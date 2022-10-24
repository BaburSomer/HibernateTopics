package com.bilgeadam.course04.lesson50.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
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
	@Column (length = 50, nullable = false, unique = true)
//	@UniqueConstraint(name = "unique_email")
	private String email;
}
