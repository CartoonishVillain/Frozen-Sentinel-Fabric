package com.cartoonishvillain.frozensentinel.client.renderers;

import com.cartoonishvillain.coldsnaphorde.client.ColdSnapClientInitializer;
import com.cartoonishvillain.coldsnaphorde.client.models.standardmodel.ColdSnapBrawlerModel;
import com.cartoonishvillain.frozensentinel.client.RenderManager;
import com.cartoonishvillain.frozensentinel.client.layers.LesserBrawlerSentinelLayer;
import com.cartoonishvillain.frozensentinel.entity.LesserBrawlerSentinel;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

public class LesserBrawlerSentinelRenderer extends MobRenderer<LesserBrawlerSentinel, ColdSnapBrawlerModel<LesserBrawlerSentinel>> {
    private static final ResourceLocation TEXTURE = new ResourceLocation("coldsnaphorde", "textures/entity/coldsnapbrawler.png");


    public LesserBrawlerSentinelRenderer(EntityRendererProvider.Context p_174304_) {
        super(p_174304_, new ColdSnapBrawlerModel<LesserBrawlerSentinel>(p_174304_.bakeLayer(ColdSnapClientInitializer.COLDSNAPBRAWLER)), 0.5F);
        this.addLayer(new LesserBrawlerSentinelLayer(this));
    }



    @Override
    public ResourceLocation getTextureLocation(LesserBrawlerSentinel p_114482_) {
        return TEXTURE;
    }
}
