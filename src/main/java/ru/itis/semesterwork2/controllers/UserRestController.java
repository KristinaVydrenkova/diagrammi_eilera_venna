package ru.itis.semesterwork2.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;
import ru.itis.semesterwork2.dto.request.EditProfileFormRequest;
import ru.itis.semesterwork2.dto.request.SignUpForm;
import ru.itis.semesterwork2.dto.response.UserResponse;
import ru.itis.semesterwork2.dto.response.ValidationErrorDto;
import ru.itis.semesterwork2.dto.response.ValidationExceptionResponse;
import ru.itis.semesterwork2.security.details.AccountUserDetails;
import ru.itis.semesterwork2.services.ProfileService;
import ru.itis.semesterwork2.services.SignUpService;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/rest")
@RequiredArgsConstructor
public class UserRestController {
    private final ProfileService profileService;
    private final SignUpService signUpService;

    @GetMapping
    public ResponseEntity<UserResponse> getUser(Authentication authentication){
        return ResponseEntity.ok(profileService.getProfilePage(((AccountUserDetails) authentication.getPrincipal()).getUser()));
    }

    @PostMapping
    public ResponseEntity<UserResponse> addUser(@Valid @RequestBody SignUpForm form){
        return ResponseEntity.ok(signUpService.signUp(form));
    }

    @PutMapping
    public ResponseEntity<UserResponse> updateUser(@Valid @RequestBody EditProfileFormRequest request, Authentication authentication){
        return ResponseEntity.ok(profileService.editProfile(request,((AccountUserDetails) authentication.getPrincipal()).getUser()));
    }

    @DeleteMapping
    public void deleteUser(Authentication authentication){
        signUpService.signOut(((AccountUserDetails) authentication.getPrincipal()).getUser());
    }

    
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ValidationExceptionResponse handleException(MethodArgumentNotValidException exception) {
        List<ValidationErrorDto> errors = new ArrayList<>();
        exception.getBindingResult().getAllErrors().forEach((error) -> {

            String errorMessage = error.getDefaultMessage();
            ValidationErrorDto errorDto = ValidationErrorDto.builder()
                    .message(errorMessage)
                    .build();

            if (error instanceof FieldError) {
                String fieldName = ((FieldError) error).getField();
                errorDto.setField(fieldName);
            } else if (error instanceof ObjectError) {
                String objectName = error.getObjectName();
                errorDto.setObject(objectName);
            }
            errors.add(errorDto);
        });
        return ValidationExceptionResponse.builder()
                .errors(errors)
                .build();
    }


}
