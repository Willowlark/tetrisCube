import java.util.*;

public class Piece
{
    //fields
    // first array is for each combo, second for each block, last for the x and y modifier.
    int positionsX[][][];
    String name;
    Random rand = new Random();
    int combos;
    char pieceChar;
    
    ArrayList<String> allPieces = new ArrayList(Arrays.asList("Line", "Cross", "L1", "L2", "Z1", "Z2", "Box"));
    
    
    //constructors
    public Piece() {
	int c = rand.nextInt(7);
	if(c == 0)
	{
	    name = "Line";
	    positionsX = new int[8][3][2];
	    combos = 8;
	    pieceChar = '@';
	    loadLinePos();
	}
	else if(c == 1)
	{
	    name = "Cross";
	    positionsX = new int[16][3][2];
	    combos = 16;
	    pieceChar = '#';
	    loadCrossPositions();
	}
	else if(c == 2)
	{
	  name = "L1";
	  positionsX = new int[16][3][2];
	  combos = 16;
	  pieceChar = '$';
	  loadL1Positons();
	}
	else if(c == 3)
	{
	  name = "L2";
	  positionsX = new int[16][3][2];
	  combos = 16;
	  pieceChar = '%';
	  loadL2Positions();
	}
	else if(c == 4)
	{
	  name = "Z1";
	  positionsX = new int[8][3][2];
	  combos = 8;
	  pieceChar = '&';
	  loadZ1Positions();
	}
	else if(c == 5)
	{
	  name = "Z2";
	  positionsX = new int[8][3][2];
	  combos = 8;
	  pieceChar = '*';
	  loadZ2Positions();
	}
	else if(c == 6)
	{
	  name = "Box";
	  positionsX = new int[4][3][2];
	  combos = 4;
	  pieceChar = '+';
	  loadBoxPositions();
	}
    }
    
    
    //function methods
    private void loadLinePos() {
	// ***&
	positionsX[0][0][0] = -1;
	positionsX[0][0][1] = 0;
	positionsX[0][1][0] = -2;
	positionsX[0][1][1] = 0;
	positionsX[0][2][0] = -3;
	positionsX[0][2][1] = 0;
	
	//**&*
	positionsX[1][0][0] = 1;
	positionsX[1][0][1] = 0;
	positionsX[1][1][0] = -1;
	positionsX[1][1][1] = 0;
	positionsX[1][2][0] = -2;
	positionsX[1][2][1] = 0;
	
	//*&**
	positionsX[2][0][0] = -1;
	positionsX[2][0][1] = 0;
	positionsX[2][1][0] = 1;
	positionsX[2][1][1] = 0;
	positionsX[2][2][0] = 2;
	positionsX[2][2][1] = 0;
	
	// &***
	positionsX[3][0][0] = 1;
	positionsX[3][0][1] = 0;
	positionsX[3][1][0] = 2;
	positionsX[3][1][1] = 0;
	positionsX[3][2][0] = 3;
	positionsX[3][2][1] = 0;
	
	// * * * &
	// * * & *
	// * & * *
	// & * * *
	
	positionsX[4][0][0] = 0;
	positionsX[4][0][1] = -1;
	positionsX[4][1][0] = 0;
	positionsX[4][1][1] = -2;
	positionsX[4][2][0] = 0;
	positionsX[4][2][1] = -3;
	
	positionsX[5][0][0] = 0;
	positionsX[5][0][1] = 1;
	positionsX[5][1][0] = 0;
	positionsX[5][1][1] = -1;
	positionsX[5][2][0] = 0;
	positionsX[5][2][1] = -2;
	
	positionsX[6][0][0] = 0;
	positionsX[6][0][1] = 2;
	positionsX[6][1][0] = 0;
	positionsX[6][1][1] = 1;
	positionsX[6][2][0] = 0;
	positionsX[6][2][1] = -1;
	
	positionsX[7][0][0] = 0;
	positionsX[7][0][1] = 3;
	positionsX[7][1][0] = 0;
	positionsX[7][1][1] = 2;
	positionsX[7][2][0] = 0;
	positionsX[7][2][1] = 1;
    }
    
    private void loadCrossPositions() {
    	// &**
    	//  *
    	positionsX[0][0][0] = 1;
	positionsX[0][0][1] = 0;
	positionsX[0][1][0] = 2;
	positionsX[0][1][1] = 0;
	positionsX[0][2][0] = 1;
	positionsX[0][2][1] = 1;
	
	// *&*
	//  *
	positionsX[1][0][0] = -1;
	positionsX[1][0][1] = 0;
	positionsX[1][1][0] = 1;
	positionsX[1][1][1] = 0;
	positionsX[1][2][0] = 0;
	positionsX[1][2][1] = 1;
	
	// **&
	//  *
	positionsX[2][0][0] = -1;
	positionsX[2][0][1] = 0;
	positionsX[2][1][0] = -2;
	positionsX[2][1][1] = 0;
	positionsX[2][2][0] = -1;
	positionsX[2][2][1] = 1;
	
	// ***
	//  &
	positionsX[3][0][0] = -1;
	positionsX[3][0][1] = -1;
	positionsX[3][1][0] = 0;
	positionsX[3][1][1] = -1;
	positionsX[3][2][0] = 1;
	positionsX[3][2][1] = -1;
	
	//  &
	// ***
	positionsX[4][0][0] = -1;
	positionsX[4][0][1] = 1;
	positionsX[4][1][0] = 0;
	positionsX[4][1][1] = 1;
	positionsX[4][2][0] = 1;
	positionsX[4][2][1] = 1;
	
	//  *
	// &**
	positionsX[5][0][0] = 1;
	positionsX[5][0][1] = 0;
	positionsX[5][1][0] = 2;
	positionsX[5][1][1] = 0;
	positionsX[5][2][0] = 1;
	positionsX[5][2][1] = -1;
	
	//  *
	// *&*
	positionsX[6][0][0] = -1;
	positionsX[6][0][1] = 0;
	positionsX[6][1][0] = 1;
	positionsX[6][1][1] = 0;
	positionsX[6][2][0] = 0;
	positionsX[6][2][1] = -1;
	
	//  *
	// **&
	positionsX[7][0][0] = -1;
	positionsX[7][0][1] = 0;
	positionsX[7][1][0] = -2;
	positionsX[7][1][1] = 0;
	positionsX[7][2][0] = -1;
	positionsX[7][2][1] = -1;
	
	// &
	// **
	// *
	positionsX[8][0][0] = 0;
	positionsX[8][0][1] = 1;
	positionsX[8][1][0] = 0;
	positionsX[8][1][1] = 2;
	positionsX[8][2][0] = 1;
	positionsX[8][2][1] = 1;
	
	// *
	// &*
	// *
	positionsX[9][0][0] = 0;
	positionsX[9][0][1] = -1;
	positionsX[9][1][0] = 0;
	positionsX[9][1][1] = 1;
	positionsX[9][2][0] = 1;
	positionsX[9][2][1] = 0;
	
	// *
	// *&
	// *
	positionsX[10][0][0] = -1;
	positionsX[10][0][1] = -1;
	positionsX[10][1][0] = -1;
	positionsX[10][1][1] = 0;
	positionsX[10][2][0] = -1;
	positionsX[10][2][1] = 1;
	
	// *
	// **
	// &
	positionsX[11][0][0] = 0;
	positionsX[11][0][1] = -1;
	positionsX[11][1][0] = 0;
	positionsX[11][1][1] = -2;
	positionsX[11][2][0] = 1;
	positionsX[11][2][1] = -1;
	
	//  *
	// &*
	//  *
	positionsX[12][0][0] = 0;
	positionsX[12][0][1] = 1;
	positionsX[12][1][0] = 1;
	positionsX[12][1][1] = -1;
	positionsX[12][2][0] = 1;
	positionsX[12][2][1] = 1;
	
	//  &
	// **
	//  *
	positionsX[13][0][0] = 0;
	positionsX[13][0][1] = 1;
	positionsX[13][1][0] = 0;
	positionsX[13][1][1] = 2;
	positionsX[13][2][0] = -1;
	positionsX[13][2][1] = 1;
	
	//  *
	// *&
	//  *
	positionsX[14][0][0] = 0;
	positionsX[14][0][1] = -1;
	positionsX[14][1][0] = 0;
	positionsX[14][1][1] = 1;
	positionsX[14][2][0] = -1;
	positionsX[14][2][1] = 0;
	
	//  *
	// **
	//  &
	positionsX[15][0][0] = 0;
	positionsX[15][0][1] = -1;
	positionsX[15][1][0] = 0;
	positionsX[15][1][1] = -2;
	positionsX[15][2][0] = -1;
	positionsX[15][2][1] = -1;
	
    }
    
    private void loadL1Positons() {
	
	// &**
    	//   *
    	positionsX[0][0][0] = 1;
	positionsX[0][0][1] = 0;
	positionsX[0][1][0] = 2;
	positionsX[0][1][1] = 0;
	positionsX[0][2][0] = 2;
	positionsX[0][2][1] = 1;
	
	// *&*
	//   *
	positionsX[1][0][0] = -1;
	positionsX[1][0][1] = 0;
	positionsX[1][1][0] = 1;
	positionsX[1][1][1] = 0;
	positionsX[1][2][0] = 1;
	positionsX[1][2][1] = 1;
	
	// **&
	//   *
	positionsX[2][0][0] = -1;
	positionsX[2][0][1] = 0;
	positionsX[2][1][0] = -2;
	positionsX[2][1][1] = 0;
	positionsX[2][2][0] = 0;
	positionsX[2][2][1] = 1;
	
	// ***
	//   &
	positionsX[3][0][0] = -2;
	positionsX[3][0][1] = -1;
	positionsX[3][1][0] = -1;
	positionsX[3][1][1] = -1;
	positionsX[3][2][0] = 0;
	positionsX[3][2][1] = -1;
	
	// &
	// ***
	positionsX[4][0][0] = 0;
	positionsX[4][0][1] = 1;
	positionsX[4][1][0] = 1;
	positionsX[4][1][1] = 1;
	positionsX[4][2][0] = 2;
	positionsX[4][2][1] = 1;
	
	// *
	// &**
	positionsX[5][0][0] = 0;
	positionsX[5][0][1] = -1;
	positionsX[5][1][0] = 1;
	positionsX[5][1][1] = 0;
	positionsX[5][2][0] = 2;
	positionsX[5][2][1] = 0;
	
	// *
	// *&*
	positionsX[6][0][0] = -1;
	positionsX[6][0][1] = 0;
	positionsX[6][1][0] = -1;
	positionsX[6][1][1] = -1;
	positionsX[6][2][0] = 1;
	positionsX[6][2][1] = 0;
	
	// *
	// **&
	positionsX[7][0][0] = -1;
	positionsX[7][0][1] = 0;
	positionsX[7][1][0] = -2;
	positionsX[7][1][1] = 0;
	positionsX[7][2][0] = -2;
	positionsX[7][2][1] = -1;
	
	// *&
	// *
	// *
	positionsX[8][0][0] = -1;
	positionsX[8][0][1] = 0;
	positionsX[8][1][0] = -1;
	positionsX[8][1][1] = 1;
	positionsX[8][2][0] = -1;
	positionsX[8][2][1] = 2;
	
	// &*
	// *
	// *
	positionsX[9][0][0] = 1;
	positionsX[9][0][1] = 0;
	positionsX[9][1][0] = 0;
	positionsX[9][1][1] = 1;
	positionsX[9][2][0] = 0;
	positionsX[9][2][1] = 2;
	
	// **
	// &
	// *
	positionsX[10][0][0] = 1;
	positionsX[10][0][1] = -1;
	positionsX[10][1][0] = 0;
	positionsX[10][1][1] = -1;
	positionsX[10][2][0] = 0;
	positionsX[10][2][1] = 1;
	
	// **
	// *
	// &
	positionsX[11][0][0] = 0;
	positionsX[11][0][1] = -1;
	positionsX[11][1][0] = 0;
	positionsX[11][1][1] = -2;
	positionsX[11][2][0] = 1;
	positionsX[11][2][1] = -2;
	
	//  *
	//  *
	// &*
	positionsX[12][0][0] = 1;
	positionsX[12][0][1] = 0;
	positionsX[12][1][0] = 1;
	positionsX[12][1][1] = -1;
	positionsX[12][2][0] = 1;
	positionsX[12][2][1] = -2;
	
	//  &
	//  *
	// **
	positionsX[13][0][0] = 0;
	positionsX[13][0][1] = 1;
	positionsX[13][1][0] = 0;
	positionsX[13][1][1] = 2;
	positionsX[13][2][0] = -1;
	positionsX[13][2][1] = 2;
	
	//  *
	//  &
	// **
	positionsX[14][0][0] = 0;
	positionsX[14][0][1] = -1;
	positionsX[14][1][0] = 0;
	positionsX[14][1][1] = 1;
	positionsX[14][2][0] = -1;
	positionsX[14][2][1] = 1;
	
	//  *
	//  *
	// *&
	positionsX[15][0][0] = 0;
	positionsX[15][0][1] = -1;
	positionsX[15][1][0] = 0;
	positionsX[15][1][1] = -2;
	positionsX[15][2][0] = -1;
	positionsX[15][2][1] = 0;
    }
    
    private void loadL2Positions() {
    	
	// ***
    	// &
    	positionsX[0][0][0] = 0;
	positionsX[0][0][1] = -1;
	positionsX[0][1][0] = 1;
	positionsX[0][1][1] = -1;
	positionsX[0][2][0] = 2;
	positionsX[0][2][1] = -1;
	
	// &**
	// *
	positionsX[1][0][0] = 1;
	positionsX[1][0][1] = 0;
	positionsX[1][1][0] = 2;
	positionsX[1][1][1] = 0;
	positionsX[1][2][0] = 0;
	positionsX[1][2][1] = 1;
	
	// *&*
	// *
	positionsX[2][0][0] = -1;
	positionsX[2][0][1] = 0;
	positionsX[2][1][0] = 1;
	positionsX[2][1][1] = 0;
	positionsX[2][2][0] = -1;
	positionsX[2][2][1] = 1;
	
	// **&
	// *
	positionsX[3][0][0] = -1;
	positionsX[3][0][1] = 0;
	positionsX[3][1][0] = -2;
	positionsX[3][1][1] = 0;
	positionsX[3][2][0] = -2;
	positionsX[3][2][1] = 1;
	
	//   &
	// ***
	positionsX[4][0][0] = -2;
	positionsX[4][0][1] = 1;
	positionsX[4][1][0] = -1;
	positionsX[4][1][1] = 1;
	positionsX[4][2][0] = 0;
	positionsX[4][2][1] = 1;
	
	//   *
	// &**
	positionsX[5][0][0] = 1;
	positionsX[5][0][1] = 0;
	positionsX[5][1][0] = 2;
	positionsX[5][1][1] = 0;
	positionsX[5][2][0] = 2;
	positionsX[5][2][1] = -1;
	
	//   *
	// *&*
	positionsX[6][0][0] = -1;
	positionsX[6][0][1] = 0;
	positionsX[6][1][0] = 1;
	positionsX[6][1][1] = 0;
	positionsX[6][2][0] = 1;
	positionsX[6][2][1] = -1;
	
	//   *
	// **&
	positionsX[7][0][0] = -1;
	positionsX[7][0][1] = 0;
	positionsX[7][1][0] = -2;
	positionsX[7][1][1] = 0;
	positionsX[7][2][0] = 0;
	positionsX[7][2][1] = -1;
	
	// &
	// *
	// **
	positionsX[8][0][0] = 0;
	positionsX[8][0][1] = 1;
	positionsX[8][1][0] = 0;
	positionsX[8][1][1] = 2;
	positionsX[8][2][0] = 1;
	positionsX[8][2][1] = 2;
	
	// *
	// &
	// **
	positionsX[9][0][0] = 0;
	positionsX[9][0][1] = -1;
	positionsX[9][1][0] = 0;
	positionsX[9][1][1] = 1;
	positionsX[9][2][0] = 1;
	positionsX[9][2][1] = 1;
	
	// *
	// *
	// &*
	positionsX[10][0][0] = 0;
	positionsX[10][0][1] = -2;
	positionsX[10][1][0] = 0;
	positionsX[10][1][1] = -1;
	positionsX[10][2][0] = 1;
	positionsX[10][2][1] = 0;
	
	// *
	// *
	// *&
	positionsX[11][0][0] = -1;
	positionsX[11][0][1] = 0;
	positionsX[11][1][0] = -1;
	positionsX[11][1][1] = -1;
	positionsX[11][2][0] = -1;
	positionsX[11][2][1] = -2;
	
	// &*
	//  *
	//  *
	positionsX[12][0][0] = 1;
	positionsX[12][0][1] = 0;
	positionsX[12][1][0] = 1;
	positionsX[12][1][1] = 1;
	positionsX[12][2][0] = 1;
	positionsX[12][2][1] = 2;
	
	// *&
	//  *
	//  *
	positionsX[13][0][0] = -1;
	positionsX[13][0][1] = 0;
	positionsX[13][1][0] = 0;
	positionsX[13][1][1] = 1;
	positionsX[13][2][0] = 0;
	positionsX[13][2][1] = 2;
	
	// **
	//  &
	//  *
	positionsX[14][0][0] = -1;
	positionsX[14][0][1] = -1;
	positionsX[14][1][0] = 0;
	positionsX[14][1][1] = -1;
	positionsX[14][2][0] = 0;
	positionsX[14][2][1] = 1;
	
	// **
	//  *
	//  &
	positionsX[15][0][0] = 0;
	positionsX[15][0][1] = -1;
	positionsX[15][1][0] = 0;
	positionsX[15][1][1] = -2;
	positionsX[15][2][0] = -1;
	positionsX[15][2][1] = -2;
	
	
    }
    
    private void loadZ1Positions() {
      
	// **
	//&*
	positionsX[0][0][0] = 1;
	positionsX[0][0][1] = 0;
	positionsX[0][1][0] = 1;
	positionsX[0][1][1] = -1;
	positionsX[0][2][0] = 2;
	positionsX[0][2][1] = -1;
	
	// **
	//*&
	positionsX[1][0][0] = -1;
	positionsX[1][0][1] = 0;
	positionsX[1][1][0] = 0;
	positionsX[1][1][1] = -1;
	positionsX[1][2][0] = 1;
	positionsX[1][2][1] = -1;
	
	// &*
	//**
	positionsX[2][0][0] = -1;
	positionsX[2][0][1] = 1;
	positionsX[2][1][0] = 0;
	positionsX[2][1][1] = 1;
	positionsX[2][2][0] = 1;
	positionsX[2][2][1] = 0;
	
	// *&
	//**
	positionsX[3][0][0] = -1;
	positionsX[3][0][1] = 0;
	positionsX[3][1][0] = -1;
	positionsX[3][1][1] = 1;
	positionsX[3][2][0] = -2;
	positionsX[3][2][1] = 1;
	
	//&
	//**
	// *
	positionsX[4][0][0] = 0;
	positionsX[4][0][1] = 1;
	positionsX[4][1][0] = 1;
	positionsX[4][1][1] = 1;
	positionsX[4][2][0] = 1;
	positionsX[4][2][1] = 2;
	
	//*
	//&*
	// *
	positionsX[5][0][0] = 0;
	positionsX[5][0][1] = -1;
	positionsX[5][1][0] = 1;
	positionsX[5][1][1] = 0;
	positionsX[5][2][0] = 1;
	positionsX[5][2][1] = 1;
	
	//*
	//*&
	// *
	positionsX[6][0][0] = -1;
	positionsX[6][0][1] = -1;
	positionsX[6][1][0] = -1;
	positionsX[6][1][1] = 0;
	positionsX[6][2][0] = 0;
	positionsX[6][2][1] = 1;
	
	//*
	//**
	// &
	positionsX[7][0][0] = -1;
	positionsX[7][0][1] = -2;
	positionsX[7][1][0] = -1;
	positionsX[7][1][1] = -1;
	positionsX[7][2][0] = 0;
	positionsX[7][2][1] = -1;
    }
    
    private void loadZ2Positions() {
      
	//&*
	// **
	positionsX[0][0][0] = 1;
	positionsX[0][0][1] = 0;
	positionsX[0][1][0] = 1;
	positionsX[0][1][1] = 1;
	positionsX[0][2][0] = 2;
	positionsX[0][2][1] = 1;
	
	//*&
	// **
	positionsX[1][0][0] = -1;
	positionsX[1][0][1] = 0;
	positionsX[1][1][0] = 0;
	positionsX[1][1][1] = 1;
	positionsX[1][2][0] = 1;
	positionsX[1][2][1] = 1;
	
	//**
	// &*
	positionsX[2][0][0] = -1;
	positionsX[2][0][1] = -1;
	positionsX[2][1][0] = 0;
	positionsX[2][1][1] = -1;
	positionsX[2][2][0] = 1;
	positionsX[2][2][1] = 0;
	
	//**
	// *&
	positionsX[3][0][0] = -2;
	positionsX[3][0][1] = -1;
	positionsX[3][1][0] = -1;
	positionsX[3][1][1] = -1;
	positionsX[3][2][0] = -1;
	positionsX[3][2][1] = 0;
	
	// &
	//**
	//*
	positionsX[4][0][0] = 0;
	positionsX[4][0][1] = 1;
	positionsX[4][1][0] = -1;
	positionsX[4][1][1] = 1;
	positionsX[4][2][0] = -1;
	positionsX[4][2][1] = 2;
	
	// *
	//&*
	//*
	positionsX[5][0][0] = 1;
	positionsX[5][0][1] = -1;
	positionsX[5][1][0] = 1;
	positionsX[5][1][1] = 0;
	positionsX[5][2][0] = 0;
	positionsX[5][2][1] = 1;
	
	// *
	//*&
	//*
	positionsX[6][0][0] = 0;
	positionsX[6][0][1] = -1;
	positionsX[6][1][0] = -1;
	positionsX[6][1][1] = 0;
	positionsX[6][2][0] = -1;
	positionsX[6][2][1] = 1;
	
	// *
	//**
	//&
	positionsX[7][0][0] = 1;
	positionsX[7][0][1] = -2;
	positionsX[7][1][0] = 0;
	positionsX[7][1][1] = -1;
	positionsX[7][2][0] = 1;
	positionsX[7][2][1] = -1;
    }
    
    private void loadBoxPositions() {
      
	//&*
	//**
	positionsX[0][0][0] = 1;
	positionsX[0][0][1] = 0;
	positionsX[0][1][0] = 1;
	positionsX[0][1][1] = 1;
	positionsX[0][2][0] = 0;
	positionsX[0][2][1] = 1;
	
	//*&
	//**
	positionsX[1][0][0] = -1;
	positionsX[1][0][1] = 0;
	positionsX[1][1][0] = 0;
	positionsX[1][1][1] = 1;
	positionsX[1][2][0] = -1;
	positionsX[1][2][1] = 1;
	
	//**
	//&*
	positionsX[2][0][0] = 0;
	positionsX[2][0][1] = -1;
	positionsX[2][1][0] = 1;
	positionsX[2][1][1] = 0;
	positionsX[2][2][0] = 1;
	positionsX[2][2][1] = -1;
	
	//**
	//*&
	positionsX[3][0][0] = 0;
	positionsX[3][0][1] = -1;
	positionsX[3][1][0] = -1;
	positionsX[3][1][1] = 0;
	positionsX[3][2][0] = -1;
	positionsX[3][2][1] = -1;
    }
    
    public int[][] buildTry(int i) {
	int ret[][] =  positionsX[i];
	return ret;
    }
    
    public Piece transformPiece() {
      
      allPieces.remove(name);
      Piece ret = null;
      boolean done = false;
      if(allPieces.size() > 0)
      {
	while(!done)
	{
	  Piece test = new Piece();
	  if(allPieces.contains(test.getName())) 
	  {
	    ret = test;
	    ret.setAllPieces(allPieces);
	    done = true;
	  }
	}
      }
      
      return ret;
    }
    
    
    
    //mutators
    private void setAllPieces(ArrayList<String> i) {
      
      allPieces = i;
    }
    
    
    
    //Accessors
    public int numberOfCombos() {
	
	return combos;
    }

    public String getName() {
      
      return name;
    }

    public char getPieceChar() {
      
      return pieceChar;
    }
}
