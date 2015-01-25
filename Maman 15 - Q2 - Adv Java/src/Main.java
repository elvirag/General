import java.util.Random;


public class Main{


	public static int matrixAWidth;
	public static int matrixALenght;
	public static int matrixBWidth;
	public static int matrixBLenght;


	public static int[][] matrixA;
	public static int[][] matrixB;

	public static Random rand = new Random();

	public static void main(String[] args) {

		matrixAWidth = Integer.parseInt(args[0]);
		matrixALenght = Integer.parseInt(args[1]);
		matrixBWidth = Integer.parseInt(args[2]);
		matrixBLenght = Integer.parseInt(args[3]);
		
		if (matrixALenght != matrixBWidth){
			System.err.println("The inner dimensions don't match.");
			System.exit(0);
		}
		
		System.out.printf("The variables are: A[%d][%d] * B[%d][%d]\n\n",matrixAWidth, matrixALenght, matrixBWidth, matrixBLenght);

		matrixA = generateMatrix(matrixAWidth, matrixALenght);
		matrixB = generateMatrix(matrixBWidth, matrixBLenght);



		for (int i = 0; i< matrixAWidth ; i++){
			for (int j = 0; j < matrixBLenght ; j++){
				Multiplier mult = new Multiplier(i, j);
				mult.run();
			}
		}
	}

	private static int[][] generateMatrix(int matrixWidth, int matrixLenght) {
		int[][] matrix = new int[matrixWidth][matrixLenght];
		for (int i = 0; i< matrixWidth ; i++){
			for (int j = 0; j < matrixLenght ; j++){
				matrix[i][j] = rand.nextInt(10);
				System.out.print(matrix[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println("******************");
		return matrix;
	}
}
