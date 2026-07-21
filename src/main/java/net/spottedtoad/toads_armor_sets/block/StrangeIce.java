package net.spottedtoad.toads_armor_sets.block;

import net.minecraft.block.AbstractBlock;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.TransparentBlock;
import net.minecraft.block.piston.PistonBehavior;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.LightType;
import net.minecraft.world.World;

public class StrangeIce
        extends TransparentBlock {
    public StrangeIce(AbstractBlock.Settings settings) {
        super(settings);
    }

    @Override
    public void randomTick(BlockState state, ServerWorld world, BlockPos pos, Random random) {
        if (world.getLightLevel(LightType.BLOCK, pos) > 11 - state.getOpacity(world, pos)) {
            this.diceRoll(state, world, pos, random);
        }
    }

    protected void diceRoll(BlockState state, ServerWorld world, BlockPos pos, Random diceroll){
        int roll = diceroll.nextBetween(0, 5);
        if (roll == 0){
            this.melt(state, world, pos);
            }
        else if (roll == 1){
            this.melt(state, world, pos);
            }
        else if (roll == 2){
            this.meltAxolotl(state, world, pos);
        }
        else if (roll == 3){
            this.meltAxolotl(state, world, pos);
        }
        else if (roll == 4){
            this.meltAxolotl(state, world, pos);
        }
        else if (roll == 5){
            this.meltFrog(state, world, pos);
        }
    }

    protected void melt(BlockState state, World world, BlockPos pos) {
        if (world.getDimension().ultrawarm()) {
            world.removeBlock(pos, false);
            return;
        }
        world.setBlockState(pos, Blocks.PACKED_ICE.getDefaultState());
        world.updateNeighbor(pos, Blocks.PACKED_ICE, pos);
    }

    protected void meltAxolotl(BlockState state, World world, BlockPos pos) {
        if (world.getDimension().ultrawarm()) {
            world.removeBlock(pos, false);
            return;
        }
        world.setBlockState(pos, ModBlocks.FROZEN_CREATURE_AXOLOTL.getDefaultState());
        world.updateNeighbor(pos, ModBlocks.FROZEN_CREATURE_AXOLOTL, pos);
    }

    protected void meltFrog(BlockState state, World world, BlockPos pos) {
        if (world.getDimension().ultrawarm()) {
            world.removeBlock(pos, false);
            return;
        }
        world.setBlockState(pos, ModBlocks.FROZEN_CREATURE_FROG.getDefaultState());
        world.updateNeighbor(pos, ModBlocks.FROZEN_CREATURE_FROG, pos);
    }

    @Override
    public PistonBehavior getPistonBehavior(BlockState state) {
        return PistonBehavior.NORMAL;
    }
}
