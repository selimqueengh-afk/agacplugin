package com.agac;

import com.agac.commands.AgacCommand;
import com.agac.listeners.TreeBreakListener;
import com.agac.utils.TreeUtils;
import org.bukkit.plugin.java.JavaPlugin;

public class AgacPlugin extends JavaPlugin {

    private static AgacPlugin instance;
    private TreeUtils treeUtils;

    @Override
    public void onEnable() {
        instance = this;
        
        // TreeUtils sınıfını başlat
        this.treeUtils = new TreeUtils(this);
        
        // Event listener'ları kaydet
        getServer().getPluginManager().registerEvents(new TreeBreakListener(this), this);
        
        // Komutları kaydet
        getCommand("agac").setExecutor(new AgacCommand(this));
        
        // Config dosyasını yükle
        saveDefaultConfig();
        
        getLogger().info("Agac plugin başarıyla yüklendi!");
    }

    @Override
    public void onDisable() {
        getLogger().info("Agac plugin kapatıldı!");
    }

    public static AgacPlugin getInstance() {
        return instance;
    }

    public TreeUtils getTreeUtils() {
        return treeUtils;
    }
}