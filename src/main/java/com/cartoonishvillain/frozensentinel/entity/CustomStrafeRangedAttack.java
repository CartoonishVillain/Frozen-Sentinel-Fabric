package com.cartoonishvillain.frozensentinel.entity;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.ai.goal.Goal;
import net.minecraft.world.entity.monster.RangedAttackMob;

import java.util.EnumSet;

public class CustomStrafeRangedAttack<T extends Mob & RangedAttackMob> extends  Goal {

    private final T mob;
    private final double speedModifier;
    private int minimumAttackDelay;
    private final float squaredAttackRadius;
    private int timeUntilAttack = -1;
    private int targetVisibleTime;
    private boolean strafeClockwise;
    private int timeToStrafe = -1;

    public CustomStrafeRangedAttack(T entity, double speedModifier, int minimumAttackDelay, float squaredAttackRadius) {
        mob = entity;
        this.speedModifier = speedModifier;
        this.minimumAttackDelay = minimumAttackDelay;
        this.squaredAttackRadius = squaredAttackRadius;
        this.setFlags(EnumSet.of(Goal.Flag.MOVE, Goal.Flag.LOOK));
    }

    @Override
    public boolean canUse() {
        return this.mob.getTarget() != null;
    }

    @Override
    public boolean canContinueToUse() {
        return (this.canUse()) && !this.mob.getTarget().isDeadOrDying();
    }

    @Override
    public void start() {
        super.start();
        this.mob.setAggressive(true);
    }

    @Override
    public void stop() {
        super.stop();
        this.mob.setAggressive(false);
        targetVisibleTime = 0;
        timeUntilAttack = -1;
        this.mob.getNavigation().stop();
    }

    @Override
    public boolean requiresUpdateEveryTick() {
        return true;
    }

    @Override
    public void tick() {
        LivingEntity target = this.mob.getTarget();
        if(target != null){
            double distance = this.mob.distanceToSqr(target);
            boolean canSeeTarget = this.mob.getSensing().hasLineOfSight(target);
            boolean targetNotJustSpotted = targetVisibleTime > 0;
            if(canSeeTarget != targetNotJustSpotted) {this.targetVisibleTime = 0;}

            if (canSeeTarget) targetVisibleTime++;
            else targetVisibleTime--;

            if(!(distance > squaredAttackRadius) && this.targetVisibleTime >= 20){
                this.mob.getNavigation().stop();
                this.timeToStrafe++;
            } else {
                //advance towards position if the target is hidden for too long but is still in range.
                this.mob.getNavigation().moveTo(target, this.speedModifier);
                this.timeToStrafe = -1;
            }

            if(this.timeToStrafe >= 40) {
                if(this.mob.getRandom().nextDouble() < 0.5){
                    this.strafeClockwise = !this.strafeClockwise;
                }

                timeToStrafe = 0;
            }

            if(timeToStrafe > -1) {
                if(distance < (this.squaredAttackRadius*0.3f)){
                    this.mob.getMoveControl().strafe(-0.5f, this.strafeClockwise ? 0.5f : -0.5f);
                    //TODO Set to 0.
                    this.mob.lookAt(target, 30.0F, 30.0F);
                } else {
                    this.mob.getMoveControl().strafe(0.5f, this.strafeClockwise ? 0.5f : -0.5f);
                    this.mob.lookAt(target, 30.0F, 30.0F);
                }
            }

            if(timeUntilAttack == 0) {
                (this.mob).performRangedAttack(target, 1);
                this.timeUntilAttack = this.minimumAttackDelay;
            } else if(timeUntilAttack > 0 && canSeeTarget && targetVisibleTime >= 20){
                timeUntilAttack--;
            } else if (timeUntilAttack < 0 && canSeeTarget && targetVisibleTime >= 20){
                timeUntilAttack = this.minimumAttackDelay;
            } else if (!canSeeTarget && targetVisibleTime <= -80){
                timeUntilAttack = -1;
            }


        }
    }
}
