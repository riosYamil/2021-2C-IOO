package domains;

import dtos.UsuarioDTO;

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
    private enums.rol rol;

    public Usuario(UsuarioDTO usuario) {
        this.id = usuario.id;
        this.nombre = usuario.nombre;
        this.email = usuario.email;
        this.password = usuario.password;
        this.nombreCompleto = usuario.nombreCompleto;
        this.domicilio = usuario.domicilio;
        this.dni = usuario.dni;
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
        usuarioDTO.rol = this.rol;
        return usuarioDTO;
    }
}


