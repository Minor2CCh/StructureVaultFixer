package com.minor2cch.structurevaultfixer.fabric.platform;

import com.google.auto.service.AutoService;
import com.minor2cch.structurevaultfixer.platform.Platform;
import net.fabricmc.loader.api.FabricLoader;

import java.nio.file.Path;

@AutoService(Platform.class)
public class FabricPlatform implements Platform {
    @Override
    public ModLoader getModLoader() {
        return ModLoader.FABRIC;
    }
    @Override
    public Path getConfigPath() {
        return FabricLoader.getInstance().getConfigDir();
    }
}
