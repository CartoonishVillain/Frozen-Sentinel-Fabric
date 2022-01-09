package com.cartoonishvillain.frozensentinel.mixin;

import com.cartoonishvillain.frozensentinel.FrozenSentinel;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.animal.SnowGolem;
import net.minecraft.world.entity.player.Player;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(SnowGolem.class)
public class LivingInteractMixin {
	@Inject(at = @At("HEAD"), method = "mobInteract")
	private void frozenSentinelInteract(Player player, InteractionHand interactionHand, CallbackInfoReturnable<InteractionResult> cir) {
		SnowGolem target = ((SnowGolem) (Object) this);
		FrozenSentinel.InteractWithSnowGolem(target, player, interactionHand);
	}
}
