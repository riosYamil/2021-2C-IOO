package views;


import controllers.UsuarioController;
import dtos.UsuarioDTO;
import enums.Rol;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FrmPrincipal extends JFrame {

	private JPanel pnlPrincipal;
	private JPanel pnlIntro;
	private JLabel lblSelect;
	private JLabel lblTitle;
	private Button btnIngresar;
	private JTextField tUsuario;
	private static String titulo = "Sistema Gestión de laboratorio";
	private JTextField tPassword;

	/**
	 * Create the frame.
	 * 
	 * @throws ClassNotFoundException
	 */
	public FrmPrincipal(String title) throws ClassNotFoundException {
		super(title);

		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException
				| UnsupportedLookAndFeelException e) {
			e.printStackTrace();
		}

		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setResizable(false);
		setBounds(100, 100, 629, 476);
		pnlPrincipal = new JPanel();
		setContentPane(pnlPrincipal);
		pnlPrincipal.setLayout(new BoxLayout(pnlPrincipal, BoxLayout.X_AXIS));

		setPrincipalPnl();
		asociarEventos();

		/*
		try {
			UsuarioController usuarioController = UsuarioController.getInstance();
			UsuarioDTO usuarioDTO = new UsuarioDTO();
			usuarioDTO.password = "1234";
			usuarioDTO.dni = "1234";
			usuarioDTO.rol = Rol.Administrador;
			usuarioController.AltaUsuario(usuarioDTO);
		}catch (Exception e){
			e.printStackTrace();
		}*/
	}

	/**
	 * Launch the application.
	 * 
	 * @throws ClassNotFoundException
	 */
	public static void main(String[] args) throws ClassNotFoundException {
		FrmPrincipal frame = new FrmPrincipal(titulo);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}

	public void setPrincipalPnl() {
		pnlIntro = new JPanel();
		pnlIntro.setBackground(Color.white);
		pnlIntro.setBounds(100, 100, 629, 476);
		pnlPrincipal.add(pnlIntro);
		pnlIntro.setLayout(null);

		lblTitle = new JLabel(titulo);
		lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitle.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.PLAIN, 35));
		lblTitle.setBounds(55, 88, 500, 27);
		lblTitle.setForeground(new Color(200, 32, 58));
		pnlIntro.add(lblTitle);

		lblSelect = new JLabel("DNI");
		lblSelect.setBackground(Color.WHITE);
		lblSelect.setHorizontalAlignment(SwingConstants.CENTER);
		lblSelect.setForeground(Color.DARK_GRAY);
		lblSelect.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblSelect.setBounds(216, 126, 183, 27);
		pnlIntro.add(lblSelect);
				
		tUsuario = new JTextField();
		tUsuario.setColumns(10);
		tUsuario.setBounds(152, 164, 295, 27);
		pnlIntro.add(tUsuario);
		
		JLabel lblPassword = new JLabel("CONTRASEÑA");
		lblPassword.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblPassword.setForeground(Color.DARK_GRAY);
		lblPassword.setBounds(267, 202, 84, 14);
		pnlIntro.add(lblPassword);
		
		tPassword = new JTextField();
		tPassword.setBounds(152, 227, 295, 27);
		pnlIntro.add(tPassword);
		tPassword.setColumns(10);

		btnIngresar = new Button("INGRESAR");
		btnIngresar.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnIngresar.setForeground(Color.WHITE);
		btnIngresar.setBackground(new Color(133, 189, 212));
		btnIngresar.setBounds(232, 270, 150, 27);
		pnlIntro.add(btnIngresar);
		
		JLabel label = new JLabel("");
		label.setBounds(316, 0, 325, 473);
		label.setVerticalAlignment(SwingConstants.TOP);
		label.setIcon(new ImageIcon(FrmPrincipal.class.getResource("/images/pic2.jpg")));
		pnlIntro.add(label);
		
	}

	private void asociarEventos() {
		btnIngresar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int id = Integer.parseInt(tUsuario.getText());
				if (validateUser(id)) {
					try {
						UsuarioController usuarioController = UsuarioController.getInstance();
						String rol = usuarioController.ObtenerUsuario(id).rol.toString();
						cleanPanel();
						addTabbedOPanel(rol);
					}catch (Exception ex){
						ex.printStackTrace();
					}
				} else {
					JOptionPane.showMessageDialog(pnlIntro, "No se reconoce ese DNI o contraseña.", "Error",
							JOptionPane.ERROR_MESSAGE);
				}
			}
		});
	}

	private boolean validateUser(int id) {
		UsuarioController usuarioController = UsuarioController.getInstance();
		boolean isValid = false;
		try {
			isValid = usuarioController.Autenticador(id, tPassword.getText());
		}
		catch (Exception e){
			e.printStackTrace();
		}
		
		return isValid;
	}

	private void cleanPanel() {
		pnlIntro.removeAll();
		pnlIntro.revalidate();
		pnlIntro.repaint();
		pnlIntro.setBackground(Color.white);
		pnlIntro.setLayout(new BoxLayout(pnlIntro, BoxLayout.X_AXIS));
	}

	private void addTabbedOPanel(String rol) {
		InternalPanel frame = new InternalPanel(rol);
		pnlIntro.add(frame);

	}
}
