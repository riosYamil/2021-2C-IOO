package views;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Window;
import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.border.EmptyBorder;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.WindowConstants;
import javax.swing.JButton;
import javax.swing.JDesktopPane;
import javax.swing.JToolBar;
import javax.swing.JFormattedTextField;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import java.awt.Component;
import javax.swing.Box;
import javax.swing.JMenuItem;
import javax.swing.JLayeredPane;
import javax.swing.BoxLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JRadioButton;
import java.awt.Panel;

public class InternalTabs extends JTabbedPane {
	
	private JTabbedPane tabbedPane_1;
	private JTabbedPane tabbedPane_2;
	private JTabbedPane tabbedPane_3;
	private JLayeredPane layeredPane;
	private JButton addComponentBtn;
	private JButton updateComponentBtn;
	private JLabel dni;
	private JTextField tdni;
	private JTextField tNombre;
	private JTextField tDomicilio;
	private JLabel lblDomicilio;
	private JLabel lblEdad;
	private JTextField tEdad;
	private Panel Baja;
	private JButton deleteComponentBtn;
	private JTextField tDNI;
	private JLabel lbldni;
	private JLabel lblBaja;

	public InternalTabs() {
		tabbedPane_1 = new JTabbedPane(JTabbedPane.LEFT);
		tabbedPane_2 = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane_3 = new JTabbedPane(JTabbedPane.TOP);

		this.addTab("Pacientes", tabbedPane_1);
		this.addTab("Petiones", tabbedPane_2);
		this.addTab("Sucursales", tabbedPane_3);

		setPacienteTab();

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

		deleteComponentBtn = new JButton("Eliminar Paciente");

		tDNI = new JTextField();
		tDNI.setColumns(10);

		lbldni = new JLabel("DNI");

		lblBaja = new JLabel("Por favor, ingrese el DNI del paciente que desea eliminar.");
		GroupLayout gl_Baja = new GroupLayout(Baja);
		gl_Baja.setHorizontalGroup(gl_Baja.createParallelGroup(Alignment.LEADING).addGroup(gl_Baja
				.createSequentialGroup().addGap(35)
				.addGroup(gl_Baja.createParallelGroup(Alignment.LEADING).addComponent(lbldni)
						.addComponent(deleteComponentBtn).addComponent(lblBaja).addComponent(tDNI,
								GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
				.addContainerGap(74, Short.MAX_VALUE)));
		gl_Baja.setVerticalGroup(gl_Baja.createParallelGroup(Alignment.LEADING).addGroup(gl_Baja.createSequentialGroup()
				.addGap(15).addComponent(lblBaja).addGap(18).addComponent(lbldni).addGap(4)
				.addComponent(tDNI, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
				.addPreferredGap(ComponentPlacement.UNRELATED).addComponent(deleteComponentBtn)
				.addContainerGap(148, Short.MAX_VALUE)));
		Baja.setLayout(gl_Baja);
		
		return Baja;
	}

	private JPanel setAltaPaciente() {
		JPanel Alta = new JPanel(false);

		addComponentBtn = new JButton("Alta");
		updateComponentBtn = new JButton("Modificar");

		tdni = new JTextField();
		tdni.setFont(new Font("Arial", Font.PLAIN, 15));
		tdni.setSize(190, 20);
		tdni.setLocation(200, 100);

		dni = new JLabel("DNI *");
		dni.setFont(new Font("Tahoma", Font.PLAIN, 11));

		JLabel lblNombre = new JLabel("Nombre");

		tNombre = new JTextField();
		tNombre.setColumns(10);

		tDomicilio = new JTextField();
		tDomicilio.setColumns(10);

		lblDomicilio = new JLabel("Domicilio");

		lblEdad = new JLabel("Edad");

		tEdad = new JTextField();
		tEdad.setColumns(10);

		// Layout
		GroupLayout gl_Alta = new GroupLayout(Alta);
		gl_Alta.setHorizontalGroup(
			gl_Alta.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_Alta.createSequentialGroup()
					.addGap(32)
					.addGroup(gl_Alta.createParallelGroup(Alignment.LEADING)
						.addComponent(tEdad, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE)
						.addComponent(tNombre, GroupLayout.PREFERRED_SIZE, 184, GroupLayout.PREFERRED_SIZE)
						.addComponent(dni, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
						.addComponent(tdni, 163, 163, 163)
						.addComponent(lblNombre)
						.addComponent(lblDomicilio)
						.addComponent(tDomicilio, GroupLayout.PREFERRED_SIZE, 162, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblEdad)
						.addGroup(gl_Alta.createSequentialGroup()
							.addGap(86)
							.addComponent(addComponentBtn)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(updateComponentBtn)))
					.addGap(149))
		);
		gl_Alta.setVerticalGroup(
			gl_Alta.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_Alta.createSequentialGroup()
					.addGap(5)
					.addGroup(gl_Alta.createParallelGroup(Alignment.BASELINE)
						.addComponent(addComponentBtn)
						.addComponent(updateComponentBtn))
					.addPreferredGap(ComponentPlacement.RELATED, 19, 40) //Set gap between buttons and form
					.addComponent(dni)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(tdni, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblNombre)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(tNombre, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(lblDomicilio)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(tDomicilio, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(lblEdad)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(tEdad, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(31))
		);
		Alta.setLayout(gl_Alta);
		
		this.setVisible(true);
		return Alta;
	}

	private void asociarEventos() {
		addComponentBtn.addActionListener(e -> {
		});
		deleteComponentBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println(lbldni.getText());
			}
		});
		updateComponentBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
	}
}
