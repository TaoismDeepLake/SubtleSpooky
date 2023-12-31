package com.deeplake.subtlespooky.blocks.tileEntity.builder;

import java.util.Vector;

import com.deeplake.subtlespooky.blocks.tileEntity.builder.builderAction.BuilderActionBase;
import com.deeplake.subtlespooky.blocks.tileEntity.builder.builderAction.BuilderActionBlock;
import net.minecraft.init.Blocks;

public class TileEntityBuilderOne extends TileEntityBuilderBase {

	public void InitTaskQueue(){
		int radius = 10;
		list = new Vector<BuilderActionBase>();
		for (int x = -radius; x <= radius; x++)
			for (int z = -radius; z <= radius; z++) {
				list.add(new BuilderActionBlock(Blocks.BRICK_BLOCK, x,-1,z));
			}
	}

	static
	{
		register("subtlespooky:builder.builder_one", TileEntityBuilderOne.class);
	}
}
