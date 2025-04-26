package com.plurasight;

import java.sql.SQLOutput;
import java.util.Scanner;

public class NeighborhoodLibrary {

    private static Book[] books = new Book[10];

    private static int numOfBooks = 5;

    public static void main(String[] args) {
        books[0] = new Book(602,"0-7526-0657-3","Forgotten Emerald", false,"");
        books[1] = new Book(295,"0-8887-3523-5","The Red Boy", false,"");
        books[2] = new Book(492,"0-8096-0482-5","Woman of Trainer", false,"");
        books[3] = new Book(691,"0-5862-6293-8","The Fire of the Kiss", false,"");
        books[4] = new Book(582,"0-4667-1993-0","Person in the Dreamer", false,"");
        books[5] = new Book(194,"0-2454-6023-3","Emerald of Illusion", true,"Gregory");
        books[6] = new Book(448,"0-5270-1732-9","The Rose's Silk", true,"Hannah");
        books[7] = new Book(381,"0-3849-1964-2","The Male of the Voyage", true,"Susie");
        books[8] = new Book(710,"0-5358-0795-3","Edge in the Husband", true,"Tom");
        books[9] = new Book(482,"0-9474-1371-5","Scent of Flames", true,"Johnny");

        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println();
            System.out.println("What wold you like to do?");
            System.out.println("1 - Show Available Books");
            System.out.println("2 - Show checked out books");
            System.out.println("3 - Exit");
            System.out.print("Your choice here: ");

            int command = scanner.nextInt();
            scanner.nextLine();

            switch (command) {
                case 1:
                    listAvailableBooks(scanner);
                    break;
                case 2:
                    unavailableBooks(scanner);
                    break;
                case 3:
                    System.out.println();
                    System.out.println("See you later");
                    return;
                default:
                    System.out.println();
                    System.out.println("Wrong choice. Try again.");
                    break;
            }

        }

    }

    public static void listAvailableBooks(Scanner scanner){
        System.out.println();
        System.out.println("Books available:");
        for (int i = 0; i < numOfBooks; i++) {
            System.out.println(books[i]);
        }
        System.out.println();
        System.out.println("Type c to check out a book");
        System.out.println("Type x to return to home screen");
        System.out.print("Your choice here: ");
        String nextstep1 = scanner.nextLine();

        if(nextstep1.equalsIgnoreCase("c")){
            System.out.println();
            System.out.println("Enter the name of the book you want to check out below: ");
            String titleToCheckOut = scanner.nextLine();

            for (Book book : books){
                if (!book.isCheckedOut() && book.getTitle().equalsIgnoreCase(titleToCheckOut)) {
                    System.out.println("What is your name?: ");
                    String person = scanner.nextLine();
                    book.setCheckedOut(true);
                    book.setCheckedOutTo(person);
                    System.out.println(person + " checked out " + titleToCheckOut + " successfully!");
                    System.out.println();
                    return;
                }
            }
        }

    }

    public static void unavailableBooks(Scanner scanner){
        System.out.println();
        System.out.println("Books not available:");
        boolean found = false;
        for (int i = 0; i < books.length; i++) {
            if (books[i].isCheckedOut()) {
                System.out.println(books[i]);
                found = true;
            }
        }
        if (!found) {
            System.out.println("No books are currently checked out.");
            return;
        }
        System.out.println();
        System.out.println("Type c to check in a book");
        System.out.println("Type x to go back to the home screen");
        System.out.print("Your choice here: ");
        String nextstep = scanner.nextLine();

            if(nextstep.equalsIgnoreCase("c")){
                System.out.println();
                System.out.println("Enter the name of the book you want to check in below ");
                String titleToCheckIn = scanner.nextLine();

                for (Book book : books){
                    if (book.isCheckedOut() && book.getTitle().equalsIgnoreCase(titleToCheckIn)) {
                        book.setCheckedOut(false);
                        book.setCheckedOutTo("");
                        System.out.println("Book checked in successfully!");
                        System.out.println();
                        return;
                    }
                }

                System.out.println("Book not found or checked out.");
        }
    }


}
