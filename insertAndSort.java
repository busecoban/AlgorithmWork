public class insertAndSort {
 
    void sort(int arr[]){
       int  n=arr.length;
        for(int i=1;i<n;i++){
            int key=arr[i]; 
            int j=i-1;
            while(j>=0 && arr[j]>key){
                arr[j+1]=arr[j];
                j=j-1;
            }
            arr[j+1]=key;
        }
    }

    int[] insert(int arr[],int x){
        int n=arr.length;
        int newArr[]=new int[n+1];
        int i;
        for (i = 0; i < n; i++) {
            newArr[i]=arr[i];
        }
        newArr[i]=x;
        return newArr;

    }

    void printArr(int arr[]){
        int n=arr.length;
        for (int i = 0; i <n ; i++) {
            System.out.print(arr[i]+" ");
        }
        System.out.println();
    }

   
    public static void main(String[] args) {
        insertAndSort ob = new insertAndSort();
        int arr[]={12,11,13,5,6};
        System.out.println("starting arr");
        ob.printArr(arr);
        System.out.println("sorted arr");
        ob.sort(arr);
        ob.printArr(arr);
        System.out.println("inserting and sorting 7");
        int[] newArr = ob.insert(arr,7);
        ob.sort(newArr);
        ob.printArr(newArr);

    }



}
