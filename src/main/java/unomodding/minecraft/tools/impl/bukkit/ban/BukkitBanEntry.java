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
package unomodding.minecraft.tools.impl.bukkit.ban;

import unomodding.minecraft.tools.ban.BanEntry;

import java.util.Date;

public class BukkitBanEntry implements BanEntry {
    private final org.bukkit.BanEntry banEntry;

    public BukkitBanEntry(org.bukkit.BanEntry banEntry) {
        this.banEntry = banEntry;
    }
    
    public String getTarget() {
        return banEntry.getTarget();
    }

    public String getSource() {
        return banEntry.getSource();
    }

    public void setSource(String source) {
        banEntry.setSource(source);
    }

    public String getReason() {
        return banEntry.getReason();
    }

    public void setReason(String reason) {
        banEntry.setReason(reason);
    }

    public Date getCreated() {
        return banEntry.getCreated();
    }

    public void setCreated(Date created) {
        banEntry.setCreated(created);
    }

    public Date getExpiration() {
        return banEntry.getExpiration();
    }

    public void setExpiration(Date expiration) {
        banEntry.setExpiration(expiration);
    }

    public void save() {
        banEntry.save();
    }
}
