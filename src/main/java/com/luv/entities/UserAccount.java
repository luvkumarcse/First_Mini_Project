package com.luv.entities;

import java.sql.Timestamp;
import java.time.LocalDate;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Data;


@Entity
public @Data class UserAccount{
	@Id
	@GeneratedValue
	private Integer userId;
	
	private String fullName;
	
	private String email;
	
	private String phno;
	
	private String gender;
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private LocalDate dob;
	
	private Integer SSN;
	
	private String activeSw;
	@CreationTimestamp
	@Column(updatable=false)
	private Timestamp createdData;
	@UpdateTimestamp
	@Column(insertable=false)
	private Timestamp updatedDate;
	

}
