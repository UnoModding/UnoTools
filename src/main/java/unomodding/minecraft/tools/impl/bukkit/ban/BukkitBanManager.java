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

import org.bukkit.BanList;
import unomodding.minecraft.tools.ban.BanEntry;
import unomodding.minecraft.tools.ban.BanManager;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class BukkitBanManager implements BanManager {
    private final BanList banList;

    public BukkitBanManager(BanList banList) {
        this.banList = banList;
    }

    public BanEntry getEntry(String target) {
        return new BukkitBanEntry(banList.getBanEntry(target));
    }

    public Set<BanEntry> getEntries() {
        Set<BanEntry> banEntries = new HashSet<BanEntry>();
        for(org.bukkit.BanEntry banEntry : banList.getBanEntries()) {
            banEntries.add(new BukkitBanEntry(banEntry));
        }
        return banEntries;
    }

    public BanEntry issueBan(String target, String source, String reason, Date expires) {
        return new BukkitBanEntry(banList.addBan(target, reason, expires, source));
    }

    public boolean isBanned(String target) {
        return banList.isBanned(target);
    }

    public void remove(String target) {
        banList.pardon(target);
    }
}
