package com.github.khy010802.allofblocksareslippery.mixin;

import com.github.khy010802.allofblocksareslippery.network.ServerNetworking;
import net.minecraft.network.ClientConnection;
import net.minecraft.server.PlayerManager;
import net.minecraft.server.network.ServerPlayerEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(PlayerManager.class)
public class PlayerManagerMixin {

    @Inject(at=@At("RETURN"), method="onPlayerConnect")
    private void inject_onPlayerConnect(ClientConnection connection, ServerPlayerEntity player, CallbackInfo ci){
        ServerNetworking.sendSlipperinessToClient(player);
    }

}
