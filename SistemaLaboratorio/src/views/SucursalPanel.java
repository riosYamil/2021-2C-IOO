package views;

import java.awt.Button;
import java.awt.Color;
import java.awt.Font;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;

import dtos.PacienteDTO;

public class SucursalPanel {
	
	private JTabbedPane tabbedPane_3;
	private JPanel Alta_1;
	private JLabel lblDireccion;
	private JLabel lblResponsableTecnico;
	private JTextField tNumero;
	private JTextField tDireccion;
	private JTextField tResponsableTecnico;
	private JLabel lblNumero;
	private Button btnAddSuc;
	private Button btnUpdateSuc;
	private Panel Baja_1;
	private JLabel lblNum;
	private JLabel lblBaja;
	private JTextField tNum;
	private Button btnDeleteSuc;
	
	/**
	 * @wbp.parser.entryPoint
	 */
	public JTabbedPane setSucursalTab() {
		tabbedPane_3 = new JTabbedPane(JTabbedPane.LEFT);
		tabbedPane_3.setBackground(Color.white);
		tabbedPane_3.setBounds(100, 100, 629, 476);
		tabbedPane_3.add(setAltaSucursal());
		tabbedPane_3.add(setBajaSucursal());
		tabbedPane_3.setTitleAt(0, "Alta");
		tabbedPane_3.setEnabledAt(0, true);
		tabbedPane_3.setEnabledAt(1, true);
		tabbedPane_3.setTitleAt(1, "Baja");
		
		asociarEventos();
		
		return tabbedPane_3;
	}

	private Panel setBajaSucursal() {
		Baja_1 = new Panel();
		tabbedPane_3.addTab("Baja", null, Baja_1, null);

		lblNum = new JLabel("NUMERO");

		lblBaja = new JLabel("Por favor, ingrese el NUMERO de la sucursal que desea eliminar.");

		tNum = new JTextField();
		tNum.setColumns(10);

		btnDeleteSuc = new Button("Eliminar Sucursal");
		btnDeleteSuc.setActionCommand("Eliminar Sucursal");
		btnDeleteSuc.setForeground(Color.WHITE);
		btnDeleteSuc.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnDeleteSuc.setBackground(Color.RED);
		GroupLayout gl_Baja_1 = new GroupLayout(Baja_1);
		gl_Baja_1.setHorizontalGroup(gl_Baja_1.createParallelGroup(Alignment.LEADING).addGap(0, 563, Short.MAX_VALUE)
				.addGap(0, 582, Short.MAX_VALUE)
				.addGroup(gl_Baja_1.createSequentialGroup().addGap(35)
						.addGroup(gl_Baja_1.createParallelGroup(Alignment.LEADING).addComponent(lblBaja)
								.addComponent(btnDeleteSuc, GroupLayout.PREFERRED_SIZE, 140,
										GroupLayout.PREFERRED_SIZE)
								.addComponent(lblNum).addComponent(tNum, GroupLayout.PREFERRED_SIZE,
										GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addContainerGap(271, Short.MAX_VALUE)));
		gl_Baja_1.setVerticalGroup(gl_Baja_1.createParallelGroup(Alignment.LEADING).addGap(0, 443, Short.MAX_VALUE)
				.addGap(0, 443, Short.MAX_VALUE)
				.addGroup(gl_Baja_1.createSequentialGroup().addGap(22).addComponent(lblBaja)
						.addPreferredGap(ComponentPlacement.UNRELATED).addComponent(lblNum).addGap(4)
						.addComponent(tNum, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
								GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.UNRELATED)
						.addComponent(btnDeleteSuc, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
						.addContainerGap(323, Short.MAX_VALUE)));
		Baja_1.setLayout(gl_Baja_1);

		return Baja_1;
	}

	private JPanel setAltaSucursal() {
		Alta_1 = new JPanel(false);
		Alta_1.setBackground(Color.WHITE);
		tabbedPane_3.addTab("Alta", null, Alta_1, null);

		lblDireccion = new JLabel("DIRECCION");

		lblResponsableTecnico = new JLabel("RESPONSABLE TECNICO");

		tNumero = new JTextField();
		tNumero.setFont(new Font("Arial", Font.PLAIN, 15));

		tDireccion = new JTextField();
		tDireccion.setColumns(10);

		tResponsableTecnico = new JTextField();
		tResponsableTecnico.setColumns(10);

		lblNumero = new JLabel("NUMERO");
		lblNumero.setForeground(Color.BLACK);
		lblNumero.setFont(new Font("Tahoma", Font.PLAIN, 11));

		btnAddSuc = new Button("Agregar sucursal");
		btnAddSuc.setForeground(Color.WHITE);
		btnAddSuc.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnAddSuc.setBackground(new Color(133, 189, 212));
		btnAddSuc.setBounds(230, 174, 150, 27);

		btnUpdateSuc = new Button("Modificar sucursal");
		btnUpdateSuc.setForeground(Color.WHITE);
		btnUpdateSuc.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnUpdateSuc.setBackground(new Color(133, 189, 212));
		btnUpdateSuc.setBounds(230, 174, 150, 27);
		
		//layout
		GroupLayout gl_Alta_1 = new GroupLayout(Alta_1);
		gl_Alta_1.setHorizontalGroup(
			gl_Alta_1.createParallelGroup(Alignment.LEADING)
				.addGap(0, 587, Short.MAX_VALUE)
				.addGap(0, 587, Short.MAX_VALUE)
				.addGroup(gl_Alta_1.createSequentialGroup()
					.addGap(31)
					.addGroup(gl_Alta_1.createParallelGroup(Alignment.LEADING)
						.addComponent(lblResponsableTecnico)
						.addComponent(lblDireccion)
						.addGroup(Alignment.TRAILING, gl_Alta_1.createSequentialGroup()
							.addComponent(btnAddSuc, GroupLayout.PREFERRED_SIZE, 228, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(btnUpdateSuc, GroupLayout.PREFERRED_SIZE, 213, GroupLayout.PREFERRED_SIZE)
							.addGap(140))
						.addGroup(gl_Alta_1.createParallelGroup(Alignment.TRAILING, false)
							.addComponent(tDireccion, Alignment.LEADING)
							.addComponent(tResponsableTecnico, Alignment.LEADING, 484, 484, Short.MAX_VALUE))
						.addGroup(gl_Alta_1.createParallelGroup(Alignment.TRAILING, false)
							.addComponent(tNumero, Alignment.LEADING)
							.addComponent(lblNumero, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 79, Short.MAX_VALUE)))
					.addContainerGap())
		);
		gl_Alta_1.setVerticalGroup(
			gl_Alta_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_Alta_1.createSequentialGroup()
					.addGap(30)
					.addGroup(gl_Alta_1.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnAddSuc, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnUpdateSuc, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(31)
					.addComponent(lblNumero)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(tNumero, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblDireccion)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(tDireccion, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(lblResponsableTecnico)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(tResponsableTecnico, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(244, Short.MAX_VALUE))
		);
		Alta_1.setLayout(gl_Alta_1);
		return Alta_1;
	}
	
	private void asociarEventos() {
        btnAddSuc.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {			
				JOptionPane.showMessageDialog(tabbedPane_3, "Se agreg� correctamente.", "Informaci�n",
						JOptionPane.INFORMATION_MESSAGE);
            }
        });
        
        btnDeleteSuc.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		
        		//if error
        		if(true) {
                    JOptionPane.showMessageDialog(tabbedPane_3, "La sucursal no se puede eliminar.", "Error",
                            JOptionPane.ERROR_MESSAGE);
        		}
        	}
        });
        
        btnUpdateSuc.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		
				JOptionPane.showMessageDialog(tabbedPane_3, "Se modific� correctamente.", "Informaci�n",
						JOptionPane.INFORMATION_MESSAGE);
        	}
        });
	}
}
