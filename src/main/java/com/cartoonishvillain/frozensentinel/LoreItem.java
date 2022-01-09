package com.cartoonishvillain.frozensentinel;

import net.minecraft.network.chat.Component;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.List;

public class LoreItem extends Item {
    ArrayList<Component> lore;
    public LoreItem(Properties p_41383_, Component... lore) {
        super(p_41383_);
        this.lore = new ArrayList<>(List.of(lore));
    }

    @Override
    public void appendHoverText(ItemStack p_41421_, @Nullable Level p_41422_, List<Component> p_41423_, TooltipFlag p_41424_) {
        super.appendHoverText(p_41421_, p_41422_, p_41423_, p_41424_);
        p_41423_.addAll(lore);
    }
}
