package uk.co.ericscott.quickrenamer;

import lombok.Getter;
import org.bukkit.plugin.java.JavaPlugin;
import uk.co.ericscott.quickrenamer.command.LoreCommand;
import uk.co.ericscott.quickrenamer.command.QuickRenamerCommand;
import uk.co.ericscott.quickrenamer.command.RenameCommand;
import uk.co.ericscott.quickrenamer.utils.command.CommandFramework;

@Getter
public class QuickRenamer extends JavaPlugin {

    @Getter
    private static QuickRenamer instance;

    private CommandFramework commandFramework;

    /**
     * Called when the plugin enables
     */
    public void onEnable() {
        instance = this;

        commandFramework = new CommandFramework(this);

        commandFramework.registerCommands(new QuickRenamerCommand(this));
        commandFramework.registerCommands(new LoreCommand(this));
        commandFramework.registerCommands(new RenameCommand(this));
        commandFramework.registerHelp();
    }

    /**
     * Called when the plugin disables
     */
    public void onDisable() {

    }

}
