package black.force.listeners;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;

import black.force.Black;

public class Listeners implements Listener {
	
	private Black plugin;
	
	public Listeners(Black plugin) {
		this.plugin = plugin;
		
		plugin.getServer().getPluginManager().registerEvents(this, plugin);
		plugin.getServer().getPluginManager().registerEvents(this, plugin);
	}
	
	@EventHandler
	public void comando(PlayerCommandPreprocessEvent event) {
		if (event.getMessage().startsWith(getPlugin().getConfig().getString("Configuracoes.Comando"))) {
			if (!getPlugin().getConfig().getStringList("Lista").contains(event.getPlayer().getName())) {
				event.getPlayer().sendMessage(getPlugin().getConfig().getString("Configuracoes.Mensagem").replace("&", "§"));
				
				event.setCancelled(true);
			}
		}
	}

	public Black getPlugin() {
		return plugin;
	}

	public void setPlugin(Black plugin) {
		this.plugin = plugin;
	}
}