package views;

import controllers.PacienteController;
import dtos.PacienteDTO;
import dtos.PeticionDTO;
import enums.EstadoPaciente;

import javax.swing.*;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class PacientePanel{
	
    private JTabbedPane tabbedPane_1;
    private Button btnAddPac;
    private JLabel lblDNI;
    private JTextField tdni;
    private JTextField tNombre;
    private JTextField tDomicilio;
    private JLabel lblDomicilio;
    private JLabel lblEdad;
    private JTextField tEdad;
    private Panel Baja;
    private Panel Modificar;
    private Button btnDeletePac;
    private Button btnObtenerPac;
    private JTextField tDNI;
    private JTextField tDNIMod;
    private JLabel lbldni;
    private JLabel lblBaja;
    private JTextField tMail;
    private JTextField tSexo;
    private JPanel Alta;
	private JLabel lblNombre;
	private JTextField tNombreMod;
	private JTextField tSexoMod;
	private JTextField tMailMod;
	private JTextField tEdadMod;
	private JTextField tDomicilioMod;
	private JButton btnUpdatePac;
	private JCheckBox chckbxActivo;
	private JLabel lblSexo;
	private JLabel lblPeticionesCompletas;
	private JLabel lblPeticionesPendientes;
	private JButton btnLimpiar;

	private List<PeticionDTO> peticionesCompletas;
	private List<PeticionDTO> peticionesPendientes;
	
    /**
     * @wbp.parser.entryPoint
     */
    public JTabbedPane setPanelPaciente(){
    	tabbedPane_1 = new JTabbedPane(JTabbedPane.LEFT);
    	tabbedPane_1.setBackground(Color.WHITE);
    	tabbedPane_1.setBounds(100, 100, 629, 476);
        tabbedPane_1.add("Alta", setAltaPaciente());
        tabbedPane_1.add("Baja", setBajaPaciente());
        tabbedPane_1.add("Modificar", setModificarPaciente());

        asociarEventos();
        
        return tabbedPane_1;
    }
    
    private Panel setModificarPaciente() {
        Modificar = new Panel();

        btnObtenerPac = new Button("Obtener Paciente");
        btnObtenerPac.setFont(new Font("Tahoma", Font.BOLD, 12));
        btnObtenerPac.setForeground(Color.WHITE);
        btnObtenerPac.setBackground(SystemColor.activeCaption);
        btnObtenerPac.setBounds(230, 174, 50, 27);

        tDNIMod = new JTextField();
        tDNIMod.setColumns(10);

        lbldni = new JLabel("DNI");

        lblBaja = new JLabel("Por favor, ingrese el DNI del paciente que desea modificar");
        
        lblNombre = new JLabel("NOMBRE");
        
        tNombreMod = new JTextField();
        tNombreMod.setColumns(10);
        
        lblSexo = new JLabel("SEXO");
        
        tSexoMod = new JTextField();
        tSexoMod.setColumns(10);
        
        tMailMod = new JTextField();
        tMailMod.setColumns(10);
        
        JLabel lblMail = new JLabel("MAIL");
        
        JLabel lblEstado = new JLabel("ESTADO");
        
        JLabel lblEdadMod = new JLabel("EDAD");
        
        tEdadMod = new JTextField();
        tEdadMod.setColumns(10);
        
        JLabel lbldomicilio = new JLabel("DOMICILIO");
        
        tDomicilioMod = new JTextField();
        tDomicilioMod.setColumns(10);
        
        JLabel lblPeticiones = new JLabel("PETICIONES");
        
        JLabel lblCompletas = new JLabel("N° de peticiones completas:");
        
        JLabel lblPendientes = new JLabel("N° de peticiones pendientes:");
        
        lblPeticionesCompletas = new JLabel("N/A");
        
        lblPeticionesPendientes = new JLabel("N/A");
        
        btnUpdatePac = new JButton("Modificar paciente");
        btnUpdatePac.setEnabled(false);
        
        chckbxActivo = new JCheckBox("Activo");
        chckbxActivo.setBackground(Color.WHITE);
        
        btnLimpiar = new JButton("Limpiar formulario");


        //Layout
        GroupLayout gl_Modificar = new GroupLayout(Modificar);
        gl_Modificar.setHorizontalGroup(
        	gl_Modificar.createParallelGroup(Alignment.LEADING)
        		.addGroup(gl_Modificar.createSequentialGroup()
        			.addGroup(gl_Modificar.createParallelGroup(Alignment.LEADING)
        				.addGroup(gl_Modificar.createSequentialGroup()
        					.addGap(35)
        					.addGroup(gl_Modificar.createParallelGroup(Alignment.LEADING)
        						.addGroup(gl_Modificar.createSequentialGroup()
        							.addGroup(gl_Modificar.createParallelGroup(Alignment.LEADING)
        								.addComponent(lblEstado)
        								.addComponent(chckbxActivo))
        							.addGap(25)
        							.addGroup(gl_Modificar.createParallelGroup(Alignment.LEADING)
        								.addComponent(lblPeticiones)
        								.addGroup(gl_Modificar.createSequentialGroup()
        									.addGroup(gl_Modificar.createParallelGroup(Alignment.LEADING)
        										.addComponent(lblPendientes)
        										.addComponent(lblCompletas))
        									.addGap(18)
        									.addGroup(gl_Modificar.createParallelGroup(Alignment.LEADING, false)
        										.addComponent(lblPeticionesPendientes, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        										.addComponent(lblPeticionesCompletas, GroupLayout.DEFAULT_SIZE, 33, Short.MAX_VALUE)))))
        						.addGroup(gl_Modificar.createSequentialGroup()
        							.addGroup(gl_Modificar.createParallelGroup(Alignment.LEADING)
        								.addGroup(gl_Modificar.createParallelGroup(Alignment.TRAILING, false)
        									.addComponent(tMailMod, Alignment.LEADING)
        									.addComponent(tNombreMod, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 255, Short.MAX_VALUE))
        								.addComponent(lblNombre)
        								.addComponent(lblBaja)
        								.addComponent(lbldni)
        								.addComponent(tDNIMod, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        								.addComponent(lblMail)
        								.addComponent(btnObtenerPac, GroupLayout.PREFERRED_SIZE, 140, GroupLayout.PREFERRED_SIZE))
        							.addPreferredGap(ComponentPlacement.RELATED)
        							.addGroup(gl_Modificar.createParallelGroup(Alignment.LEADING, false)
        								.addGroup(gl_Modificar.createSequentialGroup()
        									.addGroup(gl_Modificar.createParallelGroup(Alignment.LEADING)
        										.addComponent(tEdadMod, GroupLayout.PREFERRED_SIZE, 41, GroupLayout.PREFERRED_SIZE)
        										.addComponent(lblEdadMod))
        									.addGap(18)
        									.addGroup(gl_Modificar.createParallelGroup(Alignment.LEADING)
        										.addComponent(lblSexo)
        										.addComponent(tSexoMod, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
        								.addComponent(lbldomicilio)
        								.addComponent(btnUpdatePac, GroupLayout.DEFAULT_SIZE, 189, Short.MAX_VALUE)
        								.addComponent(tDomicilioMod)))))
        				.addGroup(gl_Modificar.createSequentialGroup()
        					.addGap(26)
        					.addComponent(btnLimpiar)))
        			.addContainerGap(56, Short.MAX_VALUE))
        );
        gl_Modificar.setVerticalGroup(
        	gl_Modificar.createParallelGroup(Alignment.LEADING)
        		.addGroup(gl_Modificar.createSequentialGroup()
        			.addGap(22)
        			.addComponent(lblBaja)
        			.addPreferredGap(ComponentPlacement.UNRELATED)
        			.addComponent(lbldni)
        			.addGap(4)
        			.addComponent(tDNIMod, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        			.addPreferredGap(ComponentPlacement.UNRELATED)
        			.addGroup(gl_Modificar.createParallelGroup(Alignment.LEADING)
        				.addComponent(btnObtenerPac, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
        				.addComponent(btnUpdatePac))
        			.addGap(23)
        			.addGroup(gl_Modificar.createParallelGroup(Alignment.BASELINE)
        				.addComponent(lblNombre)
        				.addComponent(lbldomicilio))
        			.addPreferredGap(ComponentPlacement.RELATED)
        			.addGroup(gl_Modificar.createParallelGroup(Alignment.BASELINE)
        				.addComponent(tNombreMod, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        				.addComponent(tDomicilioMod, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
        			.addPreferredGap(ComponentPlacement.UNRELATED)
        			.addGroup(gl_Modificar.createParallelGroup(Alignment.BASELINE)
        				.addComponent(lblMail)
        				.addComponent(lblEdadMod)
        				.addComponent(lblSexo))
        			.addPreferredGap(ComponentPlacement.RELATED)
        			.addGroup(gl_Modificar.createParallelGroup(Alignment.BASELINE)
        				.addComponent(tMailMod, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        				.addComponent(tEdadMod, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        				.addComponent(tSexoMod, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
        			.addGap(18)
        			.addGroup(gl_Modificar.createParallelGroup(Alignment.BASELINE)
        				.addComponent(lblEstado)
        				.addComponent(lblPeticiones))
        			.addPreferredGap(ComponentPlacement.UNRELATED)
        			.addGroup(gl_Modificar.createParallelGroup(Alignment.BASELINE)
        				.addComponent(lblCompletas)
        				.addComponent(lblPeticionesCompletas)
        				.addComponent(chckbxActivo))
        			.addGap(1)
        			.addGroup(gl_Modificar.createParallelGroup(Alignment.BASELINE)
        				.addComponent(lblPendientes)
        				.addComponent(lblPeticionesPendientes))
        			.addGap(29)
        			.addComponent(btnLimpiar)
        			.addContainerGap(107, Short.MAX_VALUE))
        );
        Modificar.setLayout(gl_Modificar);

        return Modificar;
    }

    private Panel setBajaPaciente() {
        Baja = new Panel();

        btnDeletePac = new Button("Eliminar Paciente");
        btnDeletePac.setFont(new Font("Tahoma", Font.BOLD, 12));
        btnDeletePac.setForeground(Color.WHITE);
        btnDeletePac.setBackground(Color.RED);
        btnDeletePac.setBounds(230, 174, 50, 27);

        tDNI = new JTextField();
        tDNI.setColumns(10);

        lbldni = new JLabel("DNI");

        lblBaja = new JLabel("Por favor, ingrese el DNI del paciente que desea eliminar.");

        //Layout
        GroupLayout gl_Baja = new GroupLayout(Baja);
        gl_Baja.setHorizontalGroup(gl_Baja.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(gl_Baja
                .createSequentialGroup().addGap(35)
                .addGroup(gl_Baja.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(lblBaja)
                        .addComponent(btnDeletePac, GroupLayout.PREFERRED_SIZE, 140, GroupLayout.PREFERRED_SIZE)
                        .addComponent(lbldni).addComponent(tDNI, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
                                GroupLayout.PREFERRED_SIZE))
                .addContainerGap(271, Short.MAX_VALUE)));
        gl_Baja.setVerticalGroup(gl_Baja.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(gl_Baja.createSequentialGroup()
                .addGap(22).addComponent(lblBaja).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(lbldni)
                .addGap(4)
                .addComponent(tDNI, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnDeletePac, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
                .addContainerGap(323, Short.MAX_VALUE)));
        Baja.setLayout(gl_Baja);

        return Baja;
    }

    private JPanel setAltaPaciente() {
        Alta = new JPanel(false);
        Alta.setBackground(Color.WHITE);

        btnAddPac = new Button("Agregar paciente");
        btnAddPac.setFont(new Font("Tahoma", Font.BOLD, 12));
        btnAddPac.setForeground(Color.WHITE);
        btnAddPac.setBackground(new Color(133, 189, 212));
        btnAddPac.setBounds(230, 174, 150, 27);

        tdni = new JTextField();
        tdni.setFont(new Font("Arial", Font.PLAIN, 15));
        tdni.setSize(190, 20);
        tdni.setLocation(200, 100);

        lblDNI = new JLabel("DNI");
        lblDNI.setForeground(SystemColor.windowText);
        lblDNI.setFont(new Font("Tahoma", Font.PLAIN, 11));

        JLabel lblNombre = new JLabel("NOMBRE");

        tNombre = new JTextField();
        tNombre.setColumns(10);

        tDomicilio = new JTextField();
        tDomicilio.setColumns(10);

        lblDomicilio = new JLabel("DOMICILIO");

        lblEdad = new JLabel("EDAD");

        tEdad = new JTextField();
        tEdad.setColumns(10);

        JLabel lblMail = new JLabel("MAIL");

        tMail = new JTextField();
        tMail.setColumns(10);

        JLabel lblSexo = new JLabel("SEXO");

        tSexo = new JTextField();
        tSexo.setText("");
        tSexo.setColumns(10);

        // Layout
        GroupLayout gl_Alta = new GroupLayout(Alta);
        gl_Alta.setHorizontalGroup(
        	gl_Alta.createParallelGroup(Alignment.LEADING)
        		.addGroup(gl_Alta.createSequentialGroup()
        			.addGroup(gl_Alta.createParallelGroup(Alignment.LEADING)
        				.addGroup(gl_Alta.createSequentialGroup()
        					.addGap(31)
        					.addGroup(gl_Alta.createParallelGroup(Alignment.LEADING)
        						.addComponent(tDomicilio, 481, 481, 481)
        						.addComponent(lblDomicilio)
        						.addComponent(lblNombre)
        						.addGroup(gl_Alta.createSequentialGroup()
        							.addComponent(lblDNI, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
        							.addGap(145)
        							.addComponent(lblMail))
        						.addGroup(gl_Alta.createParallelGroup(Alignment.LEADING, false)
        							.addComponent(tNombre)
        							.addGroup(gl_Alta.createSequentialGroup()
        								.addComponent(tdni, GroupLayout.PREFERRED_SIZE, 162, GroupLayout.PREFERRED_SIZE)
        								.addGap(18)
        								.addComponent(tMail, 301, 301, 301)))
        						.addGroup(gl_Alta.createSequentialGroup()
        							.addGroup(gl_Alta.createParallelGroup(Alignment.LEADING)
        								.addComponent(lblEdad)
        								.addComponent(tEdad, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE))
        							.addGap(33)
        							.addGroup(gl_Alta.createParallelGroup(Alignment.LEADING)
        								.addComponent(tSexo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        								.addComponent(lblSexo)))))
        				.addGroup(gl_Alta.createSequentialGroup()
        					.addGap(171)
        					.addComponent(btnAddPac, GroupLayout.PREFERRED_SIZE, 206, GroupLayout.PREFERRED_SIZE)))
        			.addContainerGap(53, Short.MAX_VALUE))
        );
        gl_Alta.setVerticalGroup(
        	gl_Alta.createParallelGroup(Alignment.LEADING)
        		.addGroup(gl_Alta.createSequentialGroup()
        			.addGap(28)
        			.addComponent(btnAddPac, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)
        			.addGap(28)
        			.addGroup(gl_Alta.createParallelGroup(Alignment.BASELINE)
        				.addComponent(lblDNI)
        				.addComponent(lblMail))
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
        			.addComponent(lblDomicilio)
        			.addPreferredGap(ComponentPlacement.RELATED)
        			.addComponent(tDomicilio, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        			.addPreferredGap(ComponentPlacement.UNRELATED)
        			.addGroup(gl_Alta.createParallelGroup(Alignment.BASELINE)
        				.addComponent(lblEdad)
        				.addComponent(lblSexo))
        			.addPreferredGap(ComponentPlacement.RELATED)
        			.addGroup(gl_Alta.createParallelGroup(Alignment.BASELINE)
        				.addComponent(tEdad, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        				.addComponent(tSexo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
        			.addContainerGap(203, Short.MAX_VALUE))
        );
        Alta.setLayout(gl_Alta);

        Alta.setVisible(true);
        return Alta;
    }
    
    private void alert(String msg, String type, int pane) {
        JOptionPane.showMessageDialog(tabbedPane_1, msg, type, pane);
    }
    
    private void limpiarFormulario() {
		tdni.setText("");
		tNombre.setText("");;
		tDomicilio.setText("");
		tEdad.setText("");
		tSexo.setText("");
		tMail.setText("");
		tDNI.setText("");
		tDNIMod.setText("");
		tNombreMod.setText("");
		tEdadMod.setText("");
		tDomicilioMod.setText("");
		tSexoMod.setText("");
		tMailMod.setText("");
    }
    
    private void asociarEventos() {
		PacienteController pacienteController = PacienteController.getInstance();
		
        btnAddPac.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
				PacienteDTO p = new PacienteDTO();
				String dni = tdni.getText();
				String nombre = tNombre.getText();
				String domicilio = tDomicilio.getText();
				String edad = tEdad.getText();
				String sexo = tSexo.getText();
				String mail = tMail.getText();

				if(!dni.isBlank() && !nombre.isBlank() && !mail.isBlank() && !domicilio.isBlank() && !sexo.isBlank() && !edad.isBlank()) {
					p.dni = dni;
					p.nombre = nombre;
					p.domicilio = domicilio;
					p.edad = Integer.parseInt(edad);
					p.sexo = sexo;
					p.mail = mail;
					p.id = Integer.parseInt(dni);
					p.estado = EstadoPaciente.Activo;

					try {
						p = pacienteController.AltaPaciente(p);
						limpiarFormulario();
						alert("Se creó correctamente", "Información", JOptionPane.INFORMATION_MESSAGE);
					} catch (Exception ex) {
						alert("El paciente ya existe.", "Error", JOptionPane.ERROR_MESSAGE);
					}

				}else {
					alert("Falta información.", "Error", JOptionPane.ERROR_MESSAGE);
				}
				
				
            }
        });
        
        btnUpdatePac.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
				PacienteDTO p = new PacienteDTO();
				p.dni = tDNIMod.getText();
				p.nombre = tNombreMod.getText();
				p.domicilio = tDomicilioMod.getText();
				p.edad = Integer.parseInt(tEdadMod.getText());
				p.sexo = tSexoMod.getText();
				p.mail = tMailMod.getText();
				p.id = Integer.parseInt(p.dni);
				p.peticionesCompletas = peticionesCompletas;
				p.peticionePendientes = peticionesPendientes;

				if(chckbxActivo.isSelected()) {
					p.estado = EstadoPaciente.Activo;
				}else {
					p.estado = EstadoPaciente.Inactivo;
				}

				if(pacienteController.ModificarPaciente(p)) {
					limpiarFormulario();
					tDNIMod.setEnabled(true);
					btnObtenerPac.setEnabled(true);
					btnUpdatePac.setEnabled(false);
					chckbxActivo.setSelected(false);
				    alert("Se modificó correctamente", "Información", JOptionPane.INFORMATION_MESSAGE);
				}else {
					alert("No se pudo modificar.", "Error", JOptionPane.ERROR_MESSAGE);
				}
				
				
            }
        });
        
        btnObtenerPac.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		int id = Integer.parseInt(tDNIMod.getText());
        		
        		if(!tDNIMod.getText().isBlank()) {
        			PacienteDTO p = pacienteController.ObtenerPaciente(id);
        			tNombreMod.setText(p.nombre);
        			tEdadMod.setText(String.valueOf(p.edad));
        			tDomicilioMod.setText(p.domicilio);
        			tSexoMod.setText(p.sexo);
					tMailMod.setText(p.mail);

					if (p.peticionesCompletas!= null){
						peticionesCompletas = p.peticionesCompletas;
						lblPeticionesCompletas.setText(String.valueOf(p.peticionesCompletas.size()));
					}

					if(p.peticionePendientes != null){
						peticionesPendientes = p.peticionePendientes;
        				lblPeticionesPendientes.setText(String.valueOf(p.peticionePendientes.size()));
					}
        			
        			if(p.estado.toString().equals("Activo")) {
        				chckbxActivo.setSelected(true);
        			}else {
        				chckbxActivo.setSelected(false);
        			}

					tDNIMod.setEnabled(false);
					btnObtenerPac.setEnabled(false);
					btnUpdatePac.setEnabled(true);
        			
        		}else {
        			alert("No se pudo encontrar el DNI.", "Error", JOptionPane.ERROR_MESSAGE);
        		}
        	}
        });
        
        btnDeletePac.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		int dni = Integer.parseInt(tDNI.getText());
        		
        		if(pacienteController.BajaPaciente(dni)) {
        			limpiarFormulario();
    				alert("El paciente se borró correctamente", "Información", JOptionPane.INFORMATION_MESSAGE);
        		}
        		else {
                    alert("El paciente no se puede eliminar, tiene peticiones finalizadas.", "Error", JOptionPane.ERROR_MESSAGE);
        		}
        	}
        });

		tabbedPane_1.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				limpiarFormulario();
			}
		});
		
        btnLimpiar.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		tDNIMod.setEnabled(true);
        		limpiarFormulario();
				btnObtenerPac.setEnabled(true);
				btnUpdatePac.setEnabled(false);
        	}
        });
    }
}
