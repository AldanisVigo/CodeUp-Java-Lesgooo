public class foo {

    private int privateInt = 20;

    //Accessor methods are used to give access to private members of the class
    public int myPrivateInt(){
        return privateInt;
    }

    //Mutator methods are used to change the value of a private member of the class
    public void setPrivateInt(int newInt){
        privateInt = newInt;
    }

    //Class constructors will execute when a new instance is created using the new keyword.
    foo(){
        System.out.println("A new foo has been created.");
    }

    public static void main(String[] args){
        foo myFoo = new foo(); //Calling the new keyword on a class will create an instance of that class and execute it's constructor
        System.out.printf("Getting foo private int through accessor method: %d\n",myFoo.myPrivateInt());
        System.out.println("Changing the value of the private in through a mutator method to 40.");
        myFoo.setPrivateInt(40);
        System.out.printf("Getting foo private int through accessor method: %d\n",myFoo.myPrivateInt());
    }
}
