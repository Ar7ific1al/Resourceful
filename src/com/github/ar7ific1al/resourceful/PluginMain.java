package com.github.ar7ific1al.resourceful;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.configuration.InvalidConfigurationException;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

import com.github.ar7ific1al.resourceful.utils.Log;
import com.github.ar7ific1al.resourceful.utils.SettingsHandler;

public class PluginMain extends JavaPlugin	{
	
	SettingsHandler Settings;
	String startError = "&4Resourceful encountered a problem while starting. Please view the stack trace printed below.";
	
	private static File SkillsDir;
	private static File MiningSettingsFile;
	private static FileConfiguration MiningSettings = new YamlConfiguration();
	
	
	
	@Override
	public void onEnable()	{
		Settings = new SettingsHandler(this);
		try {
			SettingsHandler.loadSettingsFile(getDataFolder() + "/Settings", "settings.yml");
		} catch (IOException | InvalidConfigurationException e) {
			Log.LogMessage(Log.ColorMessage("&4There was a problem loading &eResourceful/Settings/settings.yml&4, please ensure the file exists. Consult the stack trace below for more information."), Bukkit.getConsoleSender());
			e.printStackTrace();
		}
		
		SkillsDir = new File(getDataFolder() + "/Settings/Skills");
		if (!SkillsDir.exists())	{
			SkillsDir.mkdir();
		}
		
		MiningSettingsFile = new File(getDataFolder() + "/Settings/Skills", "mining.yml");
		if (!MiningSettingsFile.exists())	{
			saveResource("Settings/Skills/mining.yml", true);
		}
		try {
			MiningSettings.load(MiningSettingsFile);
		} catch (IOException | InvalidConfigurationException e) {
			Log.LogMessage(Log.ColorMessage("&4There was a problem loading &eResourceful/Settings/Skills/mining.yml&4, please ensure the file exists. Consult the stack trace below for more information."), Bukkit.getConsoleSender());
			e.printStackTrace();
		}
	}
	
	@Override
	public void onDisable()	{
		
	}
	
	public void SaveNodes(String worldName)	{
		
	}
	
}