package io.github.iltotore.customentity.type;

import org.bukkit.entity.Entity;

public abstract class CompositeEntityRoot<T extends Entity> extends CompositeEntityType<T> implements CustomEntityRoot<T> {

    private Object handle;

    @Override
    public Object getHandle() {
        return handle;
    }

    @Override
    public void setHandle(Object handle) {
        this.handle = handle;
    }
}
