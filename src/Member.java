public class Member {
    private int id;
    private String name;
    private int borrowedCount;
    private int numViewBorrowed;
    private int numBorrows;
    private int numReturns;
    private double sessionFees;

    static double TotalRevenue;
    static int TotalViewBorrowed;
    static int TotalBorrows;
    static int TotalReturns;

    public Member(int idp, String namep, int borrowedCountp) {
        id = idp;
        name = namep;
        borrowedCount = borrowedCountp;
    }
    private boolean canBorrow(){

        return true;
    }
    private boolean canReturn(){
        
        return true;
    }
    public void viewBorrowedCount(){

    }
    public void borrowOne(){

    }
    public void returnOne(){

    }
    public void displayStatistics(){

    }
    public void reset(){
        
    }
}
