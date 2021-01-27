package com.zdrv.domain;

import java.util.List;

import javax.validation.constraints.NotBlank;

import com.zdrv.validation.LoginGroup;
import com.zdrv.validation.RegisterGroup;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {

	private Integer id;

	@NotBlank(groups = {RegisterGroup.class, LoginGroup.class})
	private String loginId;

	@NotBlank(groups = {RegisterGroup.class, LoginGroup.class})
	private String loginPass;

	@NotBlank(groups = {RegisterGroup.class})
	private String name;

	private List<Pet> pet;

}
