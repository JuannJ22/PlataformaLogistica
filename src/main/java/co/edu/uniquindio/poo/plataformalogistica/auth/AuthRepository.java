package co.edu.uniquindio.poo.plataformalogistica.auth;

public interface AuthRepository {
    Credencial findByUsername(String username);
}
