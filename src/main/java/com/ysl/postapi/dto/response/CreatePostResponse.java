package com.ysl.postapi.dto.response;

import com.ysl.postapi.model.Category;
import lombok.Data;

import java.util.Date;

@Data
public class CreatePostResponse {
    private Long postId;
    private String title;
    private String createdBy;
    private String text;
    private Category category;
    private Date createdAt;


}
