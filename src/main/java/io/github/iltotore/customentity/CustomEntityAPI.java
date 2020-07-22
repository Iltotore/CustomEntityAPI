package io.github.iltotore.customentity;

import io.github.iltotore.customentity.util.ServerVersion;
import org.bukkit.Bukkit;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;
import java.util.function.Supplier;

public class CustomEntityAPI {

    private static NMSHandler api;
    private static Map<ServerVersion, Supplier<NMSHandler>> versions = new HashMap<>();

    static {
        versions.put(ServerVersion.v1_13, io.github.iltotore.customentity.v1_13_R1.NMSHandler::new);
        versions.put(ServerVersion.v1_13_2, io.github.iltotore.customentity.v1_13_R2.NMSHandler::new);
        versions.put(ServerVersion.v1_14, io.github.iltotore.customentity.v1_14_R1.NMSHandler::new);
        versions.put(ServerVersion.v1_15, io.github.iltotore.customentity.v1_15_R1.NMSHandler::new);
        versions.put(ServerVersion.v1_16_1, io.github.iltotore.customentity.v1_16_R1.NMSHandler::new);
    }

    /**
     * Get the {@link NMSHandler} instance.
     *
     * @return the {@link NMSHandler} instance for the server's version
     */
    public static NMSHandler getAPI(){
        if(api == null){
            ServerVersion version = ServerVersion.fromServer(Bukkit.getServer());
            Bukkit.getLogger().info("[CustomEntityAPI] Loading version " + version.getNMSVersion());
            api = versions.get(version).get();
        }
        return api;
    }


}
