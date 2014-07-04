package com.github.ar7ific1al.resourceful;

import java.io.File;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.bukkit.Bukkit;
import org.bukkit.plugin.PluginDescriptionFile;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import com.github.ar7ific1al.resourceful.utils.settings.SettingsHandler;
import com.github.ar7ific1al.resourceful.utils.text.Log;

import database.DatabaseManager;

public class PluginMain extends JavaPlugin	{
	
	String startError = "&4Resourceful encountered a problem while starting. Please view the stack trace printed below.";
	String version;
	List<String> authors;
	public static final Logger console = Logger.getLogger("Resourceful");
	
	public static File SettingsDir;
	public static File SettingsFile;
	
	public static File MiningSettingsDir;
	public static File MiningSettingsFile;
	
	public static File CropsSettingsDir;
	public static File CropsSettingsFile;
	
	public static File LoggingSettingsDir;
	public static File LoggingSettingsFile;
	
	public static File PlayersDir;
	
	public static DatabaseManager DBMan;
	
	@Override
	public void onEnable()	{
		PluginManager pm = Bukkit.getServer().getPluginManager();
		PluginDescriptionFile pdFile = this.getDescription();
		version = pdFile.getVersion();
		authors = pdFile.getAuthors();
		console.log(Level.INFO, "[Resourceful] Resourceful v." + version + " brought to you by " + authors + "...", getServer().getConsoleSender());
		
		SettingsDir = new File(getDataFolder() + "/Settings");
		SettingsFile = new File(SettingsDir + "/settings.yml");
		
		MiningSettingsDir = new File(SettingsDir + "/Mining");
		CropsSettingsDir = new File(SettingsDir + "/Crops");
		LoggingSettingsDir = new File(SettingsDir + "/Logging");
		PlayersDir = new File(getDataFolder() + "/Players");
		
		console.log(Level.INFO, "[Resourceful] Beginning resource checks.", getServer().getConsoleSender());
		SettingsHandler.SetPluginReference(this);
		SettingsHandler.CheckResources();
		
		DBMan = new DatabaseManager(this);
		DBMan.OpenDb();
	}
	
	@Override
	public void onDisable()	{
		console.log(Level.INFO, "[Resourceful] Saving node states...", getServer().getConsoleSender());
		SaveNodes("bwahh");
		//DBMan.CloseDb();
	}
	
	public void SaveNodes(String worldName)	{
		
		console.log(Level.INFO, "[Resourceful] Node states saved!", getServer().getConsoleSender());
	}
	
}