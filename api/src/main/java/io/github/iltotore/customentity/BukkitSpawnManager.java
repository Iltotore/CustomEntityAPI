package io.github.iltotore.customentity;

import io.github.iltotore.customentity.type.CustomEntityRoot;
import org.bukkit.entity.Entity;
import org.bukkit.event.entity.CreatureSpawnEvent;

import java.util.Collection;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;
import java.util.function.Function;

public abstract class BukkitSpawnManager implements SpawnManager {

    private Set<Function<CreatureSpawnEvent, Optional<CustomEntityRoot<? extends Entity>>>> bindings = new HashSet<>();

    @Override
    public void bindSpawnEvent(Function<CreatureSpawnEvent, Optional<CustomEntityRoot<? extends Entity>>> binding) {
        bindings.add(binding);
    }

    @Override
    public Collection<Function<CreatureSpawnEvent, Optional<CustomEntityRoot<? extends Entity>>>> getBindings() {
        return bindings;
    }
}
