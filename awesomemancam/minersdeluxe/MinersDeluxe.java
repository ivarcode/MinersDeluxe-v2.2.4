package awesomemancam.minersdeluxe;

import java.io.File;

import net.minecraft.block.Block;
import net.minecraft.block.BlockFlower;
import net.minecraft.block.material.Material;
import net.minecraft.command.ICommandManager;
import net.minecraft.command.ServerCommandManager;
import net.minecraft.entity.EnumCreatureType;
import net.minecraft.item.EnumArmorMaterial;
import net.minecraft.item.EnumToolMaterial;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.server.MinecraftServer;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraftforge.common.Configuration;
import net.minecraftforge.common.DimensionManager;
import net.minecraftforge.common.EnumHelper;
import net.minecraftforge.common.MinecraftForge;
import awesomemancam.minersdeluxe.biome.GrandMineBiome;
import awesomemancam.minersdeluxe.block.AmethystBlock;
import awesomemancam.minersdeluxe.block.AmethystGlass;
import awesomemancam.minersdeluxe.block.AmethystOre;
import awesomemancam.minersdeluxe.block.AmethystTorch;
import awesomemancam.minersdeluxe.block.AndraditeBlock;
import awesomemancam.minersdeluxe.block.AndraditeGlass;
import awesomemancam.minersdeluxe.block.AndraditeOre;
import awesomemancam.minersdeluxe.block.AndraditeTorch;
import awesomemancam.minersdeluxe.block.BenitoiteBlock;
import awesomemancam.minersdeluxe.block.BenitoiteOre;
import awesomemancam.minersdeluxe.block.BloodstoneBlock;
import awesomemancam.minersdeluxe.block.BloodstoneOre;
import awesomemancam.minersdeluxe.block.BurningDiamondBlock;
import awesomemancam.minersdeluxe.block.BurningDiamondOre;
import awesomemancam.minersdeluxe.block.DoomShroom;
import awesomemancam.minersdeluxe.block.FireShroom;
import awesomemancam.minersdeluxe.block.GemBlock;
import awesomemancam.minersdeluxe.block.GemFire;
import awesomemancam.minersdeluxe.block.GlowAmethystGlass;
import awesomemancam.minersdeluxe.block.GlowAndraditeGlass;
import awesomemancam.minersdeluxe.block.GlowGlass;
import awesomemancam.minersdeluxe.block.GlowOnyxGlass;
import awesomemancam.minersdeluxe.block.GlowOrthoclaseGlass;
import awesomemancam.minersdeluxe.block.GlowRubyGlass;
import awesomemancam.minersdeluxe.block.GlowSapphireGlass;
import awesomemancam.minersdeluxe.block.GrandCrystal;
import awesomemancam.minersdeluxe.block.GrandMinePortal;
import awesomemancam.minersdeluxe.block.GrandStone;
import awesomemancam.minersdeluxe.block.IridiumBlock;
import awesomemancam.minersdeluxe.block.IridiumOre;
import awesomemancam.minersdeluxe.block.OnyxBlock;
import awesomemancam.minersdeluxe.block.OnyxGlass;
import awesomemancam.minersdeluxe.block.OnyxOre;
import awesomemancam.minersdeluxe.block.OnyxTorch;
import awesomemancam.minersdeluxe.block.OrthoclaseBlock;
import awesomemancam.minersdeluxe.block.OrthoclaseGlass;
import awesomemancam.minersdeluxe.block.OrthoclaseOre;
import awesomemancam.minersdeluxe.block.OrthoclaseTorch;
import awesomemancam.minersdeluxe.block.PyriteBlock;
import awesomemancam.minersdeluxe.block.PyriteOre;
import awesomemancam.minersdeluxe.block.RubyBlock;
import awesomemancam.minersdeluxe.block.RubyGlass;
import awesomemancam.minersdeluxe.block.RubyOre;
import awesomemancam.minersdeluxe.block.RubyTorch;
import awesomemancam.minersdeluxe.block.SapphireBlock;
import awesomemancam.minersdeluxe.block.SapphireGlass;
import awesomemancam.minersdeluxe.block.SapphireOre;
import awesomemancam.minersdeluxe.block.SapphireTorch;
import awesomemancam.minersdeluxe.block.TopazBlock;
import awesomemancam.minersdeluxe.block.TopazOre;
import awesomemancam.minersdeluxe.block.TourmalineBlock;
import awesomemancam.minersdeluxe.block.TourmalineOre;
import awesomemancam.minersdeluxe.entity.EntityBombGem;
import awesomemancam.minersdeluxe.entity.EntityMacroBombGem;
import awesomemancam.minersdeluxe.entity.EntityMicroBombGem;
import awesomemancam.minersdeluxe.entity.EntityMicroMiningBombGem;
import awesomemancam.minersdeluxe.entity.EntityNuclearGem;
import awesomemancam.minersdeluxe.item.Amethyst;
import awesomemancam.minersdeluxe.item.Andradite;
import awesomemancam.minersdeluxe.item.Benitoite;
import awesomemancam.minersdeluxe.item.Bloodstone;
import awesomemancam.minersdeluxe.item.BombGem;
import awesomemancam.minersdeluxe.item.BurningDiamond;
import awesomemancam.minersdeluxe.item.GemDust;
import awesomemancam.minersdeluxe.item.GemFireStarter;
import awesomemancam.minersdeluxe.item.GrandCrystalShard;
import awesomemancam.minersdeluxe.item.Iridium;
import awesomemancam.minersdeluxe.item.MacroBombGem;
import awesomemancam.minersdeluxe.item.MicroBombGem;
import awesomemancam.minersdeluxe.item.MicroMiningBombGem;
import awesomemancam.minersdeluxe.item.NuclearGem;
import awesomemancam.minersdeluxe.item.Onyx;
import awesomemancam.minersdeluxe.item.Orthoclase;
import awesomemancam.minersdeluxe.item.PyriteIngot;
import awesomemancam.minersdeluxe.item.Ruby;
import awesomemancam.minersdeluxe.item.Sapphire;
import awesomemancam.minersdeluxe.item.SteelIngot;
import awesomemancam.minersdeluxe.item.Topaz;
import awesomemancam.minersdeluxe.item.Tourmaline;
import awesomemancam.minersdeluxe.lib.Library;
import awesomemancam.minersdeluxe.mob.EntityAwesomemancam;
import awesomemancam.minersdeluxe.mob.EntityCaveSnake;
import awesomemancam.minersdeluxe.tools.BurningDiamondAxe;
import awesomemancam.minersdeluxe.tools.BurningDiamondHoe;
import awesomemancam.minersdeluxe.tools.BurningDiamondPickaxe;
import awesomemancam.minersdeluxe.tools.BurningDiamondShovel;
import awesomemancam.minersdeluxe.tools.BurningDiamondSword;
import awesomemancam.minersdeluxe.tools.ObsidianAxe;
import awesomemancam.minersdeluxe.tools.ObsidianHoe;
import awesomemancam.minersdeluxe.tools.ObsidianPickaxe;
import awesomemancam.minersdeluxe.tools.ObsidianShovel;
import awesomemancam.minersdeluxe.tools.ObsidianSword;
import awesomemancam.minersdeluxe.tools.SteelAxe;
import awesomemancam.minersdeluxe.tools.SteelHoe;
import awesomemancam.minersdeluxe.tools.SteelPickaxe;
import awesomemancam.minersdeluxe.tools.SteelShovel;
import awesomemancam.minersdeluxe.tools.SteelSword;
import awesomemancam.minersdeluxe.util.Armor;
import awesomemancam.minersdeluxe.world.GrandMineWorldProvider;
import awesomemancam.minersdeluxe.world.WorldGen;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLLoadEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.event.FMLServerStartingEvent;
import cpw.mods.fml.common.network.NetworkMod;
import cpw.mods.fml.common.registry.EntityRegistry;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;

@Mod(modid = Library.MOD.ID, name = Library.MOD.NAME, version = Library.MOD.VERSION)
@NetworkMod(clientSideRequired = true, serverSideRequired = false)
public class MinersDeluxe {

	//Dimension ID Section
	public static int DimensionGrandMineID;

	//Item ID Section
	public static int burningDiamondID;
	public static int amethystID, andraditeID, benitoiteID, bloodstoneID, iridiumID, onyxID, orthoclaseID, pyriteIngotID, rubyID, sapphireID, steelIngotID, topazID, 
						tourmalineID;
	public static int bombGemID, microbombGemID, macrobombGemID, nuclearbombGemID;
	public static int microminingbombGemID;
	public static int gemDustID;
	public static int gemFireStarterID;
	public static int grandCrystalShardID;

	//Tool ID Section
	public static int burningDiamondSwordID, burningDiamondPickaxeID, burningDiamondAxeID, burningDiamondShovelID, burningDiamondHoeID;
	public static int obsidianSwordID, obsidianPickaxeID, obsidianAxeID, obsidianShovelID, obsidianHoeID;
	public static int steelSwordID, steelPickaxeID, steelAxeID, steelShovelID, steelHoeID;

	//Armor ID Section
	public static int burningDiamondHelmetID, burningDiamondChestID, burningDiamondLeggingsID, burningDiamondBootsID;
	public static int steelHelmetID, steelChestID, steelLeggingsID, steelBootsID;
	public static int onyxHelmetID, onyxChestID, onyxLeggingsID, onyxBootsID;
	public static int rubyHelmetID, rubyChestID, rubyLeggingsID, rubyBootsID;
	public static int sapphireHelmetID, sapphireChestID, sapphireLeggingsID, sapphireBootsID;
	public static int amethystHelmetID, amethystChestID, amethystLeggingsID, amethystBootsID;
	public static int andraditeHelmetID, andraditeChestID, andraditeLeggingsID, andraditeBootsID;
	public static int orthoclaseHelmetID, orthoclaseChestID, orthoclaseLeggingsID, orthoclaseBootsID;
	public static int bloodstoneHelmetID, bloodstoneChestID, bloodstoneLeggingsID, bloodstoneBootsID;
	public static int tourmalineHelmetID, tourmalineChestID, tourmalineLeggingsID, tourmalineBootsID;

	//Block ID Section
	public static int burningDiamondOreID;
	public static int burningDiamondBlockID;
	public static int amethystOreID, andraditeOreID, benitoiteOreID, bloodstoneOreID, iridiumOreID, onyxOreID, orthoclaseOreID, pyriteOreID, rubyOreID, sapphireOreID, topazOreID;
	public static int amethystBlockID, andraditeBlockID, benitoiteBlockID, bloodstoneBlockID, iridiumBlockID, onyxBlockID, orthoclaseBlockID, pyriteBlockID, rubyBlockID, sapphireBlockID, topazBlockID;
	public static int amethystTorchID, andraditeTorchID, onyxTorchID, orthoclaseTorchID, rubyTorchID, sapphireTorchID;
	public static int amethystGlassID, andraditeGlassID, onyxGlassID, orthoclaseGlassID, rubyGlassID, sapphireGlassID;
	public static int glowGlassID, glowamethystGlassID, glowandraditeGlassID, glowonyxGlassID, gloworthoclaseGlassID, glowrubyGlassID, glowsapphireGlassID;
	public static int gemBlockID, grandMinePortalID;
	public static int grandStoneID;
	public static int gemFireID;
	public static int grandCrystalID;
	public static int doomShroomID, fireShroomID;
	public static int tourmalineOreID, tourmalineBlockID;

	//Tool Material Section
	public static EnumToolMaterial burningDiamondToolMaterial = 
			EnumHelper.addToolMaterial("BurningDiamondTool", 4, 1500, 12.0F, 6.0F, 15);
	public static EnumToolMaterial obsidianToolMaterial = 
			EnumHelper.addToolMaterial("ObsidianTool", 4, 3000, 8.0F, 2.0F, 4);
	public static EnumToolMaterial steelToolMaterial = 
			EnumHelper.addToolMaterial("SteelTool", 3, 700, 10.0F, 3.0F, 8);

	//Armor Material Section
	public static EnumArmorMaterial burningDiamondArmorMaterial = 
			EnumHelper.addArmorMaterial("BurningDiamondArmor", 66, new int[]{12, 24, 14, 8}, 15);
	public static EnumArmorMaterial steelArmorMaterial = 
			EnumHelper.addArmorMaterial("SteelArmor", 24, new int[]{4, 6, 4, 2}, 8);
	public static EnumArmorMaterial onyxArmorMaterial = 
			EnumHelper.addArmorMaterial("OnyxArmor", 28, new int[]{5, 7, 5, 3}, 8);
	public static EnumArmorMaterial rubyArmorMaterial = 
			EnumHelper.addArmorMaterial("RubyArmor", 28, new int[]{5, 7, 5, 3}, 8);
	public static EnumArmorMaterial sapphireArmorMaterial = 
			EnumHelper.addArmorMaterial("SapphireArmor", 28, new int[]{5, 7, 5, 3}, 8);
	public static EnumArmorMaterial amethystArmorMaterial = 
			EnumHelper.addArmorMaterial("AmethystArmor", 28, new int[]{5, 7, 5, 3}, 8);
	public static EnumArmorMaterial andraditeArmorMaterial = 
			EnumHelper.addArmorMaterial("AndraditeArmor", 28, new int[]{5, 7, 5, 3}, 8);
	public static EnumArmorMaterial orthoclaseArmorMaterial = 
			EnumHelper.addArmorMaterial("OrthoclaseArmor", 28, new int[]{5, 7, 5, 3}, 8);
	public static EnumArmorMaterial bloodstoneArmorMaterial = 
			EnumHelper.addArmorMaterial("BloodstoneArmor", 36, new int[]{7, 9, 7, 5}, 8);
	public static EnumArmorMaterial tourmalineArmorMaterial = 
			EnumHelper.addArmorMaterial("TourmalineArmor", 32, new int[]{6, 8, 6, 4}, 8);

	//Item Section
	public static Item burningDiamond;
	public static Item amethyst, andradite, benitoite, bloodstone, iridium, onyx, orthoclase, pyriteIngot, ruby, sapphire, steelIngot, topaz, tourmaline;
	public static Item bombGem, microbombGem, macrobombGem, nuclearbombGem;
	public static Item microminingbombGem;
	public static Item gemDust;
	public static Item gemFireStarter;
	public static Item grandCrystalShard;

	//Tool Section
	public static Item burningDiamondSword, burningDiamondPickaxe, burningDiamondAxe, burningDiamondShovel, burningDiamondHoe;
	public static Item obsidianSword, obsidianPickaxe, obsidianAxe, obsidianShovel, obsidianHoe;
	public static Item steelSword, steelPickaxe, steelAxe, steelShovel, steelHoe;

	//Armor Section
	public static Item burningDiamondHelmet, burningDiamondChest, burningDiamondLeggings, burningDiamondBoots;
	public static Item steelHelmet, steelChest, steelLeggings, steelBoots;
	public static Item onyxHelmet, onyxChest, onyxLeggings, onyxBoots;
	public static Item rubyHelmet, rubyChest, rubyLeggings, rubyBoots;
	public static Item sapphireHelmet, sapphireChest, sapphireLeggings, sapphireBoots;
	public static Item amethystHelmet, amethystChest, amethystLeggings, amethystBoots;
	public static Item andraditeHelmet, andraditeChest, andraditeLeggings, andraditeBoots;
	public static Item orthoclaseHelmet, orthoclaseChest, orthoclaseLeggings, orthoclaseBoots;
	public static Item bloodstoneHelmet, bloodstoneChest, bloodstoneLeggings, bloodstoneBoots;
	public static Item tourmalineHelmet, tourmalineChest, tourmalineLeggings, tourmalineBoots;

	//Block Section
	public static Block burningDiamondOre;
	public static Block burningDiamondBlock;
	public static Block amethystOre, andraditeOre, benitoiteOre, bloodstoneOre, iridiumOre, onyxOre, orthoclaseOre, pyriteOre, rubyOre, sapphireOre, topazOre;
	public static Block amethystBlock, andraditeBlock, benitoiteBlock, bloodstoneBlock, iridiumBlock, onyxBlock, orthoclaseBlock, pyriteBlock, rubyBlock, sapphireBlock, topazBlock;
	public static Block amethystTorch, andraditeTorch, onyxTorch, orthoclaseTorch, rubyTorch, sapphireTorch;
	public static Block amethystGlass, andraditeGlass, onyxGlass, orthoclaseGlass, rubyGlass, sapphireGlass;
	public static Block glowGlass, glowamethystGlass, glowandraditeGlass, glowonyxGlass, gloworthoclaseGlass, glowrubyGlass, glowsapphireGlass;
	public static Block gemBlock;
	public static Block grandStone;
	public static GrandMinePortal grandMinePortal;
	public static GemFire gemFire;
	public static Block grandCrystal;
	public static BlockFlower doomShroom, fireShroom;
	public static Block tourmalineOre, tourmalineBlock;

	//Biome Section
	public static final BiomeGenBase GrandMineBiome = new GrandMineBiome(Library.BIOME.ID.GRAND_MINE_CAVE);

	//--------------------------------//
	//Mod Instance//
	@Instance(Library.MOD.ID)
	public static MinersDeluxe instance;
	//--------------------------------//
	@SidedProxy(clientSide="awesomemancam.minersdeluxe.client.ClientProxy", serverSide="awesomemancam.minersdeluxe.CommonProxy")
	public static CommonProxy proxy;
	//--------------------------------//


	@EventHandler
	public void preInit(FMLPreInitializationEvent event) {

		this.setupConfiguration(event.getSuggestedConfigurationFile());
		
		//Dimension Management
		DimensionManager.registerProviderType(DimensionGrandMineID, GrandMineWorldProvider.class, true);
		DimensionManager.registerDimension(DimensionGrandMineID, DimensionGrandMineID);

		//World Generator
		GameRegistry.registerWorldGenerator(new WorldGen());

		this.initializeAssets();
		this.setupLanguageRegistry();
		this.setupGameRegistryBlocks();
		this.setupGameRegistryRecipes();
		this.setupMinecraftForge();
		this.setupEntityRegistry();

		//Proxy Registry
		proxy.registerRenderers();
		proxy.registerSounds();
		proxy.registerServerTickHandler();
		proxy.stringLocalization();

		//Event Registry
		MinecraftForge.EVENT_BUS.register(new Event());

	}

	@EventHandler
	public void Init(FMLLoadEvent event) {

	}

	@EventHandler
	public void postInit(FMLPostInitializationEvent event) {

	}

	private void setupConfiguration(File configFile) {
		Configuration config = new Configuration(configFile);

		config.load();
		//DIM IDs
		DimensionGrandMineID = config.get("DIM IDs", "Grand Mine", Library.DIM.GRAND_MINE).getInt();
		
		//Item
		burningDiamondID = config.get("Item IDs", "Burning Diamond", Library.ITEM.ID.burningDiamond).getInt();
		amethystID = config.get("Item IDs", "Amethyst", Library.ITEM.ID.amethyst).getInt();
		andraditeID = config.get("Item IDs", "Andradite", Library.ITEM.ID.andradite).getInt();
		benitoiteID = config.get("Item IDs", "Benitoite", Library.ITEM.ID.benitoite).getInt();
		bloodstoneID = config.get("Item IDs", "Bloodstone", Library.ITEM.ID.bloodstone).getInt();
		iridiumID = config.get("Item IDs", "Iridium", Library.ITEM.ID.iridium).getInt();
		onyxID = config.get("Item IDs", "Onyx", Library.ITEM.ID.onyx).getInt();
		orthoclaseID = config.get("Item IDs", "Orthoclase", Library.ITEM.ID.orthoclase).getInt();
		pyriteIngotID = config.get("Item IDs", "Pyrite Ingot", Library.ITEM.ID.pyriteIngot).getInt();
		rubyID = config.get("Item IDs", "Ruby", Library.ITEM.ID.ruby).getInt();
		sapphireID = config.get("Item IDs", "Sapphire", Library.ITEM.ID.sapphire).getInt();
		steelIngotID = config.get("Item IDs", "Steel Ingot", Library.ITEM.ID.steelIngot).getInt();
		topazID = config.get("Item IDs", "Topaz", Library.ITEM.ID.topaz).getInt();
		microbombGemID = config.get("Item IDs", "Microbomb Gem", Library.ITEM.ID.microbombGem).getInt();
		bombGemID = config.get("Item IDs", "Bomb Gem", Library.ITEM.ID.bombGem).getInt();
		macrobombGemID = config.get("Item IDs", "Macrobomb Gem", Library.ITEM.ID.macrobombGem).getInt();
		nuclearbombGemID = config.get("Item IDs", "Nuclear Gem", Library.ITEM.ID.nuclearbombGem).getInt();
		gemDustID = config.get("Item IDs", "Gem Dust", Library.ITEM.ID.gemDust).getInt();
		gemFireStarterID = config.get("Item IDs", "Gem Fire Starter", Library.ITEM.ID.gemFireStarter).getInt();
		grandCrystalShardID = config.get("Item IDs", "Grand Crystal Shard", Library.ITEM.ID.grandCrystalShard).getInt();
		tourmalineID = config.get("Item IDs", "Tourmaline", Library.ITEM.ID.tourmaline).getInt();
		microminingbombGemID = config.get("Item IDs", "Micro Mining Bomb Gem", Library.ITEM.ID.microminingbombGem).getInt();

		//Tools
		burningDiamondSwordID = config.get("Tool IDs", "Burning Diamond Sword", Library.TOOL.ID.burningDiamondSword).getInt();
		burningDiamondPickaxeID = config.get("Tool IDs", "Burning Diamond Pickaxe", Library.TOOL.ID.burningDiamondPickaxe).getInt();
		burningDiamondAxeID = config.get("Tool IDs", "Burning Diamond Axe", Library.TOOL.ID.burningDiamondAxe).getInt();
		burningDiamondShovelID = config.get("Tool IDs", "Burning Diamond Shovel", Library.TOOL.ID.burningDiamondShovel).getInt();
		burningDiamondHoeID = config.get("Tool IDs", "Burning Diamond Hoe", Library.TOOL.ID.burningDiamondHoe).getInt();
		obsidianSwordID = config.get("Tool IDs", "Obsidian Sword", Library.TOOL.ID.obsidianSword).getInt();
		obsidianPickaxeID = config.get("Tool IDs", "Obsidian Pickaxe", Library.TOOL.ID.obsidianPickaxe).getInt();
		obsidianAxeID = config.get("Tool IDs", "Obsidian Axe", Library.TOOL.ID.obsidianAxe).getInt();
		obsidianShovelID = config.get("Tool IDs", "Obsidian Shovel", Library.TOOL.ID.obsidianShovel).getInt();
		obsidianHoeID = config.get("Tool IDs", "Obsidian Hoe", Library.TOOL.ID.obsidianHoe).getInt();
		steelSwordID = config.get("Tool IDs", "Steel Sword", Library.TOOL.ID.steelSword).getInt();
		steelPickaxeID = config.get("Tool IDs", "Steel Pickaxe", Library.TOOL.ID.steelPickaxe).getInt();
		steelAxeID = config.get("Tool IDs", "Steel Axe", Library.TOOL.ID.steelAxe).getInt();
		steelShovelID = config.get("Tool IDs", "Steel Shovel", Library.TOOL.ID.steelShovel).getInt();
		steelHoeID = config.get("Tool IDs", "Steel Hoe", Library.TOOL.ID.steelHoe).getInt();

		//Armor
		burningDiamondHelmetID = config.get("Armor IDs", "Burning Diamond Helmet ID", Library.ARMOR.ID.burningDiamondHelmet).getInt();
		burningDiamondChestID = config.get("Armor IDs", "Burning Diamond Chest ID", Library.ARMOR.ID.burningDiamondChest).getInt();
		burningDiamondLeggingsID = config.get("Armor IDs", "Burning Diamond Leggings ID", Library.ARMOR.ID.burningDiamondLeggings).getInt();
		burningDiamondBootsID = config.get("Armor IDs", "Burning Diamond Boots ID", Library.ARMOR.ID.burningDiamondBoots).getInt();
		steelHelmetID = config.get("Armor IDs", "Steel Helmet ID", Library.ARMOR.ID.steelHelmet).getInt();
		steelChestID = config.get("Armor IDs", "Steel Chest ID", Library.ARMOR.ID.steelChest).getInt();
		steelLeggingsID = config.get("Armor IDs", "Steel Leggings ID", Library.ARMOR.ID.steelLeggings).getInt();
		steelBootsID = config.get("Armor IDs", "Steel Boots ID", Library.ARMOR.ID.steelBoots).getInt();
		onyxHelmetID = config.get("Armor IDs", "Onyx Helmet ID", Library.ARMOR.ID.onyxHelmet).getInt();
		onyxChestID = config.get("Armor IDs", "Onyx Chest ID", Library.ARMOR.ID.onyxChest).getInt();
		onyxLeggingsID = config.get("Armor IDs", "Onyx Leggings ID", Library.ARMOR.ID.onyxLeggings).getInt();
		onyxBootsID = config.get("Armor IDs", "Onyx Boots ID", Library.ARMOR.ID.onyxBoots).getInt();
		rubyHelmetID = config.get("Armor IDs", "Ruby Helmet ID", Library.ARMOR.ID.rubyHelmet).getInt();
		rubyChestID = config.get("Armor IDs", "Ruby Chest ID", Library.ARMOR.ID.rubyChest).getInt();
		rubyLeggingsID = config.get("Armor IDs", "Ruby Leggings ID", Library.ARMOR.ID.rubyLeggings).getInt();
		rubyBootsID = config.get("Armor IDs", "Ruby Boots ID", Library.ARMOR.ID.rubyBoots).getInt();
		sapphireHelmetID = config.get("Armor IDs", "Sapphire Helmet ID", Library.ARMOR.ID.sapphireHelmet).getInt();
		sapphireChestID = config.get("Armor IDs", "Sapphire Chest ID", Library.ARMOR.ID.sapphireChest).getInt();
		sapphireLeggingsID = config.get("Armor IDs", "Sapphire Leggings ID", Library.ARMOR.ID.sapphireLeggings).getInt();
		sapphireBootsID = config.get("Armor IDs", "Sapphire Boots ID", Library.ARMOR.ID.sapphireBoots).getInt();
		amethystHelmetID = config.get("Armor IDs", "Amethyst Helmet ID", Library.ARMOR.ID.amethystHelmet).getInt();
		amethystChestID = config.get("Armor IDs", "Amethyst Chest ID", Library.ARMOR.ID.amethystChest).getInt();
		amethystLeggingsID = config.get("Armor IDs", "Amethyst Leggings ID", Library.ARMOR.ID.amethystLeggings).getInt();
		amethystBootsID = config.get("Armor IDs", "Amethyst Boots ID", Library.ARMOR.ID.amethystBoots).getInt();
		andraditeHelmetID = config.get("Armor IDs", "Andradite Helmet ID", Library.ARMOR.ID.andraditeHelmet).getInt();
		andraditeChestID = config.get("Armor IDs", "Andradite Chest ID", Library.ARMOR.ID.andraditeChest).getInt();
		andraditeLeggingsID = config.get("Armor IDs", "Andradite Leggings ID", Library.ARMOR.ID.andraditeLeggings).getInt();
		andraditeBootsID = config.get("Armor IDs", "Andradite Boots ID", Library.ARMOR.ID.andraditeBoots).getInt();
		orthoclaseHelmetID = config.get("Armor IDs", "Orthoclase Helmet ID", Library.ARMOR.ID.orthoclaseHelmet).getInt();
		orthoclaseChestID = config.get("Armor IDs", "Orthoclase Chest ID", Library.ARMOR.ID.orthoclaseChest).getInt();
		orthoclaseLeggingsID = config.get("Armor IDs", "Orthoclase Leggings ID", Library.ARMOR.ID.orthoclaseLeggings).getInt();
		orthoclaseBootsID = config.get("Armor IDs", "Orthoclase Boots ID", Library.ARMOR.ID.orthoclaseBoots).getInt();
		bloodstoneHelmetID = config.get("Armor IDs", "Bloodstone Helmet ID", Library.ARMOR.ID.bloodstoneHelmet).getInt();
		bloodstoneChestID = config.get("Armor IDs", "Bloodstone Chest ID", Library.ARMOR.ID.bloodstoneChest).getInt();
		bloodstoneLeggingsID = config.get("Armor IDs", "Bloodstone Leggings ID", Library.ARMOR.ID.bloodstoneLeggings).getInt();
		bloodstoneBootsID = config.get("Armor IDs", "Bloodstone Boots ID", Library.ARMOR.ID.bloodstoneBoots).getInt();
		tourmalineHelmetID = config.get("Armor IDs", "Tourmaline Helmet ID", Library.ARMOR.ID.tourmalineHelmet).getInt();
		tourmalineChestID = config.get("Armor IDs", "Tourmaline Chest ID", Library.ARMOR.ID.tourmalineChest).getInt();
		tourmalineLeggingsID = config.get("Armor IDs", "Tourmaline Leggings ID", Library.ARMOR.ID.tourmalineLeggings).getInt();
		tourmalineBootsID = config.get("Armor IDs", "Tourmaline Boots ID", Library.ARMOR.ID.tourmalineBoots).getInt();

		//Block
		burningDiamondOreID = config.get("Block IDs", "Burning Diamond Ore ID", Library.BLOCK.ID.burningDiamondOre).getInt();
		amethystOreID = config.get("Block IDs", "Amethyst Ore ID", Library.BLOCK.ID.amethystOre).getInt();
		andraditeOreID = config.get("Block IDs", "Andradite Ore ID", Library.BLOCK.ID.andraditeOre).getInt();
		benitoiteOreID = config.get("Block IDs", "Benitoite Ore ID", Library.BLOCK.ID.benitoiteOre).getInt();
		bloodstoneOreID = config.get("Block IDs", "Bloodstone Ore ID", Library.BLOCK.ID.bloodstoneOre).getInt();
		iridiumOreID = config.get("Block IDs", "Iridium Ore ID", Library.BLOCK.ID.iridiumOre).getInt();
		onyxOreID = config.get("Block IDs", "Onyx Ore ID", Library.BLOCK.ID.onyxOre).getInt();
		orthoclaseOreID = config.get("Block IDs", "Orthoclase Ore ID", Library.BLOCK.ID.orthoclaseOre).getInt();
		pyriteOreID = config.get("Block IDs", "Pyrite Ore ID", Library.BLOCK.ID.pyriteOre).getInt();
		rubyOreID = config.get("Block IDs", "Ruby Ore ID", Library.BLOCK.ID.rubyOre).getInt();
		sapphireOreID = config.get("Block IDs", "Sapphire Ore ID", Library.BLOCK.ID.sapphireOre).getInt();
		topazOreID = config.get("Block IDs", "Topaz Ore ID", Library.BLOCK.ID.topazOre).getInt();
		burningDiamondBlockID = config.get("Block IDs", "Burning Diamond Block ID", Library.BLOCK.ID.burningDiamondBlock).getInt();
		amethystBlockID = config.get("Block IDs", "Amethyst Block ID", Library.BLOCK.ID.amethystBlock).getInt();
		andraditeBlockID = config.get("Block IDs", "Andradite Block ID", Library.BLOCK.ID.andraditeBlock).getInt();
		benitoiteBlockID = config.get("Block IDs", "Benitoite Block ID", Library.BLOCK.ID.benitoiteBlock).getInt();
		bloodstoneBlockID = config.get("Block IDs", "Bloodstone Block ID", Library.BLOCK.ID.bloodstoneBlock).getInt();
		iridiumBlockID = config.get("Block IDs", "Iridium Block ID", Library.BLOCK.ID.iridiumBlock).getInt();
		onyxBlockID = config.get("Block IDs", "Onyx Block ID", Library.BLOCK.ID.onyxBlock).getInt();
		orthoclaseBlockID = config.get("Block IDs", "Orthoclase Block ID", Library.BLOCK.ID.orthoclaseBlock).getInt();
		pyriteBlockID = config.get("Block IDs", "Pyrite Block ID", Library.BLOCK.ID.pyriteBlock).getInt();
		rubyBlockID = config.get("Block IDs", "Ruby Block ID", Library.BLOCK.ID.rubyBlock).getInt();
		sapphireBlockID = config.get("Block IDs", "Sapphire Block ID", Library.BLOCK.ID.sapphireBlock).getInt();
		topazBlockID = config.get("Block IDs", "Topaz Block ID", Library.BLOCK.ID.topazBlock).getInt();
		amethystTorchID = config.get("Block IDs", "Amethyst Torch ID", Library.BLOCK.ID.amethystTorch).getInt();
		andraditeTorchID = config.get("Block IDs", "Andradite Torch ID", Library.BLOCK.ID.andraditeTorch).getInt();
		onyxTorchID = config.get("Block IDs", "Onyx Torch ID", Library.BLOCK.ID.onyxTorch).getInt();
		orthoclaseTorchID = config.get("Block IDs", "Orthoclase Torch ID", Library.BLOCK.ID.orthoclaseTorch).getInt();
		rubyTorchID = config.get("Block IDs", "Ruby Torch ID", Library.BLOCK.ID.rubyTorch).getInt();
		sapphireTorchID = config.get("Block IDs", "Sapphire Torch ID", Library.BLOCK.ID.sapphireTorch).getInt();
		amethystGlassID = config.get("Block IDs", "Amethyst Glass ID", Library.BLOCK.ID.amethystGlass).getInt();
		andraditeGlassID = config.get("Block IDs", "Andradite Glass ID", Library.BLOCK.ID.andraditeGlass).getInt();
		onyxGlassID = config.get("Block IDs", "Onyx Glass ID", Library.BLOCK.ID.onyxGlass).getInt();
		orthoclaseGlassID = config.get("Block IDs", "Orthoclase Glass ID", Library.BLOCK.ID.orthoclaseGlass).getInt();
		rubyGlassID = config.get("Block IDs", "Ruby Glass ID", Library.BLOCK.ID.rubyGlass).getInt();
		sapphireGlassID = config.get("Block IDs", "Sapphire Glass ID", Library.BLOCK.ID.sapphireGlass).getInt();
		gemBlockID = config.get("Block IDs", "Gem Block ID", Library.BLOCK.ID.gemBlock).getInt();
		grandMinePortalID = config.get("Block IDs", "Grand Mine Portal Block ID", Library.BLOCK.ID.grandMinePortal).getInt();
		glowGlassID = config.get("Block IDs", "Glow Glass ID", Library.BLOCK.ID.glowGlass).getInt();
		glowamethystGlassID = config.get("Block IDs", "Glow Amethyst Glass ID", Library.BLOCK.ID.glowamethystGlass).getInt();
		glowandraditeGlassID = config.get("Block IDs", "Glow Andradite Glass ID", Library.BLOCK.ID.glowandraditeGlass).getInt();
		glowonyxGlassID = config.get("Block IDs", "Glow Onyx Glass ID", Library.BLOCK.ID.glowonyxGlass).getInt();
		gloworthoclaseGlassID = config.get("Block IDs", "Glow Orthoclase Glass ID", Library.BLOCK.ID.gloworthoclaseGlass).getInt();
		glowrubyGlassID = config.get("Block IDs", "Glow Ruby Glass ID", Library.BLOCK.ID.glowrubyGlass).getInt();
		glowsapphireGlassID = config.get("Block IDs", "Glow Sapphire Glass ID", Library.BLOCK.ID.glowsapphireGlass).getInt();
		grandStoneID = config.get("Block IDs", "GrandStone ID", Library.BLOCK.ID.grandStone).getInt();
		gemFireID = config.get("Block IDs", "Gem Fire", Library.BLOCK.ID.gemFire).getInt();
		grandCrystalID = config.get("Block IDs", "Grand Crystal", Library.BLOCK.ID.grandCrystal).getInt();
		doomShroomID = config.get("Block IDs", "Doom Shroom", Library.BLOCK.ID.doomShroom).getInt();
		fireShroomID = config.get("Block IDs", "Fire Shroom", Library.BLOCK.ID.fireShroom).getInt();
		tourmalineOreID = config.get("Block IDs", "Tourmaline Ore", Library.BLOCK.ID.tourmalineOre).getInt();
		tourmalineBlockID = config.get("Block IDs", "Tourmaline Block", Library.BLOCK.ID.tourmalineBlock).getInt();

		config.save();
	}

	private void initializeAssets() {
		//Initialize Items
		burningDiamond = new BurningDiamond(burningDiamondID);
		amethyst = new Amethyst(amethystID);
		andradite = new Andradite(andraditeID);
		benitoite = new Benitoite(benitoiteID);
		bloodstone = new Bloodstone(bloodstoneID);
		iridium = new Iridium(iridiumID);
		onyx = new Onyx(onyxID);
		orthoclase = new Orthoclase(orthoclaseID);
		pyriteIngot = new PyriteIngot(pyriteIngotID);
		ruby = new Ruby(rubyID);
		sapphire = new Sapphire(sapphireID);
		steelIngot = new SteelIngot(steelIngotID);
		topaz = new Topaz(topazID);
		microbombGem = new MicroBombGem(microbombGemID);
		bombGem = new BombGem(bombGemID);
		macrobombGem = new MacroBombGem(macrobombGemID);
		nuclearbombGem = new NuclearGem(nuclearbombGemID);
		gemDust = new GemDust(gemDustID);
		gemFireStarter = new GemFireStarter(Library.ITEM.ID.gemFireStarter);
		grandCrystalShard = new GrandCrystalShard(grandCrystalShardID);
		tourmaline = new Tourmaline(tourmalineID);
		microminingbombGem = new MicroMiningBombGem(microminingbombGemID);

		//Initialize Tools
		burningDiamondSword = new BurningDiamondSword(burningDiamondSwordID, burningDiamondToolMaterial);
		burningDiamondPickaxe = new BurningDiamondPickaxe(burningDiamondPickaxeID, burningDiamondToolMaterial);
		burningDiamondAxe = new BurningDiamondAxe(burningDiamondAxeID, burningDiamondToolMaterial);
		burningDiamondShovel = new BurningDiamondShovel(burningDiamondShovelID, burningDiamondToolMaterial);
		burningDiamondHoe = new BurningDiamondHoe(burningDiamondHoeID, burningDiamondToolMaterial);
		obsidianSword = new ObsidianSword(obsidianSwordID, obsidianToolMaterial);
		obsidianPickaxe = new ObsidianPickaxe(obsidianPickaxeID, obsidianToolMaterial);
		obsidianAxe = new ObsidianAxe(obsidianAxeID, obsidianToolMaterial);
		obsidianShovel = new ObsidianShovel(obsidianShovelID, obsidianToolMaterial);
		obsidianHoe = new ObsidianHoe(obsidianHoeID, obsidianToolMaterial);
		steelSword = new SteelSword(steelSwordID, steelToolMaterial);
		steelPickaxe = new SteelPickaxe(steelPickaxeID, steelToolMaterial);
		steelAxe = new SteelAxe(steelAxeID, steelToolMaterial);
		steelShovel = new SteelShovel(steelShovelID, steelToolMaterial);
		steelHoe = new SteelHoe(steelHoeID, steelToolMaterial);

		//Initialize Armor
		burningDiamondHelmet = new Armor(burningDiamondHelmetID, burningDiamondArmorMaterial, 0, 0, "burningdiamond");
		burningDiamondChest = new Armor(burningDiamondChestID, burningDiamondArmorMaterial, 0, 1, "burningdiamond");
		burningDiamondLeggings = new Armor(burningDiamondLeggingsID, burningDiamondArmorMaterial, 0, 2, "burningdiamond");
		burningDiamondBoots = new Armor(burningDiamondBootsID, burningDiamondArmorMaterial, 0, 3, "burningdiamond");
		steelHelmet = new Armor(steelHelmetID, steelArmorMaterial, 0, 0, "steel");
		steelChest = new Armor(steelChestID, steelArmorMaterial, 0, 1, "steel");
		steelLeggings = new Armor(steelLeggingsID, steelArmorMaterial, 0, 2, "steel");
		steelBoots = new Armor(steelBootsID, steelArmorMaterial, 0, 3, "steel");
		onyxHelmet = new Armor(onyxHelmetID, onyxArmorMaterial, 0, 0, "onyx");
		onyxChest = new Armor(onyxChestID, onyxArmorMaterial, 0, 1, "onyx");
		onyxLeggings = new Armor(onyxLeggingsID, onyxArmorMaterial, 0, 2, "onyx");
		onyxBoots = new Armor(onyxBootsID, onyxArmorMaterial, 0, 3, "onyx");
		rubyHelmet = new Armor(rubyHelmetID, rubyArmorMaterial, 0, 0, "ruby");
		rubyChest = new Armor(rubyChestID, rubyArmorMaterial, 0, 1, "ruby");
		rubyLeggings = new Armor(rubyLeggingsID, rubyArmorMaterial, 0, 2, "ruby");
		rubyBoots = new Armor(rubyBootsID, rubyArmorMaterial, 0, 3, "ruby");
		sapphireHelmet = new Armor(sapphireHelmetID, sapphireArmorMaterial, 0, 0, "sapphire");
		sapphireChest = new Armor(sapphireChestID, sapphireArmorMaterial, 0, 1, "sapphire");
		sapphireLeggings = new Armor(sapphireLeggingsID, sapphireArmorMaterial, 0, 2, "sapphire");
		sapphireBoots = new Armor(sapphireBootsID, sapphireArmorMaterial, 0, 3, "sapphire");
		amethystHelmet = new Armor(amethystHelmetID, amethystArmorMaterial, 0, 0, "amethyst");
		amethystChest = new Armor(amethystChestID, amethystArmorMaterial, 0, 1, "amethyst");
		amethystLeggings = new Armor(amethystLeggingsID, amethystArmorMaterial, 0, 2, "amethyst");
		amethystBoots = new Armor(amethystBootsID, amethystArmorMaterial, 0, 3, "amethyst");
		andraditeHelmet = new Armor(andraditeHelmetID, andraditeArmorMaterial, 0, 0, "andradite");
		andraditeChest = new Armor(andraditeChestID, andraditeArmorMaterial, 0, 1, "andradite");
		andraditeLeggings = new Armor(andraditeLeggingsID, andraditeArmorMaterial, 0, 2, "andradite");
		andraditeBoots = new Armor(andraditeBootsID, andraditeArmorMaterial, 0, 3, "andradite");
		orthoclaseHelmet = new Armor(orthoclaseHelmetID, orthoclaseArmorMaterial, 0, 0, "orthoclase");
		orthoclaseChest = new Armor(orthoclaseChestID, orthoclaseArmorMaterial, 0, 1, "orthoclase");
		orthoclaseLeggings = new Armor(orthoclaseLeggingsID, orthoclaseArmorMaterial, 0, 2, "orthoclase");
		orthoclaseBoots = new Armor(orthoclaseBootsID, orthoclaseArmorMaterial, 0, 3, "orthoclase");
		bloodstoneHelmet = new Armor(bloodstoneHelmetID, bloodstoneArmorMaterial, 0, 0, "bloodstone");
		bloodstoneChest = new Armor(bloodstoneChestID, bloodstoneArmorMaterial, 0, 1, "bloodstone");
		bloodstoneLeggings = new Armor(bloodstoneLeggingsID, bloodstoneArmorMaterial, 0, 2, "bloodstone");
		bloodstoneBoots = new Armor(bloodstoneBootsID, bloodstoneArmorMaterial, 0, 3, "bloodstone");
		tourmalineHelmet = new Armor(tourmalineHelmetID, tourmalineArmorMaterial, 0, 0, "tourmaline");
		tourmalineChest = new Armor(tourmalineChestID, tourmalineArmorMaterial, 0, 1, "tourmaline");
		tourmalineLeggings = new Armor(tourmalineLeggingsID, tourmalineArmorMaterial, 0, 2, "tourmaline");
		tourmalineBoots = new Armor(tourmalineBootsID, tourmalineArmorMaterial, 0, 3, "tourmaline");

		//Initialize Blocks
		burningDiamondOre = new BurningDiamondOre(burningDiamondOreID);
		amethystOre = new AmethystOre(amethystOreID);
		andraditeOre = new AndraditeOre(andraditeOreID);
		benitoiteOre = new BenitoiteOre(benitoiteOreID);
		bloodstoneOre = new BloodstoneOre(bloodstoneOreID);
		iridiumOre = new IridiumOre(iridiumOreID);
		onyxOre = new OnyxOre(onyxOreID);
		orthoclaseOre = new OrthoclaseOre(orthoclaseOreID);
		pyriteOre = new PyriteOre(pyriteOreID);
		rubyOre = new RubyOre(rubyOreID);
		sapphireOre = new SapphireOre(sapphireOreID);
		topazOre = new TopazOre(topazOreID);
		tourmalineOre = new TourmalineOre(tourmalineOreID);
		burningDiamondBlock = new BurningDiamondBlock(burningDiamondBlockID, Material.rock);
		amethystBlock = new AmethystBlock(amethystBlockID, Material.rock);
		andraditeBlock = new AndraditeBlock(andraditeBlockID, Material.rock);
		benitoiteBlock = new BenitoiteBlock(benitoiteBlockID, Material.rock);
		bloodstoneBlock = new BloodstoneBlock(bloodstoneBlockID, Material.rock);
		iridiumBlock = new IridiumBlock(iridiumBlockID, Material.rock);
		onyxBlock = new OnyxBlock(onyxBlockID, Material.rock);
		orthoclaseBlock = new OrthoclaseBlock(orthoclaseBlockID, Material.rock);
		pyriteBlock = new PyriteBlock(pyriteBlockID, Material.rock);
		rubyBlock = new RubyBlock(rubyBlockID, Material.rock);
		sapphireBlock = new SapphireBlock(sapphireBlockID, Material.rock);
		topazBlock = new TopazBlock(topazBlockID, Material.rock);
		tourmalineBlock = new TourmalineBlock(tourmalineID, Material.rock);
		amethystTorch = new AmethystTorch(amethystTorchID);
		andraditeTorch = new AndraditeTorch(andraditeTorchID);
		onyxTorch = new OnyxTorch(onyxTorchID);
		orthoclaseTorch = new OrthoclaseTorch(orthoclaseTorchID);
		rubyTorch = new RubyTorch(rubyTorchID);
		sapphireTorch = new SapphireTorch(sapphireTorchID);
		amethystGlass = new AmethystGlass(amethystGlassID, Material.glass, false);
		andraditeGlass = new AndraditeGlass(andraditeGlassID, Material.glass, false);
		onyxGlass = new OnyxGlass(onyxGlassID, Material.glass, false);
		orthoclaseGlass = new OrthoclaseGlass(orthoclaseGlassID, Material.glass, false);
		rubyGlass = new RubyGlass(rubyGlassID, Material.glass, false);
		sapphireGlass = new SapphireGlass(sapphireGlassID, Material.glass, false);
		gemBlock = new GemBlock(gemBlockID, Material.rock);
		glowamethystGlass = new GlowAmethystGlass(glowamethystGlassID, Material.glass, false);
		glowandraditeGlass = new GlowAndraditeGlass(glowandraditeGlassID, Material.glass, false);
		glowonyxGlass = new GlowOnyxGlass(glowonyxGlassID, Material.glass, false);
		gloworthoclaseGlass = new GlowOrthoclaseGlass(gloworthoclaseGlassID, Material.glass, false);
		glowrubyGlass = new GlowRubyGlass(glowrubyGlassID, Material.glass, false);
		glowsapphireGlass = new GlowSapphireGlass(glowsapphireGlassID, Material.glass, false);
		glowGlass = new GlowGlass(glowGlassID, Material.glass, false);
		grandStone = new GrandStone(grandStoneID, Material.ground);
		grandMinePortal = (GrandMinePortal)new GrandMinePortal(Library.BLOCK.ID.grandMinePortal);
		gemFire = (GemFire)new GemFire(Library.BLOCK.ID.gemFire);
		grandCrystal = new GrandCrystal(grandCrystalID, Material.glass);
		doomShroom = new DoomShroom(doomShroomID, Material.plants);
		fireShroom = new FireShroom(fireShroomID, Material.plants);

	}

	private void setupLanguageRegistry() {

		//Item Registry
		LanguageRegistry.addName(burningDiamond, "Burning Diamond");
		LanguageRegistry.addName(amethyst, "Amethyst");
		LanguageRegistry.addName(andradite, "Andradite");
		LanguageRegistry.addName(benitoite, "Benitoite");
		LanguageRegistry.addName(bloodstone, "Bloodstone");
		LanguageRegistry.addName(iridium, "Iridium");
		LanguageRegistry.addName(onyx, "Onyx");
		LanguageRegistry.addName(orthoclase, "Orthoclase");
		LanguageRegistry.addName(pyriteIngot, "Pyrite Ingot");
		LanguageRegistry.addName(ruby, "Ruby");
		LanguageRegistry.addName(sapphire, "Sapphire");
		LanguageRegistry.addName(steelIngot, "Steel Ingot");
		LanguageRegistry.addName(topaz, "Topaz");
		LanguageRegistry.addName(microbombGem, "Microbomb Gem");
		LanguageRegistry.addName(macrobombGem, "Macrobomb Gem");
		LanguageRegistry.addName(nuclearbombGem, "Nuclear Gem");
		LanguageRegistry.addName(bombGem, "Bomb Gem");
		LanguageRegistry.addName(gemDust, "Gem Dust");
		LanguageRegistry.addName(gemFireStarter, "Gem Fire Starter");
		LanguageRegistry.addName(grandCrystalShard, "Grand Crystal Shard");
		LanguageRegistry.addName(tourmaline, "Tourmaline");
		LanguageRegistry.addName(microminingbombGem, "Micro Mining Bomb Gem");

		//Tool Registry
		LanguageRegistry.addName(burningDiamondSword, "Burning Diamond Sword");
		LanguageRegistry.addName(burningDiamondPickaxe, "Burning Diamond Pickaxe");
		LanguageRegistry.addName(burningDiamondAxe, "Burning Diamond Axe");
		LanguageRegistry.addName(burningDiamondShovel, "Burning Diamond Shovel");
		LanguageRegistry.addName(burningDiamondHoe, "Burning Diamond Hoe");
		LanguageRegistry.addName(obsidianSword, "Obsidian Sword");
		LanguageRegistry.addName(obsidianPickaxe, "Obsidian Pickaxe");
		LanguageRegistry.addName(obsidianAxe, "Obsidian Axe");
		LanguageRegistry.addName(obsidianShovel, "Obsidian Shovel");
		LanguageRegistry.addName(obsidianHoe, "Obsidian Hoe");
		LanguageRegistry.addName(steelSword, "Steel Sword");
		LanguageRegistry.addName(steelPickaxe, "Steel Pickaxe");
		LanguageRegistry.addName(steelAxe, "Steel Axe");
		LanguageRegistry.addName(steelShovel, "Steel Shovel");
		LanguageRegistry.addName(steelHoe, "Steel Hoe");

		//Armor Registry
		LanguageRegistry.addName(burningDiamondHelmet, "Burning Diamond Helmet");
		LanguageRegistry.addName(burningDiamondChest, "Burning Diamond Chest");
		LanguageRegistry.addName(burningDiamondLeggings, "Burning Diamond Leggings");
		LanguageRegistry.addName(burningDiamondBoots, "Burning Diamond Boots");
		LanguageRegistry.addName(steelHelmet, "Steel Helmet");
		LanguageRegistry.addName(steelChest, "Steel Chest");
		LanguageRegistry.addName(steelLeggings, "Steel Leggings");
		LanguageRegistry.addName(steelBoots, "Steel Boots");
		LanguageRegistry.addName(onyxHelmet, "Onyx Helmet");
		LanguageRegistry.addName(onyxChest, "Onyx Chest");
		LanguageRegistry.addName(onyxLeggings, "Onyx Leggings");
		LanguageRegistry.addName(onyxBoots, "Onyx Boots");
		LanguageRegistry.addName(rubyHelmet, "Ruby Helmet");
		LanguageRegistry.addName(rubyChest, "Ruby Chest");
		LanguageRegistry.addName(rubyLeggings, "Ruby Leggings");
		LanguageRegistry.addName(rubyBoots, "Ruby Boots");
		LanguageRegistry.addName(sapphireHelmet, "Sapphire Helmet");
		LanguageRegistry.addName(sapphireChest, "Sapphire Chest");
		LanguageRegistry.addName(sapphireLeggings, "Sapphire Leggings");
		LanguageRegistry.addName(sapphireBoots, "Sapphire Boots");
		LanguageRegistry.addName(amethystHelmet, "Amethyst Helmet");
		LanguageRegistry.addName(amethystChest, "Amethyst Chest");
		LanguageRegistry.addName(amethystLeggings, "Amethyst Leggings");
		LanguageRegistry.addName(amethystBoots, "Amethyst Boots");
		LanguageRegistry.addName(andraditeHelmet, "Andradite Helmet");
		LanguageRegistry.addName(andraditeChest, "Andradite Chest");
		LanguageRegistry.addName(andraditeLeggings, "Andradite Leggings");
		LanguageRegistry.addName(andraditeBoots, "Andradite Boots");
		LanguageRegistry.addName(orthoclaseHelmet, "Orthoclase Helmet");
		LanguageRegistry.addName(orthoclaseChest, "Orthoclase Chest");
		LanguageRegistry.addName(orthoclaseLeggings, "Orthoclase Leggings");
		LanguageRegistry.addName(orthoclaseBoots, "Orthoclase Boots");
		LanguageRegistry.addName(bloodstoneHelmet, "Bloodstone Helmet");
		LanguageRegistry.addName(bloodstoneChest, "Bloodstone Chest");
		LanguageRegistry.addName(bloodstoneLeggings, "Bloodstone Leggings");
		LanguageRegistry.addName(bloodstoneBoots, "Bloodstone Boots");
		LanguageRegistry.addName(tourmalineHelmet, "Tourmaline Helmet");
		LanguageRegistry.addName(tourmalineChest, "Tourmaline Chest");
		LanguageRegistry.addName(tourmalineLeggings, "Tourmaline Leggings");
		LanguageRegistry.addName(tourmalineBoots, "Tourmaline Boots");

		//Block Registry
		LanguageRegistry.addName(burningDiamondOre, "Burning Diamond Ore");
		LanguageRegistry.addName(amethystOre, "Amethyst Ore");
		LanguageRegistry.addName(pyriteOre, "Pyrite Ore");
		LanguageRegistry.addName(topazOre, "Topaz Ore");
		LanguageRegistry.addName(andraditeOre, "Andradite Ore");
		LanguageRegistry.addName(orthoclaseOre, "Orthoclase Ore");
		LanguageRegistry.addName(iridiumOre, "Iridium Ore");
		LanguageRegistry.addName(bloodstoneOre, "Bloodstone Ore");
		LanguageRegistry.addName(rubyOre, "Ruby Ore");
		LanguageRegistry.addName(onyxOre, "Onyx Ore");
		LanguageRegistry.addName(sapphireOre, "Sapphire Ore");
		LanguageRegistry.addName(benitoiteOre, "Benitoite Ore");
		LanguageRegistry.addName(burningDiamondBlock, "Burning Diamond Block");
		LanguageRegistry.addName(amethystBlock, "Amethyst Block");
		LanguageRegistry.addName(pyriteBlock, "Pyrite Block");
		LanguageRegistry.addName(topazBlock, "Topaz Block");
		LanguageRegistry.addName(andraditeBlock, "Andradite Block");
		LanguageRegistry.addName(orthoclaseBlock, "Orthoclase Block");
		LanguageRegistry.addName(iridiumBlock, "Iridium Block");
		LanguageRegistry.addName(bloodstoneBlock, "Bloodstone Block");
		LanguageRegistry.addName(rubyBlock, "Ruby Block");
		LanguageRegistry.addName(onyxBlock, "Onyx Block");
		LanguageRegistry.addName(sapphireBlock, "Sapphire Block");
		LanguageRegistry.addName(benitoiteBlock, "Benitoite Block");
		LanguageRegistry.addName(amethystTorch, "Amethyst Torch");
		LanguageRegistry.addName(andraditeTorch, "Andradite Torch");
		LanguageRegistry.addName(onyxTorch, "Onyx Torch");
		LanguageRegistry.addName(orthoclaseTorch, "Orthoclase Torch");
		LanguageRegistry.addName(rubyTorch, "Ruby Torch");
		LanguageRegistry.addName(sapphireTorch, "Sapphire Torch");
		LanguageRegistry.addName(amethystGlass, "Amethyst Glass");
		LanguageRegistry.addName(andraditeGlass, "Andradite Glass");
		LanguageRegistry.addName(onyxGlass, "Onyx Glass");
		LanguageRegistry.addName(orthoclaseGlass, "Orthoclase Glass");
		LanguageRegistry.addName(rubyGlass, "Ruby Glass");
		LanguageRegistry.addName(sapphireGlass, "Sapphire Glass");
		LanguageRegistry.addName(gemBlock, "Gem Block");
		LanguageRegistry.addName(glowamethystGlass, "Glow Amethyst Glass");
		LanguageRegistry.addName(glowandraditeGlass, "Glow Andradite Glass");
		LanguageRegistry.addName(glowonyxGlass, "Glow Onyx Glass");
		LanguageRegistry.addName(gloworthoclaseGlass, "Glow Orthoclase Glass");
		LanguageRegistry.addName(glowrubyGlass, "Glow Ruby Glass");
		LanguageRegistry.addName(glowsapphireGlass, "Glow Sapphire Glass");
		LanguageRegistry.addName(glowGlass, "Glow Glass");
		LanguageRegistry.addName(grandStone, "Grand Stone");
		LanguageRegistry.addName(gemFire, "Gem Fire");
		LanguageRegistry.addName(grandMinePortal, "Grand Mine Portal");
		LanguageRegistry.addName(grandCrystal, "Grand Crystal");
		LanguageRegistry.addName(doomShroom, "Doom Shroom");
		LanguageRegistry.addName(fireShroom, "Fire Shroom");
		LanguageRegistry.addName(tourmalineBlock, "Tourmaline Block");
		LanguageRegistry.addName(tourmalineOre, "Tourmaline Ore");

	}

	private void setupGameRegistryBlocks() {

		//Block Registry
		GameRegistry.registerBlock(burningDiamondOre, Library.BLOCK.U_NAME.burningDiamondOre);
		GameRegistry.registerBlock(amethystOre, Library.BLOCK.U_NAME.amethystOre);
		GameRegistry.registerBlock(pyriteOre, Library.BLOCK.U_NAME.pyriteOre);
		GameRegistry.registerBlock(topazOre, Library.BLOCK.U_NAME.topazOre);
		GameRegistry.registerBlock(andraditeOre, Library.BLOCK.U_NAME.andraditeOre);
		GameRegistry.registerBlock(orthoclaseOre, Library.BLOCK.U_NAME.orthoclaseOre);
		GameRegistry.registerBlock(iridiumOre, Library.BLOCK.U_NAME.iridiumOre);
		GameRegistry.registerBlock(bloodstoneOre, Library.BLOCK.U_NAME.bloodstoneOre);
		GameRegistry.registerBlock(rubyOre, Library.BLOCK.U_NAME.rubyOre);
		GameRegistry.registerBlock(onyxOre, Library.BLOCK.U_NAME.onyxOre);
		GameRegistry.registerBlock(sapphireOre, Library.BLOCK.U_NAME.sapphireOre);
		GameRegistry.registerBlock(benitoiteOre, Library.BLOCK.U_NAME.benitoiteOre);
		GameRegistry.registerBlock(amethystBlock, Library.BLOCK.U_NAME.amethystBlock);
		GameRegistry.registerBlock(pyriteBlock, Library.BLOCK.U_NAME.pyriteBlock);
		GameRegistry.registerBlock(topazBlock, Library.BLOCK.U_NAME.topazBlock);
		GameRegistry.registerBlock(andraditeBlock, Library.BLOCK.U_NAME.andraditeBlock);
		GameRegistry.registerBlock(orthoclaseBlock, Library.BLOCK.U_NAME.orthoclaseBlock);
		GameRegistry.registerBlock(iridiumBlock, Library.BLOCK.U_NAME.iridiumBlock);
		GameRegistry.registerBlock(bloodstoneBlock, Library.BLOCK.U_NAME.bloodstoneBlock);
		GameRegistry.registerBlock(rubyBlock, Library.BLOCK.U_NAME.rubyBlock);
		GameRegistry.registerBlock(onyxBlock, Library.BLOCK.U_NAME.onyxBlock);
		GameRegistry.registerBlock(sapphireBlock, Library.BLOCK.U_NAME.sapphireBlock);
		GameRegistry.registerBlock(benitoiteBlock, Library.BLOCK.U_NAME.benitoiteBlock);
		GameRegistry.registerBlock(burningDiamondBlock, Library.BLOCK.U_NAME.burningDiamondBlock);
		GameRegistry.registerBlock(amethystTorch, Library.BLOCK.U_NAME.amethystTorch);
		GameRegistry.registerBlock(andraditeTorch, Library.BLOCK.U_NAME.andraditeTorch);
		GameRegistry.registerBlock(onyxTorch, Library.BLOCK.U_NAME.onyxTorch);
		GameRegistry.registerBlock(orthoclaseTorch, Library.BLOCK.U_NAME.orthoclaseTorch);
		GameRegistry.registerBlock(rubyTorch, Library.BLOCK.U_NAME.rubyTorch);
		GameRegistry.registerBlock(sapphireTorch, Library.BLOCK.U_NAME.sapphireTorch);
		GameRegistry.registerBlock(amethystGlass, Library.BLOCK.U_NAME.amethystGlass);
		GameRegistry.registerBlock(andraditeGlass, Library.BLOCK.U_NAME.andraditeGlass);
		GameRegistry.registerBlock(onyxGlass, Library.BLOCK.U_NAME.onyxGlass);
		GameRegistry.registerBlock(orthoclaseGlass, Library.BLOCK.U_NAME.orthoclaseGlass);
		GameRegistry.registerBlock(rubyGlass, Library.BLOCK.U_NAME.rubyGlass);
		GameRegistry.registerBlock(sapphireGlass, Library.BLOCK.U_NAME.sapphireGlass);
		GameRegistry.registerBlock(gemBlock, Library.BLOCK.U_NAME.gemBlock);
		GameRegistry.registerBlock(glowamethystGlass, Library.BLOCK.U_NAME.glowamethystGlass);
		GameRegistry.registerBlock(glowandraditeGlass, Library.BLOCK.U_NAME.glowandraditeGlass);
		GameRegistry.registerBlock(glowonyxGlass, Library.BLOCK.U_NAME.glowonyxGlass);
		GameRegistry.registerBlock(gloworthoclaseGlass, Library.BLOCK.U_NAME.gloworthoclaseGlass);
		GameRegistry.registerBlock(glowrubyGlass, Library.BLOCK.U_NAME.glowrubyGlass);
		GameRegistry.registerBlock(glowsapphireGlass, Library.BLOCK.U_NAME.glowsapphireGlass);
		GameRegistry.registerBlock(glowGlass, Library.BLOCK.U_NAME.glowGlass);
		GameRegistry.registerBlock(gemFire, Library.BLOCK.U_NAME.gemFire);
		GameRegistry.registerBlock(grandMinePortal, Library.BLOCK.U_NAME.grandMinePortal);
		GameRegistry.registerBlock(grandCrystal, Library.BLOCK.U_NAME.grandCrystal);
		GameRegistry.registerBlock(doomShroom, Library.BLOCK.U_NAME.doomShroom);
		GameRegistry.registerBlock(fireShroom, Library.BLOCK.U_NAME.fireShroom);
		GameRegistry.registerBlock(tourmalineBlock, Library.BLOCK.U_NAME.tourmalineBlock);
		GameRegistry.registerBlock(tourmalineOre, Library.BLOCK.U_NAME.tourmalineOre);

	}

	private void setupGameRegistryRecipes() {

		//Crafting Recipes
		//SHAPED
		GameRegistry.addRecipe(new ItemStack(MinersDeluxe.burningDiamondBlock),
				"xxx", "xxx", "xxx", 'x', burningDiamond);
		GameRegistry.addRecipe(new ItemStack(MinersDeluxe.amethystBlock),
				"xxx", "xxx", "xxx", 'x', amethyst);
		GameRegistry.addRecipe(new ItemStack(MinersDeluxe.pyriteBlock),
				"xxx", "xxx", "xxx", 'x', pyriteIngot);
		GameRegistry.addRecipe(new ItemStack(MinersDeluxe.topazBlock),
				"xxx", "xxx", "xxx", 'x', topaz);
		GameRegistry.addRecipe(new ItemStack(MinersDeluxe.andraditeBlock),
				"xxx", "xxx", "xxx", 'x', andradite);
		GameRegistry.addRecipe(new ItemStack(MinersDeluxe.orthoclaseBlock),
				"xxx", "xxx", "xxx", 'x', orthoclase);
		GameRegistry.addRecipe(new ItemStack(MinersDeluxe.iridiumBlock),
				"xxx", "xxx", "xxx", 'x', iridium);
		GameRegistry.addRecipe(new ItemStack(MinersDeluxe.bloodstoneBlock),
				"xxx", "xxx", "xxx", 'x', bloodstone);
		GameRegistry.addRecipe(new ItemStack(MinersDeluxe.rubyBlock),
				"xxx", "xxx", "xxx", 'x', ruby);
		GameRegistry.addRecipe(new ItemStack(MinersDeluxe.onyxBlock),
				"xxx", "xxx", "xxx", 'x', onyx);
		GameRegistry.addRecipe(new ItemStack(MinersDeluxe.sapphireBlock),
				"xxx", "xxx", "xxx", 'x', sapphire);
		GameRegistry.addRecipe(new ItemStack(MinersDeluxe.benitoiteBlock),
				"xxx", "xxx", "xxx", 'x', benitoite);
		GameRegistry.addRecipe(new ItemStack(MinersDeluxe.tourmalineBlock),
				"xxx", "xxx", "xxx", 'x', tourmaline);
		GameRegistry.addRecipe(new ItemStack(MinersDeluxe.burningDiamondSword),
				" x ", " x ", " y ", 'x', burningDiamond, 'y', Item.stick);
		GameRegistry.addRecipe(new ItemStack(MinersDeluxe.burningDiamondPickaxe),
				"xxx", " y ", " y ", 'x', burningDiamond, 'y', Item.stick);
		GameRegistry.addRecipe(new ItemStack(MinersDeluxe.burningDiamondAxe),
				"xx ", "xy ", " y ", 'x', burningDiamond, 'y', Item.stick);
		GameRegistry.addRecipe(new ItemStack(MinersDeluxe.burningDiamondAxe),
				" xx", " yx", " y ", 'x', burningDiamond, 'y', Item.stick);
		GameRegistry.addRecipe(new ItemStack(MinersDeluxe.burningDiamondShovel),
				" x ", " y ", " y ", 'x', burningDiamond, 'y', Item.stick);
		GameRegistry.addRecipe(new ItemStack(MinersDeluxe.burningDiamondHoe),
				"xx ", " y ", " y ", 'x', burningDiamond, 'y', Item.stick);
		GameRegistry.addRecipe(new ItemStack(MinersDeluxe.burningDiamondHoe),
				" xx", " y ", " y ", 'x', burningDiamond, 'y', Item.stick);
		GameRegistry.addRecipe(new ItemStack(MinersDeluxe.steelSword),
				" x ", " x ", " y ", 'x', steelIngot, 'y', Item.stick);
		GameRegistry.addRecipe(new ItemStack(MinersDeluxe.steelPickaxe),
				"xxx", " y ", " y ", 'x', steelIngot, 'y', Item.stick);
		GameRegistry.addRecipe(new ItemStack(MinersDeluxe.steelAxe),
				"xx ", "xy ", " y ", 'x', steelIngot, 'y', Item.stick);
		GameRegistry.addRecipe(new ItemStack(MinersDeluxe.steelAxe),
				" xx", " yx", " y ", 'x', steelIngot, 'y', Item.stick);
		GameRegistry.addRecipe(new ItemStack(MinersDeluxe.steelShovel),
				" x ", " y ", " y ", 'x', steelIngot, 'y', Item.stick);
		GameRegistry.addRecipe(new ItemStack(MinersDeluxe.steelHoe),
				"xx ", " y ", " y ", 'x', steelIngot, 'y', Item.stick);
		GameRegistry.addRecipe(new ItemStack(MinersDeluxe.steelHoe),
				" xx", " y ", " y ", 'x', steelIngot, 'y', Item.stick);
		GameRegistry.addRecipe(new ItemStack(MinersDeluxe.obsidianSword),
				" x ", " x ", " y ", 'x', Block.obsidian, 'y', Item.stick);
		GameRegistry.addRecipe(new ItemStack(MinersDeluxe.obsidianPickaxe),
				"xxx", " y ", " y ", 'x', Block.obsidian, 'y', Item.stick);
		GameRegistry.addRecipe(new ItemStack(MinersDeluxe.obsidianAxe),
				"xx ", "xy ", " y ", 'x', Block.obsidian, 'y', Item.stick);
		GameRegistry.addRecipe(new ItemStack(MinersDeluxe.obsidianAxe),
				" xx", " yx", " y ", 'x', Block.obsidian, 'y', Item.stick);
		GameRegistry.addRecipe(new ItemStack(MinersDeluxe.obsidianShovel),
				" x ", " y ", " y ", 'x', Block.obsidian, 'y', Item.stick);
		GameRegistry.addRecipe(new ItemStack(MinersDeluxe.obsidianHoe),
				"xx ", " y ", " y ", 'x', Block.obsidian, 'y', Item.stick);
		GameRegistry.addRecipe(new ItemStack(MinersDeluxe.obsidianHoe),
				" xx", " y ", " y ", 'x', Block.obsidian, 'y', Item.stick);
		GameRegistry.addShapedRecipe(new ItemStack(burningDiamondHelmet),
				"xxx", "x x", 'x', burningDiamond);
		GameRegistry.addShapedRecipe(new ItemStack(burningDiamondChest),
				"x x", "xxx", "xxx", 'x', burningDiamond);
		GameRegistry.addShapedRecipe(new ItemStack(burningDiamondLeggings),
				"xxx", "x x", "x x", 'x', burningDiamond);
		GameRegistry.addShapedRecipe(new ItemStack(burningDiamondBoots),
				"x x", "x x", 'x', burningDiamond);
		GameRegistry.addShapedRecipe(new ItemStack(steelHelmet),
				"xxx", "x x", 'x', steelIngot);
		GameRegistry.addShapedRecipe(new ItemStack(steelChest),
				"x x", "xxx", "xxx", 'x', steelIngot);
		GameRegistry.addShapedRecipe(new ItemStack(steelLeggings),
				"xxx", "x x", "x x", 'x', steelIngot);
		GameRegistry.addShapedRecipe(new ItemStack(steelBoots),
				"x x", "x x", 'x', steelIngot);
		GameRegistry.addShapedRecipe(new ItemStack(onyxHelmet),
				"xxx", "x x", 'x', onyx);
		GameRegistry.addShapedRecipe(new ItemStack(onyxChest),
				"x x", "xxx", "xxx", 'x', onyx);
		GameRegistry.addShapedRecipe(new ItemStack(onyxLeggings),
				"xxx", "x x", "x x", 'x', onyx);
		GameRegistry.addShapedRecipe(new ItemStack(onyxBoots),
				"x x", "x x", 'x', onyx);
		GameRegistry.addShapedRecipe(new ItemStack(rubyHelmet),
				"xxx", "x x", 'x', ruby);
		GameRegistry.addShapedRecipe(new ItemStack(rubyChest),
				"x x", "xxx", "xxx", 'x', ruby);
		GameRegistry.addShapedRecipe(new ItemStack(rubyLeggings),
				"xxx", "x x", "x x", 'x', ruby);
		GameRegistry.addShapedRecipe(new ItemStack(rubyBoots),
				"x x", "x x", 'x', ruby);
		GameRegistry.addShapedRecipe(new ItemStack(sapphireHelmet),
				"xxx", "x x", 'x', sapphire);
		GameRegistry.addShapedRecipe(new ItemStack(sapphireChest),
				"x x", "xxx", "xxx", 'x', sapphire);
		GameRegistry.addShapedRecipe(new ItemStack(sapphireLeggings),
				"xxx", "x x", "x x", 'x', sapphire);
		GameRegistry.addShapedRecipe(new ItemStack(sapphireBoots),
				"x x", "x x", 'x', sapphire);
		GameRegistry.addShapedRecipe(new ItemStack(amethystHelmet),
				"xxx", "x x", 'x', amethyst);
		GameRegistry.addShapedRecipe(new ItemStack(amethystChest),
				"x x", "xxx", "xxx", 'x', amethyst);
		GameRegistry.addShapedRecipe(new ItemStack(amethystLeggings),
				"xxx", "x x", "x x", 'x', amethyst);
		GameRegistry.addShapedRecipe(new ItemStack(amethystBoots),
				"x x", "x x", 'x', amethyst);
		GameRegistry.addShapedRecipe(new ItemStack(andraditeHelmet),
				"xxx", "x x", 'x', andradite);
		GameRegistry.addShapedRecipe(new ItemStack(andraditeChest),
				"x x", "xxx", "xxx", 'x', andradite);
		GameRegistry.addShapedRecipe(new ItemStack(andraditeLeggings),
				"xxx", "x x", "x x", 'x', andradite);
		GameRegistry.addShapedRecipe(new ItemStack(andraditeBoots),
				"x x", "x x", 'x', andradite);
		GameRegistry.addShapedRecipe(new ItemStack(orthoclaseHelmet),
				"xxx", "x x", 'x', orthoclase);
		GameRegistry.addShapedRecipe(new ItemStack(orthoclaseChest),
				"x x", "xxx", "xxx", 'x', orthoclase);
		GameRegistry.addShapedRecipe(new ItemStack(orthoclaseLeggings),
				"xxx", "x x", "x x", 'x', orthoclase);
		GameRegistry.addShapedRecipe(new ItemStack(orthoclaseBoots),
				"x x", "x x", 'x', orthoclase);
		GameRegistry.addShapedRecipe(new ItemStack(tourmalineHelmet),
				"xxx", "x x", 'x', tourmaline);
		GameRegistry.addShapedRecipe(new ItemStack(tourmalineChest),
				"x x", "xxx", "xxx", 'x', tourmaline);
		GameRegistry.addShapedRecipe(new ItemStack(tourmalineLeggings),
				"xxx", "x x", "x x", 'x', tourmaline);
		GameRegistry.addShapedRecipe(new ItemStack(tourmalineBoots),
				"x x", "x x", 'x', tourmaline);
		GameRegistry.addShapedRecipe(new ItemStack(amethystTorch, 32),
				" x ", " y ", 'x', amethyst, 'y', Item.stick);
		GameRegistry.addShapedRecipe(new ItemStack(andraditeTorch, 32),
				" x ", " y ", 'x', andradite, 'y', Item.stick);
		GameRegistry.addShapedRecipe(new ItemStack(onyxTorch, 64),
				" x ", " y ", 'x', onyx, 'y', Item.stick);
		GameRegistry.addShapedRecipe(new ItemStack(orthoclaseTorch, 64),
				" x ", " y ", 'x', orthoclase, 'y', Item.stick);
		GameRegistry.addShapedRecipe(new ItemStack(rubyTorch, 32),
				" x ", " y ", 'x', ruby, 'y', Item.stick);
		GameRegistry.addShapedRecipe(new ItemStack(sapphireTorch, 64),
				" x ", " y ", 'x', sapphire, 'y', Item.stick);
		GameRegistry.addShapedRecipe(new ItemStack(amethystGlass, 8), 
				"xxx", "xyx", "xxx", 'x', Block.glass, 'y', amethyst);
		GameRegistry.addShapedRecipe(new ItemStack(andraditeGlass, 8), 
				"xxx", "xyx", "xxx", 'x', Block.glass, 'y', andradite);
		GameRegistry.addShapedRecipe(new ItemStack(onyxGlass, 8), 
				"xxx", "xyx", "xxx", 'x', Block.glass, 'y', onyx);
		GameRegistry.addShapedRecipe(new ItemStack(orthoclaseGlass, 8), 
				"xxx", "xyx", "xxx", 'x', Block.glass, 'y', orthoclase);
		GameRegistry.addShapedRecipe(new ItemStack(rubyGlass, 8), 
				"xxx", "xyx", "xxx", 'x', Block.glass, 'y', ruby);
		GameRegistry.addShapedRecipe(new ItemStack(sapphireGlass, 8), 
				"xxx", "xyx", "xxx", 'x', Block.glass, 'y', sapphire);
		GameRegistry.addShapedRecipe(new ItemStack(bloodstoneHelmet),
				"xxx", "x x", 'x', bloodstone);
		GameRegistry.addShapedRecipe(new ItemStack(bloodstoneChest),
				"x x", "xxx", "xxx", 'x', bloodstone);
		GameRegistry.addShapedRecipe(new ItemStack(bloodstoneLeggings),
				"xxx", "x x", "x x", 'x', bloodstone);
		GameRegistry.addShapedRecipe(new ItemStack(bloodstoneBoots),
				"x x", "x x", 'x', bloodstone);
		GameRegistry.addRecipe(new ItemStack(MinersDeluxe.gemBlock),
				"xxx", "xxx", "xxx", 'x', gemDust);
		GameRegistry.addRecipe(new ItemStack(MinersDeluxe.grandCrystal),
				"xx", "xx", 'x', grandCrystalShard);

		//SHAPELESS
		GameRegistry.addShapelessRecipe(new ItemStack(MinersDeluxe.burningDiamond, 9), MinersDeluxe.burningDiamondBlock);
		GameRegistry.addShapelessRecipe(new ItemStack(MinersDeluxe.amethyst, 9), MinersDeluxe.amethystBlock);
		GameRegistry.addShapelessRecipe(new ItemStack(MinersDeluxe.pyriteIngot, 9), MinersDeluxe.pyriteBlock);
		GameRegistry.addShapelessRecipe(new ItemStack(MinersDeluxe.topaz, 9), MinersDeluxe.topazBlock);
		GameRegistry.addShapelessRecipe(new ItemStack(MinersDeluxe.andradite, 9), MinersDeluxe.andraditeBlock);
		GameRegistry.addShapelessRecipe(new ItemStack(MinersDeluxe.orthoclase, 9), MinersDeluxe.orthoclaseBlock);
		GameRegistry.addShapelessRecipe(new ItemStack(MinersDeluxe.iridium, 9), MinersDeluxe.iridiumBlock);
		GameRegistry.addShapelessRecipe(new ItemStack(MinersDeluxe.bloodstone, 9), MinersDeluxe.bloodstoneBlock);
		GameRegistry.addShapelessRecipe(new ItemStack(MinersDeluxe.ruby, 9), MinersDeluxe.rubyBlock);
		GameRegistry.addShapelessRecipe(new ItemStack(MinersDeluxe.onyx, 9), MinersDeluxe.onyxBlock);
		GameRegistry.addShapelessRecipe(new ItemStack(MinersDeluxe.sapphire, 9), MinersDeluxe.sapphireBlock);
		GameRegistry.addShapelessRecipe(new ItemStack(MinersDeluxe.benitoite, 9), MinersDeluxe.benitoiteBlock);
		GameRegistry.addShapelessRecipe(new ItemStack(MinersDeluxe.tourmaline, 9), MinersDeluxe.tourmalineBlock);
		GameRegistry.addShapelessRecipe(new ItemStack(MinersDeluxe.microbombGem, 1), new Object[]{amethyst, andradite, ruby});
		GameRegistry.addShapelessRecipe(new ItemStack(MinersDeluxe.bombGem, 1), new Object[]{orthoclase, sapphire, onyx});
		GameRegistry.addShapelessRecipe(new ItemStack(MinersDeluxe.macrobombGem, 1), new Object[]{iridium, topaz, bloodstone});
		GameRegistry.addShapelessRecipe(new ItemStack(MinersDeluxe.nuclearbombGem, 1), new Object[]{bombGem, microbombGem, macrobombGem, benitoite});
		GameRegistry.addShapelessRecipe(new ItemStack(MinersDeluxe.gemDust, 3), MinersDeluxe.amethyst);
		GameRegistry.addShapelessRecipe(new ItemStack(MinersDeluxe.gemDust, 3), MinersDeluxe.andradite);
		GameRegistry.addShapelessRecipe(new ItemStack(MinersDeluxe.gemDust, 3), MinersDeluxe.topaz);
		GameRegistry.addShapelessRecipe(new ItemStack(MinersDeluxe.gemDust, 3), MinersDeluxe.orthoclase);
		GameRegistry.addShapelessRecipe(new ItemStack(MinersDeluxe.gemDust, 3), MinersDeluxe.onyx);
		GameRegistry.addShapelessRecipe(new ItemStack(MinersDeluxe.gemDust, 3), MinersDeluxe.ruby);
		GameRegistry.addShapelessRecipe(new ItemStack(MinersDeluxe.gemDust, 3), MinersDeluxe.sapphire);
		GameRegistry.addShapelessRecipe(new ItemStack(MinersDeluxe.glowGlass, 1), new Object[]{Block.glass, Item.glowstone});
		GameRegistry.addShapelessRecipe(new ItemStack(MinersDeluxe.glowamethystGlass, 1), new Object[]{MinersDeluxe.amethystGlass, Item.glowstone});
		GameRegistry.addShapelessRecipe(new ItemStack(MinersDeluxe.glowandraditeGlass, 1), new Object[]{MinersDeluxe.andraditeGlass, Item.glowstone});
		GameRegistry.addShapelessRecipe(new ItemStack(MinersDeluxe.glowonyxGlass, 1), new Object[]{MinersDeluxe.onyxGlass, Item.glowstone});
		GameRegistry.addShapelessRecipe(new ItemStack(MinersDeluxe.gloworthoclaseGlass, 1), new Object[]{MinersDeluxe.orthoclaseGlass, Item.glowstone});
		GameRegistry.addShapelessRecipe(new ItemStack(MinersDeluxe.glowrubyGlass, 1), new Object[]{MinersDeluxe.rubyGlass, Item.glowstone});
		GameRegistry.addShapelessRecipe(new ItemStack(MinersDeluxe.glowsapphireGlass, 1), new Object[]{MinersDeluxe.sapphireGlass, Item.glowstone});
		GameRegistry.addShapelessRecipe(new ItemStack(MinersDeluxe.gemFireStarter, 1), new Object[]{MinersDeluxe.gemDust, Item.flintAndSteel});
		GameRegistry.addShapelessRecipe(new ItemStack(MinersDeluxe.microminingbombGem, 1), new Object[]{microbombGem, burningDiamondPickaxe});
		GameRegistry.addShapelessRecipe(new ItemStack(MinersDeluxe.steelIngot, 1), new Object[]{Item.ingotIron, Item.ingotIron, Item.ingotIron});

		//Smelting Recipes
		GameRegistry.addSmelting(MinersDeluxe.burningDiamond.itemID, new ItemStack(Item.diamond, 3), 1.0F);
		GameRegistry.addSmelting(MinersDeluxe.pyriteOre.blockID, new ItemStack(MinersDeluxe.pyriteIngot), 0.25F);

	}

	private void setupMinecraftForge() {

		//Blocks
		MinecraftForge.setBlockHarvestLevel(burningDiamondOre, "pickaxe", 3);
		MinecraftForge.setBlockHarvestLevel(amethystOre, "pickaxe", 2);
		MinecraftForge.setBlockHarvestLevel(pyriteOre, "pickaxe", 1);
		MinecraftForge.setBlockHarvestLevel(topazOre, "pickaxe", 2);
		MinecraftForge.setBlockHarvestLevel(andraditeOre, "pickaxe", 2);
		MinecraftForge.setBlockHarvestLevel(orthoclaseOre, "pickaxe", 2);
		MinecraftForge.setBlockHarvestLevel(iridiumOre, "pickaxe", 3);
		MinecraftForge.setBlockHarvestLevel(bloodstoneOre, "pickaxe", 2);
		MinecraftForge.setBlockHarvestLevel(rubyOre, "pickaxe", 2);
		MinecraftForge.setBlockHarvestLevel(onyxOre, "pickaxe", 2);
		MinecraftForge.setBlockHarvestLevel(sapphireOre, "pickaxe", 2);
		MinecraftForge.setBlockHarvestLevel(benitoiteOre, "pickaxe", 3);
		MinecraftForge.setBlockHarvestLevel(burningDiamondBlock, "pickaxe", 3);
		MinecraftForge.setBlockHarvestLevel(amethystBlock, "pickaxe", 2);
		MinecraftForge.setBlockHarvestLevel(pyriteBlock, "pickaxe", 1);
		MinecraftForge.setBlockHarvestLevel(topazBlock, "pickaxe", 2);
		MinecraftForge.setBlockHarvestLevel(andraditeBlock, "pickaxe", 2);
		MinecraftForge.setBlockHarvestLevel(orthoclaseBlock, "pickaxe", 2);
		MinecraftForge.setBlockHarvestLevel(iridiumBlock, "pickaxe", 3);
		MinecraftForge.setBlockHarvestLevel(bloodstoneBlock, "pickaxe", 2);
		MinecraftForge.setBlockHarvestLevel(rubyBlock, "pickaxe", 2);
		MinecraftForge.setBlockHarvestLevel(onyxBlock, "pickaxe", 2);
		MinecraftForge.setBlockHarvestLevel(sapphireBlock, "pickaxe", 2);
		MinecraftForge.setBlockHarvestLevel(benitoiteBlock, "pickaxe", 3);
		MinecraftForge.setBlockHarvestLevel(gemBlock, "pickaxe", 3);
		MinecraftForge.setBlockHarvestLevel(grandStone, "pickaxe", 1);

	}

	private void setupEntityRegistry() {

		//Entity Registry [with entityRenderers]
		EntityRegistry.registerModEntity(EntityMicroBombGem.class, "MicroBombGem", microbombGemID, this, 64, 1, true);
		EntityRegistry.registerModEntity(EntityBombGem.class, "BombGem", bombGemID, this, 64, 1, true);
		EntityRegistry.registerModEntity(EntityMacroBombGem.class, "MacroBombGem", macrobombGemID, this, 64, 1, true);
		EntityRegistry.registerModEntity(EntityNuclearGem.class, "NuclearBombGem", nuclearbombGemID, this, 64, 1, true);
		EntityRegistry.registerModEntity(EntityMicroMiningBombGem.class, "MicroMiningBombGem", microminingbombGemID, this, 64, 1, true);

		//Mob
		EntityRegistry.registerGlobalEntityID(EntityCaveSnake.class, "CaveSnake", EntityRegistry.findGlobalUniqueEntityId(), 0x0d4210, 0x1bb626);
		EntityRegistry.registerGlobalEntityID(EntityAwesomemancam.class, "Awesomemancam", EntityRegistry.findGlobalUniqueEntityId(), 0xdf8b1a, 0x0000000);

		//Spawn
		EntityRegistry.addSpawn(EntityCaveSnake.class, 20, 2, 6, EnumCreatureType.monster, MinersDeluxe.GrandMineBiome);
		EntityRegistry.addSpawn(EntityAwesomemancam.class, 1, 1, 1, EnumCreatureType.monster, MinersDeluxe.GrandMineBiome);

	}

	@EventHandler
	public void ServerStart(FMLServerStartingEvent event) {
		ICommandManager manager = MinecraftServer.getServer().getCommandManager();
		ServerCommandManager serverManager = ((ServerCommandManager)manager);
	}

}
