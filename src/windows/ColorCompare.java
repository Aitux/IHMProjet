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
import javax.swing.JTextArea;

public class ColorCompare extends JDialog{
	public ColorCompare(PanelCouleur[] selected) {
		
		JPanel panel = new JPanel();
		getContentPane().add(panel);
		panel.setBackground(Color.WHITE);
		panel.setLayout(null);
		setIconImage(Toolkit.getDefaultToolkit().getImage(index.class.getResource("/color-circle.png")));

		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(10, 11, 604, 391);
		panel.add(panel_1);
		panel_1.setLayout(null);
		panel_1.setBackground(Color.WHITE);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(10, 11, 120, 370);
		panel_1.add(panel_2);
		panel_2.setBackground(selected[0].getcolor());
		panel_2.setLayout(new BorderLayout(0, 0));
		JTextArea textArea2 = new JTextArea(selected[0].couleurtoString());
		textArea2.setEditable(false);
		textArea2.setOpaque(false);
		panel_2.add(textArea2, BorderLayout.SOUTH);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBounds(133, 61, 120, 320);
		panel_1.add(panel_3);
		JTextArea textArea3 = new JTextArea(selected[1].couleurtoString());
		textArea3.setEditable(false);
		textArea3.setOpaque(false);
		panel_3.setLayout(new BorderLayout(0, 0));
		panel_3.add(textArea3,BorderLayout.SOUTH);
		panel_3.setBackground(selected[1].getcolor());
		
		JPanel panel_4 = new JPanel();
		panel_4.setBounds(474, 11, 120, 370);
		panel_1.add(panel_4);
		JTextArea textArea4 = new JTextArea(selected[0].greytoString());
		textArea4.setEditable(false);
		textArea4.setOpaque(false);
		panel_4.setLayout(new BorderLayout(0, 0));
		panel_4.add(textArea4,BorderLayout.SOUTH);
		panel_4.setBackground(selected[1].getgrey());

		JPanel panel_5 = new JPanel();
		panel_5.setBounds(351, 61, 120, 320);
		panel_1.add(panel_5);		
		JTextArea textArea5 = new JTextArea(selected[1].greytoString());
		textArea5.setEditable(false);
		textArea5.setOpaque(false);
		panel_5.setLayout(new BorderLayout(0, 0));
		panel_5.add(textArea5,BorderLayout.SOUTH);
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
		setTitle("Comparator");
		setSize(new Dimension(640,480));
		setLocationRelativeTo(null);
		setVisible(true);
	}
}
