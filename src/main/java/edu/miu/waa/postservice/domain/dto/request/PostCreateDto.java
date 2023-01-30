package edu.miu.waa.postservice.domain.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PostCreateDto {
    private long id;
    private String title;
    private String content;
    private String author;
}
