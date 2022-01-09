package com.cartoonishvillain.frozensentinel.entity;

import net.minecraft.world.entity.PathfinderMob;
import net.minecraft.world.entity.ai.goal.target.HurtByTargetGoal;

public class CustomHurtByTargetGoal extends HurtByTargetGoal {
    public CustomHurtByTargetGoal(PathfinderMob p_26039_, Class<?>... p_26040_) {
        super(p_26039_, p_26040_);
    }

    // Should not target other mobs tamed by the owner, even if friendly fire occurs accidentally
    @Override
    public boolean canUse() {
        if(this.mob instanceof GenericSentinel) {
            boolean shouldAttack = (!((GenericSentinel) this.mob).isAttackingFriend(this.mob.getLastHurtByMob())) && this.mob.getLastHurtByMob() != null;
            return shouldAttack;
        }
        return super.canUse();
    }
}
