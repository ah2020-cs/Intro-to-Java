
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class WordFinder extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JFileChooser jFileChooser;
	private JPanel topPanel; // the top line of objects is going to go here
	WordList wordList;
	//JList list;
	private JTextArea wordsBox = new JTextArea(20, 40); // results of the search go in here.
	private JTextField input;
	
	class clearer implements ActionListener {
		public void actionPerformed(ActionEvent event) {
			input.setText("");
		}
	}
	

	public WordFinder() {

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		// set the size correctly
		this.setSize(500, 450);
		jFileChooser = new JFileChooser(".");
		wordList = new WordList();

		JPanel panelForTextFields = new JPanel();
		panelForTextFields.setSize(400, 180);

		//panel at the top
		topPanel = new JPanel();
		
		// Construct menu
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		menuBar.add(createMenus());
				
		// there should be objects in the top panel
		input = new JTextField(20);
		JButton clear = new JButton("Clear Entry");
		
		topPanel.add(new JLabel("Search: ")); // input prompt text
		topPanel.add(input);
		topPanel.add(clear);
		
		// There should probably be something passed into the JScrollPane
		//model = new DefaultListModel();
		//list = new JList(model);
		
		wordsBox.setEditable(false);
		JScrollPane scrollPane = new JScrollPane(wordsBox);
		panelForTextFields.add(scrollPane);

		// and of course you will want them to be properly aligned in the frame
		add(topPanel, BorderLayout.NORTH);
		add(panelForTextFields);
		
		ActionListener clearListener = new clearer();
		clear.addActionListener(clearListener);
		
		class inputListener implements DocumentListener {
			public void changedUpdate(DocumentEvent e) {
				updatePanel(panelForTextFields);
			}

			public void removeUpdate(DocumentEvent e) {
				updatePanel(panelForTextFields);
			}

			public void insertUpdate(DocumentEvent e) {
				updatePanel(panelForTextFields);
			}
		}

		input.getDocument().addDocumentListener(new inputListener());
		
	}
	
	private JMenu createMenus() {
		/* add a "File" menu with:
		 * "Open" item which allows you to choose a new file
		 * "Exit" item which ends the process with System.exit(0);
		 * Key shortcuts are optional
		 */
		
		/* OpenActionListener that will open the file chooser */
		class OpenActionListener implements ActionListener {
			public void actionPerformed(ActionEvent e) {
				OpenFileListener myFileListener = new OpenFileListener();
				myFileListener.actionPerformed(e);
			}
		}
		class ExitActionListener implements ActionListener {
			public void actionPerformed(ActionEvent event) {
				System.exit(0);
			}
		}
		
		JMenu menu = new JMenu("File");
		JMenuItem menuOpen = new JMenuItem("Open");
		JMenuItem menuExit = new JMenuItem("Exit");

		menuExit.addActionListener(new ExitActionListener());
		menuOpen.addActionListener(new OpenActionListener());

		menu.add(menuOpen);
		menu.add(menuExit);
		return menu;
			
	}

	private void find(){
		
		String input1 = input.getText();
		List<String> result = wordList.find(input1); // figure out from WordList how to get this

		// you're going to want to get the words in the
		// searchResult list and put them in the textbox.
		
		wordsBox.setText("");
		for (Object word : result) {
			wordsBox.append(word + "\n");
		}
		wordsBox.setCaretPosition(0);
	}
	
	private void updatePanel(JPanel panel) {
		// same as getQueryResult with no argument, but also repaint the input JPanel
		// after result queried.
		find();
		panel.repaint();
	}
	
	class OpenFileListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			int returnVal = jFileChooser.showOpenDialog(getParent());
			if (returnVal == JFileChooser.APPROVE_OPTION) {
				try {
					System.out.println("You chose to open this file: " + jFileChooser.getSelectedFile().getAbsolutePath());

					InputStream in = new FileInputStream(jFileChooser.getSelectedFile().getAbsolutePath());
					wordList.load(in);

					//List searchResult = null; // figure out from WordList how to get this
					// because you will load in a wordlist and there
					// might be data in the search box
					
					find();

				} catch (IOException error){
					error.printStackTrace();
				}
			}
		}
	}


	public static void main(String[] args)  {

		WordFinder wordFinder = new WordFinder();
		wordFinder.setVisible(true);
	}
}
