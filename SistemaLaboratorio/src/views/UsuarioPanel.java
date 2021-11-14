package views;

import controllers.UsuarioController;
import dtos.UsuarioDTO;
import enums.Rol;

import javax.swing.*;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;  

public class UsuarioPanel {
	
	private JTabbedPane tabbedPane_4;
    private Button btnAddUs;
    private Button btnObtenerUs;
    private JLabel lblDNI;
    private JTextField tdni;
    private JTextField tNombre;
    private JTextField tDomicilio;
    private JLabel lblDomicilio;
    private JLabel lblPass;
    private JTextField tPass;
    private Panel Baja;
    private Button btnDeleteUs;
    private JTextField tDNI;
    private JLabel lbldni;
    private JLabel lblBaja;
    private JTextField tMail;
    private JTextField tNomUs;
    private JTextField tDia;
    private JTextField tMes;
    private JTextField tYear;
    private JButton btnUpdateUs;
    private JButton btnLimpiar;
    private JRadioButton rdbtnAdmin;
    private JRadioButton rdbtnRecep;
    private JRadioButton rdbtnLab;

	/**
	 * @wbp.parser.entryPoint
	 */
	public JTabbedPane setUsuarioTab() {	
		tabbedPane_4 = new JTabbedPane(JTabbedPane.LEFT);
		tabbedPane_4.setBackground(Color.WHITE);
		tabbedPane_4.setBounds(100, 100, 629, 476);
		tabbedPane_4.add("Alta", setAltaPaciente());
		tabbedPane_4.add("Baja", setBajaPaciente());
		
		asociarEventos();
		
		return tabbedPane_4;
	}
	
	 private Panel setBajaPaciente() {
	        Baja = new Panel();

	        btnDeleteUs = new Button("Eliminar Usuario");
	        btnDeleteUs.setActionCommand("Eliminar Usuario");
	        btnDeleteUs.setFont(new Font("Tahoma", Font.BOLD, 12));
	        btnDeleteUs.setForeground(Color.WHITE);
	        btnDeleteUs.setBackground(Color.RED);
	        btnDeleteUs.setBounds(230, 174, 50, 27);

	        tDNI = new JTextField();
	        tDNI.setColumns(10);

	        lbldni = new JLabel("DNI");

	        lblBaja = new JLabel("Por favor, ingrese el DNI del usuario que desea eliminar.");

	        //Layout
	        GroupLayout gl_Baja = new GroupLayout(Baja);
	        gl_Baja.setHorizontalGroup(gl_Baja.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(gl_Baja
	                .createSequentialGroup().addGap(35)
	                .addGroup(gl_Baja.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(lblBaja)
	                        .addComponent(btnDeleteUs, GroupLayout.PREFERRED_SIZE, 140, GroupLayout.PREFERRED_SIZE)
	                        .addComponent(lbldni).addComponent(tDNI, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
	                                GroupLayout.PREFERRED_SIZE))
	                .addContainerGap(271, Short.MAX_VALUE)));
	        gl_Baja.setVerticalGroup(gl_Baja.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(gl_Baja.createSequentialGroup()
	                .addGap(22).addComponent(lblBaja).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(lbldni)
	                .addGap(4)
	                .addComponent(tDNI, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
	                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
	                .addComponent(btnDeleteUs, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
	                .addContainerGap(323, Short.MAX_VALUE)));
	        Baja.setLayout(gl_Baja);

	        return Baja;
	    }

	    private JPanel setAltaPaciente() {
	        JPanel Alta = new JPanel(false);
	        Alta.setBackground(Color.WHITE);

	        btnAddUs = new Button("Agregar usuario");
	        btnAddUs.setFont(new Font("Tahoma", Font.BOLD, 12));
	        btnAddUs.setForeground(Color.WHITE);
	        btnAddUs.setBackground(new Color(133, 189, 212));
	        btnAddUs.setBounds(230, 174, 150, 27);

	        btnObtenerUs = new Button("Obtener usuario");
	        btnObtenerUs.setFont(new Font("Tahoma", Font.BOLD, 12));
	        btnObtenerUs.setForeground(Color.WHITE);
	        btnObtenerUs.setBackground(new Color(133, 189, 212));
	        btnObtenerUs.setBounds(230, 174, 150, 27);

	        tdni = new JTextField();
	        tdni.setFont(new Font("Arial", Font.PLAIN, 15));
	        tdni.setSize(190, 20);
	        tdni.setLocation(200, 100);

	        lblDNI = new JLabel("DNI");
	        lblDNI.setForeground(SystemColor.windowText);
	        lblDNI.setFont(new Font("Tahoma", Font.PLAIN, 11));

	        JLabel lblNombre = new JLabel("NOMBRE COMPLETO");

	        tNombre = new JTextField();
	        tNombre.setColumns(10);

	        tDomicilio = new JTextField();
	        tDomicilio.setColumns(10);

	        lblDomicilio = new JLabel("DOMICILIO");

	        lblPass = new JLabel("CONTRASE\u00D1A");

	        tPass = new JTextField();
	        tPass.setColumns(10);

	        JLabel lblMail = new JLabel("MAIL");

	        tMail = new JTextField();
	        tMail.setColumns(10);

	        JLabel lblNomUs = new JLabel("NOMBRE DE USUARIO");

	        tNomUs = new JTextField();
	        tNomUs.setText("");
	        tNomUs.setColumns(10);
	        
	        JLabel lblFechaDeNacimiento = new JLabel("FECHA DE NACIMIENTO");
	        
	        tDia = new JTextField();
	        tDia.setHorizontalAlignment(SwingConstants.CENTER);
	        tDia.setForeground(Color.LIGHT_GRAY);
	        tDia.setText("DIA");
	        tDia.setColumns(10);
	        
	        tMes = new JTextField();
	        tMes.setHorizontalAlignment(SwingConstants.CENTER);
	        tMes.setForeground(Color.LIGHT_GRAY);
	        tMes.setText("MES");
	        tMes.setColumns(10);
	        
	        tYear = new JTextField();
	        tYear.setForeground(Color.LIGHT_GRAY);
	        tYear.setText("A\u00D1O");
	        tYear.setHorizontalAlignment(SwingConstants.CENTER);
	        tYear.setColumns(10);
	        
	        rdbtnAdmin = new JRadioButton("Administrador");
	        rdbtnAdmin.setBackground(Color.WHITE);
	        
	        JLabel lblRol = new JLabel("ELIJA EL ROL:");
	        
	        rdbtnRecep = new JRadioButton("Recepcionista");
	        rdbtnRecep.setBackground(Color.WHITE);
	        
	        rdbtnLab = new JRadioButton("Laboratorista");
	        rdbtnLab.setBackground(Color.WHITE);
	        
	        JLabel lblNewLabel = new JLabel("Para obtener y modificar un usuario, solo ingrese el DNI y clickee en \"Obtener usuario\".");
	        
	        btnUpdateUs = new JButton("Modificar Usuario");
	        btnUpdateUs.setEnabled(false);
	        
	        btnLimpiar = new JButton("Limpiar formulario");

	        // Layout
	        GroupLayout gl_Alta = new GroupLayout(Alta);
	        gl_Alta.setHorizontalGroup(
	        	gl_Alta.createParallelGroup(Alignment.LEADING)
	        		.addGroup(gl_Alta.createSequentialGroup()
	        			.addGap(31)
	        			.addGroup(gl_Alta.createParallelGroup(Alignment.LEADING)
	        				.addGroup(gl_Alta.createSequentialGroup()
	        					.addComponent(btnUpdateUs)
	        					.addPreferredGap(ComponentPlacement.RELATED)
	        					.addComponent(btnLimpiar))
	        				.addComponent(lblNewLabel)
	        				.addGroup(gl_Alta.createSequentialGroup()
	        					.addComponent(rdbtnAdmin)
	        					.addGap(18)
	        					.addComponent(rdbtnRecep)
	        					.addGap(18)
	        					.addComponent(rdbtnLab))
	        				.addComponent(lblRol)
	        				.addGroup(gl_Alta.createParallelGroup(Alignment.LEADING, false)
	        					.addComponent(lblNomUs)
	        					.addComponent(lblNombre)
	        					.addGroup(gl_Alta.createSequentialGroup()
	        						.addComponent(tdni, GroupLayout.PREFERRED_SIZE, 162, GroupLayout.PREFERRED_SIZE)
	        						.addGap(18)
	        						.addComponent(tMail))
	        					.addComponent(tNombre, GroupLayout.DEFAULT_SIZE, 481, Short.MAX_VALUE)
	        					.addGroup(gl_Alta.createParallelGroup(Alignment.TRAILING)
	        						.addGroup(gl_Alta.createSequentialGroup()
	        							.addComponent(lblDNI, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
	        							.addGap(145)
	        							.addComponent(lblMail, GroupLayout.PREFERRED_SIZE, 222, GroupLayout.PREFERRED_SIZE)
	        							.addGap(64))
	        						.addGroup(gl_Alta.createSequentialGroup()
	        							.addComponent(btnAddUs, GroupLayout.PREFERRED_SIZE, 229, GroupLayout.PREFERRED_SIZE)
	        							.addPreferredGap(ComponentPlacement.RELATED)
	        							.addComponent(btnObtenerUs, GroupLayout.PREFERRED_SIZE, 227, GroupLayout.PREFERRED_SIZE)
	        							.addPreferredGap(ComponentPlacement.RELATED)))
	        					.addGroup(gl_Alta.createSequentialGroup()
	        						.addGroup(gl_Alta.createParallelGroup(Alignment.TRAILING, false)
	        							.addComponent(tNomUs, Alignment.LEADING)
	        							.addComponent(lblDomicilio, Alignment.LEADING)
	        							.addComponent(tDomicilio, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 238, Short.MAX_VALUE))
	        						.addGroup(gl_Alta.createParallelGroup(Alignment.LEADING, false)
	        							.addGroup(gl_Alta.createSequentialGroup()
	        								.addGap(37)
	        								.addGroup(gl_Alta.createParallelGroup(Alignment.LEADING, false)
	        									.addComponent(lblFechaDeNacimiento)
	        									.addGroup(gl_Alta.createSequentialGroup()
	        										.addGroup(gl_Alta.createParallelGroup(Alignment.TRAILING)
	        											.addComponent(lblPass)
	        											.addGroup(gl_Alta.createSequentialGroup()
	        												.addComponent(tDia, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE)
	        												.addPreferredGap(ComponentPlacement.RELATED)
	        												.addComponent(tMes, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)))
	        										.addPreferredGap(ComponentPlacement.RELATED)
	        										.addComponent(tYear, 0, 0, Short.MAX_VALUE)))
	        								.addGap(90))
	        							.addGroup(gl_Alta.createSequentialGroup()
	        								.addGap(18)
	        								.addComponent(tPass))))))
	        			.addContainerGap(75, Short.MAX_VALUE))
	        );
	        gl_Alta.setVerticalGroup(
	        	gl_Alta.createParallelGroup(Alignment.LEADING)
	        		.addGroup(gl_Alta.createSequentialGroup()
	        			.addGap(30)
	        			.addGroup(gl_Alta.createParallelGroup(Alignment.BASELINE)
	        				.addComponent(btnAddUs, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
	        				.addComponent(btnObtenerUs, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
	        			.addPreferredGap(ComponentPlacement.UNRELATED)
	        			.addComponent(lblNewLabel)
	        			.addGap(10)
	        			.addGroup(gl_Alta.createParallelGroup(Alignment.BASELINE)
	        				.addComponent(lblMail)
	        				.addComponent(lblDNI))
	        			.addPreferredGap(ComponentPlacement.RELATED)
	        			.addGroup(gl_Alta.createParallelGroup(Alignment.LEADING)
	        				.addGroup(gl_Alta.createSequentialGroup()
	        					.addComponent(tdni, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE)
	        					.addPreferredGap(ComponentPlacement.RELATED)
	        					.addComponent(lblNombre))
	        				.addComponent(tMail, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
	        			.addPreferredGap(ComponentPlacement.RELATED)
	        			.addComponent(tNombre, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
	        			.addPreferredGap(ComponentPlacement.UNRELATED)
	        			.addGroup(gl_Alta.createParallelGroup(Alignment.BASELINE)
	        				.addComponent(lblDomicilio)
	        				.addComponent(lblFechaDeNacimiento))
	        			.addPreferredGap(ComponentPlacement.RELATED)
	        			.addGroup(gl_Alta.createParallelGroup(Alignment.BASELINE)
	        				.addComponent(tDomicilio, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
	        				.addComponent(tDia, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
	        				.addComponent(tMes, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
	        				.addComponent(tYear, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
	        			.addGap(18)
	        			.addGroup(gl_Alta.createParallelGroup(Alignment.BASELINE)
	        				.addComponent(lblNomUs)
	        				.addComponent(lblPass))
	        			.addPreferredGap(ComponentPlacement.RELATED)
	        			.addGroup(gl_Alta.createParallelGroup(Alignment.BASELINE)
	        				.addComponent(tNomUs, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
	        				.addComponent(tPass, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
	        			.addGap(18)
	        			.addComponent(lblRol)
	        			.addPreferredGap(ComponentPlacement.RELATED)
	        			.addGroup(gl_Alta.createParallelGroup(Alignment.BASELINE)
	        				.addComponent(rdbtnAdmin)
	        				.addComponent(rdbtnRecep)
	        				.addComponent(rdbtnLab))
	        			.addGap(18)
	        			.addGroup(gl_Alta.createParallelGroup(Alignment.BASELINE)
	        				.addComponent(btnUpdateUs)
	        				.addComponent(btnLimpiar))
	        			.addContainerGap(90, Short.MAX_VALUE))
	        );
	        Alta.setLayout(gl_Alta);

	        Alta.setVisible(true);
	        return Alta;
	    }
	    
	    private void asociarEventos() {
	    	UsuarioController usuarioController = UsuarioController.getInstance();
	    	
	        btnAddUs.addActionListener(new ActionListener() {
	        	public void actionPerformed(ActionEvent e) {
	        		String dni = tdni.getText();
	        		String nombre = tNombre.getText();
	        		String domicilio = tDomicilio.getText();
	        		String mail = tMail.getText();
	        		String nombreDeUsuario = tNomUs.getText();
	        		String pass = tPass.getText();
	        		String dia = tDia.getText();
	        		String mes = tMes.getText();
	        		String year = tYear.getText();
	        		String fecha = String.join("-", dia, mes, year);
	        		DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
	        		Date fechaDeNacimiento = null;
	        		
					try {
						fechaDeNacimiento = dateFormat.parse(fecha);
					} catch (ParseException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
	        		UsuarioDTO u = new UsuarioDTO();
	        			        		
	        		if(!dni.isBlank() && !pass.isBlank() && (rdbtnAdmin.isSelected() || rdbtnLab.isSelected() || rdbtnRecep.isSelected())) {
		        		if(rdbtnAdmin.isSelected()) {
		        			u.rol = Rol.Administrador;
		        		}
		        		
		        		if(rdbtnLab.isSelected()) {
		        			u.rol = Rol.Laboratista;
		        		}
		        		
		        		if(rdbtnRecep.isSelected()) {
		        			u.rol = Rol.Recepcion;
		        		}
		        		
		        		u.id = Integer.parseInt(dni);
		        		u.dni = dni;
		        		u.nombre = nombreDeUsuario;
		        		u.nombreCompleto = nombre;
		        		u.domicilio = domicilio;
		        		u.fechaDeNacimiento = fechaDeNacimiento;
		        		u.password = pass;
		        		u.email = mail;
		        		
	        			usuarioController.AltaUsuario(u);
	        			limpiarFormulario();
	        			alert("Se creó correctamente", "Información", JOptionPane.INFORMATION_MESSAGE);
	        		}else {
	        			alert("Este usuario no se pudo crear.", "Error", JOptionPane.ERROR_MESSAGE);
	        		}
	        		
                    
	        	}
	        });
	        
	        btnObtenerUs.addActionListener(new ActionListener() {
	        	public void actionPerformed(ActionEvent e) {
	        		String dni = tdni.getText();
	        		
	        		if(!dni.isBlank()) {
	        			UsuarioDTO u = new UsuarioDTO();
	        			u = usuarioController.ObtenerUsuario(Integer.parseInt(dni));
	        			
	        			if(u != null) {
	        				tNombre.setText(u.nombreCompleto);
	        				tDomicilio.setText(u.domicilio);
	        				tMail.setText(u.email);
	        	    		tNomUs.setText(u.nombre);
	        	    		tPass.setText(u.password);
        	    		
	        	    		//arreglar date
	        	    		tDia.setText("");
	        	    		tMes.setText("");
	        	    		tYear.setText("");
	        	    		
	        	    		
	        				tdni.setEnabled(false);
	        				btnAddUs.setEnabled(false);
	        				btnUpdateUs.setEnabled(true);
	        			}
	        		}
	        		
	        	}
	        });
	    	
	        btnDeleteUs.addActionListener(new ActionListener() {
	        	public void actionPerformed(ActionEvent e) {
	        		String dni = tDNI.getText();
	        		

	        			if(usuarioController.BajaUsuario(Integer.parseInt(dni))) {
	        				limpiarFormulario();
		        			alert("Se eliminó correctamente", "Información", JOptionPane.INFORMATION_MESSAGE);
	        			}
	        			else {
	        				 alert("Este usuario no se pudo eliminar.", "Error", JOptionPane.ERROR_MESSAGE);
	        			}


	        	}
	        });
	        
	        btnUpdateUs.addActionListener(new ActionListener() {
	        	public void actionPerformed(ActionEvent e) {
	        		String dni = tdni.getText();
	        		String nombre = tNombre.getText();
	        		String domicilio = tDomicilio.getText();
	        		String mail = tMail.getText();
	        		String nombreDeUsuario = tNomUs.getText();
	        		String pass = tPass.getText();
	        		String dia = tDia.getText();
	        		String mes = tMes.getText();
	        		String year = tYear.getText();
	        		String fecha = String.join("-", dia, mes, year);
	        		DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
	        		Date fechaDeNacimiento = null;
	        		
					try {
						fechaDeNacimiento = dateFormat.parse(fecha);
					} catch (ParseException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
	        		UsuarioDTO u = new UsuarioDTO();
	        			        		
	        		if(!pass.isBlank() && (rdbtnAdmin.isSelected() || rdbtnLab.isSelected() || rdbtnRecep.isSelected())) {
		        		if(rdbtnAdmin.isSelected()) {
		        			u.rol = Rol.Administrador;
		        		}
		        		
		        		if(rdbtnLab.isSelected()) {
		        			u.rol = Rol.Laboratista;
		        		}
		        		
		        		if(rdbtnRecep.isSelected()) {
		        			u.rol = Rol.Recepcion;
		        		}
		        		
		        		u.id = Integer.parseInt(dni);
		        		u.dni = dni;
		        		u.nombre = nombreDeUsuario;
		        		u.nombreCompleto = nombre;
		        		u.domicilio = domicilio;
		        		u.fechaDeNacimiento = fechaDeNacimiento;
		        		u.password = pass;
		        		u.email = mail;
		        		
	        			usuarioController.ModificarUsuario(u);
	    				tdni.setEnabled(true);
	    				btnAddUs.setEnabled(true);
	    				btnUpdateUs.setEnabled(false);
	        			limpiarFormulario();
	        			alert("Se modificó correctamente", "Información", JOptionPane.INFORMATION_MESSAGE);
	        		}else {
	        			alert("Este usuario no se pudo modificar.", "Error", JOptionPane.ERROR_MESSAGE);
	        		}
	        		
                    
	        	}
	        });
	        
	        btnLimpiar.addActionListener(new ActionListener() {
	        	public void actionPerformed(ActionEvent e) {
	        		limpiarFormulario();
    				tdni.setEnabled(true);
    				btnAddUs.setEnabled(true);
    				btnUpdateUs.setEnabled(false);
	        	}
	        });
	        
			tabbedPane_4.addChangeListener(new ChangeListener() {
				public void stateChanged(ChangeEvent e) {
					limpiarFormulario();
				}
			});

	    }
	    
	    private void limpiarFormulario() {
			tdni.setText("");
			tNombre.setText("");
			tDomicilio.setText("");
			tMail.setText("");
    		tNomUs.setText("");
    		tPass.setText("");
    		tDia.setText("");
    		tMes.setText("");
    		tYear.setText("");
    		tDNI.setText("");
	    }
	    
	    private void alert(String msg, String type, int pane) {
	        JOptionPane.showMessageDialog(tabbedPane_4, msg, type, pane);
	    }
	    
	}
