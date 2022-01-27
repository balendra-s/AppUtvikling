package no.ntnu.crudtest;

import java.util.List;

public class Book {
    private int id;
    private String title;
    private int year;
    private int pages;
    private List<Integer> authors;

    public Book(int id, String title, int year, int pages) {
        this.id = id;
        this.title = title;
        this.year = year;
        this.pages = pages;
    }



    /**public List<Integer> getAuthors() {
        return authors;
    }

    public boolean hasAuthor(int authorId){
        boolean authorFound = false;
        for(Integer id:authors){
            if(id == authorId){
                authorFound = true;
            }
        }
        return authorFound;
    }

    public void addAuthor(int authorId){
        authors.add(authorId);
    }*/

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
