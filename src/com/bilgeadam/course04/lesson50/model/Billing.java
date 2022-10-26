package com.bilgeadam.course04.lesson50.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
@Entity
@Table(name = "billing_informations")
public class Billing {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long oid;
	@Column (name = "account_no", nullable = false, unique = true)
	private long accountNo;
	@Column (name = "account_type", nullable = false)
	private String accountType;
	
	public Billing(long accountNo, String accountType) {
		this.accountNo = accountNo;
		this.accountType = accountType;
	}
}
