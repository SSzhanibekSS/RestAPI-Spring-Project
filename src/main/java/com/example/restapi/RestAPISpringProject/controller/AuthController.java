package com.example.restapi.RestAPISpringProject.controller;

import com.example.restapi.RestAPISpringProject.dto.AuthDTO;
import com.example.restapi.RestAPISpringProject.dto.PersonDTO;
import com.example.restapi.RestAPISpringProject.security.JWTUtil;
import com.example.restapi.RestAPISpringProject.services.PersonService;
import com.example.restapi.RestAPISpringProject.util.ErrorMsg;
import com.example.restapi.RestAPISpringProject.util.RegisterValidator;
import com.example.restapi.RestAPISpringProject.util.RegistrationFieldException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.time.LocalDate;
import java.util.Map;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final RegisterValidator registerValidator;
    private final PersonService personService;
    private final JWTUtil jwtUtil;
    private final AuthenticationManager authenticationManager;
    @Autowired
    public AuthController(RegisterValidator registerValidator, PersonService personService, JWTUtil jwtUtil, AuthenticationManager authenticationManager) {
        this.registerValidator = registerValidator;
        this.personService = personService;
        this.jwtUtil = jwtUtil;
        this.authenticationManager = authenticationManager;
    }

    @PostMapping("/reg")
    public Map<String, String> register(@RequestBody @Valid PersonDTO userDTO,
                        BindingResult result){
        System.out.println(userDTO);
    registerValidator.validate(userDTO,result);

    if (result.hasErrors()){
        StringBuilder errorMsg = new StringBuilder();
        errorMsg.append("Please check this fields: ");
       for(FieldError error:result.getFieldErrors()){
            errorMsg.append(error.getField())
                    .append(" - ")
                    .append(error.getDefaultMessage())
                    .append(";")
                    .append(System.lineSeparator());
       }
       throw new RegistrationFieldException(errorMsg.toString());
    }


    personService.saveNewPerson(userDTO);

    String token = jwtUtil.generateToken(userDTO.getUsername());
        System.out.println("some thing");
    return Map.of("jwt-token", token);

    }
    @PostMapping("/login")
    public Map<String, String> performLogin(@RequestBody AuthDTO authenticationDTO) {
        UsernamePasswordAuthenticationToken authInputToken =
                new UsernamePasswordAuthenticationToken(authenticationDTO.getUsername(),
                        authenticationDTO.getPassword());

        try {
            authenticationManager.authenticate(authInputToken);
        } catch (BadCredentialsException e) {
            return Map.of("message", "Incorrect credentials!");
        }

        String token = jwtUtil.generateToken(authenticationDTO.getUsername());
        return Map.of("jwt-token", token);
    }

    @ExceptionHandler
    public ResponseEntity<ErrorMsg> hndleRegisterException(RegistrationFieldException e){
        ErrorMsg error = ErrorMsg.builder()
                .message(e.getMessage())
                .timestamp(LocalDate.now())
                .build();

        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }
}
