import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        toh(n, 1, 2, 3);
        //1 -> source
        //2 -> helper
        //3 -> destination
    }


    public static void toh(int n, int s, int h, int d) {
        if (n == 0) {
            return;
        }

        //move n-1 disks from source to helper
        toh(n - 1, s, d, h);
        //move nth disk from source to destination
        System.out.println("Move disk " + n + " from rod " + s + " to rod " + d);
        //move n-1 disks from helper to destination
        toh(n - 1, h, s, d);
    }

}
