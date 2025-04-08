package pashmash.coloredPlaceholder.manager;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import lombok.Getter;
import org.bukkit.OfflinePlayer;
import pashmash.coloredPlaceholder.ColoredPlaceholder;
import pashmash.coloredPlaceholder.enums.ColorEnums;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Getter
public class ColorManager {
    private static final Map<UUID, ColorEnums> playerColors = new HashMap<>();
    private static final Gson gson = new GsonBuilder().setPrettyPrinting().create();

    public static ColorEnums getColor(OfflinePlayer player) {
        return playerColors.getOrDefault(player.getUniqueId(), ColorEnums.STANDART);
    }

    public static void setColor(OfflinePlayer player, ColorEnums color) {
        playerColors.put(player.getUniqueId(), color);
    }

    public static void saveColorsToFile() {
        File dataFolder = ColoredPlaceholder.getInstance().getDataFolder();
        if (!dataFolder.exists()) {
            dataFolder.mkdirs();
        }

        try (FileWriter writer = new FileWriter(new File(dataFolder, "playerColors.json"))) {
            gson.toJson(playerColors, writer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void loadColorsFromFile() {
        File dataFolder = ColoredPlaceholder.getInstance().getDataFolder();
        File file = new File(dataFolder, "playerColors.json");
        if (!file.exists()) {
            return;
        }

        try (FileReader reader = new FileReader(file)) {
            Type type = new TypeToken<Map<UUID, ColorEnums>>() {}.getType();
            Map<UUID, ColorEnums> loadedColors = gson.fromJson(reader, type);
            if (loadedColors != null) {
                playerColors.putAll(loadedColors);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}