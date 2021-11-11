package com.iu.b5.member;

import java.sql.Date;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Range;
import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

@Data
public class MemberVO {
	@NotBlank
	private String id;
	@Size(max=12,min=6)
	private String pw;
	private String pwCheck;
	@NotBlank
	private String name;
	@Email
	private String email;
	@Range(min=0,max=150)
	private Integer age;
	@Past
	@DateTimeFormat(pattern = "yyyyMMdd")
	private Date birth;
	private String role;
	private MemberFilesVO memberFilesVO;

}
