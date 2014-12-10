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
package unomodding.minecraft.tools.impl.canary.entity;

import java.util.List;
import java.util.UUID;

import unomodding.minecraft.tools.entity.EntityType;
import unomodding.minecraft.tools.entity.Player;

public class CanaryPlayer extends CanaryEntity implements Player {
	private net.canarymod.api.entity.living.humanoid.Player entity;

	public CanaryPlayer(net.canarymod.api.entity.living.humanoid.Player entity) {
		super(entity);
		this.entity = entity;
	}

	public String getName() {
		return entity.getName();
	}

	public void chat(String msg) {
		entity.chat(msg);
	}

	public UUID getUUID() {
		return entity.getUUID();
	}

	public void sendMessage(String... messages) {
		for(String msg : messages) {
			entity.message(msg);
		}
	}

	public void sendMessage(List<String> messages) {
		for(String msg : messages) {
			entity.message(msg);
		}
	}

	public EntityType getType() {
		return EntityType.player;
	}
}
