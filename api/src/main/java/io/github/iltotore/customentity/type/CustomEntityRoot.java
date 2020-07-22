package io.github.iltotore.customentity.type;

import io.github.iltotore.customentity.CreatureType;
import org.bukkit.entity.Entity;

public interface CustomEntityRoot<T extends Entity> extends CustomEntityType<T> {

    String getBaseKey();
    String getKey();
    CreatureType getCreatureType();

    Object getHandle();
    void setHandle(Object handle);
}
