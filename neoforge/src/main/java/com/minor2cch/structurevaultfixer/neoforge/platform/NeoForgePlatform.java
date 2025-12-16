package com.minor2cch.structurevaultfixer.neoforge.platform;

import com.google.auto.service.AutoService;
import com.minor2cch.structurevaultfixer.platform.Platform;
import net.neoforged.fml.loading.FMLPaths;

import java.nio.file.Path;

@AutoService(Platform.class)
public class NeoForgePlatform implements Platform {
    @Override
    public ModLoader getModLoader() {
        return ModLoader.NEOFORGE;
    }
    @Override
    public Path getConfigPath() {
        return FMLPaths.CONFIGDIR.get();
    }
}
