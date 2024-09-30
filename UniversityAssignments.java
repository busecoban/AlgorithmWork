/*
 You must sort a list of student assignments by their submission deadlines.
However, some assignments are submitted much earlier than others. Modify
the insertion sort algorithm to allow significant gaps between moves so you
can quickly sort assignments with vastly different deadlines.
Hint:
A good approach is to use gapped insertion sort, inspired by shell sort. In-
stead of moving assignments one position at a time as in usual insertion sort,
you first create larger gaps between the elements (e.g., comparing every 3rd
or 5th assignment), and then reduce the gap as the sort progresses. This
way, distant assignments are placed closer to their correct position faster.
 */

public class UniversityAssignments {
    public static void main(String[] args) {
        int[] deadlines = {40,10,30,50,20};
        shellSort(deadlines);
        System.out.println("Sorted deadlines: " + java.util.Arrays.toString(deadlines));
    }

    public static void gapedInsertionSort(int[] arr,int gap){
        for (int i = gap; i < arr.length; i++) {
            int key=arr[i];
            int j;
            for (j = i; j >= gap && arr[j - gap] > key;j -= gap) {
                arr[j]=arr[j-gap];
            }
            arr[j]=key;
            
        }

    }

    public static void shellSort(int[] arr){
        int n=arr.length;
        for (int gap = n/2; gap > 0; gap/=2) {
            gapedInsertionSort(arr, gap);
    }
}
}
