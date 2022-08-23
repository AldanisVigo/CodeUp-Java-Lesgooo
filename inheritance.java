public class inheritance {
    public static void main(String[] args){
        ClassTwo myClass = new ClassTwo(); 
        myClass.walk(); //Accessing method that was inherited from ClassOne
    } 
}

//Superclass - Class that other classess inherit functions and attributes from
class ClassOne{ 
    public void walk(){
        System.out.println("Walking");
    }
}


//Subclass - Class that inherits functions and attributes from the Superclass.
class ClassTwo extends ClassOne{
    //That's why there's nothing in the class. Because all functionality is inherited from the Superclass ClassOne.
}



class Shape{
    public int numberOfSides;

    Shape(int sides){
        numberOfSides = sides;
    }
}

class Square extends Shape{
    Square(){
        super(4); //Calling super will call the constructor of the Superclass we are extending.
    }
}