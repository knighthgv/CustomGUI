package me.knighthat.plugin;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import net.kyori.adventure.text.Component;

public class MenuCommand implements CommandExecutor
{

	@Override
	public boolean onCommand( CommandSender sender, Command command, String label, String[] args ) {

		if ( !(sender instanceof Player) )
			return true;

		Player player = (Player) sender;

		Component title = Component.text("Custom GUI");
		Inventory inventory = Bukkit.createInventory(player, 27, title);

		ItemStack item = new ItemStack(Material.ELYTRA);

		inventory.addItem(item);

		player.openInventory(inventory);

		return true;
	}

}
