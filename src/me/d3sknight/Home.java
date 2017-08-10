package me.d3sknight;


import me.d3sknight.command.home;
import me.d3sknight.command.sethome;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;
public class Home extends JavaPlugin{

    Config config = new Config(this);

    @Override
    public void onEnable(){
        registerConfig();
        registerCommand();
        registerEvent();
    }
    @Override
    public void onDisable(){
    }

    public void registerConfig(){

        config.langF = new File(getDataFolder(), "lang.yml");
        config.homeF = new File(getDataFolder(), "home.yml");
        saveDefaultConfig();
        Bukkit.getConsoleSender().sendMessage("Config has been loaded");
        config.mkdirs();
        config.loadYamls();
    }

    public void registerCommand(){
        getCommand("home").setExecutor(new home(this));
        getCommand("sethome").setExecutor(new sethome(this));
    }

    public void registerEvent(){

    }



}
