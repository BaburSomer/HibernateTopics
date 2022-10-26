package com.bilgeadam.course04.lesson50.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name="contacts")
@Getter @Setter @ToString(exclude = {"user"})
public class ContactInformation {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "oid")
	private long oid;
	
	@Column (name = "email", length = 30, nullable = true)
	private String email;
	
	@Column (name = "phone_number", length = 20, nullable = true)
	private String phoneNumber;
	
	@Column (name = "address", length = 100, nullable = true)
	private String address;
	
	@OneToOne(mappedBy = "contact")
	private User user;
}
