package com.iu.b5.board;

import java.sql.Date;
import java.util.List;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import lombok.Data;

@Data
public class BoardVO {
	
	private Integer num;
	@NotBlank
	private String title;
	private String contents;
	@Size(max=6,min=3)
	private String writer;
	private Integer hit;
	private Date regDate;
	
	private List<BoardFileVO> fileList;
	

}
