package windows;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.MatteBorder;
import javax.swing.JTextField;

public class PanelCouleur extends JPanel {

	private index parent;
	private String nom;
	private PanelCouleur me;
	private static int cpt = 1;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel;
	private Color couleur, grey;
	private JTextField txtEchantillon;

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

		lblNewLabel = new JLabel("Couleur couleur");
		lblNewLabel.setBounds(15, 161, 130, 25);
		add(lblNewLabel);

		lblNewLabel_1 = new JLabel("Couleur gris");
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
		setMe();
		panel_2.addMouseListener( new MouseAdapter(){
			@Override
			public void mouseClicked(MouseEvent e) {
				super.mouseClicked(e);			
				parent.contentPane.remove(me);
				parent.couleurTotal.remove(me);
				parent.isEmpty();
				parent.validate();
				parent.repaint();
			}		
		}
				);
		this.couleur = couleur;
		this.grey = grey;

		txtEchantillon = new JTextField();
		txtEchantillon.setText("Sample N°"+cpt);
		this.nom = txtEchantillon.getText();
		txtEchantillon.setBounds(15, 1, 221, 20);
		txtEchantillon.setBorder(null);
		txtEchantillon.setBackground(this.getBackground());
		add(txtEchantillon);
		txtEchantillon.setColumns(10);
		txtEchantillon.addKeyListener(new KeyListener() {

			@Override
			public void keyTyped(KeyEvent e) {
				nom = txtEchantillon.getText();

			}

			@Override
			public void keyReleased(KeyEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void keyPressed(KeyEvent e) {
				// TODO Auto-generated method stub

			}
		});
		cpt++;

	}
	public void setMe(){
		this.me = this;
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
	public static void resetcpt(){
		cpt =1; 
	}

	public String toString(){
		
		return ""+this.nom+", RGB: "+this.couleur.getRed()+", "+this.couleur.getGreen()+", "+this.couleur.getBlue()+", Gris: "+this.grey.getRed();
	}
}






