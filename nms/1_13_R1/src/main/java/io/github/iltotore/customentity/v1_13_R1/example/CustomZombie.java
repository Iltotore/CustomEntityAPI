package io.github.iltotore.customentity.v1_13_R1.example;

import io.github.iltotore.customentity.type.CustomEntityRoot;
import io.github.iltotore.customentity.PersistentEntity;
import net.minecraft.server.v1_13_R1.Entity;
import net.minecraft.server.v1_13_R1.EntityTypes;
import net.minecraft.server.v1_13_R1.EntityZombie;
import net.minecraft.server.v1_13_R1.World;
import org.bukkit.Bukkit;

public class CustomZombie extends EntityZombie implements PersistentEntity {

    private CustomEntityRoot<? extends org.bukkit.entity.Entity> type;

    public CustomZombie(World world) {
        super(world);
    }


    @Override
    public boolean B(Entity entity) {
        Bukkit.broadcastMessage("1.13 FOREVER !");
        return super.B(entity);
    }

    @Override
    public void setCustomType(CustomEntityRoot<? extends org.bukkit.entity.Entity> type) {
        this.type = type;
    }

    @Override
    public EntityTypes<?> P() {
        return (EntityTypes<?>) type.getHandle();
    }

}
