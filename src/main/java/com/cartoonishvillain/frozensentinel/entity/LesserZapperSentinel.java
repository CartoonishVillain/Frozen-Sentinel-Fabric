package com.cartoonishvillain.frozensentinel.entity;

import com.cartoonishvillain.coldsnaphorde.ColdSnapHorde;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.AvoidEntityGoal;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.Nullable;

public class LesserZapperSentinel extends GenericSentinel {

    LivingEntity ZapTarget;
    int timer = 60;
    float transponderprogress = 1.0F;

    public LesserZapperSentinel(EntityType<? extends TamableAnimal> p_21803_, Level p_21804_) {
        super(p_21803_, p_21804_);
    }

    @Override
    protected void registerGoals() {
        super.registerGoals();
        this.goalSelector.addGoal(1, new AvoidEntityGoal<>(this, PathfinderMob.class, 6.0F, 0.75D, 1.5D, this::avoid));
        this.goalSelector.addGoal(1, new AvoidEntityGoal<>(this, Player.class, 6.0F, 1.0D, 1.8D, this::avoid));
        this.goalSelector.addGoal(5, new CustomMeleeAttackGoal(this, 1D, false));

    }

    private boolean avoid(@Nullable LivingEntity entity) {
        return entity != null && entity == this.ZapTarget;
    }

    public boolean doHurtTarget(Entity entityIn) {
        int chance = this.random.nextInt(100);
        if (chance >= ColdSnapHorde.config.coldSnapSettings.STICKTRANSPONDER && entityIn instanceof LivingEntity && this.transponderprogress == 1.0F) {
            this.ZapTarget = (LivingEntity) entityIn;
            this.transponderprogress = 0.0F;
        }
        return super.doHurtTarget(entityIn);
    }

    public static AttributeSupplier.Builder customAttributes() {
        return Mob.createMobAttributes()
                .add(Attributes.MAX_HEALTH, 30)
                .add(Attributes.MOVEMENT_SPEED, 0.3)
                .add(Attributes.ATTACK_DAMAGE, 1D);
    }

    public void aiStep() {
        super.aiStep();
        if (this.ZapTarget != null && !this.level.isClientSide()) {
            --this.timer;
            if (this.timer == 0) {
                EntityType.LIGHTNING_BOLT.spawn((ServerLevel)this.ZapTarget.getCommandSenderWorld(), new ItemStack(Items.AIR), (Player)null, this.ZapTarget.blockPosition(), MobSpawnType.TRIGGERED, true, false);
                this.ZapTarget = null;
                this.timer = 60;
            }
        }

        if (this.transponderprogress < 1.0F) {
            this.transponderprogress = (float)((double)this.transponderprogress + 0.0025D);
            if (this.transponderprogress > 1.0F) {
                this.transponderprogress = 1.0F;
            }
        }

    }



}
