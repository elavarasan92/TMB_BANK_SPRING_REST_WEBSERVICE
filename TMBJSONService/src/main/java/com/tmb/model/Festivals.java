package com.tmb.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import org.hibernate.annotations.Type;




@Entity
@Table(name="festivals",uniqueConstraints=@UniqueConstraint(columnNames={"dateOfFestival"}))
public class Festivals {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	
	private String nameOfFestival;
	@Type(type="date")
	private Date dateOfFestival;
	private String dayOfFestival;
	
	
	public String getNameOfFestival() {
		return nameOfFestival;
	}
	public Date getDateOfFestival() {
		return dateOfFestival;
	}
	public void setDateOfFestival(Date dateOfFestival) {
		this.dateOfFestival = dateOfFestival;
	}
	public String getDayOfFestival() {
		return dayOfFestival;
	}
	public void setDayOfFestival(String dayOfFestival) {
		this.dayOfFestival = dayOfFestival;
	}
	public void setNameOfFestival(String nameOfFestival) {
		this.nameOfFestival = nameOfFestival;
	}
	
	@Override
	public String toString() {
		return "Festivals [id=" + id + ", nameOfFestival=" + nameOfFestival + ", dateOfFestival=" + dateOfFestival
				+ ", dayOfFestival=" + dayOfFestival + "]";
	}
}
