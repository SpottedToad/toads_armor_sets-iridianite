package net.spottedtoad.toads_armor_sets.block;

import net.minecraft.block.*;
import net.minecraft.block.piston.PistonBehavior;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.passive.FrogEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.LightType;
import net.minecraft.world.World;
import net.spottedtoad.toads_armor_sets.registry.NewFrogVariant;

public class FrozenCreatureFrog
extends TransparentBlock {
    public FrozenCreatureFrog(AbstractBlock.Settings settings) {
        super(settings);
    }

    @Override
    public void randomTick(BlockState state, ServerWorld world, BlockPos pos, Random random) {
        if (world.getLightLevel(LightType.BLOCK, pos) > 11 - state.getOpacity(world, pos)) {
            this.melt(state, world, pos);
            this.spawnCreature(world, pos);
        }
    }

    protected void melt(BlockState state, World world, BlockPos pos) {
        if (world.getDimension().ultrawarm()) {
            world.removeBlock(pos, false);
            return;
        }
        world.setBlockState(pos, Blocks.AIR.getDefaultState());
        world.updateNeighbor(pos, Blocks.AIR, pos);
    }

    private void spawnCreature(ServerWorld world, BlockPos pos) {
        FrogEntity frogEntity = EntityType.FROG.create(world);
        assert frogEntity != null; {
            frogEntity.setVariant(NewFrogVariant.SPACE);
            }
        frogEntity.refreshPositionAndAngles((double)pos.getX() + 0.5, pos.getY(), (double)pos.getZ() + 0.5, 0.0f, 0.0f);
        world.spawnEntity(frogEntity);
        frogEntity.playSpawnEffects();
    }

    @Override
    public PistonBehavior getPistonBehavior(BlockState state) {
        return PistonBehavior.NORMAL;
    }
}

