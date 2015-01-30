public abstract class Item {
	private int stock = 0;

	/**
	 * Liefert den Lagerstand des Artikels zurück
	 * @return stock
	 */
	public int getStock() {
		return this.stock;
	}

	public void sell() {
		this.stock--;
	}

	public void restock(int amount) {
		this.stock += amount;
	}

	/**
	 * Liefert den Namen des Artikels zurück
	 * @return name
	 */
	public abstract String getName();
	
	/**
	 * Liefert den Preis des Artikels zurück
	 * @return price
	 */
	public abstract int getPrice();
}
