import java.util.Random;

//im very aware this is ALL a mess so just let it be, im learnding 

/*
    This program is for me to learn and study two different sorting algorithms,
    in this case being both Quick Sort and Merge Sort

    Alongside this demo program, I have looked at the pros and cons to both of these sorting algorithms
    such as their big O notation times and such.


    Quick Sort notes:

    - Best Case: O(n log n)
    - Average Case: O(n log n)
    - Worst: O(n^2)

    - Best and Average are the same, but has the chance to take extremely long depending on how 
      the dataset to be sorted is arranged prior to sorting
        - Worst case happens when the pivot chosen is ALWAYS the smallest or largest element 
          in the dataset, this worst case puts it to a similar speed to Bubble Sort

    Merge Sort notes:

    - Best Case: O(n log n)
    - Average Case: O(n log n)
    - Worst Case: O(n log n)

    - Best, Average, and Worst case time complexity is all the same, O(n log n), where n is 
      the size of a dataset
        - can be assumed that merge sort may be slower than quick sort but is very consistent
*/
public class App
{
    public App()
    {  
        //QUICK SORT
        long[] array = new long[10];
        long[] array_dup = new long[10];
        Random r = new Random();
        for (int i = 0; i < array.length; i++)
        {
            long random_num = Math.abs(r.nextLong(1000L));
            array[i] = random_num;
            array_dup[i] = random_num;
        }

        System.out.println("Quick Sort with array: ");
        for (long i : array)
        {
            System.out.print(i + " ");
        }
        System.out.println();

        QuicksortClass qs = new QuicksortClass();

        long start_time = System.nanoTime(); //start timing how long the sort takes
        qs.quickSort(array, 0, array.length - 1);
        long end_time = System.nanoTime(); //end timing how long the sort takes

        long duration = (end_time - start_time); //time in nanoseconds
        

        
        System.out.println("Quick Sort result:\t\t time taken: " + duration + "ns");
        for (long i : array)
        {
            System.out.print(i + " ");
        }
        System.out.println("\n");
        //END QUICKSORT

        /*--------------------------------------------------------------------------------- */
        
        //MERGE SORT

        System.out.println("Merge Sort with array: ");
        for (long i : array_dup)
        {
            System.out.print(i + " ");
        }
        System.out.println();
        MergesortClass ms = new MergesortClass();

        start_time = System.nanoTime();
        ms.mergeSort(array_dup, 0, array_dup.length - 1);
        end_time = System.nanoTime();

        duration = (end_time - start_time);

        System.out.println("Merge Sort Result: \t\t time taken: " + duration + "ns");
        for (long i : array_dup)
        {
            System.out.print(i + " ");
        }
        System.out.println();

        //END MERGE SORT
    }



    public static void main(String[] args) 
    {
        new App(); //get out of static trap
    }
}