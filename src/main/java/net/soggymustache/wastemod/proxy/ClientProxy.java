package net.soggymustache.wastemod.proxy;

import net.soggymustache.wastemod.init.block.WasteBlocks;

public class ClientProxy extends CommonProxy{
	@Override
	public void registerRenders() {
		//Register the models to load
		WasteBlocks.registerRenders();
	}
}
