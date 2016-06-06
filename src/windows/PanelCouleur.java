package windows;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;
import javax.swing.border.BevelBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;
import javax.swing.UIManager;
import javax.swing.border.MatteBorder;

public class PanelCouleur extends JPanel {
	PanelCouleur(Color couleur, Color grey){
		this.setPreferredSize(new Dimension(300,200));
		setBorder(new MatteBorder(1, 1, 3, 2, (Color) new Color(0, 0, 0)));
		setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 11, 140, 139);
		panel.setBackground(couleur);
		add(panel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(153, 11, 140, 139);
		panel_1.setBackground(grey);
		add(panel_1);
		
		JLabel lblNewLabel = new JLabel("Couleur couleur");
		lblNewLabel.setBounds(20, 161, 98, 25);
		add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Couleur gris");
		lblNewLabel_1.setBounds(163, 161, 98, 25);
		add(lblNewLabel_1);
		
	}
}
