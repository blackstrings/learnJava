package com.xai.cpp;

public class CppTest {

/*
	
	// MyMain.cpp: implementation of the MyMain class.
	//
	//////////////////////////////////////////////////////////////////////
	#pragma warning(disable:4786)
	#include <iostream>
	#include <string>
	#include <cctype>
	#include <vector>
	#include <map>



	using namespace std;

	/////////////////////////
	//define functions here
	/////////////////////////
	bool validateStartQuitInput(string a);
	bool isUserSelectionValid(string x, string y);
	void getCurrentPlayerInput(string* curPlayer, string gameBoard[][3]);
	void updateGameBoardDisplay(string a[][3]);
	bool checkForWinner(string gameBoard[][3], string* currentPlayer);
	bool checkForTie(string gameBoard[][3]);
	void aiSmartSelect(string* curPlayer, string gb[][3]);
	bool scanArrIfCanWin(string strArr[], string* curPlayer);

	int main(){


		/////////////////////////////////////////////////
		//Define all global game setting variables here
		//////////////////////////////////////////////////
		bool isWinnerFound = false;
		bool isTie = false;
		int maxRow = 3;
		int maxCol = 3;
		string gameBoard[3][3];	//creates a 3x3 matrix of strings

		//populate the grid with one empty space string value
		
		for(int row=0; row<maxRow; row++){
			for(int col=0; col<maxCol; col++){
				gameBoard[row][col] = " ";
			}
		}
		
		
		//gameBoardPtr = gameBoard;

		string p1 = "X";
		string p2 = "O";
		string * currentPlayer = &p1; 

		string title = "Let's Play Tic Tac Toe\n";

		string g0 = "Instructions:\n\n";
		string g1 = "	: 0 0 : 0 1 : 0 2 :\n\n";
		string g2 = "	: 1 0 : 1 1 : 1 2 :\n\n";
		string g3 = "	: 2 0 : 2 1 : 2 2 :\n\n";
		string grid = g0 + g1 + g2 + g3;

		//instruction
		string instruction = "Enter two coords with space to mark your decision\n";
		
		//prompts
		string n1 = "-----------------------------------------------------------\n";
		string n2 = "New Game!\n";
		string newGameText = n1 + n2 + n1;

		string prompt1 = "   A) Press A to begin\n";
		string prompt2 = "   B) Press B to quit\n";
		string promptFinalStartQuitMessage = prompt1 + prompt2;

		////////////////////////////////////
		//display title, grid, and instructions
		////////////////////////////////////

		//enable all cout below when final
		//cout << title << endl;
		//cout << grid << endl;
		//cout << instruction << endl;
		//cout << newGameText << endl;

		///////////////////////////////////
		// display start or quit options
		///////////////////////////////////
		//cout << promptFinalStartQuitMessage << endl;

		//prompt user
		string ans;
		cin >> ans;

		////////////////////
		//validate input
		////////////////////

		if(validateStartQuitInput(ans)){

			//////////////////
			//Game Loop
			//////////////////
			while(!isWinnerFound && !isTie){
			
				//alternate next player's turn
				string cp = *currentPlayer;
				if(cp.compare("X") == 0){
					currentPlayer = &p2;
				}else{
					currentPlayer = &p1;
				}

				//player input
				getCurrentPlayerInput(currentPlayer, gameBoard);
				
				//show updated gameboard
				updateGameBoardDisplay(gameBoard);

				//check for winner
				isWinnerFound = checkForWinner(gameBoard, currentPlayer);

				//if there is no winner
				if(!isWinnerFound){
					//check for a tie, will return true if all spaces are filled
					isTie = checkForTie(gameBoard);
				}
			}

			//final result
			if(isTie){
				cout << "Tie - Thanks for playing" << endl;
			}else if(isWinnerFound){
				cout << "Winner is: " << *currentPlayer <<  " - Thanks for playing" << endl;
			}

		}else{

			//display quit message
			cout << "Game is Quitting" << endl;
			
		}

		//end the app
		return 0;
	}

	//############################
	//////////////////////////////
	// Function Implementations //
	//////////////////////////////
	//############################

	bool validateStartQuitInput(string a){

		//cout << "your answer is " << ans << endl;
		if(a.compare("a") == 0 || a.compare("A") == 0) {
			//cout << "equals\n" << endl;
			return true;
		}else{
			return false;
		}
	}

	void getCurrentPlayerInput(string* curPlayer, string gb[][3]){

		

		//check if AI or real player
		string playerValue = *curPlayer;
		if(playerValue.compare("X") == 0){

			cout << "Player " << *curPlayer << " Turn. Choose Coordinates Now." << endl;

			//take user inputs
			string x, y;
			cin >> x >> y;

			//check if inputs are valid
			if(isUserSelectionValid(x,y)){
				
				//convert string to int
				int x_int = atoi(x.c_str());
				int y_int = atoi(y.c_str());

				//put the user's choice on the gameboard grid
				gb[x_int][y_int] = *curPlayer;

			}else{
				//invalid user inputs - computers turn
				cout << "Invalid inputs!! Your turn is skipped." << endl;
			}

		}else{
			//let AI pick
			cout << "AI's turn. AI is thinking..." << endl;

			//pass the gameboard and the ai into a separate method for organization
			aiSmartSelect(curPlayer, gb);
			//pool the possible selections available

			
			//apply the selection -- turn this off when finalize, this is just a tester
			gb[2][1] = *curPlayer;
			gb[2][2] = *curPlayer;
		}

	}

	//it will check the entire gameboard and scan row by row and col by col and diagonal by diagonal
	//for to know how the ai should proceed
	//example of rows:
	//   | X |   | = row [  ,X,  ]
	// O |   | X | = row [ O, ,X ]
	// O | X | O | = row [ O,X,O ]
	//
	// each row is scan to see if the ai/currentplayer is in it or not
	// the same procedure will be done for cols and for diagnols
	void aiSmartSelect(string* curPlayer, string gb[][3]){
		
		string rowArr[3];
		string colArr[3];
		string diaArr[3];

		std::map<string, int> strMap;	//if you get a lot of warnsing using map, turn off the warning with #pragma

		//scan rows
		for(int i=0; i<3; i++){
			for(int k=0; k<3; k++){

				string t = gb[i][k];
				rowArr[k] = t;

			}

			if(scanArrIfCanWin(rowArr, curPlayer)){
				//collect w rows by copying

				
			}
		}

	}

	//The array coming into here should always have a size of 3, no less no more

	bool scanArrIfCanWin(string strArr[], string* curPlayer){

		//tracks how many times the current player has already marked in the array
		int playerMarkedSlotcounter = 0;
		//tracks empty spaces counted in array
		int availableSlotCounter = 0;

		for(int i=0; i<3; i++){

			if(strArr[i].compare(*curPlayer) == 0){
				playerMarkedSlotcounter++;
			}else if(strArr[i].compare(" ") == 0){
				availableSlotCounter++;
			}
		}

		//means that 2 marks of the player are made and there is an empty slot for the current player to make and take the win
		if(playerMarkedSlotcounter == 2 && availableSlotCounter == 1){
			return true;
		}
		return false;
	}

	void updateGameBoardDisplay(string a[][3]){

		for(int row=0; row<3; row++){

			for(int col=0; col<3; col++){

				cout << a[row][col] << " : ";
			}
			
			cout << endl;
		}
	}

	bool isUserSelectionValid(string x, string y){

		//validate x is digit
		for(int i=0; i<x.length(); i++){
			if(!isdigit( x[i] )){
				return false;
			}
		}

		//validate y is digit
		for(int j=0; j<y.length(); j++){
			if(!isdigit( y[j] )){
				return false;
			}
		}

		//convert string to int for range validation
		int x_val = atoi(x.c_str());
		int y_val = atoi(y.c_str());

		//validate x y are in range
		if(x_val >= 3 || y_val >= 3){
			return false;
		}
		
		//if it gets to this point, this method will return true
		//meaning everything was validated and passed
		return true;
		
	}

	// gb = gameboard
	bool checkForWinner(string gb[][3], string* currentPlayer){
		
		//string cp = currentPlayer;
		//1st row
		if(		gb[0][0].compare(*currentPlayer) == 0 
			&&	gb[0][1].compare(*currentPlayer) == 0  
			&&	gb[0][2].compare(*currentPlayer) == 0

			|| 
			//2nd row
				gb[1][0].compare(*currentPlayer) == 0 
			&&	gb[1][1].compare(*currentPlayer) == 0  
			&&	gb[1][2].compare(*currentPlayer) == 0
			
			|| 
			//3rd row
				gb[2][0].compare(*currentPlayer) == 0 
			&&	gb[2][1].compare(*currentPlayer) == 0  
			&&	gb[2][2].compare(*currentPlayer) == 0
			
			|| 
			//1st col
				gb[0][0].compare(*currentPlayer) == 0 
			&&	gb[1][0].compare(*currentPlayer) == 0  
			&&	gb[2][0].compare(*currentPlayer) == 0
			
			|| 
			//2nd col
				gb[0][1].compare(*currentPlayer) == 0 
			&&	gb[1][1].compare(*currentPlayer) == 0  
			&&	gb[2][1].compare(*currentPlayer) == 0
			
			|| 
			//1st col
				gb[0][2].compare(*currentPlayer) == 0 
			&&	gb[1][2].compare(*currentPlayer) == 0  
			&&	gb[2][2].compare(*currentPlayer) == 0
			
			|| 
			//1st diaganol
				gb[0][0].compare(*currentPlayer) == 0 
			&&	gb[1][1].compare(*currentPlayer) == 0  
			&&	gb[2][2].compare(*currentPlayer) == 0
			
			|| 
			//2nd diagnol
				gb[0][2].compare(*currentPlayer) == 0 
			&&	gb[1][1].compare(*currentPlayer) == 0  
			&&	gb[2][0].compare(*currentPlayer) == 0) 
		{
			return true;
		};



		return false;
	}

	bool checkForTie(string gb[][3]){

		//check all spaces are filled
		for(int row=0; row<3; row++){

			for(int col=0; col<3; col++){

				//return false if any one empty space is detected
				if( gb[row][col].compare(" ") == 0){
					return false;
				}
			}
		}

		//no empty space detected, return true for a tie detection
		return true;
	}
	
*/

	
}
