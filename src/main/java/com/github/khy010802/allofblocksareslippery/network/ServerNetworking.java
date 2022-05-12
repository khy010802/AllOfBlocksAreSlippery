package com.github.khy010802.allofblocksareslippery.network;

import com.github.khy010802.allofblocksareslippery.AllOfBlocksAreSlippery;
import net.fabricmc.fabric.api.networking.v1.PacketByteBufs;
import net.fabricmc.fabric.api.networking.v1.ServerPlayNetworking;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.server.network.ServerPlayerEntity;

public class ServerNetworking {

    public static void sendSlipperinessToClient(ServerPlayerEntity player){
        if(AllOfBlocksAreSlippery.SLIPPERY != null){
            PacketByteBuf packet = PacketByteBufs.create();
            packet.writeFloat(AllOfBlocksAreSlippery.SLIPPERY);
            ServerPlayNetworking.send(player, AllOfBlocksAreSlippery.SLIPPERY_ID, packet);
        }
    }

}
