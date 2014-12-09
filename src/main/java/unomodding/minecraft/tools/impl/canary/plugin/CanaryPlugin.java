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
package unomodding.minecraft.tools.impl.canary.plugin;

import unomodding.minecraft.tools.Server;
import unomodding.minecraft.tools.impl.canary.CanaryServer;
import unomodding.minecraft.tools.log.Logger;
import unomodding.minecraft.tools.plugin.IPlugin;
import unomodding.minecraft.tools.plugin.Plugin;

public class CanaryPlugin extends net.canarymod.plugin.Plugin implements IPlugin {
	private CanaryServer server;
	private Plugin plugin;

	public CanaryPlugin(Plugin plugin) {
		this.server = new CanaryServer();
		this.plugin = plugin;
	}
	
	public Server getUnoServer() {
		return server;
	}

	public Logger getUnoLogger() {
		return server.getLogManager().getLogger(getName());
	}

	@Override
	public boolean enable() {
		plugin.onEnable(this);
		return true;
	}

	@Override
	public void disable() {
		plugin.onDisable();
	}
}
