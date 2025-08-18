package com.agac.utils;

import com.agac.AgacPlugin;
import org.bukkit.Effect;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class TreeUtils {

    private final AgacPlugin plugin;
    private final Set<Material> treeLogs;

    public TreeUtils(AgacPlugin plugin) {
        this.plugin = plugin;

        // Ağaç türlerini tanımla (sadece gövde blokları)
        this.treeLogs = new HashSet<>(Arrays.asList(
            Material.OAK_LOG, Material.BIRCH_LOG, Material.SPRUCE_LOG, Material.JUNGLE_LOG,
            Material.ACACIA_LOG, Material.DARK_OAK_LOG, Material.MANGROVE_LOG, Material.CHERRY_LOG,
            Material.BAMBOO_BLOCK, Material.CRIMSON_STEM, Material.WARPED_STEM
        ));
    }

    public boolean isTreeLog(Material material) {
        return treeLogs.contains(material);
    }

    public void breakTree(Player player, Block startBlock) {
        // İzin açık ise çalış, default true olduğundan engel değil
        if (!player.hasPermission("agac.usetree")) {
            return;
        }

        List<Block> trunkBlocks = findVerticalTrunk(startBlock);
        if (trunkBlocks.isEmpty()) {
            return;
        }

        // Tek seferde, anında kır ve envantere ekle
        instantBreakAndGive(player, trunkBlocks);
    }

    // Sadece dikey gövdeyi bul (yakın ağaçları kırmaz)
    private List<Block> findVerticalTrunk(Block startBlock) {
        List<Block> result = new ArrayList<>();
        if (!isTreeLog(startBlock.getType())) {
            return result;
        }

        Block base = startBlock;
        // Kökü bulmak için aşağı in
        while (isTreeLog(base.getRelative(0, -1, 0).getType())) {
            base = base.getRelative(0, -1, 0);
        }

        // Yukarı doğru tüm gövde bloklarını topla
        Block current = base;
        while (isTreeLog(current.getType())) {
            result.add(current);
            current = current.getRelative(0, 1, 0);
        }

        return result;
    }

    private void instantBreakAndGive(Player player, List<Block> treeBlocks) {
        // Tek seferde patlatma etkisi ile kaldır ve her blok için kendi türünü ver
        for (Block block : treeBlocks) {
            Material type = block.getType();
            if (type == Material.AIR) continue;
            if (!isTreeLog(type)) continue;
            block.getWorld().playEffect(block.getLocation(), Effect.STEP_SOUND, type);
            player.getInventory().addItem(new ItemStack(type));
            block.setType(Material.AIR, false);
        }

        // Tek bir ses çal (kök konumunda)
        if (!treeBlocks.isEmpty()) {
            treeBlocks.get(0).getWorld().playSound(treeBlocks.get(0).getLocation(), Sound.BLOCK_WOOD_BREAK, 1.0f, 1.0f);
        }
    }
}