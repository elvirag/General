import java.util.ArrayList;

/**
 * {@link CashRegister}
 * This class initializes the register, adds items to bill, charges client and gives change.
 * Also, it can print the items list.
 * */


public class CashRegister {

	private float _overAllPurchases; // the amount of all purchases in register.
	private float _bill = 0; // the amount in the client's bill so far
	private ArrayList<PurchaseItem> _itemArray; // the Array of all client's items.
	private int _itemNumber = 0; // the counter for items (needed in array progression)

	public CashRegister(int initialMoney) { //money in register or zero if illegal sum
		if (initialMoney > 0)
			setOverAllPurchases(initialMoney);
		else{
			setOverAllPurchases(0); // nullify if you have an illegal sum inputed.
			System.out.println("\nThe initial sum that was inputted is illegal. The sum in the cashier is now 0 (zero).\n");
		}
		_itemArray = new ArrayList<PurchaseItem>();
	}

	public CashRegister() { //empty constructor
		this(0);
	}

	public void itemPurchase(String itemName, int amount, float price){
		_itemArray.add(new PurchaseItem(itemName, amount, price)); // adding a new item while constructing it.
		_bill += _itemArray.get(_itemNumber).getPrice(); // adding the cost of the item to the bill
		_itemNumber++; // counting item number.
	}

	public float payment(float f){
		
		if (f < _bill)
			return -1; // if payment isn't enough, returns a flag and the main loops
		float change = f - _bill;

		_overAllPurchases += _bill;
		return change;
	}

	
	/**
	 * @return a float the represents all the purchases today, not including pending bill.
	 * */
	public float overallSumReturn(){
		return _overAllPurchases;
	}

	/**
	 * Checks if there is no items in the current bill.
	 * @return an array that contains items that are in the current bill
	 *  
	 * */
	public PurchaseItem[] arrayItems(){
		if (_itemNumber == 0)
			return null;
		else {
			PurchaseItem[] shoppingList = new PurchaseItem[_itemNumber];
			return _itemArray.toArray(shoppingList);
		}
	}
	
	/**
	 * @param the number the user inputs to start the cash-register. If negative, is set to zero.
	 * */
	private void setOverAllPurchases(int overAllPurchases) {
		if (overAllPurchases < 0){
			System.out.print("\nYou can't input a negative sum to the register. The sum has been determined as 0.\n");
			_overAllPurchases = 0;
		}
		else _overAllPurchases = overAllPurchases;
	}
	
	/**
	 * @return all the purchases in the cash register today (not including current bill
	 * */
	public float getOverAllPurchases() {
		return _overAllPurchases;
	}
	/**
	 * @return the total bill of current items.
	 * */
	public float get_bill() {
		return _bill;
	}

}
