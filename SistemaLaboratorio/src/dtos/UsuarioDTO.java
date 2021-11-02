package dtos;

import domains.Usuario;
import enums.Rol;

import java.util.Date;

public class UsuarioDTO {
    public int id;
    public String nombre;
    public String email;
    public String password;
    public String nombreCompleto;
    public String domicilio;
    public String dni;
    public Date fechaDeNacimiento;
    public Rol rol;


    @Override
    public boolean equals(Object obj) {
        UsuarioDTO c = (UsuarioDTO) obj;
        return this.id == c.id;
    }
}
