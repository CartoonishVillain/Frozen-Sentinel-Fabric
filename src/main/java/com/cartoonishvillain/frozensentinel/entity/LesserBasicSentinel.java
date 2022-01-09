package com.cartoonishvillain.frozensentinel.entity;

import com.cartoonishvillain.frozensentinel.Register;
import net.minecraft.network.chat.TextComponent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.util.Mth;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.TamableAnimal;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.RangedAttackGoal;
import net.minecraft.world.entity.monster.RangedAttackMob;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.Snowball;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;


public class LesserBasicSentinel extends GenericSentinel implements RangedAttackMob {

    public LesserBasicSentinel(EntityType<? extends TamableAnimal> p_21803_, Level p_21804_) {
        super(p_21803_, p_21804_);
    }

    @Override
    protected void registerGoals() {
        super.registerGoals();
        this.goalSelector.addGoal(5, new RangedAttackGoal(this, 1.25D, 20, 10.0F));


    }

    public static AttributeSupplier.Builder customAttributes() {
        return Mob.createMobAttributes()
                .add(Attributes.MAX_HEALTH, 30)
                .add(Attributes.MOVEMENT_SPEED, 0.3)
                .add(Attributes.ATTACK_DAMAGE, 2D);
    }


    @Override
    public void performRangedAttack(LivingEntity target, float distanceFactor) {
        Snowball snowballentity = new Snowball(this.level, this);
        double d0 = target.getEyeY() - (double)1.1F;
        double d1 = target.getX() - this.getX();
        double d2 = d0 - snowballentity.getY();
        double d3 = target.getZ() - this.getZ();
        float f = Mth.sqrt((float) (d1 * d1 + d3 * d3)) * 0.2F;
        snowballentity.setOwner(this);
        snowballentity.shoot(d1, d2 + (double)f, d3, 1.6F, 8.0F);
        this.playSound(SoundEvents.SNOW_GOLEM_SHOOT, 1.0F, 0.4F / (this.getRandom().nextFloat() * 0.4F + 0.8F));
        this.level.addFreshEntity(snowballentity);
    }

    @Override
    public InteractionResult mobInteract(Player p_27584_, InteractionHand p_27585_) {
        boolean shrinkStack = false;
        Item item = p_27584_.getItemInHand(p_27585_).getItem();
        ItemStack stack = p_27584_.getItemInHand(p_27585_);
        TextComponent nameComponent = (TextComponent) this.getCustomName();
        String name;
        if(nameComponent != null) {name = nameComponent.getText();}
        else {name = "";}
        if(this.getOwner() instanceof Player && !level.isClientSide)
        if(item.equals(Register.GUNNERSIGIL)){
            this.transferData(new LesserGunnerSentinel(Register.LESSERGUNNERSENTINEL, this.level), name, this.getHealth(), getRealPos(this), (Player) this.getOwner());
            shrinkStack = true;
        } else if(item.equals(Register.STABBERSIGIL)){
            this.transferData(new LesserStabberSentinel(Register.LESSERSTABBERSENTINEL, this.level), name, this.getHealth(), getRealPos(this), (Player) this.getOwner());
            shrinkStack = true;
        } else if(item.equals(Register.SNOWBALLERSIGIL)){
            this.transferData(new LesserSnowballerSentinel(Register.LESSERSNOWBALLERSENTINEL, this.level), name, this.getHealth(), getRealPos(this), (Player) this.getOwner());
            shrinkStack = true;
        } else if(item.equals(Register.GIFTERSIGIL)){
            this.transferData(new LesserGifterSentinel(Register.LESSERGIFTERSENTINEL, this.level), name, this.getHealth(), getRealPos(this), (Player) this.getOwner());
            shrinkStack = true;
        } else if(item.equals(Register.ZAPPERSIGIL)){
            this.transferData(new LesserZapperSentinel(Register.LESSERZAPPERSENTINEL, this.level), name, this.getHealth(), getRealPos(this), (Player) this.getOwner());
            shrinkStack = true;
        } else if(item.equals(Register.BRAWLERSIGIL)){
            this.transferData(new LesserBrawlerSentinel(Register.LESSERBRAWLERSENTINEL, this.level), name, this.getHealth(), getRealPos(this), (Player) this.getOwner());
            shrinkStack = true;
        }
        if (shrinkStack) {
            stack.shrink(1);
            return InteractionResult.CONSUME;
        }
        return super.mobInteract(p_27584_, p_27585_);
    }
}
