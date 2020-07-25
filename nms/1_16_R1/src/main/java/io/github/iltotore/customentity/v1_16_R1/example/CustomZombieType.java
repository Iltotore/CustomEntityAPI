package io.github.iltotore.customentity.v1_16_R1.example;

import io.github.iltotore.customentity.type.DefaultEntityType;
import io.github.iltotore.customentity.util.ServerVersion;
import org.bukkit.entity.Zombie;

public class CustomZombieType implements DefaultEntityType<Zombie> {
    @Override
    public int getBaseID(ServerVersion version) {
        return 101;
    }

    @Override
    public Class<?> getNMSClass(ServerVersion version) {
        return CustomZombie.class;
    }

}
