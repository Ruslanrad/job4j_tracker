package ru.job4j.pojo;

public class Library {
    public static void main(String[] args) {
        Book book1 = new Book();
        Book book2 = new Book();
        Book book3 = new Book();
        Book cleanCode = new Book();
        book1.setTitle("Book 1");
        book2.setTitle("Book 2");
        book3.setTitle("Book 3");
        cleanCode.setTitle("Clean code");
        book1.setPages(23);
        book2.setPages(98);
        book3.setPages(15);
        cleanCode.setPages(1528);
        Book[] books = new Book[4];
        books[0] = book1;
        books[1] = book2;
        books[2] = book3;
        books[3] = cleanCode;
        for (int i = 0; i < books.length; i++) {
            System.out.println(books[i].getTitle() + " - " + books[i].getPages() + " стр.");
        }
        books[0] = cleanCode;
        books[3] = book1;
        for (int i = 0; i < books.length; i++) {
            if (books[i].getTitle().equals("Clean code")) {
                System.out.println(books[i].getTitle() + " - " + books[i].getPages() + " стр.");
                break;
            }
        }
    }
}
