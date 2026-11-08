import java.util.Random;

//im very aware this is ALL a mess so just let it be, im learnding 
public class App
{
    public App()
    {  
        long[] array, array_dup;

        array = getRandomIntArray();
        array_dup = array;


        System.out.println("Quick Sort with array: ");
        for (long i : array)
        {
            System.out.print(i + " ");
        }
        System.out.println();
        QuicksortClass qs = new QuicksortClass(array);

        long start_time = System.nanoTime(); //start timing how long the sort takes
        qs.quickSort(array, 0, array.length - 1);
        long end_time = System.nanoTime(); //end timing how long the sort takes

        long duration = (end_time - start_time); //time in nanoseconds
        long[] qs_sorted = qs.arr;

        
        System.out.println("Quick Sort result:\t\t time taken: " + duration + "ns");
        for (long i : qs_sorted)
        {
            System.out.print(i + " ");
        }
        System.out.println("\n");


        System.out.println("Merge Sort with array: ");
        for (long i : array_dup)
        {
            System.out.print(i + " ");
        }
        System.out.println();
        MergesortClass ms = new MergesortClass(array_dup);

        start_time = System.nanoTime();
        ms.mergeSort(array_dup, 0, array_dup.length - 1);
        end_time = System.nanoTime();

        duration = (end_time - start_time);
        long[] ms_sorted = ms.arr;

        System.out.println("Merge Sort Result: \t\t time taken: " + duration + "ns");
        for (long i : ms_sorted)
        {
            System.out.print(i + " ");
        }
        System.out.println();
    }

    //number to digit array conversion stolen from stackoverflow ty babes <33 
    public long[] getRandomIntArray()
    {
        //generate random number
        Random r = new Random();
        long random_number = r.nextLong(1000000000000000000L);

        //turn number into a string
        String numberString = Long.toString(random_number);
        long[] digits = new long[numberString.length()]; //create long array of size of number string

        for (int i = 0; i < numberString.length(); i++)
        {
            //add each char of string array as an element in integer array
            digits[i] = Long.parseLong(String.valueOf(numberString.charAt(i)));
        }

        return digits;
    }

    public static void main(String[] args) 
    {
        new App(); //get out of static trap
    }
}