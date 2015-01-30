import java.util.ArrayList;

public class MediaStore {
	public static void main(String[] args) {
		ArrayList<Book> books = new ArrayList<Book>();
		ArrayList<Movie> movies = new ArrayList<Movie>();
		
		Book book1 = new Book("Hitchhikers Guide To The Galaxy", 14);
		books.add(book1);
		
		Movie movie1 = new Movie("Fight Club", 15);
		movies.add(movie1);
		
		Book book2 = new Book("Heart of Darkness", 10);
		books.add(book2);
		
		Movie movie2 = new Movie("A Clockwork Orange", 12);
		movies.add(movie2);
		
		for (int i = 0; i < books.size(); i++) {
			System.out.println(books.get(i).toString());
		}
		
		for (int i = 0; i < movies.size(); i++) {
			System.out.println(movies.get(i).toString());
		}
	}
	
}
