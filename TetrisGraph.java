import java.util.*;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class TetrisGraph extends JFrame implements ActionListener
{
    
    Engine e;
    
    public TetrisGraph()
    {
	e = new Engine();
	e.initalize();
	makeMenuBar();
	makeFrame();
	pack();
	
	setVisible(true);
    }
    
    public static void main(String[] args)
    {
	TetrisGraph t = new TetrisGraph();
    }
    
    private void makeFrame() {
	
	Container p = getContentPane();
	p.setLayout(new BorderLayout());
    }
    
    private Object[][] charToObjArray() {
      
      char[][] c = e.getCharField();
      Object[][] ret = new Object[c.length][c[0].length];
      for(int y = 0; y < c[0].length; y++) {
	for(int x = 0; x < c.length; x++) {
	
	  ret[x][y] = (Character)c[x][y];
	}
      }
      return ret;
    }
    
    private void drawField(Object[][] field) {
      
      String[] header = new String[field.length];
      //for(Object o : header) o = (String)" ";
      JTable table = new JTable(field, header);
      this.getContentPane().add(table.getTableHeader(), BorderLayout.PAGE_START);
      this.getContentPane().add(table, BorderLayout.CENTER);
    }
    
    private void makeMenuBar() {
	
	JMenuBar menu = new JMenuBar();
	JMenu file = new JMenu("File");
	JMenu sim = new JMenu("Sim");
	
	JMenuItem close = new JMenuItem("Close");
	JMenuItem reset = new JMenuItem("Reset");
	JMenuItem step = new JMenuItem("Step");
	JMenuItem loop = new JMenuItem("Loop");
	
	close.addActionListener(this);
	reset.addActionListener(this);
	step.addActionListener(this);
	loop.addActionListener(this);
	
	file.add(close);
	sim.add(step);
	sim.add(loop);
	sim.add(reset);
	
	menu.add(file);
	menu.add(sim);
	
	setJMenuBar(menu);
    }
    
     public void actionPerformed(ActionEvent evt) {
	if(evt.getActionCommand().equals("Close")) System.exit(0);
	if(evt.getActionCommand().equals("Reset")) 
	{
	    
	}
	if(evt.getActionCommand().equals("Step"))
	{
	  e.stepChar();
	  drawField(charToObjArray());
	}
    }
}