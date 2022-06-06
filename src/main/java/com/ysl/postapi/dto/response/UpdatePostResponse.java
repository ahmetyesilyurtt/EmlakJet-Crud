package com.ysl.postapi.dto.response;

import com.ysl.postapi.model.Category;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class UpdatePostResponse {

    private Long postId;
    private LocalDateTime updatedAt;
    private String updatedBy;
    private String title;
    private String text;
    private Category category;


}
