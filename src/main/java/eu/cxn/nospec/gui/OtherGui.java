package eu.cxn.nospec.gui;

import java.io.IOException;

import org.lwjgl.input.Keyboard;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.gui.GuiSlider;
import net.minecraft.client.gui.GuiTextField;

public class OtherGui extends GuiScreen{
	
	
	@Override
	public void initGui() {
		
		Keyboard.enableRepeatEvents(true);
		
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
		fontRendererObj.drawString("NoSpec v.2", width / 2 - 28, height / 2 - 70, 16777215);
		fontRendererObj.drawString("/elo fuer Elo-Anzeigen im CW", width / 2 - Minecraft.getMinecraft().fontRendererObj.getStringWidth("/elo fuer Elo-Anzeigen im CW") / 2, height / 2, 16777215);
		
		fontRendererObj.drawString("by cxn.", 1, 1, 16777215);
		super.drawScreen(mouseX, mouseY, partialTicks);
	}
	
	@Override
	protected void actionPerformed(GuiButton button) throws IOException {
		switch(button.id) {
		case 0:
			break;
		case 1:
			break;
		
		}
		
	}
	
	
	
	
	
	
}

