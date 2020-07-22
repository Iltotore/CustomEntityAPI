package io.github.iltotore.customentity.type;

import io.github.iltotore.customentity.BiomeSpawn;
import io.github.iltotore.customentity.util.ServerVersion;
import org.bukkit.entity.Entity;

import java.util.Collection;
import java.util.Collections;

public interface NullableEntityType<T extends Entity> extends CustomEntityType<T>{

    @Override
    default int getBaseID(ServerVersion version){
        return 0;
    }

    @Override
    default Collection<BiomeSpawn> getSpawns(ServerVersion version) {
        return Collections.emptySet();
    }

    @Override
    default boolean isVanilla(ServerVersion version) {
        return false;
    }
}
