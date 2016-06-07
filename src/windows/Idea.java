package windows;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.ImageIcon;

public class Idea extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private ArrayList<Color> couleurAr = new ArrayList<>();
	private int cpt;
	private Color grey;
	private index index;

	/**
	 * Create the dialog.
	 */
	public Idea(Color couleur, Color grey, index index) {
		this.index = index;
		this.grey = grey;
		setIconImage(Toolkit.getDefaultToolkit().getImage(Idea.class.getResource("/color-circle.png")));
		setPreferredSize(new Dimension(350, 300));
		double res;
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JLabel label = new JLabel("");
		label.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				colorPanel();
			}
		});
		label.setIcon(new ImageIcon(Idea.class.getResource("/right-arrow.png")));
		contentPanel.add(label);
		for(int r = 0;r < 256; r++){
			for(int g = 0; g<256; g++){
				for(int b = 0; b<256; b++){
					if( (res = 0.3*r+0.59*g+0.11*b) == grey.getBlue()){
						couleurAr.add(new Color(r,g,b));
					}
				}
			}
		}

		addPanel();
		this.pack();
		setLocationRelativeTo(index);
		this.setVisible(true);


	}

	public void addPanel(){
		for(int i = 0; i<20 ;i++){
			JPanel pane = new JPanel();
			pane.setPreferredSize(new Dimension(50,50));
			pane.setBackground(couleurAr.get(cpt));
			cpt++;
			contentPanel.add(pane);
			pane.addMouseListener(new MouseAdapter(){
				@Override
				public void mouseClicked(MouseEvent e){
					super.mouseClicked(e);
					dispose();
					index.addCanvas(pane.getBackground(), grey);
				}
			});
		}
	}

	public void colorPanel(){
		contentPanel.removeAll();
		JLabel label = new JLabel("");
		label.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				colorPanel();
			}
		});
		label.setIcon(new ImageIcon(Idea.class.getResource("/right-arrow.png")));
		contentPanel.add(label);
		for(int i = 0; i<20 ;i++){
			JPanel pane = new JPanel();
			pane.setPreferredSize(new Dimension(50,50));
			pane.setBackground(couleurAr.get(cpt));
			cpt++;
			contentPanel.add(pane);
			pane.addMouseListener(new MouseAdapter(){
				@Override
				public void mouseClicked(MouseEvent e){
					super.mouseClicked(e);
					dispose();
					index.addCanvas(pane.getBackground(), grey);
				}
			});
		}
		validate();
		repaint();
	
	}
}
