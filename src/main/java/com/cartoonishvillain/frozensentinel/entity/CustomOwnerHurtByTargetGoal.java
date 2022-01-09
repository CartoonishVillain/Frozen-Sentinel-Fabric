package com.cartoonishvillain.frozensentinel.entity;

import com.cartoonishvillain.frozensentinel.mixin.OwnerHurtByTargetGoalAccessor;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.TamableAnimal;
import net.minecraft.world.entity.ai.goal.target.OwnerHurtByTargetGoal;

public class CustomOwnerHurtByTargetGoal extends OwnerHurtByTargetGoal {
    public CustomOwnerHurtByTargetGoal(TamableAnimal p_26107_) {
        super(p_26107_);
    }



    @Override
    public boolean canUse() {
        if(this.mob instanceof GenericSentinel && ((GenericSentinel) this.mob).getOwner() != null) {
            LivingEntity livingentity = ((GenericSentinel) this.mob).getOwner();
            ((OwnerHurtByTargetGoalAccessor) this).frozenSentinelSetOwnerLastHurtBy(livingentity.getLastHurtByMob());
            LivingEntity whoLastHitOwner = ((OwnerHurtByTargetGoalAccessor) this).frozenSentinelGetOwnerLastHurtBy();
            boolean shouldAttack = (!((GenericSentinel) this.mob).isAttackingFriend(whoLastHitOwner)) && whoLastHitOwner != null;
            return shouldAttack;
        }
        return super.canUse();
    }
}
