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
package unomodding.minecraft.tools.impl.canary.log;

import net.canarymod.logger.Logman;
import unomodding.minecraft.tools.log.LogType;
import unomodding.minecraft.tools.log.Logger;

public class CanaryLogger implements Logger {
	private Logman logman;

	public CanaryLogger(Logman logman) {
		this.logman = logman;
	}

	public void error(String log) {
		this.logman.error(log);
	}

	public void info(String log) {
		this.logman.info(log);
	}

	public void trace(String log) {
		this.logman.trace(log);
	}

	public void warn(String log) {
		this.logman.warn(log);
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
