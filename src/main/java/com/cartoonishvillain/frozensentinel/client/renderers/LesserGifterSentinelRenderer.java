package com.cartoonishvillain.frozensentinel.client.renderers;

import com.cartoonishvillain.coldsnaphorde.client.ColdSnapClientInitializer;
import com.cartoonishvillain.coldsnaphorde.client.models.standardmodel.ColdSnapGifterModel;
import com.cartoonishvillain.frozensentinel.client.layers.LesserGifterSentinelLayer;
import com.cartoonishvillain.frozensentinel.entity.LesserGifterSentinel;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

public class LesserGifterSentinelRenderer extends MobRenderer<LesserGifterSentinel, ColdSnapGifterModel<LesserGifterSentinel>> {
    private static final ResourceLocation TEXTURE = new ResourceLocation("coldsnaphorde", "textures/entity/coldsnapgifter.png");


    public LesserGifterSentinelRenderer(EntityRendererProvider.Context p_174304_) {
        super(p_174304_, new ColdSnapGifterModel<LesserGifterSentinel>(p_174304_.bakeLayer(ColdSnapClientInitializer.COLDSNAPGIFTER)), 0.5F);
        this.addLayer(new LesserGifterSentinelLayer(this));
    }



    @Override
    public ResourceLocation getTextureLocation(LesserGifterSentinel p_114482_) {
        return TEXTURE;
    }
}
