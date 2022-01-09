package com.cartoonishvillain.frozensentinel.client;

import com.cartoonishvillain.frozensentinel.Register;
import com.cartoonishvillain.frozensentinel.client.renderers.*;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;

public class RenderManager implements ClientModInitializer {

    @Override
    public void onInitializeClient() {
        EntityRendererRegistry.register(Register.LESSERBASESENTINEL, LesserBasicSentinelRenderer::new);
        EntityRendererRegistry.register(Register.LESSERSTABBERSENTINEL, LesserStabberSentinelRenderer::new);
        EntityRendererRegistry.register(Register.LESSERGUNNERSENTINEL, LesserGunnerSentinelRenderer::new);
        EntityRendererRegistry.register(Register.LESSERSNOWBALLERSENTINEL, LesserSnowballerSentinelRenderer::new);
        EntityRendererRegistry.register(Register.LESSERGIFTERSENTINEL, LesserGifterSentinelRenderer::new);
        EntityRendererRegistry.register(Register.LESSERZAPPERSENTINEL, LesserZapperSentinelRenderer::new);
        EntityRendererRegistry.register(Register.LESSERBRAWLERSENTINEL, LesserBrawlerSentinelRenderer::new);
    }
}
