package com.prueba.mse;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 *
 * @author msubiza
 */
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/users")
public class UserRestController {

    @Autowired
    private UserDBFacade userFacade;

    @GetMapping()
    public ResponseEntity<?> listFromDb() {
        try {
            return new ResponseEntity<>(userFacade.findAll(), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    
    @PostMapping(value = "/signup", consumes = "application/json", produces = "application/json")
    public ResponseEntity<?> post(@RequestBody UserDB input) {
        try {
            userFacade.create(input);
            return new ResponseEntity(input, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity(null, HttpStatus.CONFLICT);
        }
    }
    
    @PostMapping(value = "/login", consumes = "application/json", produces = "application/json")
    public ResponseEntity<?> login(@RequestBody UserLoginDTO input) {
        try {
            UserDB user = userFacade.login(input.getEmail(), input.getPassword());
            if (user != null) {
                return new ResponseEntity(true, HttpStatus.OK);
            } else {
                return new ResponseEntity(false, HttpStatus.UNAUTHORIZED);
            }
        } catch (Exception e) {
            return new ResponseEntity(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @ExceptionHandler(Exception.class)
    @ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR, reason = "Error message")
    public void handleError() {
    }

}
