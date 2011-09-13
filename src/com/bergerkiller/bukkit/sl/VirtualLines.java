package com.bergerkiller.bukkit.sl;

import net.minecraft.server.Packet130UpdateSign;

import org.bukkit.craftbukkit.entity.CraftPlayer;
import org.bukkit.entity.Player;

public class VirtualLines {
	private String[] lines;
	private boolean changed = false;
	
	public VirtualLines(String[] lines) {
		this.lines = new String[4];
		for (int i = 0; i < 4; i++) {
			this.lines[i] = lines[i];
		}
	}
	
	public void set(int index, String value) {
		if (this.changed || !this.lines[index].equals(value)) {
			this.changed = true;
			this.lines[index] = value;
		}
	}
	public String get(int index) {
		return lines[index];
	}
	public String[] get() {
		return this.lines;
	}
	
	public boolean hasChanged() {
		return this.changed;
	}
	public void setChanged() {
		setChanged(true);
	}
	public void setChanged(boolean changed) {
		this.changed = changed;
	}
	
	public void updateSign(Player player, int x, int y, int z) {
		if (SignLink.updateSigns) {
			CraftPlayer p = (CraftPlayer) player;
			Packet130UpdateSign packet = new Packet130UpdateSign(x, y, z, lines);
			p.getHandle().netServerHandler.sendPacket(packet);
		}
	}
	
}