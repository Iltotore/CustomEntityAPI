package io.github.iltotore.customentity.type;

import io.github.iltotore.customentity.BiomeSpawn;
import io.github.iltotore.customentity.util.ServerVersion;
import io.github.iltotore.customentity.util.SuppliedValue;
import io.github.iltotore.customentity.util.UnsupportedSpigotVersionException;
import org.bukkit.entity.Entity;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.function.Supplier;

public abstract class CompositeEntityType<T extends Entity> implements CustomEntityType<T> {

    private Map<ServerVersion, SuppliedValue<CustomEntityType<T>>> children = new HashMap<>();

    protected void setVersion(ServerVersion version, Supplier<CustomEntityType<T>> type){
        children.put(version, SuppliedValue.of(type));
    }

    public Optional<CustomEntityType<T>> getType(ServerVersion version){
        return children.getOrDefault(version, SuppliedValue.empty()).get();
    }

    public CustomEntityType<T> getRawType(ServerVersion version){
        return getType(version).orElseThrow(() -> new UnsupportedSpigotVersionException(version));
    }

    @Override
    public int getBaseID(ServerVersion version) {
        return getRawType(version).getBaseID(version);
    }

    @Override
    public Class<?> getNMSClass(ServerVersion version) {
        return getRawType(version).getNMSClass(version);
    }

    @Override
    public Collection<BiomeSpawn> getSpawns(ServerVersion version) {
        return getRawType(version).getSpawns(version);
    }

    @Override
    public boolean isVanilla(ServerVersion version) {
        return getRawType(version).isVanilla(version);
    }
}
