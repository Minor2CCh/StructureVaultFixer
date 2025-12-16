package com.minor2cch.structurevaultfixer.config;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.minor2cch.structurevaultfixer.StructureVaultFixer;
import com.minor2cch.structurevaultfixer.platform.Platform;

import java.io.File;
import java.io.IOException;
import java.io.Reader;
import java.io.Writer;
import java.nio.file.Files;
import java.nio.file.Path;

public class ConfigLoader {
    private static final File DIR = Platform.INSTANCE.getConfigPath().toFile();
    private static final Gson GSON = new GsonBuilder().setPrettyPrinting().create();
    private static final String FILENAME = StructureVaultFixer.MOD_ID +".json";
    private static final Path CONFIG_PATH = Path.of(new File(DIR,FILENAME).getPath());
    private static ModConfig modConfig;
    public static void load(){
        if (Files.exists(CONFIG_PATH)) {
            try (Reader reader = Files.newBufferedReader(CONFIG_PATH)) {
                modConfig = GSON.fromJson(reader, ModConfig.class);
            } catch (Exception e) {
                System.err.println("Failed to load config: " + e.getMessage());
                modConfig = new ModConfig();
            }

            try{
                modConfig.fillDefaults();
            } catch (Exception e) {
                System.err.println("Failed to load config: " + e.getMessage());
                modConfig = new ModConfig();
            }

        } else {
            modConfig = new ModConfig();
        }
        save();

    }
    private static void save() {
        try {
            Files.createDirectories(CONFIG_PATH.getParent());
            try (Writer writer = Files.newBufferedWriter(CONFIG_PATH)) {
                GSON.toJson(modConfig, writer);
            }
        } catch (IOException e) {
            System.err.println("Failed to save config: " + e.getMessage());
        }
    }
    public static ModConfig getConfig() {
        return modConfig;
    }

    public static class ModConfig {
        private Long canOverrideIntervalTime;
        public void fillDefaults() {
            if(canOverrideIntervalTime == null){
                canOverrideIntervalTime = 200L;
            }else if(canOverrideIntervalTime < 20L){
                canOverrideIntervalTime = 20L;
            }
        }
        public long getCanOverrideIntervalTime(){
            return this.canOverrideIntervalTime;
        }
        private ModConfig(){
            this.canOverrideIntervalTime = 200L;
        }
    }
}
