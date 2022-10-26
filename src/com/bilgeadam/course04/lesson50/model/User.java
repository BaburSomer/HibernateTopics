package com.bilgeadam.course04.lesson50.model;

import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name="users")
@Getter @Setter @ToString
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long oid;
	@Column (name = "first_name", length = 50, nullable = false)
	private String firstName;
	@Column (name = "last_name", length = 50, nullable = false)
	private String lastName;
	
//	@Column (length = 50, nullable = false, unique = true)   DO NOT LEAVE SUCH A THING !!!!!!
	
	@OneToOne
	@JoinColumn(name="contact_oid")
	private ContactInformation contact;

	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "user_oid")
	private Set<Billing> billings;
	
	@Transient
	private String fullName;
	
	public String getFullName() {
		return firstName + " " + lastName;
	}
	
	public void addBilling(Billing billing) {
		if (this.billings == null) {
			this.billings = new HashSet<>();
		}
		this.billings.add(billing);
	}
	
	@ManyToMany(mappedBy = "readers")
	private Set<Magazine> magazines;
	
	public void addMagazine(Magazine magazine) {
		if (this.magazines == null) {
			this.magazines = new HashSet<>();
		}
		this.magazines.add(magazine);
	}

}
