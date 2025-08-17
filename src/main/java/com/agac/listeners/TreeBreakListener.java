package com.agac.listeners;

import com.agac.AgacPlugin;
import com.agac.utils.TreeUtils;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.inventory.ItemStack;

public class TreeBreakListener implements Listener {

    private final AgacPlugin plugin;
    private final TreeUtils treeUtils;

    public TreeBreakListener(AgacPlugin plugin) {
        this.plugin = plugin;
        this.treeUtils = plugin.getTreeUtils();
    }

    @EventHandler(priority = EventPriority.HIGH)
    public void onBlockBreak(BlockBreakEvent event) {
        Player player = event.getPlayer();
        Block block = event.getBlock();
        
        // Sadece ağaç odunları için çalış
        if (!treeUtils.isTreeLog(block.getType())) {
            return;
        }
        
        // Oyuncunun elinde balta var mı kontrol et
        ItemStack tool = player.getInventory().getItemInMainHand();
        if (!treeUtils.isValidTool(tool)) {
            return;
        }
        
        // Event'i iptal et (normal kırma işlemini engelle)
        event.setCancelled(true);
        
        // Ağaç kırma işlemini başlat
        treeUtils.breakTree(player, block);
    }
}