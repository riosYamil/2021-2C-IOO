package controllers;

import domains.Paciente;
import domains.Practica;

public class PracticaController {
    public Practica AltaPractica(Practica practica, Paciente paciente) {
        dao.PracticaDAO.CrearPractica(practica, paciente);
        return practica;
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
