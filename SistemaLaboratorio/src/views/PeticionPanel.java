package views;

import controllers.PacienteController;
import controllers.PeticionController;
import controllers.PracticaController;
import dtos.PacienteDTO;
import dtos.PeticionDTO;
import dtos.PracticaAsociadaDTO;
import dtos.PracticaDTO;
import enums.EstadoPeticion;
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
import java.util.Date;
import java.util.List;
import java.util.Objects;

public class PeticionPanel {

	private JTabbedPane tabbedPane_5;
	private Panel Peticiones1;
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
	private Panel ModificarPeticiones;
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
	private JTextField tIDPeticionMod;
	private JTextField tIDPacienteMod;
	private JTextField tOBMod;
	private JTextField tIDSucursalMod;
	private JTextField tIDPracticaMod;
	private JButton btnObtnerPeticionMod;
	private JButton btnUpdatePeticionMod;
	private JTextArea textAreaPracticasAsociadas;
	private JButton btnAddPracticaMod;
	private JButton btnDeletePracticaMod;


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
		tabbedPane_5.add("Modificar Petición", setModificarPeticion());

		if (rol != Rol.Recepcion.toString()) {
			tabbedPane_5.add("Baja", setBajaPeticiones());
		}

		asociarEventos();

		return tabbedPane_5;
	}
	
	private Panel setModificarPeticion() {
		ModificarPeticiones = new Panel();
		
		JLabel lblNewLabel = new JLabel("Para modifcar una petición, ingrese su ID y clickee en obtener petición.");
		
		btnObtnerPeticionMod = new JButton("Obtener Petición");
		
		btnUpdatePeticionMod = new JButton("Modificar petición");
		
		tIDPeticionMod = new JTextField();
		tIDPeticionMod.setColumns(10);
		
		JLabel lblIDPeticion = new JLabel("ID PETICION");
		
		tIDPacienteMod = new JTextField();
		tIDPacienteMod.setColumns(10);
		
		JLabel lblIDPaciente = new JLabel("ID PACIENTE");
		
		JLabel lblNewLabel_1 = new JLabel("OBRA SOCIAL");
		
		tOBMod = new JTextField();
		tOBMod.setColumns(10);
		
		tIDSucursalMod = new JTextField();
		tIDSucursalMod.setColumns(10);
		
		JLabel lblIDSucursal = new JLabel("ID SUCURSAL");
		
		textAreaPracticasAsociadas = new JTextArea();
		textAreaPracticasAsociadas.setWrapStyleWord(true);
		textAreaPracticasAsociadas.setLineWrap(true);
		textAreaPracticasAsociadas.setBackground(SystemColor.inactiveCaptionBorder);
		
		btnAddPracticaMod = new JButton("Agregar practica");
		
		btnDeletePracticaMod = new JButton("Borrar practica");
		
		tIDPracticaMod = new JTextField();
		tIDPracticaMod.setColumns(10);
		
		JLabel lblIDPractica = new JLabel("ID PRACTICA:");
		GroupLayout gl_ModificarPeticiones = new GroupLayout(ModificarPeticiones);
		gl_ModificarPeticiones.setHorizontalGroup(
			gl_ModificarPeticiones.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_ModificarPeticiones.createSequentialGroup()
					.addGap(34)
					.addGroup(gl_ModificarPeticiones.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_ModificarPeticiones.createParallelGroup(Alignment.TRAILING)
							.addGroup(gl_ModificarPeticiones.createSequentialGroup()
								.addComponent(btnObtnerPeticionMod)
								.addPreferredGap(ComponentPlacement.RELATED)
								.addComponent(btnUpdatePeticionMod))
							.addComponent(lblNewLabel))
						.addGroup(gl_ModificarPeticiones.createParallelGroup(Alignment.LEADING)
							.addGroup(gl_ModificarPeticiones.createSequentialGroup()
								.addComponent(tIDPeticionMod, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addGap(18)
								.addComponent(tIDPacienteMod, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addGap(18)
								.addComponent(tOBMod, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(ComponentPlacement.UNRELATED)
								.addComponent(tIDSucursalMod, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addComponent(textAreaPracticasAsociadas, GroupLayout.PREFERRED_SIZE, 437, GroupLayout.PREFERRED_SIZE)
							.addGroup(gl_ModificarPeticiones.createSequentialGroup()
								.addGroup(gl_ModificarPeticiones.createParallelGroup(Alignment.LEADING)
									.addGroup(gl_ModificarPeticiones.createSequentialGroup()
										.addComponent(lblIDPractica)
										.addGap(18)
										.addComponent(tIDPracticaMod, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(ComponentPlacement.UNRELATED)
										.addComponent(btnAddPracticaMod))
									.addGroup(gl_ModificarPeticiones.createSequentialGroup()
										.addComponent(lblIDPeticion)
										.addGap(46)
										.addComponent(lblIDPaciente)
										.addGap(37)
										.addComponent(lblNewLabel_1)))
								.addPreferredGap(ComponentPlacement.UNRELATED)
								.addGroup(gl_ModificarPeticiones.createParallelGroup(Alignment.LEADING)
									.addComponent(lblIDSucursal)
									.addComponent(btnDeletePracticaMod)))))
					.addContainerGap(54, Short.MAX_VALUE))
		);
		gl_ModificarPeticiones.setVerticalGroup(
			gl_ModificarPeticiones.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_ModificarPeticiones.createSequentialGroup()
					.addGap(19)
					.addGroup(gl_ModificarPeticiones.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnUpdatePeticionMod)
						.addComponent(btnObtnerPeticionMod))
					.addGap(18)
					.addComponent(lblNewLabel)
					.addGap(12)
					.addGroup(gl_ModificarPeticiones.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblIDPeticion)
						.addComponent(lblIDPaciente)
						.addComponent(lblNewLabel_1)
						.addComponent(lblIDSucursal))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_ModificarPeticiones.createParallelGroup(Alignment.BASELINE)
						.addComponent(tIDPeticionMod, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(tIDPacienteMod, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(tOBMod, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(tIDSucursalMod, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_ModificarPeticiones.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnDeletePracticaMod)
						.addComponent(btnAddPracticaMod)
						.addComponent(tIDPracticaMod, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblIDPractica))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(textAreaPracticasAsociadas, GroupLayout.PREFERRED_SIZE, 230, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(75, Short.MAX_VALUE))
		);
		ModificarPeticiones.setLayout(gl_ModificarPeticiones);
		
		return ModificarPeticiones;
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
		tPracticasAsociadas.setColumns(2);
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
										.addComponent(btnVerPracticas)
										.addComponent(lblNumeroSucursal))
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(tPracticasAsociadas, GroupLayout.PREFERRED_SIZE, 309, GroupLayout.PREFERRED_SIZE)
									.addGap(82))))
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
					.addGroup(gl_AltaPeticiones.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_AltaPeticiones.createSequentialGroup()
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
							.addComponent(btnAddPractica)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(btnBorrarPractica)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(btnVerPracticas)
							.addGap(0))
						.addGroup(gl_AltaPeticiones.createSequentialGroup()
							.addGap(35)
							.addComponent(tPracticasAsociadas, GroupLayout.DEFAULT_SIZE, 214, Short.MAX_VALUE)
							.addContainerGap())))
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

					if (!Objects.isNull(practicasAsociadas)) {
						peticion.practicasAsociadas = practicasAsociadas;
					} else {
						peticion.practicasAsociadas = new ArrayList<>();
					}
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
				PracticaController practicaController = PracticaController.getInstance();
				tPracticasAsociadas.setText("");
				for (dtos.PracticaAsociadaDTO o : practicasAsociadas){
					try {
						PracticaDTO practica = practicaController.ObtenerPractica(o.practicaID);
						tPracticasAsociadas.append("ID: " + practica.id + " Nombre: " + practica.nombre + "\n");
					} catch (Exception ex) {
						alert("No se puede ver la lista: (" + ex.getMessage() + ").", "Error",
								JOptionPane.ERROR_MESSAGE);
					}
				}
			}
		});

		btnAddPractica.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String idPractica = tIDPractica.getText();
				addPractica(Integer.parseInt(idPractica));
			}
		});

		btnObtenerPeticiones.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String dni = tDNIPeticiones.getText();
				boolean peticionesCompletas = chckbxPeticionesCompletas.isSelected();
				boolean peticionesPendientes = chckbxPeticionesPendientes.isSelected();
				boolean peticionesCriticas = chckbxPeticionesCriticas.isSelected();
				PacienteController pc = PacienteController.getInstance();


				if (!dni.isBlank()) {
					try {
						PacienteDTO p = pc.ObtenerPaciente(Integer.parseInt(dni));
						if (peticionesCompletas || peticionesPendientes || peticionesCriticas) {

							if (peticionesCompletas) {
								listPeticiones.addAll(peticionController.ObtenerPeticionesCompletasPorPaciente(p.id)); // Enum: finalizada
							}

							if (peticionesPendientes) {
								listPeticiones.addAll(peticionController.ObtenerPeticionesPendientesPorPaciente(p.id)); // Enum: activas
							}

							if (peticionesCriticas) {
								listPeticiones.addAll(peticionController.ObtenerPeticionesCriticasPorPaciente(p.id)); // Enum: RetirarPorSucursal
							}
						} else {
							listPeticiones.addAll(peticionController.ObtenerPeticionesDelPaciente(p.id));
						}
					} catch (Exception ex) {
						alert("No fue posible obtener la petición (" + ex.getMessage() + ").", "Error",
								JOptionPane.ERROR_MESSAGE);
					}
				}

				if (dni.isBlank()) {
					if (peticionesCompletas || peticionesPendientes || peticionesCriticas) {
						try {
							if (peticionesCompletas) {
								listPeticiones.addAll(peticionController.ObtenerPeticionesFinalizadas()); // Enum: finalizada
							}

							if (peticionesPendientes) {
								listPeticiones.addAll(peticionController.ObtenerPeticionesPendientes()); // Enum: activas
							}

							if (peticionesCriticas) {
								listPeticiones.addAll(peticionController.ObtenerPeticionesCriticas()); // Enum: RetirarPorSucursal
							}

						} catch (Exception ex) {
							alert("No fue posible obtener la petición (" + ex.getMessage() + ").", "Error",
									JOptionPane.ERROR_MESSAGE);
						}
					} else {
						listPeticiones.addAll(peticionController.ObtenerTodasLasPeticiones());
					}
				}

				mostrarPeticionesYPracticas();
				listPeticiones.clear();
			}
		});

		btnObtnerPeticionMod.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String id = tIDPeticionMod.getText();
				
				try {
					practicasAsociadas.clear();
					PeticionDTO p = peticionController.ObtenerPeticion(Integer.parseInt(id));

					tIDPacienteMod.setText(String.valueOf(p.pacienteID));
					tIDSucursalMod.setText(String.valueOf(p.sucursalID));
					tOBMod.setText(String.valueOf(p.obraSocial));
					tIDPeticionMod.setEnabled(false);
					practicasAsociadas.addAll(p.practicasAsociadas);

					SetearTextArea(false);
				} catch (Exception ex) {
					alert("La practica no se pudo obtener la petición: (" + ex.getMessage() + ").", "Error",
							JOptionPane.ERROR_MESSAGE);
				}
				
			}
		});
		
		btnAddPracticaMod.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String idPractica = tIDPracticaMod.getText();
				addPractica(Integer.parseInt(idPractica));
				SetearTextArea(false);
			}
		});
		
		btnDeletePracticaMod.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String idPractica = tIDPracticaMod.getText();

				if (!idPractica.isBlank()) {
					deletePractica(Integer.parseInt(idPractica));
					tIDPracticaMod.setText("");
				}
			}
		});
		
		btnUpdatePeticionMod.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String id = tIDPeticionMod.getText();
				String idPaciente = tIDPacienteMod.getText();
				String idSucursal = tIDSucursalMod.getText();
				String ob = tOBMod.getText();
				
				PeticionDTO p = new PeticionDTO();
				p.id = Integer.parseInt(id);
				p.pacienteID = Integer.parseInt(idPaciente);
				p.sucursalID = Integer.parseInt(idSucursal);
				p.obraSocial = ob;
				p.fechaDeCarga = new Date();
				p.practicasAsociadas = practicasAsociadas;
				
				try {
					peticionController.ModificarPeticion(p);
					limpiarListas();
					limpiarFormulario();
					alert("Se modificó correctamente.", "Información", JOptionPane.INFORMATION_MESSAGE);
				} catch (Exception ex) {
					alert("La practica no se pudo modificar la petición: (" + ex.getMessage() + ").", "Error",
							JOptionPane.ERROR_MESSAGE);
				}				
				
			}
		});
		
		tabbedPane_5.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				limpiarFormulario();
				limpiarListas();
			}
		});

	}
	
	private void SetearTextArea(Boolean tabAlta) {
		PracticaController practicaController = PracticaController.getInstance();
		
		textAreaPracticasAsociadas.setText("");		
		tPracticasAsociadas.setText("");
		
		for (dtos.PracticaAsociadaDTO o : practicasAsociadas){
			try {
				PracticaDTO practica = practicaController.ObtenerPractica(o.practicaID);
				
				if(tabAlta) {
					tPracticasAsociadas.append("ID: " + practica.id + " Nombre: " + practica.nombre + "\n");
				}else {
					textAreaPracticasAsociadas.append("ID: " + practica.id + " Nombre: " + practica.nombre + "\n");
				}

			} catch (Exception ex) {
				alert("No se puede ver la lista: (" + ex.getMessage() + ").", "Error",
						JOptionPane.ERROR_MESSAGE);
			}
		}
	}
	
	private void deletePractica(int id) {
		practicasAsociadas.removeIf(p -> (p.practicaID == id));
		alert("La práctica se borró a la lista", "Información", JOptionPane.INFORMATION_MESSAGE);
	}
	
	private void addPractica(int id) {
		try {
			PracticaController practicaController = PracticaController.getInstance();
			dtos.PracticaAsociadaDTO pa = new dtos.PracticaAsociadaDTO();

			practicaController.ObtenerPractica(id);

			pa.practicaID = id;
			pa.resultado = null;

			boolean existe = false;
			for (PracticaAsociadaDTO actualPA : practicasAsociadas){
				if (actualPA.practicaID == pa.practicaID){
					existe = true;
				}
			}

			if (!existe){
				practicasAsociadas.add(pa);
			}
			tIDPractica.setText("");
			tIDPracticaMod.setText("");
			alert("La práctica se agregó a la lista", "Información", JOptionPane.INFORMATION_MESSAGE);
		} catch (Exception ex) {
			alert("La practica no se pudo agregar a la lista (" + ex.getMessage() + ").", "Error",
					JOptionPane.ERROR_MESSAGE);
		}
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
		tIDPacienteMod.setText("");
		tIDSucursalMod.setText("");
		tOBMod.setText("");
		tIDPeticionMod.setEnabled(true);
		textAreaPracticasAsociadas.setText("");		
		tPracticasAsociadas.setText("");
		tIDPeticionMod.setText("");
	}
}
