package windows;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionAdapter;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.border.EmptyBorder;
import javax.swing.JSpinner;
import java.awt.BorderLayout;
import java.awt.Component;
import javax.swing.Box;

public class index extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					index frame = new index();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public index() {
		int compNum;
		setIconImage(Toolkit.getDefaultToolkit().getImage(index.class.getResource("/balance.png")));
		setBackground(Color.BLACK);
		setTitle("Comparateur de niveau de gris");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1036, 626);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnFile = new JMenu("File");
		menuBar.add(mnFile);
		
		JMenuItem mntmFile = new JMenuItem("Add new color");
		mntmFile.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {				
				// TODO Auto-generated method stub
				Colorchooser newcouleur = new Colorchooser();
				newcouleur.setLocationRelativeTo(contentPane);
			}
		});
		mnFile.add(mntmFile);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("Compare two colors");
		mnFile.add(mntmNewMenuItem);
		JSeparator separator = new JSeparator();
		mnFile.add(separator);
		
		JMenuItem mntmNewMenuItem_1 = new JMenuItem("Import from .txt");
		mnFile.add(mntmNewMenuItem_1);
		
		JMenuItem mntmExportTotxt = new JMenuItem("Export to .txt");
		mnFile.add(mntmExportTotxt);
		
		JSeparator separator_1 = new JSeparator();
		mnFile.add(separator_1);
		
		JMenuItem mntmExit = new JMenuItem("Exit");
		mntmExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		mnFile.add(mntmExit);
		
		JMenu mnEdit = new JMenu("Edit");
		menuBar.add(mnEdit);
		
		JMenuItem mntmCopyCtrl = new JMenuItem("Copy        Ctrl + C");
		mnEdit.add(mntmCopyCtrl);
		
		JMenuItem mntmPasteCtrl = new JMenuItem("Paste        Ctrl + V");
		mnEdit.add(mntmPasteCtrl);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		
		JLabel lblYourWorkspaceIs = new JLabel("Your workspace is empty. File > Add new color, to start !");
		lblYourWorkspaceIs.setFont(new Font("Calibri", Font.PLAIN, 24));
		lblYourWorkspaceIs.setForeground(Color.LIGHT_GRAY);
		
		Component horizontalStrut = Box.createHorizontalStrut((this.getWidth()/4));
//		contentPane.add(horizontalStrut, BorderLayout.WEST);
		contentPane.addMouseMotionListener(new MouseMotionAdapter() {
		});
		if((compNum = contentPane.getComponentCount()) == 0 ){
		contentPane.add("Center",lblYourWorkspaceIs);
		}else contentPane.remove(lblYourWorkspaceIs);
	}

}
