package me.Xephi.AntiEnderDragonPortal;

import java.io.File;
import java.util.logging.Logger;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.event.Listener;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public class AntiEnderDragonPortal extends JavaPlugin{
	
	PluginManager pm;
	public static FileConfiguration config;
	public final Logger log = Logger.getLogger("Minecraft");
	
	@Override
	public void onDisable() {
		System.out.println("[AntiEnderDragonPortal] 1.0.0 version is disabled");
	}
	
	@Override
	public void onEnable() {
		if(new File(getDataFolder()+File.separator+"config.yml").exists()){
			getConfig();
			saveConfig();
			log.info(String.format("[AntiEnderDragonPortal] Configuration is loaded"));
		}else{
			getConfig().options().copyDefaults(true);
			saveDefaultConfig();
			log.info(String.format("[AntiEnderDragonPortal] Default Config is created"));
			log.info(String.format("[AntiEnderDragonPortal] Configuration is loaded"));
		}
		pm  = this.getServer().getPluginManager();
		Listener listen = new AntiEnderDragonPortalListener(this);
		pm.registerEvents(listen, this);
		System.out.println("[AntiEnderDragonPortal] 1.0.0 version is enabled");
	}
}
