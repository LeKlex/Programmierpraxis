import java.util.ArrayList;

public class MediaStore {
	public static void main(String[] args) {
		ArrayList<Item> items = new ArrayList<Item>();
		Book book1 = new Book("Hitchhikers Guide To The Galaxy", 900);
		items.add(book1);
		
		Movie movie1 = new Movie("Fight Club", 120);
		items.add(movie1);
		
		Book book2 = new Book("Heart of Darkness", 600);
		items.add(book2);
		
		Movie movie2 = new Movie("A Clockwork Orange", 140);
		items.add(movie2);

		Ebook book3 = new Ebook("XML und Java", 1000);
		items.add(book3);
		
		Hardcover book4 = new Hardcover("Lord of the Rings", 1800);
		items.add(book4);
		
		for (int i = 0; i < items.size(); i++) {
			System.out.println(items.get(i).toString());
		}

		/**
		Movie movie3 = new Movie("Tron", 90);
		items.add(movie3);

		System.out.println(movie3.getName() + " stock: " + movie3.getStock());
		movie3.restock(50);
		System.out.println(movie3.getName() + " stock: " + movie3.getStock());
		movie3.sell();
		System.out.println(movie3.getName() + " stock: " + movie3.getStock());
		*/
	}
	
}
