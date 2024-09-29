public class mergeSort {
    public static void main(String[] args) {
        int arr[]={3,2,10,5,7};
        mergeSort ob=new mergeSort();
        ob.sort(arr,0,arr.length-1);
        for(int i=0;i<arr.length;i++){
            System.out.print(arr[i] + " ");
        }
    }

    void sort(int arr[],int beg,int end){
        if(beg<end){
            int mid=(beg+end)/2;
            sort(arr,beg,mid);
            sort(arr,mid+1,end);
            merge(arr,beg,mid,end);
        }
    }
    
    static void merge(int arr[],int beg,int mid,int end){
       int i,j,k;
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

       while (i<n1) {
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
