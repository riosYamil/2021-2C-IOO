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
    private Button btnAddUs;
    private Button btnUpdateUs;
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
    private JTextField tAo;

	/**
	 * @wbp.parser.entryPoint
	 */
	public JTabbedPane setPracticasTab() {	
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

	    private JPanel setAltaPractica() {
	        JPanel Alta = new JPanel(false);
	        Alta.setBackground(Color.WHITE);

	        btnAddUs = new Button("Agregar usuario");
	        btnAddUs.setFont(new Font("Tahoma", Font.BOLD, 12));
	        btnAddUs.setForeground(Color.WHITE);
	        btnAddUs.setBackground(new Color(133, 189, 212));
	        btnAddUs.setBounds(230, 174, 150, 27);

	        btnUpdateUs = new Button("Modificar usuario");
	        btnUpdateUs.setFont(new Font("Tahoma", Font.BOLD, 12));
	        btnUpdateUs.setForeground(Color.WHITE);
	        btnUpdateUs.setBackground(new Color(133, 189, 212));
	        btnUpdateUs.setBounds(230, 174, 150, 27);

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
	        
	        tAo = new JTextField();
	        tAo.setForeground(Color.LIGHT_GRAY);
	        tAo.setText("A\u00D1O");
	        tAo.setHorizontalAlignment(SwingConstants.CENTER);
	        tAo.setColumns(10);
	        
	        JRadioButton rdbtnAdmin = new JRadioButton("Administrador");
	        rdbtnAdmin.setBackground(Color.WHITE);
	        
	        JLabel lblRol = new JLabel("ELIJA EL ROL:");
	        
	        JRadioButton rdbtnRecep = new JRadioButton("Recepcionista");
	        rdbtnRecep.setBackground(Color.WHITE);
	        
	        JRadioButton rdbtnLab = new JRadioButton("Laboratorista");
	        rdbtnLab.setBackground(Color.WHITE);

	        // Layout
	        GroupLayout gl_Alta = new GroupLayout(Alta);
	        gl_Alta.setHorizontalGroup(
	        	gl_Alta.createParallelGroup(Alignment.LEADING)
	        		.addGroup(gl_Alta.createSequentialGroup()
	        			.addGap(31)
	        			.addGroup(gl_Alta.createParallelGroup(Alignment.LEADING)
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
	        					.addGroup(gl_Alta.createSequentialGroup()
	        						.addPreferredGap(ComponentPlacement.RELATED)
	        						.addGroup(gl_Alta.createParallelGroup(Alignment.TRAILING)
	        							.addGroup(gl_Alta.createSequentialGroup()
	        								.addComponent(lblDNI, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
	        								.addGap(147)
	        								.addComponent(lblMail)
	        								.addGap(64))
	        							.addGroup(gl_Alta.createSequentialGroup()
	        								.addComponent(btnAddUs, GroupLayout.PREFERRED_SIZE, 229, GroupLayout.PREFERRED_SIZE)
	        								.addPreferredGap(ComponentPlacement.RELATED)
	        								.addComponent(btnUpdateUs, GroupLayout.PREFERRED_SIZE, 227, GroupLayout.PREFERRED_SIZE)
	        								.addPreferredGap(ComponentPlacement.RELATED))))
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
	        										.addComponent(tAo, 0, 0, Short.MAX_VALUE)))
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
	        				.addComponent(btnUpdateUs, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
	        			.addGap(36)
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
	        			.addGroup(gl_Alta.createParallelGroup(Alignment.BASELINE)
	        				.addComponent(lblDomicilio)
	        				.addComponent(lblFechaDeNacimiento))
	        			.addPreferredGap(ComponentPlacement.RELATED)
	        			.addGroup(gl_Alta.createParallelGroup(Alignment.BASELINE)
	        				.addComponent(tDomicilio, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
	        				.addComponent(tDia, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
	        				.addComponent(tMes, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
	        				.addComponent(tAo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
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
	        			.addContainerGap(129, Short.MAX_VALUE))
	        );
	        Alta.setLayout(gl_Alta);

	        Alta.setVisible(true);
	        return Alta;
	    }
	    
	    private void asociarEventos() {
	        btnAddUs.addActionListener(new ActionListener() {
	        	public void actionPerformed(ActionEvent e) {
                    JOptionPane.showMessageDialog(tabbedPane_4, "Se creó correctamente", "Información",
                            JOptionPane.INFORMATION_MESSAGE);
	        	}
	        });
	        
	        btnUpdateUs.addActionListener(new ActionListener() {
	        	public void actionPerformed(ActionEvent e) {
                    JOptionPane.showMessageDialog(tabbedPane_4, "Se modific� correctamente", "Informaci�n",
                            JOptionPane.INFORMATION_MESSAGE);
	        	}
	        });
	    	
	        btnDeleteUs.addActionListener(new ActionListener() {
	        	public void actionPerformed(ActionEvent e) {
                    JOptionPane.showMessageDialog(tabbedPane_4, "Este práctica no se pudo eliminar.", "Error",
                            JOptionPane.ERROR_MESSAGE);
	        	}
	        });

	    }
}