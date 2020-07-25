package io.github.iltotore.customentity;

import org.bukkit.block.Biome;

import java.util.*;

public class BiomeSpawn {

    private final Biome[] biomes;
    private final int weight, min, max;

    /**
     * Create a BiomeSpawn using the given spawn infos.
     * @see #builder()
     * @param biomes the biomes where spawning is possible.
     * @param weight the weight used in the randomized spawn. A better weight will increase the spawn chances over other mobs.
     * @param min the minimal number of mobs created by a single spawn.
     * @param max the maximal number of mobs created by a single spawn.
     */
    public BiomeSpawn(Biome[] biomes, int weight, int min, int max) {
        this.biomes = biomes;
        this.weight = weight;
        this.min = min;
        this.max = max;
    }

    public Biome[] getBiomes() {
        return biomes;
    }

    public int getWeight() {
        return weight;
    }

    public int getMin() {
        return min;
    }

    public int getMax() {
        return max;
    }

    @Override
    public boolean equals(Object o) {
        if(this == o) return true;
        if(!(o instanceof BiomeSpawn)) return false;
        BiomeSpawn that = (BiomeSpawn) o;
        return weight == that.weight &&
                min == that.min &&
                max == that.max &&
                Arrays.equals(biomes, that.biomes);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(weight, min, max);
        result = 31 * result + Arrays.hashCode(biomes);
        return result;
    }

    public static Builder builder(){
        return new Builder();
    }

    public static class Builder {

        private Set<Biome> biomes = new HashSet<>();
        private int weight, min = 1, max = 1;

        public Builder in(Collection<Biome> biomes) {
            this.biomes.addAll(biomes);
            return this;
        }

        public Builder in(Biome... biomes) {
            return in(Arrays.asList(biomes));
        }

        public Builder weighing(int weight) {
            this.weight = weight;
            return this;
        }

        public Builder withMinimum(int min) {
            this.min = min;
            return this;
        }

        public Builder withMaximum(int max){
            this.max = max;
            return this;
        }

        public BiomeSpawn build(){
            return new BiomeSpawn(biomes.toArray(new Biome[]{}), weight, min, max);
        }
    }
}
