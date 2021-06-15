import java.io.*;
import java.util.*;

public class Main {

	public static int solution(String[] words, int[] farr, int[] score, int idx) {
		if (idx == words.length) {
			return 0;
		}

		int no = solution(words, farr, score, idx + 1);

		int msc = 0; //myscore -> words[idx]
		int li = words[idx].length();

		for (int i = 0; i < words[idx].length(); i++) {
			char ch = words[idx].charAt(i);

			if (farr[ch - 'a'] > 0) {
				farr[ch - 'a']--;
			} else {
				li = i;
				break;
			}

			msc += score[ch - 'a'];
		}

		int yes = 0;
		int myans = no;

		if (li == words[idx].length()) {
			yes = solution(words, farr, score, idx + 1);
			myans = Math.max(no, yes + msc);
		}

		for (int i = 0; i < li; i++) {
			char ch = words[idx].charAt(i);
			farr[ch - 'a']++;
		}

		return myans;

	}

	public static void main(String[] args) {

		Scanner scn = new Scanner(System.in);
		int nofWords = scn.nextInt();
		String[] words = new String[nofWords];
		for (int i = 0; i < words.length; i++) {
			words[i] = scn.next();
		}
		int nofLetters = scn.nextInt();
		char[] letters = new char[nofLetters];
		for (int i = 0; i < letters.length; i++) {
			letters[i] = scn.next().charAt(0);
		}
		int[] score = new int[26];
		for (int i = 0; i < score.length; i++) {
			score[i] = scn.nextInt();
		}
		if (words == null || words.length == 0 || letters == null || letters.length == 0 || score == null ||
			score.length == 0) {
			System.out.println(0);
			return;
		}
		int[] farr = new int[score.length];
		for (char ch: letters) {
			farr[ch - 'a']++;
		}
		System.out.println(solution(words, farr, score, 0));

	}
}