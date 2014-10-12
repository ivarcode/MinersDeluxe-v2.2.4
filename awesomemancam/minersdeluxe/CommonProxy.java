package awesomemancam.minersdeluxe;

import cpw.mods.fml.common.registry.TickRegistry;
import cpw.mods.fml.relauncher.Side;

public class CommonProxy {
	
	// Client
    public void registerRenderers() {/* Nothing here as the server doesn't render graphics or entities! */}
    public void registerSounds() {/* Nothing here as the server doesn't make sounds from entities! */}
    public void stringLocalization() {/* ""    "" */}
	
    //Server
    public void registerServerTickHandler() {
    	TickRegistry.registerTickHandler(new ServerTickHandler(), Side.SERVER);
    }
    
}
