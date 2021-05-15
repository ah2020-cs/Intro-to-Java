import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Random;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.Timer;
//final version

public class Minesweeper extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private JFrame frame = new JFrame("Minesweeper");
	private JLabel statusbar;
	private JPanel topPanel;
	JTextField counter = new JTextField();
    final private int delay = 1000;
    private int seconds = 1000;
    Timer timer;
	
	public Minesweeper() {

		//panel at the top
		topPanel = new JPanel();
		topPanel.add(new JLabel("Seconds left to Play!:")); 
		add(topPanel, BorderLayout.NORTH);
		
		// Construct menu
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		menuBar.add(createMenus());
		
		timer = new Timer(delay, taskPerformer);
        timer.start();
        
        //Layout
        counter.setHorizontalAlignment(JTextField.CENTER);
        counter.setEditable(false);
        counter.setText("Counter");
        Font fontC = new Font("SansSerif", Font.BOLD, 15);
        counter.setFont(fontC);
        topPanel.add(counter);

        statusbar = new JLabel("");
        add(statusbar, BorderLayout.SOUTH);
        add(new Board(statusbar));

        setResizable(false);
        pack();

        setTitle("Minesweeper - AH");
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
    }
	
	//Timer
    final private ActionListener taskPerformer = new ActionListener() {
        public void actionPerformed(ActionEvent event) {
            if(seconds <= 1000) {
                seconds--;
            }
            if (seconds == 0) {
            	timer.stop();
            	JOptionPane.showMessageDialog(frame, "Times Up!");
            	System.exit(0);
            }
            counter.setText(""+seconds);
        }
    };
    
	private JMenu createMenus() {
		
		class NewActionListener implements ActionListener {
			public void actionPerformed(ActionEvent event) {
				var ex = new Minesweeper();
	            ex.setVisible(true);
			}
		}
		
		/*class OpenActionListener implements ActionListener {
			public void actionPerformed(ActionEvent event) {
				OpenFileListener myFileListener = new OpenFileListener();
				myFileListener.actionPerformed(event);
		    }
	    }
		
		class SaveActionListener implements ActionListener {
			public void actionPerformed(ActionEvent event) {

	    	}
    	}*/
		
		class ExitActionListener implements ActionListener {
			public void actionPerformed(ActionEvent event) {
				System.exit(0);
			}
		}
		
		JMenu menu = new JMenu("Menu");
		JMenuItem menuNew = new JMenuItem("New");
		JMenuItem menuOpen = new JMenuItem("Open");
		JMenuItem menuSave = new JMenuItem("Save");
		JMenuItem menuExit = new JMenuItem("Exit");
		
		menuNew.addActionListener(new NewActionListener());
		//menuOpen.addActionListener(new OpenActionListener());
		//menuSave.addActionListener(new SaveActionListener());
		menuExit.addActionListener(new ExitActionListener());
		
		menu.add(menuNew);
		menu.add(menuOpen);
		menu.add(menuSave);
		menu.add(menuExit);
		return menu;
			
	}

    public static void main(String[] args) {

        EventQueue.invokeLater(() -> {
            var ex = new Minesweeper();
            ex.setVisible(true);
        });
    }
}

class Board extends JPanel {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private final int tImages = 13;
    private final int cellSize = 30;
    private final int cover = 10;
    private final int marks = 10;
    private final int emptyCell = 0;
    private final int mineCell = 9;
    private final int coveredMC = 19;
    private final int markedMC = 29;
    private final int drawMine = 9;
    private final int drawCover = 10;
    private final int drawMark = 11;
    private final int drawWrong = 12;
    private final int tMines = 40;
    private final int tRows = 16;
    private final int tCols = 16;
    private final int width = 481;
    private final int height = 481;
    private int[] field;
    private boolean inGame;
    private int minesLeft;
    private Image[] img;
    private int totalCells = 256;
    private final JLabel statusbar;
    

    
    public Board(JLabel statusbar) {
        this.statusbar = statusbar;
        newBoard();
    }
    
    private void newBoard() {

        setPreferredSize(new Dimension(width, height));

        img = new Image[tImages];

        for (int i = 0; i < tImages; i++) {
            var path = "tiles/" + i + ".png";
            img[i] = (new ImageIcon(path)).getImage();
        }
        addMouseListener(new MinesAdapter());
        newGame();
    }

    private void newGame() {
    	

        int cells;
        var random = new Random();
        inGame = true;
        minesLeft = tMines;
        field = new int[totalCells];

        for (int i = 0; i < totalCells; i++) {
            field[i] = cover;
        }

        statusbar.setText(Integer.toString(minesLeft));
        int i = 0;

        while (i < tMines) {

            int position = (int) (totalCells * random.nextDouble());

            if ((position < totalCells) && (field[position] != coveredMC)) {

                int col = position % tCols;
                field[position] = coveredMC;
                i++;

                if (col > 0) {
                    cells = position - 1 - tCols;
                    if (cells >= 0) {
                        if (field[cells] != coveredMC) {
                            field[cells] += 1;
                        }
                    }
                    cells = position - 1;
                    if (cells >= 0) {
                        if (field[cells] != coveredMC) {
                            field[cells] += 1;
                        }
                    }

                    cells = position + tCols - 1;
                    if (cells < totalCells) {
                        if (field[cells] != coveredMC) {
                            field[cells] += 1;
                        }
                    }
                }

                cells = position - tCols;
                if (cells >= 0) {
                    if (field[cells] != coveredMC) {
                        field[cells] += 1;
                    }
                }

                cells = position + tCols;
                if (cells < totalCells) {
                    if (field[cells] != coveredMC) {
                        field[cells] += 1;
                    }
                }

                if (col < (tCols - 1)) {
                    cells = position - tCols + 1;
                    if (cells >= 0) {
                        if (field[cells] != coveredMC) {
                            field[cells] += 1;
                        }
                    }
                    cells = position + tCols + 1;
                    if (cells < totalCells) {
                        if (field[cells] != coveredMC) {
                            field[cells] += 1;
                        }
                    }
                    cells = position + 1;
                    if (cells < totalCells) {
                        if (field[cells] != coveredMC) {
                            field[cells] += 1;
                        }
                    }
                }
            }
        }
    }


	private void emptyCells(int i) {

        int col = i % tCols;
        int cells;

        if (col > 0) {
            cells = i - tCols - 1;
            if (cells >= 0) {
                if (field[cells] > mineCell) {
                    field[cells] -= cover;
                    if (field[cells] == emptyCell) {
                        emptyCells(cells);
                    }
                }
            }

            cells = i - 1;
            if (cells >= 0) {
                if (field[cells] > mineCell) {
                    field[cells] -= cover;
                    if (field[cells] == emptyCell) {
                        emptyCells(cells);
                    }
                }
            }

            cells = i + tCols - 1;
            if (cells < totalCells) {
                if (field[cells] > mineCell) {
                    field[cells] -= cover;
                    if (field[cells] == emptyCell) {
                        emptyCells(cells);
                    }
                }
            }
        }

        cells = i - tCols;
        if (cells >= 0) {
            if (field[cells] > mineCell) {
                field[cells] -= cover;
                if (field[cells] == emptyCell) {
                    emptyCells(cells);
                }
            }
        }

        cells = i + tCols;
        if (cells < totalCells) {
            if (field[cells] > mineCell) {
                field[cells] -= cover;
                if (field[cells] == emptyCell) {
                    emptyCells(cells);
                }
            }
        }

        if (col < (tCols - 1)) {
            cells = i - tCols + 1;
            if (cells >= 0) {
                if (field[cells] > mineCell) {
                    field[cells] -= cover;
                    if (field[cells] == emptyCell) {
                        emptyCells(cells);
                    }
                }
            }

            cells = i + tCols + 1;
            if (cells < totalCells) {
                if (field[cells] > mineCell) {
                    field[cells] -= cover;
                    if (field[cells] == emptyCell) {
                        emptyCells(cells);
                    }
                }
            }

            cells = i + 1;
            if (cells < totalCells) {
                if (field[cells] > mineCell) {
                    field[cells] -= cover;
                    if (field[cells] == emptyCell) {
                        emptyCells(cells);
                    }
                }
            }
        }

    }
    
    @Override
    public void paintComponent(Graphics g) {

        int uncover = 0;

        for (int i = 0; i < tRows; i++) {

            for (int j = 0; j < tCols; j++) {
                int cell = field[(i * tCols) + j];

                if (inGame && cell == mineCell) {
                    inGame = false;
                }

                if (!inGame) {

                    if (cell == coveredMC) {
                        cell = drawMine;
                    } else if (cell == markedMC) {
                        cell = drawMark;
                    } else if (cell > coveredMC) {
                        cell = drawWrong;
                    } else if (cell > mineCell) {
                        cell = drawCover;
                    }

                } else {

                    if (cell > coveredMC) {
                        cell = drawMark;
                    } else if (cell > mineCell) {
                        cell = drawCover;
                        uncover++;
                    }
                }
                g.drawImage(img[cell], (j * cellSize), (i * cellSize), 30, 30, this);
            }
        }

        if (uncover == 0 && inGame) {
            inGame = false;
            statusbar.setText("Game Won!");
        } else if (!inGame) {
            statusbar.setText("Game Lost!");
            //JFrame frame = new JFrame("Minesweeper");
        	//JOptionPane.showMessageDialog(frame, "Game Over!");
        	//System.exit(0);
        }
    }

    private class MinesAdapter extends MouseAdapter {
        @Override
        public void mousePressed(MouseEvent event) {

            int x = event.getX();
            int y = event.getY();

            int colsC = x / cellSize;
            int rowsC = y / cellSize;

            boolean repaint = false;

            if (!inGame) {
                newGame();
                repaint();
            }

            if ((x < tCols * cellSize) && (y < tRows * cellSize)) {

                if (event.getButton() == MouseEvent.BUTTON3) {

                    if (field[(rowsC * tCols) + colsC] > mineCell) {
                        repaint = true;

                        if (field[(rowsC * tCols) + colsC] <= coveredMC) {
                            if (minesLeft > 0) {
                                field[(rowsC * tCols) + colsC] += marks;
                                minesLeft--;
                                String msg = Integer.toString(minesLeft);
                                statusbar.setText(msg);
                            } else {
                                statusbar.setText("None left");
                            }
                        } else {

                            field[(rowsC * tCols) + colsC] -= marks;
                            minesLeft++;
                            String msg = Integer.toString(minesLeft);
                            statusbar.setText(msg);
                        }
                    }

                } else {

                    if (field[(rowsC * tCols) + colsC] > coveredMC) {

                        return;
                    }

                    if ((field[(rowsC * tCols) + colsC] > mineCell)
                            && (field[(rowsC * tCols) + colsC] < markedMC)) {

                        field[(rowsC * tCols) + colsC] -= cover;
                        repaint = true;

                        if (field[(rowsC * tCols) + colsC] == mineCell) {
                            inGame = false;
                        }

                        if (field[(rowsC * tCols) + colsC] == emptyCell) {
                            emptyCells((rowsC * tCols) + colsC);
                        }
                    }
                }

                if (repaint) {
                    repaint();
                }
            }
        }
    }
}
