package me.Xephi.AntiEnderDragonPortal;

import org.bukkit.entity.EnderDragon;
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
		if (event.getEntity() instanceof EnderDragon && main.worldList.contains(event.getEntity().getWorld().getName())){
			event.setCancelled(true);
		}
	}
}
