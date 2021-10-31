package views;


import java.awt.Button;
import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JTextField;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;

public class FrmPrincipal extends JFrame {

	private JPanel pnlPrincipal;
	private JPanel pnlIntro;
	private JLabel lblSelect;
	private JLabel lblTitle;
	private Button btnIngresar;
	private JTextField tUsuario;
	private static String titulo = "Sistema Gestión de laboratorio";

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

		lblSelect = new JLabel("Por favor, ingrese su nombre de usuario:");
		lblSelect.setBackground(Color.WHITE);
		lblSelect.setHorizontalAlignment(SwingConstants.CENTER);
		lblSelect.setForeground(Color.DARK_GRAY);
		lblSelect.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblSelect.setBounds(128, 126, 341, 27);
		pnlIntro.add(lblSelect);
				
		tUsuario = new JTextField();
		tUsuario.setColumns(10);
		tUsuario.setBounds(152, 164, 295, 27);
		pnlIntro.add(tUsuario);

		btnIngresar = new Button("INGRESAR");
		btnIngresar.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnIngresar.setForeground(Color.WHITE);
		btnIngresar.setBackground(new Color(133, 189, 212));
		btnIngresar.setBounds(226, 197, 150, 27);
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
				// check user
				cleanPanel();
				addTabbedOPanel();
			}
		});
	}

	private void cleanPanel() {
		pnlIntro.removeAll();
		pnlIntro.revalidate();
		pnlIntro.repaint();
		pnlIntro.setBackground(Color.white);
		pnlIntro.setLayout(new BoxLayout(pnlIntro, BoxLayout.X_AXIS));
	}

	private void addTabbedOPanel() {
		InternalPanel frame = new InternalPanel();// should get if it is admin, recep or labo
		pnlIntro.add(frame);

	}
}
