/*
    THIS CODE HAS BEEN TAKEN FROM G4G AND HAS BEEN USED FOR BETTER UNDERSTANDING OF THIS ALGORITHM
*/

public class MergesortClass
{
    public void merge(long[] arr, int l, int m, int r)
    {
        //get lengths of halves to be merged
        int n1 = m - l + 1;
        int n2 = r - m;

        //initialise halves
        long[] L = new long[n1];
        long[] R = new long[n2];

        //feed first half into left array
        for (int i = 0; i < n1; ++i)
        {
            L[i] = arr[l + i];
        }

        //feed second half into right array
        for (int j = 0; j < n2; ++j)
        {
            R[j] = arr[m + 1 + j];
        }


        int i = 0, j = 0;

        int k = l;

        while (i < n1 && j < n2)
        {
            if (L[i] <= R[j])
            {
                arr[k] = L[i];
                i++;
            }
            else
            {
                arr[k] = R[j];
                j++;
            }
            k++;
        }

        while (i < n1)
        {
            arr[k] = L[i];
            i++;
            k++;
        }

        while (j < n2)
        {
            arr[k] = R[j];
            j++;
            k++;
        }
    }


    public void mergeSort(long[] arr, int l, int r)
    {
        if (l < r)
        {
            //find middle point of array
            int m = l + (r - l) / 2;
        
            //sort first and second halves
            mergeSort(arr, l, m);
            mergeSort(arr, m + 1, r);

            //merge sorted halves together and repeat
            merge(arr, l, m, r);
        }
    }
}
