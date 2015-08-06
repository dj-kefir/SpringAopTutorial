package ru.oz.cxf;

import javax.jws.WebService;

@WebService(endpointInterface = "ru.oz.cxf.BookService",
        serviceName="bookService")
public class BookServiceImpl implements BookService {
    public String insertBook(Book book) {
        //HashDB.insertBook(book);
        return "Book with name : " + book.getBookName() + " is now available on the shelf";  //To change body of implemented methods use File | Settings | File Templates.
    }

    public Book getBook(String title) {

        return new Book();
        //return HashDB.getBook(title);  //To change body of implemented methods use File | Settings | File Templates.
    }

    public Book getException(String title) {
        throw new NullPointerException("Нульпоинтер эксептион");
    }
}