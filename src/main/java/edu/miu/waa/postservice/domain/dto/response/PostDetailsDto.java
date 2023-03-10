package edu.miu.waa.postservice.domain.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PostDetailsDto {
    long id;
    String title;
    String content;
    String author;
}
