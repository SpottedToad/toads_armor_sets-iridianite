package net.spottedtoad.toads_armor_sets.mixin;

import net.spottedtoad.toads_armor_sets.TASMod;
import net.minecraft.client.gui.screen.TitleScreen;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(TitleScreen.class)
public class ExampleMixin {
	@Inject(at = @At("HEAD"), method = "init()V")
	private void init(CallbackInfo info) {
		TASMod.LOGGER.info("This line is printed by an example mixin for the Toad's Armor Sets: Iridianite Mod.");
	}
}
