package com.minor2cch.structurevaultfixer;

import com.minor2cch.structurevaultfixer.config.ConfigLoader;

public final class StructureVaultFixer {
    public static final String MOD_ID = "structure_vault_fixer";

    public static void init() {
        ConfigLoader.load();
    }
}
