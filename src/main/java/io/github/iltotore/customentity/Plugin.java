package io.github.iltotore.customentity;

import io.github.iltotore.customentity.example.CustomZombieRoot;
import org.bukkit.plugin.java.JavaPlugin;

public class Plugin extends JavaPlugin {

    @Override
    public void onLoad() {
        getLogger().info("Registering entities...");
        CustomEntityAPI.getAPI().getRegistry().register(new CustomZombieRoot()); //This is the example entity: a zombie saying <version> forever when attacking.
        //Spawn it using `/summon minecraft:custom_zombie`
    }
}
