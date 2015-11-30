package pl.chaos.theory.view.book;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import pl.chaos.theory.db.model.Book;

@Component("book")
@Scope(value = "request")
public class BookView extends Book {

	public BookView() { }
}
