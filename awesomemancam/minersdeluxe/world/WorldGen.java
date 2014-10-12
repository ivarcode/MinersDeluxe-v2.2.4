package awesomemancam.minersdeluxe.world;

import java.util.Random;

import awesomemancam.minersdeluxe.MinersDeluxe;
import net.minecraft.block.Block;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.feature.WorldGenMinable;
import cpw.mods.fml.common.IWorldGenerator;

public class WorldGen implements IWorldGenerator {
	@Override
	public void generate (Random random, int chunkX, int chunkZ, World world, IChunkProvider chunkGenerator, IChunkProvider chunkProvider) {
		switch (world.provider.dimensionId) {
		case -1:
			generateNether(world, random, chunkX * 16, chunkZ * 16);
			break;
		case 0:
			generateSurface(world, random, chunkX * 16, chunkZ * 16);
			break;
		case 1:
			generateEnd(world, random, chunkX * 16, chunkZ * 16);
			break;
		case 2:
			generateGrandMine(world, random, chunkX * 16, chunkZ * 16);
			break;
		}
	}

	private void generateGrandMine(World world, Random rand, int chunkX, int chunkZ) {
		for(int k = 0; k < 25; k++){
        	int fishOreXCoord = chunkX + rand.nextInt(16);
        	int fishOreYCoord = rand.nextInt(128);
        	int fishOreZCoord = chunkZ + rand.nextInt(16);
        	(new WorldGenMinable(Block.silverfish.blockID, rand.nextInt(24))).generate(world, rand, fishOreXCoord, fishOreYCoord, fishOreZCoord);
        }
		for(int k = 0; k < 8; k++){
        	int diamondOreXCoord = chunkX + rand.nextInt(16);
        	int diamondOreYCoord = rand.nextInt(128);
        	int diamondOreZCoord = chunkZ + rand.nextInt(16);
        	(new WorldGenMinable(Block.oreDiamond.blockID, rand.nextInt(12))).generate(world, rand, diamondOreXCoord, diamondOreYCoord, diamondOreZCoord);
        }
		for(int k = 0; k < 6; k++){
        	int burningdiamondOreXCoord = chunkX + rand.nextInt(16);
        	int burningdiamondOreYCoord = rand.nextInt(128);
        	int burningdiamondOreZCoord = chunkZ + rand.nextInt(16);
        	(new WorldGenMinable(MinersDeluxe.burningDiamondOre.blockID, rand.nextInt(8))).generate(world, rand, burningdiamondOreXCoord, burningdiamondOreYCoord, burningdiamondOreZCoord);
        }
		for(int k = 0; k < 4; k++){
        	int benitoiteOreXCoord = chunkX + rand.nextInt(16);
        	int benitoiteOreYCoord = rand.nextInt(128);
        	int benitoiteOreZCoord = chunkZ + rand.nextInt(16);
        	(new WorldGenMinable(MinersDeluxe.benitoiteOre.blockID, rand.nextInt(8))).generate(world, rand, benitoiteOreXCoord, benitoiteOreYCoord, benitoiteOreZCoord);
        }
		for(int k = 0; k < 25; k++){
        	int goldOreXCoord = chunkX + rand.nextInt(16);
        	int goldOreYCoord = rand.nextInt(128);
        	int goldOreZCoord = chunkZ + rand.nextInt(16);
        	(new WorldGenMinable(Block.oreGold.blockID, rand.nextInt(24))).generate(world, rand, goldOreXCoord, goldOreYCoord, goldOreZCoord);
        }
		for(int k = 0; k < 25; k++){
        	int redstoneOreXCoord = chunkX + rand.nextInt(16);
        	int redstoneOreYCoord = rand.nextInt(128);
        	int redstoneOreZCoord = chunkZ + rand.nextInt(16);
        	(new WorldGenMinable(Block.oreRedstone.blockID, rand.nextInt(36))).generate(world, rand, redstoneOreXCoord, redstoneOreYCoord, redstoneOreZCoord);
        }
		for(int k = 0; k < 25; k++){
        	int ironOreXCoord = chunkX + rand.nextInt(16);
        	int ironOreYCoord = rand.nextInt(128);
        	int ironOreZCoord = chunkZ + rand.nextInt(16);
        	(new WorldGenMinable(Block.oreIron.blockID, rand.nextInt(36))).generate(world, rand, ironOreXCoord, ironOreYCoord, ironOreZCoord);
        }
		for(int k = 0; k < 25; k++){
        	int coalOreXCoord = chunkX + rand.nextInt(16);
        	int coalOreYCoord = rand.nextInt(128);
        	int coalOreZCoord = chunkZ + rand.nextInt(16);
        	(new WorldGenMinable(Block.oreCoal.blockID, rand.nextInt(36))).generate(world, rand, coalOreXCoord, coalOreYCoord, coalOreZCoord);
        }
	}

	private void generateEnd(World world, Random rand, int chunkX, int chunkZ) {
		
	}

	private void generateSurface(World world, Random rand, int chunkX, int chunkZ) {
		for(int k = 0; k < 8; k++){
        	int amethystOreXCoord = chunkX + rand.nextInt(16);
        	int amethystOreYCoord = rand.nextInt(45);
        	int amethystOreZCoord = chunkZ + rand.nextInt(16);
        	(new WorldGenMinable(MinersDeluxe.amethystOre.blockID, rand.nextInt(8))).generate(world, rand, amethystOreXCoord, amethystOreYCoord, amethystOreZCoord);
        }
		for(int k = 0; k < 8; k++){
        	int pyriteOreXCoord = chunkX + rand.nextInt(16);
        	int pyriteOreYCoord = rand.nextInt(40);
        	int pyriteOreZCoord = chunkZ + rand.nextInt(16);
        	(new WorldGenMinable(MinersDeluxe.pyriteOre.blockID, rand.nextInt(8))).generate(world, rand, pyriteOreXCoord, pyriteOreYCoord, pyriteOreZCoord);
        }
		for(int k = 0; k < 4; k++){
        	int topazOreXCoord = chunkX + rand.nextInt(16);
        	int topazOreYCoord = rand.nextInt(20);
        	int topazOreZCoord = chunkZ + rand.nextInt(16);
        	(new WorldGenMinable(MinersDeluxe.topazOre.blockID, rand.nextInt(8))).generate(world, rand, topazOreXCoord, topazOreYCoord, topazOreZCoord);
        }
		for(int k = 0; k < 4; k++){
        	int tourmalineOreXCoord = chunkX + rand.nextInt(16);
        	int tourmalineOreYCoord = rand.nextInt(20);
        	int tourmalineOreZCoord = chunkZ + rand.nextInt(16);
        	(new WorldGenMinable(MinersDeluxe.tourmalineOre.blockID, rand.nextInt(8))).generate(world, rand, tourmalineOreXCoord, tourmalineOreYCoord, tourmalineOreZCoord);
        }
		for(int k = 0; k < 8; k++){
        	int andraditeOreXCoord = chunkX + rand.nextInt(16);
        	int andraditeOreYCoord = rand.nextInt(45);
        	int andraditeOreZCoord = chunkZ + rand.nextInt(16);
        	(new WorldGenMinable(MinersDeluxe.andraditeOre.blockID, rand.nextInt(8))).generate(world, rand, andraditeOreXCoord, andraditeOreYCoord, andraditeOreZCoord);
        }
		for(int k = 0; k < 6; k++){
        	int orthoclaseOreXCoord = chunkX + rand.nextInt(16);
        	int orthoclaseOreYCoord = rand.nextInt(30);
        	int orthoclaseOreZCoord = chunkZ + rand.nextInt(16);
        	(new WorldGenMinable(MinersDeluxe.orthoclaseOre.blockID, rand.nextInt(8))).generate(world, rand, orthoclaseOreXCoord, orthoclaseOreYCoord, orthoclaseOreZCoord);
        }
		for(int k = 0; k < 8; k++){
        	int rubyOreXCoord = chunkX + rand.nextInt(16);
        	int rubyOreYCoord = rand.nextInt(50);
        	int rubyOreZCoord = chunkZ + rand.nextInt(16);
        	(new WorldGenMinable(MinersDeluxe.rubyOre.blockID, rand.nextInt(8))).generate(world, rand, rubyOreXCoord, rubyOreYCoord, rubyOreZCoord);
        }
		for(int k = 0; k < 6; k++){
        	int onyxOreXCoord = chunkX + rand.nextInt(16);
        	int onyxOreYCoord = rand.nextInt(30);
        	int onyxOreZCoord = chunkZ + rand.nextInt(16);
        	(new WorldGenMinable(MinersDeluxe.onyxOre.blockID, rand.nextInt(8))).generate(world, rand, onyxOreXCoord, onyxOreYCoord, onyxOreZCoord);
        }
		for(int k = 0; k < 6; k++){
        	int sapphireOreXCoord = chunkX + rand.nextInt(16);
        	int sapphireOreYCoord = rand.nextInt(40);
        	int sapphireOreZCoord = chunkZ + rand.nextInt(16);
        	(new WorldGenMinable(MinersDeluxe.sapphireOre.blockID, rand.nextInt(8))).generate(world, rand, sapphireOreXCoord, sapphireOreYCoord, sapphireOreZCoord);
        }
		for(int k = 0; k < 5; k++){
        	int iridiumOreXCoord = chunkX + rand.nextInt(16);
        	int iridiumOreYCoord = rand.nextInt(30);
        	int iridiumOreZCoord = chunkZ + rand.nextInt(16);
        	(new WorldGenMinable(MinersDeluxe.iridiumOre.blockID, rand.nextInt(8))).generate(world, rand, iridiumOreXCoord, iridiumOreYCoord, iridiumOreZCoord);
        }
	}

	private void generateNether(World world, Random rand, int chunkX, int chunkZ) {
		for(int k = 0; k < 10; k++){
        	int bloodstoneOreXCoord = chunkX + rand.nextInt(16);
        	int bloodstoneOreYCoord = rand.nextInt(128);
        	int bloodstoneOreZCoord = chunkZ + rand.nextInt(16);
        	(new WorldGenNetherMinable(MinersDeluxe.bloodstoneOre.blockID, rand.nextInt(16))).generate(world, rand, bloodstoneOreXCoord, bloodstoneOreYCoord, bloodstoneOreZCoord);
        }
	}
}