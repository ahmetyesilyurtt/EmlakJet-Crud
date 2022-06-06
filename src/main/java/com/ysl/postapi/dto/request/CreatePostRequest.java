package com.ysl.postapi.dto.request;

import com.ysl.postapi.model.Category;
import lombok.Data;

@Data
public class CreatePostRequest {
    private Long postId;
    private String title;
    private String createdBy;
    private String text;
    private Category category;
}
