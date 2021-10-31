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

public class FrmPrincipal extends JFrame {

	private JPanel pnlPrincipal;
	private JPanel pnlIntro;
	private JLabel lblSelect;
	private JLabel lblTitle;
	private Button btnAdmin;
	private Button btnRecep;
	private Button btnLabo;
	private static String titulo = "Sistema Gestión de laboratorio";
	
	private  FrmPrincipal self;
	
	/**
	 * Create the frame.
	 * @throws ClassNotFoundException 
	 */
	public FrmPrincipal(String title) throws ClassNotFoundException {
		super(title);

		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException e) {
			e.printStackTrace();
		}

		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
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
	 * @throws ClassNotFoundException 
	 */
	public static void main(String[] args) throws ClassNotFoundException {
		FrmPrincipal frame = new FrmPrincipal(titulo);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}
	
	
	public void setPrincipalPnl() {			
		pnlIntro = new JPanel();
		pnlIntro.setBackground(new Color( 180, 204, 227 ));
		pnlIntro.setBounds(100, 100, 629, 476);
		pnlPrincipal.add(pnlIntro);
		pnlIntro.setLayout(null);
		
		lblTitle = new JLabel(titulo);
		lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitle.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.PLAIN, 30));
		lblTitle.setBounds(105, 80, 400, 27);
		lblTitle.setForeground(Color.black);
		pnlIntro.add(lblTitle);
		
		lblSelect = new JLabel("Por favor, seleccione cómo quiere ingresar:");
		lblSelect.setHorizontalAlignment(SwingConstants.CENTER);
		lblSelect.setForeground(Color.DARK_GRAY);
		lblSelect.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblSelect.setBounds(135, 118, 341, 27);
		pnlIntro.add(lblSelect);
				
		btnAdmin = new Button("Administrador");
		btnAdmin.setForeground(Color.black);
		btnAdmin.setBackground(new Color(  236, 240, 241));
		btnAdmin.setBounds(163, 174, 300, 27);
		pnlIntro.add(btnAdmin);
		
		btnRecep = new Button("Recepcionista");
		btnRecep.setForeground(Color.black);
		btnRecep.setBackground(new Color(  236, 240, 241));
		btnRecep.setBounds(163, 236, 300, 27);
		pnlIntro.add(btnRecep);
		
		btnLabo = new Button("Laboratorista");
		btnLabo.setForeground(Color.black);
		btnLabo.setBackground(new Color(  236, 240, 241));
		btnLabo.setBounds(163, 297, 300, 27);
		pnlIntro.add(btnLabo);  
		
		JLabel label = new JLabel("");
		label.setBounds(-10, 200, 629, 576);
		label.setVerticalAlignment(SwingConstants.TOP);
		label.setIcon(new ImageIcon(FrmPrincipal.class.getResource("/images/pic.png")));
		pnlIntro.add(label);
	}
	
	private void asociarEventos() {
		
		btnAdmin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {			
				//if admin
				cleanPanel();
				addTabbedOPanel();
				//else 
				//dialog ?
			}
		});
		
		btnRecep.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//if recep
				cleanPanel();
				addTabbedOPanel();
			}
		});
		
		btnLabo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//if labo
				cleanPanel();
				addTabbedOPanel();
			}
		});
	}
	
	
	private void cleanPanel() {
		pnlIntro.removeAll();
		pnlIntro.revalidate();
		pnlIntro.repaint();
		pnlIntro.setLayout(new BoxLayout(pnlIntro, BoxLayout.X_AXIS));
	}
	
	private void addTabbedOPanel() {
		InternalTabs frame = new InternalTabs(); //should get if it is admin, recep or labo
		pnlIntro.add(frame);
		
		
	}
}
