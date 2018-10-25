package trhod177.pocketsand.handlers;

import java.util.List;

import net.minecraft.block.Block;
import net.minecraft.block.BlockPrismarine;
import net.minecraft.block.BlockSand;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraftforge.event.world.BlockEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.Mod.Metadata;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import trhod177.pocketsand.init.ItemInit;


public class PocketSandEventHandler {
	
    
	
	
     
	@SubscribeEvent
	public static void onHarvestBlock(BlockEvent.HarvestDropsEvent event)
	{
		final EntityPlayer PLAYER = event.getHarvester();
		if(null == PLAYER || null == PLAYER.getHeldItemMainhand()) return;

		if(ConfigHandler.overridesanddrops == true) {
		
		if(event.getState().getBlock() == Blocks.SAND.getDefaultState().withProperty(BlockSand.VARIANT, BlockSand.EnumType.SAND))
		{
			event.getDrops().add(new ItemStack(ItemInit.sandpile, 4));
			event.getDrops().remove(0);
			
			
 
			
		}

		}
		
		if(ConfigHandler.overrideredsanddrops == true) {
			
			   if(event.getState().getBlock() ==  Blocks.SAND.getDefaultState().withProperty(BlockSand.VARIANT, BlockSand.EnumType.RED_SAND)) {
					
					event.getDrops().add(new ItemStack(ItemInit.redsandpile, 4));
					event.getDrops().remove(0);
				}
		}
		
		
	}
	}
	
