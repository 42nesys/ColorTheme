package pashmash.coloredPlaceholder.command;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;
import pashmash.coloredPlaceholder.ColoredPlaceholder;
import pashmash.coloredPlaceholder.gui.ColorMenu;

import java.util.Objects;

public class ColorCommand implements CommandExecutor {
    public ColorCommand() {
        Objects.requireNonNull(ColoredPlaceholder.getInstance().getCommand("color")).setExecutor(this);
    }



    @Override
    public boolean onCommand(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String s, @NotNull String[] strings) {
        Player player = (Player) commandSender;
        ColorMenu.openColorSettingsMenu(player);
        return false;
    }

}
