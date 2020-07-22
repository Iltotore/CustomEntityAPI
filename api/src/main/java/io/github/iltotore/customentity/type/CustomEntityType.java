package io.github.iltotore.customentity.type;

import io.github.iltotore.customentity.BiomeSpawn;
import io.github.iltotore.customentity.util.ServerVersion;
import org.bukkit.entity.Entity;

import java.util.Collection;

public interface CustomEntityType<T extends Entity> {

    int getBaseID(ServerVersion version);
    Class<?> getNMSClass(ServerVersion version);
    Collection<BiomeSpawn> getSpawns(ServerVersion version);
    boolean isVanilla(ServerVersion version);
}
