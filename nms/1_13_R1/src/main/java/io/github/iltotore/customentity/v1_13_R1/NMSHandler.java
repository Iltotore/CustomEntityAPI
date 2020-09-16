package io.github.iltotore.customentity.v1_13_R1;

import io.github.iltotore.customentity.CustomRegistry;
import io.github.iltotore.customentity.SpawnManager;

public class NMSHandler implements io.github.iltotore.customentity.NMSHandler {

    private CustomRegistry registry = new NMSEntityRegistry();

    @Override
    public CustomRegistry getRegistry() {
        return registry;
    }

    @Override
    public SpawnManager getSpawnManager() {
        return null;
    }
}
