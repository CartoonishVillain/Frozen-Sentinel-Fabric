package com.cartoonishvillain.frozensentinel.client.layers;

import com.cartoonishvillain.coldsnaphorde.client.models.standardmodel.ColdSnapGifterModel;
import com.cartoonishvillain.frozensentinel.FrozenSentinel;
import com.cartoonishvillain.frozensentinel.entity.LesserGifterSentinel;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.RenderLayerParent;
import net.minecraft.client.renderer.entity.layers.RenderLayer;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.resources.ResourceLocation;

public class LesserGifterSentinelLayer extends RenderLayer<LesserGifterSentinel, ColdSnapGifterModel<LesserGifterSentinel>> {
    protected final static ResourceLocation TEXTURE = new ResourceLocation(FrozenSentinel.MOD_ID, "textures/entity/lesserbluegifter.png");

    public LesserGifterSentinelLayer(RenderLayerParent<LesserGifterSentinel, ColdSnapGifterModel<LesserGifterSentinel>> entityRendererIn) {
        super(entityRendererIn);
    }

    @Override
    public void render(PoseStack matrixStackIn, MultiBufferSource bufferIn, int packedLightIn, LesserGifterSentinel entitylivingbaseIn, float limbSwing, float limbSwingAmount, float partialTicks, float ageInTicks, float netHeadYaw, float headPitch) {
        if(!entitylivingbaseIn.isInvisible()){
            VertexConsumer bb = bufferIn.getBuffer(RenderType.entityTranslucent(TEXTURE));
            this.getParentModel().renderToBuffer(matrixStackIn, bb, packedLightIn, OverlayTexture.NO_OVERLAY, 1f, 1f, 1f, 1f);
        }
    }
}
