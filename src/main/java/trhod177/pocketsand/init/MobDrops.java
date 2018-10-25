package trhod177.pocketsand.init;

import java.util.Collection;
import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.monster.EntityHusk;
import net.minecraft.entity.monster.EntitySkeleton;
import net.minecraft.entity.monster.EntityStray;
import net.minecraft.entity.monster.EntityVex;
import net.minecraft.entity.monster.EntityZombie;
import net.minecraft.entity.passive.EntityChicken;
import net.minecraft.entity.passive.EntityCow;
import net.minecraft.entity.passive.EntityMooshroom;
import net.minecraft.entity.passive.EntityPig;
import net.minecraft.entity.passive.EntityRabbit;
import net.minecraft.entity.passive.EntitySheep;
import net.minecraft.entity.passive.EntityVillager;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraftforge.event.entity.living.LivingDropsEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import trhod177.pocketsand.handlers.ConfigHandler;

public class MobDrops {
	
	public static double rand;
	public Random r = new Random();

	
	
	@SubscribeEvent
	public void onEntityDrop(LivingDropsEvent event) {

    if(ConfigHandler.overridehuskdrops == true) {
		
	if(event.getEntityLiving() instanceof EntityHusk) {
		event.getEntityLiving().dropItem(ItemInit.sandpile, r.nextInt(4));
		event.getEntityLiving().dropItem(ItemInit.redsandpile, r.nextInt(4));
		
	} 
	
	if(ConfigHandler.overridestraydrops == true) {
		if(event.getEntityLiving() instanceof EntityStray) {
			event.getEntityLiving().dropItem(ItemInit.sandpile, r.nextInt(4));
			event.getEntityLiving().dropItem(ItemInit.redsandpile, r.nextInt(4));
		}
	}
		
    }
	}
}
	
	
	