package com.cartoonishvillain.frozensentinel.client.layers;

import com.cartoonishvillain.coldsnaphorde.client.models.standardmodel.ColdSnapGunnerModel;
import com.cartoonishvillain.frozensentinel.FrozenSentinel;
import com.cartoonishvillain.frozensentinel.entity.LesserGunnerSentinel;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.RenderLayerParent;
import net.minecraft.client.renderer.entity.layers.RenderLayer;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.resources.ResourceLocation;

public class LesserGunnerSentinelLayer extends RenderLayer<LesserGunnerSentinel, ColdSnapGunnerModel<LesserGunnerSentinel>> {
    protected final static ResourceLocation TEXTURE = new ResourceLocation(FrozenSentinel.MOD_ID, "textures/entity/lesserbluegunner.png");

    public LesserGunnerSentinelLayer(RenderLayerParent<LesserGunnerSentinel, ColdSnapGunnerModel<LesserGunnerSentinel>> entityRendererIn) {
        super(entityRendererIn);
    }

    @Override
    public void render(PoseStack matrixStackIn, MultiBufferSource bufferIn, int packedLightIn, LesserGunnerSentinel entitylivingbaseIn, float limbSwing, float limbSwingAmount, float partialTicks, float ageInTicks, float netHeadYaw, float headPitch) {
        if(!entitylivingbaseIn.isInvisible()){
            VertexConsumer bb = bufferIn.getBuffer(RenderType.entityTranslucent(TEXTURE));
            this.getParentModel().renderToBuffer(matrixStackIn, bb, packedLightIn, OverlayTexture.NO_OVERLAY, 1f, 1f, 1f, 1f);
        }
    }
}
