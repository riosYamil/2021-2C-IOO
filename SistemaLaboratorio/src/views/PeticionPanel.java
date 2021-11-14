package views;

import controllers.PacienteController;
import controllers.PeticionController;
import dtos.PacienteDTO;
import dtos.PeticionDTO;
import dtos.PracticaAsociadaDTO;
import dtos.PracticaDTO;
import enums.EstadoPeticion;

import javax.swing.*;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class PeticionPanel {
	
	private JTabbedPane tabbedPane_5;
	private Panel Peticiones1;
	private JButton btnEnviarNot;
	private JLabel lblNotificar;
	private JLabel lblID;
	private JTextField tID;
	private Button btnDeletePet;
	private Button btnAddPet;
	private JLabel lblDNI;
	private JTextField tDNI;
	private JLabel lblOB;
	private JTextField tOB;
	private JLabel lblPracticas;
	private JButton btnAddPractica;
	private Panel MasPeticiones;
	private Panel AltaPeticiones;
	private Panel BajaPeticiones;
	private Button btnObtenerPeticiones;
	private JTextField tDNIPeticiones;
	private JTextArea tPracticas;
	private JCheckBox chckbxPeticionesPendientes;
	private JCheckBox chckbxPeticionesCompletas;
	private JCheckBox chckbxPeticionesCriticas;
	private JLabel lblNombrePractica;
	private JTextField tNombrePractica;
	private JLabel lblGrupoPractica;
	private JTextField tGrupoPractica;
	
	private List<PracticaAsociadaDTO> practicasAsociadas = new ArrayList<PracticaAsociadaDTO>();
	private JTextField tNumSucursal;
	private JLabel lblNumeroSucursal;

	/**
	 * @wbp.parser.entryPoint
	 */
	public JTabbedPane setPeticionesTab(String rol) {	
		tabbedPane_5 = new JTabbedPane(JTabbedPane.LEFT);
		tabbedPane_5.setBackground(Color.WHITE);
		tabbedPane_5.setBounds(100, 100, 629, 476);
		tabbedPane_5.add("Peticiones", setObtenerPeticiones());
		tabbedPane_5.add("Alta", setAltaPeticiones());
		tabbedPane_5.add("Baja", setBajaPeticiones());
		tabbedPane_5.add("+", setNotificar());
		
		asociarEventos();
		
		return tabbedPane_5;
	}
	
	public Panel setAltaPeticiones() {
		AltaPeticiones = new Panel();
		btnAddPet = new Button("Agregar Petición");
		btnAddPet.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnAddPet.setForeground(Color.WHITE);
		btnAddPet.setBackground(new Color(133, 189, 212));
		btnAddPet.setBounds(230, 174, 150, 27);
		
		lblDNI = new JLabel("DNI DEL PACIENTE");
		
		tDNI = new JTextField();
		tDNI.setColumns(10);
		
		lblOB = new JLabel("OBRA SOCIAL");
		
		tOB = new JTextField();
		tOB.setColumns(10);
		
		lblPracticas = new JLabel("PRACTICAS ASOCIADAS");
		lblPracticas.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnAddPractica = new JButton("Agregar Práctica");
		
		lblNombrePractica = new JLabel("NOMBRE");
		
		tNombrePractica = new JTextField();
		tNombrePractica.setColumns(10);
		
		lblGrupoPractica = new JLabel("GRUPO");
		
		tGrupoPractica = new JTextField();
		tGrupoPractica.setText("");
		tGrupoPractica.setColumns(10);
		
		tNumSucursal = new JTextField();
		tNumSucursal.setColumns(10);
		
		lblNumeroSucursal = new JLabel("NUMERO DE SUCURSAL");
		
		
		GroupLayout gl_AltaPeticiones = new GroupLayout(AltaPeticiones);
		gl_AltaPeticiones.setHorizontalGroup(
			gl_AltaPeticiones.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_AltaPeticiones.createSequentialGroup()
					.addGroup(gl_AltaPeticiones.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_AltaPeticiones.createSequentialGroup()
							.addGap(35)
							.addGroup(gl_AltaPeticiones.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_AltaPeticiones.createSequentialGroup()
									.addGroup(gl_AltaPeticiones.createParallelGroup(Alignment.LEADING)
										.addComponent(lblDNI)
										.addComponent(tDNI, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
									.addGap(18)
									.addGroup(gl_AltaPeticiones.createParallelGroup(Alignment.LEADING)
										.addComponent(tOB, GroupLayout.PREFERRED_SIZE, 237, GroupLayout.PREFERRED_SIZE)
										.addComponent(lblOB)))
								.addComponent(btnAddPractica, GroupLayout.PREFERRED_SIZE, 139, GroupLayout.PREFERRED_SIZE)
								.addGroup(gl_AltaPeticiones.createSequentialGroup()
									.addGroup(gl_AltaPeticiones.createParallelGroup(Alignment.LEADING)
										.addComponent(tNombrePractica, GroupLayout.PREFERRED_SIZE, 166, GroupLayout.PREFERRED_SIZE)
										.addComponent(lblNombrePractica)
										.addComponent(lblPracticas)
										.addComponent(tNumSucursal, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
										.addComponent(lblNumeroSucursal))
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addGroup(gl_AltaPeticiones.createParallelGroup(Alignment.LEADING)
										.addComponent(lblGrupoPractica)
										.addComponent(tGrupoPractica, GroupLayout.PREFERRED_SIZE, 197, GroupLayout.PREFERRED_SIZE))))
							.addPreferredGap(ComponentPlacement.RELATED))
						.addGroup(gl_AltaPeticiones.createSequentialGroup()
							.addGap(176)
							.addComponent(btnAddPet, GroupLayout.PREFERRED_SIZE, 186, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(152, Short.MAX_VALUE))
		);
		gl_AltaPeticiones.setVerticalGroup(
			gl_AltaPeticiones.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_AltaPeticiones.createSequentialGroup()
					.addGap(27)
					.addComponent(btnAddPet, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(30)
					.addGroup(gl_AltaPeticiones.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblDNI)
						.addComponent(lblOB))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_AltaPeticiones.createParallelGroup(Alignment.BASELINE)
						.addComponent(tDNI, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(tOB, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addComponent(lblNumeroSucursal)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(tNumSucursal, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(lblPracticas)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_AltaPeticiones.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblGrupoPractica)
						.addComponent(lblNombrePractica))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_AltaPeticiones.createParallelGroup(Alignment.BASELINE)
						.addComponent(tNombrePractica, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(tGrupoPractica, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addComponent(btnAddPractica)
					.addContainerGap(169, Short.MAX_VALUE))
		);
		AltaPeticiones.setLayout(gl_AltaPeticiones);
		
		return AltaPeticiones;
	}
	
	
	private Panel setObtenerPeticiones() {
		Peticiones1 = new Panel();
		
		JLabel lblPeticiones = new JLabel("Peticiones:");
		JLabel lblObtenerPeticiones = new JLabel("Por favor, ingrese el DNI del paciente para obtener sus peticiones.");
		
		chckbxPeticionesPendientes = new JCheckBox("Peticiones pendientes.");
		chckbxPeticionesPendientes.setBackground(Color.WHITE);
		
		chckbxPeticionesCompletas = new JCheckBox("Peticiones completas");
		chckbxPeticionesCompletas.setBackground(Color.WHITE);
		
		chckbxPeticionesCriticas = new JCheckBox("Peticiones con resultados criticos. ");
		chckbxPeticionesCriticas.setBackground(Color.WHITE);
		
		tDNIPeticiones = new JTextField();
		tDNIPeticiones.setColumns(10);
		
		JLabel lbldni_1 = new JLabel("DNI");
		
		btnObtenerPeticiones = new Button("Obtener peticiones");
		btnObtenerPeticiones.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnObtenerPeticiones.setForeground(Color.WHITE);
		btnObtenerPeticiones.setBackground(new Color(133, 189, 212));
		btnObtenerPeticiones.setBounds(230, 174, 150, 27);
		
		tPracticas = new JTextArea();
		tPracticas.setBackground(SystemColor.control);
		
		JLabel lblPracticasAsoc = new JLabel("PRACTICAS ASOCIADAS");
		
		GroupLayout gl_Peticiones1 = new GroupLayout(Peticiones1);
		gl_Peticiones1.setHorizontalGroup(
			gl_Peticiones1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_Peticiones1.createSequentialGroup()
					.addGap(31)
					.addGroup(gl_Peticiones1.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_Peticiones1.createSequentialGroup()
							.addComponent(tPracticas, GroupLayout.PREFERRED_SIZE, 483, GroupLayout.PREFERRED_SIZE)
							.addContainerGap())
						.addGroup(gl_Peticiones1.createParallelGroup(Alignment.LEADING)
							.addGroup(gl_Peticiones1.createSequentialGroup()
								.addGroup(gl_Peticiones1.createParallelGroup(Alignment.LEADING)
									.addComponent(tDNIPeticiones, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
									.addComponent(lblObtenerPeticiones)
									.addComponent(lbldni_1))
								.addContainerGap(209, Short.MAX_VALUE))
							.addGroup(gl_Peticiones1.createSequentialGroup()
								.addGroup(gl_Peticiones1.createParallelGroup(Alignment.TRAILING, false)
									.addComponent(lblPracticasAsoc, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
									.addComponent(btnObtenerPeticiones, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 147, Short.MAX_VALUE))
								.addPreferredGap(ComponentPlacement.RELATED, 47, Short.MAX_VALUE)
								.addGroup(gl_Peticiones1.createParallelGroup(Alignment.LEADING)
									.addComponent(chckbxPeticionesCriticas)
									.addComponent(chckbxPeticionesCompletas)
									.addComponent(chckbxPeticionesPendientes))
								.addGap(146)))))
		);
		gl_Peticiones1.setVerticalGroup(
			gl_Peticiones1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_Peticiones1.createSequentialGroup()
					.addGap(32)
					.addComponent(lblObtenerPeticiones)
					.addGroup(gl_Peticiones1.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_Peticiones1.createSequentialGroup()
							.addGap(18)
							.addComponent(chckbxPeticionesPendientes)
							.addGap(18)
							.addComponent(chckbxPeticionesCompletas)
							.addGap(18)
							.addComponent(chckbxPeticionesCriticas))
						.addGroup(gl_Peticiones1.createSequentialGroup()
							.addGap(15)
							.addComponent(lbldni_1)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(tDNIPeticiones, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addGap(26)
							.addComponent(btnObtenerPeticiones, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE)))
					.addGap(6)
					.addComponent(lblPracticasAsoc)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(tPracticas, GroupLayout.PREFERRED_SIZE, 181, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(95, Short.MAX_VALUE))
		);
						Peticiones1.setLayout(gl_Peticiones1);
			return Peticiones1;

	}
	
	
	private Panel setBajaPeticiones() {
		BajaPeticiones = new Panel();
		
		JLabel lblBaja = new JLabel("Por favor, ingrese el ID de la petición que desea eliminar.");
		
		lblID = new JLabel("ID");
		
		tID = new JTextField();
		tID.setColumns(10);
		
		btnDeletePet = new Button("Eliminar petición");
		btnDeletePet.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnDeletePet.setForeground(Color.WHITE);
		btnDeletePet.setBackground(Color.RED);
		btnDeletePet.setBounds(230, 174, 50, 27);
		
		GroupLayout gl_BajaPeticiones = new GroupLayout(BajaPeticiones);
		gl_BajaPeticiones.setHorizontalGroup(
			gl_BajaPeticiones.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_BajaPeticiones.createSequentialGroup()
					.addGap(35)
					.addGroup(gl_BajaPeticiones.createParallelGroup(Alignment.LEADING)
						.addComponent(tID, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblID)
						.addComponent(lblBaja)
						.addComponent(btnDeletePet, GroupLayout.PREFERRED_SIZE, 118, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(251, Short.MAX_VALUE))
		);
		gl_BajaPeticiones.setVerticalGroup(
			gl_BajaPeticiones.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_BajaPeticiones.createSequentialGroup()
					.addGap(33)
					.addComponent(lblBaja)
					.addGap(18)
					.addComponent(lblID)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(tID, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(btnDeletePet, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(325, Short.MAX_VALUE))
		);
		BajaPeticiones.setLayout(gl_BajaPeticiones);
		
		return BajaPeticiones;
	}
	
	private Panel setNotificar() {
		MasPeticiones = new Panel();
				
		btnEnviarNot = new JButton("Enviar notificaci\u00F3n");

		lblNotificar = new JLabel("Notificar a aquellos pacientes que deben retirar sus resultados con valores reservados por sucursal.");
		GroupLayout gl_MasPeticiones = new GroupLayout(MasPeticiones);
		gl_MasPeticiones.setHorizontalGroup(
			gl_MasPeticiones.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_MasPeticiones.createSequentialGroup()
					.addGap(27)
					.addGroup(gl_MasPeticiones.createParallelGroup(Alignment.LEADING)
						.addComponent(btnEnviarNot)
						.addComponent(lblNotificar))
					.addContainerGap(54, Short.MAX_VALUE))
		);
		
		gl_MasPeticiones.setVerticalGroup(
				gl_MasPeticiones.createParallelGroup(Alignment.LEADING)
					.addGroup(gl_MasPeticiones.createSequentialGroup()
						.addGap(25)
						.addComponent(lblNotificar)
						.addGap(18)
						.addComponent(btnEnviarNot)
						.addContainerGap(391, Short.MAX_VALUE))
				);
		MasPeticiones.setLayout(gl_MasPeticiones);
		return MasPeticiones;
	}
	
	
	private void asociarEventos() {
		PeticionController peticionController = PeticionController.getInstance();
		
		btnEnviarNot.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(tabbedPane_5, "Se notific� correctamente", "Informaci�n",
						JOptionPane.INFORMATION_MESSAGE);
			}
		});
		
		btnDeletePet.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String id = tID.getText();
				
				if(!id.isBlank()) {
					boolean borrada = peticionController.BajaPeticion(Integer.parseInt(id));
					
					if(borrada) {
						alert("La peticón se borró correctamente.", "Información", JOptionPane.INFORMATION_MESSAGE);
					}
					else {
						alert("No se pudo eliminar", "Error", JOptionPane.ERROR_MESSAGE);
					}
					
				} else {
					alert("No se reconocen ciertos datos.", "Error", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		
		btnAddPet.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String dni = tDNI.getText();
				String numSucursal = tNumSucursal.getText();
				
				if(!dni.isBlank() && !numSucursal.isBlank()) {
					PacienteController pc = PacienteController.getInstance();
					PacienteDTO p = pc.ObtenerPaciente(Integer.parseInt(dni));
					PeticionDTO peticion = new PeticionDTO();
					peticion.estadoPeticion = EstadoPeticion.Activa;
					peticion.fechaDeCarga = new Date();
					peticion.pacienteID = Integer.parseInt(dni);
					peticion.practicasAsociadas = practicasAsociadas;
					peticion.sucursalID = Integer.parseInt(numSucursal);
					
					if(!p.dni.isBlank()) {						
						peticionController.AltaPeticion(peticion);
						limpiarFormulario();
						alert("Se agregó correctamente.", "Información", JOptionPane.INFORMATION_MESSAGE);
					}
				} else {
					alert("No se reconocen ciertos datos.", "Error", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		
		btnAddPractica.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String nombre = tNombrePractica.getText();
				String grupo = tGrupoPractica.getText();

				if(!nombre.isBlank() && !grupo.isBlank()) {
					dtos.PracticaAsociadaDTO pa = new dtos.PracticaAsociadaDTO();
					PracticaDTO p = new PracticaDTO();
					p.nombre = nombre;
					p.grupo = grupo;
					p.id = practicasAsociadas.size() + 1;
					pa.practicaDTO = p;
					practicasAsociadas.add(pa);
					limpiarPracticas();
				}
			}
		});
		
		btnObtenerPeticiones.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String dni = tDNIPeticiones.getText();
				boolean peticionesCompletas = chckbxPeticionesCompletas.isSelected();
				boolean peticionesPendientes = chckbxPeticionesPendientes.isSelected();
				boolean peticionesCriticas = chckbxPeticionesCriticas.isSelected();
				
				if(!dni.isBlank()) {
					
				}
			}
		});
		
	}
	
    private void alert(String msg, String type, int pane) {
        JOptionPane.showMessageDialog(tabbedPane_5, msg, type, pane);
    }
    
    private void limpiarPracticas() {
    	tNombrePractica.setText("");
    	tGrupoPractica.setText("");
    }
	
    private void limpiarFormulario() {
    	tDNI.setText("");
    	tNumSucursal.setText("");
    	tOB.setText("");
    }
}
