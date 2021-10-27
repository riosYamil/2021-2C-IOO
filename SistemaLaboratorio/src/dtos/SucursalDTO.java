package dtos;

import domains.Peticion;
import domains.Usuario;

import java.util.List;

public class SucursalDTO {
    public int id;
    public int numero;
    public String direccion;
    public Usuario responsableTecnico;
    public List<Peticion> peticiones;
}
