package eu.cxn.nospec.gui;

import java.io.IOException;

import org.lwjgl.input.Keyboard;
import org.lwjgl.input.Mouse;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiMainMenu;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.gui.GuiSlider;
import net.minecraft.client.gui.GuiTextField;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.util.Util;
import net.minecraftforge.client.event.GuiScreenEvent.ActionPerformedEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class MainGui extends GuiScreen {
	
	public static boolean showMainGui = false;
	
	GuiButton DetectorButton = new GuiButton(0, this.width / 2 - 150, this.height / 2, 100, 20, "Detector");
	GuiButton otherButton = new GuiButton(1, this.width / 2 + 50, this.height / 2, 100, 20, "Other");
	//CustomButton testButton = new CustomButton(2, width, height, 100, 20, "TEST");
	
	
	@Override
	public void initGui() {
		
		Keyboard.enableRepeatEvents(true);
		//Mouse.setGrabbed(true);
		
		this.buttonList.clear();

		this.DetectorButton = new GuiButton(0, this.width / 2 - 150, this.height / 2, 100, 20, "Detector");
		this.otherButton = new GuiButton(1, this.width / 2 + 50, this.height / 2, 100, 20, "Other");
		//this.testButton = new CustomButton(2, width / 2 - 50, height / 2 + 100, 100, 20, "TEST");
		
		this.buttonList.add(DetectorButton);
		this.buttonList.add(otherButton);
		//this.buttonList.add(testButton);
		}
	
	
	
	@Override
	public void updateScreen() {
		
		super.updateScreen();
	}
	
	@Override
	protected void keyTyped(char typedChar, int keyCode) throws IOException {
		super.keyTyped(typedChar, keyCode);
	}
	
	@Override
	public void drawScreen(int mouseX, int mouseY, float partialTicks) {
		drawDefaultBackground();
		
		fontRendererObj.drawString("NoSpec v.2", this.width / 2 - 28, this.height / 2 - 70, 16777215);
		fontRendererObj.drawString("by cxn.", 1, 1, 16777215);
		super.drawScreen(mouseX, mouseY, partialTicks);
	}
	

	@Override
	protected void actionPerformed(GuiButton button) throws IOException {
		switch(button.id) {
		case 0:
			
			Minecraft.getMinecraft().displayGuiScreen((GuiScreen)new DetectorGui());
			break;
		case 1:
			Minecraft.getMinecraft().displayGuiScreen((GuiScreen)new OtherGui());
			break;
		}
		
	}
	

	
	
	
	
	
	
	
	
}
