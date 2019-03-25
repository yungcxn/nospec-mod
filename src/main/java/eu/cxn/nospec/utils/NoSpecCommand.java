package eu.cxn.nospec.utils;

import eu.cxn.nospec.gui.MainGui;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.command.CommandBase;
import net.minecraft.command.CommandException;
import net.minecraft.command.ICommand;
import net.minecraft.command.ICommandSender;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.EnumChatFormatting;

public class NoSpecCommand extends CommandBase{
	

	@Override
	public String getCommandName() {
		return "nospec";
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
		//FOR TEST PURPOSE: Minecraft.getMinecraft().thePlayer.addChatComponentMessage(new ChatComponentText("Hallo"));
		//Minecraft.getMinecraft().displayGuiScreen((GuiScreen)new MainGui());
		//ersetzt durch bool mit clienttick on wait:
		
		if(args.length == 0) {
			MainGui.showMainGui = true;
		}
	}

}
