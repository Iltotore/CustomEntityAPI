package io.github.iltotore.customentity.type;

import io.github.iltotore.customentity.BiomeSpawn;
import io.github.iltotore.customentity.util.ServerVersion;
import io.github.iltotore.customentity.util.SuppliedValue;
import io.github.iltotore.customentity.util.UnsupportedSpigotVersionException;
import org.bukkit.entity.Entity;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.function.Supplier;

/**
 * A CompositeEntityType is a proxy for a CustomEntityType child by its version.
 * @param <T> the Bukkit entity equivalent. Used to spawn the mob trough the API.
 */
public abstract class CompositeEntityType<T extends Entity> implements CustomEntityType<T> {

    private Map<ServerVersion, SuppliedValue<CustomEntityType<T>>> children = new HashMap<>();

    /**
     * Associate a child with the given version.
     * @param version the version used to retrieve the associated CustomEntityType.
     * @param type the custom child to associate with the given version.
     */
    protected void setVersion(ServerVersion version, Supplier<CustomEntityType<T>> type){
        children.put(version, SuppliedValue.of(type));
    }

    /**
     * Get the type child using the given version.
     * @param version the ServerVersion used to find the child CustomEntityType.
     * @return an Optional wrapping the possible returned CustomEntityType.
     */
    public Optional<CustomEntityType<T>> getType(ServerVersion version){
        return children.getOrDefault(version, SuppliedValue.empty()).get();
    }

    /**
     * Get the type child using the given version if exists. Throws an UnsupportedSpigotVersionException otherwise.
     * @param version the ServerVersion used to find the child CustomEntityType.
     * @return an Optional wrapping the possible returned CustomEntityType.
     */
    public CustomEntityType<T> getRawType(ServerVersion version){
        return getType(version).orElseThrow(() -> new UnsupportedSpigotVersionException(version));
    }

    @Override
    public int getBaseID(ServerVersion version) {
        return getRawType(version).getBaseID(version);
    }

    @Override
    public Class<?> getNMSClass(ServerVersion version) {
        return getRawType(version).getNMSClass(version);
    }

    @Override
    public Collection<BiomeSpawn> getSpawns(ServerVersion version) {
        return getRawType(version).getSpawns(version);
    }

    @Override
    public boolean isVanilla(ServerVersion version) {
        return getRawType(version).isVanilla(version);
    }
}
