package com.minor2cch.structurevaultfixer.platform;

import java.nio.file.Path;
import java.util.Iterator;
import java.util.ServiceLoader;

@SuppressWarnings("unused")
public interface Platform {
    Platform INSTANCE = create();
    private static Platform create() {
        ServiceLoader<Platform> loader = ServiceLoader.load(Platform.class);
        Iterator<Platform> iterator = loader.iterator();

        if (!iterator.hasNext()) {
            throw new RuntimeException("Platform instance not found!");
        }

        Platform platform = iterator.next();

        if (iterator.hasNext()) {
            throw new RuntimeException("More than one platform instance was found!");
        }
        return platform;
    }
    enum ModLoader{
        NEOFORGE,
        FABRIC
    }
    ModLoader getModLoader();
    Path getConfigPath();
}
