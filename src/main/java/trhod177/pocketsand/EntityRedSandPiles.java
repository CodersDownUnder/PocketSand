package trhod177.pocketsand;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.monster.EntityBlaze;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityThrowable;
import net.minecraft.init.MobEffects;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.datafix.DataFixer;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class EntityRedSandPiles extends EntityThrowable
{
	
	
    public EntityRedSandPiles(World worldIn)
    {
        super(worldIn);
    }

    public EntityRedSandPiles(World worldIn, EntityLivingBase throwerIn)
    {
        super(worldIn, throwerIn);
    }

    public EntityRedSandPiles(World worldIn, double x, double y, double z)
    {
        super(worldIn, x, y, z);
    }

    public static void registerFixesSnowball(DataFixer fixer)
    {
        EntityThrowable.registerFixesThrowable(fixer, "sandpiles");
    }

 
    

    
    public boolean hitEntity(ItemStack stack, EntityLivingBase hitEntity, EntityLivingBase attackingEntity)
	  {
	  hitEntity.addPotionEffect(new PotionEffect(MobEffects.BLINDNESS, 60*20, 5, false, true));
	  return true;
	  }
  
    protected void onImpact(RayTraceResult result)
    {
        if (result.entityHit != null)
        {
            int i = 0;

           
            
            result.entityHit.attackEntityFrom(DamageSource.causeThrownDamage(this, this.getThrower()), (float)i);
            
            
        }

        if (!this.world.isRemote)
        {
            this.world.setEntityState(this, (byte)3);
            this.setDead();
            
        }
        
        
    }
    
    @Override
	public void onUpdate() {
		EntityLivingBase thrower = this.getThrower();
		
		if(thrower != null && thrower instanceof EntityPlayer && !thrower.isEntityAlive())
			this.setDead();
		else
			super.onUpdate();
	}
}