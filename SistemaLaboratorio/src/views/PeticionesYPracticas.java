package views;

import controllers.PracticaController;
import dtos.PeticionDTO;
import dtos.PracticaAsociadaDTO;
import dtos.PracticaDTO;
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
	public PeticionesYPracticas(List<PeticionDTO> l) throws Exception {
		frame = new JFrame("Peticiones y prácticas");
		frame.getContentPane().setBackground(Color.WHITE);
		frame.setType(Type.POPUP);
		frame.setBackground(Color.WHITE);
		frame.getContentPane().setLayout(new GridLayout(0, 1));
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.setSize(1100, 500);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);

		JLabel lblPracticasAsoc = new JLabel("PETICIONES Y PRACTICAS ASOCIADAS");
		lblPracticasAsoc.setBackground(Color.WHITE);
		lblPracticasAsoc.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblPracticasAsoc.setForeground(new Color(200, 32, 58));
		frame.getContentPane().add(lblPracticasAsoc);

		for(int i = 0; i < l.size(); i++) {
			PeticionDTO p = l.get(i);
			JLabel lbl = new JLabel("Petición ID: " + p.id + " | Sucursal asociada: " + p.sucursalID + " | Estado de petición: " + p.estadoPeticion);
			lbl.setFont(new Font("Tahoma", Font.BOLD, 13));
			frame.getContentPane().add(lbl);
			agregarPracticasAsociadas(p.practicasAsociadas);
			frame.validate();
			frame.repaint();
		}
	}


	private void agregarPracticasAsociadas(List<PracticaAsociadaDTO> list) throws Exception {
		for (final PracticaAsociadaDTO p : list) {
			JLabel lblpracticaAsocidada = new JLabel();
			//JLabel lblpractica = new JLabel();
			lblpracticaAsocidada.setFont(new Font("Tahoma", Font.PLAIN, 12));
			lblpracticaAsocidada.setForeground(Color.darkGray);

			if(p.resultadoPractica ==  EstadoResultadoPractica.Normal || p.resultadoPractica ==  EstadoResultadoPractica.Pendiente || p.resultadoPractica==  EstadoResultadoPractica.Critico) {
				lblpracticaAsocidada.setText("> Practica ID: " + p.practicaID + " Resultado: " + p.resultadoPractica);

				PracticaDTO practica = PracticaController.getInstance().ObtenerPractica(p.practicaID);
				JTextArea txtPractica = new JTextArea();
				txtPractica.setFont(new Font("Tahoma", Font.PLAIN, 11));
				//txtPractica.setText(" Nombre: " + practica.nombre + "\n Grupo: " + practica.grupo + "\n Valores criticos" + "\n MAX: " + practica.valorCriticoMax + " MIN: " + practica.valorReservadoMin + "\n Valores Reservados" + "\n MAX: " + practica.valorReservadoMin + " MIN: " + practica.valorReservadoMax + "\n Horas de espera: " + practica.horasEsperaResultado + "\n Estado de la practica: " + practica.estadoPractica);
				txtPractica.setText(" Nombre: " + practica.nombre + " | Grupo: " + practica.grupo + " | Valores criticos: MAX: " + practica.valorCriticoMax + " MIN: " + practica.valorReservadoMin + " | Valores Reservados: MAX: " + practica.valorReservadoMin + " MIN: " + practica.valorReservadoMax + " | Horas de espera: " + practica.horasEsperaResultado + " | Estado de la practica: " + practica.estadoPractica);
				frame.getContentPane().add(lblpracticaAsocidada);
				frame.getContentPane().add(txtPractica);
			}
			else {
				lblpracticaAsocidada.setText("> Practica ID: " + p.practicaID + " Resultado: RETIRAR POR SUCURSAL");
				frame.getContentPane().add(lblpracticaAsocidada);
			}
		}
	}
}
