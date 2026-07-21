package net.spottedtoad.toads_armor_sets;

import net.fabricmc.api.ModInitializer;
import net.spottedtoad.toads_armor_sets.block.ModBlocks;
import net.spottedtoad.toads_armor_sets.item.ModItems;
import net.spottedtoad.toads_armor_sets.registry.NewFrogVariant;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TASMod implements ModInitializer {
	public static final String MOD_ID = "toads_armor_sets";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {

		ModItems.registerModItems();
		ModBlocks.registerModBlocks();

		NewFrogVariant.init();

	}
}
