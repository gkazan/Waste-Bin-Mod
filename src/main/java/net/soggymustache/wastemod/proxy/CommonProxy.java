package net.soggymustache.wastemod.proxy;

import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.soggymustache.wastemod.init.block.WasteBlocks;

public class CommonProxy {
	

	public void preInit(FMLPreInitializationEvent event)
	{
		//Initialize and register the block class
		WasteBlocks.init();
		WasteBlocks.register();
	}
	
	public void init(FMLInitializationEvent event)	
	{
		//Crafting recipe
		GameRegistry.addRecipe(new ItemStack(WasteBlocks.waste_bin, 1), new Object[] {"III", "SSS", "SSS", 'S', Item.getItemFromBlock(Blocks.cobblestone), 'I', Items.iron_ingot});
	}
	public void postInit(FMLPostInitializationEvent event)
	{

	}
	public void registerRenders() {

	}

}
