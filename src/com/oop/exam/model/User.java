package com.oop.exam.model;

public class User {
	private String name;
	private String correo;

	public User(String name, String correo){
		this.name=name;
		this.correo=correo;
	}

	public String getUserName() {
		return name;
	}

	public String getUserCorreo() {
		return correo;
	}
}
