package views;

import java.awt.Button;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Panel;

import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PeticionPanel {
	
	private JTabbedPane tabbedPane_2;
	private Panel Peticiones;
	private JLabel lblBaja_2;
	private JLabel lbldni_1;
	private JTextField tDNIPeticiones;
	private JCheckBox chckbxPeticionesCompletas;
	private Button btnObtenerPeticiones;
	private JCheckBox chckbxPeticionesCriticas;
	private JButton btnEnviarNot;
	private JLabel lblNotificar;

	/**
	 * @wbp.parser.entryPoint
	 */
	public JTabbedPane setPeticionesTab() {	
		tabbedPane_2 = new JTabbedPane(JTabbedPane.LEFT);
		tabbedPane_2.setBackground(Color.WHITE);
		tabbedPane_2.setBounds(100, 100, 629, 476);
		tabbedPane_2.add(setLayout());
        tabbedPane_2.setEnabledAt(0, true);
        tabbedPane_2.setTitleAt(0, "Peticiones");
		
		asociarEventos();
		
		return tabbedPane_2;
	}
	
	private Panel setLayout() {
		Peticiones = new Panel();
		lblBaja_2 = new JLabel("Por favor, ingrese el DNI del paciente para obtener sus peticiones o deje el campo vacio.");
		
		lbldni_1 = new JLabel("DNI");
		
		tDNIPeticiones = new JTextField();
		tDNIPeticiones.setColumns(10);
		
		JCheckBox chckbxPeticionesPendientes = new JCheckBox("Solo peticiones completas");
		chckbxPeticionesPendientes.setBackground(Color.WHITE);
		
		chckbxPeticionesCompletas = new JCheckBox("Solo peticiones pendientes");
		chckbxPeticionesCompletas.setBackground(Color.WHITE);
		
		btnObtenerPeticiones = new Button("Obtener peticiones");

		btnObtenerPeticiones.setForeground(Color.WHITE);
		btnObtenerPeticiones.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnObtenerPeticiones.setBackground(new Color(133, 189, 212));
		
		chckbxPeticionesCriticas = new JCheckBox("Solo peticiones con resultados criticos");
		chckbxPeticionesCriticas.setBackground(Color.WHITE);
		
		btnEnviarNot = new JButton("Enviar notificaci\u00F3n");

		lblNotificar = new JLabel("Notificar a aquellos pacientes que deben retirar sus resultados con valores reservados por sucursal.");
		
		GroupLayout gl_Peticiones = new GroupLayout(Peticiones);
		gl_Peticiones.setHorizontalGroup(
			gl_Peticiones.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_Peticiones.createSequentialGroup()
					.addGap(35)
					.addGroup(gl_Peticiones.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_Peticiones.createSequentialGroup()
							.addComponent(lblNotificar)
							.addContainerGap())
						.addGroup(gl_Peticiones.createParallelGroup(Alignment.LEADING)
							.addGroup(gl_Peticiones.createSequentialGroup()
								.addComponent(btnEnviarNot)
								.addContainerGap())
							.addGroup(gl_Peticiones.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_Peticiones.createSequentialGroup()
									.addComponent(btnObtenerPeticiones, GroupLayout.PREFERRED_SIZE, 152, GroupLayout.PREFERRED_SIZE)
									.addContainerGap())
								.addGroup(gl_Peticiones.createParallelGroup(Alignment.LEADING)
									.addGroup(gl_Peticiones.createSequentialGroup()
										.addComponent(lblBaja_2, GroupLayout.PREFERRED_SIZE, 474, GroupLayout.PREFERRED_SIZE)
										.addContainerGap())
									.addGroup(gl_Peticiones.createSequentialGroup()
										.addGroup(gl_Peticiones.createParallelGroup(Alignment.LEADING)
											.addComponent(lbldni_1)
											.addComponent(tDNIPeticiones, GroupLayout.PREFERRED_SIZE, 132, GroupLayout.PREFERRED_SIZE))
										.addPreferredGap(ComponentPlacement.RELATED, 104, Short.MAX_VALUE)
										.addGroup(gl_Peticiones.createParallelGroup(Alignment.LEADING)
											.addComponent(chckbxPeticionesPendientes)
											.addComponent(chckbxPeticionesCriticas)
											.addComponent(chckbxPeticionesCompletas))
										.addContainerGap(79, Short.MAX_VALUE)))))))
		);
		gl_Peticiones.setVerticalGroup(
			gl_Peticiones.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_Peticiones.createSequentialGroup()
					.addGap(16)
					.addComponent(lblBaja_2, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
					.addGap(11)
					.addGroup(gl_Peticiones.createParallelGroup(Alignment.TRAILING)
						.addComponent(lbldni_1)
						.addComponent(chckbxPeticionesPendientes))
					.addGroup(gl_Peticiones.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_Peticiones.createSequentialGroup()
							.addGap(18)
							.addComponent(chckbxPeticionesCompletas)
							.addGap(11)
							.addComponent(chckbxPeticionesCriticas))
						.addGroup(gl_Peticiones.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(tDNIPeticiones, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
					.addGap(16)
					.addComponent(btnObtenerPeticiones, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(56)
					.addComponent(lblNotificar)
					.addGap(18)
					.addComponent(btnEnviarNot)
					.addContainerGap(133, Short.MAX_VALUE))
		);
		Peticiones.setLayout(gl_Peticiones);
		
		return Peticiones;
	}
	
	private void asociarEventos() {
		btnObtenerPeticiones.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(tabbedPane_2, "Hola?", "Informaciï¿½n",
						JOptionPane.INFORMATION_MESSAGE);
			}
		});
		
		btnEnviarNot.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(tabbedPane_2, "Se notificó correctamente", "Informaciï¿½n",
						JOptionPane.INFORMATION_MESSAGE);
			}
		});
		
	}
	
}
