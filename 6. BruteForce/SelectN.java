package six.bruteforce;
/**
 * n의 수에서 m개를 선택하는 recursion
 * 조합을 재귀로 구현함
 * 
 */
import java.util.ArrayList;
import java.util.Scanner;

public class SelectN {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		ArrayList<Integer> picked  = new ArrayList<>();
		
		nPickm(n,m, picked); //n 고르고자하는 수 m pick하는 수 picked = 숫자가 담길 배열.
	}

	private static void nPickm(int n, int m, ArrayList<Integer> picked) {
		if(m==0) {			
				System.out.println(picked);
				return;
			}//base case
		//작은 원소부터 하나씩 탐색
		int smallest = -1;
		if(picked.isEmpty()) //가작 작은 원소를 서치. 0부터 증가. 첫번째 선택
			smallest = 0;
		else
			smallest = picked.get(picked.size()-1)+1;
			
		for(int next = smallest; next<n; ++next) {
			picked.add(next); //두번째 선택부터 add smallest에서 1씩 증가.
			nPickm(n, m-1, picked);//픽하는 수를 감소시키며 재귀
			picked.remove(picked.size()-1); //픽이 끝난 마지막 자리를 팝
		}
			
		
	}

}
