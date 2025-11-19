package co.edu.uniquindio.poo.plataformalogistica.dto;

public class UsuarioDTO {

    private String id;
    private String nombreCompleto;
    private String telefono;
    private Integer edad;
    private String correoElectronico;

    public UsuarioDTO() {
    }

    public UsuarioDTO(String id, String nombreCompleto, String telefono,
                      Integer edad, String correoElectronico) {
        this.id = id;
        this.nombreCompleto = nombreCompleto;
        this.telefono = telefono;
        this.edad = edad;
        this.correoElectronico = correoElectronico;
    }

    // Getters y setters (necesarios para PropertyValueFactory)
    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public String getNombreCompleto() { return nombreCompleto; }
    public void setNombreCompleto(String nombreCompleto) { this.nombreCompleto = nombreCompleto; }

    public String getTelefono() { return telefono; }
    public void setTelefono(String telefono) { this.telefono = telefono; }

    public Integer getEdad() { return edad; }
    public void setEdad(Integer edad) { this.edad = edad; }

    public String getCorreoElectronico() { return correoElectronico; }
    public void setCorreoElectronico(String correoElectronico) { this.correoElectronico = correoElectronico; }
}
