package com.foodies.backend.logic;

class ServiceTest {
    /*
    private static Stream testingFoodlists () {

        List<Dish> breakfast = new ArrayList<>(
                List.of(new Dish("Cereal"),
                        new Dish("Bacon&Eggs"),
                        new Dish("Omelette"),
                        new Dish("Dry Toast")));
        List<Dish> lunch = new ArrayList<>(
                List.of(new Dish("Pizza"),
                        new Dish("Spaghetti"),
                        new Dish("Burger"),
                        new Dish("Sushi")));
        List<Dish> dinner = new ArrayList<>(
                List.of(new Dish("Salad"),
                        new Dish("Steak"),
                        new Dish("Cold Cut Platter"),
                        new Dish("Soup")));

        List<Dish> allDishes = new ArrayList<>(breakfast);
        allDishes.addAll(lunch);
        allDishes.addAll(dinner);

        List<Dish> BreakfastLunch= new ArrayList<>(breakfast);
        BreakfastLunch.addAll(lunch);

        return  Stream.of(
                breakfast,
                lunch,
                dinner,
                BreakfastLunch,
                allDishes
                );
    }
    private Random random = new Random();

    @ParameterizedTest
    @MethodSource("testingFoodlists")
    void getRandomMeal(List<Dish> list) {
        List<String> stringList = list.stream()
                .map(dish -> dish.getName())
                .collect(Collectors.toList());

        Service service = new Service(randomNumberGenerator);

        String actual = service.getRandomMeal(list, random);

        assertTrue(stringList.contains(actual));
    }

     */
}