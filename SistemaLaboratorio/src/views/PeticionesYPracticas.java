package views;

import dtos.PeticionDTO;
import dtos.PracticaAsociadaDTO;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.text.DefaultCaret;

public class PeticionesYPracticas extends JFrame {

	private final JFrame frame;

	/**
	 * Create the frame.
	 */
	public PeticionesYPracticas(List<PeticionDTO> l) {
		frame = new JFrame("Peticiones y prácticas");
		frame.setLayout(new GridLayout(0, 1));
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.setSize(400, 300);
		//frame.setBackground(Color.white);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);

		JLabel lblPracticasAsoc = new JLabel("PETICIONES Y PRACTICAS ASOCIADAS");
		lblPracticasAsoc.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblPracticasAsoc.setForeground(new Color(200, 32, 58));
		frame.add(lblPracticasAsoc);

		for(int i = 0; i < l.size(); i++) {
			PeticionDTO p = l.get(i);
			JLabel lbl = new JLabel("Petición ID: " + p.id + "| Obra social:" + p.obraSocial + " | Sucursal asociada: " + p.sucursalID);
			lbl.setFont(new Font("Tahoma", Font.BOLD, 11));
			frame.add(lbl);
			agregarPracticas(p.practicasAsociadas);
			frame.validate();
			frame.repaint();
		}
	}


	private void agregarPracticas(List<PracticaAsociadaDTO> list) {
		for (final PracticaAsociadaDTO p : list) {
			JLabel lblpractica = new JLabel();

			//if(p.resultado ==  EstadoResultadoPractica.Normal || p.resultado ==  EstadoResultadoPractica.Pendiente) {

			//}
			lblpractica.setText("Practica ID: " + p.practicaDTO.id + " Resultado: " + p.resultado + " algo mas?");
			frame.add(lblpractica);
		}
	}

}
