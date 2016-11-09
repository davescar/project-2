package project2.ds.project2;

import java.util.ArrayList;

/**
 * Created by ds on 11/6/16.
 */

public class ShoppingCart {
    private static ShoppingCart sShoppingCart = null;
    private ArrayList<Animal> mAnimals;

    private ShoppingCart() {
        mAnimals = new ArrayList<>();

    }

    public static ShoppingCart getInstance() {
        if (sShoppingCart == null) {
            sShoppingCart = new ShoppingCart();
        }

        return sShoppingCart;

    }

    public void addAnimal(Animal animal) {
        mAnimals.add(animal);

    }

    public ArrayList<Animal> getAnimals() {
        return mAnimals;
    }
}
