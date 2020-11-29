
/*
 This class contains methods for sorting the user's list from 
 highest to lowest using the recursive quick sort method. It also
 contains methods for printing out the array 
*/
import java.util.*;

public class Back {

	private int[] numbers; // user's list of students

	// constructor for setting the user's list
	public Back(ArrayList<Integer> a) {
		numbers = new int[a.size()];
		// transfer elements from array list to array
		for (int i = 0; i < a.size(); i++) {
			numbers[i] = a.get(i);
		}
	}

	// parsing the string list into an array list
	public static ArrayList<Integer> parse(String list) {
		ArrayList<Integer> nums = new ArrayList<Integer>();
		String number = "";

		// looping through each character in the string
		for (int i = 0; i < list.length(); i++) {
			if (list.charAt(i) != ',') { // if the character is not a comma
				number += "" + list.charAt(i); // add it to the number string
			} else if (list.charAt(i) != ' ') { // if the character is a space
				nums.add(Integer.parseInt(number.trim())); // add the number to the list
				number = ""; // reset the number string
			}
		}

		nums.add(Integer.parseInt(number.trim())); // add the last number to the array
		return nums;
	}

	// printing the user's list of numbers
	public String printArray() {
		String output = numbers[0] + ""; // first element
		// looping through each element and printing each one
		for (int i = 1; i < numbers.length; i++) {
			output += ", " + numbers[i];
		}
		return output;
	}

	// method for sorting the array recursively using quick sort
	public void quicksort(int left, int right, int option) {
		if (left >= right) { // if the two pointers overlap, then quit
			return;
		}
		int pivot; // initializing the pivot
		// setting the pivot value depending on the user's choice
		if (option == 1) { // pivot as middle value
			pivot = numbers[(int) ((left + right) / 2)];
		} else if (option == 2) { // pivot as first value
			pivot = numbers[left];
		} else { // pivot as random number between two pointers
			Random generator = new Random();
			pivot = numbers[generator.nextInt((right - left) + 1) + left];
		}

		// setting the partitioning index
		int index = partition(left, right, pivot, option);
		quicksort(left, index - 1, option); // call quick sort again for first half
		quicksort(index, right, option); // call quick sort again for second half
	}

	// method for getting the partitioning index
	public int partition(int left, int right, int pivot, int option) {
		while (left <= right) { // while the left pointer is less than right pointer
			// move left pointer right while it's greater than pointer
			while (numbers[left] > pivot) {
				left++;
			}
			// move right pointer left while it's less than pointer
			while (numbers[right] < pivot) {
				right--;
			}
			if (left <= right) { // if left pointer is still left of right
				// swapping the two numbers at the pointers
				int temp = numbers[left];
				numbers[left] = numbers[right];
				numbers[right] = temp;
				// move the two pointers inward
				left++;
				right--;
			}
		}
		return left;
	}

}
