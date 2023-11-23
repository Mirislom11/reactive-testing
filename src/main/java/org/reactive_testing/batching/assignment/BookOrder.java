package org.reactive_testing.batching.assignment;

import com.github.javafaker.Book;
import lombok.Getter;
import lombok.ToString;
import org.reactive_testing.util.Util;

@ToString
public class BookOrder {
  private String title;
  private String author;
  private String category;
  private Double price;

  public BookOrder () {
    Book book = Util.faker().book();
    this.title = book.title();
    this.author = book.author();
    this.category = book.genre();
    this.price = Double.parseDouble(Util.faker().commerce().price().charAt(0) + "." + "01");

  }

  public String getTitle() {
    return title;
  }

  public String getAuthor() {
    return author;
  }

  public String getCategory() {
    return category;
  }

  public Double getPrice() {
    return price;
  }
}
