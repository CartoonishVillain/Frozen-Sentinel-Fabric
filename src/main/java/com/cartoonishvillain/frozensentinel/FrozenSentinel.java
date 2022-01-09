package com.cartoonishvillain.frozensentinel;

import com.cartoonishvillain.frozensentinel.entity.LesserBasicSentinel;
import net.fabricmc.api.ModInitializer;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.player.Player;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class FrozenSentinel implements ModInitializer {
	// This logger is used to write text to the console and the log file.
	// It is considered best practice to use your mod id as the logger's name.
	// That way, it's clear which mod wrote info, warnings, and errors.
	public static final String MOD_ID = "frozensentinel";
	public static final Logger LOGGER = LogManager.getLogger(MOD_ID);


	@Override
	public void onInitialize() {
		// This code runs as soon as Minecraft is in a mod-load-ready state.
		// However, some things (like resources) may still be uninitialized.
		// Proceed with mild caution.

		Register.init();
	}

	//Not client side, and a snow golem is being interacted with, and this is the main hand, and the item is a lesser animation core...
	public static void InteractWithSnowGolem(Mob target, Player player, InteractionHand interactionHand){
		if(!player.level.isClientSide && target.getType().equals(EntityType.SNOW_GOLEM) && interactionHand == InteractionHand.MAIN_HAND && player.getItemInHand(interactionHand).getItem().equals(Register.LESSERANIMATIONCORE)){
			LesserBasicSentinel lesserBasicSentinel = new LesserBasicSentinel(Register.LESSERBASESENTINEL, player.level);
			lesserBasicSentinel.setPos(target.getX(), target.getY(), target.getZ());
			lesserBasicSentinel.tame(player);
			target.remove(Entity.RemovalReason.DISCARDED);
			player.level.addFreshEntity(lesserBasicSentinel);
			BlockPos pos = lesserBasicSentinel.getOnPos();
			ServerLevel level = (ServerLevel) player.level;
			for (int iterator = 0; iterator < 6; iterator++){
				if(iterator % 2 == 0) {level.sendParticles(ParticleTypes.SNOWFLAKE, pos.getX() + player.level.getRandom().nextDouble(), pos.getY() + player.level.getRandom().nextDouble() + 2, pos.getZ() + player.level.getRandom().nextDouble(), 10, 0.5, 0.5, 0.5, 0);}
				else {level.sendParticles(ParticleTypes.HEART, pos.getX() + player.level.getRandom().nextDouble(), pos.getY() + player.level.getRandom().nextDouble(), pos.getZ() + player.level.getRandom().nextDouble(), 10, 0.5, 0.5, 0.5, 0);}
			}
			player.level.playSound(null, pos, SoundEvents.ZOMBIE_VILLAGER_CURE, SoundSource.NEUTRAL, 0.5f, 0.5f);
			player.getItemInHand(interactionHand).shrink(1);
		}
	}
}
