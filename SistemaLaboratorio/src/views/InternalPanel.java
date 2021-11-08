package views;

import controllers.UsuarioController;
import enums.Rol;

import javax.swing.JTabbedPane;

public class InternalPanel extends JTabbedPane {

	public InternalPanel(String rol) {
		setBorder(null);
		setBounds(100, 100, 629, 476);

		PacientePanel pnlPaciente = new PacientePanel();
		SucursalPanel pnlSucursal = new SucursalPanel();
		PeticionPanel pnlPeticion = new PeticionPanel();
		UsuarioPanel pnlUsuario = new UsuarioPanel();

		if (rol == Rol.Recepcion.toString() || rol == Rol.Administrador.toString()) {
			this.addTab("Pacientes", pnlPaciente.setPanelPaciente()); //Recep: recibe pacientes
			this.addTab("Peticiones", pnlPeticion.setPeticionesTab()); //Recep: carga peticiones y consulta
		}

		if (rol == Rol.Laboratista.toString() || rol == Rol.Administrador.toString()) {
			//carga resultados de practicas
		}

		if (rol == Rol.Administrador.toString()) {
			this.addTab("Sucursales", pnlSucursal.setSucursalTab());
			this.addTab("Usuarios", pnlUsuario.setUsuarioTab());
		}
	}


}
