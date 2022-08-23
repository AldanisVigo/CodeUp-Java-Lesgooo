//Streams bring functional programming to java
import java.util.stream.*;
public class streams {
    /*
        Streams can be created from Collections, Lists, Sets, ints, longs, doubles, arrays, lines of a file.
        
        Stream operations begin with a source data set.

        Then there can be any number of intermediate operations:

        Intermediate Stream Operations:

        anyMatch()
        distinct()
        filter()
        findFirst()
        flatmap()
        map()
        skip()
        sorted()

        Order matters, filter first to reduce number of elements in a stream
        before sorting or mapping.

        For really large data sets consider using ParallelStream

        And finally there must be one terminal operation, and there can only be one 
        terminal operation. 

        Terminal Operations:

        forEach() -> Applies the same lambda function to all the elements in the reduced collection
        collect() -> Saves elements to a final collection

        //Reducing terminal operations reduce the collection to a single value or element.
        
        count()
        max()
        min()
        reduce()
        summaryMetrics()
    */

    //Example Integer Stream
    public static void main(String[] args){
        IntStream.range(0,10).forEach(e->System.out.printf("Looking at number %d\n",e));
        System.out.println();
    }
}
