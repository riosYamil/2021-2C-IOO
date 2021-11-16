package views;

import controllers.SucursalController;
import controllers.UsuarioController;
import dtos.SucursalDTO;
import dtos.UsuarioDTO;

import javax.swing.*;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
	private Panel Baja_1;
	private JLabel lblNum;
	private JLabel lblBaja;
	private JTextField tNum;
	private Button btnDeleteSuc;
	private Panel Modificacion;
	private JButton btnUpdateSuc;
	private Button btnObtenerSuc;
	private JLabel lblNewLabel;
	private JLabel lblNumeroMod;
	private JLabel lblDireccionMod;
	private JLabel lblResponsableTecnicoMod;
	private JButton btnLimpiarForm;
	private JTextField tDireccionMod;
	private JTextField tNumMod;
	private JTextField tResponsableTecnicoMod;
	private JTextField tNuevaSucursal;
		
	
	/**
	 * @wbp.parser.entryPoint
	 */
	public JTabbedPane setSucursalTab() {
		tabbedPane_3 = new JTabbedPane(JTabbedPane.LEFT);
		tabbedPane_3.setBackground(Color.white);
		tabbedPane_3.setBounds(100, 100, 629, 476);
		
		tabbedPane_3.add("Alta", setAltaSucursal());
		tabbedPane_3.add("Baja", setBajaSucursal());
		tabbedPane_3.add("Modificación", setModificacionSucursal());


		asociarEventos();
		
		return tabbedPane_3;
	}
	
	private Panel setModificacionSucursal() {
		Modificacion = new Panel();
		
		btnUpdateSuc = new JButton("Modificar sucursal");
		btnUpdateSuc.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnUpdateSuc.setForeground(Color.BLACK);
		btnUpdateSuc.setBackground(new Color(133, 189, 212));
		btnUpdateSuc.setBounds(230, 174, 150, 27);
		btnUpdateSuc.setEnabled(false);
		
		btnObtenerSuc = new Button("Obtener sucursal");
		btnObtenerSuc.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnObtenerSuc.setForeground(Color.WHITE);
		btnObtenerSuc.setBackground(SystemColor.activeCaption);
		btnObtenerSuc.setBounds(230, 174, 50, 27);
		
		lblNewLabel = new JLabel("Para obtener una sucursal ingrese su número:");
		
		lblNumeroMod = new JLabel("NUMERO");
		
		lblDireccionMod = new JLabel("DIRECCION");
		
		lblResponsableTecnicoMod = new JLabel("DNI DEL RESPONSABLE TECNICO");
		
		btnLimpiarForm = new JButton("Limpiar formulario");
		
		tDireccionMod = new JTextField();
		tDireccionMod.setColumns(10);
		
		tNumMod = new JTextField();
		tNumMod.setText("");
		tNumMod.setColumns(10);
		
		tResponsableTecnicoMod = new JTextField();
		tResponsableTecnicoMod.setColumns(10);
		GroupLayout gl_Modificacion = new GroupLayout(Modificacion);
		gl_Modificacion.setHorizontalGroup(
			gl_Modificacion.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_Modificacion.createSequentialGroup()
					.addGap(50)
					.addGroup(gl_Modificacion.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_Modificacion.createSequentialGroup()
							.addComponent(btnLimpiarForm)
							.addContainerGap())
						.addGroup(gl_Modificacion.createParallelGroup(Alignment.LEADING)
							.addGroup(gl_Modificacion.createSequentialGroup()
								.addComponent(tResponsableTecnicoMod, GroupLayout.PREFERRED_SIZE, 137, GroupLayout.PREFERRED_SIZE)
								.addContainerGap())
							.addGroup(gl_Modificacion.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_Modificacion.createSequentialGroup()
									.addComponent(lblDireccionMod)
									.addContainerGap())
								.addGroup(gl_Modificacion.createParallelGroup(Alignment.LEADING)
									.addGroup(gl_Modificacion.createSequentialGroup()
										.addComponent(tNumMod, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
										.addContainerGap())
									.addGroup(gl_Modificacion.createSequentialGroup()
										.addComponent(lblResponsableTecnicoMod)
										.addContainerGap())
									.addGroup(gl_Modificacion.createSequentialGroup()
										.addComponent(lblNumeroMod)
										.addContainerGap())
									.addGroup(gl_Modificacion.createSequentialGroup()
										.addComponent(lblNewLabel)
										.addContainerGap())
									.addGroup(Alignment.TRAILING, gl_Modificacion.createSequentialGroup()
										.addComponent(btnObtenerSuc, GroupLayout.PREFERRED_SIZE, 129, GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(ComponentPlacement.RELATED, 97, Short.MAX_VALUE)
										.addComponent(btnUpdateSuc)
										.addGap(133))
									.addGroup(gl_Modificacion.createSequentialGroup()
										.addComponent(tDireccionMod, GroupLayout.PREFERRED_SIZE, 309, GroupLayout.PREFERRED_SIZE)
										.addContainerGap()))))))
		);
		gl_Modificacion.setVerticalGroup(
			gl_Modificacion.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_Modificacion.createSequentialGroup()
					.addGap(40)
					.addComponent(lblNewLabel)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(lblNumeroMod)
					.addGap(4)
					.addComponent(tNumMod, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_Modificacion.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnObtenerSuc, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnUpdateSuc))
					.addGap(33)
					.addComponent(lblDireccionMod)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(tDireccionMod, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(13)
					.addComponent(lblResponsableTecnicoMod)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(tResponsableTecnicoMod, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(36)
					.addComponent(btnLimpiarForm)
					.addContainerGap(144, Short.MAX_VALUE))
		);
		Modificacion.setLayout(gl_Modificacion);
		return Modificacion;
	}

	private Panel setBajaSucursal() {
		Baja_1 = new Panel();
		tabbedPane_3.addTab("Baja", null, Baja_1, null);

		lblNum = new JLabel("NUMERO");

		lblBaja = new JLabel("Por favor, ingrese el NUMERO de la sucursal que desea eliminar y el NUMERO de la nueva sucursal.");

		tNum = new JTextField();
		tNum.setColumns(10);

		btnDeleteSuc = new Button("Eliminar Sucursal");
		btnDeleteSuc.setActionCommand("Eliminar Sucursal");
		btnDeleteSuc.setForeground(Color.WHITE);
		btnDeleteSuc.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnDeleteSuc.setBackground(Color.RED);
		
		JLabel lblNuevaSucursal = new JLabel("NUMERO DE NUEVA SUCURSAL");
		
		tNuevaSucursal = new JTextField();
		tNuevaSucursal.setColumns(10);
		GroupLayout gl_Baja_1 = new GroupLayout(Baja_1);
		gl_Baja_1.setHorizontalGroup(
			gl_Baja_1.createParallelGroup(Alignment.LEADING)
				.addGap(0, 550, Short.MAX_VALUE)
				.addGroup(gl_Baja_1.createSequentialGroup()
					.addGap(35)
					.addGroup(gl_Baja_1.createParallelGroup(Alignment.LEADING)
						.addComponent(lblBaja)
						.addComponent(btnDeleteSuc, GroupLayout.PREFERRED_SIZE, 140, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_Baja_1.createSequentialGroup()
							.addGroup(gl_Baja_1.createParallelGroup(Alignment.LEADING)
								.addComponent(lblNum)
								.addComponent(tNum, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addGap(83)
							.addGroup(gl_Baja_1.createParallelGroup(Alignment.LEADING)
								.addComponent(tNuevaSucursal, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblNuevaSucursal))))
					.addContainerGap(207, Short.MAX_VALUE))
		);
		gl_Baja_1.setVerticalGroup(
			gl_Baja_1.createParallelGroup(Alignment.LEADING)
				.addGap(0, 471, Short.MAX_VALUE)
				.addGroup(gl_Baja_1.createSequentialGroup()
					.addGap(22)
					.addComponent(lblBaja)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_Baja_1.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNum)
						.addComponent(lblNuevaSucursal))
					.addGap(4)
					.addGroup(gl_Baja_1.createParallelGroup(Alignment.BASELINE)
						.addComponent(tNum, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(tNuevaSucursal, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(btnDeleteSuc, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(351, Short.MAX_VALUE))
		);
		Baja_1.setLayout(gl_Baja_1);

		return Baja_1;
	}

	private JPanel setAltaSucursal() {
		Alta_1 = new JPanel(false);
		Alta_1.setBackground(Color.WHITE);
		tabbedPane_3.addTab("Alta", null, Alta_1, null);

		lblDireccion = new JLabel("DIRECCION");

		lblResponsableTecnico = new JLabel("DNI DEL RESPONSABLE TECNICO");

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
		
		//layout
		GroupLayout gl_Alta_1 = new GroupLayout(Alta_1);
		gl_Alta_1.setHorizontalGroup(
			gl_Alta_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_Alta_1.createSequentialGroup()
					.addGroup(gl_Alta_1.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_Alta_1.createSequentialGroup()
							.addGap(23)
							.addGroup(gl_Alta_1.createParallelGroup(Alignment.LEADING)
								.addComponent(tNumero, GroupLayout.PREFERRED_SIZE, 81, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblNumero, GroupLayout.PREFERRED_SIZE, 79, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblDireccion)
								.addComponent(tDireccion, 449, 449, 449)
								.addGroup(gl_Alta_1.createParallelGroup(Alignment.TRAILING, false)
									.addComponent(tResponsableTecnico, Alignment.LEADING)
									.addComponent(lblResponsableTecnico, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
						.addGroup(gl_Alta_1.createSequentialGroup()
							.addGap(168)
							.addComponent(btnAddSuc, GroupLayout.PREFERRED_SIZE, 228, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(78, Short.MAX_VALUE))
		);
		gl_Alta_1.setVerticalGroup(
			gl_Alta_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_Alta_1.createSequentialGroup()
					.addGap(34)
					.addComponent(btnAddSuc)
					.addGap(26)
					.addComponent(lblNumero)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(tNumero, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE)
					.addGap(11)
					.addComponent(lblDireccion)
					.addGap(7)
					.addComponent(tDireccion, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(11)
					.addComponent(lblResponsableTecnico)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(tResponsableTecnico, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(244, Short.MAX_VALUE))
		);
		Alta_1.setLayout(gl_Alta_1);
		return Alta_1;
	}
	
	private void asociarEventos() {
		SucursalController sucursalController = SucursalController.getInstance();
		
        btnAddSuc.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	String num = tNumero.getText();
            	String dir = tDireccion.getText();
            	String rt = tResponsableTecnico.getText();
            	
            	if(!num.isBlank() && !dir.isBlank() && !rt.isBlank()) {
                	SucursalDTO s = new SucursalDTO();
                	s.id = Integer.parseInt(num);
                	s.numero = Integer.parseInt(num);
                	s.direccion = dir;
					s.responsableTecnicoDNI = Integer.parseInt(rt);
                	UsuarioDTO u = UsuarioController.getInstance().ObtenerUsuario(Integer.parseInt(rt));

					if (u != null) {
						s = sucursalController.AltaSucursal(s);

						if(s == null) {
							alert("Ya existe.", "Error", JOptionPane.ERROR_MESSAGE);
						}
						else {
							limpiarFormulario();
							alert("Se agregó correctamente.", "Información", JOptionPane.INFORMATION_MESSAGE);
						}
					}else {
						alert("No se reconoce el DNI.", "Error", JOptionPane.ERROR_MESSAGE);
					}
            	}
            	else {
            		alert("Falta información.", "Error", JOptionPane.ERROR_MESSAGE);
            	}           	           
            }
        });
        
        btnDeleteSuc.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		String num = tNum.getText();
        		String numNuevo = tNuevaSucursal.getText();
        		
        		if(!num.isBlank() && !numNuevo.isBlank()) {
        			SucursalDTO s = new SucursalDTO();
        			s = sucursalController.ObtenerSucursal(Integer.parseInt(num));
        			
        			if(sucursalController.BajaSucursal(s.id)) {
						limpiarFormulario();
        				alert("Se borró correctamente.", "Información", JOptionPane.INFORMATION_MESSAGE);
        			}else {
        				alert("La sucursal no se puede eliminar, tiene peticiones finalizadas.", "Error", JOptionPane.ERROR_MESSAGE);
        			}

        		}
        	}
        });
        
		btnObtenerSuc.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
        		String num = tNumMod.getText();
        		
        		if(!num.isBlank()) {
        			SucursalDTO s = new SucursalDTO();
        			s = sucursalController.ObtenerSucursal(Integer.parseInt(num));
        			
        			tDireccionMod.setText(s.direccion);
        			tResponsableTecnicoMod.setText(String.valueOf(s.responsableTecnicoDNI));
        			btnUpdateSuc.setEnabled(true);
        			tNumMod.setEnabled(false);
        			btnObtenerSuc.setEnabled(false);
        		} else {
        			alert("No se pudo obtener sucursal.", "Error", JOptionPane.ERROR_MESSAGE);
        		}
			}
		});
		
		btnUpdateSuc.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
        		String num = tNumMod.getText();
        		String dir = tDireccionMod.getText();
        		String rt = tResponsableTecnicoMod.getText();
        		
        		if (!rt.isBlank()) {
            		SucursalDTO s = new SucursalDTO();
					UsuarioDTO u = UsuarioController.getInstance().ObtenerUsuario(Integer.parseInt(rt));

					if(u != null) {
						s.id = Integer.parseInt(num);
						s.numero = Integer.parseInt(num);
						s.direccion = dir;
						s.responsableTecnicoDNI = Integer.parseInt(rt);

						if(sucursalController.ModificarSucursal(s)) {
							limpiarFormulario();
							btnUpdateSuc.setEnabled(false);
							tNumMod.setEnabled(true);
							btnObtenerSuc.setEnabled(true);
							alert("Se modificó correctamente.", "Información", JOptionPane.INFORMATION_MESSAGE);
						}
						else {
							alert("No se pudo modificar.", "Error", JOptionPane.ERROR_MESSAGE);
						}
					} else {
						alert("No se reconoce ese usuario.", "Error", JOptionPane.ERROR_MESSAGE);
					}
				}else {
					alert("No se reconoce el DNI.", "Error", JOptionPane.ERROR_MESSAGE);
				}
        		        		
        		
			}
		});
        
		btnLimpiarForm.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
    			btnUpdateSuc.setEnabled(false);
    			tNumMod.setEnabled(true);
    			btnObtenerSuc.setEnabled(true);
    			limpiarFormulario();
			}
		});
        
		tabbedPane_3.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				limpiarFormulario();
			}
		});
	}
	
    private void alert(String msg, String type, int pane) {
        JOptionPane.showMessageDialog(tabbedPane_3, msg, type, pane);
    }
	
    private void limpiarFormulario() {
		tNumero.setText("");
		tDireccion.setText("");
		tResponsableTecnico.setText("");
		tNum.setText("");
		tDireccionMod.setText("");
		tResponsableTecnicoMod.setText("");
		tNumMod.setText("");
		tNuevaSucursal.setText("");
    }
}
