package io.github.iltotore.customentity.util;

public class UnsupportedSpigotVersionException extends RuntimeException {

    public UnsupportedSpigotVersionException(ServerVersion version){
        super(version.getNMSVersion());
    }
}
