package unomodding.minecraft.tools.entity;

import java.util.UUID;

import unomodding.minecraft.tools.command.CommandSource;

public interface Player extends Entity, CommandSource {
	String getName();
	
	void chat(String msg);
	
	UUID getUUID();
}
