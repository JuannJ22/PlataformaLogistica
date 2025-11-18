package co.edu.uniquindio.poo.plataformalogistica.auth;

public interface PasswordEncoder {
    String encode(String raw);
    boolean matches(String raw, String encoded);
}
