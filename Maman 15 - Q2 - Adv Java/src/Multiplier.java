public class Multiplier implements Runnable{

	private int column;
	private int row;
	private int result = 0;

	public Multiplier(int column, int row) {
		this.column = column;
		this.row = row;
	}

	@Override
	public void run(){
		for (int i = 0; i < Main.matrixALenght; i++) {
			result += Main.matrixA[column][i] * Main.matrixB[i][row];
			System.out
			.printf("Multiplying matrixA[%d][%d]* Main.matrixB[%d][%d] = %d * %d = %d\n",
					column, i, i, row, Main.matrixA[column][i],
					Main.matrixB[i][row], Main.matrixA[column][i]
							* Main.matrixB[i][row]);
		}

		try {
			System.out.print(result + "\n");
		} catch (Exception e){
			e.printStackTrace();
		}
	}
}
