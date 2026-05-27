package com.pluralsight.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class HotDogTest {

    @Test
    public void testBasePriceRegular() {
        HotDog dog = new HotDog(HotDogSize.REGULAR, HotDogType.CLASSIC);
        assertEquals(5.00, dog.getPrice());
    }

    @Test
    public void testBasePriceFootlong() {
        HotDog dog = new HotDog(HotDogSize.FOOTLONG, HotDogType.BEEF);
        assertEquals(7.00, dog.getPrice());
    }

    @Test
    public void testBasePriceJumbo() {
        HotDog dog = new HotDog(HotDogSize.JUMBO, HotDogType.TURKEY);
        assertEquals(9.00, dog.getPrice());
    }

    @Test
    public void testMeatTopping() {
        HotDog dog = new HotDog(HotDogSize.FOOTLONG, HotDogType.CLASSIC);
        dog.addTopping(new Topping("Bacon", ToppingCategory.MEAT, false));
        assertEquals(8.50, dog.getPrice());
    }

    @Test
    public void testCheeseTopping() {
        HotDog dog = new HotDog(HotDogSize.REGULAR, HotDogType.CLASSIC);
        dog.addTopping(new Topping("Cheddar", ToppingCategory.CHEESE, false));
        assertEquals(6.00, dog.getPrice());
    }

    @Test
    public void testExtraMeat() {
        HotDog dog = new HotDog(HotDogSize.JUMBO, HotDogType.BEEF);
        dog.addTopping(new Topping("Bacon", ToppingCategory.MEAT, false));
        dog.addTopping(new Topping("Bacon", ToppingCategory.MEAT, true));
        assertEquals(13.00, dog.getPrice());
    }

    @Test
    public void testExtraCheese() {
        HotDog dog = new HotDog(HotDogSize.FOOTLONG, HotDogType.CLASSIC);
        dog.addTopping(new Topping("Cheddar", ToppingCategory.CHEESE, false));
        dog.addTopping(new Topping("Cheddar", ToppingCategory.CHEESE, true));
        assertEquals(9.50, dog.getPrice());
    }

    @Test
    public void testRegularToppingsAreFree() {
        HotDog dog = new HotDog(HotDogSize.REGULAR, HotDogType.CLASSIC);
        dog.addTopping(new Topping("Onions", ToppingCategory.REGULAR, false));
        dog.addTopping(new Topping("Relish", ToppingCategory.REGULAR, false));
        dog.addTopping(new Topping("Mustard", ToppingCategory.SAUCE, false));
        assertEquals(5.00, dog.getPrice());
    }

    @Test
    public void testDisplayName() {
        HotDog dog = new HotDog(HotDogSize.JUMBO, HotDogType.BEEF);
        assertEquals("Jumbo Beef Hot Dog", dog.getDisplayName());
    }

    @Test
    public void testDisplayNameLoaded() {
        HotDog dog = new HotDog(HotDogSize.FOOTLONG, HotDogType.CLASSIC);
        dog.setLoaded(true);
        assertEquals("Footlong Classic Hot Dog (Loaded)", dog.getDisplayName());
    }
}