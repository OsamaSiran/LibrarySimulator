// Osama Ibrahim Mohammed Siran 446100768 اسامة ابراهيم محمد سعران
// https://github.com/OsamaSiran/LibrarySimulator

public class Member {
    private int id;
    private String name;
    private int borrowedCount;
    private int numViewBorrowed;
    private int numBorrows;
    private int numReturns;
    private double sessionFees;

    public static double TotalRevenue;
    public static int TotalViewBorrowed;
    public static int TotalBorrows;
    public static int TotalReturns;

    public Member(int id, String name, int borrowedCount) {
        this.id = id;
        this.name = name;
        this.borrowedCount = borrowedCount;
        
        // Make them zero. So they can be incremented.
        this.numViewBorrowed = 0;
        this.numBorrows = 0;
        this.numReturns = 0;
        this.sessionFees = 0.0;
    }
    private boolean canBorrow(){
        if (this.borrowedCount < 5) {
            return true;
        } else {
        return false;
        }
    }
    private boolean canReturn(){
        if (this.borrowedCount > 0) {
            return true;
        } else {
        return false;
        }
    }
    public void viewBorrowedCount(){
        this.numViewBorrowed++;
        Member.TotalViewBorrowed++;
        System.out.println("You have " + this.borrowedCount + " books.");
    }
    public boolean borrowOne(){
        if (!canBorrow()) {
            System.out.println("You can not borrow more the 5 books.");
            return false; 
        }
        else {
            this.borrowedCount++;
            this.numBorrows++;
            this.sessionFees += 0.50;
            Member.TotalBorrows++;
            Member.TotalRevenue += 0.50;
            System.out.printf("You borrowed a book. The fee will be %.2f thank you. \n", 0.50);
            return true; 
        }
    }
    public boolean returnOne(){ 
        if (!canReturn()) {
            System.out.println("You do not have any books to return.");
            return false; 
        }
        else {
            this.borrowedCount--;
            this.numReturns++;
            Member.TotalReturns++;
            
            System.out.println("You returned a book.");
            return true;
        }
    }
    public void displayStatistics(){
        System.out.println("Statistics for " + this.name);
        System.out.println("You borrowed: " + this.numBorrows);
        System.out.println("You returned: " + this.numReturns);
        System.out.println("You View borrowed count: " + this.numViewBorrowed);
        System.out.printf("Total fees incurred during this session is: %.2f %n", this.sessionFees); 
    }
    public void reset(){
        this.numViewBorrowed = 0;
        this.numBorrows = 0;
        this.numReturns = 0;
        this.sessionFees = 0.0;
    }

    // getter
    public String getName() {
        return this.name;
    }
    public int getId() {
        return this.id;
    }
    public static double getTotalRevenue() {
        return TotalRevenue;
    }
    public static int getTotalBorrows() {
        return TotalBorrows;
    }
    public static int getTotalReturns() {
        return TotalReturns;
    }
}
