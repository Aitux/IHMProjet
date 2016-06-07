package windows;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class Idea extends JDialog {

	private final JPanel contentPanel = new JPanel();

	/**
	 * Create the dialog.
	 */
	public Idea(Color couleur, Color grey) {
		setBounds(100, 100, 350, 250);
		int res, cpt = 0;
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		for(int r = 0;r < 256; r++){
			for(int g = 0; g<256; g++){
				for(int b = 0; b<256; b++){
					if( (res =(int) (0.3*r+0.59*g+0.11*b)) == grey.getBlue() && cpt < 10){
						cpt++;
						JPanel pane = new JPanel();
						pane.setBackground(new Color(r,g,b));
						pane.setPreferredSize(new Dimension(50,50));
//						pane.addMouseListener(new MouseAdapter() {
//							@Override
//							public void mouseClicked(MouseEvent e) {
//								// TODO Auto-generated method stub
//								super.mouseClicked(e);
//								dispose();
//								
//							}
//						});
						contentPanel.add(pane);
					}
				}
			}
		}
		this.pack();
		this.setVisible(true);
		
	}

}
