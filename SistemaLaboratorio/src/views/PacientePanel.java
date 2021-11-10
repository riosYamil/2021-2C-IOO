package views;

import controllers.PacienteController;
import dtos.PacienteDTO;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PacientePanel{
	
    private JTabbedPane tabbedPane_1;
    private Button btnAddPac;
    private Button btnUpdatePac;
    private JLabel lblDNI;
    private JTextField tdni;
    private JTextField tNombre;
    private JTextField tDomicilio;
    private JLabel lblDomicilio;
    private JLabel lblEdad;
    private JTextField tEdad;
    private Panel Baja;
    private Button btnDeletePac;
    private JTextField tDNI;
    private JLabel lbldni;
    private JLabel lblBaja;
    private JTextField tMail;
    private JTextField tSexo;

    /**
     * @wbp.parser.entryPoint
     */
    public JTabbedPane setPanelPaciente(){
    	tabbedPane_1 = new JTabbedPane(JTabbedPane.LEFT);
    	tabbedPane_1.setBackground(Color.WHITE);
    	tabbedPane_1.setBounds(100, 100, 629, 476);
        tabbedPane_1.add(setAltaPaciente());
        tabbedPane_1.add(setBajaPaciente());
        tabbedPane_1.setEnabledAt(0, true);
        tabbedPane_1.setTitleAt(0, "Alta");
        tabbedPane_1.setEnabledAt(1, true);
        tabbedPane_1.setTitleAt(1, "Baja");

        asociarEventos();
        
        return tabbedPane_1;
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
        JPanel Alta = new JPanel(false);
        Alta.setBackground(Color.WHITE);

        btnAddPac = new Button("Agregar paciente");
        btnAddPac.setFont(new Font("Tahoma", Font.BOLD, 12));
        btnAddPac.setForeground(Color.WHITE);
        btnAddPac.setBackground(new Color(133, 189, 212));
        btnAddPac.setBounds(230, 174, 150, 27);

        btnUpdatePac = new Button("Modificar paciente");
        btnUpdatePac.setFont(new Font("Tahoma", Font.BOLD, 12));
        btnUpdatePac.setForeground(Color.WHITE);
        btnUpdatePac.setBackground(new Color(133, 189, 212));
        btnUpdatePac.setBounds(230, 174, 150, 27);

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
        gl_Alta.setHorizontalGroup(gl_Alta.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(gl_Alta
                .createSequentialGroup().addGap(31)
                .addGroup(gl_Alta.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(lblNombre)
                        .addComponent(lblDomicilio)
                        .addGroup(gl_Alta.createSequentialGroup()
                                .addGroup(gl_Alta.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(lblEdad)
                                        .addComponent(tEdad, GroupLayout.PREFERRED_SIZE, 34,
                                                GroupLayout.PREFERRED_SIZE))
                                .addGap(33)
                                .addGroup(gl_Alta.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addComponent(tSexo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
                                                GroupLayout.PREFERRED_SIZE)
                                        .addComponent(lblSexo)))
                        .addGroup(gl_Alta.createSequentialGroup()
                                .addComponent(tdni, GroupLayout.PREFERRED_SIZE, 162, GroupLayout.PREFERRED_SIZE)
                                .addGap(18).addComponent(tMail))
                        .addComponent(tNombre, GroupLayout.DEFAULT_SIZE, 481, Short.MAX_VALUE).addComponent(tDomicilio)
                        .addGroup(gl_Alta.createParallelGroup(GroupLayout.Alignment.LEADING)
                                .addGroup(gl_Alta.createSequentialGroup()
                                        .addComponent(lblDNI, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
                                        .addGap(147).addComponent(lblMail).addGap(64))
                                .addGroup(GroupLayout.Alignment.TRAILING,
                                        gl_Alta.createSequentialGroup().addComponent(btnAddPac).addGap(18)
                                                .addComponent(btnUpdatePac)
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED))))
                .addContainerGap(70, Short.MAX_VALUE)));
        gl_Alta.setVerticalGroup(gl_Alta.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(gl_Alta.createSequentialGroup()
                .addGap(30)
                .addGroup(gl_Alta.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(btnAddPac)
                        .addComponent(btnUpdatePac))
                .addGap(36)
                .addGroup(gl_Alta.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(lblDNI).addComponent(lblMail))
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(gl_Alta.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(gl_Alta.createSequentialGroup()
                                .addComponent(tdni, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(lblNombre))
                        .addComponent(tMail, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
                                GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tNombre, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(lblDomicilio)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tDomicilio, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
                        GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(gl_Alta.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(lblEdad).addComponent(lblSexo))
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(gl_Alta.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(tEdad, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
                                GroupLayout.PREFERRED_SIZE)
                        .addComponent(tSexo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
                                GroupLayout.PREFERRED_SIZE))
                .addContainerGap(165, Short.MAX_VALUE)));
        Alta.setLayout(gl_Alta);

        Alta.setVisible(true);
        return Alta;
    }
    
    private void asociarEventos() {
		PacienteController pacienteController = PacienteController.getInstance();
		
        btnAddPac.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
				PacienteDTO p = new PacienteDTO();
				p.dni = tdni.getText();
				p.nombre = tNombre.getText();
				p.domicilio = tDomicilio.getText();
				p.edad = Integer.parseInt(tEdad.getText());
				p.sexo = tSexo.getText();
				p.mail = tMail.getText();
				pacienteController.AltaPaciente(p);
				
				JOptionPane.showMessageDialog(tabbedPane_1, "Se agregó correctamente.", "Información",
						JOptionPane.INFORMATION_MESSAGE);
            }
        });
        
        btnDeletePac.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		
        		//if error
        		if(true) {
                    JOptionPane.showMessageDialog(tabbedPane_1, "Este paciente no se puede eliminar.", "Error",
                            JOptionPane.ERROR_MESSAGE);
        		}
        	}
        });
        
        btnUpdatePac.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		
				JOptionPane.showMessageDialog(tabbedPane_1, "Se modific� correctamente.", "Informaci�n",
						JOptionPane.INFORMATION_MESSAGE);
        	}
        });
    }
}
