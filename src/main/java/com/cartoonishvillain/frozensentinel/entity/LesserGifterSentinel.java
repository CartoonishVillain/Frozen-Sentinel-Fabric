package com.cartoonishvillain.frozensentinel.entity;

import com.cartoonishvillain.coldsnaphorde.entities.mobs.behaviors.GifterSurprise;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.TamableAnimal;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.MeleeAttackGoal;
import net.minecraft.world.level.Level;

public class LesserGifterSentinel extends GenericSentinel {

    public LesserGifterSentinel(EntityType<? extends TamableAnimal> p_21803_, Level p_21804_) {
        super(p_21803_, p_21804_);
    }

    int timer = 50;
    boolean exploding = false;

    @Override
    protected void registerGoals() {
        super.registerGoals();
        this.goalSelector.addGoal(5, new MeleeAttackGoal(this, 1D, true));
    }

    public int getTimer() {
        return this.timer;
    }

    public static AttributeSupplier.Builder customAttributes() {
        return Mob.createMobAttributes()
                .add(Attributes.MAX_HEALTH, 30)
                .add(Attributes.MOVEMENT_SPEED, 0.3)
                .add(Attributes.ATTACK_DAMAGE, 2D);
    }

    public void aiStep() {
        super.aiStep();
        LivingEntity livingEntity = this.getTarget();
        if (livingEntity != null) {
            double distance = this.distanceToSqr(livingEntity);
            if (distance < 4.5D && !this.level.isClientSide()) {
                if (!this.exploding) {
                    this.playSound(SoundEvents.TNT_PRIMED, 1.0F, 1.0F);
                }

                this.exploding = true;
                this.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 50, 10, false, false));
            }

            if (this.exploding && distance < 36.0D) {
                --this.timer;
                if (!this.level.isClientSide() && this.timer == 0) {
                    this.hurt(DamageSource.explosion(this), 5);
                    GifterSurprise gifterSurprise = new GifterSurprise(this.level, this, this.getX(), this.getY(), this.getZ(), 5.0F);
                    gifterSurprise.StageDetonation();
                    gifterSurprise.DetonateBlockDamage();
                    gifterSurprise.DetonateLivingHarm();
                    this.playSound(SoundEvents.GENERIC_EXPLODE, 1.0F, 1.5F);
                    this.exploding = false;
                    this.timer = 50;
                }
            } else if (this.exploding && distance > 36.0D) {
                this.exploding = false;
                this.timer = 50;
            }
        }

    }



}
