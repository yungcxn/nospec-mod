package eu.cxn.nospec.gui;

import java.io.IOException;

import org.lwjgl.input.Keyboard;

import eu.cxn.nospec.setting.Settings;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.gui.GuiSlider;
import net.minecraft.client.gui.GuiTextField;
import net.minecraft.util.EnumChatFormatting;

public class DetectorGui extends GuiScreen{
	
	public String getStateToString(String str) {
		String stateString = Settings.getState(str) ? EnumChatFormatting.GREEN + "On" : EnumChatFormatting.RED + "Off";
		return stateString;
	}
	
	int currentPosHeight = Settings.getPosHeight();
	
	String PosString = "OP-Weg: " + getStateToString("POS");
	String EPString = "EP: " + getStateToString("EP");
	String SheepString = "Schafe: " + getStateToString("SHEEP");
	String FNSString = "FNS: " + getStateToString("FNS");
	String SwordString = "Eisenschwert: " + getStateToString("SWORD");
	String PickString = "Eisenpicke: " + getStateToString("PICK");
	String PotionString = "Potion: " + getStateToString("POTION");
	
	GuiTextField textField;
	
	GuiButton EPButton = new GuiButton(0, width, height, 100, 20, EPString);
	GuiButton SheepButton = new GuiButton(1, width, height, 100, 20, SheepString);
	GuiButton FNSButton = new GuiButton(2, width, height, 100, 20, FNSString);
	GuiButton SwordButton = new GuiButton(3, width, height, 100, 20, SwordString);
	GuiButton PickButton = new GuiButton(4, width, height, 100, 20, PickString);
	GuiButton PotionButton = new GuiButton(5, width, height, 100, 20, PotionString);
	GuiButton PosButton = new GuiButton(6, width, height, 100, 20, PosString);
	GuiButton SavePosheightButton = new GuiButton(0, width, height, 100, 20, EPString);
	
	int ButtonVerticalDistance = 50;
	
	@Override
	public void initGui() {
		
		Keyboard.enableRepeatEvents(true);
		
		this.buttonList.clear();
		EPButton = new GuiButton(0, this.width / 2 - 200, this.height / 2 - ButtonVerticalDistance , 100, 20, EPString);
		SheepButton = new GuiButton(1, this.width / 2 - 200, this.height / 2 + ButtonVerticalDistance, 100, 20, SheepString);
		FNSButton = new GuiButton(2, this.width / 2 - 200 - 10, this.height / 2, 100, 20, FNSString);
		SwordButton = new GuiButton(3, this.width / 2 + 100, this.height / 2 + ButtonVerticalDistance, 100, 20, SwordString);
		PickButton = new GuiButton(4, this.width / 2 + 100, this.height / 2 - ButtonVerticalDistance, 100, 20, PickString);
		PotionButton = new GuiButton(5, this.width / 2 + 100 + 10, this.height / 2, 100, 20, PotionString);
		PosButton = new GuiButton(6, width/2 - 50, height/2, 100, 20, PosString);
		SavePosheightButton = new GuiButton(7, width/2, height/2 + 30, 50, 20, "Save");
		
		textField = new GuiTextField(99, fontRendererObj, width/2 - 50, height/2 + 30, 40, 20);
		
		this.buttonList.add(EPButton);
		this.buttonList.add(SheepButton);
		this.buttonList.add(FNSButton);
		this.buttonList.add(SwordButton);
		this.buttonList.add(PickButton);
		this.buttonList.add(PotionButton);
		this.buttonList.add(PosButton);
		this.buttonList.add(SavePosheightButton);
		textField.setMaxStringLength(3);
		textField.setCanLoseFocus(true);
		textField.setFocused(true);
		
		
		
		}
	
	
		@Override
		public void updateScreen() {
			
			textField.updateCursorCounter();
			super.updateScreen();
		}
		
		
		@Override
		protected void keyTyped(char typedChar, int keyCode) throws IOException {
			super.keyTyped(typedChar, keyCode);
			textField.textboxKeyTyped(typedChar, keyCode);
		}
		
		@Override
		public void drawScreen(int mouseX, int mouseY, float partialTicks) {
			drawDefaultBackground();
			
			textField.drawTextBox();
			
			fontRendererObj.drawString("NoSpec v.2", width / 2 - 28, height / 2 - 70, 16777215);
			fontRendererObj.drawString("by cxn.", 1, 1, 16777215);
			super.drawScreen(mouseX, mouseY, partialTicks);
			
		}
		
		@Override
		protected void actionPerformed(GuiButton button) throws IOException {
			switch(button.id) {
			case 0:
				if(Settings.getState("EP")) {
				Settings.EditAndSafeSetting("EP", 0);
				}else {
					Settings.EditAndSafeSetting("EP", 1);
				}
				EPString = "EP: " + getStateToString("EP");
				EPButton.displayString = EPString;
				EPButton.visible = true;
				break;
			case 1:
				if(Settings.getState("SHEEP")) {
					Settings.EditAndSafeSetting("SHEEP", 0);
					}else {
						Settings.EditAndSafeSetting("SHEEP", 1);
					}
				SheepString = "Schafe: " + getStateToString("SHEEP");
				SheepButton.displayString = SheepString;
				SheepButton.visible = true;
				
				break;
			case 2:
				if(Settings.getState("FNS")) {
					Settings.EditAndSafeSetting("FNS", 0);
					}else {
						Settings.EditAndSafeSetting("FNS", 1);
					}
				FNSString = "FNS: " + getStateToString("FNS");
				FNSButton.displayString = FNSString;
				FNSButton.visible = true;
				
				break;
			case 3:
				if(Settings.getState("SWORD")) {
					Settings.EditAndSafeSetting("SWORD", 0);
					}else {
						Settings.EditAndSafeSetting("SWORD", 1);
					}
				SwordString = "Eisenschwert: " + getStateToString("SWORD");
				SwordButton.displayString = SwordString;
				SwordButton.visible = true;
				
				break;
			case 4:
				if(Settings.getState("PICK")) {
					Settings.EditAndSafeSetting("PICK", 0);
					}else {
						Settings.EditAndSafeSetting("PICK", 1);
					}
				PickString = "Eisenpicke: " + getStateToString("PICK");
				PickButton.displayString = PickString;
				PickButton.visible = true;
				
				break;
			case 5:
				if(Settings.getState("POTION")) {
					Settings.EditAndSafeSetting("POTION", 0);
					}else {
						Settings.EditAndSafeSetting("POTION", 1);
					}
				PotionString = "Potion: " + getStateToString("POTION");
				PotionButton.displayString = PotionString;
				PotionButton.visible = true;
				
				break;
			case 6:
				if(Settings.getState("POS")) {
					Settings.EditAndSafeSetting("POS", 0);
					}else {
						Settings.EditAndSafeSetting("POS", 1);
					}
				PosString = "OP-Weg: " + getStateToString("POS");
				PosButton.displayString = PosString;
				PosButton.visible = true;
				break;
			case 7:
				try {
					currentPosHeight = Integer.parseInt(textField.getText());
					Settings.EditAndSafeSetting("POSHEIGHT", currentPosHeight);
				}catch(Exception e) {
					Settings.EditAndSafeSetting("POSHEIGHT", currentPosHeight);
				}
				
				textField.updateCursorCounter();
				textField.setText("");
				break;
			
			}
			
		}
		
		
	
}
