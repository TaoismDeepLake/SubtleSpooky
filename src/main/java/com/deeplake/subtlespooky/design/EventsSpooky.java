package com.deeplake.subtlespooky.design;

import com.deeplake.subtlespooky.IdlFramework;
import com.deeplake.subtlespooky.init.ModConfig;
import com.deeplake.subtlespooky.util.CommonDef;
import com.deeplake.subtlespooky.util.EntityUtil;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.SoundEvents;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent;

import java.util.Random;

@Mod.EventBusSubscriber(modid = IdlFramework.MODID)
public class EventsSpooky {

    public static boolean isAlone(EntityPlayer player)
    {
        World world = player.getEntityWorld();
        return (long) EntityUtil.getEntitiesWithinAABB(world,
                EntityPlayer.class,
                player.getPositionVector(), 64f, null).size() == 1;
    }

    @SubscribeEvent
    public static void onTick(TickEvent.PlayerTickEvent event)
    {
        EntityPlayer player = event.player;
        World world = player.getEntityWorld();
        long tick = world.getTotalWorldTime();
        Random random = player.getRNG();
        Vec3d spot = player.getPositionVector().add(player.getLookVec().scale(-14f));
        if (isAlone(player))
        {
            if (tick % CommonDef.TICK_PER_DAY == 0)
            {

            }
            else if (tick % CommonDef.TICK_PER_SECOND == 0)
            {
                if (random.nextFloat() < ModConfig.GENERAL_CONF.SKELETON_SOUND_CHANCE)
                {
                    SoundEvent soundEvent = random.nextBoolean() ? SoundEvents.ENTITY_SKELETON_SHOOT
                            : SoundEvents.ENTITY_SKELETON_AMBIENT;
                    world.playSound(null,spot.x, spot.y, spot.z,
                            soundEvent,
                            SoundCategory.HOSTILE,
                            0.8f+random.nextFloat()*0.2f,
                            1f);
                }

                //todo: witch, creeper, arrow hit, explosion
            }
        }
    }
}
