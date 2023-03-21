package com.nutri.bitacoras.controller.Auth;

import com.nutri.bitacoras.model.entiy.Usuario;
import com.nutri.bitacoras.service.impl.UsuarioServiceImpl;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
//import org.springframework.security.authentication.AuthenticationManager;

@CrossOrigin
@RestController
@RequestMapping("/auth")
public class AuthController {
    /*@Autowired
    private AuthenticationManager authenticationManager;*/

    @Autowired
    private UsuarioServiceImpl usuarioService;

    @PostMapping("/login")
    public ResponseEntity<?> authenticateUser(@Valid @RequestBody Usuario loginDTO){
      /*  Authentication authentication = authenticationManager
                .authenticate(new UsernamePasswordAuthenticationToken(loginDTO.getUsername(),loginDTO.getPassword()));

        SecurityContextHolder.getContext().setAuthentication(authentication);

        String token = jwtTokenProvider.generateToken(authentication);
        UserDetails userDetails = (UserDetails) authentication.getPrincipal();
        Usuario usuario = usuarioService.findByUsername(userDetails.getUsername());

        JwtAuthResponse jwtAuthResponse = new JwtAuthResponse(
                token, usuario.getId(), usuario.getUsername(),userDetails.getAuthorities()
        );*/

      //  return ResponseEntity.ok(jwtAuthResponse);
        return null;
    }



}
