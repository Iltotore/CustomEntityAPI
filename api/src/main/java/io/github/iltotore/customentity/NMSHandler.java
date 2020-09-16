package io.github.iltotore.customentity;

/**
 * Represent a custom NMS version root. All nms-based components should be only accessible from the asssociated NMSHandler.
 */
public interface NMSHandler {

    /**
     * Get the CustomRegistry for the used version.
     * @return the CustomRegistry of the used NMS version.
     */
    CustomRegistry getRegistry();

    SpawnManager getSpawnManager();
}
