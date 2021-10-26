package controllers;

import domains.Practica;
import domains.Sucursal;
import dtos.SucursalDTO;

public class PracticaController {
    public Practica AltaPractica(Practica p) {
        dao.PracticaDAO.CrearPractica(p);
        return p;
    }

    public void BajaPractica(int codigoPractica) {
        dao.PracticaDAO.BorrarPractica(codigoPractica);
    }

    public void ModificarPractica(Practica p) {
        dao.PracticaDAO.ActualizarPractica(p);
    }

    public Practica ObtenerPractica(int codigoPractica) {
        return dao.PracticaDAO.ObtenerPractica(codigoPractica);
    }
}
