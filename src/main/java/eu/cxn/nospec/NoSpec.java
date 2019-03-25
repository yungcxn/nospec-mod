package eu.cxn.nospec;

import eu.cxn.nospec.gui.DetectorGui;
import eu.cxn.nospec.gui.MainGui;
import eu.cxn.nospec.gui.OtherGui;
import eu.cxn.nospec.proxies.CommonProxy;
import eu.cxn.nospec.setting.Settings;
import eu.cxn.nospec.utils.Events;
import eu.cxn.nospec.utils.NoSpecCommand;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraftforge.client.ClientCommandHandler;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.FMLCommonHandler;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.event.FMLServerStartingEvent;

@Mod(modid = NoSpec.MODID, version = NoSpec.VERSION)
public class NoSpec
{
	
	/*
	 *	public static double getDistanceToEntity(Entity entity, BlockPos pos) {
			double deltaX = entity.posX - pos.getX();
			double deltaY = entity.posY - pos.getY();
			double deltaZ = entity.posZ - pos.getZ();
		
			return Math.sqrt((deltaX * deltaX) + (deltaY * deltaY) + (deltaZ * deltaZ));
		} 
		distanceSq(BlockPos, otherPos)
	 * 
	 * 
	 * 
	 * 
	 */
	
	
	public final static boolean isDebug = java.lang.management.ManagementFactory.getRuntimeMXBean().
		    getInputArguments().toString().indexOf("-agentlib:jdwp") > 0;
		    

    public final static boolean isEclipse = System.getProperty("java.class.path").toLowerCase().contains("eclipse");
	
	

    public static final String MODID = "noSpec";
    public static final String VERSION = "1.0";
    
    @Mod.Instance
    public static NoSpec instance;
    
    @SidedProxy(clientSide = "eu.cxn.nospec.proxies.ClientProxy", serverSide = "eu.cxn.nospec.proxies.CommonProxy")
    public static CommonProxy proxy;

    
    
    
    @EventHandler
    public void preInit(FMLPreInitializationEvent event)
    {
    	
    }
    
    @EventHandler
    public void init(FMLInitializationEvent event)
    {    	
    	Settings.loadSetting();
    	MinecraftForge.EVENT_BUS.register(new Events());
    	ClientCommandHandler.instance.registerCommand(new NoSpecCommand());
    	FMLCommonHandler.instance().bus().register(this);
    	System.out.println("DEBUG-MODE: " + isDebug);
    	System.out.println("ECLIPSE-MODE: " + isEclipse);
    }
    
    @EventHandler
    public void postInit(FMLPostInitializationEvent event)
    {

    }
    
   /*
    @EventHandler
    public void serverStarting(FMLServerStartingEvent ev){
    	
        ev.registerServerCommand(new NoSpecCommand());
        
    }
    */
}
