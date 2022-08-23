public class arrays {
    public static void main(String[] args){

        //Creating pre-populated arrays

        //Creating int array
        int[] myIntArray = {1,2,3,4,5,6,7,8};


        //Creating String array
        String[] myStringArray = {"String One","String Two","String Three","String Four","String Five"};


        //Changing an element's value in an array
        myIntArray[1] = 99;
        myStringArray[0] = "First Element";


        //Creating empty arrays
        int[] emptyIntArray = new int[5]; //This is an empty int array that can hold 5 ints
        emptyIntArray[0] = 0;
        emptyIntArray[1] = 2;
        emptyIntArray[2] = 4;
        emptyIntArray[3] = 6;
        emptyIntArray[4] = 8;

        //Multidimensional Array
        int[][] twoDimensionalArray = {{1,2,3},{1,2,3}};
        System.out.println(twoDimensionalArray[0][2]); //Should print 3
        System.out.println(twoDimensionalArray[1][1]); //Should print 2
        System.out.println(twoDimensionalArray[0][0]); //Should print 1

        
    }
}
