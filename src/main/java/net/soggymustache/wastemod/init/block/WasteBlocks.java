package net.soggymustache.wastemod.init.block;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.Minecraft;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.soggymustache.wastemod.Reference;
import net.soggymustache.wastemod.init.block.type.BinBlock;

public class WasteBlocks {
	
	public static Block waste_bin;

	
	public static void init() {
		waste_bin = new BinBlock(Material.cloth).setUnlocalizedName("waste_bin");
	}
	
	public static void register()
	{
		GameRegistry.registerBlock(waste_bin, waste_bin.getUnlocalizedName().substring(5));
	}
	
	public static void registerRenders()
	{
		registerRenders(waste_bin);
	}
	
	public static void registerRenders(Block block)
	{
		Item item = Item.getItemFromBlock(block);
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(item, 0, new ModelResourceLocation(Reference.MOD_ID + ":" + item.getUnlocalizedName().substring(5), "inventory")); 						
	}
}
