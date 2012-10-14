package me.Xephi.AntiEnderDragonPortal;

import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.*;

public class AntiEnderDragonPortalListener implements Listener {
	
	AntiEnderDragonPortal main;
	
	public AntiEnderDragonPortalListener(AntiEnderDragonPortal main) {
		this.main = main;
	}

	@EventHandler(priority = EventPriority.HIGH)
	public void onEntityCreatePortalEvent(EntityCreatePortalEvent event) {
		for(String world : AntiEnderDragonPortal.config.getStringList("Worlds")){
			if(event.getEntity().getWorld().getName().equalsIgnoreCase(world)){
				event.setCancelled(true);
				
			}
		}
	}
}
