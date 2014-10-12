package awesomemancam.minersdeluxe.client;

import cpw.mods.fml.client.registry.RenderingRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;
import awesomemancam.minersdeluxe.CommonProxy;
import awesomemancam.minersdeluxe.EventSounds;
import awesomemancam.minersdeluxe.MinersDeluxe;
import awesomemancam.minersdeluxe.entity.*;
import awesomemancam.minersdeluxe.item.renderer.*;
import awesomemancam.minersdeluxe.mob.*;
import awesomemancam.minersdeluxe.mob.model.*;
import awesomemancam.minersdeluxe.mob.renderer.*;
import net.minecraft.item.Item;
import net.minecraftforge.client.MinecraftForgeClient;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.ForgeSubscribe;

public class ClientProxy extends CommonProxy {

	@Override
	public void registerRenderers() {

		//Throwable
		RenderingRegistry.registerEntityRenderingHandler(EntityBombGem.class, new RenderBombGem(MinersDeluxe.bombGem));
		RenderingRegistry.registerEntityRenderingHandler(EntityMacroBombGem.class, new RenderMacroBombGem(MinersDeluxe.macrobombGem));
		RenderingRegistry.registerEntityRenderingHandler(EntityMicroBombGem.class, new RenderMicroBombGem(MinersDeluxe.microbombGem));
		RenderingRegistry.registerEntityRenderingHandler(EntityNuclearGem.class, new RenderNuclearGem(MinersDeluxe.nuclearbombGem));
		RenderingRegistry.registerEntityRenderingHandler(EntityMicroMiningBombGem.class, new RenderMicroMiningBombGem(MinersDeluxe.microminingbombGem));

		//Mobs
		RenderingRegistry.registerEntityRenderingHandler(EntityCaveSnake.class, new RenderCaveSnake(new ModelCaveSnake(), 0.1F));
		RenderingRegistry.registerEntityRenderingHandler(EntityAwesomemancam.class, new RenderAwesomemancam(new ModelAwesomemancam(), 0.3F));

	}

	@ForgeSubscribe
	public void registerSounds() {
		MinecraftForge.EVENT_BUS.register(new EventSounds());
	}

	public void stringLocalization() {
		//String Localization
		LanguageRegistry.instance().addStringLocalization("entity.CaveSnake.name", "Cave Snake");
		LanguageRegistry.instance().addStringLocalization("entity.Awesomemancam.name", "awesomemancam");
	}

}