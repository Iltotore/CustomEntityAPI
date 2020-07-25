package io.github.iltotore.customentity.type;

import io.github.iltotore.customentity.BiomeSpawn;
import io.github.iltotore.customentity.util.ServerVersion;
import org.bukkit.entity.Entity;

import java.util.Collection;

/**
 * A CustomEntityType represents information about mob id, appearance, and spawning.
 * @param <T> the Bukkit entity equivalent. Used to spawn the mob trough the API.
 */
public interface CustomEntityType<T extends Entity> {

    /**
     * Get the overrode mob's numerical id.
     * @param version the version of the server.
     * @return the overrode mob's id depending of the current version.
     */
    int getBaseID(ServerVersion version);

    /**
     * Get the custom entity class.
     * @param version the version of the server.
     * @return the custom entity NMS class depending of the current version.
     */
    Class<?> getNMSClass(ServerVersion version);

    /**
     * Get the spawn information.
     * @param version the version of the server.
     * @return a Collection of spawn information depending of the current version.
     */
    Collection<BiomeSpawn> getSpawns(ServerVersion version);

    /**
     * Check if the custom entity should replace its vanilla base.
     * @param version the version of the server.
     * @return true if this custom entity should override vanilla spawns.
     */
    boolean isVanilla(ServerVersion version);
}
