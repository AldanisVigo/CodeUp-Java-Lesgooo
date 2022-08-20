/*
    Arguments can be passed in to your program separated by a space.
*/


public class arguments {
    public static void main(String[] args){
        /*
            Arguments are passed in just like in C++, except there's no argc just args.length
         */
        for(int i = 0; i < args.length; i++){
            System.out.println(args[i]);
        }
    }
}
