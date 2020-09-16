package io.github.iltotore.customentity.v1_16_R1;


import io.github.iltotore.customentity.BukkitSpawnManager;
import io.github.iltotore.customentity.type.CustomEntityRoot;
import net.minecraft.server.v1_16_R1.EntityTypes;
import net.minecraft.server.v1_16_R1.World;
import org.bukkit.Location;
import org.bukkit.craftbukkit.v1_16_R1.CraftWorld;
import org.bukkit.entity.Entity;
import org.bukkit.event.entity.CreatureSpawnEvent;

import java.util.Optional;

public class NMSSpawnManager extends BukkitSpawnManager {

    @Override
    @SuppressWarnings("unchecked")
    public <T extends Entity> Optional<T> spawn(CustomEntityRoot<T> type, Location location) {
        World nmsWorld = ((CraftWorld) location.getWorld()).getHandle();
        Optional<net.minecraft.server.v1_16_R1.Entity> nmsEntity = EntityTypes.a(type.getKey())
                .map(nmsType -> nmsType.a(nmsWorld));
                nmsEntity.ifPresent(entity -> {
                    entity.setPositionRotation(location.getX(), location.getY(), location.getZ(), location.getYaw(), location.getPitch());
                    nmsWorld.addEntity(entity, CreatureSpawnEvent.SpawnReason.CUSTOM);
                });
        return (Optional<T>) nmsEntity.map(net.minecraft.server.v1_16_R1.Entity::getBukkitEntity);
    }
}
