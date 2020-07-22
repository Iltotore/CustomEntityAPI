package io.github.iltotore.customentity.v1_14_R1.example;

import net.minecraft.server.v1_14_R1.*;
import org.bukkit.Bukkit;

public class CustomZombie extends EntityZombie{

    public CustomZombie(EntityTypes<? extends EntityZombie> entityTypes, World world) {
        super(entityTypes, world);
    }


    @Override
    public boolean C(Entity entity) {
        Bukkit.broadcastMessage("1.14.4 FOREVER");
        return super.C(entity);
    }

}
