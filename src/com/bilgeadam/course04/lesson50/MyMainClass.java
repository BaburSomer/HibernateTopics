package com.bilgeadam.course04.lesson50;

import java.util.ArrayList;

import com.bilgeadam.course04.lesson50.controller.ContactInformationController;
import com.bilgeadam.course04.lesson50.controller.UserController;
import com.bilgeadam.course04.lesson50.model.Billing;
import com.bilgeadam.course04.lesson50.model.ContactInformation;
import com.bilgeadam.course04.lesson50.model.Magazine;
import com.bilgeadam.course04.lesson50.model.User;
import com.bilgeadam.course04.lesson50.util.CommonData;

public class MyMainClass {
	
	public static void main(String... args) {
		if (args.length != 1) {
			System.err.println("Wrong number of arguments. Expected <<<1>>> actual <<<" + args.length + ">>>");
			System.exit(100);
		}
		
		CommonData.getInstance().setPropertiesFile(args[0]);

		CommonData.getInstance().info("Uygulama başladı");
		
		UserController userController = new UserController();
		ContactInformationController contactsController = new ContactInformationController();
		
		User user1 = new User();
		user1.setFirstName("Babür");
		user1.setLastName("Somer");
		
		ContactInformation c1 = new ContactInformation();
		c1.setEmail("aaa@bbb.com");
		c1.setPhoneNumber("987654");
		c1.setAddress("Beyoğlu Istanbul");
		contactsController.insert(c1);
		user1.setContact(c1);
		user1.addBilling(new Billing(123_456L, "Elektrik"));
		user1.addBilling(new Billing(43_242_456L, "Su"));
		user1.addBilling(new Billing(123_888L, "Alışveriş"));
		user1.addBilling(new Billing(123_3523L, "Bakkal"));
		userController.insert(user1);
		
		User user2 = new User();
		user2.setFirstName("Ali İhsan");
		user2.setLastName("Vercan");
		Magazine magazine1 = new Magazine("Gırgır", "Haftalık Mizah Dergisi", 10.5);
		Magazine magazine2 = new Magazine("Fırt", "Haftalık Mizah Dergisi", 8.5);
		user2.addMagazine(magazine1);
		user2.addMagazine(magazine2);
		
		
		c1 = new ContactInformation();
		c1.setEmail("fgfgfgfdgdf@bbb.com");
		c1.setPhoneNumber("45434t435435");
		c1.setAddress("Kadıköy Istanbul");
		contactsController.insert(c1);
		
		user2.setContact(c1);
		userController.insert(user2);
		
		User user = new User();
		user.setFirstName("Burak");
		user.setLastName("Tosun");
		
		c1 = new ContactInformation();
		c1.setEmail("dsfdsg@bbb.com");
		c1.setPhoneNumber("463634");
		c1.setAddress("Kağıthane, Istanbul, Türkiye");
		user1.addMagazine(magazine1);
		user1.addMagazine(magazine2);
		contactsController.insert(c1);

		user1.setContact(c1);
		userController.insert(user);
		
		user = new User();
		user.setFirstName("Ezgi");
		user.setLastName("Akkaş");
		user.addBilling(new Billing(123_888L, "Alışveriş"));
		user.addBilling(new Billing(123_881L, "Alışveriş"));
		user.addBilling(new Billing(123_882L, "Alışveriş"));
		user.addBilling(new Billing(123_883L, "Alışveriş"));
		user.addBilling(new Billing(123_884L, "Alışveriş"));
		user.addBilling(new Billing(123_885L, "Alışveriş"));
		user.addMagazine(magazine1);
		userController.insert(user);

		user = new User();
		user.setFirstName("Emre");
		user.setLastName("Ilgar");
		userController.insert(user);
		
//		userController.delete(user1);
		
		userController.update(user2);
		
		ArrayList<User> users = userController.retrieve();
		for (User user3 : users) {
			System.out.println(user3);
		}
		
		User user4 = userController.find(3);
		System.out.println(user4);
//		
//		System.out.println(userController.findByFirstAndLastName("Emge", "Ilgar"));
		CommonData.getInstance().info("Uygulama bitti");
	}

}
