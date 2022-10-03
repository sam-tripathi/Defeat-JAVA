import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class GUI extends Solver {
	
	private JFrame frame;
	private JButton b1;
	private JButton b2;
	private JButton b3;
	private JTextField[] fields;

    public GUI() {
        frame = new JFrame();
        frame.setPreferredSize(new Dimension(800, 600));

        JPanel panel = new JPanel();

        b1 = new JButton("Solve");
        b1.addActionListener(e -> {
            // Calling a function that takees the inputted value from the UI and inturn calls more
            //  methods to solve and update the UI with solved values
	    	GUIToSudoku(fields);
     	});
        
        b2 = new JButton("Clear grid");
        b2.addActionListener(e -> {
        	// clearing all JTextFields by setting them ""
        	for (int i=0; i<81; i++) {
        		fields[i].setText("");
        		fields[i].setBackground(Color.LIGHT_GRAY);
                fields[i].setForeground(Color.BLACK);
        	}
     	});
        
        b3 = new JButton("Exit");
        b3.addActionListener(e -> {
        	// disposing the frame
    	   frame.dispose();
           System.out.println("Exited");
    	});
        
        fields = getClearedFields();
        
        panel.setBorder(BorderFactory.createEmptyBorder(30, 30, 10, 30));
        panel.setLayout(new GridLayout(10, 3)); //imported awt module for this
        for (int x=0 ; x<81 ; x++) {
           panel.add(fields[x]);
        }
        panel.add(b1);
        panel.add(b2);
        panel.add(b3);

        frame.add(panel, BorderLayout.CENTER);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("Sudoku Solver");
        frame.pack();
        frame.setVisible(true);
    
    }

    JTextField[] getClearedFields() {
    	JTextField[] newFields = new JTextField[81];
        for (int x = 0 ; x < 81 ; x++){
        	newFields[x] = new JTextField();
            JTextField f = newFields[x];
            f.setHorizontalAlignment(JTextField.CENTER);
            f.setBackground(Color.LIGHT_GRAY);
            f.setEditable(true);
            Border border = BorderFactory.createLineBorder(Color.BLACK, 1);
            f.setBorder(border);
            
            f.addKeyListener(new KeyAdapter() {
                public void keyPressed(KeyEvent ke) {
                   char pressedKey = ke.getKeyChar();
                   if (pressedKey == 8) {
                        //backspace
                	   f.setText("");
                	   f.setBackground(Color.LIGHT_GRAY);
                   } else if ((pressedKey >= '1' && pressedKey <= '9')) {
                        // after setting text we set editable false as automatucally key listener would also add the value 
                        // as soon as key is released which will lead to repeated value
                	   f.setText(""+pressedKey);
                	   f.setEditable(false);
                	   f.setBackground(Color.GRAY);
                   } else {
                	   f.setEditable(false);
                   }
                }
             });
            //  finally we set editable back to true
            f.setEditable(true);
        }
        
        return newFields;
    }
    
    void populateFieldInteractive(JTextField f, int numberToUpdate, int initial) {
    	f.setEditable(true);
    	if (initial == 0) {
    		f.setForeground(Color.BLUE);
    	} else {
    		f.setForeground(Color.BLACK);
    	}
		f.setText(""+numberToUpdate);
		f.setEditable(false);
    }
    
    void SudokuToGUI(int[][] solution, int[][] initialSudoku){
    	for (int i=0; i<9; i++) {
    		for (int j=0; j<9; j++) {
    			populateFieldInteractive(fields[(i*9) + j], solution[i][j], initialSudoku[i][j]);
    		}
    	}
    }
    
    void copySudoku(int[][] originalSudoku, int[][] copiedSudoku) {
    	for(int i=0; i<9; i++){
            for(int j=0; j<9; j++){
            	copiedSudoku[i][j] = originalSudoku[i][j];
            }
        }
    }
    
    void GUIToSudoku(JTextField[] fields){
        SudokuClass inputPuzzle = new SudokuClass();
        for(int i=0; i<9; i++){
            for(int j=0; j<9; j++){
                String val = fields[9 * i + j].getText();
                if (val.equals("")) {
                    inputPuzzle.sudoku[i][j] = 0;
                } else {
                    inputPuzzle.sudoku[i][j] = Integer.parseInt(val);
                }
            }
        }
        
        if (isValid(inputPuzzle)){
            int[][] initialSudoku = new int[9][9];
            copySudoku(inputPuzzle.sudoku, initialSudoku);
            
            int[][] solution = new int[9][9];
            solveAndGetFirstSolution(inputPuzzle, 0, 0, solution);
            
            SudokuToGUI(solution, initialSudoku);
        }

        
    }

}