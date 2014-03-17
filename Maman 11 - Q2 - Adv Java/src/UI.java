import java.util.Scanner;


public class UI {
	/**
	 * The class that performs all input and output from user.
	 * */

	CashRegister A = null;
	boolean stopShopping = true; // end of shopping - flag
	boolean paySufficient = true; // payment was sufficient, can close bill.
	boolean rightFormat = true; // item was inputed in the right form. Can process it.
	Scanner input = new Scanner(System.in); // my input object. Is reused and closed at the end of the object method.

	
	/**
	 * Starts all TODO: Try to make OOP
	 */
	public void start(){

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
			initialization();
		}
		else if (answer1.matches("2")){
			System.out.println("\nYou have chosen to initialize with a pre-defined sum.\nPlease enter the sum: \n");
			A = new CashRegister(input.nextInt());
			initialization();
		}
		else {
			System.out.print("\nYour choice isn't valid. Re-run the program.\n");
			System.exit(2);
		}
	}
	private void initialization(){

		System.out.print("The Automated_CaShReGistEr has been initialized to the amount of: " + A.getOverAllPurchases() + "\n");
		mainUI();

	}

	private void mainUI(){
		do {
			System.out.print("\n\nYour options are as follows:\n" +
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
				do
				{
					input.reset();
					System.out.print("\nInput item name, amount and price, separated by commas.\nFor example:Orange,3,2.30\n"); // if not inputted this way, it won't work. Assumes correct input!
					String[] tokens = input.next().split(",");
					//System.out.print("\nNumber of tokens:" + tokens.length); //TODO
					if (tokens.length != 3)
						System.out.print("\nWrong input. Try again.\n");
					else
					{
						rightFormat = false;
						A.itemPurchase(tokens[0], Integer.parseInt(tokens[1]), Float.valueOf(tokens[2])); // assuming the input was correct, in the form expected (string,int,float)
					}
				} while (rightFormat);
				break;
			case "2": //printing out the array
				if (A.arrayItems() == null)
					System.out.print("\nYou haven't added any item to the bill yet.\nPlease continue.\n");
				else
				{
					for (int i = 0 ; i < A.arrayItems().length ; i++){
						System.out.println(A.arrayItems()[i]);
					}
				}
				break;
			case "3":
				System.out.print("\nYour bill so far is: " + A.get_bill());
				break;
			case "4":
				System.out.print("\nYour total bill is: " + A.get_bill() + "\nPlease input your payment: ");

				do {
					float pay = input.nextFloat();
					if (A.payment(pay) == -1)
						System.out.print("Your payment is not sufficient.\n Please input again.\n"); // loops if doesn't get enough money to cover the bill.
					else {
						paySufficient = false;
						System.out.print("\nYour change is: " + A.payment(pay) + 
								"\nThank you for shopping here! Have a NicE dAy!\nAutomated_CaShReGistEr(TM)");
						break;	
					}
				} while(paySufficient);

				break;
			case "5":
				System.out.print("\nThe total amount of purchases in the Automated_CaShReGistEr is: " + A.overallSumReturn() + "\n");
				break;
			case "6":
				A = null;
				System.out.print("Bye Bye!");
				stopShopping = false;
				//System.exit(0);
				break;
			default:
				System.out.print("Wrong input. Please restart program!");
				System.exit(0);
				break;
			}
		} while (stopShopping);


		input.close();
	}
}