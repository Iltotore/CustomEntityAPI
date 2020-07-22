package io.github.iltotore.customentity;

import io.github.iltotore.customentity.type.CustomEntityRoot;
import org.bukkit.entity.Entity;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

public abstract class HashCustomRegistry implements CustomRegistry {

    private Set<CustomEntityRoot<? extends Entity>> registry = new HashSet<>();

    @Override
    public void register(CustomEntityRoot<? extends Entity> type) {
        applyRegister(type);
        registry.add(type);
    }

    @Override
    public void unregister(String key) {
        registry.removeIf(type -> type.getKey().equals(key));
    }

    @Override
    public <T extends Entity> Optional<CustomEntityRoot<? extends Entity>> getEntityType(String key) {
        return registry.stream().filter(type -> type.getKey().equals(key)).findAny();
    }

    protected abstract void applyRegister(CustomEntityRoot<? extends Entity> type);
}