package io.github.iltotore.customentity.type;

import io.github.iltotore.customentity.BiomeSpawn;
import io.github.iltotore.customentity.util.ServerVersion;
import org.bukkit.entity.Entity;

import java.util.Collection;
import java.util.Collections;

/**
 * A CustomEntityType version where methods are not mandatory.
 * @param <T> the Bukkit entity equivalent. Used to spawn the mob trough the API.
 */
public interface DefaultEntityType<T extends Entity> extends CustomEntityType<T>{

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
