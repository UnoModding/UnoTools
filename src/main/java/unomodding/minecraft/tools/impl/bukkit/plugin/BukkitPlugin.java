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
package unomodding.minecraft.tools.impl.bukkit.plugin;

import java.io.File;

import unomodding.minecraft.tools.Server;
import unomodding.minecraft.tools.config.Configuration;
import unomodding.minecraft.tools.impl.bukkit.BukkitServer;
import unomodding.minecraft.tools.impl.bukkit.config.BukkitConfiguration;
import unomodding.minecraft.tools.log.Logger;
import unomodding.minecraft.tools.plugin.PluginInfo;
import unomodding.minecraft.tools.plugin.Plugin;

public class BukkitPlugin extends org.bukkit.plugin.java.JavaPlugin implements PluginInfo {
	private BukkitServer server;
	private Plugin plugin;

	public BukkitPlugin(Plugin plugin) {
		this.server = new BukkitServer();
		this.plugin = plugin;
	}

	public String getVersion() {
		return getDescription().getVersion();
	}
	
	public Server getUnoServer() {
		return server;
	}

	public Logger getUnoLogger() {
		return server.getLogManager().getLogger(getName());
	}

	public Configuration getUnoConfiguration() {
		return new BukkitConfiguration(getConfig());
	}

	public File getStorageDir() {
		return getDataFolder();
	}
	
	@Override
	public void onEnable() {
		plugin.onEnable(this);
	}
	
	@Override
	public void onDisable() {
		plugin.onDisable();
	}
}
