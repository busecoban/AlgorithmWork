public class JobApplicationSort {

    public static void primarySort(int[][] applications, int left, int right) {
        int chunkSize = 5;
        if (left < right) {
            if (right - left + 1 <= chunkSize) {
                insertionSort(applications, left, right);
            } else {
                int middle = (left + right) / 2;
                primarySort(applications, left, middle);
                primarySort(applications, middle + 1, right);
                merge(applications, left, middle, right);
            }
        }
    }

    public static void insertionSort(int[][] applications, int left, int right) {
        for (int i = left + 1; i <= right; i++) {
            int[] key = applications[i];
            int j = i - 1;
            while (j >= left && (applications[j][0] > key[0] ||
                   (applications[j][0] == key[0] && applications[j][1] < key[1]))) {
                applications[j + 1] = applications[j];
                j--;
            }
            applications[j + 1] = key;
        }
    }

    public static void merge(int[][] applications, int left, int middle, int right) {
        int n1 = middle - left + 1;
        int n2 = right - middle;

        int[][] L = new int[n1][2];
        int[][] R = new int[n2][2];

        for (int i = 0; i < n1; i++) {
            L[i] = applications[left + i];
        }
        for (int j = 0; j < n2; j++) {
            R[j] = applications[middle + 1 + j];
        }

        int i = 0, j = 0, k = left;
        while (i < n1 && j < n2) {
            if (L[i][0] < R[j][0] || (L[i][0] == R[j][0] && L[i][1] > R[j][1])) {
                applications[k] = L[i];
                i++;
            } else {
                applications[k] = R[j];
                j++;
            }
            k++;
        }

        while (i < n1) {
            applications[k] = L[i];
            i++;
            k++;
        }

        while (j < n2) {
            applications[k] = R[j];
            j++;
            k++;
        }
    }

    public static void printApplications(int[][] applications) {
        for (int[] app : applications) {
            System.out.println("Experience: " + app[0] + " year, Commute Time: " + app[1] + " minutes");
        }
    }

    public static void main(String[] args) {
        int[][] applications = {
            {2, 100}, {5, 50}, {3, 20}, {5, 120}, {2, 40}
        };

        System.out.println("Original applications:");
        printApplications(applications);

        primarySort(applications, 0, applications.length - 1);

        System.out.println("\nSorted applications by experience and commute time:");
        printApplications(applications);
    }
}
