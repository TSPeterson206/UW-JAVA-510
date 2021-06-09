package scrapfile.main;

import java.util.Iterator;
import java.util.LinkedList;

public class PetShop {

    private static LinkedList<Animal> inventory = new LinkedList<Animal>();

    public static void main(String[] args) {
//        inventory.add(new Cat());
        addAnimal(new Cat());
        addAnimal(new Dog());
        addAnimal(new Bird());

        makeSomeNoise();
    }

    public static void addAnimal(Animal animal) {
        inventory.add(animal);
    }

    public static void makeSomeNoise() {
        Iterator<Animal> iterator = inventory.iterator();
        while (iterator.hasNext()) {
            iterator.next().makeNoise();
//            System.out.println(iterator.next().toString());
        }
    }
}
