package views;

import controllers.PeticionController;
import controllers.PracticaController;
import dtos.PeticionDTO;
import dtos.PracticaAsociadaDTO;
import dtos.PracticaDTO;
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
import java.util.List;

public class PracticasPanel {

	private JTabbedPane tabbedPane_4;
	private Button btnObtenerPractica1;
	private Button btnAgregarPractica;
	private JLabel lblID;
	private JTextField tid;
	private JTextField tid1;
	private JTextField tNombre;
	private JTextField tNombre1;
	private JTextField tValCriticoMax;
	private JTextField tValCriticoMax1;
	private JLabel lblValCriticoMax;
	private Panel Baja;
	private Button btnDelete;
	private JTextField tID;
	private JLabel lbldni;
	private JLabel lblBaja;
	private JTextField tValCriticoMin;
	private JTextField tValCriticoMin1;
	private JTextField tValReservadoMax;
	private JTextField tValReservadoMax1;
	private JTextField tValReservadoMin;
	private JTextField tValReservadoMin1;
	private JLabel lblPractica;
	private JLabel lblValReservadoMax;
	private JLabel lblValReservadoMin;
	private JLabel lblGrupo;
	private JTextField tGrupo;
	private JTextField tGrupo1;
	private JLabel lblTiempoEstimado;
	private JLabel lblTiempo;
	private JRadioButton rdbtnPendiente;
	private JButton btnUpdatePractica;
	private JButton btnUpdatePeticion;
	private JButton btnLimpiar;
	private JButton btnLimpiar1;
	private JTextField tPeticionID;
	private JRadioButton rdbtnNormal;
	private JRadioButton rdbtnCritico;
	private JRadioButton rdbtnReservado;
	private JLabel lblHabilitacion;
	private JLabel lblHabliticacion_1;
	private EstadoResultadoPractica estado;
	private JTextField tResultado;
	private JButton btnObtenerPeticiones;
	private List<PracticaAsociadaDTO> practicasAsociadas = new ArrayList<PracticaAsociadaDTO>();
	private List<PeticionDTO> listPeticiones = new ArrayList<PeticionDTO>();
	private JTabbedPane AgregarResultado;
	private JTextField tTiempo;
	private JCheckBox chckbxHabilitada;
	private Button btnObtenerPracticaAlta;

	/**
	 * @wbp.parser.entryPoint
	 */
	public JTabbedPane setPracticasTab(String r) {
		tabbedPane_4 = new JTabbedPane(JTabbedPane.LEFT);
		tabbedPane_4.setBackground(Color.WHITE);
		tabbedPane_4.setBounds(100, 100, 629, 476);
		tabbedPane_4.addTab("Alta Resultado", setAltaResultado());

		if (r != Rol.Laboratista.toString()) {
			tabbedPane_4.add("Alta", setAltaPractica());
			tabbedPane_4.add("Baja", setBajaPractica());
		}

		asociarEventos();

		return tabbedPane_4;
	}

	private Panel setBajaPractica() {
		Baja = new Panel();

		btnDelete = new Button("Eliminar Práctica");
		btnDelete.setActionCommand("Eliminar Usuario");
		btnDelete.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnDelete.setForeground(Color.WHITE);
		btnDelete.setBackground(Color.RED);
		btnDelete.setBounds(230, 174, 50, 27);

		tID = new JTextField();
		tID.setColumns(10);

		lbldni = new JLabel("ID");

		lblBaja = new JLabel("Por favor, ingrese el ID de la petición y su practica asociada que desea inhabililar.");

		// Layout
		GroupLayout gl_Baja = new GroupLayout(Baja);
		gl_Baja.setHorizontalGroup(gl_Baja.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_Baja.createSequentialGroup().addGap(35)
						.addGroup(gl_Baja.createParallelGroup(Alignment.LEADING).addComponent(lblBaja)
								.addComponent(btnDelete, GroupLayout.PREFERRED_SIZE, 140, GroupLayout.PREFERRED_SIZE)
								.addGroup(gl_Baja.createParallelGroup(Alignment.LEADING)
										.addComponent(tID, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
												GroupLayout.PREFERRED_SIZE)
										.addComponent(lbldni)))
						.addContainerGap(120, Short.MAX_VALUE)));
		gl_Baja.setVerticalGroup(gl_Baja.createParallelGroup(Alignment.LEADING).addGroup(gl_Baja.createSequentialGroup()
				.addGap(22).addComponent(lblBaja).addPreferredGap(ComponentPlacement.UNRELATED).addComponent(lbldni)
				.addGap(4)
				.addComponent(tID, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
				.addPreferredGap(ComponentPlacement.UNRELATED)
				.addComponent(btnDelete, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
				.addContainerGap(351, Short.MAX_VALUE)));
		Baja.setLayout(gl_Baja);

		return Baja;
	}

	private JPanel setAltaResultado() {
		JPanel AltaResultado = new JPanel(false);
		AltaResultado.setBackground(Color.WHITE);

		btnObtenerPractica1 = new Button("Obtener Practica");
		btnObtenerPractica1.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnObtenerPractica1.setForeground(Color.WHITE);
		btnObtenerPractica1.setBackground(new Color(133, 189, 212));
		btnObtenerPractica1.setBounds(230, 174, 150, 27);

		tid1 = new JTextField();
		tid1.setFont(new Font("Tahoma", Font.PLAIN, 11));
		tid1.setSize(190, 20);
		tid1.setLocation(200, 100);

		lblID = new JLabel("ID");
		lblID.setForeground(SystemColor.windowText);
		lblID.setFont(new Font("Tahoma", Font.PLAIN, 11));

		JLabel lblNombre = new JLabel("NOMBRE");

		tNombre1 = new JTextField();
		tNombre1.setEditable(false);
		tNombre1.setColumns(10);

		tValCriticoMax1 = new JTextField();
		tValCriticoMax1.setEditable(false);
		tValCriticoMax1.setColumns(10);

		lblValCriticoMax = new JLabel("VALOR CRITICO MAX");

		JLabel lblValCriticoMin = new JLabel("VALOR CRITICO MIN");

		tValCriticoMin1 = new JTextField();
		tValCriticoMin1.setEditable(false);
		tValCriticoMin1.setText("");
		tValCriticoMin1.setColumns(10);

		tValReservadoMax1 = new JTextField();
		tValReservadoMax1.setEditable(false);
		tValReservadoMax1.setHorizontalAlignment(SwingConstants.LEFT);
		tValReservadoMax1.setForeground(Color.BLACK);
		tValReservadoMax1.setColumns(10);

		tValReservadoMin1 = new JTextField();
		tValReservadoMin1.setEditable(false);
		tValReservadoMin1.setHorizontalAlignment(SwingConstants.LEFT);
		tValReservadoMin1.setForeground(Color.BLACK);
		tValReservadoMin1.setColumns(10);

		rdbtnPendiente = new JRadioButton("Pendiente");
		rdbtnPendiente.setEnabled(false);
		rdbtnPendiente.setBackground(Color.WHITE);

		JLabel lblRol = new JLabel("ESTADO DE LA PRACTICA:");

		lblPractica = new JLabel(
				"Ingrese el ID de la peticion y de la practica para obtener una practica y agregar el resultado:");

		lblValReservadoMax = new JLabel("VALOR RESERVADO MAX");

		lblValReservadoMin = new JLabel("VALOR RESERVADO MIN");

		lblGrupo = new JLabel("GRUPO");

		tGrupo1 = new JTextField();
		tGrupo1.setEditable(false);
		tGrupo1.setColumns(10);

		lblTiempoEstimado = new JLabel("TIEMPO ESTIMADO");

		lblTiempo = new JLabel("N/A");

		btnUpdatePeticion = new JButton("Modifcar peticón");

		btnUpdatePeticion.setEnabled(true);

		btnLimpiar1 = new JButton("Limpiar formulario");

		tPeticionID = new JTextField();
		tPeticionID.setColumns(10);

		JLabel lblPeticion = new JLabel("ID PETICION");

		rdbtnNormal = new JRadioButton("Normal");
		rdbtnNormal.setEnabled(false);
		rdbtnNormal.setBackground(Color.WHITE);

		rdbtnCritico = new JRadioButton("Critico");
		rdbtnCritico.setEnabled(false);
		rdbtnCritico.setBackground(Color.WHITE);

		rdbtnReservado = new JRadioButton("Reservado");
		rdbtnReservado.setEnabled(false);
		rdbtnReservado.setBackground(Color.WHITE);

		lblHabilitacion = new JLabel("Está habilitada: ");

		lblHabliticacion_1 = new JLabel("NO");

		JLabel lblResultado = new JLabel("RESULTADO DE LA PRACTICA");

		tResultado = new JTextField();
		tResultado.setColumns(10);

		btnObtenerPeticiones = new JButton("Obtener todas las peticiones");

		// Layout
		GroupLayout gl_AltaResultado = new GroupLayout(AltaResultado);
		gl_AltaResultado.setHorizontalGroup(gl_AltaResultado.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_AltaResultado.createSequentialGroup().addGap(31)
						.addGroup(gl_AltaResultado.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_AltaResultado.createSequentialGroup().addComponent(btnUpdatePeticion)
										.addPreferredGap(ComponentPlacement.RELATED).addComponent(btnLimpiar1)
										.addPreferredGap(ComponentPlacement.UNRELATED).addComponent(
												btnObtenerPeticiones, GroupLayout.PREFERRED_SIZE, 182,
												GroupLayout.PREFERRED_SIZE)
										.addContainerGap())
								.addGroup(gl_AltaResultado.createParallelGroup(Alignment.LEADING)
										.addGroup(gl_AltaResultado.createSequentialGroup().addComponent(lblRol)
												.addGap(18).addComponent(rdbtnPendiente)
												.addPreferredGap(ComponentPlacement.UNRELATED).addComponent(rdbtnNormal)
												.addPreferredGap(ComponentPlacement.RELATED).addComponent(rdbtnCritico)
												.addPreferredGap(ComponentPlacement.RELATED)
												.addComponent(rdbtnReservado).addGap(165))
										.addGroup(gl_AltaResultado.createSequentialGroup().addGroup(gl_AltaResultado
												.createParallelGroup(Alignment.LEADING).addComponent(lblPractica)
												.addGroup(gl_AltaResultado.createSequentialGroup()
														.addGroup(gl_AltaResultado
																.createParallelGroup(Alignment.LEADING)
																.addGroup(gl_AltaResultado.createSequentialGroup()
																		.addGroup(gl_AltaResultado
																				.createParallelGroup(Alignment.TRAILING)
																				.addComponent(tNombre1,
																						Alignment.LEADING,
																						GroupLayout.DEFAULT_SIZE, 264,
																						Short.MAX_VALUE)
																				.addGroup(gl_AltaResultado
																						.createSequentialGroup()
																						.addGroup(gl_AltaResultado
																								.createParallelGroup(
																										Alignment.LEADING,
																										false)
																								.addComponent(
																										lblValCriticoMax,
																										GroupLayout.DEFAULT_SIZE,
																										GroupLayout.DEFAULT_SIZE,
																										Short.MAX_VALUE)
																								.addComponent(
																										tValCriticoMax1)
																								.addComponent(
																										lblValReservadoMax,
																										GroupLayout.DEFAULT_SIZE,
																										GroupLayout.DEFAULT_SIZE,
																										Short.MAX_VALUE)
																								.addComponent(
																										tValReservadoMax1))
																						.addGap(18)
																						.addGroup(gl_AltaResultado
																								.createParallelGroup(
																										Alignment.LEADING)
																								.addGroup(
																										gl_AltaResultado
																												.createParallelGroup(
																														Alignment.LEADING)
																												.addComponent(
																														tValCriticoMin1,
																														GroupLayout.DEFAULT_SIZE,
																														126,
																														Short.MAX_VALUE)
																												.addComponent(
																														lblValCriticoMin,
																														GroupLayout.DEFAULT_SIZE,
																														126,
																														Short.MAX_VALUE)
																												.addComponent(
																														tValReservadoMin1,
																														GroupLayout.DEFAULT_SIZE,
																														126,
																														Short.MAX_VALUE))
																								.addComponent(
																										lblValReservadoMin))))
																		.addGap(18))
																.addGroup(gl_AltaResultado.createSequentialGroup()
																		.addComponent(lblNombre).addGap(232)))
														.addGroup(gl_AltaResultado
																.createParallelGroup(Alignment.LEADING, false)
																.addComponent(lblGrupo)
																.addComponent(tGrupo1, GroupLayout.DEFAULT_SIZE, 176,
																		Short.MAX_VALUE)
																.addGroup(gl_AltaResultado.createSequentialGroup()
																		.addGroup(gl_AltaResultado
																				.createParallelGroup(Alignment.LEADING)
																				.addComponent(lblTiempoEstimado)
																				.addComponent(lblHabilitacion))
																		.addPreferredGap(ComponentPlacement.UNRELATED)
																		.addGroup(gl_AltaResultado
																				.createParallelGroup(Alignment.LEADING)
																				.addComponent(lblHabliticacion_1)
																				.addComponent(lblTiempo)))
																.addComponent(lblResultado).addComponent(tResultado))
														.addGap(53)))
												.addGap(75))
										.addGroup(gl_AltaResultado.createSequentialGroup().addGroup(gl_AltaResultado
												.createParallelGroup(Alignment.LEADING)
												.addGroup(gl_AltaResultado.createSequentialGroup()
														.addComponent(lblID, GroupLayout.DEFAULT_SIZE,
																GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
														.addGap(18))
												.addGroup(gl_AltaResultado.createSequentialGroup()
														.addComponent(tid1, GroupLayout.DEFAULT_SIZE, 19,
																Short.MAX_VALUE)
														.addPreferredGap(ComponentPlacement.UNRELATED)))
												.addGroup(gl_AltaResultado.createParallelGroup(Alignment.LEADING)
														.addComponent(tPeticionID, GroupLayout.PREFERRED_SIZE, 51,
																GroupLayout.PREFERRED_SIZE)
														.addComponent(lblPeticion))
												.addGap(495)))))
				.addGroup(gl_AltaResultado.createSequentialGroup().addGap(160)
						.addComponent(btnObtenerPractica1, GroupLayout.PREFERRED_SIZE, 227, GroupLayout.PREFERRED_SIZE)
						.addContainerGap(230, Short.MAX_VALUE)));
		gl_AltaResultado.setVerticalGroup(gl_AltaResultado.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_AltaResultado.createSequentialGroup().addGap(23)
						.addComponent(btnObtenerPractica1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
								GroupLayout.PREFERRED_SIZE)
						.addGap(18).addComponent(lblPractica).addPreferredGap(ComponentPlacement.RELATED)
						.addGroup(gl_AltaResultado
								.createParallelGroup(Alignment.BASELINE).addComponent(lblPeticion).addComponent(lblID))
						.addPreferredGap(ComponentPlacement.RELATED)
						.addGroup(gl_AltaResultado.createParallelGroup(Alignment.BASELINE)
								.addComponent(tid1, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE)
								.addComponent(tPeticionID, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE))
						.addPreferredGap(ComponentPlacement.RELATED)
						.addGroup(gl_AltaResultado
								.createParallelGroup(Alignment.BASELINE).addComponent(lblNombre).addComponent(lblGrupo))
						.addPreferredGap(ComponentPlacement.RELATED)
						.addGroup(gl_AltaResultado.createParallelGroup(Alignment.BASELINE)
								.addComponent(tNombre1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE)
								.addComponent(tGrupo1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE))
						.addPreferredGap(ComponentPlacement.UNRELATED)
						.addGroup(gl_AltaResultado.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblValCriticoMax).addComponent(lblValCriticoMin)
								.addComponent(lblTiempoEstimado).addComponent(lblTiempo))
						.addPreferredGap(ComponentPlacement.RELATED)
						.addGroup(gl_AltaResultado.createParallelGroup(Alignment.BASELINE)
								.addComponent(tValCriticoMax1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE)
								.addComponent(tValCriticoMin1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE)
								.addComponent(lblHabilitacion).addComponent(lblHabliticacion_1))
						.addGap(14)
						.addGroup(gl_AltaResultado
								.createParallelGroup(Alignment.BASELINE).addComponent(lblValReservadoMax)
								.addComponent(lblValReservadoMin).addComponent(lblResultado))
						.addPreferredGap(ComponentPlacement.RELATED)
						.addGroup(gl_AltaResultado.createParallelGroup(Alignment.BASELINE)
								.addComponent(tValReservadoMax1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE)
								.addComponent(tValReservadoMin1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE)
								.addComponent(tResultado, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE))
						.addGap(18)
						.addGroup(gl_AltaResultado.createParallelGroup(Alignment.BASELINE).addComponent(lblRol)
								.addComponent(rdbtnPendiente).addComponent(rdbtnNormal).addComponent(rdbtnCritico)
								.addComponent(rdbtnReservado))
						.addPreferredGap(ComponentPlacement.UNRELATED)
						.addGroup(
								gl_AltaResultado.createParallelGroup(Alignment.BASELINE).addComponent(btnUpdatePeticion)
										.addComponent(btnLimpiar1).addComponent(btnObtenerPeticiones))
						.addContainerGap(124, Short.MAX_VALUE)));
		AltaResultado.setLayout(gl_AltaResultado);

		AltaResultado.setVisible(true);
		return AltaResultado;
	}

	private JPanel setAltaPractica() {
		JPanel Alta = new JPanel(false);
		Alta.setBackground(Color.WHITE);

		btnAgregarPractica = new Button("Agregar Practica");
		btnAgregarPractica.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnAgregarPractica.setForeground(Color.WHITE);
		btnAgregarPractica.setBackground(new Color(133, 189, 212));
		btnAgregarPractica.setBounds(230, 174, 150, 27);

		tid = new JTextField();
		tid.setFont(new Font("Tahoma", Font.PLAIN, 11));
		tid.setSize(190, 20);
		tid.setLocation(200, 100);

		lblID = new JLabel("ID");
		lblID.setForeground(SystemColor.windowText);
		lblID.setFont(new Font("Tahoma", Font.PLAIN, 11));

		JLabel lblNombre = new JLabel("NOMBRE");

		tNombre = new JTextField();
		tNombre.setColumns(10);

		tValCriticoMax = new JTextField();
		tValCriticoMax.setColumns(10);

		lblValCriticoMax = new JLabel("VALOR CRITICO MAX");

		JLabel lblValCriticoMin = new JLabel("VALOR CRITICO MIN");

		tValCriticoMin = new JTextField();
		tValCriticoMin.setText("");
		tValCriticoMin.setColumns(10);

		tValReservadoMax = new JTextField();
		tValReservadoMax.setHorizontalAlignment(SwingConstants.LEFT);
		tValReservadoMax.setForeground(Color.BLACK);
		tValReservadoMax.setColumns(10);

		tValReservadoMin = new JTextField();
		tValReservadoMin.setHorizontalAlignment(SwingConstants.LEFT);
		tValReservadoMin.setForeground(Color.BLACK);
		tValReservadoMin.setColumns(10);

		lblPractica = new JLabel(
				"Ingrese el ID de una practica para modificarla o deje ese campo vacio para agregarla.");

		lblValReservadoMax = new JLabel("VALOR RESERVADO MAX");

		lblValReservadoMin = new JLabel("VALOR RESERVADO MIN");

		lblGrupo = new JLabel("GRUPO");

		tGrupo = new JTextField();
		tGrupo.setColumns(10);

		lblTiempoEstimado = new JLabel("TIEMPO ESTIMADO");

		btnUpdatePractica = new JButton("Modifcar práctica");
		btnUpdatePractica.setEnabled(false);

		btnLimpiar = new JButton("Limpiar formulario");

		tTiempo = new JTextField();
		tTiempo.setColumns(10);

		chckbxHabilitada = new JCheckBox("Habilitada");
		chckbxHabilitada.setBackground(Color.WHITE);

		btnObtenerPracticaAlta = new Button("Obtener Practica");
		btnObtenerPracticaAlta.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnObtenerPracticaAlta.setForeground(Color.WHITE);
		btnObtenerPracticaAlta.setBackground(new Color(133, 189, 212));
		btnObtenerPracticaAlta.setBounds(230, 174, 150, 27);

		// Layout
		GroupLayout gl_Alta = new GroupLayout(Alta);
		gl_Alta.setHorizontalGroup(gl_Alta.createParallelGroup(Alignment.LEADING).addGroup(gl_Alta
				.createSequentialGroup().addGap(31)
				.addGroup(gl_Alta.createParallelGroup(Alignment.LEADING).addGroup(gl_Alta.createSequentialGroup()
						.addGap(37)
						.addComponent(btnAgregarPractica, GroupLayout.PREFERRED_SIZE, 167, GroupLayout.PREFERRED_SIZE)
						.addGap(18)
						.addComponent(btnObtenerPracticaAlta, GroupLayout.PREFERRED_SIZE, 147,
								GroupLayout.PREFERRED_SIZE)
						.addContainerGap())
						.addGroup(gl_Alta.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_Alta.createSequentialGroup().addComponent(btnUpdatePractica)
										.addPreferredGap(ComponentPlacement.RELATED).addComponent(btnLimpiar)
										.addGap(348))
								.addGroup(gl_Alta.createSequentialGroup().addGroup(gl_Alta
										.createParallelGroup(Alignment.LEADING).addComponent(lblPractica)
										.addGroup(gl_Alta.createSequentialGroup().addGroup(gl_Alta
												.createParallelGroup(Alignment.LEADING)
												.addGroup(gl_Alta.createSequentialGroup().addGroup(gl_Alta
														.createParallelGroup(Alignment.TRAILING)
														.addComponent(tNombre, Alignment.LEADING,
																GroupLayout.DEFAULT_SIZE, 273, Short.MAX_VALUE)
														.addGroup(gl_Alta.createSequentialGroup().addGroup(gl_Alta
																.createParallelGroup(Alignment.LEADING, false)
																.addComponent(lblValCriticoMax,
																		GroupLayout.DEFAULT_SIZE,
																		GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
																.addComponent(tValCriticoMax)
																.addComponent(lblValReservadoMax,
																		GroupLayout.DEFAULT_SIZE,
																		GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
																.addComponent(tValReservadoMax)).addGap(18)
																.addGroup(gl_Alta.createParallelGroup(Alignment.LEADING)
																		.addGroup(gl_Alta
																				.createParallelGroup(Alignment.LEADING)
																				.addComponent(tValCriticoMin,
																						GroupLayout.DEFAULT_SIZE, 135,
																						Short.MAX_VALUE)
																				.addComponent(lblValCriticoMin,
																						GroupLayout.DEFAULT_SIZE, 135,
																						Short.MAX_VALUE)
																				.addComponent(tValReservadoMin,
																						GroupLayout.DEFAULT_SIZE, 135,
																						Short.MAX_VALUE))
																		.addComponent(lblValReservadoMin))))
														.addGap(18))
												.addGroup(gl_Alta.createSequentialGroup().addComponent(lblNombre)
														.addGap(232)))
												.addGroup(gl_Alta.createParallelGroup(Alignment.LEADING)
														.addGroup(gl_Alta.createParallelGroup(Alignment.LEADING, false)
																.addComponent(lblGrupo)
																.addComponent(tGrupo, GroupLayout.DEFAULT_SIZE, 176,
																		Short.MAX_VALUE)
																.addGroup(gl_Alta.createSequentialGroup()
																		.addComponent(lblTiempoEstimado)
																		.addPreferredGap(ComponentPlacement.RELATED)
																		.addComponent(tTiempo)))
														.addComponent(chckbxHabilitada))
												.addGap(37)))
										.addGap(75))
								.addGroup(gl_Alta.createSequentialGroup()
										.addGroup(gl_Alta.createParallelGroup(Alignment.LEADING)
												.addGroup(gl_Alta.createSequentialGroup()
														.addComponent(lblID, GroupLayout.DEFAULT_SIZE, 90,
																Short.MAX_VALUE)
														.addGap(18))
												.addGroup(gl_Alta.createSequentialGroup()
														.addComponent(tid, GroupLayout.DEFAULT_SIZE, 108,
																Short.MAX_VALUE)
														.addPreferredGap(ComponentPlacement.UNRELATED)))
										.addGap(478))))));
		gl_Alta.setVerticalGroup(gl_Alta.createParallelGroup(Alignment.LEADING).addGroup(gl_Alta.createSequentialGroup()
				.addGap(23)
				.addGroup(gl_Alta.createParallelGroup(Alignment.BASELINE).addComponent(btnObtenerPracticaAlta)
						.addComponent(btnAgregarPractica))
				.addGap(18).addComponent(lblPractica).addPreferredGap(ComponentPlacement.RELATED).addComponent(lblID)
				.addPreferredGap(ComponentPlacement.RELATED)
				.addComponent(tid, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE)
				.addPreferredGap(ComponentPlacement.RELATED)
				.addGroup(
						gl_Alta.createParallelGroup(Alignment.BASELINE).addComponent(lblNombre).addComponent(lblGrupo))
				.addPreferredGap(ComponentPlacement.RELATED)
				.addGroup(gl_Alta.createParallelGroup(Alignment.BASELINE)
						.addComponent(tNombre, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
								GroupLayout.PREFERRED_SIZE)
						.addComponent(tGrupo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
								GroupLayout.PREFERRED_SIZE))
				.addPreferredGap(ComponentPlacement.UNRELATED)
				.addGroup(gl_Alta.createParallelGroup(Alignment.BASELINE).addComponent(lblValCriticoMax)
						.addComponent(lblValCriticoMin).addComponent(lblTiempoEstimado).addComponent(tTiempo,
								GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
				.addPreferredGap(ComponentPlacement.RELATED)
				.addGroup(gl_Alta.createParallelGroup(Alignment.BASELINE)
						.addComponent(tValCriticoMax, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
								GroupLayout.PREFERRED_SIZE)
						.addComponent(tValCriticoMin, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
								GroupLayout.PREFERRED_SIZE)
						.addComponent(chckbxHabilitada))
				.addGap(14)
				.addGroup(gl_Alta.createParallelGroup(Alignment.BASELINE).addComponent(lblValReservadoMax)
						.addComponent(lblValReservadoMin))
				.addPreferredGap(ComponentPlacement.RELATED)
				.addGroup(gl_Alta.createParallelGroup(Alignment.BASELINE)
						.addComponent(tValReservadoMax, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
								GroupLayout.PREFERRED_SIZE)
						.addComponent(tValReservadoMin, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
								GroupLayout.PREFERRED_SIZE))
				.addGap(18).addGroup(gl_Alta.createParallelGroup(Alignment.BASELINE).addComponent(btnUpdatePractica)
						.addComponent(btnLimpiar))
				.addContainerGap(146, Short.MAX_VALUE)));
		Alta.setLayout(gl_Alta);

		Alta.setVisible(true);
		return Alta;
	}

	private void asociarEventos() {
		PracticaController pc = PracticaController.getInstance();
		PeticionController peticionController = PeticionController.getInstance();

		if (btnDelete != null || btnAgregarPractica != null) {
			btnAgregarPractica.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					String nombre = tNombre.getText();
					String grupo = tGrupo.getText();
					String valorReservadoMax = tValReservadoMax.getText();
					String valorReservadoMin = tValReservadoMin.getText();
					String valorCriticoMax = tValCriticoMax.getText();
					String valorCriticoMin = tValCriticoMin.getText();
					String tiempo = tTiempo.getText();

					try {
						PracticaDTO p = new PracticaDTO();
						p.nombre = nombre;
						p.grupo = grupo;
						p.valorCriticoMax = Integer.parseInt(valorCriticoMax);
						p.valorCriticoMin = Integer.parseInt(valorCriticoMin);
						p.valorReservadoMax = Integer.parseInt(valorReservadoMax);
						p.valorReservadoMin = Integer.parseInt(valorReservadoMin);
						p.horasEsperaResultado = Integer.parseInt(tiempo);
						p.estadoPractica = EstadoPractica.Habilitado;

						if (!chckbxHabilitada.isSelected()) {
							p.estadoPractica = EstadoPractica.Inhabilidado;
						}

						pc.AltaPractica(p);
						limpiarFormulario();
						alert("Se agregó correctamente", "Información", JOptionPane.INFORMATION_MESSAGE);
					} catch (Exception ex) {
						alert("Este práctica no se pudo eliminar (" + ex.getMessage() + ").", "Error",
								JOptionPane.ERROR_MESSAGE);
					}
				}
			});

			btnObtenerPracticaAlta.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					String id = tid.getText();

					try {
						PracticaDTO practica = pc.ObtenerPractica(Integer.parseInt(id));

						tNombre.setText(practica.nombre);
						tGrupo.setText(practica.grupo);
						tValCriticoMax.setText(String.valueOf(practica.valorCriticoMax));
						tValCriticoMin.setText(String.valueOf(practica.valorCriticoMin));
						tValReservadoMax.setText(String.valueOf(practica.valorReservadoMax));
						tValReservadoMin.setText(String.valueOf(practica.valorReservadoMin));
						tTiempo.setText(String.valueOf(practica.horasEsperaResultado));
						chckbxHabilitada.setSelected(false);

						if (practica.estadoPractica == EstadoPractica.Habilitado) {
							chckbxHabilitada.setSelected(true);
						}

						tid.setEnabled(false);
						btnUpdatePractica.setEnabled(true);
					} catch (Exception ex) {
						alert("No se pudo obtener la practica ingresada (" + ex.getMessage() + ").", "Error",
								JOptionPane.ERROR_MESSAGE);
					}

				}
			});

			btnUpdatePractica.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					String id = tid.getText();
					String nombre = tNombre.getText();
					String grupo = tGrupo.getText();
					String valorReservadoMax = tValReservadoMax.getText();
					String valorReservadoMin = tValReservadoMin.getText();
					String valorCriticoMax = tValCriticoMax.getText();
					String valorCriticoMin = tValCriticoMin.getText();
					String tiempo = tTiempo.getText();

					PracticaDTO p = new PracticaDTO();
					p.id = Integer.parseInt(id);
					p.nombre = nombre;
					p.grupo = grupo;
					p.valorCriticoMax = Integer.parseInt(valorCriticoMax);
					p.valorCriticoMin = Integer.parseInt(valorCriticoMin);
					p.valorReservadoMax = Integer.parseInt(valorReservadoMax);
					p.valorReservadoMin = Integer.parseInt(valorReservadoMin);
					p.horasEsperaResultado = Integer.parseInt(tiempo);

					if (chckbxHabilitada.isSelected()) {
						p.estadoPractica = EstadoPractica.Habilitado;
					} else {
						p.estadoPractica = EstadoPractica.Inhabilidado;
					}

					if (p.valorCriticoMax >= p.valorCriticoMin || p.valorReservadoMax >= p.valorReservadoMin) {
						try {
							pc.ModificarPractica(p);
							limpiarFormulario();
							alert("Se modificó correctamente", "Información", JOptionPane.INFORMATION_MESSAGE);
						} catch (Exception ex) {
							alert("Esta práctica no se pudo modificar (" + ex.getMessage() + ").", "Error",
									JOptionPane.ERROR_MESSAGE);
						}
					} else {
						alert("Los valores está mal setados.", "Error", JOptionPane.ERROR_MESSAGE);
					}

				}
			});

			btnDelete.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					String id = tID.getText();

					try {
						pc.BajaPractica(Integer.parseInt(id));
						tID.setText("");
						alert("Se eliminó correctamente", "Información", JOptionPane.INFORMATION_MESSAGE);
					} catch (Exception ex) {
						alert("Este práctica no se pudo eliminar (" + ex.getMessage() + ").", "Error",
								JOptionPane.ERROR_MESSAGE);
					}
				}
			});

			btnLimpiar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					limpiarFormulario();
				}
			});
		}

		btnObtenerPractica1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				limpiarEstados();
				String id = tid1.getText();
				String idPeticion = tPeticionID.getText();

				try {
					PracticaAsociadaDTO pa = peticionController.ObtenerPracticaAsociada(Integer.parseInt(idPeticion),
							Integer.parseInt(id));
					PracticaDTO practica = pc.ObtenerPractica(Integer.parseInt(id));

					tNombre1.setText(practica.nombre);
					tGrupo1.setText(practica.grupo);
					tValCriticoMax1.setText(String.valueOf(practica.valorCriticoMax));
					tValCriticoMin1.setText(String.valueOf(practica.valorCriticoMin));
					tValReservadoMax1.setText(String.valueOf(practica.valorReservadoMax));
					tValReservadoMin1.setText(String.valueOf(practica.valorReservadoMin));
					lblTiempo.setText(String.valueOf(practica.horasEsperaResultado) + " hs.");
					tResultado.setText(String.valueOf(pa.resultado));

					if (practica.estadoPractica == EstadoPractica.Habilitado) {
						lblHabliticacion_1.setText("SI");
					}

					if (String.valueOf(pa.resultado).isBlank()) {
						tResultado.setText("0");
					}

					estado = pa.resultadoPractica;
					setearEstados();
					btnUpdatePeticion.setEnabled(true);
				} catch (Exception ex) {
					alert("No se pudo obtener la practica ingresada (" + ex.getMessage() + ").", "Error",
							JOptionPane.ERROR_MESSAGE);
				}

			}
		});

		btnUpdatePeticion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String id = tid1.getText();
				String idPeticion = tPeticionID.getText();
				String resultado = tResultado.getText();

				try {
					PeticionDTO peticion = peticionController.ObtenerPeticion(Integer.parseInt(idPeticion));

					for (PracticaAsociadaDTO practicasAsociada : peticion.practicasAsociadas) {
						if (practicasAsociada.practicaID == Integer.parseInt(id)) {
							practicasAsociada.resultado = Integer.parseInt(resultado);
						}
					}

					peticionController.ModificarPeticion(peticion);
					limpiarFormularioPeticion();
					alert("Se modificó correctamente", "Información", JOptionPane.INFORMATION_MESSAGE);
				} catch (Exception ex) {
					alert("No se pudo modificar la petición: (" + ex.getMessage() + ").", "Error",
							JOptionPane.ERROR_MESSAGE);
				}

			}
		});

		btnLimpiar1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				limpiarFormularioPeticion();
			}
		});

		btnObtenerPeticiones.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PeticionController pc = PeticionController.getInstance();
				listPeticiones = pc.ObtenerTodasLasPeticiones();
				mostrarPeticionesYPracticas();
			}
		});

		tabbedPane_4.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				limpiarFormulario();
			}
		});

	}

	private void mostrarPeticionesYPracticas() {
		if (listPeticiones.size() == 0) {
			alert("No hay peticiones", "Información", JOptionPane.INFORMATION_MESSAGE);
			return;
		}

		try {
			PeticionesYPracticas f = new PeticionesYPracticas(listPeticiones);
			f.setVisible(true);
		} catch (Exception e) {
			alert("Hubo un error al obtener peticiones: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
		}
	}

	private void setearEstados() {
		if (estado == EstadoResultadoPractica.Pendiente) {
			rdbtnPendiente.setSelected(true);
		}

		if (estado == EstadoResultadoPractica.Critico) {
			rdbtnCritico.setSelected(true);
		}

		if (estado == EstadoResultadoPractica.Normal) {
			rdbtnNormal.setSelected(true);
		}

		if (estado == EstadoResultadoPractica.Reservado) {
			rdbtnReservado.setSelected(true);
		}
	}

	private void limpiarEstados() {
		rdbtnPendiente.setSelected(false);
		rdbtnCritico.setSelected(false);
		rdbtnNormal.setSelected(false);
		rdbtnReservado.setSelected(false);
	}

	private void limpiarFormularioPeticion() {
		tid1.setText("");
		tPeticionID.setText("");
		tNombre1.setText("");
		tGrupo1.setText("");
		tValCriticoMax1.setText("");
		tValCriticoMin1.setText("");
		tValReservadoMax1.setText("");
		tValReservadoMin1.setText("");
		lblTiempo.setText("N/A");
		tResultado.setText("");
		lblHabliticacion_1.setText("NO");
		tid.setEnabled(true);
		btnUpdatePractica.setEnabled(false);
	}

	private void limpiarFormulario() {
		tid.setText("");
		tPeticionID.setText("");
		tNombre.setText("");
		tGrupo.setText("");
		tValCriticoMax.setText("");
		tValCriticoMin.setText("");
		tValReservadoMax.setText("");
		tValReservadoMin.setText("");
		tTiempo.setText("");
		tid.setEnabled(true);
		btnUpdatePractica.setEnabled(false);
	}

	private void alert(String msg, String type, int pane) {
		JOptionPane.showMessageDialog(tabbedPane_4, msg, type, pane);
	}
}