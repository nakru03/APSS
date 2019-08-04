package six.bruteforce;

import java.util.Scanner;

/**
 * 코드 6.1 1부터 n까지의 합을 구하는 함수 & 재귀 구현.
 * @author SangHyung Kim
 *
 */
public class Recursion {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		//int res = sum1(n);
		int res = sum2(n);
		System.out.println(res);
		

	}

	private static int sum2(int n) {
		//기저, 할일, 재귀..
		if(n==1) //base case
			return 1;
		
		return n + sum2(n-1);
	}

	private static int sum1(int n) { //일반적인 반복문을 이용.
		int sum = 0;
		for(int i=1; i<=n; ++i) {
			sum += i;
		}
		return sum;
	}

}
