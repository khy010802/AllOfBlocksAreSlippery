package com.github.khy010802.allofblocksareslippery.commands;

import static net.minecraft.server.command.CommandManager.*;

import com.github.khy010802.allofblocksareslippery.AllOfBlocksAreSlippery;
import com.github.khy010802.allofblocksareslippery.network.ServerNetworking;
import com.mojang.brigadier.CommandDispatcher;
import com.mojang.brigadier.arguments.FloatArgumentType;
import com.mojang.brigadier.context.CommandContext;
import com.mojang.brigadier.exceptions.CommandSyntaxException;
import net.fabricmc.fabric.api.networking.v1.PlayerLookup;
import net.minecraft.server.command.ServerCommandSource;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.text.LiteralText;

public class SlipCommand {

    public static void register(CommandDispatcher<ServerCommandSource> dispatcher){
        dispatcher.register(literal("slip").requires(serverCommandSource -> serverCommandSource.hasPermissionLevel(2))
                        .then(argument("amount", FloatArgumentType.floatArg()).executes(SlipCommand::execute)));
    }

    private static int execute(CommandContext<ServerCommandSource> context) throws CommandSyntaxException {

        System.out.println(AllOfBlocksAreSlippery.SLIPPERY);

        float temp = context.getArgument("amount", Float.class);
        context.getSource().getPlayer().sendMessage(new LiteralText("미끄러움 정도가 " + temp + " 으로 설정 되었습니다!"), false);

        AllOfBlocksAreSlippery.SLIPPERY = temp;
        for(ServerPlayerEntity player : PlayerLookup.all(context.getSource().getServer())){
            ServerNetworking.sendSlipperinessToClient(player);
        }

        return 1;
    }

}
