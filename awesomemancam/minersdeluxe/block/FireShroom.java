package awesomemancam.minersdeluxe.block;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import awesomemancam.minersdeluxe.MinersDeluxe;
import awesomemancam.minersdeluxe.lib.Library;
import net.minecraft.block.Block;
import net.minecraft.block.BlockFlower;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;

public class FireShroom extends BlockFlower {

	public FireShroom(int par1, Material par2Material) {
		super(par1, par2Material);
		this.setUnlocalizedName(Library.BLOCK.U_NAME.fireShroom);
	}
	
	@Override
	protected boolean canThisPlantGrowOnThisBlockID(int par1)
    {
        return par1 == MinersDeluxe.grandStone.blockID;
    }
	
	@Override
	@SideOnly(Side.CLIENT)
	public void registerIcons(IconRegister reg) {
		this.blockIcon = reg.registerIcon("minersdeluxe:fireShroom");
	}

}
