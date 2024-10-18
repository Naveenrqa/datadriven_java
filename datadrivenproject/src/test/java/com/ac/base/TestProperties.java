package com.ac.base;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class TestProperties {

	public static void main(String[] args) throws IOException {

		Properties Config = new Properties();

		Properties OR = new Properties();

		FileInputStream fis = new FileInputStream("C:\\Users\\user\\eclipse-workspace\\datadrivenproject\\src\\test\\resources\\properties\\Config.properties");

		Config.load(fis);

		System.out.println(Config.getProperty("browser"));

       FileInputStream fis1 = new FileInputStream("C:\\Users\\user\\eclipse-workspace\\datadrivenproject\\src\\test\\resources\\properties\\OR.properties");

       OR.load(fis1);

		System.out.println(OR.getProperty("Login"));

	}

}
