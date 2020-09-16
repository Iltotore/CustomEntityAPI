package io.github.iltotore.customentity.v1_13_R1;

import io.github.iltotore.customentity.BukkitSpawnManager;
import io.github.iltotore.customentity.type.CustomEntityRoot;
import net.minecraft.server.v1_13_R1.EntityTypes;
import net.minecraft.server.v1_13_R1.MinecraftKey;
import net.minecraft.server.v1_13_R1.World;
import org.bukkit.Location;
import org.bukkit.craftbukkit.v1_13_R1.CraftWorld;
import org.bukkit.entity.Entity;
import org.bukkit.event.entity.CreatureSpawnEvent;

import java.util.Optional;

public class NMSSpawnManager extends BukkitSpawnManager {

    @Override
    @SuppressWarnings("unchecked")
    public <T extends Entity> Optional<T> spawn(CustomEntityRoot<T> type, Location location) {
        World nmsWorld = ((CraftWorld)location.getWorld()).getHandle();
        net.minecraft.server.v1_13_R1.Entity nmsEntity = EntityTypes.a(nmsWorld, MinecraftKey.a(type.getKey()));
        if(nmsEntity == null) return Optional.empty();
        nmsEntity.setPositionRotation(location.getX(), location.getY(), location.getZ(), location.getYaw(), location.getPitch());
        nmsWorld.addEntity(nmsEntity, CreatureSpawnEvent.SpawnReason.CUSTOM);
        return (Optional<T>) Optional.of(nmsEntity.getBukkitEntity());
    }
}
