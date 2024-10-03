public class AirlineTicketSorter {

    //ücreti loyalty olup olmadığı loyaltyse 1 değilse 0 priceları aynıysa ikinci kısma bakıyo

    private static final int CHUNK_SIZE=7;
   
    public static void threeWayMergeSort(int[][] tickets,int left,int right){
        if(left<right){
            int mid1=left+(right-left)/3;
            int mid2=left+2*(right-left)/3;
            if(right-left<=CHUNK_SIZE){
                insertionSort(tickets, left, right);
                return;
            }
            threeWayMergeSort(tickets, left, mid1-1);
            threeWayMergeSort(tickets, mid1, mid2-1);
            threeWayMergeSort(tickets, mid2, right);

            mergeThreeWay(tickets, left, mid1, mid2, right);
        }

    }
    public static void insertionSort(int[][] tickets,int left,int right){
        for(int i=left+1;i<=right;i++){
            int[] key=tickets[i];
            int j=i-1;
            while(j>=left && tickets[j][0]>key[0]){
                tickets[j+1]=tickets[j];
                j--;
            }
            tickets[j+1]=key;
        }

    }
    public static void mergeThreeWay(int [][] tickets,int left,int mid1,int mid2,int right){

     

        int n1=mid1-left+1;
        int n2=mid2-mid1;
        int n3=right-mid2;
        int[][] leftArray=new int[n1][2];
        int[][] middleArray=new int[n2][2];
        int[][] rightArray=new int[n3][2];

        for(int i=0;i<n1;i++){
            leftArray[i]=tickets[left+i];
        }
        for(int i=0;i<n2;i++){
            middleArray[i]=tickets[mid1+1+i];
        }
        for(int i=0;i<n3;i++){
            rightArray[i]=tickets[mid2+1+i];
        }
        int i=0,j=0,k=0;
        int l=left;
        while(i<n1 && j<n2 && k<n3){
            if(compare(leftArray[i],middleArray[j])<=0 && compare(leftArray[i],rightArray[k])<=0){
                tickets[l]=leftArray[i];
                i++;
            }else if(compare(middleArray[j],leftArray[i])<=0 && compare(middleArray[j],rightArray[k])<=0){
                tickets[l]=middleArray[j];
                j++;
            }else{
                tickets[l]=rightArray[k];
                k++;
            }
            l++;
        }
        while(i<n1 && j<n2){
            if(compare(leftArray[i],middleArray[j])<=0){
                tickets[l]=leftArray[i];
                i++;
            }else{
                tickets[l]=middleArray[j];
                j++;
            }
            l++;
        }
        while(i<n1 && k<n3){
            if(compare(leftArray[i],rightArray[k])<=0){
                tickets[l]=leftArray[i];
                i++;
            }else{
                tickets[l]=rightArray[k];
                k++;
            }
            l++;
        }
        while(j<n2 && k<n3){
            if(compare(middleArray[j],rightArray[k])<=0){
                tickets[l]=middleArray[j];
                j++;
            }else{
                tickets[l]=rightArray[k];
                k++;
            }
            l++;
        }




        while(i<n1){
            tickets[l]=leftArray[i];
            i++;
            l++;
        }
        while(j<n2){
            tickets[l]=middleArray[j];
            j++;
            l++;
        }
        while(k<n3){
            tickets[l]=rightArray[k];
            k++;
            l++;
        }



    }
    static int compare(int[] ticket1,int[] ticket2){
        if(ticket1[0]!= ticket2[0]){
            return Integer.compare(ticket1[0], ticket2[0]);
        }else{
            return Integer.compare(ticket1[1], ticket2[1]);
        }
    }
  
    public static void printTickets(int[][] tickets) {
        for (int[] ticket : tickets) {
        System.out.println("Price: " + ticket[0] + ",  Loyalty: " + (ticket[1] == 1 ? "Yes" : "No")   );
     }
    }
    public static void main(String[] args) {
        int [][] tickets={{100,1},{100,0},{400,0},{300,0},{500,1},{400,1},{700,1},{600,1},{800,1}};
      //  int [][] tickets={{500,0},{300,1},{500,1},{400,0},{300,0},{700,1},{600,0},{200,1}};

        System.out.println("Original Tickets:");
        printTickets(tickets);
        threeWayMergeSort(tickets,0,tickets.length-1);
        System.out.println("sorted tickets by price and loyalty: ");
        printTickets(tickets);

    }




}
