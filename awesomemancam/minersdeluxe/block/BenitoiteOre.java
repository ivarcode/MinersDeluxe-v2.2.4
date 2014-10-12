package awesomemancam.minersdeluxe.block;

import java.util.Random;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import awesomemancam.minersdeluxe.MinersDeluxe;
import awesomemancam.minersdeluxe.lib.Library;
import net.minecraft.block.BlockOre;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;

public class BenitoiteOre extends BlockOre {

	public BenitoiteOre(int par1) {
		super(par1);
		
		this.setHardness(4.0F);
		this.setStepSound(soundStoneFootstep);
		this.setUnlocalizedName(Library.BLOCK.U_NAME.benitoiteOre);
		this.setCreativeTab(CreativeTabs.tabBlock);
	}
	
	public int idDropped(int par1, Random random, int par2) {
        return MinersDeluxe.benitoite.itemID;
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public void registerIcons(IconRegister reg) {
		this.blockIcon = reg.registerIcon("minersdeluxe:benitoiteOre");
	}
	
}
