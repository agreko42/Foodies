package com.foodies.backend.data;

import java.util.List;

public record Menu(List<Dish> dishes, MenuType menuType) {
    public void addDish(Dish dish) {
        dishes.add(dish);
    }
}
