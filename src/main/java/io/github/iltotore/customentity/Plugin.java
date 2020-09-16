package io.github.iltotore.customentity;

import io.github.iltotore.customentity.example.CustomZombieRoot;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.CreatureSpawnEvent;
import org.bukkit.plugin.java.JavaPlugin;

public class Plugin extends JavaPlugin implements Listener {

    @Override
    public void onLoad() {
        getLogger().info("Registering entities...");
        CustomEntityAPI.getAPI().getRegistry().register(new CustomZombieRoot()); //This is the example entity: a zombie saying "<version> forever" when attacking.

    }

    @Override
    public void onEnable() {
        getServer().getPluginManager().registerEvents(this, this);
    }

    @EventHandler
    public void onSpawn(CreatureSpawnEvent event){
        CustomEntityAPI.getAPI().getSpawnManager().onSpawn(event);
    }
}
