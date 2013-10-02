import java.util.*;
import java.awt.Color;
import java.io.*;

public class Engine
{
  
  // Fields.
  char[][] charField;
  Piece part;
  boolean debugLines = false;
  boolean randPieceChar = true;
  int waiting = 0;
  int auto = 0;
  
  // Constructors
  public Engine(int x, int y) {
    
    charField = new char[x][y];
    for(int yy = 0; yy < charField[0].length; yy++) {
      for(int xx = 0; xx < charField.length; xx++) {
	charField[xx][yy] = ' ';
      }
    }
  }
  
  public Engine() {
    
    this(10, 10);
  }
  
  
  
  // Main Method and pseudo main method
  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);
    Engine e = null;
    int s = 10;
    int x = -1;
    int y = -1;
    boolean debug = false;
    boolean randPC = true;
    boolean quit = false;
    boolean missingXY = false;
    int autoo = 0;
    int waitt = 0;

    //process flags.
    for(int i = 0; i < args.length; i++) {
      String a = args[i];
      
      //check if the arg is a flag parameter
      if(a.charAt(0) == '-')
      {
	char[] c = a.toCharArray();
	for(int o = 1; o < c.length; o++)
	{
	  int cc = c[o];
	  
	  if(cc == 's') 
	  {
	    try 
	    {
	     s = Integer.parseInt(args[i+o]);
	    }
	    catch (ArrayIndexOutOfBoundsException iob)
	    {
	      System.out.println("You need a parameter for the -size command. Using the default 10.");
	    }
	  }
	  else if(cc == 'x') 
	  {
	    try { x = Integer.parseInt(args[i+o]); }
	    catch (ArrayIndexOutOfBoundsException iob)
	    { missingXY = true; }
	  }
	  else if(cc == 'y') 
	  {
	    try { y = Integer.parseInt(args[i+o]); }
	    catch (ArrayIndexOutOfBoundsException iob)
	    { missingXY = true; }
	  }
	  else if(cc == 'd')
	  {
	    debug = true;
	  }
	  else if(cc == 'a')
	  {
	    try { autoo = Integer.parseInt(args[i+o]); }
	    catch (ArrayIndexOutOfBoundsException iob)
	    { autoo = 2; }
	  }
	  else if(cc == 'w')
	  {
	    try { waitt = Integer.parseInt(args[i+o]); }
	    catch (ArrayIndexOutOfBoundsException iob)
	    { waitt = 1; }
	  }
	  else if(cc == 'c')
	  {
	    randPC = false;
	  }
	  else if(cc == 'h')
	  {
	    System.out.println("Runs a simulation filling in a square of a set size with tetris blocks.");
	    System.out.println("-s(ize) : Sets the square's x and y parameter.");
	    System.out.println("-x : sets the x dimension of the program. Must be used with the -y command.");
	    System.out.println("-y : sets the y dimension of the program. Must be used with the -x command.");
	    System.out.println("-a(utomatic) : automatically run the next step after a 2 second (or a specified) delay.");
	    System.out.println("-w(ait) : delay after each block part is drawn 1 second or a specifed amount.");
	    System.out.println("-d(ebug) : Prints debug lines during the steps.");
	    System.out.println("-c(harRandomization) : turns on random character for drawing a particular shape.");
	    quit = true;
	  }
	}
      }
    }
    
    if(quit) System.exit(0);
    
    if(y > 0 || x > 0 || missingXY)
    {
    	try { e = new Engine(x, y); }
    	catch(NegativeArraySizeException nas)
    	{
    	System.out.println("You need to set both the x and y sizes. If you want both to be the same, use the -s(ize) command.");
    	System.exit(0);
    	}
    	
    }
    else e = new Engine(s, s);
    if(debug) e.debugLines = true;
    if(randPC) e.randPieceChar = false;
    if(autoo > 0) e.auto = autoo;
    if(waitt > 0) e.waiting = waitt;
    
    
    //run program.
    e.initalize();
    e.printField();
    while(!quit)
    {
      String in = "";
      //System.out.println("");
      System.out.print(">");
      if(e.auto > 0)
      {
	e.waitProgram(1);
      }
      else 
      {
	in = scan.nextLine();
      }
      if(in.equals("quit")) 
      {
	quit = true;
	break;
      }
      boolean b = e.stepChar();
      //System.out.println("");
      if(e.waiting <= 0) e.printField();
      if(!b) quit = true;
    }
    System.out.println("No more possible moves.");
    
  }
  
  public void run() {
    boolean done = false;
    while(!done)
    {
      done = stepChar();
      printField();
      printField();
    }
  }
  
  
  
  // Function methods
  public boolean stepChar() {
    
    boolean drawn = false;
    
    //get all open positions
    ArrayList<int[]> posses = getOpenPositions();
    if(posses.size() == 0) {
      
      drawn = true;
      if(debugLines)System.out.println("No open spaces.");
    }
    
    //get a part
    part = new Piece();
    
    while(!drawn)
    {
      int[] poses = getRandPosition(posses);
      if(poses == null) 
      {
	if(debugLines)System.out.println("No more possible moves(for this part)");
	part = part.transformPiece();
	if(part == null) break;
	else 
	{
	  posses = getOpenPositions();
	  if(posses.size() == 0) 
	  {
	    drawn = true;
	    if(debugLines)System.out.println("No open spaces.");
	  }
	  continue;
	}
      }
      int x = poses[0];
      int y = poses[1];
      
      //check if a position is valid
      //declare a valid position collection.
      ArrayList<int[][]> validpos = new ArrayList<int[][]>();
      
      //for the number of possible combos.
      for(int tryz = 0; tryz < part.numberOfCombos(); tryz++) 
      {
	//get the combo mods,
	int[][] blocks = part.buildTry(tryz);
	int validCount = 0;
	
	//for each square in the shape, check validity
	for(int square = 0; square < blocks.length; square++) {
	  
	  if(isPostEmpty(x+blocks[square][0], y+blocks[square][1])) validCount++;
	  if(validCount >= 3) 
	  {
	    validpos.add(blocks);
	    validCount = 0;
	  }
	}
      }
      
      //try each of the valid positions, if any, first one will cycle loop.
      if(validpos.size() != 0)
      {
	int[][] mods = getDoubleRandPosition(validpos);
	drawn = drawPiece(x, y, part, mods);
      }
      else if(debugLines)System.out.println("No valid pos.");
    }
    return drawn;
  }
  
  public void initalize() {
    //get first draw position
    int x = charField.length/2;
    int y = charField[0].length/2;
    
    //get a piece to place
    part = new Piece();
    
    //draw the first part
    drawPiece(x, y, part, part.buildTry(1));
  }
  
  private ArrayList<int[]> getOpenPositions() {
    
    ArrayList<int[]> ret = new ArrayList<int[]>();
    for(int y = 0; y < charField[0].length; y++) {
      for(int x = 0; x < charField.length; x++) {
	
	
	ArrayList<int[]> cross = new ArrayList<int[]>();
	if(!isPostEmpty(x, y))
	{
	  if(isPostEmpty(x-1, y)) cross.add(new int[]{x-1, y});
	  if(isPostEmpty(x+1, y)) cross.add(new int[]{x+1, y});
	  if(isPostEmpty(x, y-1)) cross.add(new int[]{x, y-1});
	  if(isPostEmpty(x, y+1)) cross.add(new int[]{x, y+1});
	}
	
	if(cross.size() > 0 && ret.size() != 0)
	{
	  for(int i = 0; i<ret.size(); i++) {
	    for(int o = 0; o<cross.size(); o++)
	    {
	      int[] g = ret.get(i);
	      int[] p = cross.get(o);
	      if(g[0] == p[1]) {
		if(g[1] == p[1])
		{
		  cross.remove(o);
		}
	      }
	    }
	  }
	  for(int[] o : cross) ret.add(o);
	}
	else if(ret.size() == 0)
	{
	  for(int[] o : cross) ret.add(o);
	}
      }
    }
    
    return ret;
  }
  
  private int[] getRandPosition(ArrayList<int[]> i) {
    
    Random rand = new Random();
    
    if(i.size() > 0)
    {
      int z = rand.nextInt(i.size());
      int[] f;
      f = i.get(z);
      i.remove(z);
      return f;
    }
    else return null;
  }
  
  private int[][] getDoubleRandPosition(ArrayList<int[][]> i) {
    
    Random rand = new Random();
    
    if(i.size() > 0)
    {
      int z = rand.nextInt(i.size());
      int[][] f;
      f = i.get(z);
      i.remove(z);
      return f;
    }
    else return null;
  }
  
  private boolean isPostEmpty(int x, int y) {
    
    if(charField.length > x && x >= 0 && charField[0].length > y && y >= 0 && charField[x][y] == ' ') 
    { return true; }
    else return false;
  }
  
  private char randomChar() {
    
    Random rand = new Random();
    int z = rand.nextInt(7);
    switch(z)
    {
      case 0: return '@';
      case 1: return '$';
      case 2: return '&';
      case 3: return '*';
      case 4: return '#';
      case 5: return '%';
      case 6: return '+';
    }
    return 'n';
  }
  
  private void waitProgram(int which) {
    
    int w;
    if(which == 0) 
    {
      w = waiting;
      printField();
    }
    else w = auto;
    long t0 = System.currentTimeMillis();
    long t1;
    do 
    { 
      t1 = System.currentTimeMillis();
    } while((t1 - t0) < (w * 1000));
  }
  
  
  // Terminal drawing methods.
  private boolean drawPiece(int x, int y, Piece p, int[][] mods) {
    
    char c;
    if(randPieceChar) c = randomChar();
    else c = p.getPieceChar();
    charField[x][y] = c;
    if(waiting>0) waitProgram(0);
    for(int i = 0; i < mods.length; i++)
    {
      charField[x+mods[i][0]][y+mods[i][1]] = c;
      if(waiting>0 && (i+1) != mods.length) waitProgram(0);
    }
    
    if(debugLines)System.out.println("good.");
    return true;
  }
  
  private void printField() {
    System.out.println("");
    for(int top =  0; top < charField.length+2; top++) System.out.print("-");
    System.out.print("\n");
    for(int y = 0; y < charField[0].length; y++) 
    {
      System.out.print("|");
      for(int x = 0; x < charField.length; x++) 
      {
	System.out.print(charField[x][y]);
      }
      System.out.print("|");
      System.out.print("\n");
    }
    for(int top =  0; top < charField.length+2; top++) System.out.print("-");
    System.out.println("");
  }
  
  
  
  //accessors
  public char[][] getCharField() {
    
    return charField;
  }
}
