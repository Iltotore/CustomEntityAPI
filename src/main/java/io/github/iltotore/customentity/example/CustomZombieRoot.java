package io.github.iltotore.customentity.example;

import io.github.iltotore.customentity.BiomeSpawn;
import io.github.iltotore.customentity.CreatureType;
import io.github.iltotore.customentity.type.CompositeEntityRoot;
import io.github.iltotore.customentity.util.ServerVersion;
import org.bukkit.block.Biome;
import org.bukkit.entity.Zombie;

import java.util.Collection;
import java.util.Collections;

public class CustomZombieRoot extends CompositeEntityRoot<Zombie> {

    {
        setVersion(ServerVersion.v1_13, io.github.iltotore.customentity.v1_13_R1.example.CustomZombieType::new);
        setVersion(ServerVersion.v1_13_2, io.github.iltotore.customentity.v1_13_R2.example.CustomZombieType::new);
        setVersion(ServerVersion.v1_14, io.github.iltotore.customentity.v1_14_R1.example.CustomZombieType::new);
        setVersion(ServerVersion.v1_15, io.github.iltotore.customentity.v1_15_R1.example.CustomZombieType::new);
        setVersion(ServerVersion.v1_16_1, io.github.iltotore.customentity.v1_16_R1.example.CustomZombieType::new);
    }

    @Override
    public String getBaseKey() {
        return "zombie";
    }

    @Override
    public String getKey() {
        return "custom_zombie";
    }

    @Override
    public CreatureType getCreatureType() {
        return CreatureType.MONSTER;
    }

    @Override
    public boolean isVanilla(ServerVersion version) {
        return false;
    }

    @Override
    public Collection<BiomeSpawn> getSpawns(ServerVersion version) {
        return Collections.singleton(
                BiomeSpawn.builder()
                        .in(Biome.THE_END, Biome.END_HIGHLANDS)
                        .weighing(100)
                        .withMaximum(4)
                        .build()
        );
    }
}
