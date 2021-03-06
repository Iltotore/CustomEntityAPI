package io.github.iltotore.customentity.v1_13_R2.example;

import io.github.iltotore.customentity.type.DefaultEntityType;
import io.github.iltotore.customentity.util.ServerVersion;
import org.bukkit.entity.Zombie;

public class CustomZombieType implements DefaultEntityType<Zombie> {
    @Override
    public int getBaseID(ServerVersion version) {
        return 87;
    }

    @Override
    public Class<?> getNMSClass(ServerVersion version) {
        return CustomZombie.class;
    }
}
