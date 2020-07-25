package io.github.iltotore.customentity;

import io.github.iltotore.customentity.type.CustomEntityRoot;
import org.bukkit.entity.Entity;

/**
 * Only used to pass the CustomEntityRoot instance.
 */
public interface PersistentEntity {

    /**
     * Pass the given CustomEntityRoot. Should be used for Entity persistence before 1.14.
     * @param type the type to pass.
     */
    void setCustomType(CustomEntityRoot<? extends Entity> type);
}
