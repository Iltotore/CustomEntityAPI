package io.github.iltotore.customentity.v1_14_R1.example;

import io.github.iltotore.customentity.type.NullableEntityType;
import io.github.iltotore.customentity.util.ServerVersion;
import org.bukkit.entity.Zombie;

public class CustomZombieType implements NullableEntityType<Zombie> {
    @Override
    public int getBaseID(ServerVersion version) {
        return 94;
    }

    @Override
    public Class<?> getNMSClass(ServerVersion version) {
        return CustomZombie.class;
    }
}
