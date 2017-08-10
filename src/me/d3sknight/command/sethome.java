package me.d3sknight.command;

import me.d3sknight.Config;
import me.d3sknight.Home;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.io.File;

/**
 * Created by zerom on 8/11/2017.
 */
public class sethome implements CommandExecutor {

    public Home plugin;
    public sethome(Home pl) {
        plugin = pl;
    }

    Config config = new Config(plugin);


    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
            if (cmd.getName().equalsIgnoreCase("sethome")){
                Player p = (Player) sender;
                config.homeF = new File(plugin.getDataFolder(), "home.yml");
                if (config.homeF == null) p.sendMessage("null cmnr");
                config.home.set("Home",p.getLocation());
                p.sendMessage(ChatColor.GRAY+"Your home has been set");
                config.savehomeF();
                return true;
            }

        return false;
    }
}
