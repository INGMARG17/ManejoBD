package co.edu.itc.programacion2.PruebaBD.vo;

public class EstudianteVO {

    private Integer codigo;

    private String nombre;

    private String apellido;

    private String numeroTelefonico;

    private String email;

    public EstudianteVO() {
    }

    public EstudianteVO(Integer codigo, String nombre, String apellido, String numeroTelefonico, String email) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.apellido = apellido;
        this.numeroTelefonico = numeroTelefonico;
        this.email = email;
    }

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getNumeroTelefonico() {
        return numeroTelefonico;
    }

    public void setNumeroTelefonico(String numeroTelefonico) {
        this.numeroTelefonico = numeroTelefonico;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "EstudianteVO{" + "codigo=" + codigo + ", nombre=" + nombre + ", apellido=" + apellido + ", numeroTelefonico=" + numeroTelefonico + ", email=" + email + '}';
    }

}
