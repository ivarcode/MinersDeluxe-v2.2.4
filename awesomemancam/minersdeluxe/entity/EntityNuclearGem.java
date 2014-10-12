package awesomemancam.minersdeluxe.entity;

import cpw.mods.fml.common.network.Player;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.projectile.EntityThrowable;
import net.minecraft.util.DamageSource;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;

public class EntityNuclearGem extends EntityThrowable
{
	public EntityNuclearGem(World par1World)
    {
        super(par1World);
    }

    public EntityNuclearGem(World par1World, EntityLivingBase par2EntityLivingBase)
    {
        super(par1World, par2EntityLivingBase);
    }

    public EntityNuclearGem(World par1World, double par2, double par4, double par6)
    {
        super(par1World, par2, par4, par6);
    }

    protected void onImpact(MovingObjectPosition par1MovingObjectPosition)
    {
        if (par1MovingObjectPosition.entityHit != null)
        {
            byte b0 = 0;

            par1MovingObjectPosition.entityHit.attackEntityFrom(DamageSource.causeThrownDamage(this, this.getThrower()), (float)b0);
        }

        for (int i = 0; i < 8; ++i)
        {
            this.worldObj.createExplosion(this, this.posX, this.posY, this.posZ, 25.0F, true);
            this.worldObj.createExplosion(this, this.posX + 20, this.posY, this.posZ + 20, 20.0F, true);
            this.worldObj.createExplosion(this, this.posX + 20, this.posY, this.posZ - 20, 20.0F, true);
            this.worldObj.createExplosion(this, this.posX - 20, this.posY, this.posZ - 20, 20.0F, true);
            this.worldObj.createExplosion(this, this.posX - 20, this.posY, this.posZ + 20, 20.0F, true);
        }

        if (!this.worldObj.isRemote)
        {
            this.setDead();
        }
    }
}
