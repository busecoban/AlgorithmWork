
/*
 You work at a library with limited shelving space and need to sort a collection
of books. However, you only have room for one additional temporary shelf
for sorting. Modify the merge sort algorithm to use only a constant amount
of extra space.
Hint:
To implement an in-place merge sort, modify the merging step to avoid using
extra arrays. Instead, you can merge by shifting elements directly within
the array, similar to how insertion sort works. This requires more complex
element swapping during the merge step, but it allows you to sort using
constant space (O(1) extra memory).
 */
public class LibraryBooks {
    public static void main(String[] args) {
        int[] books={35,20,50,10,40,30};
        System.out.println("original shelf: "+java.util.Arrays.toString(books));

        mergeSort(books,0,books.length-1);
        System.out.println("sorted shelf: "+java.util.Arrays.toString(books));
    }

    public static void mergeSort(int arr[],int left,int right){
        if(left<right){
            int middle=left + (right-left)/2;
            mergeSort(arr,left,middle);
            mergeSort(arr,middle+1,right);
            mergeInPlace(arr,left,middle,right);
        }
    }

    private static void mergeInPlace(int[] arr,int left,int middle,int right){
        int start1=left;
        int start2=middle+1;

        while(start1<=middle && start2<=right){
            if(arr[start1]<=arr[start2]){
                start1++;
            }else{
            int value=arr[start2];
            int index=start2;
            while(index>start1){
                arr[index]=arr[index-1];
                index--;
            }
            arr[start1]=value;
            start1++;
            middle++;
            start2++;
            }


        }

       

    }

    

}
