package awesomemancam.minersdeluxe.util;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.item.EnumArmorMaterial;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;

public class Armor extends ItemArmor {

	private String texturePath = "minersdeluxe:";
	private String iconPath = "minersdeluxe:";
	
	public Armor(int par1, EnumArmorMaterial par2EnumArmorMaterial, int par3, int par4, String type) {
		super(par1, par2EnumArmorMaterial, par3, par4);
		this.setMaxStackSize(1);
		this.setCreativeTab(CreativeTabs.tabCombat);
		this.setArmorType(type.toLowerCase(), par4);
	}
	
	private void setArmorType(String type, int par4) {
		switch (par4) {
		case 0:
			this.setUnlocalizedName(type + "Helmet");
			this.texturePath += type + "_layer_1.png";
			this.iconPath += type + "_helmet";
			break;
		case 1:
			this.setUnlocalizedName(type + "Chest");
			this.texturePath += type + "_layer_1.png";
			this.iconPath += type + "_chest";
			break;
		case 2:
			this.setUnlocalizedName(type + "Leggings");
			this.texturePath += type + "_layer_2.png";
			this.iconPath += type + "_leggings";
			break;
		case 3:
			this.setUnlocalizedName(type + "Boots");
			this.texturePath += type + "_layer_1.png";
			this.iconPath += type + "_boots";
			break;
		}
	}
	
	@SideOnly(Side.CLIENT)
	public void registerIcons(IconRegister reg) {
		this.itemIcon = reg.registerIcon(this.iconPath);
	}

	@SideOnly(Side.CLIENT)
	public String getArmorTexture(ItemStack stack, Entity entity, int slot, int layer) {
		return this.texturePath;
	}

}
