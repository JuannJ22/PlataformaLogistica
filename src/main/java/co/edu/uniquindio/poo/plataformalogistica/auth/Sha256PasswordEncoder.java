package co.edu.uniquindio.poo.plataformalogistica.auth;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;

public class Sha256PasswordEncoder implements PasswordEncoder {
    @Override
    public String encode(String raw) {
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            byte[] out = md.digest(raw.getBytes(StandardCharsets.UTF_8));
            StringBuilder sb = new StringBuilder();
            for (byte b : out) sb.append(String.format("%02x", b));
            return sb.toString();
        } catch (Exception e) {
            throw new IllegalStateException("No se pudo usar SHA-256", e);
        }
    }
    @Override
    public boolean matches(String raw, String encoded) {
        return encode(raw).equals(encoded);
    }
}
