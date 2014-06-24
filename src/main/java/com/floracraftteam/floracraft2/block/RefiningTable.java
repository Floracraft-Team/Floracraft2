package com.floracraftteam.floracraft2.block;

import com.floracraftteam.floracraft2.FloraCraft2;
import com.floracraftteam.floracraft2.core.reference.FC2Reference;
import com.floracraftteam.floracraft2.tile.TileEntityRefiningTable;

import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;

public class RefiningTable extends BlockContainer {
	
	@SideOnly(Side.CLIENT)
	private IIcon top;
	@SideOnly(Side.CLIENT)
	private IIcon front;
	
	protected RefiningTable(){
		
		super(Material.rock);
		this.setBlockName(FC2Reference.REFININGTABLE_NAME);
		this.setHardness(1.2F);
		this.setResistance(2.5F);
		this.setStepSound(Block.soundTypeStone);
		GameRegistry.registerBlock(this, this.getUnlocalizedName());
	}

    @Override
    public TileEntity createNewTileEntity(World var1, int var2)
    {
        return new TileEntityRefiningTable();
    }

    @Override
    public boolean hasTileEntity(int meta)
    {
        return true;
    }
    @Override
    public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int par6, float par7, float par8, float par9)
    {
        if (player.isSneaking())
        {
            return false;
        }
        else
        {
            if (!world.isRemote)
            {
                if (world.getTileEntity(x, y, z) instanceof TileEntityRefiningTable)
                {
                    player.openGui(FloraCraft2.instance, FC2Reference.REFININGTABLE, world, x, y, z);
                }
            }

            return true;
        }
    }
	@SideOnly(Side.CLIENT)
	public IIcon getIcon(int side, int p_149691_2_)
	{
	return side == 1 || side == 0 ? this.top : (side == 2 ? this.front : this.blockIcon);
	}
	
	@SideOnly(Side.CLIENT)
	public void registerBlockIcons(IIconRegister p_149651_1_)
	{
	this.blockIcon = p_149651_1_.registerIcon(FC2Reference.RESOURCESPREFIX + ":" + "refiningTable" + "side");
	this.top = p_149651_1_.registerIcon(FC2Reference.RESOURCESPREFIX + ":" + "refiningTable" + "top");
	this.front = p_149651_1_.registerIcon(FC2Reference.RESOURCESPREFIX + ":" + "refiningTable" + "front");
	}

}
