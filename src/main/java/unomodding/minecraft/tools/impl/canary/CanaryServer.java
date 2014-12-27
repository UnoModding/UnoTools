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
package unomodding.minecraft.tools.impl.canary;

import java.io.File;

import net.canarymod.Canary;
import net.canarymod.config.Configuration;
import unomodding.minecraft.tools.Platform;
import unomodding.minecraft.tools.Server;
import unomodding.minecraft.tools.ServerSettings;
import unomodding.minecraft.tools.ban.BanManager;
import unomodding.minecraft.tools.entity.Player;
import unomodding.minecraft.tools.impl.canary.ban.CanaryBanManager;
import unomodding.minecraft.tools.impl.canary.entity.CanaryPlayer;
import unomodding.minecraft.tools.impl.canary.log.CanaryLogManager;

public class CanaryServer implements Server {
	private net.canarymod.api.Server server;
	private CanaryLogManager logManager;
	private CanaryServerSettings serverSettings;
	
	public CanaryServer() {
		server = Canary.getServer();
		logManager = new CanaryLogManager();
		serverSettings = new CanaryServerSettings();
	}
	
	public Platform getPlatform() {
		return Platform.canary;
	}

	public ServerSettings getServerSettings() {
		return serverSettings;
	}

	public String getIP() {
		return Configuration.getServerConfig().getBindIp();
	}

	public int getPort() {
		return Configuration.getServerConfig().getPort();
	}

	public void stopServer() {
		server.initiateShutdown(null);
	}

	public File getServerDir() {
		return Canary.getWorkingDirectory();
	}
	
	public CanaryLogManager getLogManager() {
		return logManager;
	}

	public BanManager getManager(BanManager.BanType type) {
		return new CanaryBanManager(Canary.bans(), type);
	}

	public Player[] getPlayers() {
		Player[] players = new Player[server.getPlayerList().size()];
		int i = 0;
		for(net.canarymod.api.entity.living.humanoid.Player player : server.getPlayerList()) {
			players[i] = new CanaryPlayer(player);
			i++;
		}
		return players;
	}
	
	private class CanaryServerSettings implements ServerSettings {
		public boolean isOnlineMode() {
			return Configuration.getServerConfig().isOnlineMode();
		}

		public String getMOTD() {
			return Configuration.getServerConfig().getMotd();
		}
	}
}
