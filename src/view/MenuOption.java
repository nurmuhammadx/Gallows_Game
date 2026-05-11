package view;

public enum MenuOption {
    NEW_GAME(1, "New Game"),
    EXIT_GAME(0, "Exit");

    private final int value;
    private final String description;

    MenuOption(int value, String name) {
        this.value = value;
        this.description = name;
    }

    public int getValue() {
        return value;
    }

    public String getDescription() {
        return description;
    }

    public static MenuOption getMenuOption(int value) {
        for (MenuOption menuOption : MenuOption.values()) {
            if (menuOption.getValue() == value) {
                return menuOption;
            }
        }
        return null;
    }
}

