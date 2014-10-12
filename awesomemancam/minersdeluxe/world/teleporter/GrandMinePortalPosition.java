package awesomemancam.minersdeluxe.world.teleporter;

import net.minecraft.util.ChunkCoordinates;

public class GrandMinePortalPosition extends ChunkCoordinates
{
	public long field_85087_d;
	
	final GrandMineTeleporter field_85088_e;
	
	public GrandMinePortalPosition(GrandMineTeleporter grandMineTeleporter, int par2, int par3, int par4, long par5)
	{
		super(par2, par3, par4);
		this.field_85088_e = grandMineTeleporter;
		this.field_85087_d = par5;
	}
}