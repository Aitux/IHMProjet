package windows;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.MatteBorder;

import com.sun.xml.internal.ws.api.server.Container;

public class PanelCouleur extends JPanel {
	PanelCouleur(Color couleur, Color grey){
		this.setPreferredSize(new Dimension(300,200));
		setBorder(new MatteBorder(1, 1, 3, 2, (Color) new Color(0, 0, 0)));
		setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(5, 22, 145, 139);
		panel.setBackground(couleur);
		add(panel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(149, 22, 145, 139);
		panel_1.setBackground(grey);
		add(panel_1);
		
		JLabel lblNewLabel = new JLabel("Couleur couleur");
		lblNewLabel.setBounds(20, 161, 98, 25);
		add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Couleur gris");
		lblNewLabel_1.setBounds(163, 161, 98, 25);
		add(lblNewLabel_1);
		
		JPanel panel_2 = new JPanel();
		ImageIcon croix = new ImageIcon(Toolkit.getDefaultToolkit().getImage(index.class.getResource("/croix.png")));
		panel_2.setLayout(null);
		JLabel icon = new JLabel();
		icon.setLocation(0, 0);
		icon.setIcon(croix);
		icon.setSize(new Dimension(20, 20));
		panel_2.add(icon);
		panel_2.setBounds(278, 1, 20, 20);
		add(panel_2);
		panel_2.addMouseListener( new MouseAdapter(){
			@Override
					public void mouseClicked(MouseEvent e) {
						super.mouseClicked(e);
						
					}		
		}
				);
		
	}
}
