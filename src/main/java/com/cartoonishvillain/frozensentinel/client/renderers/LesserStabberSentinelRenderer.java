package com.cartoonishvillain.frozensentinel.client.renderers;

import com.cartoonishvillain.coldsnaphorde.client.ColdSnapClientInitializer;
import com.cartoonishvillain.coldsnaphorde.client.models.standardmodel.ColdSnapStabberModel;
import com.cartoonishvillain.frozensentinel.client.layers.LesserStabberSentinelLayer;
import com.cartoonishvillain.frozensentinel.entity.LesserStabberSentinel;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

public class LesserStabberSentinelRenderer extends MobRenderer<LesserStabberSentinel, ColdSnapStabberModel<LesserStabberSentinel>> {
    private static final ResourceLocation TEXTURE = new ResourceLocation("coldsnaphorde", "textures/entity/coldsnapstabber.png");


    public LesserStabberSentinelRenderer(EntityRendererProvider.Context p_174304_) {
        super(p_174304_, new ColdSnapStabberModel<LesserStabberSentinel>(p_174304_.bakeLayer(ColdSnapClientInitializer.COLDSNAPSTABBER)), 0.5F);
        this.addLayer(new LesserStabberSentinelLayer(this));
    }



    @Override
    public ResourceLocation getTextureLocation(LesserStabberSentinel p_114482_) {
        return TEXTURE;
    }
}
