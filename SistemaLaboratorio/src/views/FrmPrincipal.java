package views;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.border.EmptyBorder;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import javax.swing.JTabbedPane;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JTextPane;
import java.awt.Point;
import javax.swing.JProgressBar;
import javax.swing.JOptionPane;

public class FrmPrincipal extends JFrame {

	private JPanel pnlPrincipal;
	private JPanel pnlIntro;
	private JLabel lblSelect;
	private JLabel lblTitle;
	private Button btnAdmin;
	private Button btnRecep;
	private Button btnLabo;
	private static String titulo = "Sistema Gestión de laboratorio";

	private FrmPrincipal self;

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

		this.self = this;

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
		pnlIntro.setBackground(new Color(180, 204, 227));
		pnlIntro.setBounds(100, 100, 629, 476);
		pnlPrincipal.add(pnlIntro);
		pnlIntro.setLayout(null);

		lblTitle = new JLabel(titulo);
		lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitle.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.PLAIN, 35));
		lblTitle.setBounds(70, 80, 500, 27);
		lblTitle.setForeground(new Color(200, 32, 58));
		pnlIntro.add(lblTitle);

		lblSelect = new JLabel("Por favor, seleccione en qué modo quiere ingresar:");
		lblSelect.setHorizontalAlignment(SwingConstants.CENTER);
		lblSelect.setForeground(Color.DARK_GRAY);
		lblSelect.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblSelect.setBounds(135, 118, 341, 27);
		pnlIntro.add(lblSelect);

		btnAdmin = new Button("Administrador");
		btnAdmin.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnAdmin.setForeground(Color.WHITE);
		btnAdmin.setBackground(new Color(133, 189, 212));
		btnAdmin.setBounds(230, 174, 150, 27);
		pnlIntro.add(btnAdmin);

		btnRecep = new Button("Recepcionista");
		btnRecep.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnRecep.setForeground(Color.WHITE);
		btnRecep.setBackground(new Color(133, 189, 212));
		btnRecep.setBounds(230, 237, 150, 27);
		pnlIntro.add(btnRecep);

		btnLabo = new Button("Laboratorista");
		btnLabo.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnLabo.setForeground(Color.WHITE);
		btnLabo.setBackground(new Color(133, 189, 212));
		btnLabo.setBounds(230, 297, 150, 27);
		pnlIntro.add(btnLabo);

		JLabel label = new JLabel("");
		label.setBounds(0, 247, 619, 200);
		label.setVerticalAlignment(SwingConstants.TOP);
		label.setIcon(new ImageIcon(FrmPrincipal.class.getResource("/images/pic.png")));
		pnlIntro.add(label);
	}

	private void asociarEventos() {
		btnAdmin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cleanPanel();
				addTabbedOPanel();
			}
		});

		btnRecep.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// if recep
				cleanPanel();
				addTabbedOPanel();
			}
		});

		btnLabo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// if labo
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
