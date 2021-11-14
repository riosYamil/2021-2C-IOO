package views;

import java.awt.Button;
import java.awt.Color;
import java.awt.Font;
import java.awt.Panel;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.GroupLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;
import javax.swing.SwingConstants;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;

public class PracticasPanel {

	private JTabbedPane tabbedPane_4;
    private Button btnAddPractica;
    private Button btnUpdatePractica;
    private JLabel lblID;
    private JTextField tdni;
    private JTextField tNombre;
    private JTextField tValCriticoMax;
    private JLabel lblValCriticoMax;
    private Panel Baja;
    private Button btnDelete;
    private JTextField tDNI;
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

	/**
	 * @wbp.parser.entryPoint
	 */
	public JTabbedPane setPracticasTab(String rol) {	
		tabbedPane_4 = new JTabbedPane(JTabbedPane.LEFT);
		tabbedPane_4.setBackground(Color.WHITE);
		tabbedPane_4.setBounds(100, 100, 629, 476);
		tabbedPane_4.add(setAltaPractica());
		tabbedPane_4.add(setBajaPractica());
		tabbedPane_4.setEnabledAt(0, true);
		tabbedPane_4.setTitleAt(0, "Alta");
		tabbedPane_4.setEnabledAt(1, true);
		tabbedPane_4.setTitleAt(1, "Baja");
		
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

	        tDNI = new JTextField();
	        tDNI.setColumns(10);

	        lbldni = new JLabel("DNI");

	        lblBaja = new JLabel("Por favor, ingrese el ID de la práctica que desea eliminar.");

	        //Layout
	        GroupLayout gl_Baja = new GroupLayout(Baja);
	        gl_Baja.setHorizontalGroup(gl_Baja.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(gl_Baja
	                .createSequentialGroup().addGap(35)
	                .addGroup(gl_Baja.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(lblBaja)
	                        .addComponent(btnDelete, GroupLayout.PREFERRED_SIZE, 140, GroupLayout.PREFERRED_SIZE)
	                        .addComponent(lbldni).addComponent(tDNI, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
	                                GroupLayout.PREFERRED_SIZE))
	                .addContainerGap(271, Short.MAX_VALUE)));
	        gl_Baja.setVerticalGroup(gl_Baja.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(gl_Baja.createSequentialGroup()
	                .addGap(22).addComponent(lblBaja).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(lbldni)
	                .addGap(4)
	                .addComponent(tDNI, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
	                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
	                .addComponent(btnDelete, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
	                .addContainerGap(323, Short.MAX_VALUE)));
	        Baja.setLayout(gl_Baja);

	        return Baja;
	    }

	    private JPanel setAltaPractica() {
	        JPanel Alta = new JPanel(false);
	        Alta.setBackground(Color.WHITE);

	        btnAddPractica = new Button("Agregar Practica");
	        btnAddPractica.setFont(new Font("Tahoma", Font.BOLD, 12));
	        btnAddPractica.setForeground(Color.WHITE);
	        btnAddPractica.setBackground(new Color(133, 189, 212));
	        btnAddPractica.setBounds(230, 174, 150, 27);

	        btnUpdatePractica = new Button("Modificar Practica");
	        btnUpdatePractica.setEnabled(false);
	        btnUpdatePractica.setFont(new Font("Tahoma", Font.BOLD, 12));
	        btnUpdatePractica.setForeground(Color.BLACK);
	        btnUpdatePractica.setBackground(new Color(133, 189, 212));
	        btnUpdatePractica.setBounds(230, 174, 150, 27);

	        tdni = new JTextField();
	        tdni.setFont(new Font("Arial", Font.PLAIN, 15));
	        tdni.setSize(190, 20);
	        tdni.setLocation(200, 100);

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
	        tValReservadoMax.setHorizontalAlignment(SwingConstants.CENTER);
	        tValReservadoMax.setForeground(Color.LIGHT_GRAY);
	        tValReservadoMax.setColumns(10);
	        
	        tValReservadoMin = new JTextField();
	        tValReservadoMin.setHorizontalAlignment(SwingConstants.CENTER);
	        tValReservadoMin.setForeground(Color.LIGHT_GRAY);
	        tValReservadoMin.setColumns(10);
	        
	        JRadioButton rdbtnAdmin = new JRadioButton("Habilitada");
	        rdbtnAdmin.setBackground(Color.WHITE);
	        
	        JLabel lblRol = new JLabel("ESTADO DE LA PRACTICA");
	        
	        lblPractica = new JLabel("Ingrese solo el ID de la practica para modificarla");
	        
	        lblValReservadoMax = new JLabel("VALOR RESERVADO MAX");
	        
	        lblValReservadoMin = new JLabel("VALOR RESERVADO MIN");
	        
	        lblGrupo = new JLabel("GRUPO");
	        
	        tGrupo = new JTextField();
	        tGrupo.setColumns(10);
	        
	        lblTiempoEstimado = new JLabel("TIEMPO ESTIMADO");
	        
	        lblTiempo = new JLabel("N/A");

	        // Layout
	        GroupLayout gl_Alta = new GroupLayout(Alta);
	        gl_Alta.setHorizontalGroup(
	        	gl_Alta.createParallelGroup(Alignment.LEADING)
	        		.addGroup(gl_Alta.createSequentialGroup()
	        			.addGap(31)
	        			.addGroup(gl_Alta.createParallelGroup(Alignment.LEADING)
	        				.addGroup(gl_Alta.createSequentialGroup()
	        					.addComponent(rdbtnAdmin)
	        					.addContainerGap())
	        				.addGroup(gl_Alta.createParallelGroup(Alignment.LEADING)
	        					.addGroup(gl_Alta.createSequentialGroup()
	        						.addComponent(lblRol)
	        						.addContainerGap())
	        					.addGroup(gl_Alta.createSequentialGroup()
	        						.addGroup(gl_Alta.createParallelGroup(Alignment.LEADING)
	        							.addComponent(lblPractica)
	        							.addGroup(gl_Alta.createParallelGroup(Alignment.LEADING)
	        								.addGroup(gl_Alta.createSequentialGroup()
	        									.addGroup(gl_Alta.createParallelGroup(Alignment.LEADING)
	        										.addGroup(gl_Alta.createParallelGroup(Alignment.LEADING)
	        											.addGroup(Alignment.TRAILING, gl_Alta.createSequentialGroup()
	        												.addComponent(btnAddPractica, GroupLayout.PREFERRED_SIZE, 229, GroupLayout.PREFERRED_SIZE)
	        												.addPreferredGap(ComponentPlacement.RELATED))
	        											.addGroup(Alignment.TRAILING, gl_Alta.createSequentialGroup()
	        												.addComponent(lblID, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
	        												.addGap(204)))
	        										.addComponent(tdni, GroupLayout.PREFERRED_SIZE, 162, GroupLayout.PREFERRED_SIZE))
	        									.addGap(10)
	        									.addComponent(btnUpdatePractica, GroupLayout.PREFERRED_SIZE, 227, GroupLayout.PREFERRED_SIZE))
	        								.addGroup(Alignment.TRAILING, gl_Alta.createSequentialGroup()
	        									.addGroup(gl_Alta.createParallelGroup(Alignment.LEADING)
	        										.addGroup(gl_Alta.createSequentialGroup()
	        											.addGroup(gl_Alta.createParallelGroup(Alignment.TRAILING)
	        												.addComponent(tNombre, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 256, Short.MAX_VALUE)
	        												.addGroup(gl_Alta.createSequentialGroup()
	        													.addGroup(gl_Alta.createParallelGroup(Alignment.LEADING, false)
	        														.addComponent(lblValCriticoMax, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
	        														.addComponent(tValCriticoMax)
	        														.addComponent(lblValReservadoMax, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
	        														.addComponent(tValReservadoMax))
	        													.addGap(18)
	        													.addGroup(gl_Alta.createParallelGroup(Alignment.LEADING)
	        														.addGroup(gl_Alta.createParallelGroup(Alignment.LEADING)
	        															.addComponent(tValCriticoMin, GroupLayout.DEFAULT_SIZE, 118, Short.MAX_VALUE)
	        															.addComponent(lblValCriticoMin, GroupLayout.DEFAULT_SIZE, 118, Short.MAX_VALUE)
	        															.addComponent(tValReservadoMin, GroupLayout.DEFAULT_SIZE, 118, Short.MAX_VALUE))
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
	        									.addGap(53))))
	        						.addGap(75)))))
	        );
	        gl_Alta.setVerticalGroup(
	        	gl_Alta.createParallelGroup(Alignment.LEADING)
	        		.addGroup(gl_Alta.createSequentialGroup()
	        			.addGap(30)
	        			.addGroup(gl_Alta.createParallelGroup(Alignment.BASELINE)
	        				.addComponent(btnAddPractica, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
	        				.addComponent(btnUpdatePractica, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
	        			.addGap(11)
	        			.addComponent(lblPractica)
	        			.addPreferredGap(ComponentPlacement.RELATED)
	        			.addComponent(lblID)
	        			.addGap(11)
	        			.addComponent(tdni, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE)
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
	        			.addComponent(lblRol)
	        			.addPreferredGap(ComponentPlacement.UNRELATED)
	        			.addComponent(rdbtnAdmin)
	        			.addContainerGap(128, Short.MAX_VALUE))
	        );
	        Alta.setLayout(gl_Alta);

	        Alta.setVisible(true);
	        return Alta;
	    }
	    
	    private void asociarEventos() {
	        btnAddPractica.addActionListener(new ActionListener() {
	        	public void actionPerformed(ActionEvent e) {
                    JOptionPane.showMessageDialog(tabbedPane_4, "Se creó correctamente", "Información",
                            JOptionPane.INFORMATION_MESSAGE);
	        	}
	        });
	        
	        btnUpdatePractica.addActionListener(new ActionListener() {
	        	public void actionPerformed(ActionEvent e) {
                    JOptionPane.showMessageDialog(tabbedPane_4, "Se modific� correctamente", "Informaci�n",
                            JOptionPane.INFORMATION_MESSAGE);
	        	}
	        });
	    	
	        btnDelete.addActionListener(new ActionListener() {
	        	public void actionPerformed(ActionEvent e) {
                    JOptionPane.showMessageDialog(tabbedPane_4, "Este práctica no se pudo eliminar.", "Error",
                            JOptionPane.ERROR_MESSAGE);
	        	}
	        });

	    }
}