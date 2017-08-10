package me.d3sknight;


import org.bukkit.Bukkit;
import org.bukkit.configuration.InvalidConfigurationException;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.io.IOException;

public class Config {

    public Home plugin;
    public Config(Home pl) {
        plugin = pl;
    }


    public File langF;
    public File homeF;
    public YamlConfiguration lang = new YamlConfiguration();
    public YamlConfiguration home = new YamlConfiguration();

    public void mkdirs(){
        if(!langF.exists()){
            plugin.saveResource( "lang.yml", false);
        }
        if(!homeF.exists()){
            plugin.saveResource("home.yml", false);
        }
        Bukkit.getConsoleSender().sendMessage("Make directory");
    }


    public void loadYamls(){
        try {
            lang.load(langF);
            home.load(homeF);
        } catch (IOException | InvalidConfigurationException e){
            e.printStackTrace();
        }
    }

    public void savelangF() {
        try {
            lang.save(langF);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void savehomeF() {
        try {
            home.save(homeF);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public YamlConfiguration getLang(){
        return lang;
    }
    public YamlConfiguration getHome(){
        return home;
    }
}
