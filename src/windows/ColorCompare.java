package windows;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class ColorCompare extends JDialog{
	public ColorCompare(PanelCouleur[] selected) {
		
		JPanel panel = new JPanel();
		getContentPane().add(panel);
		panel.setBackground(Color.WHITE);
		panel.setLayout(null);
		
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(10, 11, 604, 391);
		panel.add(panel_1);
		panel_1.setLayout(null);
		panel_1.setBackground(Color.WHITE);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(10, 11, 120, 370);
		panel_1.add(panel_2);
		panel_2.setBackground(selected[0].getcolor());
		JLabel lblNewLabel = new JLabel(selected[0].getnom());
		panel_2.add(lblNewLabel, BorderLayout.SOUTH);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBounds(133, 61, 120, 320);
		panel_1.add(panel_3);
		panel_3.setBackground(selected[1].getcolor());
		
		JPanel panel_4 = new JPanel();
		panel_4.setBounds(474, 11, 120, 370);
		panel_1.add(panel_4);
		panel_4.setBackground(selected[1].getgrey());

		JPanel panel_5 = new JPanel();
		panel_5.setBounds(351, 61, 120, 320);
		panel_1.add(panel_5);
		panel_5.setBackground(selected[0].getgrey());
		
		JPanel panel_6 = new JPanel();
		panel_6.setBounds(277, 181, 50, 50);
		panel_1.add(panel_6);
		ImageIcon arrow = new ImageIcon(Toolkit.getDefaultToolkit().getImage(index.class.getResource("/arrow.png")));
		panel_6.setLayout(new BoxLayout(panel_6, BoxLayout.X_AXIS));
		JLabel icon = new JLabel();
		icon.setIcon(arrow);
		panel_6.setBackground(Color.WHITE);
		panel_6.add(icon);
		
		JPanel panel_7 = new JPanel();
		panel_7.setBounds(350, 430, 252, -28);
		panel.add(panel_7);
		
		JButton btnOk = new JButton("OK");
		btnOk.setBounds(268, 408, 89, 23);
		panel.add(btnOk);
		btnOk.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		setSize(new Dimension(640,480));
		setLocationRelativeTo(null);
		setVisible(true);
	}
}
