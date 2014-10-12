package awesomemancam.minersdeluxe;

import java.util.EnumSet;
import java.util.Random;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import cpw.mods.fml.common.ITickHandler;
import cpw.mods.fml.common.TickType;

public class ServerTickHandler implements ITickHandler {

	private void onPlayerTick(EntityPlayer player) {
		if (player.getCurrentItemOrArmor(4) != null && player.getCurrentItemOrArmor(3) != null 
				&& player.getCurrentItemOrArmor(2) != null && player.getCurrentItemOrArmor(1) != null) {
			ItemStack helmet = player.getCurrentItemOrArmor(4);
			ItemStack chest = player.getCurrentItemOrArmor(3);
			ItemStack leggings = player.getCurrentItemOrArmor(2);
			ItemStack boots = player.getCurrentItemOrArmor(1);
			if (helmet.getItem() == MinersDeluxe.burningDiamondHelmet && chest.getItem() == MinersDeluxe.burningDiamondChest 
					&& leggings.getItem() == MinersDeluxe.burningDiamondLeggings && boots.getItem() == MinersDeluxe.burningDiamondBoots) {
				player.addPotionEffect(new PotionEffect(Potion.resistance.getId(), 200, 0));
				player.addPotionEffect(new PotionEffect(Potion.fireResistance.getId(), 200, 0));
				Random rand = new Random();
				if (rand.nextInt()%100 == 0) {
					player.addPotionEffect(new PotionEffect(Potion.regeneration.getId(), 60, 2));
				}
			}
			if (helmet.getItem() == MinersDeluxe.rubyHelmet && chest.getItem() == MinersDeluxe.rubyChest 
					&& leggings.getItem() == MinersDeluxe.rubyLeggings && boots.getItem() == MinersDeluxe.rubyBoots) {
				player.addPotionEffect(new PotionEffect(Potion.fireResistance.getId(), 200, 0));
			}
			if (helmet.getItem() == MinersDeluxe.amethystHelmet && chest.getItem() == MinersDeluxe.amethystChest 
					&& leggings.getItem() == MinersDeluxe.amethystLeggings && boots.getItem() == MinersDeluxe.amethystBoots) {
				player.addPotionEffect(new PotionEffect(Potion.damageBoost.getId(), 200, 0));
			}
			if (helmet.getItem() == MinersDeluxe.andraditeHelmet && chest.getItem() == MinersDeluxe.andraditeChest 
					&& leggings.getItem() == MinersDeluxe.andraditeLeggings && boots.getItem() == MinersDeluxe.andraditeBoots) {
				player.addPotionEffect(new PotionEffect(Potion.digSpeed.getId(), 200, 0));
			}
			if (helmet.getItem() == MinersDeluxe.sapphireHelmet && chest.getItem() == MinersDeluxe.sapphireChest 
					&& leggings.getItem() == MinersDeluxe.sapphireLeggings && boots.getItem() == MinersDeluxe.sapphireBoots) {
				player.addPotionEffect(new PotionEffect(Potion.waterBreathing.getId(), 200, 0));
			}
			if (helmet.getItem() == MinersDeluxe.onyxHelmet && chest.getItem() == MinersDeluxe.onyxChest 
					&& leggings.getItem() == MinersDeluxe.onyxLeggings && boots.getItem() == MinersDeluxe.onyxBoots) {
				player.addPotionEffect(new PotionEffect(Potion.nightVision.getId(), 200, 0));
			}
			if (helmet.getItem() == MinersDeluxe.orthoclaseHelmet && chest.getItem() == MinersDeluxe.orthoclaseChest 
					&& leggings.getItem() == MinersDeluxe.orthoclaseLeggings && boots.getItem() == MinersDeluxe.orthoclaseBoots) {
				player.addPotionEffect(new PotionEffect(Potion.jump.getId(), 200, 5));
			}
			if (helmet.getItem() == MinersDeluxe.steelHelmet && chest.getItem() == MinersDeluxe.steelChest 
					&& leggings.getItem() == MinersDeluxe.steelLeggings && boots.getItem() == MinersDeluxe.steelBoots) {
				player.addPotionEffect(new PotionEffect(Potion.moveSpeed.getId(), 200, 3));
			}
			if (helmet.getItem() == MinersDeluxe.bloodstoneHelmet && chest.getItem() == MinersDeluxe.bloodstoneChest 
					&& leggings.getItem() == MinersDeluxe.bloodstoneLeggings && boots.getItem() == MinersDeluxe.bloodstoneBoots) {
				player.addPotionEffect(new PotionEffect(Potion.blindness.getId(), 200, 0));
				player.addPotionEffect(new PotionEffect(Potion.confusion.getId(), 200, 0));
				player.addPotionEffect(new PotionEffect(Potion.digSlowdown.getId(), 200, 0));
				player.addPotionEffect(new PotionEffect(Potion.hunger.getId(), 200, 0));
				player.addPotionEffect(new PotionEffect(Potion.moveSlowdown.getId(), 200, 0));
				player.addPotionEffect(new PotionEffect(Potion.poison.getId(), 200, 0));
				player.addPotionEffect(new PotionEffect(Potion.weakness.getId(), 200, 0));
			}
			if (helmet.getItem() == MinersDeluxe.tourmalineHelmet && chest.getItem() == MinersDeluxe.tourmalineChest 
					&& leggings.getItem() == MinersDeluxe.tourmalineLeggings && boots.getItem() == MinersDeluxe.tourmalineBoots) {
				Random rand = new Random();
				if (rand.nextInt()%100 == 0) {
					player.addPotionEffect(new PotionEffect(Potion.regeneration.getId(), 60, 2));
				}
			}
		}
	}
	
	@Override
	public void tickStart(EnumSet<TickType> type, Object... tickData) {
		if (type.equals(EnumSet.of(TickType.PLAYER))) {
			onPlayerTick((EntityPlayer) tickData[0]);
		}
		
	}

	@Override
	public void tickEnd(EnumSet<TickType> type, Object... tickData) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public EnumSet<TickType> ticks() {
		return EnumSet.of(TickType.PLAYER, TickType.SERVER);
	}

	@Override
	public String getLabel() {
		// TODO Auto-generated method stub
		return null;
	}

}
