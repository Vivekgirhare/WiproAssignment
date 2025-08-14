package com.wipro.model;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name="List")
public class BookList {
    private List<Book> items;

    public BookList() {}
    public BookList(List<Book> items) {
        this.items = items;
    }

    @XmlElement(name = "item")
    public List<Book> getItems() { return items; }
    public void setItems(List<Book> items) { this.items = items; }
}
