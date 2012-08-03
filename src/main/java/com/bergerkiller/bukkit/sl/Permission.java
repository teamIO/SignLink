package com.bergerkiller.bukkit.sl;

import java.util.logging.Level;

import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

public class Permission {

	public static boolean has(Player player, String node) {
		//Build-in permissions
		return player.hasPermission("signlink." + node);
	}
	public static boolean hasGlobal(Player player, String node, String name) {
		return has(player, node + name) || has(player, node + "*");
	}

}
