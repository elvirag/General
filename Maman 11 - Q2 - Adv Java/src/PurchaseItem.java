
public class PurchaseItem {
	
	private String _itemName; // the name of the item
	private int _amount; //the amount of items
	private float _price; //the price of the item (amount times single item price)

	public PurchaseItem(String itemName, int amount, float price) { //uses setters to construct & initialize  object

		setItemName(itemName);
		setAmount(amount);
		setPrice(price);
	}


	/**
	 * @return the price
	 */
	public float getPrice() {
		return _price;
	}
	/**
	 * @param itemName the itemName to set
	 */
	private void setItemName(String itemName) {
		_itemName = itemName;
	}
	/**
	 * @param amount the amount to set
	 */
	private void setAmount(int amount) {
		if (amount > 0)
			_amount = amount;
		else{
			_amount = 1;
			System.out.println("The amount of items is illegal.\nThe amount has been set to 1.\n");
		}
	}
	/**
	 * @param price the price to set
	 */
	private void setPrice(float price) {
		if (price > 0)
			_price = price*_amount;
		else{
			_price = 0;
			System.out.println("The price of items is illegal.\nThe price has been set to 0.\n");
		}
	}
	/**
	 * 
	 * @return returns toString() of the purchased item.
	 * */
	public String toString(){
		return  "Item: " + _itemName + "   #: " + _amount + "    total price: " + _price; 
	}
}
