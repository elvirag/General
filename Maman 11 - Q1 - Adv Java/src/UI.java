import javax.swing.JOptionPane;


public class UI {



	public static void main(String args[]){

		int input = 0;
		int newGame = JOptionPane.YES_OPTION;
		
		while (newGame == JOptionPane.YES_OPTION){
			while (input == JOptionPane.YES_OPTION){
				System.out.println("You have chosen to continue.");
				input = JOptionPane.showConfirmDialog(null, "Would you like to draw another card?", "21 Game" , JOptionPane.YES_NO_OPTION);
			}
			newGame = JOptionPane.showConfirmDialog(null, "You have chosen to not draw any cards.\n Would you like to play another game?!", "21 Game" , JOptionPane.YES_NO_OPTION);
		}
	}
}
