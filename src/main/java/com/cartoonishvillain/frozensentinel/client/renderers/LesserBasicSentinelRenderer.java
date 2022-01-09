package com.cartoonishvillain.frozensentinel.client.renderers;

import com.cartoonishvillain.frozensentinel.client.layers.LesserBasicSentinelLayer;
import com.cartoonishvillain.frozensentinel.entity.LesserBasicSentinel;
import net.minecraft.client.model.SnowGolemModel;
import net.minecraft.client.model.geom.ModelLayers;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

public class LesserBasicSentinelRenderer extends MobRenderer<LesserBasicSentinel, SnowGolemModel<LesserBasicSentinel>> {
    private static final ResourceLocation TEXTURE = new ResourceLocation("textures/entity/snow_golem.png");

    public LesserBasicSentinelRenderer(EntityRendererProvider.Context p_174304_) {
        super(p_174304_, new SnowGolemModel<>(p_174304_.bakeLayer(ModelLayers.SNOW_GOLEM)), 0.5F);
        this.addLayer(new LesserBasicSentinelLayer(this));
    }



    @Override
    public ResourceLocation getTextureLocation(LesserBasicSentinel p_114482_) {
        return TEXTURE;
    }
}
