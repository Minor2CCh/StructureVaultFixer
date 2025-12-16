package com.minor2cch.structurevaultfixer.mixin;

import net.minecraft.world.level.block.entity.vault.VaultServerData;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Invoker;

@Mixin(VaultServerData.class)
public interface VaultServerDataInvoker {
    @Invoker("stateUpdatingResumesAt")
    long getStateUpdatingResumesAt();
    @Invoker("pauseStateUpdatingUntil")
    void setStateUpdatingResumesAt(long l);

}
