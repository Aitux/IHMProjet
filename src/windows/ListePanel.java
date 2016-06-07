package windows;

import java.awt.Dimension;
import java.awt.List;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;

public class ListePanel extends JDialog{
	protected ListePanel me = this;
	public ListePanel(ArrayList<PanelCouleur> couleurTotal) {
		getContentPane().setLayout(null);
		
		JLabel lblChooseTheTwo = new JLabel("Choose the two samples you want to compare:");
		lblChooseTheTwo.setBounds(10, 11, 327, 14);
		getContentPane().add(lblChooseTheTwo);
		setIconImage(Toolkit.getDefaultToolkit().getImage(index.class.getResource("/color-circle.png")));

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 36, 264, 319);
		getContentPane().add(scrollPane);
		
		JList list = new JList();
		list.setListData(couleurTotal.toArray());
		scrollPane.setViewportView(list);

		JButton btnValidate = new JButton("Validate");
		btnValidate.setBounds(20, 366, 89, 23);
		btnValidate.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if (list.getSelectedValuesList().size() <2){
					JOptionPane.showMessageDialog(me, "You must select at least 2 colors to do that!");
				}else if (list.getSelectedValuesList().size() >2){
					JOptionPane.showMessageDialog(me, "Select only 2 colors!");
				}else{
					PanelCouleur[] tabcolor = new PanelCouleur[2];
					tabcolor[0] = couleurTotal.get(list.getSelectedIndices()[0]);
					tabcolor[1] = couleurTotal.get(list.getSelectedIndices()[1]);
					ColorCompare compare = new ColorCompare(tabcolor);
					dispose();
				}
			}
		});
		getContentPane().add(btnValidate);
		
		JButton btnNewButton = new JButton("Cancel");
		btnNewButton.setBounds(175, 366, 89, 23);
		btnNewButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		getContentPane().add(btnNewButton);
		setSize(new Dimension(300,440));
		setTitle("Selection");
		setVisible(true);
	}
}
