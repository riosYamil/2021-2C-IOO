package views;

import dtos.PeticionDTO;
import dtos.PracticaAsociadaDTO;
import enums.EstadoResultadoPractica;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.text.DefaultCaret;
import java.awt.Window.Type;

public class PeticionesYPracticas extends JFrame {

	private final JFrame frame;

	/**
	 * Create the frame.
	 */
	public PeticionesYPracticas(List<PeticionDTO> l) {
		frame = new JFrame("Peticiones y prácticas");
		frame.getContentPane().setBackground(Color.WHITE);
		frame.setType(Type.POPUP);
		frame.setBackground(Color.WHITE);
		frame.getContentPane().setLayout(new GridLayout(0, 1));
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.setSize(400, 300);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);

		JLabel lblPracticasAsoc = new JLabel("PETICIONES Y PRACTICAS ASOCIADAS");
		lblPracticasAsoc.setBackground(Color.WHITE);
		lblPracticasAsoc.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblPracticasAsoc.setForeground(new Color(200, 32, 58));
		frame.getContentPane().add(lblPracticasAsoc);

		for(int i = 0; i < l.size(); i++) {
			PeticionDTO p = l.get(i);
			JLabel lbl = new JLabel("Petición ID: " + p.id + " | Sucursal asociada: " + p.sucursalID + " | Estado de petición: " + p.estadoPeticion);
			lbl.setFont(new Font("Tahoma", Font.BOLD, 11));
			frame.getContentPane().add(lbl);
			agregarPracticas(p.practicasAsociadas);
			frame.validate();
			frame.repaint();
		}
	}


	private void agregarPracticas(List<PracticaAsociadaDTO> list) {
		for (final PracticaAsociadaDTO p : list) {
			JLabel lblpractica = new JLabel();

			if(p.resultadoPractica ==  EstadoResultadoPractica.Normal || p.resultadoPractica ==  EstadoResultadoPractica.Pendiente || p.resultadoPractica==  EstadoResultadoPractica.Critico) {
				lblpractica.setText("Practica ID: " + p.practicaID + " Resultado: " + p.resultadoPractica);
			}
			else {
				lblpractica.setText("Practica ID: " + p.practicaID + " Resultado: RETIRAR POR SUCURSAL");
			}
			
			//lblpractica.setText("Practica ID: " + p.practicaID + " Resultado: " + p.resultadoPractica);
			frame.getContentPane().add(lblpractica);
		}
	}

}
