package com.Hospital.Management.System.entity;
 
 
import java.util.Set;

import com.Hospital.Management.System.doclogin.entity.Medicine;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
@Entity
@Table(name="patients")
public class Patient {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	
	private long id;
	@Column(name="first_name")
	private String name;
	@Column(name="age")
	private int age;
	@Column(name="blood_group")
	private String blood;
	private String pescription;
	private String dose;
	private String fees;
	private String emergency;
	 @ManyToMany
	    @JoinTable(
	        name = "patient_medicine",
	        joinColumns = @JoinColumn(name = "patient_id"),
	        inverseJoinColumns = @JoinColumn(name = "medicine_id")
	    )
	    private Set<Medicine> medicines;
	 
	 public Patient() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Patient(long id, String name, int age, String blood, String pescription, String dose, String fees,
			String emergency) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
		this.blood = blood;
		this.pescription = pescription;
		this.dose = dose;
		this.fees = fees;
		this.emergency = emergency;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getBlood() {
		return blood;
	}
	public void setBlood(String blood) {
		this.blood = blood;
	}
	public String getPescription() {
		return pescription;
	}
	public void setPescription(String pescription) {
		this.pescription = pescription;
	}
	public String getDose() {
		return dose;
	}
	public void setDose(String dose) {
		this.dose = dose;
	}
	public String getFees() {
		return fees;
	}
	public void setFees(String fees) {
		this.fees = fees;
	}
	public String getEmergency() {
		return emergency;
	}
	public void setEmergency(String emergency) {
		this.emergency = emergency;
	}
	
	
 
}
 