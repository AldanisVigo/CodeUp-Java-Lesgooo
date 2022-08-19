
import java.util.Scanner;

class Hello{
    public static void main(String[] args){
        // System.out.println(name.length());
        // System.out.println(name.toUpperCase());
        // System.out.println(name.toLowerCase());
        // System.out.println(name.indexOf("bob"));
        //String Formatting
        /*
           Kind of like string Interpolation
        */
        int age = 18;
        String name = "Avinash is %d years old.";
        System.out.printf(name,age);

        //Polymorphism at it's worst
        Animal animal = new Animal();
        animal.eat();

        Dog dog = new Dog();
        dog.eat();

        Cat cat = new Cat();
        cat.eat();

        Poodle poodle = new Poodle();
        poodle.eat();

        //User input using a Scanner
        Scanner scantron =  new Scanner(System.in);
        System.out.print("Please input something:");
        String input = scantron.nextLine();
        System.out.printf("You enetered: %s\n",input);
        scantron.close();
    }
}

//Polymorphism
class Animal{
    void eat(){
        System.out.println("chomp chomp");
    }
}

class Dog extends Animal{
    void eat(){
        System.out.println("nom nom");
    }
}

class Poodle extends Dog{

}


class Cat extends Animal{
    void eat(){
        System.out.println("yum yum");
    }
}



