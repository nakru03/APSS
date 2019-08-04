package six.bruteforce;

import java.util.Scanner;

public class BOGGLE {
	static char[][] board = new char[5][5];
	static final int dx[] = {1,1,0,-1,-1,-1,0,1}; //우 부터 시계방향으로돔
	static final int dy[] = {0,1,1,1,0,-1,-1,-1};
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int tc = sc.nextInt(); //테케		
		for(int t=0; t<tc; ++t) {
			for(int y=0; y<5; ++y) {
				String oneLine = sc.next();
				board[y]=oneLine.toCharArray(); //board 인.
			}
			int n = sc.nextInt();
			boolean result = false;
			
			for(int i=0; i<n; ++i) {
				String s = sc.next();
			outter :for(int y=0; y<5; ++y) {
					for(int x=0; x<5; ++x) {
						result = hasWord(y,x,s,"");
						if(result) {
							System.out.println(s + " " + "YES"); //true면 return.
							break outter;
						}
					}
				}
				if(!result) System.out.println(s + " " + "NO");
			}
			
		}		
		
	}
	
	
	private static boolean hasWord(int y, int x, String word, String result) {
		if(result.equals(word)) { //result와 word가 일치 true.
			//System.out.println(result);
			return true;
		}
			
		if(board[y][x] != word.charAt(0)) //글자가 일치하는지 check.
			return false;
		
		if(word.length()==1) // 일치하면서 단어의 길이가 1개일때 
			return true;
		
		for(int dir = 0; dir < 8; ++dir) { //8ways check 
			int ny = y + dy[dir]; //next dir.
			int nx = x + dx[dir];
			if(ny<0 || nx <0 || ny>=board.length || nx>=board.length) continue;	//boundary check.		
			
			if(hasWord(ny, nx, word.substring(1), result)) { //substring을 통해 한글자씩 줄여나감.
				result += board[y][x]; //result에 담음.
				//System.out.println(result);
				return true;
			};
					
		}
		return false;
		
	}

}
