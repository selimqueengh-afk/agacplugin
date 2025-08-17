package com.agac.utils;

import com.agac.AgacPlugin;
import org.bukkit.*;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.*;

public class TreeUtils {

    private final AgacPlugin plugin;
    private final Set<Material> treeLogs;
    private final Set<Material> treeLeaves;
    private final Random random;

    public TreeUtils(AgacPlugin plugin) {
        this.plugin = plugin;
        this.random = new Random();
        
        // Ağaç türlerini tanımla
        this.treeLogs = new HashSet<>(Arrays.asList(
            Material.OAK_LOG, Material.BIRCH_LOG, Material.SPRUCE_LOG, Material.JUNGLE_LOG,
            Material.ACACIA_LOG, Material.DARK_OAK_LOG, Material.MANGROVE_LOG, Material.CHERRY_LOG,
            Material.BAMBOO_BLOCK, Material.CRIMSON_STEM, Material.WARPED_STEM
        ));
        
        this.treeLeaves = new HashSet<>(Arrays.asList(
            Material.OAK_LEAVES, Material.BIRCH_LEAVES, Material.SPRUCE_LEAVES, Material.JUNGLE_LEAVES,
            Material.ACACIA_LEAVES, Material.DARK_OAK_LEAVES, Material.MANGROVE_LEAVES, Material.CHERRY_LEAVES,
            Material.AZALEA_LEAVES, Material.FLOWERING_AZALEA_LEAVES, Material.NETHER_WART_BLOCK, Material.SHROOMLIGHT
        ));
    }

    public boolean isTreeLog(Material material) {
        return treeLogs.contains(material);
    }

    public boolean isTreeLeaf(Material material) {
        return treeLeaves.contains(material);
    }

    public void breakTree(Player player, Block startBlock) {
        if (!player.hasPermission("agac.usetree")) {
            return;
        }

        // Ağaç yapısını bul
        List<Block> treeBlocks = findTreeStructure(startBlock);
        if (treeBlocks.isEmpty()) {
            return;
        }

        // Ağaç kırma animasyonunu başlat
        animateTreeBreak(player, treeBlocks);
    }

    private List<Block> findTreeStructure(Block startBlock) {
        List<Block> treeBlocks = new ArrayList<>();
        Queue<Block> toCheck = new LinkedList<>();
        Set<Block> checked = new HashSet<>();

        toCheck.add(startBlock);
        checked.add(startBlock);

        while (!toCheck.isEmpty()) {
            Block current = toCheck.poll();
            treeBlocks.add(current);

            // Çevredeki blokları kontrol et
            for (int x = -1; x <= 1; x++) {
                for (int y = -1; y <= 1; y++) {
                    for (int z = -1; z <= 1; z++) {
                        if (x == 0 && y == 0 && z == 0) continue;

                        Block neighbor = current.getRelative(x, y, z);
                        if (checked.contains(neighbor)) continue;

                        Material neighborType = neighbor.getType();
                        if (isTreeLog(neighborType) || isTreeLeaf(neighborType)) {
                            toCheck.add(neighbor);
                            checked.add(neighbor);
                        }
                    }
                }
            }
        }

        return treeBlocks;
    }

    private void animateTreeBreak(Player player, List<Block> treeBlocks) {
        // Ağaç bloklarını yükseklik sırasına göre sırala
        treeBlocks.sort((b1, b2) -> Integer.compare(b2.getY(), b1.getY()));

        // Animasyon için scheduler kullan
        new BukkitRunnable() {
            int index = 0;
            
            @Override
            public void run() {
                if (index >= treeBlocks.size()) {
                    this.cancel();
                    return;
                }

                Block block = treeBlocks.get(index);
                if (block.getType() != Material.AIR) {
                    // Blok kırma efekti
                    block.getWorld().playEffect(block.getLocation(), Effect.STEP_SOUND, block.getType());
                    
                    // Blok kırma sesi
                    block.getWorld().playSound(block.getLocation(), Sound.BLOCK_WOOD_BREAK, 1.0f, 1.0f);
                    
                    // Blok türüne göre drop ekle
                    addDropsToInventory(player, block);
                    
                    // Bloğu kaldır
                    block.setType(Material.AIR);
                }
                
                index++;
            }
        }.runTaskTimer(plugin, 0L, 2L); // Her 2 tick'te bir blok kır
    }

    private void addDropsToInventory(Player player, Block block) {
        Material blockType = block.getType();
        
        if (isTreeLog(blockType)) {
            // Odun drop'u
            ItemStack log = new ItemStack(blockType);
            player.getInventory().addItem(log);
            
            // Ekstra drop şansı
            if (random.nextDouble() < 0.1) { // %10 şans
                player.getInventory().addItem(new ItemStack(Material.STICK));
            }
        } else if (isTreeLeaf(blockType)) {
            // Yaprak drop'u
            if (random.nextDouble() < 0.05) { // %5 şans
                player.getInventory().addItem(new ItemStack(Material.APPLE));
            }
            if (random.nextDouble() < 0.02) { // %2 şans
                player.getInventory().addItem(new ItemStack(Material.STICK));
            }
        }
    }

    public boolean isValidTool(ItemStack tool) {
        if (tool == null) return false;
        
        return tool.getType() == Material.WOODEN_AXE ||
               tool.getType() == Material.STONE_AXE ||
               tool.getType() == Material.IRON_AXE ||
               tool.getType() == Material.DIAMOND_AXE ||
               tool.getType() == Material.NETHERITE_AXE;
    }
}