package co.edu.uniquindio.poo.plataformalogistica.auth;

import java.util.regex.Pattern;

public class AuthService {
    private final AuthRepository repository;
    private final PasswordEncoder encoder;
    private static final Pattern USER_PATTERN = Pattern.compile("^[A-Za-z0-9._@-]{3,40}$");

    public AuthService(AuthRepository repository, PasswordEncoder encoder) {
        this.repository = repository;
        this.encoder = encoder;
    }

    public AuthResult authenticate(String username, String rawPassword) {
        if (username == null || username.isBlank()) return AuthResult.fail("El usuario es obligatorio.");
        if (!USER_PATTERN.matcher(username).matches()) return AuthResult.fail("Usuario inválido.");
        if (rawPassword == null || rawPassword.isBlank()) return AuthResult.fail("La contraseña es obligatoria.");
        if (rawPassword.length() < 4) return AuthResult.fail("La contraseña debe tener al menos 4 caracteres.");

        Credencial cred = repository.findByUsername(username);
        if (cred == null) return AuthResult.fail("Usuario no registrado.");
        if (!encoder.matches(rawPassword, cred.getPasswordHash())) return AuthResult.fail("Contraseña incorrecta.");

        return AuthResult.ok(cred.getRol(), cred.getLinkedId());
    }
}
