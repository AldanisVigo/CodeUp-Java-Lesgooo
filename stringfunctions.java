public class stringfunctions {
    public static void main(String[] args){
        String myString = "Hello this is my string.";
        String myOtherString = "and this is an attachment";
        System.out.printf("My String: %s\n",myString);
        System.out.printf("My String Length: %d\n", myString.length());
        System.out.printf("My String Concat With Attachment: %s\n",myString.concat(myOtherString));
        System.out.printf("Does my string equal: \"and this is an attachment\"? %b\n",myString.equals(myOtherString));
        System.out.printf("myString.indexOf('this'): %d\n",myString.indexOf("this"));
        System.out.printf("myString.charAt(4): %c\n",myString.charAt(4));
        System.out.printf("myString.substring(6,4) : %s\n",myString.substring(6, 6+4));
        System.out.printf("myString.toUpperCase() : %s\n",myString.toUpperCase());
        System.out.printf("myString.toLowerCase() : %s\n",myString.toLowerCase());
    }
}
