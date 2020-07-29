package black.force;

import org.bukkit.plugin.java.*;

import black.force.listeners.Listeners;

public class Black extends JavaPlugin {
	
	@Override
	public void onEnable() {
		saveDefaultConfig();
		
		new Listeners(this);
	}
	
	@Override
	public void onDisable() {
	}
}