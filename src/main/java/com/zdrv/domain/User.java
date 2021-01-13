package com.zdrv.domain;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {

	private Integer id;

	private String loginId;

	private String loginPass;

	private String name;

	private List<Pet> pet;

}
