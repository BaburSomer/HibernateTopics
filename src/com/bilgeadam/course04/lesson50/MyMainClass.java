package com.bilgeadam.course04.lesson50;

import com.bilgeadam.course04.lesson50.controller.UserController;
import com.bilgeadam.course04.lesson50.model.User;

public class MyMainClass {
	
	public static void main(String... args) {
//		if (args.length != 1) {
//			System.err.println("Wrong number of arguments. Expected <<<1>>> actual <<<" + args.length + ">>>");
//			System.exit(100);
//		}

		UserController userController = new UserController();
		User user = new User();
		user.setFirstName("Babür");
		user.setLastName("Somer");
		user.setEmail("babur@somer.com");
		userController.insert(user);
	}

}
