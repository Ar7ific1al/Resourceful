package com.github.ar7ific1al.resourceful.utils.settings;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.logging.Level;

import org.bukkit.Bukkit;
import org.bukkit.configuration.InvalidConfigurationException;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

import com.github.ar7ific1al.resourceful.PluginMain;
import com.github.ar7ific1al.resourceful.utils.text.Log;

public class SettingsHandler {
	
	private static PluginMain plugin;
	
	public static void SetPluginReference(PluginMain instance)	{
		plugin = instance;
	}

	public static void CheckResources()	{
		PluginMain.console.log(Level.INFO, "[Resourceful] Checking for missing files and directories...", Bukkit.getServer().getConsoleSender());
		
		if (!plugin.getDataFolder().exists())	{
			PluginMain.console.log(Level.INFO, "[Resourceful] Plugin directory not found! Creating...", Bukkit.getServer().getConsoleSender());
			plugin.getDataFolder().mkdir();
			PluginMain.console.log(Level.INFO, "[Resourceful] Plugin directory created!", Bukkit.getServer().getConsoleSender());
		}
		if (!plugin.PlayersDir.exists())	{
			plugin.PlayersDir.mkdir();
			PluginMain.console.log(Level.INFO, "[Resourceful] Players directory was not found and was created!", Bukkit.getServer().getConsoleSender());
		}
		if (!plugin.SettingsDir.exists())	{
			plugin.SettingsDir.mkdir();
			PluginMain.console.log(Level.INFO, "[Resourceful] Settings directory was not found and was created!", Bukkit.getServer().getConsoleSender());
		}
		if (!plugin.CropsSettingsDir.exists())	{
			plugin.CropsSettingsDir.mkdir();
			PluginMain.console.log(Level.INFO, "[Resourceful] Crops Settings directory was not found and was created!", Bukkit.getServer().getConsoleSender());
		}
		if (!plugin.LoggingSettingsDir.exists())	{
			plugin.LoggingSettingsDir.mkdir();
			PluginMain.console.log(Level.INFO, "[Resourceful] Logging Settings directory was not found and was created!", Bukkit.getServer().getConsoleSender());
		}
		if (!plugin.MiningSettingsDir.exists())	{
			plugin.MiningSettingsDir.mkdir();
			PluginMain.console.log(Level.INFO, "[Resourceful] Mining Settings directory was not found and was created!", Bukkit.getServer().getConsoleSender());
		}
		
		if (!(new File(plugin.SettingsDir + "/settings.yml").exists()))	{
			plugin.saveResource("Settings/settings.yml", true);
			PluginMain.console.log(Level.INFO, "[Resourceful] Copied resource \"Settings\\settings.yml\"", Bukkit.getServer().getConsoleSender());
		}
		if (!(new File(plugin.CropsSettingsDir + "/CARROT.yml").exists()))	{
			plugin.saveResource("Settings/Crops/CARROT.yml", true);
			PluginMain.console.log(Level.INFO, "[Resourceful] Copied resource \"Settings\\Crops\\CARROT.yml\"", Bukkit.getServer().getConsoleSender());
		}
		if (!(new File(plugin.CropsSettingsDir + "/MELON.yml").exists()))	{
			plugin.saveResource("Settings/Crops/MELON.yml", true);
			PluginMain.console.log(Level.INFO, "[Resourceful] Copied resource \"Settings\\Crops\\MELON.yml\"", Bukkit.getServer().getConsoleSender());
		}
		if (!(new File(plugin.CropsSettingsDir + "/NETHER_WART.yml").exists()))	{
			plugin.saveResource("Settings/Crops/NETHER_WART.yml", true);
			PluginMain.console.log(Level.INFO, "[Resourceful] Copied resource \"Settings\\Crops\\NETHER_WART.yml\"", Bukkit.getServer().getConsoleSender());
		}
		if (!(new File(plugin.CropsSettingsDir + "/POTATO.yml").exists()))	{
			plugin.saveResource("Settings/Crops/POTATO.yml", true);
			PluginMain.console.log(Level.INFO, "[Resourceful] Copied resource \"Settings\\Crops\\POTATO.yml\"", Bukkit.getServer().getConsoleSender());
		}
		if (!(new File(plugin.CropsSettingsDir + "/PUMPKIN.yml").exists()))	{
			plugin.saveResource("Settings/Crops/PUMPKIN.yml", true);
			PluginMain.console.log(Level.INFO, "[Resourceful] Copied resource \"Settings\\Crops\\PUMPKIN.yml\"", Bukkit.getServer().getConsoleSender());
		}
		if (!(new File(plugin.CropsSettingsDir + "/WHEAT.yml").exists()))	{
			plugin.saveResource("Settings/Crops/WHEAT.yml", true);
			PluginMain.console.log(Level.INFO, "[Resourceful] Copied resource \"Settings\\Crops\\WHEAT.yml\"", Bukkit.getServer().getConsoleSender());
		}
		if (!(new File(plugin.LoggingSettingsDir + "/Logging.yml").exists()))	{
			plugin.saveResource("Settings/Logging/Logging.yml", true);
			PluginMain.console.log(Level.INFO, "[Resourceful] Copied resource \"Settings\\Logging\\Logging.yml\"", Bukkit.getServer().getConsoleSender());
		}
		if (!(new File(plugin.MiningSettingsDir + "/COAL_ORE.yml").exists()))	{
			plugin.saveResource("Settings/Mining/COAL_ORE.yml", true);
			PluginMain.console.log(Level.INFO, "[Resourceful] Copied resource \"Settings\\Mining\\COAL_ORE.yml\"", Bukkit.getServer().getConsoleSender());
		}
		if (!(new File(plugin.MiningSettingsDir + "/DIAMOND_ORE.yml").exists()))	{
			plugin.saveResource("Settings/Mining/DIAMOND_ORE.yml", true);
			PluginMain.console.log(Level.INFO, "[Resourceful] Copied resource \"Settings\\Mining\\DIAMOND_ORE.yml\"", Bukkit.getServer().getConsoleSender());
		}
		if (!(new File(plugin.MiningSettingsDir + "/EMERALD_ORE.yml").exists()))	{
			plugin.saveResource("Settings/Mining/EMERALD_ORE.yml", true);
			PluginMain.console.log(Level.INFO, "[Resourceful] Copied resource \"Settings\\Mining\\EMERALD_ORE.yml\"", Bukkit.getServer().getConsoleSender());
		}
		if (!(new File(plugin.MiningSettingsDir + "/GOLD_ORE.yml").exists()))	{
			plugin.saveResource("Settings/Mining/GOLD_ORE.yml", true);
			PluginMain.console.log(Level.INFO, "[Resourceful] Copied resource \"Settings\\Mining\\GOLD_ORE.yml\"", Bukkit.getServer().getConsoleSender());
		}
		if (!(new File(plugin.MiningSettingsDir + "/IRON_ORE.yml").exists()))	{
			plugin.saveResource("Settings/Mining/IRON_ORE.yml", true);
			PluginMain.console.log(Level.INFO, "[Resourceful] Copied resource \"Settings\\Mining\\IRON_ORE.yml\"", Bukkit.getServer().getConsoleSender());
		}
		if (!(new File(plugin.MiningSettingsDir + "/NETHER_QUARTZ_ORE.yml").exists()))	{
			plugin.saveResource("Settings/Mining/NETHER_QUARTZ_ORE.yml", true);
			PluginMain.console.log(Level.INFO, "[Resourceful] Copied resource \"Settings\\Mining\\NETHER_QUARTZ_ORE.yml\"", Bukkit.getServer().getConsoleSender());
		}
		
		PluginMain.console.log(Level.INFO, "[Resourceful] Resource checks complete! Resuming startup.", Bukkit.getServer().getConsoleSender());
	}

}