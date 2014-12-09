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
package unomodding.minecraft.tools.impl.bukkit.log;

import unomodding.minecraft.tools.log.LogType;
import unomodding.minecraft.tools.log.Logger;

public class BukkitLogger implements Logger {
	private java.util.logging.Logger logger;

	public BukkitLogger(java.util.logging.Logger logger) {
		this.logger = logger;
	}

	public void error(String log) {
		this.logger.severe(log);
	}

	public void info(String log) {
		this.logger.info(log);
	}

	public void trace(String log) {
		this.logger.finer(log);
	}

	public void warn(String log) {
		this.logger.warning(log);
	}

	public void log(LogType type, String log) {
		switch(type) {
			case error:
				error(log);
				break;
			case info:
				info(log);
				break;
			case trace:
				trace(log);
				break;
			case warn:
				warn(log);
				break;
		}
	}
}
