package net.soggymustache.wastemod.init.block.type;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.BlockPos;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.EnumWorldBlockLayer;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class BinBlock extends Block{

	public BinBlock(Material materialIn) {
		super(materialIn);
		this.setCreativeTab(CreativeTabs.tabMisc);
	}
	//Make items and blocks get deleted when clicked on block
	@Override
	public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn, EnumFacing side, float hitX, float hitY, float hitZ) {
        ItemStack itemstack = playerIn.inventory.getCurrentItem();
        
        if(playerIn.getHeldItem() != null){
        	--itemstack.stackSize;
            worldIn.spawnParticle(EnumParticleTypes.CLOUD, (double)pos.getX() + 0.5D, (double)pos.getY() + 2.0D, (double)pos.getZ() + 0.5D, 0.0D, 0.0D, 0.0D, new int[0]);
        }

		return super.onBlockActivated(worldIn, pos, state, playerIn, side, hitX, hitY, hitZ);
	}
	
	//Help model load properly
	@Override
	public boolean isOpaqueCube() {
		return false;
	}
	//Help model load properly
	@Override
	public boolean isFullCube() {
		return false;
	}
	//Help model load properly
    @SideOnly(Side.CLIENT)
    public EnumWorldBlockLayer getBlockLayer()
    {
        return EnumWorldBlockLayer.CUTOUT;
    }
    //Make items and blocks thrown on top get deleteds
	@Override
    public void onEntityCollidedWithBlock(World worldIn, BlockPos pos, IBlockState state, Entity entityIn)
    {
		if(!entityIn.isEntityAlive()){
			entityIn.attackEntityFrom(DamageSource.cactus, 1.0F);
		}
    }

}
