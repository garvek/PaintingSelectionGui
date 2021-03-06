package com.mcf.davidee.paintinggui;

import java.util.Arrays;

import com.mcf.davidee.paintinggui.forge.PacketPipeline;
import com.mcf.davidee.paintinggui.gui.ArtComparator;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.ModMetadata;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.event.FMLServerStartingEvent;


@Mod(modid = "PaintingSelGui", name = "PaintingSelectionGui", version = "1.7.2.0", dependencies = "after:guilib")
public class PaintingSelectionMod {
	
	public static final String CHANNEL = "PaintingSelGui";
	public static final char COLOR = '\u00A7';
	
	public static final ArtComparator ART_COMPARATOR = new ArtComparator();
	public static final PacketPipeline DISPATCHER = new PacketPipeline();
	
	@SidedProxy(clientSide="com.mcf.davidee.paintinggui.ClientProxy", serverSide="com.mcf.davidee.paintinggui.NetProxy")
	public static NetProxy proxy;
	
	@EventHandler 
	public void preInit(FMLPreInitializationEvent event) {
		ModMetadata modMeta = event.getModMetadata();
		modMeta.authorList = Arrays.asList(new String[] { "Davidee" });
		modMeta.autogenerated = false;
		modMeta.credits = "Thanks to Mojang, Forge, and all your support.";
		modMeta.description = "Select your paintings via a GUI";
		modMeta.url = "http://www.minecraftforum.net/topic/1897999-/";
	}
	
	@EventHandler
	public void init(FMLInitializationEvent event) {
		DISPATCHER.initalize();
	}
	
	@EventHandler
	public void postInit(FMLPostInitializationEvent event) {
		DISPATCHER.postInitialize();
	}
	
	@EventHandler
  	public void serverStarting(FMLServerStartingEvent event) {
 		event.registerServerCommand(new CommandPainting());
  	}
	
	
}
