package ru.oz.cxf;

import javax.jws.WebMethod;
import javax.jws.WebService;

@WebService
public interface BookService {
    @WebMethod
    public  String insertBook(Book book);
    @WebMethod
    public  Book getBook(String title);
    @WebMethod
    public Book getException(String title);
}
