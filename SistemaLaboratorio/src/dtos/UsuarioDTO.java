package dtos;

import enums.rol;
import java.util.Date;

public class UsuarioDTO {
    public int usuarioID;
    public String nombre;
    public String email;
    public String password;
    public String nombreCompleto;
    public String domicilio;
    public String dni;
    public Date fechaDeNacimiento;
    public enums.rol rol;
}
