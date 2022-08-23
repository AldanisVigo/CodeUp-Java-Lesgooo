public class accessibility {
    public static void main(String[] args){
        /*
            A public method can be accessed by any part of a program, including other classes.
            
            A static method can be called throughout a program without creating an instance of an object of a certain class.
            
            A void method does not return a value.

         */

        TestAccessibility.main(args);
    }
    
    /*
        This function is not static therefore in order to access it from outside this accessibility class, an instance of the class must be created
    */
    public int nonStaticIntFunction(){
        System.out.printf("Can public instance member functions access static class variables? %b\n",staticboolean);
        return 10;
    }

    /*
        This function is marked with the static keyword, therefore in order to access it from outside the accessibility class, an instance of the class does not have to be created.
        it can just be accessed directly.
     */
    public static int staticIntFunction(){
        return 10;
    }

    //Static methods are automatically public and always belong to the class itself, and not the instance object that you create from the class.
    static int publicStaticIntFunction(){
        return 10;
    }

    public static boolean staticboolean = true;
    int myInt = 20;
    static void staticMethodCanOnlyAccessStaticVariables(){
        //System.out.println(myInt); //This will throw an error because myInt is a non static class member
        System.out.printf("But we can access static variables just fine right? %b\n",staticboolean);
    }

}

class TestAccessibility{
    public static void main(String[] args){
        //How to call static methods.
        System.out.println(accessibility.publicStaticIntFunction());

        //How to call non static.
        accessibility ac = new accessibility();
        System.out.println(ac.nonStaticIntFunction());
        

        accessibility.staticMethodCanOnlyAccessStaticVariables();

    }
}
