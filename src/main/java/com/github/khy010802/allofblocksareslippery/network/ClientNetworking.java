package com.github.khy010802.allofblocksareslippery.network;

import com.github.khy010802.allofblocksareslippery.AllOfBlocksAreSlippery;

public class ClientNetworking {

    public static void receiveSlipperiness(float slipperiness){
        AllOfBlocksAreSlippery.SLIPPERY = slipperiness;
    }
}
