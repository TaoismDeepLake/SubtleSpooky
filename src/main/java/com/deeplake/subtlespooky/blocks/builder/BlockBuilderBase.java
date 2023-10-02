package com.deeplake.subtlespooky.blocks.builder;

import com.deeplake.subtlespooky.IdlFramework;
import com.deeplake.subtlespooky.blocks.BlockBase;
import com.deeplake.subtlespooky.blocks.tileEntity.builder.TileEntityBuilderBase;
import com.deeplake.subtlespooky.init.ModCreativeTab;
import net.minecraft.block.ITileEntityProvider;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.world.World;

public class BlockBuilderBase extends BlockBase implements ITileEntityProvider {

    Class<? extends TileEntityBuilderBase> tileEntity;

    public BlockBuilderBase(String name, Material material, Class<? extends TileEntityBuilderBase> tileEntity) {
        super(name, material);
        this.tileEntity = tileEntity;
        setCreativeTab(ModCreativeTab.IDL_MISC);
        setSoundType(SoundType.METAL);
        setHardness(5.0F);
        setResistance(15.0F);
        setHarvestLevel("pickaxe", 3);
        setLightOpacity(1);
    }

    /**
     * Returns a new instance of a block's tile entity class. Called on placing the block.
     */
    public TileEntityBuilderBase createNewTileEntity(World worldIn, int meta) {
        TileEntityBuilderBase t = null;
        try {
            t = tileEntity.newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
            IdlFramework.Log("Instantiate failed");
        }
        return t;
    }
}
