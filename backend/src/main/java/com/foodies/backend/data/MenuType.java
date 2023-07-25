package com.foodies.backend.data;

public enum MenuType {
    SWEET("sweet"),
    SAVOURY("savoury");

    private String menuType;

    MenuType(String menuType) {
        this.menuType = menuType;
    }

    public String getMenuType() {
        return menuType;
    }

}
