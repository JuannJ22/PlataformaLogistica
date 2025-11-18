package co.edu.uniquindio.poo.plataformalogistica.auth;

import java.util.ArrayList;
import java.util.List;

public class InMemoryAuthRepository implements AuthRepository {
    private final List<Credencial> credenciales = new ArrayList<>();
    public void add(Credencial c) { credenciales.add(c); }

    @Override
    public Credencial findByUsername(String username) {
        if (username == null) return null;
        for (Credencial c : credenciales) {
            if (username.equalsIgnoreCase(c.getUsername())) return c;
        }
        return null;
    }
}
