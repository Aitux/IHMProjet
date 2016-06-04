package windows;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Dimension;
import java.awt.Toolkit;

public class Colorchooser extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private index Parent;
	/**
	 * Create the dialog.
	 */
	public Colorchooser() {
		setResizable(false);
		setIconImage(Toolkit.getDefaultToolkit().getImage(Colorchooser.class.getResource("/balance.png")));
		setMinimumSize(new Dimension(500, 300));

		this.setTitle("Palette de couleur");

		JColorChooser test = new JColorChooser();
		test.removeChooserPanel(test.getChooserPanels()[0]);
		test.removeChooserPanel(test.getChooserPanels()[0]);
		test.removeChooserPanel(test.getChooserPanels()[0]);
		test.removeChooserPanel(test.getChooserPanels()[1]);
		test.getPreviewPanel().setVisible(false);
		test.getPreviewPanel().getParent().setVisible(false);

	

		setBounds(100, 100, 539, 302);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setLayout(new FlowLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPanel.add(test);
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.setActionCommand("OK");
				okButton.addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent arg0) {
						// TODO Auto-generated method stub
						dispose();
						Parent.setRGB(test.getColor());
						Parent.setGreyLevel();
						System.out.println(Parent.toString());
						Parent.addCanvas(Parent.getRGB(), Parent.getGrey());
						Parent.isEmpty();
					}
				});
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.setActionCommand("Cancel");
				cancelButton.addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent arg0) {
						// TODO Auto-generated method stub


						dispose();
						
					}
				});
				buttonPane.add(cancelButton);
			}
		}
		this.pack();
		//this.setLocationRelativeTo(null);
		this.setVisible(true);
	}

	public void setParent(index Parent){
		this.Parent = Parent;
	}
}
