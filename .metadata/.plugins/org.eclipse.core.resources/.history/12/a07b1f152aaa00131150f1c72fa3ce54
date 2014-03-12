import java.util.ArrayList;


public class CashRegister {

	private int _initialMoney;
	private int _totalPurchases;
	private String _clientName;
	private String customerString;
	private int _bill;
	private int _overAllPurchases;
	private ArrayList<PurchaseItem> _itemArray = new ArrayList();
	private int _itemNumber;

	
	public CashRegister() { //empty constructor
		_initialMoney = 0;
	}
	
	public CashRegister(int initialMoney) { //money in register or zero if illegal sum
		if (initialMoney > 0)
			_initialMoney = initialMoney;
		else{
			_initialMoney = 0; // nullify if you have an illegal sum inputed.
			System.out.println("\nThe initial sum that was inputted is illegal. The sum in the cashier is now 0 (zero).\n");
		}
	}
	
	private int itemPurchase(PurchaseItem itemName, int amount, int price){
		int itemPrice = amount * price;  //Calculating the price of the total amount of items of one type
		_itemArray.add(itemName);
		_itemNumber++;
		return itemPrice;
	}
	
	private int payment(int clientPayment){
		
		int change= clientPayment - _bill;
		
		_overAllPurchases += _bill;
		return change;
	}
	
	private ArrayList<PurchaseItem> purchaseditems(){
		return _itemArray;
	}
	
	private int customerBillReturn(){
		return _bill;
	}
	
	private int overallSumReturn(){
		return _overAllPurchases;
	}
	
	
}
