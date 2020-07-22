package io.github.iltotore.customentity;

import io.github.iltotore.customentity.type.CustomEntityRoot;
import org.bukkit.entity.Entity;

import java.util.Optional;

public interface CustomRegistry {

    void register(CustomEntityRoot<? extends Entity> type);
    void unregister(String key);

    <T extends Entity> Optional<CustomEntityRoot<? extends Entity>> getEntityType(String key);
}
