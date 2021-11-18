package views;

import controllers.PacienteController;
import controllers.PeticionController;
import controllers.PracticaController;
import dtos.PacienteDTO;
import dtos.PeticionDTO;
import dtos.PracticaAsociadaDTO;
import dtos.PracticaDTO;
import enums.EstadoPeticion;
import enums.EstadoPractica;
import enums.EstadoResultadoPractica;
import enums.Rol;

import javax.swing.*;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Calendar;
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
	private JCheckBox chckbxPeticionesPendientes;
	private JCheckBox chckbxPeticionesCompletas;
	private JCheckBox chckbxPeticionesCriticas;
	private JTextField tNumSucursal;
	private JLabel lblNumeroSucursal;
	private JButton btnBorrarPractica;
	private JButton btnVerPracticas;
	private JTextArea tPracticasAsociadas;
	private JTextField tIDPractica;

	private List<PracticaAsociadaDTO> practicasAsociadas = new ArrayList<PracticaAsociadaDTO>();
	private List<PeticionDTO> listPeticiones = new ArrayList<PeticionDTO>();
	private List practicas = new ArrayList();

	/**
	 * @wbp.parser.entryPoint
	 */
	public JTabbedPane setPeticionesTab(String rol) {
		tabbedPane_5 = new JTabbedPane(JTabbedPane.LEFT);
		tabbedPane_5.setBackground(Color.WHITE);
		tabbedPane_5.setBounds(100, 100, 629, 476);
		tabbedPane_5.add("Peticiones", setObtenerPeticiones());
		tabbedPane_5.add("Alta", setAltaPeticiones());

		if (rol != Rol.Recepcion.toString()) {
			tabbedPane_5.add("Baja", setBajaPeticiones());
		}

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

		tNumSucursal = new JTextField();
		tNumSucursal.setColumns(10);

		lblNumeroSucursal = new JLabel("NUMERO DE SUCURSAL");

		tIDPractica = new JTextField();
		tIDPractica.setColumns(10);

		JLabel lblIDPractica = new JLabel("ID PRACTICA");

		btnVerPracticas = new JButton("Ver lista");

		btnBorrarPractica = new JButton("Borrar Practica");
		
		tPracticasAsociadas = new JTextArea();
		tPracticasAsociadas.setLineWrap(true);
		tPracticasAsociadas.setWrapStyleWord(true);

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
										.addComponent(lblOB)
										.addComponent(tOB, GroupLayout.PREFERRED_SIZE, 237, GroupLayout.PREFERRED_SIZE)))
								.addGroup(gl_AltaPeticiones.createSequentialGroup()
									.addGroup(gl_AltaPeticiones.createParallelGroup(Alignment.LEADING)
										.addGroup(gl_AltaPeticiones.createSequentialGroup()
											.addGroup(gl_AltaPeticiones.createParallelGroup(Alignment.LEADING)
												.addComponent(btnBorrarPractica, GroupLayout.DEFAULT_SIZE, 133, Short.MAX_VALUE)
												.addComponent(tNumSucursal, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
												.addComponent(lblPracticas, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
												.addComponent(lblIDPractica)
												.addComponent(btnAddPractica, GroupLayout.DEFAULT_SIZE, 133, Short.MAX_VALUE)
												.addComponent(tIDPractica, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
											.addGap(41))
										.addGroup(gl_AltaPeticiones.createSequentialGroup()
											.addComponent(btnVerPracticas)
											.addPreferredGap(ComponentPlacement.RELATED)))
									.addComponent(tPracticasAsociadas, GroupLayout.PREFERRED_SIZE, 309, GroupLayout.PREFERRED_SIZE)
									.addGap(15))
								.addComponent(lblNumeroSucursal)))
						.addGroup(gl_AltaPeticiones.createSequentialGroup()
							.addGap(176)
							.addComponent(btnAddPet, GroupLayout.PREFERRED_SIZE, 186, GroupLayout.PREFERRED_SIZE)))
					.addGap(27))
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
					.addGap(4)
					.addComponent(lblIDPractica)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(tIDPractica, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_AltaPeticiones.createParallelGroup(Alignment.BASELINE)
						.addGroup(gl_AltaPeticiones.createSequentialGroup()
							.addComponent(btnAddPractica)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(btnBorrarPractica)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(btnVerPracticas))
						.addComponent(tPracticasAsociadas, GroupLayout.PREFERRED_SIZE, 87, GroupLayout.PREFERRED_SIZE))
					.addGap(172))
		);
		AltaPeticiones.setLayout(gl_AltaPeticiones);

		return AltaPeticiones;
	}

	private Panel setObtenerPeticiones() {
		Peticiones1 = new Panel();

		JLabel lblPeticiones = new JLabel("Peticiones:");
		JLabel lblObtenerPeticiones = new JLabel(
				"Por favor, ingrese el DNI del paciente para obtener sus peticiones o deje el ID en blanco para obtener todas.");

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

		GroupLayout gl_Peticiones1 = new GroupLayout(Peticiones1);
		gl_Peticiones1.setHorizontalGroup(gl_Peticiones1.createParallelGroup(Alignment.LEADING).addGroup(gl_Peticiones1
				.createSequentialGroup().addGap(31)
				.addGroup(gl_Peticiones1.createParallelGroup(Alignment.LEADING).addGroup(gl_Peticiones1
						.createSequentialGroup()
						.addGroup(gl_Peticiones1.createParallelGroup(Alignment.LEADING)
								.addComponent(tDNIPeticiones, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE)
								.addComponent(lbldni_1))
						.addContainerGap(646, Short.MAX_VALUE))
						.addGroup(gl_Peticiones1.createSequentialGroup()
								.addComponent(btnObtenerPeticiones, GroupLayout.PREFERRED_SIZE, 141,
										GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(ComponentPlacement.RELATED, 53, Short.MAX_VALUE)
								.addGroup(gl_Peticiones1.createParallelGroup(Alignment.LEADING)
										.addComponent(chckbxPeticionesCriticas).addComponent(chckbxPeticionesCompletas)
										.addComponent(chckbxPeticionesPendientes))
								.addGap(146))))
				.addGroup(gl_Peticiones1.createSequentialGroup().addContainerGap().addComponent(lblObtenerPeticiones)
						.addContainerGap(27, Short.MAX_VALUE)));
		gl_Peticiones1.setVerticalGroup(gl_Peticiones1.createParallelGroup(Alignment.LEADING).addGroup(gl_Peticiones1
				.createSequentialGroup().addGap(32).addComponent(lblObtenerPeticiones).addGap(18)
				.addGroup(gl_Peticiones1.createParallelGroup(Alignment.LEADING).addGroup(gl_Peticiones1
						.createSequentialGroup().addGap(18).addComponent(chckbxPeticionesPendientes).addGap(18)
						.addComponent(chckbxPeticionesCompletas).addGap(18).addComponent(chckbxPeticionesCriticas))
						.addGroup(gl_Peticiones1.createSequentialGroup().addGap(15).addComponent(lbldni_1)
								.addPreferredGap(ComponentPlacement.RELATED)
								.addComponent(tDNIPeticiones, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE)
								.addGap(26).addComponent(btnObtenerPeticiones, GroupLayout.PREFERRED_SIZE, 27,
										GroupLayout.PREFERRED_SIZE)))
				.addContainerGap(302, Short.MAX_VALUE)));
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
		gl_BajaPeticiones.setHorizontalGroup(gl_BajaPeticiones.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_BajaPeticiones.createSequentialGroup().addGap(35)
						.addGroup(gl_BajaPeticiones.createParallelGroup(Alignment.LEADING)
								.addComponent(tID, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE)
								.addComponent(lblID).addComponent(lblBaja).addComponent(btnDeletePet,
										GroupLayout.PREFERRED_SIZE, 118, GroupLayout.PREFERRED_SIZE))
						.addContainerGap(251, Short.MAX_VALUE)));
		gl_BajaPeticiones.setVerticalGroup(gl_BajaPeticiones.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_BajaPeticiones.createSequentialGroup().addGap(33).addComponent(lblBaja).addGap(18)
						.addComponent(lblID).addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(tID, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
								GroupLayout.PREFERRED_SIZE)
						.addGap(18).addComponent(btnDeletePet, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
								GroupLayout.PREFERRED_SIZE)
						.addContainerGap(325, Short.MAX_VALUE)));
		BajaPeticiones.setLayout(gl_BajaPeticiones);

		return BajaPeticiones;
	}

	private void asociarEventos() {
		PeticionController peticionController = PeticionController.getInstance();

		if (btnDeletePet != null) {
			btnDeletePet.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					String id = tID.getText();

					if (id.isBlank()) {
						alert("No se reconocen ciertos datos.", "Error", JOptionPane.ERROR_MESSAGE);
						return;
					}

					try {
						peticionController.BajaPeticion(Integer.parseInt(id));
						tID.setText("");
						alert("La petición se borró correctamente.", "Información", JOptionPane.INFORMATION_MESSAGE);
					} catch (Exception ex) {
						alert("La petición no se pudo eliminar (" + ex.getMessage() + ").", "Error",
								JOptionPane.ERROR_MESSAGE);
					}
				}
			});
		}

		btnAddPet.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String dni = tDNI.getText();
				String numSucursal = tNumSucursal.getText();
				String ob = tOB.getText();

				if (dni.isBlank() && numSucursal.isBlank()) {
					alert("No se reconocen ciertos datos.", "Error", JOptionPane.ERROR_MESSAGE);
					return;
				}

				try {
					PeticionDTO peticion = new PeticionDTO();

					peticion.estadoPeticion = EstadoPeticion.Activa;
					peticion.fechaDeCarga = new Date();
					peticion.pacienteID = Integer.parseInt(dni);
					peticion.practicasAsociadas = practicasAsociadas;
					peticion.sucursalID = Integer.parseInt(numSucursal);
					peticion.obraSocial = ob;

					peticionController.AltaPeticion(peticion);
					limpiarFormulario();
					limpiarListas();
					alert("Se agregó correctamente.", "Información", JOptionPane.INFORMATION_MESSAGE);
				} catch (Exception ex) {
					alert("No se reconocen ciertos datos (" + ex.getMessage() + ").", "Error",
							JOptionPane.ERROR_MESSAGE);
				}
			}
		});

		btnBorrarPractica.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String idPractica = tIDPractica.getText();

				if (!idPractica.isBlank()) {
					practicasAsociadas.removeIf(p -> (p.practicaID == Integer.parseInt(idPractica)));
					tIDPractica.setText("");
					alert("La práctica se borró a la lista", "Información", JOptionPane.INFORMATION_MESSAGE);
				}
			}
		});

		btnVerPracticas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//List practicas = new ArrayList();
				//practicasAsociadas.forEach(p -> practicas.add(p.practicaID));
				tPracticasAsociadas.setText(practicas.toString());
			}
		});

		btnAddPractica.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PracticaController practicaController = PracticaController.getInstance();
				String idPractica = tIDPractica.getText();
				
				try {
					PracticaDTO practica = practicaController.ObtenerPractica(Integer.parseInt(idPractica));
					dtos.PracticaAsociadaDTO pa = new dtos.PracticaAsociadaDTO();
					pa.practicaID = Integer.parseInt(idPractica);
					pa.resultado = null;
					practicasAsociadas.add(pa);
					
					Object[] p = {idPractica, practica.nombre};
					
					practicas.add(p);
					tIDPractica.setText("");
					alert("La práctica se agregó a la lista", "Información", JOptionPane.INFORMATION_MESSAGE);
				} catch (Exception ex) {
					alert("La practica no se pudo agregar a la lista (" + ex.getMessage() + ").", "Error",
							JOptionPane.ERROR_MESSAGE);
				}
			}
		});

		btnObtenerPeticiones.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String dni = tDNIPeticiones.getText();
				boolean peticionesCompletas = chckbxPeticionesCompletas.isSelected();
				boolean peticionesPendientes = chckbxPeticionesPendientes.isSelected();
				boolean peticionesCriticas = chckbxPeticionesCriticas.isSelected();

				if (!dni.isBlank() && (peticionesCompletas || peticionesPendientes || peticionesCriticas)) {
					try {
						PacienteController pc = PacienteController.getInstance();
						PacienteDTO p = pc.ObtenerPaciente(Integer.parseInt(dni));

						if (peticionesCompletas) {
							listPeticiones.addAll(peticionController.ObtenerPeticionesCompletasPorPaciente(p.id)); // Enum:
																													// finalizada
						}

						if (peticionesPendientes) {
							listPeticiones.addAll(peticionController.ObtenerPeticionesPendientesPorPaciente(p.id)); // Enum:
																													// activas
						}

						if (peticionesCriticas) {
							listPeticiones.addAll(peticionController.ObtenerPeticionesCriticasPorPaciente(p.id)); // Enum:
																													// RetirarPorSucursal
						}

					} catch (Exception ex) {
						alert("No fue posible obtener la petición (" + ex.getMessage() + ").", "Error",
								JOptionPane.ERROR_MESSAGE);

					}
				} else {
					listPeticiones.addAll(peticionController.ObtenerTodasLasPeticiones());
				}

				mostrarPeticionesYPracticas();
				listPeticiones.clear();
			}
		});

		tabbedPane_5.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				limpiarFormulario();
			}
		});

	}

	private void mostrarPeticionesYPracticas() {
		try {
			if (listPeticiones.size() == 0) {
				alert("No hay peticiones.", "Información", JOptionPane.INFORMATION_MESSAGE);
				return;
			}

			PeticionesYPracticas f = new PeticionesYPracticas(listPeticiones);
			f.setVisible(true);
		} catch (Exception ex) {
			alert("No fue posible obtener la petición (" + ex.getMessage() + ").", "Error", JOptionPane.ERROR_MESSAGE);
		}

	}

	private void alert(String msg, String type, int pane) {
		JOptionPane.showMessageDialog(tabbedPane_5, msg, type, pane);
	}

	private void limpiarListas() {
		practicasAsociadas.clear();
	}

	private void limpiarFormulario() {
		tDNI.setText("");
		tNumSucursal.setText("");
		tOB.setText("");
		tIDPractica.setText("");
		tPracticasAsociadas.setText("");
	}
}
