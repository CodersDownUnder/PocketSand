package trhod177.pocketsand;


import net.minecraft.util.ResourceLocation;

public class EntityRegistry {
	public static void registerEntities() {
		net.minecraftforge.fml.common.registry.EntityRegistry.registerModEntity(new ResourceLocation(References.MODID + ":sandpiles"), EntitySandPiles.class, "sandpile", -1, PocketSand.instance, 64, 1, true);
		net.minecraftforge.fml.common.registry.EntityRegistry.registerModEntity(new ResourceLocation(References.MODID + ":redsandpiles"), EntityRedSandPiles.class, "redsandpile", -2, PocketSand.instance, 64, 1, true);
	
	}
}