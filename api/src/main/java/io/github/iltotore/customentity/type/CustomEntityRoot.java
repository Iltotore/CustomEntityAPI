package io.github.iltotore.customentity.type;

import io.github.iltotore.customentity.CreatureType;
import org.bukkit.entity.Entity;

/**
 * Represent the root of a CustomEntityType.
 * @param <T> the Bukkit entity equivalent. Used to spawn the mob trough the API.
 */
public interface CustomEntityRoot<T extends Entity> extends CustomEntityType<T> {

    /**
     * Get the key of the vanilla mob.
     * @return the vanilla base's key.
     */
    String getBaseKey();

    /**
     * Get the new entity type's key.
     * @return the custom type's key, usable in /summon.
     */
    String getKey();

    /**
     * Get the entity's CreatureType.
     * @return the entity's CreatureType. Used to register spawns.
     */
    CreatureType getCreatureType();

    Object getHandle();
    void setHandle(Object handle);
}
