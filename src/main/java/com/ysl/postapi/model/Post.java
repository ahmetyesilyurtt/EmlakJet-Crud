package com.ysl.postapi.model;

import lombok.*;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Date;

@Entity
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long postId;
    @CreatedDate
    private Date createdAt;
    @UpdateTimestamp
    private LocalDateTime updatedAt;
    private String createdBy;
    @Column(nullable = false)
    private String text;
    private String updatedBy;
    @Column(nullable = false)
    private String title;
    @Enumerated(EnumType.STRING)
    private Category category;



}
