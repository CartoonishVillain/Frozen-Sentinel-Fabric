package com.cartoonishvillain.frozensentinel.mixin;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.goal.target.OwnerHurtByTargetGoal;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;

@Mixin(OwnerHurtByTargetGoal.class)
public interface OwnerHurtByTargetGoalAccessor {

    @Accessor("ownerLastHurtBy")
    LivingEntity frozenSentinelGetOwnerLastHurtBy();

    @Accessor("ownerLastHurtBy")
    public void frozenSentinelSetOwnerLastHurtBy(LivingEntity entity);

}
