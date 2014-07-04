package database;

import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

import lib.PatPeter.SQLibrary.Database;
import lib.PatPeter.SQLibrary.SQLite;

import com.github.ar7ific1al.resourceful.PluginMain;

public class DatabaseManager {
	
	private static PluginMain plugin;
	
	private static Database miningSqlite;
	private static Database cropsSqlite;
	private static Database loggingSqlite;
	private static Database playersSqlite;
	
	public DatabaseManager(PluginMain instance)	{
		plugin = instance;
		
		miningSqlite = new SQLite(Logger.getLogger("SQLogger"),
				"[Resourceful] ",
				plugin.getDataFolder().getAbsolutePath(),
				"Resourceful.Mining",
				".sqlite");
		cropsSqlite = new SQLite(Logger.getLogger("SQLogger"),
				"[Resourceful] ",
				plugin.getDataFolder().getAbsolutePath(),
				"Resourceful.Crops",
				".sqlite");
		loggingSqlite = new SQLite(Logger.getLogger("SQLogger"),
				"[Resourceful] ",
				plugin.getDataFolder().getAbsolutePath(),
				"Resourceful.Logging",
				".sqlite");
		playersSqlite = new SQLite(Logger.getLogger("SQLogger"),
				"[Resourceful] ",
				plugin.getDataFolder().getAbsolutePath(),
				"Resourceful.Players",
				".sqlite");
	}
	
	public void OpenDb()	{
		PluginMain.console.log(Level.INFO, "[Resourceful] Opening SQLite connections.");
		if (!miningSqlite.isOpen())	{
			miningSqlite.open();
			PluginMain.console.log(Level.INFO, "[Resourceful] Mining database connection opened.");
		}
		if (!cropsSqlite.isOpen())	{
			cropsSqlite.open();
			PluginMain.console.log(Level.INFO, "[Resourceful] Crops database connection opened.");
		}
		if (!loggingSqlite.isOpen())	{
			loggingSqlite.open();
			PluginMain.console.log(Level.INFO, "[Resourceful] Logging database connection opened.");
		}
		if (!playersSqlite.isOpen())	{
			playersSqlite.open();
			PluginMain.console.log(Level.INFO, "[Resourceful] Players database connection opened.");
			
			if (!playersSqlite.isTable("TestTable"))	{
				try {
					playersSqlite.query("CREATE TABLE main.TestTable (UUID TEXT PRIMARY KEY NOT NULL, Name TEXT NOT NULL);");
					playersSqlite.query("INSERT INTO main.TestTable (UUID, Name) VALUES ('Test UUID', 'Ar7ific1al')");
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
	
	public void CloseDb()	{
		PluginMain.console.log(Level.INFO, "[Resourceful] Closing SQLite connections.");
		if (miningSqlite.isOpen(1))	{
			miningSqlite.close();
			PluginMain.console.log(Level.INFO, "[Resourceful] Mining database connection closed.");
		}
		if (cropsSqlite.isOpen())	{
			cropsSqlite.close();
			PluginMain.console.log(Level.INFO, "[Resourceful] Crops database connection closed.");
		}
		if (loggingSqlite.isOpen())	{
			loggingSqlite.close();
			PluginMain.console.log(Level.INFO, "[Resourceful] Logging database connection closed.");
		}
		if (playersSqlite.isOpen())	{
			playersSqlite.close();
			PluginMain.console.log(Level.INFO, "[Resourceful] Players database connection closed.");
		}
	}
	
}
