package com.deeplake.subtlespooky.item.misc;

import java.util.Random;

import com.deeplake.subtlespooky.item.ItemBase;
import com.deeplake.subtlespooky.util.EntityUtil;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;

public class ItemYiJianMei extends ItemBase {
    public ItemYiJianMei(String name) {
        super(name);
    }

    @Override
    public void onUpdate(ItemStack stack, World worldIn, Entity entityIn, int itemSlot, boolean isSelected) {
        super.onUpdate(stack, worldIn, entityIn, itemSlot, isSelected);
        if (worldIn.isRemote && entityIn instanceof EntityPlayer)
        {
            Random random = ((EntityPlayer) entityIn).getRNG();
            Vec3d pos = EntityUtil.GetRandomAroundPos(entityIn.getPositionEyes(0f), 1f, random).addVector(0, random.nextFloat(), 0);
            worldIn.spawnParticle(EnumParticleTypes.SNOW_SHOVEL, pos.x, pos.y, pos.z, 0,0, random.nextFloat());//from the north
        }
    }
}
