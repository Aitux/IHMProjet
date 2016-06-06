package windows;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.MatteBorder;

public class PanelCouleur extends JPanel {
	
	private index parent;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel;
	
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
		
		lblNewLabel = new JLabel("Couleur couleur");
		lblNewLabel.setBounds(20, 161, 98, 25);
		add(lblNewLabel);
		
		lblNewLabel_1 = new JLabel("Couleur gris");
		lblNewLabel_1.setBounds(163, 161, 98, 25);
		add(lblNewLabel_1);
	}
	
	public void setParent(index parent){
		this.parent = parent;
	}
	
	public void setTextClr(String txt){
		lblNewLabel.setText(txt);
	}
	
	public void setTextGry(String txt){
		lblNewLabel_1.setText(txt);
	}
	
	
	
}
