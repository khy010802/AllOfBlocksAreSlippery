package com.github.khy010802.allofblocksareslippery.mixin;

import com.github.khy010802.allofblocksareslippery.AllOfBlocksAreSlippery;
import net.minecraft.block.Block;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(Block.class)
public class BlockMixin {

    @Inject(method="getSlipperiness", at=@At("HEAD"), cancellable = true)
    private void inject_getSlipperiness(CallbackInfoReturnable<Float> cir){
        if(AllOfBlocksAreSlippery.SLIPPERY != null){
            cir.setReturnValue(AllOfBlocksAreSlippery.SLIPPERY);
        }
    }

}
