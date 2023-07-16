package com.foodies.backend.data;

public enum MenuType {
    SWEET("sweet"),
    SEVERY("severy");

    private String menuType;

    MenuType(String menuType) {
        this.menuType = menuType;
    }

    public String getMenuType() {
        return menuType;
    }

}
