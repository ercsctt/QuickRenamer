package uk.co.ericscott.quickrenamer.command;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import uk.co.ericscott.quickrenamer.QuickRenamer;
import uk.co.ericscott.quickrenamer.utils.CC;
import uk.co.ericscott.quickrenamer.utils.command.Command;
import uk.co.ericscott.quickrenamer.utils.command.CommandArgs;

import java.util.ArrayList;
import java.util.List;

public class LoreCommand {

    private QuickRenamer instance;

    public LoreCommand(QuickRenamer instance) {
        this.instance = instance;
    }

    @Command(name = "lore", inGameOnly = true)
    public void onLoreCommand(CommandArgs args) {
        Player player = args.getPlayer();

        player.sendMessage(CC.translate("&cUsage: /lore <add/remove/clear> [line/number]"));
    }

    @Command(name = "lore.add", permission = "quickrenamer.lore", inGameOnly = true)
    public void onLoreAddCommand(CommandArgs args) {
        Player player = args.getPlayer();

        if(args.getArgs().length <= 0) {
            player.sendMessage(CC.translate("&cUsage: /lore add <line>"));
            return;
        }

        ItemStack itemStack = player.getItemInHand();

        if(itemStack == null || itemStack.getType() == Material.AIR) {
            player.sendMessage(CC.translate("&cYou must have an item in your hand to do this."));
            return;
        }

        ItemMeta itemMeta = itemStack.getItemMeta();

        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < args.getArgs().length; i++) {
            builder.append(args.getArgs(i)).append(" ");
        }
        String toAdd = CC.translate(builder.toString());

        List<String> lore = (itemMeta.getLore() == null ? new ArrayList<>() : itemMeta.getLore());

        lore.add(toAdd);

        itemMeta.setLore(lore);

        itemStack.setItemMeta(itemMeta);

        player.setItemInHand(itemStack);
        player.sendMessage(CC.translate("&aSet lore of item the in your hand."));
    }

    @Command(name = "lore.remove", permission = "quickrenamer.lore", inGameOnly = true)
    public void onLoreRemoveCommand(CommandArgs args) {
        Player player = args.getPlayer();

        if(args.getArgs().length <= 0) {
            player.sendMessage(CC.translate("&cUsage: /lore remove <line #>"));
            return;
        }

        int index;
        try {
            index = Integer.parseInt(args.getArgs(0));
        } catch (NumberFormatException e) {
            player.sendMessage(CC.translate("&cPlease provide a line number to remove."));
            return;
        }

        ItemStack itemStack = player.getItemInHand();

        if(itemStack == null || itemStack.getType() == Material.AIR) {
            player.sendMessage(CC.translate("&cYou must have an item in your hand to do this."));
            return;
        }

        ItemMeta itemMeta = itemStack.getItemMeta();

        List<String> lore = (itemMeta.getLore() == null ? new ArrayList<>() : itemMeta.getLore());

        if(lore.size() <= 0) {
            player.sendMessage(CC.translate("&cThat item's lore is currently empty."));
            return;
        }

        try {
            lore.get(index-1);
        }catch (IndexOutOfBoundsException e) {
            player.sendMessage(CC.translate("&cThat line doesn't exist on the lore (Size: " + lore.size() + ")"));
            return;
        }

        lore.remove(index-1);

        itemMeta.setLore(lore);

        itemStack.setItemMeta(itemMeta);

        player.setItemInHand(itemStack);
        player.sendMessage(CC.translate("&aSet lore of item the in your hand."));
    }

    @Command(name = "lore.clear", permission = "quickrenamer.lore", inGameOnly = true)
    public void onLoreClearCommand(CommandArgs args) {
        Player player = args.getPlayer();

        ItemStack itemStack = player.getItemInHand();

        if(itemStack == null || itemStack.getType() == Material.AIR) {
            player.sendMessage(CC.translate("&cYou must have an item in your hand to do this."));
            return;
        }

        ItemMeta itemMeta = itemStack.getItemMeta();

        itemMeta.setLore(new ArrayList<>());

        itemStack.setItemMeta(itemMeta);

        player.setItemInHand(itemStack);
        player.sendMessage(CC.translate("&aCleared the lore of the item in your hand."));
    }

}
