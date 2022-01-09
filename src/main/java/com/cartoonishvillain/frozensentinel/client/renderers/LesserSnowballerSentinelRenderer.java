package com.cartoonishvillain.frozensentinel.client.renderers;

import com.cartoonishvillain.coldsnaphorde.client.ColdSnapClientInitializer;
import com.cartoonishvillain.coldsnaphorde.client.models.standardmodel.ColdSnapSnowballerModel;
import com.cartoonishvillain.frozensentinel.client.layers.LesserSnowballerSentinelLayer;
import com.cartoonishvillain.frozensentinel.entity.LesserSnowballerSentinel;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

public class LesserSnowballerSentinelRenderer extends MobRenderer<LesserSnowballerSentinel, ColdSnapSnowballerModel<LesserSnowballerSentinel>> {
    private static final ResourceLocation TEXTURE = new ResourceLocation("coldsnaphorde", "textures/entity/coldsnapsnowballer.png");


    public LesserSnowballerSentinelRenderer(EntityRendererProvider.Context p_174304_) {
        super(p_174304_, new ColdSnapSnowballerModel<LesserSnowballerSentinel>(p_174304_.bakeLayer(ColdSnapClientInitializer.COLDSNAPSNOWBALLER)), 0.5F);
        this.addLayer(new LesserSnowballerSentinelLayer(this));
    }



    @Override
    public ResourceLocation getTextureLocation(LesserSnowballerSentinel p_114482_) {
        return TEXTURE;
    }
}
