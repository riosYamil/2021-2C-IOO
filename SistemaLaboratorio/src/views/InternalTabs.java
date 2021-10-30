package views;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Window;
import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.border.EmptyBorder;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.WindowConstants;
import javax.swing.JButton;
import javax.swing.JDesktopPane;
import javax.swing.JToolBar;
import javax.swing.JFormattedTextField;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import java.awt.Component;
import javax.swing.Box;
import javax.swing.JMenuItem;
import javax.swing.JLayeredPane;
import javax.swing.BoxLayout;

public class InternalTabs extends JTabbedPane {

	private JPanel grid;
	private JTabbedPane tabbedPane_1;
	private JTabbedPane tabbedPane_2;
	private JTabbedPane tabbedPane_3;
	private JLayeredPane layeredPane;
	private JButton addComponentBtn;
	private JButton deleteComponentBtn;
	private JButton updateComponentBtn;

	public InternalTabs() {
		tabbedPane_1 = new JTabbedPane(JTabbedPane.LEFT);
		tabbedPane_2 = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane_3 = new JTabbedPane(JTabbedPane.TOP);

		this.addTab("Pacientes", tabbedPane_1);
		this.addTab("Petiones", tabbedPane_2);
		this.addTab("Sucursales", tabbedPane_3);

		tabbedPane_1.add(setTabPacientes());

	}

	private JPanel setTabPacientes() {
		JPanel gp = new JPanel(false);
		gp.setPreferredSize(new Dimension(800, 600));

		// Agregar botones
		addComponentBtn = new JButton("Alta");
		gp.add(addComponentBtn, BorderLayout.PAGE_START);
		
		deleteComponentBtn = new JButton("Baja");
		gp.add(deleteComponentBtn, BorderLayout.PAGE_START);
		
		updateComponentBtn = new JButton("Modificar");
		gp.add(updateComponentBtn, BorderLayout.PAGE_START);
		
		

		this.setVisible(true);
		return gp;
	}
	
	private JButton close() {
		return null;
		
	}
	
	private void asociarEventos() {
		addComponentBtn.addActionListener(e -> {
		});
	}

}
