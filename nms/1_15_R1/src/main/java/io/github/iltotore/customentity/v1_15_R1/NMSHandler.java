package io.github.iltotore.customentity.v1_15_R1;

import io.github.iltotore.customentity.CustomRegistry;

public class NMSHandler implements io.github.iltotore.customentity.NMSHandler {

    private CustomRegistry registry = new NMSEntityRegistry();

    @Override
    public CustomRegistry getRegistry() {
        return registry;
    }
}
