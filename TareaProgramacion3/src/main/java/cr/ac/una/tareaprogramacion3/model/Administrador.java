
package cr.ac.una.tareaprogramacion3.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;


    
    @Entity
@Table(name = "ADMINISTRADORES",
       uniqueConstraints = {
         @UniqueConstraint(columnNames = "USUARIO"),
         @UniqueConstraint(columnNames = "CORREO")
       })
public class Administrador {
           

  
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    @Column(name = "NOMBRE", nullable = false, length = 80)
    private String nombre;

    @Column(name = "APELLIDOS", nullable = false, length = 120)
    private String apellidos;

    @Column(name = "CORREO", nullable = false, length = 120)
    private String correo;

    @Column(name = "USUARIO", nullable = false, length = 40)
    private String usuario;

    // Solo para pruebas: luego lo cambiaremos a PASSWORD_HASH (BCrypt)
    @Column(name = "PASSWORD_PLAIN", nullable = false, length = 255)
    private String passwordPlain;

    @Column(name = "ESTADO", nullable = false, length = 10)
    private String estado; // 'ACTIVO' | 'INACTIVO'

    // getters/setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public String getApellidos() { return apellidos; }
    public void setApellidos(String apellidos) { this.apellidos = apellidos; }

    public String getCorreo() { return correo; }
    public void setCorreo(String correo) { this.correo = correo; }

    public String getUsuario() { return usuario; }
    public void setUsuario(String usuario) { this.usuario = usuario; }

    public String getPasswordPlain() { return passwordPlain; }
    public void setPasswordPlain(String passwordPlain) { this.passwordPlain = passwordPlain; }

    public String getEstado() { return estado; }
    public void setEstado(String estado) { this.estado = estado; }

  }

