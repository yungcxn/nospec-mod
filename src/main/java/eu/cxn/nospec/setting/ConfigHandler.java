package eu.cxn.nospec.setting;

import java.awt.List;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;

import com.google.common.io.Files;

import net.minecraft.client.Minecraft;
import net.minecraft.util.ResourceLocation;

public class ConfigHandler{
	
	
	//String path = "conf.txt";
	
	//lines[1] = line1 of file a s o
	static String configPath = System.getProperty("user.home") + File.separator + "AppData" + File.separator + "Roaming" + File.separator + ".minecraft" + File.separator + "config";
	static String filePath = configPath + File.separator + "conf.txt";
	static String StandardFileContent = String.format("EP=1%nPOS=1%nPOSHEIGHT=169%nPICK=1%nSWORD=1%nFNS=1%nPOTION=1%nSHEEP=1%n");

	public static String[] readLines(){
		
		File TestFile = new File(filePath);
		
		if(!TestFile.exists() || !TestFile.canRead()) {
			try {
				TestFile.createNewFile();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			writeNewFile(StandardFileContent);
		}
		
		try {
			System.out.println(filePath);
			FileReader fileReader = new FileReader(filePath);
	         
	        BufferedReader bufferedReader = new BufferedReader(fileReader);
	        ArrayList<String> lines = new ArrayList();
	        String line = null;
	        try {
				while ((line = bufferedReader.readLine()) != null) {
				    lines.add(line);
				}
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	        
	        try {
				bufferedReader.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	        
	        return (String[]) lines.toArray(new String[lines.size()]);
	        
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
        
    }
	
	
	
	
	static void writeNewFile(String toWrite)
    {
		try {
			File file = new File(filePath);
			DataOutputStream outstream = new DataOutputStream(new FileOutputStream(file,false));
			String body = toWrite;
			outstream.write(body.getBytes());
			outstream.close(); 
		} catch (IOException e) {
			e.printStackTrace();
		} 
    }
	

}