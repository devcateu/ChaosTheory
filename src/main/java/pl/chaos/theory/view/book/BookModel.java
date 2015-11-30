package pl.chaos.theory.view.book;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import pl.chaos.theory.db.model.Book;
import pl.chaos.theory.db.repository.BookRepository;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import java.util.ArrayList;
import java.util.List;

@Component("model")
@Scope(value = "request")
public class BookModel {

	@Autowired
	private Book book;
	@Autowired
	private BookRepository bookRepository;

	public Book getBook() {
		return book;
	}

	public void setBook(BookView book) {
		this.book = book;
	}

	public String doCreateBook() {
		Book created = new Book();
		created.setId(this.book.getId());
		created.setTitle(this.book.getTitle());
		created.setPrice(this.book.getPrice());
		created.setnbofpage(this.book.getnbofpage());
		created.setDescription(this.book.getDescription());
		Book newBook = this.bookRepository.save(created);

		FacesContext.getCurrentInstance().addMessage("errors",
				new FacesMessage(FacesMessage.SEVERITY_INFO, "Book created",
						"The book " + created.getTitle() + " has been created with id=" + newBook.getId()));

		this.book.setTitle("");
		this.book.setPrice(null);
		this.book.setDescription("");
		this.book.setIllustrations(false);
		this.book.setnbofpage(null);

		return "index.xhtml";
	}

	public void doFindBookById() {
		Book found = bookRepository.findOne(this.book.getId());
		this.book.setId(found.getId());
		this.book.setTitle(found.getTitle());
		this.book.setPrice(found.getPrice());
		this.book.setnbofpage(found.getnbofpage());
		this.book.setDescription(found.getDescription());
		this.book.setDescription(found.getDescription());
	}

	public List<BookView> findAllBooks() {
		List<BookView> books = new ArrayList<BookView>();
		for (Book entity : this.bookRepository.findAll()) {
			BookView view = new BookView();
			view.setId(entity.getId());
			view.setTitle(entity.getTitle());
			view.setPrice(entity.getPrice());
			view.setnbofpage(entity.getnbofpage());
			view.setDescription(entity.getDescription());
			view.setDescription(entity.getDescription());
			books.add(view);
		}
		return books;
	}

}
