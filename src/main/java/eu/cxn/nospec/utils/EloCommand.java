package eu.cxn.nospec.utils;

import java.util.List;

import eu.cxn.nospec.elo.EloCalculator;
import eu.cxn.nospec.gui.MainGui;
import eu.cxn.nospec.setting.Settings;
import net.minecraft.client.Minecraft;
import net.minecraft.command.CommandBase;
import net.minecraft.command.CommandException;
import net.minecraft.command.ICommandSender;
import net.minecraft.scoreboard.Scoreboard;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.util.IChatComponent;

public class EloCommand  extends CommandBase{
	

	@Override
	public String getCommandName() {
		return "elo";
	}

	@Override
	public String getCommandUsage(ICommandSender sender) {
		return "/" + getCommandName();
	}
	
	public boolean canCommandSenderUseCommand(ICommandSender sender) {
		return true; 
	}
	
	@Override
	public int getRequiredPermissionLevel() {
		return 0;
	}

	@Override
	public void processCommand(ICommandSender sender, String[] args) throws CommandException {
		
		EloCalculator.init();
		
		
	}

}

	

