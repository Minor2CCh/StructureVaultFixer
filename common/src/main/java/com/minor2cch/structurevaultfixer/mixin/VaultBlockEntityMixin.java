package com.minor2cch.structurevaultfixer.mixin;

import com.minor2cch.structurevaultfixer.config.ConfigLoader;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.level.block.entity.vault.VaultBlockEntity;
import net.minecraft.world.level.block.entity.vault.VaultConfig;
import net.minecraft.world.level.block.entity.vault.VaultServerData;
import net.minecraft.world.level.block.entity.vault.VaultSharedData;
import net.minecraft.world.level.block.state.BlockState;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(VaultBlockEntity.Server.class)
public class VaultBlockEntityMixin {
    @Inject(at = @At("HEAD"), method = "tick")
    private static void fixStateUpdatingResumesAt(ServerLevel serverLevel, BlockPos blockPos, BlockState blockState, VaultConfig vaultConfig, VaultServerData vaultServerData, VaultSharedData vaultSharedData, CallbackInfo ci){
        VaultServerDataInvoker invoker = (VaultServerDataInvoker)vaultServerData;
        if(invoker.getStateUpdatingResumesAt() > serverLevel.getGameTime() + ConfigLoader.getConfig().getCanOverrideIntervalTime()){
            invoker.setStateUpdatingResumesAt(serverLevel.getGameTime() + 20);
        }
    }
}
