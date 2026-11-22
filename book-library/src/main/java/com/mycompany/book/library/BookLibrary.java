package com.mycompany.book.library;
import java.util.Scanner;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class BookLibrary {

    static Scanner input = new Scanner(System.in);

    // Book catalog arrays
    static String[] titles = new String[100];
    static String[] authors = new String[100];
    static String[] urls = new String[100];
    static int bookCount = 0;

    // Reading list arrays
    static String[] readingTitles = new String[20];
    static String[] readingAuthors = new String[20];
    static String[] readingUrls = new String[20];
    static int readingCount = 0;

    public static void main(String[] args) {

        loadBooks();

        int choice = -1;

        do {
            System.out.println("\n===== GUTENBERG BOOK EXPLORER =====");
            System.out.println("1. Explore Books");
            System.out.println("2. Search by Title");
            System.out.println("3. Search by Author");
            System.out.println("4. Add Book to Reading List");
            System.out.println("5. View Reading List");
            System.out.println("6. Remove Book");
            System.out.println("7. Display Book Details");
            System.out.println("0. Exit");

            System.out.print("Enter your choice: ");

            try {
                choice = Integer.parseInt(input.nextLine());

                switch (choice) {

                    case 1:
                        exploreBooks();
                        break;

                    case 2:
                        System.out.print("Enter book title: ");
                        searchBook(input.nextLine());
                        break;

                    case 3:
                        System.out.print("Enter author name: ");
                        searchBook(input.nextLine(), true);
                        break;

                    case 4:
                        addBook();
                        break;

                    case 5:
                        viewReadingList();
                        break;

                    case 6:
                        removeBook();
                        break;

                    case 7:
                        displayBookDetails();
                        break;

                    case 0:
                        System.out.println("Goodbye!");
                        break;

                    default:
                        System.out.println("Invalid choice.");
                }

            } catch (NumberFormatException e) {
                System.out.println("Please enter a number.");
            }

        } while (choice != 0);

        input.close();
    }

    // Load books from Project Gutenberg
    static void loadBooks() {

        try {
            Document doc = Jsoup.connect(
                    "https://www.gutenberg.org/browse/scores/top")
                    .userAgent("Mozilla/5.0")
                    .timeout(15000)
                    .get();

            Elements bookLinks = doc.select("a[href^=/ebooks/]");

            for (Element link : bookLinks) {

                if (bookCount >= 20) {
                    break;
                }

                String title = link.text().trim();
                String url = link.absUrl("href");

                // Avoid duplicate books
                boolean duplicate = false;

                for (int i = 0; i < bookCount; i++) {
                    if (urls[i].equals(url)) {
                        duplicate = true;
                        break;
                    }
                }

                if (duplicate || title.isEmpty()) {
                    continue;
                }

                String author = getAuthor(url);

                titles[bookCount] = title;
                authors[bookCount] = author;
                urls[bookCount] = url;

                bookCount++;
            }

            System.out.println(bookCount + " books loaded.");

        } catch (Exception e) {
            System.out.println("Connection error: " + e.getMessage());
        }
    }

    // Get author from book details page
    static String getAuthor(String bookUrl) {

        try {
            Document doc = Jsoup.connect(bookUrl)
                    .userAgent("Mozilla/5.0")
                    .timeout(15000)
                    .get();

            Elements rows = doc.select("table.bibrec tr");

            for (Element row : rows) {

                Elements cells = row.select("th, td");

                if (cells.size() >= 2) {

                    String label = cells.get(0).text().trim();

                    if (label.equalsIgnoreCase("Author")) {
                        return cells.get(1).text().trim();
                    }
                }
            }

        } catch (Exception e) {
            // Return fallback if author cannot be retrieved
        }

        return "Unknown";
    }

    // Display all books
    static void exploreBooks() {

        if (bookCount == 0) {
            System.out.println("No books available.");
            return;
        }

        for (int i = 0; i < bookCount; i++) {

            System.out.println("\nBook " + (i + 1));
            System.out.println("Title: " + titles[i]);
            System.out.println("Author: " + authors[i]);
            System.out.println("URL: " + urls[i]);
            System.out.println("-------------------------");
        }
    }

    // Search by title
    static void searchBook(String title) {

        boolean found = false;

        for (int i = 0; i < bookCount; i++) {

            if (titles[i].toLowerCase()
                    .contains(title.toLowerCase())) {

                System.out.println("\nBook found!");
                System.out.println("Title: " + titles[i]);
                System.out.println("Author: " + authors[i]);
                System.out.println("URL: " + urls[i]);

                found = true;
            }
        }

        if (!found) {
            System.out.println("Book not found.");
        }
    }

    // Overloaded method: Search by author or title
    static void searchBook(String keyword, boolean searchByAuthor) {

        boolean found = false;

        for (int i = 0; i < bookCount; i++) {

            if (searchByAuthor &&
                    authors[i].toLowerCase()
                    .contains(keyword.toLowerCase())) {

                System.out.println("\nBook found!");
                System.out.println("Title: " + titles[i]);
                System.out.println("Author: " + authors[i]);
                System.out.println("URL: " + urls[i]);

                found = true;

            } else if (!searchByAuthor &&
                    titles[i].toLowerCase()
                    .contains(keyword.toLowerCase())) {

                System.out.println("\nBook found!");
                System.out.println("Title: " + titles[i]);
                System.out.println("Author: " + authors[i]);
                System.out.println("URL: " + urls[i]);

                found = true;
            }
        }

        if (!found) {
            System.out.println("No results found.");
        }
    }

    // Add book to reading list
    static void addBook() {

        if (readingCount >= readingTitles.length) {
            System.out.println("Reading list is full.");
            return;
        }

        if (bookCount == 0) {
            System.out.println("No books available.");
            return;
        }

        exploreBooks();

        System.out.print("Enter book number to add: ");

        try {
            int number = Integer.parseInt(input.nextLine());

            if (number < 1 || number > bookCount) {
                System.out.println("Invalid book number.");
                return;
            }

            int index = number - 1;

            // Check for duplicate
            for (int i = 0; i < readingCount; i++) {

                if (readingUrls[i].equals(urls[index])) {
                    System.out.println("Book already in reading list.");
                    return;
                }
            }

            readingTitles[readingCount] = titles[index];
            readingAuthors[readingCount] = authors[index];
            readingUrls[readingCount] = urls[index];

            readingCount++;

            System.out.println("Book added successfully!");

        } catch (NumberFormatException e) {
            System.out.println("Please enter a valid number.");
        }
    }

    // View reading list
    static void viewReadingList() {

        if (readingCount == 0) {
            System.out.println("Your reading list is empty.");
            return;
        }

        System.out.println("\n===== MY READING LIST =====");

        for (int i = 0; i < readingCount; i++) {

            System.out.println("\nBook " + (i + 1));
            System.out.println("Title: " + readingTitles[i]);
            System.out.println("Author: " + readingAuthors[i]);
            System.out.println("URL: " + readingUrls[i]);
        }
    }

    // Remove book from reading list
    static void removeBook() {

        if (readingCount == 0) {
            System.out.println("Your reading list is empty.");
            return;
        }

        viewReadingList();

        System.out.print("Enter book number to remove: ");

        try {
            int number = Integer.parseInt(input.nextLine());

            if (number < 1 || number > readingCount) {
                System.out.println("Invalid book number.");
                return;
            }

            int index = number - 1;

            // Shift books to fill the empty position
            for (int i = index; i < readingCount - 1; i++) {

                readingTitles[i] = readingTitles[i + 1];
                readingAuthors[i] = readingAuthors[i + 1];
                readingUrls[i] = readingUrls[i + 1];
            }

            readingCount--;

            System.out.println("Book removed successfully!");

        } catch (NumberFormatException e) {
            System.out.println("Please enter a valid number.");
        }
    }

    // Display book details
    static void displayBookDetails() {

        if (bookCount == 0) {
            System.out.println("No books available.");
            return;
        }

        exploreBooks();

        System.out.print("Enter book number: ");

        try {
            int number = Integer.parseInt(input.nextLine());

            if (number < 1 || number > bookCount) {
                System.out.println("Invalid book number.");
                return;
            }

            int index = number - 1;

            System.out.println("\n===== BOOK DETAILS =====");
            System.out.println("Title: " + titles[index]);
            System.out.println("Author: " + authors[index]);
            System.out.println("Gutenberg URL: " + urls[index]);

        } catch (NumberFormatException e) {
            System.out.println("Please enter a valid number.");
        }
    }
}