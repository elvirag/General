/**
 * {@link CashRegister}
 * This class initializes the register, adds items to bill, charges client and gives change.
 * Also, it can print the items list.
 * */


public class CashRegister {

	private float _overAllPurchases; // the amount of all purchases in register.
	private float _bill = 0; // the amount in the client's bill so far
	private PurchaseItem[] _itemArray; // the Array of all client's items.
	private int _itemNumber = 0; // the counter for items (needed in array progression)

	
	public CashRegister() { //empty constructor
		setOverAllPurchases(0);
	}
	
	public CashRegister(int initialMoney) { //money in register or zero if illegal sum
		if (initialMoney > 0)
			setOverAllPurchases(initialMoney);
		else{
			setOverAllPurchases(0); // nullify if you have an illegal sum inputed.
			System.out.println("\nThe initial sum that was inputted is illegal. The sum in the cashier is now 0 (zero).\n");
		}
	}
	
	public void itemPurchase(String itemName, int amount, float price){
		_itemArray[_itemNumber] = new PurchaseItem(itemName, amount, price);
		_bill += _itemArray[_itemNumber].getPrice();
		_itemNumber++;
	}
	
	public float payment(float f){
		
		float change = f - _bill;
		
		_overAllPurchases += _bill;
		return change;
	}
	
	public float overallSumReturn(){
		return _overAllPurchases;
	}
	
	public PurchaseItem[] arrayItems(){
		return _itemArray;
	}

	public void setOverAllPurchases(int overAllPurchases) {
		_overAllPurchases = overAllPurchases;
	}

	public float getOverAllPurchases() {
		return _overAllPurchases;
	}

	public float get_bill() {
		return _bill;
	}
	
	
}
