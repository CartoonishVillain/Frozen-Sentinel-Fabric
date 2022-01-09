package com.cartoonishvillain.frozensentinel.entity;

import net.minecraft.world.entity.PathfinderMob;
import net.minecraft.world.entity.ai.goal.MeleeAttackGoal;

class CustomMeleeAttackGoal extends MeleeAttackGoal {
    public CustomMeleeAttackGoal(PathfinderMob creature, double speedIn, boolean useLongMemory) {
        super(creature, speedIn, useLongMemory);
    }

    public boolean canContinueToUse() {
        return (!(this.mob instanceof GenericSentinel) || this.mob.getTarget() != ((GenericSentinel) this.mob).getZapTarget()) && super.canContinueToUse();
    }
}