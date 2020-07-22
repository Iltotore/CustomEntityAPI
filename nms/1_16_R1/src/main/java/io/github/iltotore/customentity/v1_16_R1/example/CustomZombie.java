package io.github.iltotore.customentity.v1_16_R1.example;

import net.minecraft.server.v1_16_R1.Entity;
import net.minecraft.server.v1_16_R1.EntityTypes;
import net.minecraft.server.v1_16_R1.EntityZombie;
import net.minecraft.server.v1_16_R1.World;
import org.bukkit.Bukkit;

public class CustomZombie extends EntityZombie {

    private EntityTypes<? extends EntityZombie> type;

    public CustomZombie(EntityTypes<? extends EntityZombie> entityTypes, World world) {
        super(EntityTypes.ZOMBIE, world);
        this.type = entityTypes;
    }

    @Override
    public boolean attackEntity(Entity entity) {
        Bukkit.broadcastMessage("1.16.1 FOREVER");
        return super.attackEntity(entity);
    }

    @Override
    public EntityTypes<?> getEntityType() {
        return type;
    }
}
