/*
    THIS CODE HAS BEEN TAKEN FROM G4G AND HAS BEEN USED FOR BETTER UNDERSTANDING OF THIS ALGORITHM
*/
public class QuicksortClass
{
    public void swap(long[] array, int i, int j)
    {
        long temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    public int partition(long[] array, int low, int high)
    {
        //set pivot
        long pivot = array[high];

        // i honestly have no idea what this low - 1 is supposed to do
        int i = low - 1;

        for (int j = low; j < high; j++)
        {
            if (array[j] < pivot)
            {
                i++;
                swap(array, i, j);
            }
        }

        swap(array, i + 1, high);

        return i + 1;
    }

    public void quickSort(long[] array, int low, int high)
    {
        if (low < high)
        {
            //get partition index where we get the pivot
            int partition_index = partition(array, low, high);
            
            //recurively call until sorted
            quickSort(array, low, partition_index - 1);
            quickSort(array, partition_index + 1, high);
        }
    }
}
