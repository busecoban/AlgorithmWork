/*
In a school, you are a teacher who needs to sort a list of students’ test scores
for an upcoming report. However, new test scores keep coming in as you’re
sorting. Modify the merge sort algorithm to efficiently handle the arrival of
new scores without restarting the process.
Hint:
To handle this situation, you can use an online merge sort, which processes
incoming data as it arrives. One approach is to maintain a sorted list of scores
and, when a new score arrives, use binary search to find where it should be
inserted, then merge it into the already sorted list. This way, the additional
sorting happens incrementally, preventing a complete restart.
 */

import java.util.Arrays;

public class SchoolTestScores {
    public static void main(String[] args) {
        int[] testScores = {88, 92, 79, 85};
        int newScore = 90;
        mergeInsert(testScores, newScore);
    }

    public static void mergeInsert(int sortedArr[],int newScore){
        int[] newArr=new int[sortedArr.length+1];

        System.arraycopy(sortedArr, 0, newArr, 0, sortedArr.length);
   

      newArr[newArr.length-1]=newScore;
      mergeSort(newArr,0,newArr.length-1);
      System.out.println("with new score sorted: " + Arrays.toString(newArr) );
    
    }
    public static void mergeSort(int arr[],int beg,int end){
        if(beg<end){
            int mid=(beg+end)/2;
            mergeSort(arr,beg,mid);
            mergeSort(arr,mid+1,end);
            merge(arr,beg,mid,end);
        }
    }

    static void merge(int arr[],int beg,int mid,int end){
        int i,j,k=0;
        int n1=mid-beg+1;
        int n2=end-mid;

        int L[]=new int[n1];
        int R[]=new int[n2];

        for(i=0;i<n1;i++){
            L[i]=arr[beg+i];
        }

        for(j=0;j<n2;j++){
            R[j]=arr[mid+1+j];
        }
        i=0;
        j=0;
        k=beg;

        while(i<n1 && j<n2){
            if(L[i]<=R[j]){
                arr[k]=L[i];
                i++;

            }else{
                arr[k]=R[j];
                j++;

            }
            k++;
        }

        while(i<n1){
            arr[k]=L[i];
            i++;
            k++;
        }

        while(j<n2){
            arr[k]=R[j];
            j++;
            k++;
        }
    }

   
}
