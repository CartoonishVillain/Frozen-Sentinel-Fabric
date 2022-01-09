package com.cartoonishvillain.frozensentinel.client.layers;

import com.cartoonishvillain.coldsnaphorde.client.models.standardmodel.ColdSnapSnowballerModel;
import com.cartoonishvillain.frozensentinel.FrozenSentinel;
import com.cartoonishvillain.frozensentinel.entity.LesserSnowballerSentinel;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.RenderLayerParent;
import net.minecraft.client.renderer.entity.layers.RenderLayer;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.resources.ResourceLocation;

public class LesserSnowballerSentinelLayer extends RenderLayer<LesserSnowballerSentinel, ColdSnapSnowballerModel<LesserSnowballerSentinel>> {
    protected final static ResourceLocation TEXTURE = new ResourceLocation(FrozenSentinel.MOD_ID, "textures/entity/lesserbluesnowballer.png");

    public LesserSnowballerSentinelLayer(RenderLayerParent<LesserSnowballerSentinel, ColdSnapSnowballerModel<LesserSnowballerSentinel>> entityRendererIn) {
        super(entityRendererIn);
    }

    @Override
    public void render(PoseStack matrixStackIn, MultiBufferSource bufferIn, int packedLightIn, LesserSnowballerSentinel entitylivingbaseIn, float limbSwing, float limbSwingAmount, float partialTicks, float ageInTicks, float netHeadYaw, float headPitch) {
        if(!entitylivingbaseIn.isInvisible()){
            VertexConsumer bb = bufferIn.getBuffer(RenderType.entityTranslucent(TEXTURE));
            this.getParentModel().renderToBuffer(matrixStackIn, bb, packedLightIn, OverlayTexture.NO_OVERLAY, 1f, 1f, 1f, 1f);
        }
    }
}
