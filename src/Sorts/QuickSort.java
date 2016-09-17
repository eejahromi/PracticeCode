package Sorts;


public class QuickSort {
    private static int n[];

    public static int[] quickSort(int array[]) {
        n = array;
        quickSort(0,n.length-1);
        return n;
    }

    private static void quickSort(int left,int right) {
        if(right-left <= 0) {
            return;
        }

        int pivot = n[right];
        int partition = getPartition(left,right,pivot);
        quickSort(left,partition-1);
        quickSort(partition+1,right);
    }

    private static int getPartition(int left, int right, int pivot) {
        int lptr = left-1;
        int rptr = right;

        for(;;) {
            while(n[++lptr] < pivot);
            while(rptr > 0 && n[--rptr] > pivot);
            if(lptr >= rptr) {
                break;
            } else {
                swap(lptr,rptr);
            }
        }

        swap(lptr,right);

        return lptr;
    }

    private static void swap(int lptr, int rptr) {
        int temp = n[lptr];
        n[lptr] = n[rptr];
        n[rptr] = temp;
    }
}
