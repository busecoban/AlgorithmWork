/*
 You are working for an airline, and the company is offering discounts on
certain flight routes. You are tasked with sorting the ticket prices using
merge sort, but with a twist: for each flight with a discount, the discount
should be applied before sorting. Modify the merge sort algorithm to handle
price adjustments before sorting the tickets.
5
Hint:
The merge sort algorithm should be modified to adjust ticket prices during
the recursion phase. Before the actual sorting, for each ticket, you will check
if a discount is applicable and modify the ticket price accordingly. After
applying discounts, the usual merge sort procedure is followed.
 */

public class bankTransactions {
    public static void merge(int arr[],int beg,int mid,int end){
        int i,j,k;
        int n1=mid-beg+1;
        int n2=end-mid;

        int L[]=new int[n1],
            R[]=new int[n2];

            for ( i = 0; i <n1; i++) {
                L[i]=arr[beg+i];  
            }
            for ( j = 0; j < n2; j++) {
                R[j]=arr[mid+1+j];
            }
            i=0;
            j=0;
            k=beg;
            while (i<n1 && j<n2) {
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
            while (i<n2) {
                arr[k]=R[j];
                j++;
                k++;
            }

        
    }
    public static void mergeSortWithDiscount(int[] prices,int[] discounts,int left,int right){
        if(left<right){
            int middle=(left+right)/2;
            mergeSortWithDiscount(prices,discounts,left,middle);
            mergeSortWithDiscount(prices,discounts,middle+1,right);
            applyDiscounts(prices,discounts,left,right);
            merge(prices,left,middle,right);
            }
    }
    public static void applyDiscounts(int[] prices,int[] discounts,int left,int right){
        for (int i = left; i <= right; i++) {
            prices[i] -= discounts[i];
        }
    }
    public static void main(String[] args) {
        int[] prices = {100, 50, 150, 200, 75};
        int[] discounts = {10, 25, 20, 15, 5};
        System.out.println("original prices: "+ java.util.Arrays.toString(prices));
        mergeSortWithDiscount(prices,discounts,0,prices.length-1);


    }
}
