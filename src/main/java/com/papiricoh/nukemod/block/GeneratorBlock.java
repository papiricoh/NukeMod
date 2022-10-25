package com.papiricoh.nukemod.block;

import com.papiricoh.nukemod.energysystem.NukeEnergy;
import net.minecraft.core.BlockPos;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;

public class GeneratorBlock extends Block {
    private NukeEnergy energy;
    public GeneratorBlock(Block.Properties properties) {
        super(properties);
        energy = new NukeEnergy(NukeEnergy.LOW_QUALITY_TRANSFER_QUANTITY, NukeEnergy.LOW_QUALITY_CAPACITY);
    }



    @Override
    public InteractionResult use(BlockState state, Level world, BlockPos pos, Player player, InteractionHand hand, BlockHitResult hit) {
        ItemStack held = player.getItemInHand(hand);

        if (!world.isClientSide() && held.getItem() == Items.GUNPOWDER){
            return InteractionResult.CONSUME;
        }

        return super.use(state, world, pos, player, hand, hit);
    }
}
