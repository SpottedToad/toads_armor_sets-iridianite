package net.spottedtoad.toads_armor_sets.mixin;

import net.minecraft.entity.data.DataTracker;
import net.minecraft.entity.data.TrackedData;
import net.minecraft.entity.data.TrackedDataHandlerRegistry;
import net.minecraft.entity.passive.AxolotlEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NbtCompound;
import net.spottedtoad.toads_armor_sets.entity.custom.SpaceAxolotlTracker;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(AxolotlEntity.class)
public class AxolotlEntityMixin implements SpaceAxolotlTracker {

    @Unique
    private static final TrackedData<Integer> SPACE_VARIANT = DataTracker.registerData(AxolotlEntity.class, TrackedDataHandlerRegistry.INTEGER);

    @Inject(method = "initDataTracker", at = @At("TAIL"))
    protected void initSpaceDataTracker(CallbackInfo ci) {
        ((AxolotlEntity)(Object)this).getDataTracker().startTracking(SPACE_VARIANT, 0);
    }

    @Inject(method = "mobTick", at = @At("TAIL"))
    private void inheritSpaceVariantViaTicking(CallbackInfo ci) {
        AxolotlEntity self = (AxolotlEntity)(Object)this;
        if (!self.isBaby() && this.getSpaceVariant() == 1 && !self.getWorld().isClient()) {
            if (self.getBreedingAge() == 6000) {
                boolean bothParentsAreCosmic = false;
                for (AxolotlEntity otherAdult : self.getWorld().getEntitiesByClass(AxolotlEntity.class, self.getBoundingBox().expand(4.0), adult -> !adult.isBaby() && adult != self)) {
                    if (otherAdult.getBreedingAge() == 6000 && otherAdult instanceof SpaceAxolotlTracker partnerTracker && partnerTracker.getSpaceVariant() == 1) {
                        bothParentsAreCosmic = true;
                        break;
                    }
                }
                for (AxolotlEntity baby : self.getWorld().getEntitiesByClass(AxolotlEntity.class, self.getBoundingBox().expand(3.0), AxolotlEntity::isBaby)) {
                    if (baby instanceof SpaceAxolotlTracker babyTracker && babyTracker.getSpaceVariant() == 0) {
                        if (bothParentsAreCosmic || self.getWorld().getRandom().nextBoolean()) {
                            babyTracker.setSpaceVariant(1);
                            baby.setVariant(AxolotlEntity.Variant.LUCY);
                        }
                    }
                }
            }
        }
    }

    @Inject(method = "writeCustomDataToNbt", at = @At("TAIL"))
    public void writeSpaceDataToNbt(NbtCompound nbt, CallbackInfo ci) {
        nbt.putInt("SpaceVariant", this.getSpaceVariant());
    }

    @Inject(method = "readCustomDataFromNbt", at = @At("TAIL"))
    public void readSpaceDataFromNbt(NbtCompound nbt, CallbackInfo ci) {
        if (nbt.contains("SpaceVariant", 3)) {
            this.setSpaceVariant(nbt.getInt("SpaceVariant"));
        }
    }

    @Inject(method = "copyDataToStack", at = @At("TAIL"))
    private void saveSpaceVariantToBucket(ItemStack stack, CallbackInfo ci) {
        if (this.getSpaceVariant() > 0) {
            NbtCompound nbt = stack.getOrCreateNbt();
            nbt.putInt("SpaceVariant", this.getSpaceVariant());
        }
    }

    @Inject(method = "copyDataFromNbt", at = @At("TAIL"))
    private void loadSpaceVariantFromBucket(NbtCompound nbt, CallbackInfo ci) {
        if (nbt.contains("SpaceVariant", 3)) {
            this.setSpaceVariant(nbt.getInt("SpaceVariant"));
        }
    }

    @Override
    public int getSpaceVariant() {
        return ((AxolotlEntity)(Object)this).getDataTracker().get(SPACE_VARIANT);
    }

    @Override
    public void setSpaceVariant(int variant) {
        ((AxolotlEntity)(Object)this).getDataTracker().set(SPACE_VARIANT, variant);
    }
}