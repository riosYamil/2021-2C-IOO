package views;

import javax.swing.JTabbedPane;

public class InternalPanel extends JTabbedPane {

	public InternalPanel() {
		setBorder(null);
		setBounds(100, 100, 629, 476);

		PacientePanel pnlPaciente = new PacientePanel();
		SucursalPanel pnlSucursal = new SucursalPanel();
		PeticionPanel pnlPeticion = new PeticionPanel();
		UsuarioPanel pnlUsuario = new UsuarioPanel();
		
		this.addTab("Pacientes", pnlPaciente.setPanelPaciente());
		this.addTab("Peticiones", pnlPeticion.setPeticionesTab());
		this.addTab("Sucursales", pnlSucursal.setSucursalTab());
		this.addTab("Usuarios", pnlUsuario.setUsuarioTab());
	}


}
