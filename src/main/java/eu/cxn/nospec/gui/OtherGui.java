package eu.cxn.nospec.gui;

import java.io.IOException;

import org.lwjgl.input.Keyboard;

import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.gui.GuiSlider;
import net.minecraft.client.gui.GuiTextField;

public class OtherGui extends GuiScreen{
	
	
	@Override
	public void initGui() {
		
		Keyboard.enableRepeatEvents(true);
		
		
		buttonList.clear();
		
		GuiButton HeartsButton = new GuiButton(1, width, height, 100, 20, "Hearts");
		
		buttonList.add(HeartsButton);
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
		fontRendererObj.drawString("Coming Soon", width / 2 - 30, height / 2 - 10, 16777215);
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

