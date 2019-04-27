package eu.cxn.nospec.elo;

import java.io.IOException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.nodes.Node;
import org.jsoup.select.Elements;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiIngame;
import net.minecraft.scoreboard.Score;
import net.minecraft.scoreboard.ScoreObjective;
import net.minecraft.scoreboard.ScorePlayerTeam;
import net.minecraft.scoreboard.Scoreboard;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.util.IChatComponent;
import net.minecraftforge.fml.common.ObfuscationReflectionHelper;
import net.minecraftforge.fml.relauncher.ReflectionHelper;

public class EloCalculator {

	static Document GommeWebsite;
	static Elements Value;
	static String nodeBufferBlue;
	static String nodeBufferRed;
	
	static double winEloRed;
	static double winEloBlue;
	static double winPercentageRed;
	static double winPercentageBlue;

	public static String getCurrentActionBar() {
		
		try {
			String actionBar = (String) ReflectionHelper.findField(GuiIngame.class, "displayedActionBar", "recordPlaying", "field_73838_g").get(Minecraft.getMinecraft().ingameGUI);
			return actionBar;
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}
		return null;
	}
	
    public static void init() {
    	Minecraft minecraft = Minecraft.getMinecraft();
    	String currentClanWar = getCurrentActionBar().trim();
    	String[] barBuffer = currentClanWar.split(" ");
    	
        String TeamRed = null;
        String TeamBlue = null;
        if(barBuffer.length == 5) {
        	try {
        		TeamRed = barBuffer[3].trim().substring(2);
        		TeamBlue = barBuffer[0].trim().substring(2);

        		
        	}catch(Exception e) {
        		Minecraft.getMinecraft().thePlayer.addChatMessage(new ChatComponentText(EnumChatFormatting.RED + "[NoSpec] " +  EnumChatFormatting.DARK_RED + "Nicht verfuegbar!"));
                return;
        	}
        	
        	if(TeamRed == null || TeamBlue == null) {
        		Minecraft.getMinecraft().thePlayer.addChatMessage(new ChatComponentText(EnumChatFormatting.RED + "[NoSpec] " +  EnumChatFormatting.DARK_RED + "Nicht verfuegbar!"));
                return;
        	}
        	
        	
        	try {
    			GommeWebsite = Jsoup.connect("https://www.gommehd.net/clan-profile/wars/?name=" + TeamBlue).get();
    			Value = GommeWebsite.select("table.table.bedwars");
    			for(Element elem: Value){
    				for(Node node: elem.childNodes()){
    					nodeBufferBlue = nodeBufferBlue + node;
    				}
    				
    			}	
    			
    			GommeWebsite = Jsoup.connect("https://www.gommehd.net/clan-profile/wars/?name=" + TeamRed).get();
    			Value = GommeWebsite.select("table.table.bedwars");
    			for(Element elem: Value){
    				for(Node node: elem.childNodes()){
    					nodeBufferRed = nodeBufferRed + node;
    				}
    				
    			}	
    			
    		} catch (IOException e) {
    			e.printStackTrace();
    		}
        	
        	String eloRed =  nodeBufferRed.split("</tr>")[1].split("<span>")[1].split("</span>")[0].trim();
        	String eloBlue =  nodeBufferBlue.split("</tr>")[1].split("<span>")[1].split("</span>")[0].trim();
        	
        	int eloRedNum = Integer.parseInt(eloRed);
        	int eloBlueNum = Integer.parseInt(eloBlue);
        	
        	winPercentageRed = 1.0 / ( 1.0+ Math.pow(10.0,(eloBlueNum-eloRedNum)/400.0));
        	winPercentageBlue = 1.0/(1.0+ Math.pow(10.0,(eloRedNum-eloBlueNum)/400.0));
        	winEloRed = eloRedNum + 50.0 * (1.0 - winPercentageRed);
        	winEloBlue = eloBlueNum + 50.0 * (1.0 - winPercentageBlue);

        	String tempString = Double.toString(winPercentageRed * 100).substring(0,4);
        	winPercentageRed = Double.parseDouble(tempString);
        	tempString = Double.toString(winPercentageBlue * 100).substring(0,4);
        	winPercentageBlue = Double.parseDouble(tempString);
        	
        	
        	Minecraft.getMinecraft().thePlayer.addChatMessage(new ChatComponentText(EnumChatFormatting.RED + "[NoSpec] " +  EnumChatFormatting.DARK_RED + TeamRed + EnumChatFormatting.GRAY + " gewinnt zu " + EnumChatFormatting.GOLD + winPercentageRed + " %"));
        	Minecraft.getMinecraft().thePlayer.addChatMessage(new ChatComponentText(EnumChatFormatting.RED + "[NoSpec] " +  EnumChatFormatting.DARK_RED + TeamBlue + EnumChatFormatting.GRAY + " gewinnt zu " + EnumChatFormatting.GOLD + winPercentageBlue+ " %"));
        	
        	Minecraft.getMinecraft().thePlayer.addChatMessage(new ChatComponentText(EnumChatFormatting.RED + "[NoSpec] " +  EnumChatFormatting.DARK_RED + TeamRed + EnumChatFormatting.GRAY + " kriegt bei Win " + EnumChatFormatting.GOLD + (int)winEloRed + " Elo"));
        	Minecraft.getMinecraft().thePlayer.addChatMessage(new ChatComponentText(EnumChatFormatting.RED + "[NoSpec] " +  EnumChatFormatting.DARK_RED + TeamBlue + EnumChatFormatting.GRAY + " kriegt bei Win " + EnumChatFormatting.GOLD + (int)winEloBlue + " Elo"));
        	
        }
     
    }
    
    
    public static void testInit() {
    	Minecraft.getMinecraft().thePlayer.addChatMessage(new ChatComponentText(getCurrentActionBar()));
    }
    
    
    public void parse() {
    	
    }
}
	
	
