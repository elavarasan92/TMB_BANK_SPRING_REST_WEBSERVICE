package com.tmb.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.hibernate.annotations.Type;

import com.tmb.enumeration.Education;
import com.tmb.enumeration.Gender;
import com.tmb.enumeration.GrossAnnualIncome;
import com.tmb.enumeration.MaritalStatus;
import com.tmb.enumeration.Occupation;
import com.tmb.enumeration.Salutation;
import com.tmb.enumeration.SourceOfFunds;

@Entity
@Table(name="user",uniqueConstraints=@UniqueConstraint(columnNames={"userid","mobile","pAN"}))
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class User {
	
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id;
	
	@Enumerated(EnumType.STRING)
	private Salutation salutation;
	@Enumerated(EnumType.STRING)
	private Gender gender;
	private String userid;
	private String password;
	
	private String firstName;
	private String lastName;
	
	@Enumerated(EnumType.STRING)
	private MaritalStatus maritalStatus;
	
	@Type(type="date")
	private Date dateOfBirth;
	private String motherName;
	private String fatherName;
	private String eMail;
	private String mobile;
	private String address;
	private String pAN;
	
	@Enumerated(EnumType.STRING)
	private Occupation occupation;
	@Enumerated(EnumType.STRING)
	private Education education;
	@Enumerated(EnumType.STRING)
	private GrossAnnualIncome grossAnnualIncome;
	@Enumerated(EnumType.STRING)
	private SourceOfFunds sourceOfFunds;
	
	
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	} 
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public Date getDateOfBirth() {
		return dateOfBirth;
	}
	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
	public String getMotherName() {
		return motherName;
	}
	public void setMotherName(String motherName) {
		this.motherName = motherName;
	}
	public String getFatherName() {
		return fatherName;
	}
	public void setFatherName(String fatherName) {
		this.fatherName = fatherName;
	}
	public String geteMail() {
		return eMail;
	}
	public void seteMail(String eMail) {
		this.eMail = eMail;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String getpAN() {
		return pAN;
	}
	public void setpAN(String pAN) {
		this.pAN = pAN;
	}
	
	
	public Salutation getSalutation() {
		return salutation;
	}
	public void setSalutation(Salutation saluation) {
		this.salutation = saluation;
	}
	public Gender getGender() {
		return gender;
	}
	public void setGender(Gender gender) {
		this.gender = gender;
	}
	public MaritalStatus getMaritalStatus() {
		return maritalStatus;
	}
	public void setMaritalStatus(MaritalStatus maritalStatus) {
		this.maritalStatus = maritalStatus;
	}
	public Occupation getOccupation() {
		return occupation;
	}
	public void setOccupation(Occupation occupation) {
		this.occupation = occupation;
	}
	public Education getEducation() {
		return education;
	}
	public void setEducation(Education education) {
		this.education = education;
	}
	public GrossAnnualIncome getGrossAnnualIncome() {
		return grossAnnualIncome;
	}
	public void setGrossAnnualIncome(GrossAnnualIncome grossAnnualIncome) {
		this.grossAnnualIncome = grossAnnualIncome;
	}
	public SourceOfFunds getSourceOfFunds() {
		return sourceOfFunds;
	}
	public void setSourceOfFunds(SourceOfFunds sourceOfFunds) {
		this.sourceOfFunds = sourceOfFunds;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	
	@Override
	public String toString() {
		return "User [id=" + id + ", salutation=" + salutation + ", gender="
				+ gender + ", userid=" + userid + ", password=" + password
				+ ", firstName=" + firstName + ", lastName=" + lastName
				+ ", maritalStatus=" + maritalStatus + ", dateOfBirth="
				+ dateOfBirth + ", motherName=" + motherName + ", fatherName="
				+ fatherName + ", eMail=" + eMail + ", mobile=" + mobile
				+ ", address=" + address + ", pAN=" + pAN + ", occupation="
				+ occupation + ", education=" + education
				+ ", grossAnnualIncome=" + grossAnnualIncome
				+ ", sourceOfFunds=" + sourceOfFunds + "]";
	}
	
}
