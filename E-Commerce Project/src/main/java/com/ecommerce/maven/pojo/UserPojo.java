package com.ecommerce.maven.pojo;

import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString
@EqualsAndHashCode

public class UserPojo {
	
	private int userID;
	
	@NotNull
	private String username;
	@NotNull
	private String password;
	@NotNull
	private String firstname;
	@NotNull
	private String lastname;
	@NotNull
	private String email;
	@NotNull
	private String usertype;

	
}
