package uk.co.ericscott.quickrenamer.command;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import uk.co.ericscott.quickrenamer.QuickRenamer;
import uk.co.ericscott.quickrenamer.utils.CC;
import uk.co.ericscott.quickrenamer.utils.command.Command;
import uk.co.ericscott.quickrenamer.utils.command.CommandArgs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class QuickRenamerCommand {

    private QuickRenamer instance;

    public QuickRenamerCommand(QuickRenamer instance) {
        this.instance = instance;
    }

    @Command(name = "quickrenamer", aliases = { "qr" }, inGameOnly = true)
    public void onRenamerCommand(CommandArgs args) {
        Player player = args.getPlayer();

        player.sendMessage(CC.translate("&8&m----------------------------------"));
        player.sendMessage(CC.translate("&6&lQuickRenamer &7by Eric"));
        player.sendMessage(CC.translate("&6 "));
        player.sendMessage(CC.translate("&7&oSee below for command help:"));
        player.sendMessage(CC.translate("&7- &e/rename <name> &7(Rename the item in your hand)"));
        player.sendMessage(CC.translate("&7- &e/lore add <line> &7(Add a line to the lore)"));
        player.sendMessage(CC.translate("&7- &e/lore remove <line #> &7(Remove a line from the lore by the number)"));
        player.sendMessage(CC.translate("&7- &e/lore edit <line #> <text> &7(Edit a line on the lore)"));
        player.sendMessage(CC.translate("&7- &e/lore clear &7(Clear the lore of the item in your hand)"));
        player.sendMessage(CC.translate("&8&m----------------------------------"));
    }

}
