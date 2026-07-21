package net.spottedtoad.toads_armor_sets.mixin;

import net.minecraft.client.render.entity.AxolotlEntityRenderer;
import net.minecraft.entity.passive.AxolotlEntity;
import net.minecraft.util.Identifier;
import net.spottedtoad.toads_armor_sets.entity.custom.SpaceAxolotlTracker;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(AxolotlEntityRenderer.class)
public class AxolotlEntityRendererMixin {

    @Unique
    private static final Identifier SPACE_TEXTURE = new Identifier("toads_armor_sets", "textures/entity/space_axolotl.png");

    @Unique
    private static final Identifier BABY_SPACE_TEXTURE = new Identifier("toads_armor_sets", "textures/entity/baby_space_axolotl.png");

    @Inject(method = "getTexture(Lnet/minecraft/entity/passive/AxolotlEntity;)Lnet/minecraft/util/Identifier;", at = @At("HEAD"), cancellable = true)
    public void getCustomVariantTexture(AxolotlEntity entity, CallbackInfoReturnable<Identifier> cir) {
        if (entity instanceof SpaceAxolotlTracker tracker && tracker.getSpaceVariant() == 1) {
            if (entity.isBaby()) {
                cir.setReturnValue(BABY_SPACE_TEXTURE);
            } else {
                cir.setReturnValue(SPACE_TEXTURE);
            }
        }
    }
}