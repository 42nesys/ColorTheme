package pashmash.coloredPlaceholder.gui;

import dev.triumphteam.gui.builder.item.ItemBuilder;
import dev.triumphteam.gui.guis.Gui;
import lombok.Getter;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import pashmash.coloredPlaceholder.enums.ColorEnums;
import pashmash.coloredPlaceholder.manager.ColorManager;
import pashmash.coloredPlaceholder.util.ColorUtil;

@Getter
public class ColorMenu {
    public static void openColorSettingsMenu(Player player) {
        Gui gui = Gui.gui()
                .title(ColorUtil.translate(ColorUtil.PEACH + "Color Settings"))
                .rows(3)
                .create();

        gui.setDefaultClickAction(event -> event.setCancelled(true));

        setItem(gui, 11, Material.RED_WOOL, ColorEnums.RED, player, ColorUtil.ERROR + "RED");

        setItem(gui, 12, Material.GREEN_WOOL, ColorEnums.GREEN, player, ColorUtil.GREEN + "GREEN");

        setItem(gui, 13, Material.YELLOW_WOOL, ColorEnums.PEACH, player, ColorUtil.PEACH + "PEACH");

        setItem(gui, 14, Material.BLUE_WOOL, ColorEnums.BLUE, player, ColorUtil.BLUE + "BLUE");

        setItem(gui, 15, Material.GRAY_WOOL, ColorEnums.STANDART, player, ColorUtil.RESET + "STANDART");






        gui.open(player);
    }

    private static void setColor(Player player, ColorEnums color) {
        ColorManager.setColor(player, color);
        player.sendMessage(ColorUtil.translate(ColorUtil.PREFIX + "You have changed your theme color"));
    }

    public static void setItem(Gui gui, int slot, Material material, ColorEnums color, Player player, String name) {
        gui.setItem(slot, ItemBuilder.from(material).name(ColorUtil.translate(name)).asGuiItem(event -> {
            setColor(player, color);
            gui.close(player);
        }));
    }
}
