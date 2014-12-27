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
package unomodding.minecraft.tools.impl.canary.ban;

import net.canarymod.Canary;
import net.canarymod.bansystem.Ban;
import unomodding.minecraft.tools.ban.BanEntry;
import unomodding.minecraft.tools.ban.BanManager;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class CanaryBanManager implements BanManager {
    private final net.canarymod.bansystem.BanManager banManager;
    private final BanType banType;

    public CanaryBanManager(net.canarymod.bansystem.BanManager banManager, BanType banType) {
        this.banManager = banManager;
        this.banType = banType;
    }

    public BanEntry getEntry(String target) {
        BanEntry entry = null;
        for (Ban ban : banManager.getAllBans()) {
            if (ban.getSubject().equalsIgnoreCase(target) && (ban.isIpBan() == (banType == BanType.ip))) {
                entry = new CanaryBanEntry(ban);
            }
        }
        return entry;
    }

    public Set<BanEntry> getEntries() {
        Set<BanEntry> bans = new HashSet<BanEntry>();
        for (Ban ban : banManager.getAllBans()) {
            if (ban.isIpBan() == (banType == BanType.ip)) {
                bans.add(new CanaryBanEntry(ban));
            }
        }
        return bans;
    }

    public BanEntry issueBan(String target, String source, String reason, Date expires) {
        Ban ban = new Ban(Canary.getServer().getPlayer(target), reason, (banType == BanType.ip));
        ban.setBanningPlayer(source);
        banManager.issueBan(ban);
        return getEntry(target);
    }

    public boolean isBanned(String target) {
        return banManager.isBanned(target);
    }

    public void remove(String target) {
        banManager.unban(target);
    }
}
