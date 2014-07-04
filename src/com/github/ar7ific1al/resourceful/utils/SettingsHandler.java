package com.github.ar7ific1al.resourceful.utils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.bukkit.Bukkit;
import org.bukkit.configuration.InvalidConfigurationException;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import com.github.ar7ific1al.resourceful.PluginMain;

public class SettingsHandler {
	
	private static PluginMain plugin;
	
	public SettingsHandler(PluginMain instance)	{
		plugin = instance;
	}

	private static File SettingsFile;
	private static FileConfiguration Settings;

	public static void createSettingsFile(String path, String fileName, boolean overwrite) throws IOException {
		SettingsFile = new File(path, fileName);
		plugin.saveResource("Settings/settings.yml", true);
		Log.LogMessage("&4Resourceful has created the default settings file.", Bukkit.getConsoleSender());
	}
	
	public static void loadSettingsFile(String path, String fileName) throws IOException, InvalidConfigurationException	{
		SettingsFile = new File(path, fileName);
		if (!SettingsFile.exists())	{
			Log.LogMessage(Log.ColorMessage("&4Resourceful could not fine the settings file. Creating default settings file..."), Bukkit.getConsoleSender());
			createSettingsFile(path, fileName, true);
		}
		Settings = new YamlConfiguration();
		Settings.load(SettingsFile);
	}
	
	public static boolean saveSettingsFile(File path, String fileName) throws IOException	{
		if (!SettingsFile.exists())	{
			Log.LogMessage(Log.ColorMessage("&4Resourceful has no settings file. Something has gone horribly wrong and the file is missing. Please reload Resourceful!"), Bukkit.getConsoleSender());
			return false;
		}
		Settings.save(SettingsFile);
		return true;
	}
	
	public static boolean reloadSettingsFile(String path, String fileName) throws FileNotFoundException, IOException, InvalidConfigurationException	{
		if (!SettingsFile.exists())	{
			Log.LogMessage(Log.ColorMessage("&4Resourceful has no settings file. Something has gone horribly wrong and the file is missing. Please reload Resourceful!"), Bukkit.getConsoleSender());
			return false;
		}
		loadSettingsFile(path, fileName);
		Settings.load(SettingsFile);
		return true;
	}

}