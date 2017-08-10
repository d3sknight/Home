package me.d3sknight.command;

import me.d3sknight.Config;
import me.d3sknight.Home;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.io.File;

/**
 * Created by zerom on 8/11/2017.
 */
public class home implements CommandExecutor {

    public Home plugin;
    public home(Home pl) {
        plugin = pl;
    }

    Config config = new Config(plugin);


    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (!(sender instanceof Player)) {
            sender.sendMessage(ChatColor.RED+"You must be a player to use the command");
            return false;
        } else {
            if (cmd.getName().equalsIgnoreCase("home")){
                Player p = (Player) sender;
                config.homeF = new File(plugin.getDataFolder(), "home.yml");
                String w = config.home.getString("Home.world");
                Double X = config.home.getDouble("Home.x");
                Double Y = config.home.getDouble("Home.y");
                Double Z = config.home.getDouble("Home.z");
/*
                Location home = new Location(Bukkit.getWorld(w),X,Y,Z);
*/
                p.sendMessage("World "+w+" X "+X+" Y "+Y+" Z "+Z);

                return true;

            }
        }
        return false;
    }
}