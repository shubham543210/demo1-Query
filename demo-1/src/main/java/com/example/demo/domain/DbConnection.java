package com.example.demo.domain;

import org.springframework.beans.factory.annotation.Value;

public class DbConnection {
	
	@Value("com.mysql.jdbc.Driver")
	private String driverClass;
	@Value("jdbc:mysql://localhost:3307/details1?useSSL=false")
	private String dbURL;
	@Value("root")
	private String userName;
	@Value("root")
	private char[] password;

	public DbConnection() {
	}

	public void printDBConfigs() {
		System.out.println("Driver Class = " + driverClass);
		System.out.println("DB URL = " + dbURL);
		System.out.println("User Name = " + userName);

		// Never do below in production environment :D
		System.out.println("Password = " + String.valueOf(password));
	}

}
