package com.creeping_creeper.no_lapis_lazuli.mixins;

import net.minecraft.world.inventory.EnchantmentMenu;
import net.minecraft.world.item.ItemStack;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.Redirect;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin({EnchantmentMenu.class})
public class EnchantmentMenuMixin {
    @Redirect(method = "clickMenuButton", at = @At(value = "INVOKE", target = "Lnet/minecraft/world/item/ItemStack;isEmpty()Z", ordinal = 0))
    private boolean isEmpty(ItemStack instance) {
        return false;
    }

    @Redirect(method = "clickMenuButton", at = @At(value = "INVOKE", target = "Lnet/minecraft/world/item/ItemStack;getCount()I", ordinal = 0))
    private int getCount(ItemStack instance) {
        return 3;
    }

    @Inject(method = "getGoldCount", at = @At(value = "HEAD"), cancellable = true)
    private void getGoldCount(CallbackInfoReturnable<Integer> cir){
        cir.setReturnValue(3);
    }
}
