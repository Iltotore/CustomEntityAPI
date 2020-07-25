package io.github.iltotore.customentity.type;

import org.bukkit.entity.Entity;

/**
 * A root equivalent of the CompositeEntityType.
 * @param <T> the Bukkit entity equivalent. Used to spawn the mob trough the API.
 */
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
