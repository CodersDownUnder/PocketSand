package trhod177.pocketsand;



import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntitySnowball;
import net.minecraft.init.Blocks;
import net.minecraft.init.MobEffects;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.stats.StatList;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.World;


public class ItemRedSandPiles extends Item {
	
	

	protected String name;

	public ItemRedSandPiles(String name) {
		this.name = name;
		setUnlocalizedName(name);
		setRegistryName(name);
		
		
	}
	
	  public ActionResult<ItemStack> onItemRightClick(World worldIn, EntityPlayer playerIn, EnumHand handIn)
	    {
	        ItemStack itemstack = playerIn.getHeldItem(handIn);

	        if (!playerIn.capabilities.isCreativeMode)
	        {
	            itemstack.shrink(1);
	        }

	        worldIn.playSound((EntityPlayer)null, playerIn.posX, playerIn.posY, playerIn.posZ, SoundEvents.ENTITY_SNOWBALL_THROW, SoundCategory.NEUTRAL, 0.5F, 0.4F / (itemRand.nextFloat() * 0.4F + 0.8F));

	        if (!worldIn.isRemote)
	        {
	            EntitySandPiles sandpiles = new EntitySandPiles(worldIn, playerIn);
	            sandpiles.shoot(playerIn, playerIn.rotationPitch, playerIn.rotationYaw, 0.0F, 1.5F, 1.0F);
	            worldIn.spawnEntity(sandpiles);
	        }

	        playerIn.addStat(StatList.getObjectUseStats(this));
	        return new ActionResult<ItemStack>(EnumActionResult.SUCCESS, itemstack);
	    }
	  
	  public boolean hitEntity(ItemStack stack, EntityLivingBase hitEntity, EntityLivingBase attackingEntity)
	  {
	  hitEntity.addPotionEffect(new PotionEffect(MobEffects.BLINDNESS, 60*20, 5, false, true));
	  return true;
	  }

	public void registerItemModel() {
		PocketSand.proxy.registerItemRenderer(this, 0, name);
	}
	
	
	
	@Override
	public ItemRedSandPiles setCreativeTab(CreativeTabs tab) {
		super.setCreativeTab(CreativeTabs.MISC);
		return this;
     }
}
