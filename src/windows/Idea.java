package windows;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Toolkit;

public class Idea extends JDialog {

	private final JPanel contentPanel = new JPanel();
	

	/**
	 * Create the dialog.
	 */
	public Idea(Color couleur, Color grey, index index) {
		setIconImage(Toolkit.getDefaultToolkit().getImage(Idea.class.getResource("/color-circle.png")));
		setPreferredSize(new Dimension(350, 300));
		int cpt = 0;
		double res;
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		for(int r = 0;r < 256; r++){
			for(int g = 0; g<256; g++){
				for(int b = 0; b<256; b++){
					if( (res = 0.3*r+0.59*g+0.11*b) == grey.getBlue() && cpt < 20){
						cpt++;
						JPanel pane = new JPanel();
						pane.setPreferredSize(new Dimension(50,50));
						Color color = new Color(r,g,b);
						pane.setBackground(color);
						pane.addMouseListener(new MouseAdapter() {
							@Override
							public void mouseClicked(MouseEvent e) {
								// TODO Auto-generated method stub
								super.mouseClicked(e);
								dispose();
								index.addCanvas(color, grey);
							}
						});
						contentPanel.add(pane);
					}
				}
			}
		}
		this.pack();
		setLocationRelativeTo(index);
		this.setVisible(true);
		
		
	}

}
