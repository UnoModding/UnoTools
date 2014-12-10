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
package unomodding.minecraft.tools.impl.canary.config;

import unomodding.minecraft.tools.config.Configuration;
import unomodding.minecraft.tools.config.KeyException;

public class CanaryConfiguration implements Configuration {
	private net.visualillusionsent.utils.PropertiesFile configuration;

	public CanaryConfiguration(net.visualillusionsent.utils.PropertiesFile configuration) {
		this.configuration = configuration;
	}
	
	public void setString(String key, String value) {
		configuration.setString(key, value);
	}

	public void setInt(String key, int value) {
		configuration.setInt(key, value);
	}

	public void setBoolean(String key, boolean value) {
		configuration.setBoolean(key, value);
	}

	public String getString(String key) throws KeyException {
		String result = configuration.getString(key);
		if(result != null) {
			return result;
		}
		throw new KeyException(key);
	}

	public String getString(String key, String defaultValue) {
		return configuration.getString(key, defaultValue);
	}

	public int getInt(String key) throws KeyException {
		Integer result = configuration.getInt(key);
		if(result != null) {
			return result;
		}
		throw new KeyException(key);
	}

	public int getInt(String key, int defaultValue) {
		return configuration.getInt(key, defaultValue);
	}

	public boolean getBoolean(String key) throws KeyException {
		Boolean result = configuration.getBoolean(key);
		if(result != null) {
			return result;
		}
		throw new KeyException(key);
	}

	public boolean getBoolean(String key, boolean defaultValue) {
		return configuration.getBoolean(key, defaultValue);
	}
}
