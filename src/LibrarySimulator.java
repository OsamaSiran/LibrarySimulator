// Osama Ibrahim Mohammed Siran 446100768 اسامة ابراهيم محمد سعران
// https://github.com/OsamaSiran/LibrarySimulator

import java.util.Scanner;
public class LibrarySimulator {
    public static void main(String[] args) {
        Scanner read = new Scanner(System.in);
        // Creating 3 members.
        Member user1 = new Member(101, "Osama", 0);
        Member user2 = new Member(102, "Mohammed", 0);
        Member user3 = new Member(103, "Abdullah", 0);

        System.out.println("Welcome, this is King Salman Central library system.");

        boolean active = true;
        // Main while loop. If the condition become false the program ends.
        while (active) {
            System.out.println("----------------------");
            System.out.println("Main menu.");
            System.out.println("What would you like to do?");
            System.out.println("Select a user account (1).");
            System.out.println("Login as Administrator (2).");
            System.out.println("Exit the program (3).");
            System.out.print("Please enter a number: ");
            int userInput = read.nextInt();
            
            // Ending the program.
            if (userInput == 3){
                System.out.println("Ending the program. Thank you.");
                active = false;
                continue;
            } 

            // This is the main switch statement. It has two cases: user interface, and login as administrator. default case displays an error message.
            switch (userInput) {
                case 1: // User selection.
                    System.out.println(user1.getId() + " " + user1.getName() + " (1)");
                    System.out.println(user2.getId() + " " + user2.getName() + " (2)");
                    System.out.println(user3.getId() + " " + user3.getName() + " (3)");
                    System.out.print("Select a user: ");
                    userInput = read.nextInt();
                    Member selectedUser;
                    switch (userInput) {
                        case 1:
                            selectedUser = user1;
                            break;
                        case 2:
                            selectedUser = user2;
                            break;
                        case 3: 
                            selectedUser = user3;
                            break;
                        default:
                            System.out.println("Error, The number you entered is not one of the users. Try again.");
                            continue;
                    }
                    // User interface. 
                    // Reseting upon session
                    selectedUser.reset();
                    boolean active2 = true;
                    // User interface while loop. If the condition becomes false it will exit to main menu.
                    while (active2) {
                        System.out.println("----------------------"); 
                        System.out.println(selectedUser.getName() + " What would you like to do?");
                        System.out.println("View borrowed books count (1).");
                        System.out.println("Borrow a book (2).");
                        System.out.println("Return a book (3).");
                        System.out.println("View session summary (4).");
                        System.out.println("Exit to main menu (5).");
                        System.out.print("Please enter a number: ");
                        userInput = read.nextInt();

                        // Exiting to main menu.
                        if (userInput == 5) {
                            active2 = false;
                            continue;
                        }

                        // This is the user interface switch statement. It has 4 cases and a default case that displays an error message. 
                        switch (userInput) {
                            case 1: // Viewing borrowed books count.
                                selectedUser.viewBorrowedCount();
                                break;
                            case 2: // Borrowing a book.
                                selectedUser.borrowOne();
                                break;
                            case 3: // Returning a book.
                                selectedUser.returnOne();
                                break;
                            case 4: // Viewing session summary.
                                selectedUser.displayStatistics();
                                break;
                            default: // Error message.
                                System.out.println("Error, The number you entered is not one of the options. Try again.");
                                break;
                        }


                    }
                    break;
                case 2: // Login as administrator.
                    boolean active3 = true;
                    // Admin menu while loop. If the condition becomes false it will exit to main menu.
                    while (active3) {
                        System.out.println("----------------------"); 
                        System.out.println("Admin what would you like to do?");
                        System.out.println("View total revenue (1).");
                        System.out.println("View the most frequent operation (2).");
                        System.out.println("Exit to main menu (3).");
                        System.out.print("Please enter a number: ");
                        userInput = read.nextInt();

                        // Exiting to main menu.
                        if (userInput == 3){
                            active3 = false;
                            continue;
                        }

                        // This is the admin switch statement with two cases and default case that displays an error message.
                        switch (userInput) {
                            case 1: // Viewing total revenue.
                                System.out.printf("Total revenue is: %.2f %n", Member.getTotalRevenue());
                                break;
                            case 2: // Viewing the most frequent operation.

                                int totalBorrowedBooks = Member.getTotalBorrows();
                                int totalReturnedBooks = Member.getTotalReturns();   
                                
                                if (totalBorrowedBooks > totalReturnedBooks){
                                    System.out.println("The most frequent operation is " + totalBorrowedBooks + " borrowed books.");
                                    break;
                                } else if (totalReturnedBooks > totalBorrowedBooks){
                                    System.out.println("The most frequent operation is " + totalReturnedBooks + " returned books.");
                                    break;
                                } else {
                                    System.out.println("Both operations are equal with " + totalBorrowedBooks + " borrowed and returned books.");
                                    break;
                                }
                            default: // Error message.
                                System.out.println("Error, The number you entered is not one of the options. Try again.");
                                break;
                        }
                    }
                    break;
                default: // Error message.
                    System.out.println("Error, The number you entered is not one of the options. Try again.");
                    break;
            }   
        }
        
    }
}