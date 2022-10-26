package com.bilgeadam.course04.lesson50.model;

import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "magazines")
@Getter @Setter @NoArgsConstructor @ToString
public class Magazine {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long oid;
	@Column (length = 50, nullable = false)
	private String name;
	@Column (length = 50, nullable = false)
	private String genre;
	@Column (length = 50, nullable = false)
	private double price;
	
	@ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
	private Set<User> readers;
	
	public Magazine(String name, String genre, double price) {
		this.name = name;
		this.genre = genre;
		this.price = price;		
	}
	
	public void addMagazine(User reader) {
		if (this.readers == null) {
			this.readers = new HashSet<>();
		}
		this.readers.add(reader);
	}
}
