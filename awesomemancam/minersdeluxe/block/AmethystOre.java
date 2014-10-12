package awesomemancam.minersdeluxe.block;

import java.util.Random;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import awesomemancam.minersdeluxe.MinersDeluxe;
import awesomemancam.minersdeluxe.lib.Library;
import net.minecraft.block.BlockOre;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;

public class AmethystOre extends BlockOre {

	public AmethystOre(int par1) {
		super(par1);
		
		this.setHardness(4.0F);
		this.setStepSound(soundStoneFootstep);
		this.setUnlocalizedName(Library.BLOCK.U_NAME.amethystOre);
		this.setCreativeTab(CreativeTabs.tabBlock);
		this.setLightValue(0.0F);
	}
	
	public int idDropped(int par1, Random random, int par2) {
        return MinersDeluxe.amethyst.itemID;
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public void registerIcons(IconRegister reg) {
		this.blockIcon = reg.registerIcon("minersdeluxe:amethystOre");
	}
	
}
