package io.github.iltotore.customentity;

import io.github.iltotore.customentity.type.CustomEntityRoot;
import org.bukkit.Location;
import org.bukkit.entity.Entity;
import org.bukkit.event.entity.CreatureSpawnEvent;

import java.util.Collection;
import java.util.Optional;
import java.util.function.Function;

public interface SpawnManager {

    <T extends Entity> Optional<T> spawn(CustomEntityRoot<T> type, Location location);

    void bindSpawnEvent(Function<CreatureSpawnEvent, Optional<CustomEntityRoot<? extends Entity>>> binding);

    Collection<Function<CreatureSpawnEvent, Optional<CustomEntityRoot<? extends Entity>>>> getBindings();

    default Optional<CustomEntityRoot<? extends Entity>> retrieve(CreatureSpawnEvent event) {
        return getBindings().stream()
                .map(function -> function.apply(event))
                .filter(Optional::isPresent)
                .findAny().orElseGet(Optional::empty);
    }

    default void onSpawn(CreatureSpawnEvent event){
        retrieve(event).ifPresent(type -> {
            event.setCancelled(true);
            spawn(type, event.getLocation());
        });
    }
}
