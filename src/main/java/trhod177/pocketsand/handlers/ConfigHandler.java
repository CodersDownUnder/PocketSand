package trhod177.pocketsand.handlers;

import java.io.File;

import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import trhod177.pocketsand.PocketSand;
import trhod177.pocketsand.References;

public class ConfigHandler {
	
	public static Configuration config;
	

	
	public static boolean overridehuskdrops;
	public static boolean overridestraydrops;
	public static boolean overridesanddrops;
	public static boolean overrideredsanddrops;
	public static String VERSION;
	
	public static void init(File file) {
		
		config = new Configuration(file);
		
		String category;
		
		
		category = "Drops";
		config.addCustomCategoryComment(category, "/");
	    overridehuskdrops = config.getBoolean("Override MobDrops", category, true, "If true sand piles will be dropped from husks");
	    overridestraydrops = config.getBoolean("Override MobDrops", category, true, "If true sand piles will be dropped from strays");
	    overridesanddrops = config.getBoolean("Override SandDrops", category, true, "If true sand will drop sand piles when broken");
	    overrideredsanddrops = config.getBoolean("Override RedSandDrops", category, true, "If true red sand will drop red sand piles when broken");
	    
	   config.save();
	}
	
	public static void registerConfig(FMLPreInitializationEvent event) {
		PocketSand.config = new File(event.getModConfigurationDirectory() + "/" + References.MODID);
		PocketSand.config.mkdirs();
		init(new File(PocketSand.config.getPath(), References.MODID + ".cfg"));
				
	}
	

}
