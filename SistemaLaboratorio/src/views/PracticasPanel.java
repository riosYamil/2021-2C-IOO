package views;

import controllers.PracticaController;
import dtos.PracticaDTO;
import enums.EstadoPractica;
import enums.Rol;

import javax.swing.*;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PracticasPanel {

	private JTabbedPane tabbedPane_4;
    private Button btnObtenerPractica;
    private JLabel lblID;
    private JTextField tid;
    private JTextField tNombre;
    private JTextField tValCriticoMax;
    private JLabel lblValCriticoMax;
    private Panel Baja;
    private Button btnDelete;
    private JTextField tID;
    private JLabel lbldni;
    private JLabel lblBaja;
    private JTextField tValCriticoMin;
    private JTextField tValReservadoMax;
    private JTextField tValReservadoMin;
    private JLabel lblPractica;
    private JLabel lblValReservadoMax;
    private JLabel lblValReservadoMin;
    private JLabel lblGrupo;
    private JTextField tGrupo;
    private JLabel lblTiempoEstimado;
    private JLabel lblTiempo;
    private JRadioButton rdbtnAdmin;
    private JButton btnUpdatePractica;
    private JButton btnLimpiar;
    private JTextField tPeticionID;
    private JTextField tIDPeticion;
    private JLabel lblNewLabel;

	/**
	 * @wbp.parser.entryPoint
	 */
	public JTabbedPane setPracticasTab(String rol) {	
		tabbedPane_4 = new JTabbedPane(JTabbedPane.LEFT);
		tabbedPane_4.setBackground(Color.WHITE);
		tabbedPane_4.setBounds(100, 100, 629, 476);
		tabbedPane_4.add("Alta", setAltaPractica());

		if(rol != Rol.Laboratista.toString()) {
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

	        lblBaja = new JLabel("Por favor, ingrese el ID de la peticón y su practica asociada que desea eliminar.");
	        
	        tIDPeticion = new JTextField();
	        tIDPeticion.setColumns(10);
	        
	        lblNewLabel = new JLabel("ID PETICION");

	        //Layout
	        GroupLayout gl_Baja = new GroupLayout(Baja);
	        gl_Baja.setHorizontalGroup(
	        	gl_Baja.createParallelGroup(Alignment.LEADING)
	        		.addGroup(gl_Baja.createSequentialGroup()
	        			.addGap(35)
	        			.addGroup(gl_Baja.createParallelGroup(Alignment.LEADING)
	        				.addComponent(lblBaja)
	        				.addComponent(btnDelete, GroupLayout.PREFERRED_SIZE, 140, GroupLayout.PREFERRED_SIZE)
	        				.addGroup(gl_Baja.createSequentialGroup()
	        					.addGroup(gl_Baja.createParallelGroup(Alignment.LEADING)
	        						.addComponent(tID, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
	        						.addComponent(lbldni))
	        					.addGap(46)
	        					.addGroup(gl_Baja.createParallelGroup(Alignment.LEADING)
	        						.addComponent(lblNewLabel)
	        						.addComponent(tIDPeticion, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))))
	        			.addContainerGap(277, Short.MAX_VALUE))
	        );
	        gl_Baja.setVerticalGroup(
	        	gl_Baja.createParallelGroup(Alignment.LEADING)
	        		.addGroup(gl_Baja.createSequentialGroup()
	        			.addGap(22)
	        			.addComponent(lblBaja)
	        			.addPreferredGap(ComponentPlacement.UNRELATED)
	        			.addGroup(gl_Baja.createParallelGroup(Alignment.BASELINE)
	        				.addComponent(lbldni)
	        				.addComponent(lblNewLabel))
	        			.addGap(4)
	        			.addGroup(gl_Baja.createParallelGroup(Alignment.BASELINE)
	        				.addComponent(tID, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
	        				.addComponent(tIDPeticion, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
	        			.addPreferredGap(ComponentPlacement.UNRELATED)
	        			.addComponent(btnDelete, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
	        			.addContainerGap(351, Short.MAX_VALUE))
	        );
	        Baja.setLayout(gl_Baja);

	        return Baja;
	    }

	    private JPanel setAltaPractica() {
	        JPanel Alta = new JPanel(false);
	        Alta.setBackground(Color.WHITE);

	        btnObtenerPractica = new Button("Obtener Practica");
	        btnObtenerPractica.setFont(new Font("Tahoma", Font.BOLD, 12));
	        btnObtenerPractica.setForeground(Color.WHITE);
	        btnObtenerPractica.setBackground(new Color(133, 189, 212));
	        btnObtenerPractica.setBounds(230, 174, 150, 27);

	        tid = new JTextField();
	        tid.setFont(new Font("Arial", Font.PLAIN, 15));
	        tid.setSize(190, 20);
	        tid.setLocation(200, 100);

	        lblID = new JLabel("ID");
	        lblID.setForeground(SystemColor.windowText);
	        lblID.setFont(new Font("Tahoma", Font.PLAIN, 11));

	        JLabel lblNombre = new JLabel("NOMBRE");

	        tNombre = new JTextField();
	        tNombre.setEditable(false);
	        tNombre.setColumns(10);

	        tValCriticoMax = new JTextField();
	        tValCriticoMax.setEditable(false);
	        tValCriticoMax.setColumns(10);

	        lblValCriticoMax = new JLabel("VALOR CRITICO MAX");

	        JLabel lblValCriticoMin = new JLabel("VALOR CRITICO MIN");

	        tValCriticoMin = new JTextField();
	        tValCriticoMin.setEditable(false);
	        tValCriticoMin.setText("");
	        tValCriticoMin.setColumns(10);
	        
	        tValReservadoMax = new JTextField();
	        tValReservadoMax.setEditable(false);
	        tValReservadoMax.setHorizontalAlignment(SwingConstants.LEFT);
	        tValReservadoMax.setForeground(Color.BLACK);
	        tValReservadoMax.setColumns(10);
	        
	        tValReservadoMin = new JTextField();
	        tValReservadoMin.setEditable(false);
	        tValReservadoMin.setHorizontalAlignment(SwingConstants.LEFT);
	        tValReservadoMin.setForeground(Color.BLACK);
	        tValReservadoMin.setColumns(10);
	        
	        rdbtnAdmin = new JRadioButton("Habilitada");
	        rdbtnAdmin.setEnabled(false);
	        rdbtnAdmin.setBackground(Color.WHITE);
	        
	        JLabel lblRol = new JLabel("ESTADO DE LA PRACTICA:");
	        
	        lblPractica = new JLabel("Ingrese el ID de la peticion y de la practica para obtener una practica y modificarla");
	        
	        lblValReservadoMax = new JLabel("VALOR RESERVADO MAX");
	        
	        lblValReservadoMin = new JLabel("VALOR RESERVADO MIN");
	        
	        lblGrupo = new JLabel("GRUPO");
	        
	        tGrupo = new JTextField();
	        tGrupo.setEditable(false);
	        tGrupo.setColumns(10);
	        
	        lblTiempoEstimado = new JLabel("TIEMPO ESTIMADO");
	        
	        lblTiempo = new JLabel("N/A");
	        
	        btnUpdatePractica = new JButton("Modifcar práctica");

	        btnUpdatePractica.setEnabled(false);
	        
	        btnLimpiar = new JButton("Limpiar formulario");
	        
	        tPeticionID = new JTextField();
	        tPeticionID.setColumns(10);
	        
	        JLabel lblPeticion = new JLabel("ID PETICION");

	        // Layout
	        GroupLayout gl_Alta = new GroupLayout(Alta);
	        gl_Alta.setHorizontalGroup(
	        	gl_Alta.createParallelGroup(Alignment.LEADING)
	        		.addGroup(gl_Alta.createSequentialGroup()
	        			.addGap(31)
	        			.addGroup(gl_Alta.createParallelGroup(Alignment.LEADING)
	        				.addGroup(gl_Alta.createSequentialGroup()
	        					.addComponent(btnUpdatePractica)
	        					.addPreferredGap(ComponentPlacement.RELATED)
	        					.addComponent(btnLimpiar)
	        					.addGap(372))
	        				.addGroup(gl_Alta.createParallelGroup(Alignment.LEADING)
	        					.addGroup(gl_Alta.createSequentialGroup()
	        						.addComponent(lblRol)
	        						.addGap(18)
	        						.addComponent(rdbtnAdmin)
	        						.addGap(362))
	        					.addGroup(gl_Alta.createSequentialGroup()
	        						.addGroup(gl_Alta.createParallelGroup(Alignment.LEADING)
	        							.addComponent(lblPractica)
	        							.addGroup(gl_Alta.createSequentialGroup()
	        								.addGroup(gl_Alta.createParallelGroup(Alignment.LEADING)
	        									.addGroup(gl_Alta.createSequentialGroup()
	        										.addGroup(gl_Alta.createParallelGroup(Alignment.TRAILING)
	        											.addComponent(tNombre, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 288, Short.MAX_VALUE)
	        											.addGroup(gl_Alta.createSequentialGroup()
	        												.addGroup(gl_Alta.createParallelGroup(Alignment.LEADING, false)
	        													.addComponent(lblValCriticoMax, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
	        													.addComponent(tValCriticoMax)
	        													.addComponent(lblValReservadoMax, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
	        													.addComponent(tValReservadoMax))
	        												.addGap(18)
	        												.addGroup(gl_Alta.createParallelGroup(Alignment.LEADING)
	        													.addGroup(gl_Alta.createParallelGroup(Alignment.LEADING)
	        														.addComponent(tValCriticoMin, GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE)
	        														.addComponent(lblValCriticoMin, GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE)
	        														.addComponent(tValReservadoMin, GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE))
	        													.addComponent(lblValReservadoMin))))
	        										.addGap(18))
	        									.addGroup(gl_Alta.createSequentialGroup()
	        										.addComponent(lblNombre)
	        										.addGap(232)))
	        								.addGroup(gl_Alta.createParallelGroup(Alignment.LEADING)
	        									.addComponent(lblGrupo)
	        									.addComponent(tGrupo, GroupLayout.PREFERRED_SIZE, 176, GroupLayout.PREFERRED_SIZE)
	        									.addComponent(lblTiempoEstimado)
	        									.addComponent(lblTiempo))
	        								.addGap(53)))
	        						.addGap(75))
	        					.addGroup(gl_Alta.createSequentialGroup()
	        						.addGroup(gl_Alta.createParallelGroup(Alignment.TRAILING)
	        							.addComponent(tid, GroupLayout.DEFAULT_SIZE, 35, Short.MAX_VALUE)
	        							.addComponent(lblID, GroupLayout.DEFAULT_SIZE, 35, Short.MAX_VALUE))
	        						.addGap(18)
	        						.addGroup(gl_Alta.createParallelGroup(Alignment.LEADING)
	        							.addComponent(tPeticionID, GroupLayout.PREFERRED_SIZE, 51, GroupLayout.PREFERRED_SIZE)
	        							.addComponent(lblPeticion))
	        						.addGap(495)))))
	        		.addGroup(gl_Alta.createSequentialGroup()
	        			.addGap(160)
	        			.addComponent(btnObtenerPractica, GroupLayout.PREFERRED_SIZE, 227, GroupLayout.PREFERRED_SIZE)
	        			.addContainerGap(254, Short.MAX_VALUE))
	        );
	        gl_Alta.setVerticalGroup(
	        	gl_Alta.createParallelGroup(Alignment.LEADING)
	        		.addGroup(gl_Alta.createSequentialGroup()
	        			.addGap(23)
	        			.addComponent(btnObtenerPractica, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
	        			.addGap(18)
	        			.addComponent(lblPractica)
	        			.addPreferredGap(ComponentPlacement.RELATED)
	        			.addGroup(gl_Alta.createParallelGroup(Alignment.BASELINE)
	        				.addComponent(lblPeticion)
	        				.addComponent(lblID))
	        			.addPreferredGap(ComponentPlacement.RELATED)
	        			.addGroup(gl_Alta.createParallelGroup(Alignment.BASELINE)
	        				.addComponent(tid, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE)
	        				.addComponent(tPeticionID, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
	        			.addPreferredGap(ComponentPlacement.RELATED)
	        			.addGroup(gl_Alta.createParallelGroup(Alignment.BASELINE)
	        				.addComponent(lblNombre)
	        				.addComponent(lblGrupo))
	        			.addPreferredGap(ComponentPlacement.RELATED)
	        			.addGroup(gl_Alta.createParallelGroup(Alignment.BASELINE)
	        				.addComponent(tNombre, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
	        				.addComponent(tGrupo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
	        			.addPreferredGap(ComponentPlacement.UNRELATED)
	        			.addGroup(gl_Alta.createParallelGroup(Alignment.BASELINE)
	        				.addComponent(lblValCriticoMax)
	        				.addComponent(lblValCriticoMin)
	        				.addComponent(lblTiempoEstimado))
	        			.addPreferredGap(ComponentPlacement.RELATED)
	        			.addGroup(gl_Alta.createParallelGroup(Alignment.BASELINE)
	        				.addComponent(tValCriticoMax, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
	        				.addComponent(tValCriticoMin, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
	        				.addComponent(lblTiempo))
	        			.addGap(14)
	        			.addGroup(gl_Alta.createParallelGroup(Alignment.BASELINE)
	        				.addComponent(lblValReservadoMax)
	        				.addComponent(lblValReservadoMin))
	        			.addPreferredGap(ComponentPlacement.RELATED)
	        			.addGroup(gl_Alta.createParallelGroup(Alignment.BASELINE)
	        				.addComponent(tValReservadoMax, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
	        				.addComponent(tValReservadoMin, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
	        			.addGap(18)
	        			.addGroup(gl_Alta.createParallelGroup(Alignment.BASELINE)
	        				.addComponent(lblRol)
	        				.addComponent(rdbtnAdmin))
	        			.addPreferredGap(ComponentPlacement.UNRELATED)
	        			.addGroup(gl_Alta.createParallelGroup(Alignment.BASELINE)
	        				.addComponent(btnUpdatePractica)
	        				.addComponent(btnLimpiar))
	        			.addContainerGap(119, Short.MAX_VALUE))
	        );
	        Alta.setLayout(gl_Alta);

	        Alta.setVisible(true);
	        return Alta;
	    }
	    
	    private void asociarEventos() {
	    	PracticaController pc = PracticaController.getInstance();
	    		        
	        btnObtenerPractica.addActionListener(new ActionListener() {
	        	public void actionPerformed(ActionEvent e) {
	        		String id = tid.getText();
	        		String idPeticion = tPeticionID.getText();
	        		
	        		if(!id.isBlank() && !idPeticion.isBlank()) {
						PracticaDTO p = new PracticaDTO();
						try {
							p = pc.ObtenerPractica(Integer.parseInt(id));
						} catch (Exception ex) {
							alert("No se pudo obtener la practica ingresada (" + ex.getMessage() + ").", "Error", JOptionPane.ERROR_MESSAGE);
						}
						tNombre.setText(p.nombre);
						tGrupo.setText(p.grupo);
						tValCriticoMax.setText(String.valueOf(p.valorCriticoMax));
						tValCriticoMin.setText(String.valueOf(p.valorCriticoMin));
						tValReservadoMax.setText(String.valueOf(p.valorReservadoMax));
						tValReservadoMin.setText(String.valueOf(p.valorReservadoMin));

						if (p.estadoPractica == EstadoPractica.Habilitado) {
							rdbtnAdmin.setSelected(true);
						}
						tid.setEnabled(false);
						tPeticionID.setEditable(false);
						tValCriticoMax.setEditable(true);
						tValCriticoMin.setEditable(true);
						tValReservadoMax.setEditable(true);
						tValReservadoMin.setEditable(true);
						rdbtnAdmin.setEnabled(true);
						btnUpdatePractica.setEnabled(true);
	        		}else {
	                    alert("No se reconoce ese ID.", "Error", JOptionPane.ERROR_MESSAGE);
	        		}
	        	}
	        });
	    	
	        if(btnDelete != null) {
		        btnDelete.addActionListener(new ActionListener() {
		        	public void actionPerformed(ActionEvent e) {
						String id = tID.getText();
						String idPeticion = tIDPeticion.getText();

						if (!id.isBlank() && !idPeticion.isBlank()) {
							try {
								if (pc.BajaPractica(Integer.parseInt(id))) {
									limpiarFormulario();
									alert("Se eliminó correctamente", "Información", JOptionPane.INFORMATION_MESSAGE);
								} else {
									alert("Este práctica no se pudo eliminar.", "Error", JOptionPane.ERROR_MESSAGE);
								}
							} catch (Exception ex) {
								alert("Este práctica no se pudo eliminar (" + ex.getMessage() + ").", "Error", JOptionPane.ERROR_MESSAGE);
							}
						} else {
							alert("No se reconoce ese ID.", "Error", JOptionPane.ERROR_MESSAGE);
						}


					}
		        });
	        }
	        
	        
	        btnUpdatePractica.addActionListener(new ActionListener() {
	        	public void actionPerformed(ActionEvent e) {
					String id = tid.getText();
					String nombre = tNombre.getText();
					String grupo = tGrupo.getText();
					String valorReservadoMax = tValReservadoMax.getText();
					String valorReservadoMin = tValReservadoMin.getText();
					String valorCriticoMax = tValCriticoMax.getText();
					String valorCriticoMin = tValCriticoMin.getText();
					boolean habilitado = rdbtnAdmin.isSelected();

					PracticaDTO p = new PracticaDTO();
					p.id = Integer.parseInt(id);
					p.nombre = nombre;
					p.grupo = grupo;
					p.valorCriticoMax = Integer.parseInt(valorCriticoMax);
					p.valorCriticoMin = Integer.parseInt(valorCriticoMin);
					p.valorReservadoMax = Integer.parseInt(valorReservadoMax);
					p.valorReservadoMin = Integer.parseInt(valorReservadoMin);
					//p.horasEsperaResultado = calcular

					if (habilitado) {
						p.estadoPractica = EstadoPractica.Habilitado;
					} else {
						p.estadoPractica = EstadoPractica.Inhabilidado;
					}
					try {
						if (pc.ModificarPractica(p)) {
							alert("Se modificó correctamente", "Información", JOptionPane.INFORMATION_MESSAGE);
						} else {
							alert("Este práctica no se pudo modificar.", "Error", JOptionPane.ERROR_MESSAGE);
						}
					} catch (Exception ex) {
						alert("Este práctica no se pudo modificar (" + ex.getMessage() + ").", "Error", JOptionPane.ERROR_MESSAGE);
					}

				}
	        });
	        
	        btnLimpiar.addActionListener(new ActionListener() {
	        	public void actionPerformed(ActionEvent e) {
	        		limpiarFormulario();
	        	}
	        });

	        
			tabbedPane_4.addChangeListener(new ChangeListener() {
				public void stateChanged(ChangeEvent e) {
					limpiarFormulario();
				}
			});
			

	    }
	    
	    private void limpiarFormulario() {
	    	if(tID != null) {
		    	tID.setText("");
		    	tIDPeticion.setText("");
	    	}
			tNombre.setText("");
			tGrupo.setText("");
			tValCriticoMax.setText("");
			tValCriticoMin.setText("");
			tValReservadoMax.setText("");
			tValReservadoMin.setText("");
			tid.setEnabled(true);
			tPeticionID.setEditable(true);
			tValCriticoMax.setEditable(false);
			tValCriticoMin.setEditable(false);
			tValReservadoMax.setEditable(false);
			tValReservadoMin.setEditable(false);
			rdbtnAdmin.setEnabled(false);
			btnUpdatePractica.setEnabled(false);
			rdbtnAdmin.setSelected(false);
	    }
	    
	    private void alert(String msg, String type, int pane) {
	        JOptionPane.showMessageDialog(tabbedPane_4, msg, type, pane);
	    }
}