package net.spottedtoad.toads_armor_sets.block;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.Material;
import net.minecraft.block.OreBlock;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.intprovider.UniformIntProvider;
import net.minecraft.util.registry.Registry;
import net.spottedtoad.toads_armor_sets.TASMod;
import net.spottedtoad.toads_armor_sets.item.ModItemGroup;

public class ModBlocks {

    public static final Block IRIDIAN_CRYSTAL_BLOCK = registerBlock("iridian_crystal_block",
            new OreBlock(FabricBlockSettings.of(Material.AMETHYST).sounds(BlockSoundGroup.AMETHYST_CLUSTER).strength(3f).requiresTool()), ModItemGroup.ADDITIONS);
    public static final Block STROMATOLITE_GEODE = registerBlock("stromatolite_geode",
            new OreBlock(FabricBlockSettings.of(Material.AMETHYST).sounds(BlockSoundGroup.LARGE_AMETHYST_BUD).strength(4f).requiresTool(),
                    UniformIntProvider.create(2,6)), ModItemGroup.ADDITIONS);

    public static final Block STROMATOLITE = registerBlock("stromatolite",
            new Block(FabricBlockSettings.of(Material.STONE).strength(4f).requiresTool()), ModItemGroup.ADDITIONS);
    public static final Block POLISHED_STROMATOLITE = registerBlock("polished_stromatolite",
            new Block(FabricBlockSettings.of(Material.STONE).strength(4f).requiresTool()), ModItemGroup.ADDITIONS);
    public static final Block STROMATOLITE_BRICKS = registerBlock("stromatolite_bricks",
            new Block(FabricBlockSettings.of(Material.STONE).strength(4f).requiresTool()), ModItemGroup.ADDITIONS);
    public static final Block CRACKED_STROMATOLITE_BRICKS = registerBlock("cracked_stromatolite_bricks",
            new Block(FabricBlockSettings.of(Material.STONE).strength(4f).requiresTool()), ModItemGroup.ADDITIONS);
    public static final Block CHISELED_STROMATOLITE = registerBlock("chiseled_stromatolite",
            new Block(FabricBlockSettings.of(Material.STONE).strength(4f).requiresTool()), ModItemGroup.ADDITIONS);
    public static final Block GILDED_CHISELED_STROMATOLITE = registerBlock("gilded_chiseled_stromatolite",
            new Block(FabricBlockSettings.of(Material.STONE).strength(4f).requiresTool()), ModItemGroup.ADDITIONS);

    public static final Block SCORCHED_STROMATOLITE = registerBlock("scorched_stromatolite",
            new Block(FabricBlockSettings.of(Material.STONE).strength(5f).requiresTool()), ModItemGroup.ADDITIONS);
    public static final Block POLISHED_SCORCHED_STROMATOLITE = registerBlock("polished_scorched_stromatolite",
            new Block(FabricBlockSettings.of(Material.STONE).strength(5f).requiresTool()), ModItemGroup.ADDITIONS);
    public static final Block SCORCHED_STROMATOLITE_BRICKS = registerBlock("scorched_stromatolite_bricks",
            new Block(FabricBlockSettings.of(Material.STONE).strength(5f).requiresTool()), ModItemGroup.ADDITIONS);
    public static final Block CRACKED_SCORCHED_STROMATOLITE_BRICKS = registerBlock("cracked_scorched_stromatolite_bricks",
            new Block(FabricBlockSettings.of(Material.STONE).strength(5f).requiresTool()), ModItemGroup.ADDITIONS);
    public static final Block CHISELED_SCORCHED_STROMATOLITE = registerBlock("chiseled_scorched_stromatolite",
            new Block(FabricBlockSettings.of(Material.STONE).strength(5f).requiresTool()), ModItemGroup.ADDITIONS);
    public static final Block GILDED_CHISELED_SCORCHED_STROMATOLITE = registerBlock("gilded_chiseled_scorched_stromatolite",
            new Block(FabricBlockSettings.of(Material.STONE).strength(5f).requiresTool()), ModItemGroup.ADDITIONS);

    public static final Block VULCANIZED_STROMATOLITE = registerBlock("vulcanized_stromatolite",
            new Block(FabricBlockSettings.of(Material.STONE).strength(4f).requiresTool()), ModItemGroup.ADDITIONS);
    public static final Block MOLTEN_STROMATOLITE = registerBlock("molten_stromatolite",
            new Block(FabricBlockSettings.of(Material.STONE).strength(4f).requiresTool()), ModItemGroup.ADDITIONS);

    public static final Block CHILLED_STROMATOLITE = registerBlock("chilled_stromatolite",
            new Block(FabricBlockSettings.of(Material.STONE).strength(4f).requiresTool()), ModItemGroup.ADDITIONS);
    public static final Block FROZEN_STROMATOLITE = registerBlock("frozen_stromatolite",
            new Block(FabricBlockSettings.of(Material.STONE).strength(4f).requiresTool()), ModItemGroup.ADDITIONS);

    public static final Block STRANGE_ICE = registerBlock("strange_ice",
            new StrangeIce(FabricBlockSettings.of(Material.ICE).slipperiness(0.98f).strength(1f).requiresTool().ticksRandomly().nonOpaque().sounds(BlockSoundGroup.GLASS)), ModItemGroup.ADDITIONS);
    public static final Block FROZEN_CREATURE_AXOLOTL = registerBlock("frozen_creature_axolotl",
            new FrozenCreatureAxolotl(FabricBlockSettings.of(Material.ICE).slipperiness(0.98f).strength(1f).requiresTool().ticksRandomly().nonOpaque().sounds(BlockSoundGroup.GLASS)), ModItemGroup.ADDITIONS);
    public static final Block FROZEN_CREATURE_FROG = registerBlock("frozen_creature_frog",
            new FrozenCreatureFrog(FabricBlockSettings.of(Material.ICE).slipperiness(0.98f).strength(1f).requiresTool().ticksRandomly().nonOpaque().sounds(BlockSoundGroup.GLASS)), ModItemGroup.ADDITIONS);


    private static Block registerBlock(String name, Block block, ItemGroup tab){
        registerBlockItem(name, block, tab);
        return Registry.register(Registry.BLOCK, new Identifier(TASMod.MOD_ID, name), block);
        }
    private static Item registerBlockItem(String name, Block block, ItemGroup tab){
        return Registry.register(Registry.ITEM, new Identifier(TASMod.MOD_ID, name),
                new BlockItem(block, new FabricItemSettings().group(tab)));
        }
    public static void registerModBlocks() {
        TASMod.LOGGER.debug("Registering ModBlocks for" + TASMod.MOD_ID);
    }
}
