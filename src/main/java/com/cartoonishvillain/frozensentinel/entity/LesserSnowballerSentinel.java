package com.cartoonishvillain.frozensentinel.entity;

import com.cartoonishvillain.coldsnaphorde.Register;
import com.cartoonishvillain.coldsnaphorde.entities.projectiles.RockSnowballEntity;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.RangedAttackGoal;
import net.minecraft.world.entity.monster.RangedAttackMob;
import net.minecraft.world.entity.projectile.ThrowableItemProjectile;
import net.minecraft.world.level.Level;

public class LesserSnowballerSentinel extends GenericSentinel implements RangedAttackMob {

    public LesserSnowballerSentinel(EntityType<? extends TamableAnimal> p_21803_, Level p_21804_) {
        super(p_21803_, p_21804_);
    }

    @Override
    protected void registerGoals() {
        super.registerGoals();
        this.goalSelector.addGoal(5, new RangedAttackGoal(this, 1.0D, 16, 20.0F));


    }

    public static AttributeSupplier.Builder customAttributes() {
        return Mob.createMobAttributes()
                .add(Attributes.MAX_HEALTH, 30)
                .add(Attributes.MOVEMENT_SPEED, 0.3)
                .add(Attributes.ATTACK_DAMAGE, 2D);
    }


    @Override
    public void performRangedAttack(LivingEntity target, float distanceFactor) {
        ThrowableItemProjectile snowballentity = new RockSnowballEntity(Register.ROCKSNOWBALLPROJECTILE, this.level, this);
        double d0 = target.getEyeY() - 1.100000023841858D;
        double d1 = target.getX() - this.getX();
        double d2 = d0 - (snowballentity).getY();
        double d3 = target.getZ() - this.getZ();
        float f = Mth.sqrt((float)(d1 * d1 + d3 * d3)) * 0.2F;
        (snowballentity).setOwner(this);
        (snowballentity).shoot(d1, d2 + (double)f, d3, 1.6F, 8.0F);
        this.playSound(SoundEvents.SNOW_GOLEM_SHOOT, 1.0F, 0.4F / (this.getRandom().nextFloat() * 0.4F + 0.8F));
        this.level.addFreshEntity((Entity)snowballentity);
    }
}
