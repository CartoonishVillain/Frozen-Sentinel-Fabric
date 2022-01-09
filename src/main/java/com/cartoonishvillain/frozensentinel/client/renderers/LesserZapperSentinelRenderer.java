package com.cartoonishvillain.frozensentinel.client.renderers;

import com.cartoonishvillain.coldsnaphorde.client.ColdSnapClientInitializer;
import com.cartoonishvillain.coldsnaphorde.client.models.standardmodel.ColdSnapZapperModel;
import com.cartoonishvillain.frozensentinel.client.layers.LesserZapperSentinelLayer;
import com.cartoonishvillain.frozensentinel.entity.LesserZapperSentinel;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

public class LesserZapperSentinelRenderer extends MobRenderer<LesserZapperSentinel, ColdSnapZapperModel<LesserZapperSentinel>> {
    private static final ResourceLocation TEXTURE = new ResourceLocation("coldsnaphorde", "textures/entity/coldsnapzapper.png");


    public LesserZapperSentinelRenderer(EntityRendererProvider.Context p_174304_) {
        super(p_174304_, new ColdSnapZapperModel<LesserZapperSentinel>(p_174304_.bakeLayer(ColdSnapClientInitializer.COLDSNAPZAPPER)), 0.5F);
        this.addLayer(new LesserZapperSentinelLayer(this));
    }



    @Override
    public ResourceLocation getTextureLocation(LesserZapperSentinel p_114482_) {
        return TEXTURE;
    }
}
