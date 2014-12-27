/**
 * This file is part of UnoTools, a cross-platform Minecraft server API, licensed under the MIT License (MIT).
 *
 * Copyright (c) UnoModding <https://github.com/UnoModding>
 * Copyright (c) contributors
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */
package unomodding.minecraft.tools.impl.bukkit;

import java.io.File;

import org.bukkit.BanList;
import org.bukkit.Bukkit;

import unomodding.minecraft.tools.Platform;
import unomodding.minecraft.tools.Server;
import unomodding.minecraft.tools.ServerSettings;
import unomodding.minecraft.tools.ban.BanManager;
import unomodding.minecraft.tools.entity.Player;
import unomodding.minecraft.tools.impl.bukkit.ban.BukkitBanManager;
import unomodding.minecraft.tools.impl.bukkit.entity.BukkitPlayer;
import unomodding.minecraft.tools.impl.bukkit.log.BukkitLogManager;

public class BukkitServer implements Server {
	private org.bukkit.Server server;
	private BukkitLogManager logManager;
	private BukkitServerSettings serverSettings;
	
	public BukkitServer() {
		server = Bukkit.getServer();
		logManager = new BukkitLogManager();
		serverSettings = new BukkitServerSettings(server);
	}
	
	public Platform getPlatform() {
		return Platform.bukkit;
	}

	public ServerSettings getServerSettings() {
		return serverSettings;
	}

	public String getIP() {
		return server.getIp();
	}

	public int getPort() {
		return server.getPort();
	}

	public void stopServer() {
		server.shutdown();
	}

	public File getServerDir() {
		return null; //TODO: how can I go about doing this?
	}
	
	public BukkitLogManager getLogManager() {
		return logManager;
	}

	public BanManager getManager(BanManager.BanType type) {
		switch(type) {
			case ip:
				return new BukkitBanManager(server.getBanList(BanList.Type.IP));
			case name:
			default:
				return new BukkitBanManager(server.getBanList(BanList.Type.NAME));
		}
	}

	public Player[] getPlayers() {
		Player[] players = new Player[server.getOnlinePlayers().length];
		int i = 0;
		for(org.bukkit.entity.Player player : server.getOnlinePlayers()) {
			players[i] = new BukkitPlayer(player);
			i++;
		}
		return players;
	}
	
	private class BukkitServerSettings implements ServerSettings {
		private org.bukkit.Server server;

		public BukkitServerSettings(org.bukkit.Server server) {
			this.server = server;
		}

		public boolean isOnlineMode() {
			return server.getOnlineMode();
		}

		public String getMOTD() {
			return server.getMotd();
		}
	}
}
