package pashmash.coloredPlaceholder.hook;

import lombok.Getter;
import me.clip.placeholderapi.expansion.PlaceholderExpansion;
import org.bukkit.OfflinePlayer;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import pashmash.coloredPlaceholder.enums.ColorEnums;
import pashmash.coloredPlaceholder.manager.ColorManager;

@Getter
public class PlaceholderHook extends PlaceholderExpansion {


    @Override
    public @NotNull String getIdentifier() {
        return "coloredplaceholder";
    }

    @Override
    public @NotNull String getAuthor() {
        return "42ne.sys";
    }

    @Override
    public @NotNull String getVersion() {
        return "1.0.0";
    }

    @Override
    public @Nullable String onRequest(OfflinePlayer player, @NotNull String params) {
        if (params.equals("color")) {
            ColorEnums colorEnum = ColorManager.getColor(player);
            return colorEnum != null ? colorEnum.colorCode : null;
        }

        return null;
    }
}
