package ac.cr.ucr.SISTRADE.controller;

import ac.cr.ucr.SISTRADE.model.User;
import ac.cr.ucr.SISTRADE.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/user")
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping
    public ResponseEntity<?> addUser(@Validated @RequestBody User user, BindingResult result){
        if (result.hasErrors()) {
            Map<String, String> errors = new HashMap<>();
            for (FieldError error : result.getFieldErrors()) {
                errors.put(error.getField(), error.getDefaultMessage());
            }
            return ResponseEntity.badRequest().body(errors);
        }
        Optional<User> userOp = this.userService.findUserById(user.getId());

        if(userOp.isPresent()){
            return ResponseEntity.status(HttpStatus.CONFLICT).body("User with ID "+user.getId()+" already exists!");
        }

        return ResponseEntity.status(HttpStatus.CREATED).body(this.userService.saveUser(user));
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> findUserById(@PathVariable Integer id){
        Optional<User> userFind = this.userService.findUserById(id);
        if(!userFind.isPresent()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User with ID "+id+" doesn't exist!");
        }

        return ResponseEntity.ok(userFind);
    }

    @GetMapping
    public ResponseEntity<?> findAllUsers(){

        List<User> listUsers=this.userService.findAllUsers();
        if (listUsers.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No Users stored!");
        }
        return ResponseEntity.ok(listUsers);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteUser(@PathVariable Integer id){

        Optional<User> userFind = this.userService.findUserById(id);
        if(!userFind.isPresent()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User with ID "+id+" doesn't exist!");
        }
        this.userService.deleteUserById(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> editUser(@Validated @PathVariable Integer id, @RequestBody User user, BindingResult result){

        if (result.hasErrors()) {
            Map<String, String> errors = new HashMap<>();
            for (FieldError error : result.getFieldErrors()) {
                errors.put(error.getField(), error.getDefaultMessage());
            }
            return ResponseEntity.badRequest().body(errors);
        }
        Optional<User> userFind = this.userService.findUserById(id);
        if(!userFind.isPresent()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User with ID "+id+" doesn't exist!");
        }

        return ResponseEntity.ok(this.userService.editUser(id, user));
    }
}
