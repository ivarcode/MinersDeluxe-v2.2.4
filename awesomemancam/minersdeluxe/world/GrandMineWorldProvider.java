package awesomemancam.minersdeluxe.world;

import net.minecraft.util.ChunkCoordinates;
import net.minecraft.util.MathHelper;
import net.minecraft.util.Vec3;
import net.minecraft.world.WorldProvider;
import net.minecraft.world.biome.WorldChunkManagerHell;
import net.minecraft.world.chunk.IChunkProvider;
import awesomemancam.minersdeluxe.MinersDeluxe;
import awesomemancam.minersdeluxe.lib.Library;
import awesomemancam.minersdeluxe.world.chunk.GrandMineChunkProvider;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class GrandMineWorldProvider extends WorldProvider
{
	private float[] colorsSunriseSunset = new float[4];
	public void registerWorldChunkManager()
	{
		this.worldChunkMgr = new WorldChunkManagerHell(MinersDeluxe.GrandMineBiome, this.dimensionId, this.dimensionId);
		this.dimensionId = Library.DIM.GRAND_MINE;
		this.hasNoSky = true;
	}
	public IChunkProvider createChunkGenerator()
	{
		return new GrandMineChunkProvider(this.worldObj, this.worldObj.getSeed());
	}
	public int getAverageGroundLevel()
	{
		return 0;
	}
	@SideOnly(Side.CLIENT)
	public boolean doesXZShowFog(int par1, int par2)
	{
		return false;
	}
	public String getDimensionName()
	{
		return "GrandMine";
	}
	public boolean renderStars()
	{
		return false;
	}
	public boolean renderClouds()
	{
		return false;
	}
	public boolean renderVoidFog()
	{
		return false;
	}
	public boolean renderEndSky()
	{
		return false;
	}
	public boolean canRespawnHere()
	{
		return false;
	}
	public boolean isSurfaceWorld()
	{
		return false;
	}
	public boolean canCoordinateBeSpawn(int par1, int par2)
	{
		return false;
	}
	public ChunkCoordinates getEntrancePortalLocation()
	{
		return new ChunkCoordinates(50, 5, 0);
	}
	protected void generateLightBrightnessTable()
	{
		float f = 0.0F;

        for (int i = 0; i <= 15; ++i)
        {
            float f1 = 1.0F - (float)i / 15.0F;
            this.lightBrightnessTable[i] = (1.0F - f1) / (f1 * 3.0F + 1.0F) * (1.0F - f) + f;
        }
	}
	@SideOnly(Side.CLIENT)
	public String getWelcomeMessage()
	{
		return "Entering the Grand Mine";
	}
	@SideOnly(Side.CLIENT)
	public String getDepartMessage()
	{
		return "Leaving the Grand Mine";
	}
	@SideOnly(Side.CLIENT)
	public String getSaveFolder() {
		return (dimensionId == 0 ? null : "DIM" + dimensionId);
	}
	public float calculateCelestialAngle(long par1, float par3)
	{
		int j = (int)(par1 % 24000L);
        float f1 = ((float)j + par3) / 24000.0F - 0.25F;

        if (f1 < 0.0F)
        {
            ++f1;
        }

        if (f1 > 1.0F)
        {
            --f1;
        }

        float f2 = f1;
        f1 = 1.0F - (float)((Math.cos((double)f1 * Math.PI) + 1.0D) / 2.0D);
        f1 = f2 + (f1 - f2) / 3.0F;
        return f1;
	}
	@SideOnly(Side.CLIENT)
	public Vec3 getFogColor(float par1, float par2)
	{
		float f2 = MathHelper.cos(par1 * (float)Math.PI * 2.0F) * 2.0F + 0.5F;

        if (f2 < 0.0F)
        {
            f2 = 0.0F;
        }

        if (f2 > 1.0F)
        {
            f2 = 1.0F;
        }

        float f3 = 0.7529412F;
        float f4 = 0.84705883F;
        float f5 = 1.0F;
        f3 *= f2 * 0.94F + 0.06F;
        f4 *= f2 * 0.94F + 0.06F;
        f5 *= f2 * 0.91F + 0.09F;
        return this.worldObj.getWorldVec3Pool().getVecFromPool((double)f3, (double)f4, (double)f5);
	}
}