package co.edu.uniquindio.poo.plataformalogistica.controller;

import co.edu.uniquindio.poo.plataformalogistica.auth.*;

public class LoginController {
    private final AuthService authService;
    private final SessionManager sessionManager = SessionManager.getInstancia();

    public LoginController(AuthService authService) {
        this.authService = authService;
    }

    public AuthResult login(String user, String pass) {
        AuthResult r = authService.authenticate(user, pass);
        if (r.isSuccess()) sessionManager.iniciarSesion(r.getRol(), r.getLinkedId());
        return r;
    }

    public void logout() { sessionManager.cerrarSesion(); }
}
