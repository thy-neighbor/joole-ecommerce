package com.neighbor.jooleuserservice.user;

import com.neighbor.jooleuserservice.security.AuthenticationRequest;
import com.neighbor.jooleuserservice.security.AuthenticationResponse;
import com.neighbor.jooleuserservice.security.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*", allowCredentials = "false")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private MyUserDetailsService userDetailsService;

    @Autowired
    private JwtUtil jwtTokenUtil;

    @GetMapping("/hello")
    public String sayHi(){
        return "hi";
    }

    @GetMapping("/api/users")
    public List<User> getAllUsers(){
        return userService.getAllUsers();
    }

    @GetMapping("/api/users/id")
    public List<User> getOneUser(){
        return null;
    }

    @GetMapping("/api/users/{name}")
    public User getUserByName(@PathVariable String name){
        return userService.getByUsername(name);
    }

    @RequestMapping(value="/api/users", method=RequestMethod.POST)
    public void addUser(@RequestBody User user){
        userService.createUser(user);
    }

/*    @DeleteMapping("/api/users/{name}")
    public void deleteUserByName(@PathVariable String name){
        userService.deleteByUsername(name);
    }*/

    @DeleteMapping("/api/users/{id}")
    public void deleteUser(@PathVariable Integer id){
        userService.deleteUserById(id);
    }

    @RequestMapping(value = "/signup", method = RequestMethod.POST)
    public HttpStatus signup(@RequestBody User user) {
        //user.setJoinDate(new Date());
        return userService.createUser(user) ? HttpStatus.CREATED :
                HttpStatus.BAD_REQUEST; //adds a user in database
    }

    //used to grant a new jwt token
    @RequestMapping(value = "/authenticate", method = RequestMethod.POST)
    public ResponseEntity<?> createAuthenticationToken(@RequestBody AuthenticationRequest authenticationRequest) throws Exception {
        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(authenticationRequest.getUsername(), authenticationRequest.getPassword())
            );
        }catch(BadCredentialsException e) {
            throw new Exception("Incorrect username or password", e);
        }

        final UserDetails userDetails = userDetailsService
                .loadUserByUsername(authenticationRequest.getUsername());
        final String jwt=jwtTokenUtil.generateToken(userDetails);
        final User user=userService.getByUsername(userDetails.getUsername());
        return ResponseEntity.ok(new AuthenticationResponse(jwt,user.getId(),user.getEmail(),user.getRole(),user.getProfileImage()));

    }
    //check to see if token is expired
    @RequestMapping(value = "/auth/validate", method = RequestMethod.POST)
    public ResponseEntity<?> isTokenBad(@RequestBody String token) {
        boolean valid = jwtTokenUtil.isTokenExpired(token);
        return ResponseEntity.ok(valid);
    }
}
