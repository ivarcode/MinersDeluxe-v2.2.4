package awesomemancam.minersdeluxe.block;

import java.util.Random;

import awesomemancam.minersdeluxe.MinersDeluxe;
import awesomemancam.minersdeluxe.lib.Library;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.BlockTorch;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;

public class SapphireTorch extends BlockTorch
{
    public SapphireTorch(int par1)
    {
        super(par1);
        this.setLightValue(1.0F);
        this.setTickRandomly(true);
        this.setCreativeTab(CreativeTabs.tabDecorations);
        this.setUnlocalizedName(Library.BLOCK.U_NAME.sapphireTorch);
    }
    
    public int idDropped(int par1, Random random, int par2) {
        return MinersDeluxe.sapphireTorch.blockID;
	}

    @Override
	@SideOnly(Side.CLIENT)
	public void registerIcons(IconRegister reg) {
		this.blockIcon = reg.registerIcon("minersdeluxe:sapphireTorch");
	}
}
