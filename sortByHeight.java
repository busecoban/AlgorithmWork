public class sortByHeight {
    /*
    CLASSROOM BOOKS
In a classroom, students are asked to stack books by height in ascending
order. Some books are taller than others, and the teacher wants the shortest
books stacked first. Using only insertion sort, modify the algorithm to sort
the books by height.
     */

     public static void insertionSort(int[] heights){
            int n=heights.length;
            for(int i=1;i<n;i++){
                int key=heights[i];
                int j=i-1;
                while(j>=0 && heights[j]>key){
                    heights[j+1]=heights[j];
                    j--;
                }
                heights[j+1]=key;
            }
     }
     public static void main(String[] args) {
        int[] bookHeights = {45, 32, 60, 22, 41};
        System.out.println("Original heights: " + java.util .Arrays.toString(bookHeights));
        insertionSort(bookHeights);
        System.out.println("Sorted heights: " + java.util.Arrays.toString(bookHeights));
     }


}
