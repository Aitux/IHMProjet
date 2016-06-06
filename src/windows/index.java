package windows;
import java.awt.Color;
import java.awt.Container;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridBagLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.ArrayList;

import javax.swing.BoxLayout;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.border.EmptyBorder;

public class index extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4845003394650059301L;
	private JPanel paneLbl;
	private JLabel lblYourWorkspaceIs;
	private JPanel contentPane;
	private Color RGB;
	private Color GreyLevel;
	private index info = this;
	private ArrayList<ArrayList<String>> couleurTotal = new ArrayList<>();
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
		setIconImage(Toolkit.getDefaultToolkit().getImage(index.class.getResource("/color-circle.png")));
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
				newcouleur.setParent(info);
				newcouleur.setLocationRelativeTo(contentPane);
			}
		});
		mnFile.add(mntmFile);

		JMenuItem mntmNewMenuItem = new JMenuItem("Compare two colors");
		mnFile.add(mntmNewMenuItem);
		JSeparator separator = new JSeparator();
		mnFile.add(separator);

		JMenuItem mntmExportTotxt = new JMenuItem("Export to .txt");
		mntmExportTotxt.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				JFileChooser jfc = new JFileChooser();
				jfc.setDialogTitle("Select the place to export");
				jfc.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
				jfc.showOpenDialog(contentPane);
				File fi = jfc.getSelectedFile();
				
				
			}
		});
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
		FirstTime();
		isEmpty();
	}

	private void FirstTime() {
		// TODO Auto-generated method stub
		paneLbl = new JPanel();
		lblYourWorkspaceIs = new JLabel("Your workspace is empty. File > Add new color, to start !");
	}

	public void isEmpty() {
		@SuppressWarnings("unused")
		int compNum;
		if((compNum = contentPane.getComponentCount()) == 0 ){
			lblYourWorkspaceIs.setFont(new Font("Calibri", Font.PLAIN, 24));
			lblYourWorkspaceIs.setForeground(Color.LIGHT_GRAY);
			paneLbl.add(lblYourWorkspaceIs);
			contentPane.add(paneLbl);
			GridBagLayout gbl_contentPane = new GridBagLayout();
			gbl_contentPane.columnWidths = new int[]{0};
			gbl_contentPane.rowHeights = new int[]{0};
			gbl_contentPane.columnWeights = new double[]{Double.MIN_VALUE};
			gbl_contentPane.rowWeights = new double[]{Double.MIN_VALUE};
			contentPane.setLayout(gbl_contentPane);
		}else{ 
			System.out.println("Hola Chica");
			Container parent = lblYourWorkspaceIs.getParent();
			parent.remove(lblYourWorkspaceIs);
			parent.validate();
			parent.repaint();
			contentPane.setLayout(new BoxLayout(contentPane, BoxLayout.X_AXIS));

		}
	}

	public void setRGB(Color color){
		this.RGB = color;
	}

	public String toString(){
		return RGB.toString() + " "+ GreyLevel.toString();
	}

	public void addCanvas(Color rgb, Color Grey){

		MyCanvas canvas = new MyCanvas(rgb);		
//		JFrame test = new JFrame();
//		test.setSize(300, 300);
//		test.setVisible(true);
//		test.add(canvas);
		contentPane.add(canvas);
	//	canvas.repaint();

		JPanel pane = new JPanel();
		JPanel color1 = new JPanel();
		JPanel color2 = new JPanel();
		color1.setBackground(rgb);
		color2.setBackground(Grey);
		pane.setLayout(new BoxLayout(pane, BoxLayout.X_AXIS));
		pane.add(color1);
		pane.add(color2);
		contentPane.add(pane);
		contentPane.validate();
	}

	public void setGreyLevel(){
		int r, g, b, res;
		r = RGB.getRed();
		g = RGB.getGreen();
		b = RGB.getBlue();
		res =(int) (0.3*r+0.59*g+0.11*b);
		this.GreyLevel = new Color(res, res ,res);
	}

	public Color getRGB(){
		return this.RGB;
	}

	public Color getGrey(){
		return this.GreyLevel;
	}
}
