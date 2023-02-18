package GUI;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;

import Controller.Controller;

import javax.swing.ListSelectionModel;
import javax.swing.JTextField;
import javax.swing.JSeparator;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.border.LineBorder;
import javax.swing.JPanel;

public class VisualizzaConferenza {

	private int mouseX, mouseY;
	public JFrame frame;
	private JTable table;
	private JLabel dragFrame;
	private JLabel signature;
	private JScrollPane scrollPane;
	private JLabel dataProgrammaLabel;
	private JTextField textField;
	private JSeparator separator_1;
	private JPanel panel;

	
	public VisualizzaConferenza(Controller controller, JFrame frameHome) {
		initialize(controller, frameHome);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(final Controller controller, final JFrame frameHome) {
		frame = new JFrame();
		frame.setUndecorated(true);
		frame.setResizable(false);
		frame.getContentPane().setBackground(new Color(32, 33, 35));
		frame.getContentPane().setLayout(null);
		
		panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel.setBackground(new Color(32, 33, 35));
		panel.setBounds(0, 0, 513, 408);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(39, 152, 425, 212);
		panel.add(scrollPane);
		scrollPane.setBorder(new LineBorder(new Color(0, 0, 0)));
		scrollPane.setBackground(new Color(0, 0, 0));
		
		table = new JTable();
		
		table.addMouseListener(new MouseAdapter() {
	         public void mouseClicked(MouseEvent me) {
	            if (me.getClickCount() == 2) {     //se viene effettuato un doppio click in una zona
	               JTable target = (JTable)me.getSource();
	               int row = target.getSelectedRow(); // seleziona riga
	               int column = target.getSelectedColumn(); // seleziona colonna
	              controller.visualizzaFrameProgrammi(controller, frame, table.getValueAt(row, column));  //passo il valore del Programma cliccato
	            }
	         }
	      });
		
		table.setSelectionBackground(new Color(126, 87, 194));
		table.setRequestFocusEnabled(false);
		table.setAutoResizeMode(JTable.AUTO_RESIZE_NEXT_COLUMN);
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null},
			},
			new String[] {
				"New column", "New column"
			}
		) {
			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;
			boolean[] columnEditables = new boolean[] {
				false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		table.getColumnModel().getColumn(0).setResizable(false);
		table.getColumnModel().getColumn(1).setResizable(false);
		scrollPane.setViewportView(table);
		table.setBorder(new LineBorder(new Color(0, 0, 0)));
		table.setBackground(new Color(32, 33, 35));
		
		//definisco il pulsante di uscita
		Image imgExit = new ImageIcon(this.getClass().getResource("/exit.png")).getImage();
		
		JLabel exitLabel = new JLabel("");
		exitLabel.setBounds(486, 11, 17, 21);
		panel.add(exitLabel);
		exitLabel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		exitLabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				controller.tornaAllaHome(controller, frame, frameHome);		
			}
		});
		
		exitLabel.setIcon(new ImageIcon(imgExit));
		
		//trascino la finestra undecorated
		dragFrame = new JLabel("");
		dragFrame.setBounds(0, 0, 460, 44);
		panel.add(dragFrame);
		
		signature = new JLabel("Duminuco&Grieco.Company©");
		signature.setBounds(322, 375, 191, 33);
		panel.add(signature);
		signature.setForeground(new Color(71, 72, 75));
		signature.setFont(new Font("Century Gothic", Font.PLAIN, 11));
		
		dataProgrammaLabel = new JLabel("Data");
		dataProgrammaLabel.setBounds(39, 55, 48, 14);
		panel.add(dataProgrammaLabel);
		dataProgrammaLabel.setForeground(new Color(57, 113, 177));
		dataProgrammaLabel.setFont(new Font("Tahoma", Font.PLAIN, 11));
		dataProgrammaLabel.setBackground(new Color(57, 113, 177));
		
		textField = new JTextField();
		textField.setBounds(86, 55, 174, 20);
		panel.add(textField);
		textField.setSelectionColor(new Color(126, 87, 194));
		textField.setForeground(Color.WHITE);
		textField.setDisabledTextColor(Color.WHITE);
		textField.setColumns(10);
		textField.setCaretColor(Color.WHITE);
		textField.setBorder(null);
		textField.setBackground(new Color(32, 33, 35));
		
		separator_1 = new JSeparator();
		separator_1.setBounds(86, 79, 174, 2);
		panel.add(separator_1);
		
		JLabel sedeLabel = new JLabel("Sede");
		sedeLabel.setBounds(39, 110, 48, 14);
		panel.add(sedeLabel);
		sedeLabel.setForeground(new Color(57, 113, 177));
		sedeLabel.setFont(new Font("Tahoma", Font.PLAIN, 11));
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(86, 107, 154, 21);
		panel.add(comboBox);
		comboBox.setBorder(null);
		comboBox.setBackground(new Color(32, 33, 35));
		
		JButton aggiornaListaConferenzeButton = new JButton("aggiorna");
		aggiornaListaConferenzeButton.setBounds(373, 103, 88, 26);
		panel.add(aggiornaListaConferenzeButton);
		aggiornaListaConferenzeButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		aggiornaListaConferenzeButton.setForeground(Color.WHITE);
		aggiornaListaConferenzeButton.setFont(new Font("Century Gothic", Font.PLAIN, 12));
		aggiornaListaConferenzeButton.setFocusPainted(false);
		aggiornaListaConferenzeButton.setBorder(null);
		aggiornaListaConferenzeButton.setBackground(new Color(126, 87, 194));
		
		JLabel lblNewLabel = new JLabel("filtra per data");
		lblNewLabel.setBounds(86, 85, 174, 14);
		panel.add(lblNewLabel);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblNewLabel.setForeground(new Color(71, 72, 75));
		
		JLabel lblFiltraPerSede = new JLabel("filtra per sede");
		lblFiltraPerSede.setBounds(86, 131, 174, 14);
		panel.add(lblFiltraPerSede);
		lblFiltraPerSede.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblFiltraPerSede.setForeground(new Color(71, 72, 75));
		dragFrame.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseDragged(MouseEvent e) {
				frame.setLocation(frame.getX() + e.getX() - mouseX, frame.getY() + e.getY() - mouseY);
			}
		});
		dragFrame.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				mouseX = e.getX();
				mouseY = e.getY();			}
		});
		
		frame.setBackground(new Color(32, 33, 35));
		frame.setBounds(100, 100, 513, 408);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
