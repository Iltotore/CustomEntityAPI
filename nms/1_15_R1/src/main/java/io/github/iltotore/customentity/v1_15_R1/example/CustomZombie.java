package io.github.iltotore.customentity.v1_15_R1.example;

import net.minecraft.server.v1_15_R1.*;
import org.bukkit.Bukkit;

public class CustomZombie extends EntityZombie {

    private EntityTypes<? extends EntityZombie> type;

    public CustomZombie(EntityTypes<? extends EntityZombie> entityTypes, World world) {
        super(EntityTypes.ZOMBIE, world);
        this.type = entityTypes;
    }

    @Override
    public boolean B(Entity entity) {
        Bukkit.broadcastMessage("1.15 FOREVER");
        return super.B(entity);
    }


    @Override
    public EntityTypes<?> getEntityType() {
        return type;
    }
}
