package co.edu.uniquindio.poo.plataformalogistica.auth;

public final class SessionManager {
    private static SessionManager instancia;
    private boolean autenticado;
    private Rol rol;
    private String linkedId;

    private SessionManager(){}

    public static SessionManager getInstancia() {
        if (instancia == null) instancia = new SessionManager();
        return instancia;
    }

    public void iniciarSesion(Rol rol, String linkedId) {
        this.autenticado = true; this.rol = rol; this.linkedId = linkedId;
    }
    public void cerrarSesion() { this.autenticado = false; this.rol = null; this.linkedId = null; }

    public boolean isAutenticado() { return autenticado; }
    public Rol getRol() { return rol; }
    public String getLinkedId() { return linkedId; }
}
