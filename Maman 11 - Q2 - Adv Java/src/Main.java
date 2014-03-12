import java.util.Scanner;


public class Main {

	public static void main(String[] args) throws Exception{

		CashRegister A = null;
		boolean stopShopping = true; // end of shopping - flag
		Scanner input = new Scanner(System.in);

		System.out.print("Welcome to the Automated_CaShReGistEr (TM)!\n" +
				"We are always proud to serve!\n" +
				"------------------------------------------------------\n" +
				"Please choose your initialization:\n" +
				"1.) Initialize with zero.\n" +
				"2.) Initialize with a defined sum.\n" +
				"> ");

		String answer1 = input.next();

		if (answer1.matches("1")){
			A = new CashRegister();
		}
		else if (answer1.matches("2")){
			System.out.println("\nYou have chosen to initialize with a pre-defined sum.\nPlease enter the sum: \n");
			A = new CashRegister(input.nextInt());
		}
		else {
			System.out.print("\nYour choice isn't valid. Re-run the program.\n");
			System.exit(2);
		}

		System.out.print("The Automated_CaShReGistEr has been initialized to the amount of: " + A.getOverAllPurchases() + "\n");
		do {
			System.out.print("\nYour options are as follows:\n" +
					"1.) Add an item to the bill.\n" +
					"2.) Display list of all items.\n" +
					"3.) Display the total bill so far\n" +
					"4.) Pay for your groceries and close your bill.\n" +
					"5.) For managers only: View the total amount of purchases in the Automated_CaShReGistEr\n" +
					"6.) Exit.\n" +
					"> ");
			String answer2 = input.next();
			switch(answer2){
			case "1":
				System.out.print("\nInput itemname, amount and price, separated by a comma.\nFor example:Orange,3,2.30\n" + A.overallSumReturn());
				String[] tokens = input.toString().split(",\\s");
				A.itemPurchase(tokens[0], Integer.parseInt(tokens[1]), Float.valueOf(tokens[2]));
				break;
			case "2":
				System.out.println(A.arrayItems());
				break;
			case "3":
				System.out.print("\nYour bill so far is: " + A.get_bill());
				break;
			case "4":
				System.out.print("\nYour total bill is: " + A.get_bill() + "\nPlease input your payment: ");
				A.payment(input.nextFloat());
				stopShopping = false;
				break;
			case "5":
				System.out.print("\nThe total amount of purchases in the Automated_CaShReGistEr is: " + A.overallSumReturn() + "\n");
				break;
			case "6":
				A = null;
				System.out.print("Bye Bye!");
				System.exit(0);
			default:
				System.out.print("Wrong input. Please restart program!");
				System.exit(0);
				break;
			}
		} while (stopShopping);


		input.close();
	}

}
