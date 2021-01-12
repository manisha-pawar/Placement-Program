import java.util.Scanner;

public class Main {

    public static int search(int[] ar, int key) {

        //Write your code here
        int pos = -1;
        int l = 0;
        int r = ar.length - 1;

        while (l <= r) {
            int mid = (l + r) / 2;

            if (ar[mid] == key) {
                pos = mid;
                break;
            } 
            else if (ar[mid] > key) {
                r = mid - 1;
            } 
            else if (ar[mid] < key) {
                l = mid + 1;
            }
        }

        return pos;

    }

    public static void main(String[] args) {

        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int[] ar = new int[n];
        for (int i = 0; i < ar.length; i++) {
            ar[i] = s.nextInt();
        }
        int key = s.nextInt();
        System.out.println(search(ar, key));
    }
}
