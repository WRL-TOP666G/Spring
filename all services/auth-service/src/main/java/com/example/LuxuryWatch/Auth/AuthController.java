package com.example.LuxuryWatch.Auth;


import com.example.LuxuryWatch.Beam.User;
import com.example.LuxuryWatch.Dao.RoleDao;
import com.example.LuxuryWatch.Dao.UserDao;
import com.example.LuxuryWatch.Security.JwtService;
import com.example.LuxuryWatch.Security.UserDetailsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
public class AuthController {


    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    UserDao userDao;
    @Autowired
    RoleDao roleDao;
    @Autowired
    PasswordEncoder passwordEncoder;

    @Autowired
    AuthService authService;
    @Autowired
    JwtService jwtService;

    @Autowired
    UserDetailsServiceImpl userDetailsServiceImpl;

    @PostMapping("/login")
    public ResponseEntity<?> authenticateUser(@Validated @RequestBody AuthRequest authRequest) {

        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        authRequest.getUsername(),
                        authRequest.getPassword()
                )
        );

        SecurityContextHolder.getContext().setAuthentication(authentication);
        String jwt = jwtService.generateToken(authRequest.getUsername());

        User user = (User) authentication.getPrincipal();

        AuthResponse authResponse = new AuthResponse(user.getUsername(), user.getPassword(),jwt);
        return ResponseEntity.ok(authResponse);
    }

//    @GetMapping("/checklogin")
//    public DataResponse<User> checkLogin(HttpServletRequest request) {
//        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
//        String authHeader = request.getHeader("Authorization");
//        System.out.println(authHeader);
//        if (authHeader != null && authentication.isAuthenticated()) {
//            System.out.println(authentication.getPrincipal());
//            User user = (User) authentication.getPrincipal();
//            return new DataResponse<>("User is authenticated", user );
//        } else if (authHeader == null) {
//            return new DataResponse<>(false, "Missing Authentication header");
//        } else if (!authHeader.startsWith("Bearer ")){
//            return new DataResponse<>(false, "Invalid Authentication header");
//        } else {
//            return new DataResponse<>(false, "User is not authenticated");
//        }
//
//    }


    //
//    @PostMapping("/register")
//    public ResponseEntity<AuthenticationResponse> register(
//            @RequestBody RegisterRequest request
//    ) {
//        return ResponseEntity.ok(authService.register(request));
//    }
//    @PostMapping("/authenticate")
//    public ResponseEntity<AuthenticationResponse> authenticate(
//            @RequestBody AuthenticationRequest request
//    ) {
//        return ResponseEntity.ok(authService.authenticate(request));
//    }
//
//    @PostMapping("/refresh-token")
//    public void refreshToken(
//            HttpServletRequest request,
//            HttpServletResponse response
//    ) throws IOException {
//        authService.refreshToken(request, response);
//    }
    @PostMapping("/register")
    public User createUser(@RequestBody User user) {
        if(userDao.existsByUsername(user.getUsername())){
            throw new Error("The username is already existed !!");
        }
        //TODO: change to Response{true, false}
        return authService.createUser(user);
    }



//
    @PostMapping("/token")
    public String getToken(@RequestBody AuthRequest authRequest) {
        Authentication authentication = authenticationManager
                .authenticate(new UsernamePasswordAuthenticationToken(
                        authRequest.getUsername(),authRequest.getPassword()));
        if(authentication.isAuthenticated()) {
            return authService.generateToken(authRequest.getUsername());
        }else {
            throw new RuntimeException("invalid access");
        }
    }
//
//    @PostMapping("/validate")
//    public String validateToken(@RequestParam("token") String token, @RequestBody User user) {
//        if (authService.isTokenValid(token, user)){
//            return "Token is valid";
//        }else {
//            return "Token is not valid";
//        }
//
//    }

}

