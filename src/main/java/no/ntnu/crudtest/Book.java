package no.ntnu.crudtest;

public class Book {
    private int id;
    private String title;
    private int year;
    private int pages;

    public Book(int id, String title, int year, int pages) {
        this.id = id;
        this.title = title;
        this.year = year;
        this.pages = pages;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getPages() {
        return pages;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }
}
