package Intermedio.Polimorfismo.Ejemplo3;

public class Principal {
    public static void main(String[] args) {
        Animal animal = new Animal();
        Pig cerdo = new Pig();
        Dog perro = new Dog();

        animal.animalSound();
        cerdo.animalSound();
        perro.animalSound();
    }
}

class Animal {
    public void animalSound() {
        System.out.println("The animal makes a sound");
    }
}

class Pig extends Animal {
    public void animalSound() {
        System.out.println("The pig says: wee wee");
    }
}

class Dog extends Animal {
    public void animalSound() {
        System.out.println("The dog says: bow wow");
    }
}
