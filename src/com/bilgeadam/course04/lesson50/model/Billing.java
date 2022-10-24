package com.bilgeadam.course04.lesson50.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Billing {
	private long accountNo;
	private String accountType;
	private User accountHolder;
}
