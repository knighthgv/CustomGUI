package me.knighthat.plugin;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.serializer.plain.PlainTextComponentSerializer;

public class EventListener implements Listener
{

	@EventHandler
	public void onClick( InventoryClickEvent event ) {

		if ( event.getInventory() == null || event.getCurrentItem() == null )
			return;

		String menu_title = PlainTextComponentSerializer.plainText().serialize(event.getView().title());
		if ( !menu_title.equals("Custom GUI") )
			return;

		event.setCancelled(true);

		if ( !event.getCurrentItem().getType().equals(Material.ELYTRA) )
			return;

		Player player = (Player) event.getWhoClicked();

		player.setAllowFlight(!player.getAllowFlight());

		Component message = Component.text("Chế độ bay: " + player.getAllowFlight());
		player.sendMessage(message);
	}

}
