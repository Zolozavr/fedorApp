package com.mich.fedorbackend.dto;

import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Min;

import org.hibernate.validator.constraints.NotBlank;
import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Books {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@NotBlank(message= "Book Title is empty")
	private String bookName;
	
	private String author;
	private String yearOfPrint;
	@Column(name = "unit_price")
	@Min(value=1, message="Price must be greater then 1")
	private double unitPrice;

	@Column(name = "img_url")
	private String imgUrl;
	@Column(name = "category_id")
	private int categoryId;
	@Column(name = "users_id")
	private int usersId;
	private int views;
	@Column(name = "is_active")
	@JsonIgnore
	private boolean active;
	
	
	//Field for file multipart
	private MultipartFile imgfile;
	

	public Books() {
		this.imgUrl = "BK" + UUID.randomUUID().toString().substring(26).toUpperCase();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getBookName() {
		return bookName;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public void setBookName(String bookName) {
		this.bookName = bookName;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public double getUnitPrice() {
		return unitPrice;
	}

	public void setUnitPrice(double unitPrice) {
		this.unitPrice = unitPrice;
	}

	public String getImgUrl() {
		return imgUrl;
	}

	public void setImgUrl(String imgUrl) {
		this.imgUrl = imgUrl;
	}

	public int getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}

	public int getUsersId() {
		return usersId;
	}

	public void setUsersId(int usersId) {
		this.usersId = usersId;
	}

	public int getViews() {
		return views;
	}

	public void setViews(int views) {
		this.views = views;
	}

	public String getYearOfPrint() {
		return yearOfPrint;
	}

	public void setYearOfPrint(String yearOfPrint) {
		this.yearOfPrint = yearOfPrint;
	}
	//For logger
	@Override
	public String toString() {
		return "Books [id=" + id + ", bookName=" + bookName + ", author=" + author + ", yearOfPrint=" + yearOfPrint
				+ ", unitPrice=" + unitPrice + ", imgUrl=" + imgUrl + ", categoryId=" + categoryId + ", usersId="
				+ usersId + ", views=" + views + ", active=" + active + "]";
	}
	
	
	

}
