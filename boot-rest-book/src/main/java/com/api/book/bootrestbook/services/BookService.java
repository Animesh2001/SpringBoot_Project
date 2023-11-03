package com.api.book.bootrestbook.services;
import com.api.book.bootrestbook.entities.Book;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
public class BookService {

    private static List<Book> list = new ArrayList<>();

    static{
        list.add(new Book(12,"Gangs Of Four","Pankaj Sharma"));
        list.add(new Book(13,"Gangs Of Three","XYZ"));
        list.add(new Book(14,"Gangs Of Two","Animesh Jaiswal"));
    }


    public List<Book> getAllBooks(){
        return list;
    }

    public Book getBookByID(int id){
        Book book = null;
        for(Book b : list){
            if(b.getId()==id){
                book = b;
                break;
            }
        }
        return book;
    }

    //adding the book
    public Book addBook(Book b){
        list.add(b);
        return b;
    }
    public Book deleteBook(int bookId) {
        Book book = null;
        for(int i=0; i< list.size(); i++){
            if(list.get(i).getId()==bookId) {
                book = list.get(i);
                list.remove(i);
                break;
            }
        }
        return book;
    }
    public void updateBook(Book book, int bookId) {
        for(Book b : list){
            if(b.getId()==bookId){
                b.setAuthor(book.getAuthor());
                b.setTitle(book.getTitle());
                break;
            }
        }

    }
}
