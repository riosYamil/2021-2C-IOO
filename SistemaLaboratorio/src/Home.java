import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import java.awt.Button;
import java.awt.SystemColor;
import javax.swing.JTextField;
import javax.swing.JSeparator;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import javax.swing.JMenuBar;

public class Home extends JFrame {

	private JPanel contentPane;	
	private JPanel panel;
	private Button btnAdmin;
	private Button btnRecep;
	private Button btnLabo;
	private JLabel lblTitle;
	private JLabel lblSelect;
	
	int xx,xy;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Home frame = new Home();
					frame.setUndecorated(true);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
		

	/**
	 * Create the frame.
	 */
	public Home() {
		setBackground(Color.white);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 929, 476);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(46, 64, 83));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		panel = new JPanel();
		panel.setBackground(new Color( 174, 214, 241));
		panel.setBounds(0, 0, 346, 490);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lbl_close = new JLabel("X");
		lbl_close.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				
				System.exit(0);
			}
		});
		lbl_close.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_close.setForeground(new Color( 84, 153, 199));
		lbl_close.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lbl_close.setBounds(851, 20, 37, 27);
		contentPane.add(lbl_close);
		
		setHomePanel();
				
	}
	
	public void setHomePanel() {
		lblTitle = new JLabel("Sistema Gestión de laboratorio");
		lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitle.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblTitle.setForeground(Color.black);
		lblTitle.setBounds(26, 100, 300, 27);
		panel.add(lblTitle);
				
		lblSelect = new JLabel("Por favor, seleccione algun modo:");
		lblSelect.setHorizontalAlignment(SwingConstants.CENTER);
		lblSelect.setForeground(Color.black);
		lblSelect.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblSelect.setBounds(50, 130, 241, 27);
		panel.add(lblSelect);
		
		btnAdmin = new Button("Administrador");
		btnAdmin.setForeground(Color.WHITE);
		btnAdmin.setBackground(new Color( 84, 153, 199));
		btnAdmin.setBounds(26, 180, 300, 27);
		panel.add(btnAdmin);
		
		btnRecep = new Button("Recepcionista");
		btnRecep.setForeground(Color.white);
		btnRecep.setBackground(new Color( 84, 153, 199));
		btnRecep.setBounds(26, 250, 300, 27);
		panel.add(btnRecep);
				
		btnLabo = new Button("Laboratorista");
		btnLabo.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {	
				SetHomePanelVisibility(false);
				SetLabPanel(panel);
			}
		});
		btnLabo.setForeground(Color.white);
		btnLabo.setBackground(new Color( 84, 153, 199));
		btnLabo.setBounds(26, 320, 300, 27);
		panel.add(btnLabo);  
	}
	
	public void SetLabPanel(JPanel panel) {	
		Button btnGetAll = new Button("Obtener practicas");
		btnGetAll.setForeground(Color.WHITE);
		btnGetAll.setBackground(new Color( 84, 153, 199));
		btnGetAll.setBounds(26, 100, 300, 27);
		panel.add(btnGetAll);
		
		Button btnAdd = new Button("Agregar");
		btnAdd.setForeground(Color.WHITE);
		btnAdd.setBackground(new Color( 84, 153, 199));
		btnAdd.setBounds(26, 140, 300, 27);
		panel.add(btnAdd);
		
		Button btnUpdate = new Button("Modificar");
		btnUpdate.setForeground(Color.WHITE);
		btnUpdate.setBackground(new Color( 84, 153, 199));
		btnUpdate.setBounds(26, 180, 300, 27);
		panel.add(btnUpdate);
		
		Button btnDelete = new Button("Eliminar");
		btnDelete.setForeground(Color.WHITE);
		btnDelete.setBackground(new Color( 84, 153, 199));
		btnDelete.setBounds(26, 220, 300, 27);
		panel.add(btnDelete);
		
	} 
	
	public void SetHomePanelVisibility(boolean v) {
		lblSelect.setVisible(v);
		lblTitle.setVisible(v);
		btnAdmin.setVisible(v);
		btnRecep.setVisible(v);
		btnLabo.setVisible(v);
	}
}
