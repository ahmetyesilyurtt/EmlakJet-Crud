package com.ysl.postapi.dto.request;

import com.ysl.postapi.model.Category;
import lombok.Data;

@Data
public class UpdatePostRequest {

    private String updatedBy;
    private String title;
    private String text;
    private Category category;

}
