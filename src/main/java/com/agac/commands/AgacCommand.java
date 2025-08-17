package com.agac.commands;

import com.agac.AgacPlugin;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AgacCommand implements CommandExecutor, TabCompleter {

    private final AgacPlugin plugin;

    public AgacCommand(AgacPlugin plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!sender.hasPermission("agac.admin")) {
            sender.sendMessage("§cBu komutu kullanma yetkiniz yok!");
            return true;
        }

        if (args.length == 0) {
            showHelp(sender);
            return true;
        }

        switch (args[0].toLowerCase()) {
            case "reload":
                plugin.reloadConfig();
                sender.sendMessage("§aPlugin yeniden yüklendi!");
                break;
                
            case "info":
                showInfo(sender);
                break;
                
            case "version":
                sender.sendMessage("§aAgac Plugin v" + plugin.getDescription().getVersion());
                break;
                
            default:
                showHelp(sender);
                break;
        }

        return true;
    }

    private void showHelp(CommandSender sender) {
        sender.sendMessage("§6=== Agac Plugin Komutları ===");
        sender.sendMessage("§e/agac reload §7- Plugin'i yeniden yükle");
        sender.sendMessage("§e/agac info §7- Plugin bilgilerini göster");
        sender.sendMessage("§e/agac version §7- Plugin versiyonunu göster");
    }

    private void showInfo(CommandSender sender) {
        sender.sendMessage("§6=== Agac Plugin Bilgileri ===");
        sender.sendMessage("§eVersiyon: §7" + plugin.getDescription().getVersion());
        sender.sendMessage("§eYazar: §7" + plugin.getDescription().getAuthors());
        sender.sendMessage("§eAçıklama: §7" + plugin.getDescription().getDescription());
        sender.sendMessage("§eSunucu: §7" + plugin.getServer().getName());
        sender.sendMessage("§eMinecraft: §7" + plugin.getServer().getVersion());
    }

    @Override
    public List<String> onTabComplete(CommandSender sender, Command command, String alias, String[] args) {
        if (!sender.hasPermission("agac.admin")) {
            return new ArrayList<>();
        }

        if (args.length == 1) {
            List<String> completions = Arrays.asList("reload", "info", "version");
            List<String> filtered = new ArrayList<>();
            
            String input = args[0].toLowerCase();
            for (String completion : completions) {
                if (completion.startsWith(input)) {
                    filtered.add(completion);
                }
            }
            
            return filtered;
        }

        return new ArrayList<>();
    }
}