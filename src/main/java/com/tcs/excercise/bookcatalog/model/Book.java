package com.tcs.excercise.bookcatalog.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
public class Book {

@Id
@GeneratedValue(strategy = GenerationType.AUTO)
private Integer id;
@Column(unique = true)
private String bookTitle;
private String authorName;
private long ISBN;
private Date publicationDate;

public Integer getId() {
	return id;
}
public void setId(Integer id) {
	this.id = id;
}
public String getBookTitle() {
	return bookTitle;
}
public void setBookTitle(String bookTitle) {
	this.bookTitle = bookTitle;
}
public String getAuthorName() {
	return authorName;
}
public void setAuthorName(String authorName) {
	this.authorName = authorName;
}
public long getISBN() {
	return ISBN;
}
public void setISBN(long iSBN) {
	ISBN = iSBN;
}
public Date getPublicationDate() {
	return publicationDate;
}
public void setPublicationDate(Date publicationDate) {
	this.publicationDate = publicationDate;
}

}


