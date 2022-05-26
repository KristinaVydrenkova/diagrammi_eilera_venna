package ru.itis.semesterwork2.utils.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import ru.itis.semesterwork2.dto.request.SignUpForm;
import ru.itis.semesterwork2.dto.response.EditProfileFormResponse;
import ru.itis.semesterwork2.dto.response.UserResponse;
import ru.itis.semesterwork2.models.User;

@Mapper(componentModel = "spring")
public interface UserMapper {
    @Mapping(target = "password", ignore = true)
    User toEntity(SignUpForm form);

    EditProfileFormResponse toEditProfileFormResponse(User user);

    UserResponse toResponse(User user);
}
