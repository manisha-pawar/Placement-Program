import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();

		for (int i = 1; i <= 9; i++) {
			family_print(i, n);
		}
	}

	public static void family_print(int num, int n) {
		if (num > n) {
			return;
		}

		System.out.println(num);

		for (int i = 0; i <= 9; i++) {
			family_print(num * 10 + i, n);
		}
	}

}