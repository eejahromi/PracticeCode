package Sorts;


public class MergeSort {

    static int n[];
    static int aux[];

    public static int[] mergeSort(int array[]) {
        n = array;
        aux = new int[n.length];
        mergeSortHelper(0,n.length-1);
        return n;
    }

    private static void mergeSortHelper(int low, int high) {
        if(low == high) {
            return;
        }
        int mid = (high + low)/2;
        mergeSortHelper(low,mid);
        mergeSortHelper(mid+1,high);
        merge(low,mid+1,high);
    }

    private static void merge(int low, int high, int upperbound) {
        int i=0;
        int lowerbound = low;
        int mid = high - 1;
        int elementCount = upperbound - lowerbound+1;

        while(low <= mid && high <= upperbound) {
            if(n[low] <= n[high]) {
                aux[i++] = n[low++];
            } else {
                aux[i++] = n[high++];
            }
        }

        while(low <= mid) {
            aux[i++] = n[low++];
        }

        while(high <= upperbound) {
            aux[i++] = n[high++];
        }

        for(int j=0;j<elementCount;j++) {
            n[lowerbound+j] = aux[j];
        }
    }
}
