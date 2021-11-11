package views;

import javax.swing.*;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
	private JTextField textField;
	private JLabel lblPracticas;
	private JButton btnAddPractica;
	private Panel MasPeticiones;
	private Panel AltaPeticiones;
	private Panel BajaPeticiones;
	private Button btnObtenerPeticiones;
	private JTextField tDNIPeticiones;

	/**
	 * @wbp.parser.entryPoint
	 */
	public JTabbedPane setPeticionesTab() {	
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
	
	private Panel setObtenerPeticiones() {
		Peticiones1 = new Panel();
		
		JLabel lblPeticiones = new JLabel("Peticiones:");
		JLabel lblObtenerPeticiones = new JLabel("Por favor, ingrese el DNI del paciente para obtener sus peticiones.");
		
		JCheckBox chckbxPeticionesPendientes = new JCheckBox("Peticiones pendientes.");
		chckbxPeticionesPendientes.setBackground(Color.WHITE);
		
		JCheckBox chckbxPeticionesCompletas = new JCheckBox("Peticiones completas");
		chckbxPeticionesCompletas.setBackground(Color.WHITE);
		
		JCheckBox chckbxPeticionesCriticas = new JCheckBox("Peticiones con resultados criticos. ");
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
		gl_Peticiones1.setHorizontalGroup(
			gl_Peticiones1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_Peticiones1.createSequentialGroup()
					.addGap(31)
					.addGroup(gl_Peticiones1.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_Peticiones1.createSequentialGroup()
								.addComponent(btnObtenerPeticiones, GroupLayout.PREFERRED_SIZE, 147, GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(ComponentPlacement.RELATED, 47, Short.MAX_VALUE)
								.addGroup(gl_Peticiones1.createParallelGroup(Alignment.LEADING)
									.addComponent(chckbxPeticionesCriticas)
									.addComponent(chckbxPeticionesCompletas)
									.addComponent(chckbxPeticionesPendientes))
								.addGap(146))
							.addGroup(gl_Peticiones1.createSequentialGroup()
									.addGroup(gl_Peticiones1.createParallelGroup(Alignment.LEADING)
											.addComponent(tDNIPeticiones, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
											.addComponent(lblObtenerPeticiones)
											.addComponent(lbldni_1))
										.addContainerGap(209, Short.MAX_VALUE))))
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
									.addContainerGap(302, Short.MAX_VALUE))
						);
						Peticiones1.setLayout(gl_Peticiones1);
			return Peticiones1;

	}
	
	private Panel setAltaPeticiones() {
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
		
		textField = new JTextField();
		textField.setColumns(10);
		
		lblPracticas = new JLabel("PRACTICAS ASOCIADAS");
btnAddPractica = new JButton("Agregar Práctica");
		
		
		GroupLayout gl_AltaPeticiones = new GroupLayout(AltaPeticiones);
		gl_AltaPeticiones.setHorizontalGroup(
			gl_AltaPeticiones.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_AltaPeticiones.createSequentialGroup()
					.addGroup(gl_AltaPeticiones.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_AltaPeticiones.createSequentialGroup()
							.addGap(35)
							.addGroup(gl_AltaPeticiones.createParallelGroup(Alignment.LEADING)
								.addComponent(tDNI, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblDNI)
								.addComponent(lblOB)
								.addComponent(textField, GroupLayout.PREFERRED_SIZE, 237, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblPracticas)
								.addComponent(btnAddPractica, GroupLayout.PREFERRED_SIZE, 139, GroupLayout.PREFERRED_SIZE)))
						.addGroup(gl_AltaPeticiones.createSequentialGroup()
							.addGap(176)
							.addComponent(btnAddPet, GroupLayout.PREFERRED_SIZE, 186, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(198, Short.MAX_VALUE))
		);
		gl_AltaPeticiones.setVerticalGroup(
			gl_AltaPeticiones.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_AltaPeticiones.createSequentialGroup()
					.addGap(27)
					.addComponent(btnAddPet)
					.addGap(30)
					.addComponent(lblDNI)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(tDNI, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(lblOB)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(lblPracticas)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(btnAddPractica)
					.addContainerGap(227, Short.MAX_VALUE))
		);
		AltaPeticiones.setLayout(gl_AltaPeticiones);
		
		return AltaPeticiones;
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
		btnEnviarNot.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(tabbedPane_5, "Se notific� correctamente", "Informaci�n",
						JOptionPane.INFORMATION_MESSAGE);
			}
		});
		
		btnDeletePet.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(tabbedPane_5, "Esta peticón no se pudo eliminar.", "Error",
                        JOptionPane.ERROR_MESSAGE);
			}
		});
		
		btnAddPractica.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		
		btnObtenerPeticiones.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		
	}
}
