package trhod177.pocketsand;

import java.io.File;

import javax.annotation.Nullable;

import org.lwjgl.opengl.GL11;

import net.minecraft.block.Block;
import net.minecraft.block.BlockSand;
import net.minecraft.block.BlockSandStone;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.PotionEffect;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.DamageSource;
import net.minecraft.util.NonNullList;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;
import trhod177.pocketsand.handlers.ConfigHandler;
import trhod177.pocketsand.handlers.PocketSandEventHandler;
import trhod177.pocketsand.init.ItemInit;
import trhod177.pocketsand.init.MobDrops;
import trhod177.pocketsand.proxy.CommonProxy;


@Mod(modid = References.MODID, name = References.NAME, version = References.VERSION)
public class PocketSand {
	
	 

	    
	    public static File config;
	    
		
		@SidedProxy(clientSide = References.CLIENTPROXY, serverSide = References.COMMONPROXY)
		public static CommonProxy proxy;
		
		@Mod.Instance(References.MODID)
		public static PocketSand instance;

		@Mod.EventBusSubscriber
		public static class RegistrationHandler {

			@SubscribeEvent
			public static void registerBlocks(RegistryEvent.Register<Block> event) {
				
				
			}
			

			@SubscribeEvent
			public static void registerItems(RegistryEvent.Register<Item> event) {
				ItemInit.register(event.getRegistry());
				
				
			}
			
			@SubscribeEvent
			public static void registerModels(ModelRegistryEvent event) {
				ItemInit.registerModels();
				
				
			}
			
			@SubscribeEvent
			public static void registerItems(ModelRegistryEvent event) {
				ItemInit.registerModels();
			}
			

	  
		}
		
		public void registerItemRenderer(Item item, int meta, String id) {
			ModelLoader.setCustomModelResourceLocation(item, meta, new ModelResourceLocation(References.MODID + ":" + id, "inventory"));
			new ModelResourceLocation(item.getRegistryName() + "variantName", "inventory");
			
		}
		
		
		
		@EventHandler
		public static void preInit(FMLPreInitializationEvent event) {
			proxy.preInit(event);
			ConfigHandler.registerConfig(event);
		    
		}
		
		@EventHandler
		public static void init(FMLInitializationEvent event) {
			proxy.init(event);
            
			MinecraftForge.EVENT_BUS.register(new MobDrops());
			EntityRegistry.registerEntities();
			MinecraftForge.EVENT_BUS.register(new PocketSandEventHandler());
			
			
			
		}
		
		@EventHandler
		public static void postInit(FMLPostInitializationEvent event) {
			proxy.postInit(event);
		}
		
	    
		
		
		
		
		    
}
		


