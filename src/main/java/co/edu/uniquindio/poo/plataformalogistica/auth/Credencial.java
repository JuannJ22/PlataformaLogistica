package co.edu.uniquindio.poo.plataformalogistica.auth;

public class Credencial {
    private final String username;
    private final String passwordHash;
    private final Rol rol;
    private final String linkedId;

    public Credencial(String username, String passwordHash, Rol rol, String linkedId) {
        this.username = username;
        this.passwordHash = passwordHash;
        this.rol = rol;
        this.linkedId = linkedId;
    }
    public String getUsername() { return username; }
    public String getPasswordHash() { return passwordHash; }
    public Rol getRol() { return rol; }
    public String getLinkedId() { return linkedId; }
}
