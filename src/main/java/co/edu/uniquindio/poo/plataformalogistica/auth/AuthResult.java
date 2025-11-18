package co.edu.uniquindio.poo.plataformalogistica.auth;

public class AuthResult {
    private final boolean success;
    private final String message;
    private final Rol rol;
    private final String linkedId;

    private AuthResult(boolean success, String message, Rol rol, String linkedId) {
        this.success = success; this.message = message; this.rol = rol; this.linkedId = linkedId;
    }
    public static AuthResult ok(Rol rol, String linkedId) { return new AuthResult(true,"OK",rol,linkedId); }
    public static AuthResult fail(String message) { return new AuthResult(false,message,null,null); }

    public boolean isSuccess() { return success; }
    public String getMessage() { return message; }
    public Rol getRol() { return rol; }
    public String getLinkedId() { return linkedId; }
}
