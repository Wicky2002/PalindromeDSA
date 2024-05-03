/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package palindromchecker;

import java.util.LinkedList;
import java.util.Scanner;

public class PalindromChecker {
    public static boolean isPalindrome(String str) {
        if (str == null || str.isEmpty()) {
            return true; // Empty string or null is considered a palindrome
        }

        // Preprocess the string: remove non-alphanumeric characters and convert to lowercase
        str = str.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();

        // Create a stack and a queue
        LinkedList<Character> stack = new LinkedList<>();
        LinkedList<Character> queue = new LinkedList<>();

        // Fill the stack and queue with characters from the first and second half of the processed string respectively
        int length = str.length();
        int halfLength = length / 2;
        int secondHalfStartIndex = length % 2 == 0 ? halfLength : halfLength + 1;
        for (int i = 0; i < halfLength; i++) {
            stack.push(str.charAt(i));
            queue.addLast(str.charAt(secondHalfStartIndex + i));
        }

        // Compare characters popped from the stack with characters dequeued from the queue
        while (!stack.isEmpty() && !queue.isEmpty()) {
            if (!stack.pop().equals(queue.removeFirst())) {
                return false; // If characters don't match, it's not a palindrome
            }
        }

        return true; // If all characters match, it's a palindrome
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Get user input
        System.out.print("Enter a string to check if it's a palindrome: ");
        String userInput = scanner.nextLine();

        // Check if the input string is a palindrome
        boolean isPalindrome = isPalindrome(userInput);
        if (isPalindrome) {
            System.out.println("The input string is a palindrome.");
        } else {
            System.out.println("The input string is not a palindrome.");
        }
        
        scanner.close();
    }
}
