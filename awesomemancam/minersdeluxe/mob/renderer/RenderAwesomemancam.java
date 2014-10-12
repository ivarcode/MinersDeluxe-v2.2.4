package awesomemancam.minersdeluxe.mob.renderer;

import awesomemancam.minersdeluxe.lib.Library;
import awesomemancam.minersdeluxe.mob.EntityAwesomemancam;
import awesomemancam.minersdeluxe.mob.EntityCaveSnake;
import awesomemancam.minersdeluxe.mob.model.ModelAwesomemancam;
import awesomemancam.minersdeluxe.mob.model.ModelCaveSnake;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.passive.EntityCow;
import net.minecraft.util.ResourceLocation;

public class RenderAwesomemancam extends RenderLiving  {
	protected ModelAwesomemancam model;

	public RenderAwesomemancam(ModelBase par1ModelBase, float par2) {
		super(par1ModelBase, par2);
		model = ((ModelAwesomemancam)mainModel);
	}

	public void renderAwesomemancam(EntityAwesomemancam entity, double par2, double par4, double par6, float par8, float par9) {
		super.doRenderLiving(entity, par2, par4, par6, par8, par9);
	}

	public void doRenderLiving(EntityLiving par1EntityLiving, double par2, double par4, double par6, float par8, float par9) {
		renderAwesomemancam((EntityAwesomemancam)par1EntityLiving, par2, par4, par6, par8, par9);
	}

	public void doRender(Entity par1Entity, double par2, double par4, double par6, float par8, float par9) {
		renderAwesomemancam((EntityAwesomemancam)par1Entity, par2, par4, par6, par8, par9);
	}
	@Override
	protected ResourceLocation func_110775_a(Entity entity) {
		return new ResourceLocation("minersdeluxe:textures/entity/awesomemancam.png");
	}

}