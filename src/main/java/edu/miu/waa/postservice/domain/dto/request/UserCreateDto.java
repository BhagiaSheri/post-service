package edu.miu.waa.postservice.domain.dto.request;

import edu.miu.waa.postservice.domain.entity.Role;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserCreateDto {
    private long id;
    private String name;
    private String username;
    private String password;
    private List<Role> roles;
}
