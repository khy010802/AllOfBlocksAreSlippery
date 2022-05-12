package com.github.khy010802.allofblocksareslippery;

import com.github.khy010802.allofblocksareslippery.commands.SlipCommand;
import com.github.khy010802.allofblocksareslippery.network.ClientNetworking;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.client.networking.v1.ClientPlayNetworking;
import net.fabricmc.fabric.api.command.v1.CommandRegistrationCallback;
import net.minecraft.util.Identifier;

public class AllOfBlocksAreSlippery implements ModInitializer {

    public static Identifier SLIPPERY_ID = new Identifier("slippery");
    public static Float SLIPPERY = null;

    @Override
    public void onInitialize() {
        CommandRegistrationCallback.EVENT.register((dispatcher, dedicated) -> {
            SlipCommand.register(dispatcher);
        });

        ClientPlayNetworking.registerGlobalReceiver(SLIPPERY_ID, (client, handler, buf, responseSender) -> {
            float slip = buf.readFloat();
            client.execute(() -> {
                ClientNetworking.receiveSlipperiness(slip);
            });
        });
    }
}
