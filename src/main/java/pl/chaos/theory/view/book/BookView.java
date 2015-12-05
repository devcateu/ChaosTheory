package pl.chaos.theory.view.book;

import org.springframework.stereotype.Component;
import pl.chaos.theory.db.model.Book;
import pl.chaos.theory.util.Request;

@Component("book")
@Request
public class BookView extends Book {

	public BookView() { }
}
