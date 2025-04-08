package pashmash.coloredPlaceholder;

import lombok.Getter;
import org.bukkit.plugin.java.JavaPlugin;
import pashmash.coloredPlaceholder.command.ColorCommand;
import pashmash.coloredPlaceholder.hook.PlaceholderHook;
import pashmash.coloredPlaceholder.manager.ColorManager;

@Getter
public final class ColoredPlaceholder extends JavaPlugin {

    @Getter
    private static ColoredPlaceholder instance;
    private PlaceholderHook placeholderHook;

    @Override
    public void onEnable() {
        instance = this;
        // Registering PlaceholderAPI hook
        placeholderHook = new PlaceholderHook();
        placeholderHook.register();
        // Registering command
        ColorManager.loadColorsFromFile();
        new ColorCommand();
    }

    @Override
    public void onDisable() {
        ColorManager.saveColorsToFile();
    }
}
