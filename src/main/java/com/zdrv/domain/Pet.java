package com.zdrv.domain;

import java.util.Date;

import org.springframework.web.multipart.MultipartFile;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Pet {

	private Integer id;
	private String image;
	private Date uptime;
	private Category category;
	private Integer userId;
	private MultipartFile upfile;
	private String uploadDirectory;
	private Integer likenum;

	private boolean isLike;

	public boolean getIsLike() {
		return this.isLike;
	}

}
