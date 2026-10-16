import java.io.*;
import java.util.Random;

public class QuickSort
{
    /* function that consider last element as pivot,  
place the pivot at its exact position, and place  
smaller elements to left of pivot and greater  
elements to right of pivot.  */
    private void swap(int[] a, int left, int right) {
        int value = a[left];
        a[left] = a[right];
        a[right] = value;
    }

    /* Three-way partitioning keeps duplicate-heavy inputs near linear time. */
    void quick(int[] a, int start, int end) {
        while (start < end) {
            int pivot = a[start + (end - start) / 2];
            int lower = start;
            int current = start;
            int upper = end;

            while (current <= upper) {
                if (a[current] < pivot) {
                    swap(a, lower++, current++);
                } else if (a[current] > pivot) {
                    swap(a, current, upper--);
                } else {
                    current++;
                }
            }

            // Recurse only into the smaller partition to bound stack depth.
            if (lower - start < end - upper) {
                quick(a, start, lower - 1);
                start = upper + 1;
            } else {
                quick(a, upper + 1, end);
                end = lower - 1;
            }
        }
    }


    public static void main(String[] args) {
        int[] A = new int[1000];//muuta tästä taulukon kokoa
        Random satu = new Random();
        for (int i = 0; i < A.length; i++)//muista syöttää taulukon koko
            A[i] = satu.nextInt(30000000);
        int n = A.length;
        QuickSort q1 = new QuickSort();

        long alkuaika = System.currentTimeMillis();

        q1.quick(A, 0, n - 1);

        long loppuaika = System.currentTimeMillis();

        float sekuntit = Float.valueOf(loppuaika-alkuaika)/1000;

        System.out.println("Elapsed time: " + (loppuaika - alkuaika) + "ms");
        System.out.println("In seconds: " + sekuntit);
    }
}  