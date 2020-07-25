package io.github.iltotore.customentity;

import io.github.iltotore.customentity.type.CustomEntityRoot;
import org.bukkit.entity.Entity;

import java.util.Optional;

public interface CustomRegistry {

    /**
     * Register the given entity type's root.
     * @param type the CustomEntityRoot to register.
     */
    void register(CustomEntityRoot<? extends Entity> type);

    /**
     * Remove the desired entity type's root.
     * @param key the key used to retrieve the root to remove.
     */
    void unregister(String key);

    /**
     * Get the CustomEntityRoot using the given key.
     * @param key the key of the desired CustomEntityRoot.
     * @param <T> the Bukkit entity equivalent. Used to spawn the mob trough the API.
     * @return an Optional wrapping the possible CustomEntityRoot.
     */
    <T extends Entity> Optional<CustomEntityRoot<? extends Entity>> getEntityType(String key);
}
