package domains;

import dtos.UsuarioDTO;
import enums.Rol;

import java.util.Date;

public class Usuario {
    private Integer id;
    private String nombre;
    private String email;
    private String password;
    private String nombreCompleto;
    private String domicilio;
    private String dni;
    private Date fechaDeNacimiento;
    private Rol rol;

    public Usuario(UsuarioDTO usuario) {
        this.id = usuario.id;
        this.nombre = usuario.nombre;
        this.email = usuario.email;
        this.password = usuario.password;
        this.nombreCompleto = usuario.nombreCompleto;
        this.domicilio = usuario.domicilio;
        this.dni = usuario.dni;
        this.fechaDeNacimiento = usuario.fechaDeNacimiento;
        this.rol = usuario.rol;
    }

    public UsuarioDTO toUsuarioDTO() {
        UsuarioDTO usuarioDTO = new UsuarioDTO();
        usuarioDTO.id = this.id;
        usuarioDTO.nombre = this.nombre;
        usuarioDTO.email = this.email;
        usuarioDTO.password = this.password;
        usuarioDTO.nombreCompleto = this.nombreCompleto;
        usuarioDTO.domicilio = this.domicilio;
        usuarioDTO.dni = this.dni;
        usuarioDTO.fechaDeNacimiento = this.fechaDeNacimiento;
        usuarioDTO.rol = this.rol;
        return usuarioDTO;
    }

    public boolean esLaboratista() {
        return this.rol.equals(rol.Laboratista);
    }

    public boolean esRecepcionista() {
        return this.rol.equals(rol.Recepcion);
    }

    public boolean esAdministrador() {
        return this.rol.equals(rol.Administrador);
    }

    public void trabajar() {
        return;
    }

}


