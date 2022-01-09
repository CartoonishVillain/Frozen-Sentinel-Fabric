package com.cartoonishvillain.frozensentinel.entity;

import net.minecraft.ChatFormatting;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.network.chat.TextComponent;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.AgeableMob;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.TamableAnimal;
import net.minecraft.world.entity.ai.goal.*;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.Vec3;


public class GenericSentinel extends TamableAnimal {

    protected GenericSentinel(EntityType<? extends TamableAnimal> p_21803_, Level p_21804_) {
        super(p_21803_, p_21804_);
    }

    @Override
    protected void registerGoals() {
        super.registerGoals();
        this.goalSelector.addGoal(1, new FloatGoal(this));
        this.goalSelector.addGoal(2, new SitWhenOrderedToGoal(this));
        this.goalSelector.addGoal(4, new FollowOwnerGoal(this, 1.0D, 11.0F, 9.5F, false));
        this.goalSelector.addGoal(8, new WaterAvoidingRandomStrollGoal(this, 1.0D));
        this.goalSelector.addGoal(10, new LookAtPlayerGoal(this, Player.class, 8.0F));
        this.goalSelector.addGoal(10, new RandomLookAroundGoal(this));
        this.targetSelector.addGoal(1, new CustomOwnerHurtByTargetGoal(this));
        this.targetSelector.addGoal(2, new CustomOwnerHurtTargetGoal(this));
        this.targetSelector.addGoal(3, new CustomHurtByTargetGoal(this));
        this.targetSelector.addGoal(4, new NearestAttackableTargetGoal<>(this, Monster.class, false));
    }

    public boolean isAttackingFriend(LivingEntity target) {
        if (target == null) return false;
        return (this.getOwner() != null && target instanceof TamableAnimal && this.getOwner().equals(((TamableAnimal) target).getOwner())) || target.equals(getOwner());
    }

    @Override
    public InteractionResult mobInteract(Player p_27584_, InteractionHand p_27585_) {
        if(!isTame() && p_27585_.equals(InteractionHand.MAIN_HAND) && !p_27584_.level.isClientSide) {
            tame(p_27584_);
            p_27584_.sendMessage(new TextComponent("Summoned snowman tamed."), p_27584_.getUUID());
        }

        if(p_27585_.equals(InteractionHand.MAIN_HAND) && !p_27584_.level.isClientSide){
            ItemStack itemStack = p_27584_.getItemInHand(p_27585_);
            float heal = 0;
            boolean validHeal = false;
            if(itemStack.getItem().equals(Items.SNOW_BLOCK)){heal = 1f; validHeal = true;}
            else if(itemStack.getItem().equals(Items.ICE)){heal = 5f; validHeal = true;}
            else if(itemStack.getItem().equals(Items.PACKED_ICE)){heal = 10f; validHeal = true;}
            else if(itemStack.getItem().equals(Items.BLUE_ICE)){heal = this.getMaxHealth(); validHeal = true;}
            else {
                if(p_27584_.equals(this.getOwner())) {
                    this.setOrderedToSit(!isOrderedToSit());
                    if (isOrderedToSit()) {
                        p_27584_.displayClientMessage(new TextComponent("Holding position...").withStyle(ChatFormatting.AQUA), true);
                    } else {
                        p_27584_.displayClientMessage(new TextComponent("Following").withStyle(ChatFormatting.AQUA), true);
                    }
                }
            }

            if (validHeal) {itemStack.shrink(1);}
            this.heal(heal);
        }

        return super.mobInteract(p_27584_, p_27585_);
    }

    public LivingEntity getZapTarget(){
        return null;
    }


    @Override
    public AgeableMob getBreedOffspring(ServerLevel p_146743_, AgeableMob p_146744_) {
        return null;
    }

    public void transferData(GenericSentinel newSentinel, String name, float health, Vec3 position, Player player){
        if(!this.level.isClientSide) {
            if(!name.equals("")) {
                newSentinel.setCustomName(new TextComponent(name));
            }
            newSentinel.setHealth(health);
            newSentinel.setPos(position.x(), position.y(), position.z());
            newSentinel.tame(player);
            this.remove(RemovalReason.DISCARDED);
            this.level.addFreshEntity(newSentinel);
            BlockPos pos = newSentinel.getOnPos();
            ServerLevel level = (ServerLevel) this.level;
            for (int iterator = 0; iterator < 6; iterator++) {
                if (iterator % 2 == 0) {
                    level.sendParticles(ParticleTypes.ENCHANT, pos.getX() + level.getRandom().nextDouble(), pos.getY() + level.getRandom().nextDouble() + 2, pos.getZ() + level.getRandom().nextDouble(), 10, 0.5, 0.5, 0.5, 0);
                } else {
                    level.sendParticles(ParticleTypes.HAPPY_VILLAGER, pos.getX() + level.getRandom().nextDouble(), pos.getY() + level.getRandom().nextDouble(), pos.getZ() + level.getRandom().nextDouble(), 10, 0.5, 0.5, 0.5, 0);
                }
            }
            level.playSound(null, newSentinel, SoundEvents.ENCHANTMENT_TABLE_USE, SoundSource.NEUTRAL, 1.5f, 0.75f);
        }
    }

    public Vec3 getRealPos(GenericSentinel sentinel) {
        return new Vec3(sentinel.getX(), sentinel.getY(), sentinel.getZ());
    }


    @Override
    protected SoundEvent getHurtSound(DamageSource p_21239_) {
        return SoundEvents.SNOW_GOLEM_HURT;
    }

    @Override
    protected SoundEvent getDeathSound() {
        return SoundEvents.SNOW_GOLEM_DEATH;
    }
}
