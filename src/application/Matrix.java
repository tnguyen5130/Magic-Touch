package application;

public class Matrix {
	private static int height = EnumSprite.HEIGHT.getValue();
	private static int width = EnumSprite.WIDTH.getValue();
	private static int size=20;
	public static int[][] matrix=new int[height][width];
	public static int[][] resizedMat=new int[size][size];
	
	public static void setUpMatrix() {
		for(int i=0;i<height;i++) {
			for(int j=0;j<width;j++) {
				matrix[i][j]=0;
			}
		}
	}
	
	public static void resizeMatrix() {
		for(int i=0;i<size;i++) {
			for(int j=0;j<size;j++) {
				resizedMat[i][j]=matrix[i*(height/size)][j*(width/size)];
			}
		}
	}
	
	public static void display() {
		for(int i=0;i<20;i++) {
			for(int j=0;j<20;j++) {
				System.out.print(resizedMat[i][j]+" ");
			}
			System.out.println("");
		}
	}
	
	public static void fillOne(int i, int j) {
		for(int m=20;m>-20;m--) {
			for(int n=20;n>-20;n--) {
				matrix[i-m][j-n]=1;
			}
		}
	}
}
