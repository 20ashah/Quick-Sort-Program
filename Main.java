
/*
 Arjun Shah
 E Block
 4/8/19
 Program Description: 
 This program codes the quick sort algorithm to sort a set of data
 from highest to lowest. The user in addition gets to choose 
 what the pivot point will be when performing quick sort. After this, 
 the original and sorted lists are printed. The max number of numbers
 the user can enter is 10. 
*/
import BreezySwing.*;
import javax.swing.*;
import java.util.*;

public class Main extends GBFrame {

	// GUI components that will be put on the window
	private JLabel listL, optionL, sortedL, unsortedL;
	private JTextField listF, sortedF, unsortedF;
	private IntegerField optionF;
	private JButton sortB, quit;

	// default constructor for putting the GUI components onto the screen
	public Main() {
		listL = addLabel("List of Numbers", 1, 1, 1, 1);
		listF = addTextField("", 1, 2, 1, 1);
		optionL = addLabel("Middle ( 1 ) , First ( 2 ) , Random ( 3 )", 2, 1, 1, 1);
		optionF = addIntegerField(0, 2, 2, 1, 1);
		optionF.setText("");
		sortB = addButton("Sort", 3, 1, 1, 1);
		sortedL = addLabel("Sorted", 4, 1, 1, 1);
		sortedF = addTextField("", 4, 2, 1, 1);
		unsortedL = addLabel("Unsorted", 5, 1, 1, 1);
		unsortedF = addTextField("", 5, 2, 1, 1);
		quit = addButton("Quit", 6, 1, 1, 1);
	}

	// method for performing actions when buttons are clicked
	public void buttonClicked(JButton button) {
		if (button == sortB) { // if user clicks the sort button
			try { // error checking user inputs
				ArrayList<Integer> nums = Back.parse(listF.getText()); // parsing user's list
				// error checking number of numbers user enters
				if (nums.size() > 10) { // throw error is number > 10
					throw new Exception();
				}
				// error checking the option the user enters
				if (optionF.getNumber() <= 0 || optionF.getNumber() >= 4) {
					throw new Exception();
				}
				Back back = new Back(nums); // convert from array list to array
				unsortedF.setText(back.printArray() + ""); // print unsorted list
				back.quicksort(0, nums.size() - 1, optionF.getNumber()); // sort list
				sortedF.setText(back.printArray() + ""); // print sorted list
			} catch (Exception e) {
				messageBox("Invalid Input!");
			}
		} else { // if user clicks the quit button
			System.exit(0);
		}
	}

	// main method
	public static void main(String[] args) {
		Main window = new Main(); // creating GUI window
		window.setSize(600, 250);
		window.setVisible(true);
	}

}
