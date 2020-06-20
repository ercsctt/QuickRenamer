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

public class RenameCommand {

    private QuickRenamer instance;

    public RenameCommand(QuickRenamer instance) {
        this.instance = instance;
    }

    @Command(name = "rename", permission = "quickrenamer.rename", inGameOnly = true)
    public void onRenameCommand(CommandArgs args) {
        Player player = args.getPlayer();

        if(args.getArgs().length <= 0) {
            player.sendMessage(CC.translate("&cUsage: /rename <name>"));
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
        String name = builder.toString();

        itemMeta.setDisplayName(CC.translate(name));

        itemStack.setItemMeta(itemMeta);

        player.setItemInHand(itemStack);
        player.sendMessage(CC.translate("&aRenamed item in your hand to: &7" + name));
    }

}
