package com.deeplake.subtlespooky.entity;

import com.deeplake.subtlespooky.IdlFramework;
import com.deeplake.subtlespooky.entity.creatures.moroon.EntityMoroonUnitBase;
import com.deeplake.subtlespooky.entity.creatures.render.RenderBullet;
import com.deeplake.subtlespooky.entity.creatures.render.RenderMoroonHumanoid;
import com.deeplake.subtlespooky.entity.projectiles.EntityIdlProjectile;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.client.registry.RenderingRegistry;

public class RenderHandler {

    public static void registerEntityRenders() {
        RenderingRegistry.registerEntityRenderingHandler(EntityMoroonUnitBase.class, RenderMoroonHumanoid::new);

        RenderingRegistry.registerEntityRenderingHandler(EntityIdlProjectile.class, renderManager -> new RenderBullet<>(renderManager, new ResourceLocation(IdlFramework.MODID,
                "textures/entity/projectiles/bullet_norm.png")));
    }
}
