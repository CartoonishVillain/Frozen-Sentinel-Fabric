package com.cartoonishvillain.frozensentinel;

import com.cartoonishvillain.frozensentinel.entity.*;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricEntityTypeBuilder;
import net.minecraft.ChatFormatting;
import net.minecraft.core.Registry;
import net.minecraft.network.chat.TranslatableComponent;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EntityDimensions;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;

import static com.cartoonishvillain.frozensentinel.FrozenSentinel.MOD_ID;

public class Register {

    public static final Item LESSERANIMATIONCORE = new LoreItem(new Item.Properties().tab(CreativeModeTab.TAB_MISC), new TranslatableComponent("item.frozensentinel.lesseranimationcoredesc").withStyle(ChatFormatting.BLUE));
    public static final Item BLANKSIGIL = new LoreItem(new Item.Properties().tab(CreativeModeTab.TAB_MISC), new TranslatableComponent("item.frozensentinel.blanksigildesc").withStyle(ChatFormatting.BLUE));
    public static final Item GUNNERSIGIL = new LoreItem(new Item.Properties().tab(CreativeModeTab.TAB_MISC), new TranslatableComponent("item.frozensentinel.gunnersigildesc").withStyle(ChatFormatting.BLUE));
    public static final Item STABBERSIGIL = new LoreItem(new Item.Properties().tab(CreativeModeTab.TAB_MISC), new TranslatableComponent("item.frozensentinel.stabbersigildesc").withStyle(ChatFormatting.BLUE));
    public static final Item SNOWBALLERSIGIL = new LoreItem(new Item.Properties().tab(CreativeModeTab.TAB_MISC), new TranslatableComponent("item.frozensentinel.snowballersigildesc").withStyle(ChatFormatting.BLUE));
    public static final Item GIFTERSIGIL = new LoreItem(new Item.Properties().tab(CreativeModeTab.TAB_MISC), new TranslatableComponent("item.frozensentinel.giftersigildesc").withStyle(ChatFormatting.BLUE));
    public static final Item ZAPPERSIGIL = new LoreItem(new Item.Properties().tab(CreativeModeTab.TAB_MISC), new TranslatableComponent("item.frozensentinel.zappersigildesc").withStyle(ChatFormatting.BLUE));
    public static final Item BRAWLERSIGIL = new LoreItem(new Item.Properties().tab(CreativeModeTab.TAB_MISC), new TranslatableComponent("item.frozensentinel.brawlersigildesc").withStyle(ChatFormatting.BLUE));

    public static final EntityType<LesserBasicSentinel> LESSERBASESENTINEL = Registry.register(Registry.ENTITY_TYPE, new ResourceLocation(MOD_ID, "lesserbasicsentinel"), FabricEntityTypeBuilder.create(MobCategory.MONSTER, LesserBasicSentinel::new).dimensions(EntityDimensions.fixed(0.6f, 1.95f)).build());
    public static final EntityType<LesserStabberSentinel> LESSERSTABBERSENTINEL = Registry.register(Registry.ENTITY_TYPE, new ResourceLocation(MOD_ID, "lesserstabbersentinel"), FabricEntityTypeBuilder.create(MobCategory.MONSTER, LesserStabberSentinel::new).dimensions(EntityDimensions.fixed(0.6f, 1.95f)).build());
    public static final EntityType<LesserGunnerSentinel> LESSERGUNNERSENTINEL = Registry.register(Registry.ENTITY_TYPE, new ResourceLocation(MOD_ID, "lessergunnersentinel"), FabricEntityTypeBuilder.create(MobCategory.MONSTER, LesserGunnerSentinel::new).dimensions(EntityDimensions.fixed(0.6f, 1.95f)).build());
    public static final EntityType<LesserSnowballerSentinel> LESSERSNOWBALLERSENTINEL = Registry.register(Registry.ENTITY_TYPE, new ResourceLocation(MOD_ID, "lessersnowballersentinel"), FabricEntityTypeBuilder.create(MobCategory.MONSTER, LesserSnowballerSentinel::new).dimensions(EntityDimensions.fixed(0.6f, 1.95f)).build());
    public static final EntityType<LesserGifterSentinel> LESSERGIFTERSENTINEL = Registry.register(Registry.ENTITY_TYPE, new ResourceLocation(MOD_ID, "lessergiftersentinel"), FabricEntityTypeBuilder.create(MobCategory.MONSTER, LesserGifterSentinel::new).dimensions(EntityDimensions.fixed(0.6f, 1.95f)).build());
    public static final EntityType<LesserZapperSentinel> LESSERZAPPERSENTINEL = Registry.register(Registry.ENTITY_TYPE, new ResourceLocation(MOD_ID,"lesserzappersentinel"), FabricEntityTypeBuilder.create(MobCategory.MONSTER, LesserZapperSentinel::new).dimensions(EntityDimensions.fixed(0.6f, 1.95f)).build());
    public static final EntityType<LesserBrawlerSentinel> LESSERBRAWLERSENTINEL = Registry.register(Registry.ENTITY_TYPE, new ResourceLocation(MOD_ID, "lesserbrawlersentinel"), FabricEntityTypeBuilder.create(MobCategory.MONSTER, LesserBrawlerSentinel::new).dimensions(EntityDimensions.fixed(0.6f, 1.95f)).build());



    public static void init() {
        Registry.register(Registry.ITEM, new ResourceLocation(MOD_ID, "lesseranimationcore"), LESSERANIMATIONCORE);
        Registry.register(Registry.ITEM, new ResourceLocation(MOD_ID, "blanksigil"), BLANKSIGIL);
        Registry.register(Registry.ITEM, new ResourceLocation(MOD_ID, "gunnersigil"), GUNNERSIGIL);
        Registry.register(Registry.ITEM, new ResourceLocation(MOD_ID, "stabbersigil"), STABBERSIGIL);
        Registry.register(Registry.ITEM, new ResourceLocation(MOD_ID,"snowballersigil"), SNOWBALLERSIGIL);
        Registry.register(Registry.ITEM, new ResourceLocation(MOD_ID, "giftersigil"), GIFTERSIGIL);
        Registry.register(Registry.ITEM, new ResourceLocation(MOD_ID, "zappersigil"), ZAPPERSIGIL);
        Registry.register(Registry.ITEM, new ResourceLocation(MOD_ID, "brawlersigil"), BRAWLERSIGIL);

        FabricDefaultAttributeRegistry.register(LESSERBASESENTINEL, LesserBasicSentinel.customAttributes());
        FabricDefaultAttributeRegistry.register(LESSERGUNNERSENTINEL, LesserGunnerSentinel.customAttributes());
        FabricDefaultAttributeRegistry.register(LESSERSTABBERSENTINEL, LesserStabberSentinel.customAttributes());
        FabricDefaultAttributeRegistry.register(LESSERSNOWBALLERSENTINEL, LesserSnowballerSentinel.customAttributes());
        FabricDefaultAttributeRegistry.register(LESSERGIFTERSENTINEL, LesserGifterSentinel.customAttributes());
        FabricDefaultAttributeRegistry.register(LESSERZAPPERSENTINEL, LesserZapperSentinel.customAttributes());
        FabricDefaultAttributeRegistry.register(LESSERBRAWLERSENTINEL, LesserBrawlerSentinel.customAttributes());
    }
}
