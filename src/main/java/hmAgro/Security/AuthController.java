package hmAgro.Security;

import hmAgro.model.User;
import hmAgro.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder encoder;

    @Autowired
    private JwtService jwtService;

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody User user) {
        user.setPassword(encoder.encode(user.getPassword()));
        userRepository.save(user);
        return ResponseEntity.ok("Usuário criado");
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody User user) {

        var userDb = userRepository.findByUsername(user.getUsername())
                .orElse(null);

        if (userDb == null || !encoder.matches(user.getPassword(), userDb.getPassword())) {
            return ResponseEntity.status(401).body("Credenciais inválidas");
        }

        String token = jwtService.gerarToken(userDb.getUsername());

        return ResponseEntity.ok(Map.of("token", token));
    }
}
