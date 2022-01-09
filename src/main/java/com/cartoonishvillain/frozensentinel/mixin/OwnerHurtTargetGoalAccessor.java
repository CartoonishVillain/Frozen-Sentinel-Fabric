package com.cartoonishvillain.frozensentinel.mixin;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.goal.target.OwnerHurtTargetGoal;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;

@Mixin(OwnerHurtTargetGoal.class)
public interface OwnerHurtTargetGoalAccessor {

    @Accessor("ownerLastHurt")
    LivingEntity frozenSentinelGetOwnerLastHurt();

    @Accessor("ownerLastHurt")
    public void frozenSentinelSetOwnerLastHurt(LivingEntity entity);

}
