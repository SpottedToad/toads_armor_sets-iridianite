package net.spottedtoad.toads_armor_sets.block;

import net.minecraft.block.*;
import net.minecraft.block.piston.PistonBehavior;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.passive.AxolotlEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.LightType;
import net.minecraft.world.World;
import net.spottedtoad.toads_armor_sets.entity.custom.SpaceAxolotlTracker;

public class FrozenCreatureAxolotl
extends TransparentBlock {
    public FrozenCreatureAxolotl(AbstractBlock.Settings settings) {
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
        world.setBlockState(pos, Blocks.WATER.getDefaultState());
        world.updateNeighbor(pos, Blocks.WATER, pos);
    }

    private void spawnCreature(ServerWorld world, BlockPos pos) {
        AxolotlEntity axolotl = EntityType.AXOLOTL.create(world);
        if (axolotl != null) {
            axolotl.setBaby(true);
            ((SpaceAxolotlTracker) axolotl).setSpaceVariant(1);
            axolotl.setVariant(AxolotlEntity.Variant.LUCY);
        }
        axolotl.refreshPositionAndAngles((double)pos.getX() + 0.5, pos.getY(), (double)pos.getZ() + 0.5, 0.0f, 0.0f);
        world.spawnEntity(axolotl);
        axolotl.playSpawnEffects();
    }

    @Override
    public PistonBehavior getPistonBehavior(BlockState state) {
        return PistonBehavior.NORMAL;
    }
}
