package me.Xephi.AntiEnderDragonPortal;

import java.io.File;
import java.util.List;
import java.util.logging.Logger;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.event.Listener;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public class AntiEnderDragonPortal extends JavaPlugin{
	
	PluginManager pluginmanager;
	public static FileConfiguration config;
	public final Logger log = Logger.getLogger("Minecraft");
	List<String> worldList;
	
	@Override
	public void onDisable() {
		System.out.println("[AntiEnderDragonPortal] 1.1 version is disabled");
	}
	
	@Override
	public void onEnable() {
		if(new File(getDataFolder()+File.separator+"config.yml").exists()){
			getConfig();
			saveConfig();
			config = getConfig();
			worldList = config.getStringList("Worlds");
			log.info(String.format("[AntiEnderDragonPortal] Configuration is loaded"));
		}else {
			getConfig().options().copyDefaults(true);
			saveDefaultConfig();
			config = getConfig();
			worldList = config.getDefaultSection().getStringList("Worlds");
			log.info(String.format("[AntiEnderDragonPortal] Default Config is created"));
			log.info(String.format("[AntiEnderDragonPortal] Configuration is loaded"));
		}
		pluginmanager  = this.getServer().getPluginManager();
		Listener listener = new AntiEnderDragonPortalListener(this);
		pluginmanager.registerEvents(listener, this);
		System.out.println("[AntiEnderDragonPortal] 1.1 version is enabled");
	}
}
