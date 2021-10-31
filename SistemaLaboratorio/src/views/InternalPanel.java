package views;

import java.awt.Button;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JLayeredPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.Panel;
import java.awt.SystemColor;
import javax.swing.JSplitPane;

public class InternalPanel extends JTabbedPane {

	private JTabbedPane tabbedPane_1;
	private JTabbedPane tabbedPane_2;
	private JTabbedPane tabbedPane_3;
	private JLayeredPane layeredPane;
	private Button addComponentBtn;
	private Button updateComponentBtn;
	private JLabel dni;
	private JTextField tdni;
	private JTextField tNombre;
	private JTextField tDomicilio;
	private JLabel lblDomicilio;
	private JLabel lblEdad;
	private JTextField tEdad;
	private Panel Baja;
	private Button deleteComponentBtn;
	private JTextField tDNI;
	private JLabel lbldni;
	private JLabel lblBaja;
	private JTextField tMail;
	private JTextField tSexo;
	private JPanel Alta_1;
	private JLabel lblDIreccion;
	private JLabel lblResponsableTecnico;
	private JTextField tNumero;
	private JTextField textField_4;
	private JTextField textField_5;
	private JLabel lblNumero;
	private Button addComponentBtn_1;
	private Button updateComponentBtn_1;
	private Panel Baja_1;
	private JLabel lblNumero1;
	private JLabel lblBaja_1;
	private JTextField tNumero1;
	private Button deleteComponentBtn_1;

	public InternalPanel() {
		setBorder(null);
		setBounds(100, 100, 629, 476);
		tabbedPane_1 = new JTabbedPane(JTabbedPane.LEFT);
		tabbedPane_1.setBackground(Color.WHITE);
		tabbedPane_2 = new JTabbedPane(JTabbedPane.LEFT);
		tabbedPane_3 = new JTabbedPane(JTabbedPane.LEFT);

		this.addTab("Pacientes", tabbedPane_1);
		this.addTab("Petiones", tabbedPane_2);
		this.addTab("Sucursales", tabbedPane_3);

		setPacienteTab();
		setSucursalTab();

		asociarEventos();
	}

	private void setPacienteTab() {
		tabbedPane_1.add(setAltaPaciente());
		tabbedPane_1.add(setBajaPaciente());
		tabbedPane_1.setEnabledAt(0, true);
		tabbedPane_1.setTitleAt(0, "Alta");
		tabbedPane_1.setEnabledAt(1, true);
		tabbedPane_1.setTitleAt(1, "Baja");
	}

	private Panel setBajaPaciente() {
		Baja = new Panel();

		deleteComponentBtn = new Button("Eliminar Paciente");
		deleteComponentBtn.setFont(new Font("Tahoma", Font.BOLD, 12));
		deleteComponentBtn.setForeground(Color.WHITE);
		deleteComponentBtn.setBackground(Color.RED);
		deleteComponentBtn.setBounds(230, 174, 50, 27);

		tDNI = new JTextField();
		tDNI.setColumns(10);

		lbldni = new JLabel("DNI");

		lblBaja = new JLabel("Por favor, ingrese el DNI del paciente que desea eliminar.");
		GroupLayout gl_Baja = new GroupLayout(Baja);
		gl_Baja.setHorizontalGroup(gl_Baja.createParallelGroup(Alignment.LEADING).addGroup(gl_Baja
				.createSequentialGroup().addGap(35)
				.addGroup(gl_Baja.createParallelGroup(Alignment.LEADING).addComponent(lblBaja)
						.addComponent(deleteComponentBtn, GroupLayout.PREFERRED_SIZE, 140, GroupLayout.PREFERRED_SIZE)
						.addComponent(lbldni).addComponent(tDNI, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
								GroupLayout.PREFERRED_SIZE))
				.addContainerGap(271, Short.MAX_VALUE)));
		gl_Baja.setVerticalGroup(gl_Baja.createParallelGroup(Alignment.LEADING).addGroup(gl_Baja.createSequentialGroup()
				.addGap(22).addComponent(lblBaja).addPreferredGap(ComponentPlacement.UNRELATED).addComponent(lbldni)
				.addGap(4)
				.addComponent(tDNI, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
				.addPreferredGap(ComponentPlacement.UNRELATED)
				.addComponent(deleteComponentBtn, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
				.addContainerGap(323, Short.MAX_VALUE)));
		Baja.setLayout(gl_Baja);

		return Baja;
	}

	private JPanel setAltaPaciente() {
		JPanel Alta = new JPanel(false);
		Alta.setBackground(Color.WHITE);

		addComponentBtn = new Button("Agregar paciente");
		addComponentBtn.setFont(new Font("Tahoma", Font.BOLD, 12));
		addComponentBtn.setForeground(Color.WHITE);
		addComponentBtn.setBackground(new Color(133, 189, 212));
		addComponentBtn.setBounds(230, 174, 150, 27);
		updateComponentBtn = new Button("Modificar paciente");
		updateComponentBtn.setFont(new Font("Tahoma", Font.BOLD, 12));
		updateComponentBtn.setForeground(Color.WHITE);
		updateComponentBtn.setBackground(new Color(133, 189, 212));
		updateComponentBtn.setBounds(230, 174, 150, 27);

		tdni = new JTextField();
		tdni.setFont(new Font("Arial", Font.PLAIN, 15));
		tdni.setSize(190, 20);
		tdni.setLocation(200, 100);

		dni = new JLabel("DNI");
		dni.setForeground(SystemColor.windowText);
		dni.setFont(new Font("Tahoma", Font.PLAIN, 11));

		JLabel lblNombre = new JLabel("NOMBRE");

		tNombre = new JTextField();
		tNombre.setColumns(10);

		tDomicilio = new JTextField();
		tDomicilio.setColumns(10);

		lblDomicilio = new JLabel("DOMICILIO");

		lblEdad = new JLabel("EDAD");

		tEdad = new JTextField();
		tEdad.setColumns(10);

		JLabel lblNewLabel = new JLabel("MAIL");

		tMail = new JTextField();
		tMail.setColumns(10);

		JLabel lblSexo = new JLabel("SEXO");

		tSexo = new JTextField();
		tSexo.setText("");
		tSexo.setColumns(10);

		// Layout
		GroupLayout gl_Alta = new GroupLayout(Alta);
		gl_Alta.setHorizontalGroup(gl_Alta.createParallelGroup(Alignment.LEADING).addGroup(gl_Alta
				.createSequentialGroup().addGap(31)
				.addGroup(gl_Alta.createParallelGroup(Alignment.LEADING, false).addComponent(lblNombre)
						.addComponent(lblDomicilio)
						.addGroup(gl_Alta.createSequentialGroup()
								.addGroup(gl_Alta.createParallelGroup(Alignment.LEADING).addComponent(lblEdad)
										.addComponent(tEdad, GroupLayout.PREFERRED_SIZE, 34,
												GroupLayout.PREFERRED_SIZE))
								.addGap(33)
								.addGroup(gl_Alta.createParallelGroup(Alignment.LEADING)
										.addComponent(tSexo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
												GroupLayout.PREFERRED_SIZE)
										.addComponent(lblSexo)))
						.addGroup(gl_Alta.createSequentialGroup()
								.addComponent(tdni, GroupLayout.PREFERRED_SIZE, 162, GroupLayout.PREFERRED_SIZE)
								.addGap(18).addComponent(tMail))
						.addComponent(tNombre, GroupLayout.DEFAULT_SIZE, 481, Short.MAX_VALUE).addComponent(tDomicilio)
						.addGroup(gl_Alta.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_Alta.createSequentialGroup()
										.addComponent(dni, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
										.addGap(147).addComponent(lblNewLabel).addGap(64))
								.addGroup(Alignment.TRAILING,
										gl_Alta.createSequentialGroup().addComponent(addComponentBtn).addGap(18)
												.addComponent(updateComponentBtn)
												.addPreferredGap(ComponentPlacement.RELATED))))
				.addContainerGap(70, Short.MAX_VALUE)));
		gl_Alta.setVerticalGroup(gl_Alta.createParallelGroup(Alignment.LEADING).addGroup(gl_Alta.createSequentialGroup()
				.addGap(30)
				.addGroup(gl_Alta.createParallelGroup(Alignment.BASELINE).addComponent(addComponentBtn)
						.addComponent(updateComponentBtn))
				.addGap(36)
				.addGroup(gl_Alta.createParallelGroup(Alignment.BASELINE).addComponent(dni).addComponent(lblNewLabel))
				.addPreferredGap(ComponentPlacement.RELATED)
				.addGroup(gl_Alta.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_Alta.createSequentialGroup()
								.addComponent(tdni, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(ComponentPlacement.RELATED).addComponent(lblNombre))
						.addComponent(tMail, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
								GroupLayout.PREFERRED_SIZE))
				.addPreferredGap(ComponentPlacement.RELATED)
				.addComponent(tNombre, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
				.addPreferredGap(ComponentPlacement.UNRELATED).addComponent(lblDomicilio)
				.addPreferredGap(ComponentPlacement.RELATED)
				.addComponent(tDomicilio, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
						GroupLayout.PREFERRED_SIZE)
				.addPreferredGap(ComponentPlacement.UNRELATED)
				.addGroup(gl_Alta.createParallelGroup(Alignment.BASELINE).addComponent(lblEdad).addComponent(lblSexo))
				.addPreferredGap(ComponentPlacement.RELATED)
				.addGroup(gl_Alta.createParallelGroup(Alignment.BASELINE)
						.addComponent(tEdad, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
								GroupLayout.PREFERRED_SIZE)
						.addComponent(tSexo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
								GroupLayout.PREFERRED_SIZE))
				.addContainerGap(165, Short.MAX_VALUE)));
		Alta.setLayout(gl_Alta);

		this.setVisible(true);
		return Alta;
	}

	private void setSucursalTab() {
		tabbedPane_3.setBackground(Color.WHITE);
		tabbedPane_3.add(setAltaSucursal());
		tabbedPane_3.add(setBajaSucursal());
		tabbedPane_3.setTitleAt(0, "Alta");
		tabbedPane_3.setEnabledAt(0, true);
		tabbedPane_3.setEnabledAt(1, true);
		tabbedPane_3.setTitleAt(1, "Baja");
	}

	private Panel setBajaSucursal() {
		Baja_1 = new Panel();
		tabbedPane_3.addTab("Baja", null, Baja_1, null);

		lblNumero1 = new JLabel("NUMERO");

		lblBaja_1 = new JLabel("Por favor, ingrese el NUMERO de la sucursal que desea eliminar.");

		tNumero1 = new JTextField();
		tNumero1.setColumns(10);

		deleteComponentBtn_1 = new Button("Eliminar Sucursal");
		deleteComponentBtn_1.setActionCommand("Eliminar Sucursal");
		deleteComponentBtn_1.setForeground(Color.WHITE);
		deleteComponentBtn_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		deleteComponentBtn_1.setBackground(Color.RED);
		GroupLayout gl_Baja_1 = new GroupLayout(Baja_1);
		gl_Baja_1.setHorizontalGroup(gl_Baja_1.createParallelGroup(Alignment.LEADING).addGap(0, 563, Short.MAX_VALUE)
				.addGap(0, 582, Short.MAX_VALUE)
				.addGroup(gl_Baja_1.createSequentialGroup().addGap(35)
						.addGroup(gl_Baja_1.createParallelGroup(Alignment.LEADING).addComponent(lblBaja_1)
								.addComponent(deleteComponentBtn_1, GroupLayout.PREFERRED_SIZE, 140,
										GroupLayout.PREFERRED_SIZE)
								.addComponent(lblNumero1).addComponent(tNumero1, GroupLayout.PREFERRED_SIZE,
										GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addContainerGap(271, Short.MAX_VALUE)));
		gl_Baja_1.setVerticalGroup(gl_Baja_1.createParallelGroup(Alignment.LEADING).addGap(0, 443, Short.MAX_VALUE)
				.addGap(0, 443, Short.MAX_VALUE)
				.addGroup(gl_Baja_1.createSequentialGroup().addGap(22).addComponent(lblBaja_1)
						.addPreferredGap(ComponentPlacement.UNRELATED).addComponent(lblNumero1).addGap(4)
						.addComponent(tNumero1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
								GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.UNRELATED)
						.addComponent(deleteComponentBtn_1, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
						.addContainerGap(323, Short.MAX_VALUE)));
		Baja_1.setLayout(gl_Baja_1);

		return Baja_1;
	}

	private JPanel setAltaSucursal() {
		Alta_1 = new JPanel(false);
		Alta_1.setBackground(Color.WHITE);
		tabbedPane_3.addTab("Alta", null, Alta_1, null);

		lblDIreccion = new JLabel("DIRECCION");

		lblResponsableTecnico = new JLabel("RESPONSABLE TECNICO");

		tNumero = new JTextField();
		tNumero.setFont(new Font("Arial", Font.PLAIN, 15));

		textField_4 = new JTextField();
		textField_4.setColumns(10);

		textField_5 = new JTextField();
		textField_5.setColumns(10);

		lblNumero = new JLabel("NUMERO");
		lblNumero.setForeground(Color.BLACK);
		lblNumero.setFont(new Font("Tahoma", Font.PLAIN, 11));

		addComponentBtn_1 = new Button("Agregar sucursal");
		addComponentBtn_1.setForeground(Color.WHITE);
		addComponentBtn_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		addComponentBtn_1.setBackground(new Color(133, 189, 212));

		updateComponentBtn_1 = new Button("Modificar sucursal");
		updateComponentBtn_1.setForeground(Color.WHITE);
		updateComponentBtn_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		updateComponentBtn_1.setBackground(new Color(133, 189, 212));
		GroupLayout gl_Alta_1 = new GroupLayout(Alta_1);
		gl_Alta_1.setHorizontalGroup(gl_Alta_1.createParallelGroup(Alignment.LEADING).addGap(0, 624, Short.MAX_VALUE)
				.addGap(0, 563, Short.MAX_VALUE).addGap(0, 582, Short.MAX_VALUE)
				.addGroup(gl_Alta_1.createSequentialGroup().addGap(31)
						.addGroup(gl_Alta_1.createParallelGroup(Alignment.LEADING).addComponent(lblDIreccion)
								.addComponent(lblResponsableTecnico)
								.addComponent(tNumero, GroupLayout.PREFERRED_SIZE, 162, GroupLayout.PREFERRED_SIZE)
								.addComponent(textField_4, GroupLayout.DEFAULT_SIZE, 481, Short.MAX_VALUE)
								.addComponent(textField_5)
								.addGroup(gl_Alta_1.createSequentialGroup()
										.addComponent(addComponentBtn_1, GroupLayout.PREFERRED_SIZE,
												GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
										.addGap(18)
										.addComponent(updateComponentBtn_1, GroupLayout.PREFERRED_SIZE,
												GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(ComponentPlacement.RELATED))
								.addGroup(Alignment.TRAILING,
										gl_Alta_1.createSequentialGroup()
												.addComponent(lblNumero, GroupLayout.PREFERRED_SIZE, 79,
														GroupLayout.PREFERRED_SIZE)
												.addGap(402)))
						.addContainerGap(70, Short.MAX_VALUE)));
		gl_Alta_1.setVerticalGroup(gl_Alta_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_Alta_1.createSequentialGroup().addGap(30)
						.addGroup(gl_Alta_1.createParallelGroup(Alignment.BASELINE)
								.addComponent(addComponentBtn_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE)
								.addComponent(updateComponentBtn_1, GroupLayout.PREFERRED_SIZE,
										GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGap(36).addComponent(lblNumero).addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(tNumero, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.RELATED).addComponent(lblDIreccion)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(textField_4, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
								GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.UNRELATED).addComponent(lblResponsableTecnico)
						.addPreferredGap(ComponentPlacement.RELATED).addComponent(textField_5,
								GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addContainerGap(216, Short.MAX_VALUE)));
		Alta_1.setLayout(gl_Alta_1);
		return Alta_1;
	}

	private void asociarEventos() {
		addComponentBtn.addActionListener(e -> {
		});
		deleteComponentBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println(tDNI.getText());
			}
		});
		updateComponentBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
	}
}
