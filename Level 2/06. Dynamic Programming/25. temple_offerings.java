//https://practice.geeksforgeeks.org/problems/temple-offerings2831/1

class Solution {
    int offerings(int N, int arr[]) {
        int[] left = new int[N];
        int[] right = new int[N];

        left[0] = 1;

        for (int i = 1; i < N; i++) {
            if (arr[i - 1] < arr[i]) {
                left[i] = left[i - 1] + 1;
            } else {
                left[i] = 1;
            }
        }

        right[N - 1] = 1;

        for (int i = N - 2; i >= 0; i--) {
            if (arr[i + 1] < arr[i]) {
                right[i] = right[i + 1] + 1;
            } else {
                right[i] = 1;
            }
        }


        int sum = 0;
        for (int i = 0; i < N; i++) {
            int ito = Math.max(left[i], right[i]); //ith temple offerings

            sum += ito;
        }

        return sum;
    }
}