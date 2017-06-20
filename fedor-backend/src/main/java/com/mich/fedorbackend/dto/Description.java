package com.mich.fedorbackend.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Description {

@Id
@GeneratedValue(strategy=GenerationType.IDENTITY)
private int id;
@Column(name="description_id")
private int descriptionId;

public int getDescriptionId() {
	return descriptionId;
}

public void setDescriptionId(int descriptionId) {
	this.descriptionId = descriptionId;
}

public int getId() {
	return id;
}

public void setId(int id) {
	this.id = id;
}

@Override
public String toString() {
	return "Description [id=" + id + ", descriptionId=" + descriptionId + "]";
}





}
