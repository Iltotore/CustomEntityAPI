package io.github.iltotore.customentity;

import io.github.iltotore.customentity.type.CustomEntityRoot;
import org.bukkit.entity.Entity;

public interface PersistentEntity {

    void setCustomType(CustomEntityRoot<? extends Entity> type);
}
