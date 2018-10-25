package trhod177.pocketsand.init;

import java.util.ArrayList;
import java.util.List;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraftforge.registries.IForgeRegistry;
import trhod177.pocketsand.ItemRedSandPiles;
import trhod177.pocketsand.ItemSandPiles;




public class ItemInit {
	
	
	
	public static ItemSandPiles sandpile = new ItemSandPiles("sandpile").setCreativeTab(CreativeTabs.MISC);
	public static ItemRedSandPiles redsandpile = new ItemRedSandPiles("redsandpile").setCreativeTab(CreativeTabs.MISC);
	
	
	public static void register(IForgeRegistry<Item> registry) {
	  registry.registerAll(
          //itemname
			  sandpile,
			  redsandpile
			  
			
	          
			  );
	  
	
	}
	
	public static void registerModels() {
	    //itemname.registerItemModel();
        sandpile.registerItemModel();
        redsandpile.registerItemModel();
		
	}
	
	

}

