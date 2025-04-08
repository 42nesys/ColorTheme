package pashmash.coloredPlaceholder.enums;

import lombok.Getter;

@Getter
public enum ColorEnums {
    RED("#FF331C"),
    PEACH("#fcce83"),
    GREEN("#8BC34A"),
    BLUE("#2196F3"),
    STANDART("&7");

    @Getter
    public final String colorCode;

    /**
     * Constructor for ColorEnums.
     *
     * @param colorCode The color code associated with the enum constant.
     */
    ColorEnums(String colorCode) {
        this.colorCode = colorCode;
    }

}