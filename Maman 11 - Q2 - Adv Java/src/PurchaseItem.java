
public class PurchaseItem {
	
	private String _itemName;
	private int _amount;
	private float _price;

	public PurchaseItem(String itemName, int amount, float price) { //uses setters to construct & initialize  object

		setItemName(itemName);
		setAmount(amount);
		setPrice(price);
	}

	/**
	 * @return the itemName
	 */
	public String getItemName() {
		return _itemName;
	}
	/**
	 * @return the amount
	 */
	public int getAmount() {
		return _amount;
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
	public void setItemName(String itemName) {
		_itemName = itemName;
	}
	/**
	 * @param amount the amount to set
	 */
	public void setAmount(int amount) {
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
	public void setPrice(float price) {
		if (price > 0)
			_price = price*getAmount();
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
