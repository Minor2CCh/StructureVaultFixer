package com.minor2cch.structurevaultfixer.neoforge;

import com.minor2cch.structurevaultfixer.StructureVaultFixer;
import net.neoforged.fml.common.Mod;

@Mod(StructureVaultFixer.MOD_ID)
public final class StructureVaultFixerNeoForge {
    public StructureVaultFixerNeoForge() {
        // Run our common setup.
        StructureVaultFixer.init();
    }
}
