package Introduction;

public class mines100215 {
	static int row = getRandomInt(2);
	static int column = getRandomInt(2);

	public static void main(String[] args) {
		boolean[][] mines = new boolean[10][20];
		System.out.println(row+" and " +column);
		mines[row][column] = true;
		checkNeighbors(mines,row,column);
	}
	public static int getRandomInt(int max){
		int random = (int)(Math.random()*max)+1;
		return random;
	}
	public static int checkNeighbors(boolean[][] neighborhood, int r, int c){
		if (neighborhood[r][c]){
			guessed();
			return 0;
		}
		if (neighborhood[r-1][c] ||neighborhood[r+1][c]||neighborhood[r][c+1] ||neighborhood[r][c-1]){
			guessed1();
			return 1;
		}
		else
		{
			guessed2();
			return -1;
		}

	}
	public static void guessed(){
		System.out.println("at row " + row + ", column " + column + ", the mine was found!");	
	}
	public static void guessed1(){
		System.out.println("at row " + row + ", column " + column + ", the mine is nearby!");	
	}
	public static void guessed2(){
		System.out.println("at row " + row + ", column " + column + ", NO mine is nearby!");	
	}
}
