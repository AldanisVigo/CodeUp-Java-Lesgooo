public class loops {
    public static void main(String[] args){
        //while loops
        int num = 0;
        System.out.printf("Number is : %d\n",num);
        while(num < 10){
            num++;
            System.out.printf("Number is still < 10 : %b\n",num < 10);
        }
        System.out.printf("10 == %d\n",num);


        //do-while loops
        do{
            num--;
            System.out.printf("Reducing number by 1 it is now %d\n",num);
        }while(num > 0);


        //for loops
        System.out.println("Now entering for loop; i=0|i<10|i++ && num+=i");
        for(int i = 0; i < 10; i++){
            num += i;
            System.out.printf("Number is now %d\n",num);
        }


        //for each loop
        String[] names = {"Aldanis","Jennifer","Delilah","Daniel","Delena","Damy","Dawson"};
        for(String name : names){
            System.out.printf("Saying hello to %s\n",name);
        }

        //break keyword - allows you to break out of a loop
        System.out.printf("Number is at %d\n",num );
        while(num > 0){
            num--;
            System.out.printf("The number is now %d\n",num);
            if(num == 10){ //When the number gets to 10, break out of the loop
                break;
            }
        }
        System.out.printf("We have exited the loop and the number is %d\n",num);

        //continue keyword - allows you to skip logic for a specific iteration of a loop
        for(int i = 0; i < num; i++){
            if(i == 4){
                System.out.println("Skipping using continue keyword");
                continue;
            } //Skip the 5th iteration
            System.out.printf("This is the %dth iteration\n",i);
        }
    }
}
