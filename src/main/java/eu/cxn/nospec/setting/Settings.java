package eu.cxn.nospec.setting;

import java.awt.List;
import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

import org.omg.CORBA.portable.InputStream;

import com.ibm.icu.util.BytesTrie.Iterator;

import eu.cxn.nospec.setting.*;
import net.minecraft.util.ResourceLocation;


public class Settings {
	
	public static LinkedHashMap<String, Integer> oldSetting = new LinkedHashMap();
	public static LinkedHashMap<String, Integer> newSetting = new LinkedHashMap();
	public static boolean toBool(int i) {
		boolean returning = i == 1 ? true : false;
		return returning;
	}
	
	
	public static void loadSetting() {
		String[] fileArr = ConfigHandler.readLines();
		for(String value: fileArr) {
			
			if(value != "" || value != " " || value != "\n" || value != null) {
			String[] splitValue = value.split("=");
			oldSetting.put(splitValue[0], Integer.parseInt(splitValue[1]));
			System.out.println("Putting " + splitValue[1] + " in " + splitValue[0]);
			}
		}
		newSetting.putAll(oldSetting);
	}
	
	public static void reloadSetting() {
		loadSetting();
	}
	
	private static void changeSetting(String ModuleName, int nullOneHeight) {
		newSetting.replace(ModuleName, nullOneHeight);
	}
	
	
	
	private static void saveSetting(String ModuleName, int nullOneHeight) {
		
		StringBuilder sb = new StringBuilder();
		String builder = "";
		 
		java.util.Iterator<String> iterator = newSetting.keySet().iterator();
		while(iterator.hasNext()){
		  Object key   = iterator.next();
		  Object value = newSetting.get(key);
		  builder = builder + (key + "=" + value);
		  builder= builder + (System.getProperty("line.separator"));
		  System.out.println("Putting " + value + " in " + key);
		  }
		ConfigHandler.writeNewFile(builder);
				
	}
	
	//Standard override Setting
	public static void EditAndSafeSetting(String ModuleName, int nullOneHeight) {
		changeSetting(ModuleName, nullOneHeight);
		saveSetting(ModuleName, nullOneHeight);
	}
	
	//standard get state of module
	public static boolean getState(String st) {
		int mdl = newSetting.get(st);
		return toBool(mdl);
	}
	
	//standard get position height of module
	public static int getPosHeight() {
		int mdl = newSetting.get("POSHEIGHT");
		return mdl;
	}
	
	
	
}

