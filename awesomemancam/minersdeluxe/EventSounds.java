package awesomemancam.minersdeluxe;

import net.minecraftforge.client.event.sound.SoundLoadEvent;
import net.minecraftforge.event.ForgeSubscribe;

public class EventSounds {
	@ForgeSubscribe
	public void onSound(SoundLoadEvent event)
	{
		try
		{
			event.manager.addSound("minersdeluxe:cavesnake_hiss.ogg");
			event.manager.addSound("minersdeluxe:awesomemancam_hurt.ogg");
			event.manager.addSound("minersdeluxe:awesomemancam_derp.ogg");
			event.manager.addSound("minersdeluxe:awesomemancam_death.ogg");
		}
		catch (Exception e)
		{
			System.err.println("Sound Failure");
		}
	}
}