package io.github.iltotore.customentity.util;

import io.github.iltotore.customentity.type.CustomEntityRoot;
import org.bukkit.entity.Entity;
import org.bukkit.event.entity.CreatureSpawnEvent;

import java.util.Optional;
import java.util.function.Function;

public class SimpleBinding {

    public static <T extends Entity> Function<CreatureSpawnEvent, Optional<CustomEntityRoot<T>>> apply(Class<T> clazz, CustomEntityRoot<T> root) {
        return event -> Optional.of(root)
                .filter(r -> clazz.isInstance(event.getEntity()));
    }
}
