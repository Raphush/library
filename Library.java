import java.util.Scanner;

public  class Library {
    public static Book[] bookShelf = new Book[10];

    public static void main(String[] args) {
        bookShelf[0] = new Book("Macbeth", 10, 23);
        showMenu();
    }

    public static void showMenu() {
        System.out.println("Xos gelmisiniz, menu-dan bir secim edin");
        System.out.println("1. Bu kitablara bax");
        System.out.println("2. Kitab elave et");
        System.out.println("3. Kitab axdar");

        Scanner scanner = new Scanner(System.in);
        int secim = scanner.nextInt();

        switch (secim) {
            case 1:
                listBooks();
                break;
            case 2:
                addBook();
                break;
            case 3:
                findBook();
                break;
            default:
                System.out.println("Duzgun secim edin : ");
                break;
        }
    }

    public static void listBooks() {
        for (Book book : bookShelf) {
            if (book != null) {
                System.out.println("Ad: " + book.name + " Qiymet: " + book.price + " Sayi: " + book.count);
            }
        }
    }

    public static void addBook() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Kitabin adini daxil edin: ");
        String bookName = scanner.nextLine();

        System.out.print("Kitabin qiymetini daxil edin: ");
        int price = scanner.nextInt();

        System.out.print("Kitabin sayini daxil edin: ");
        int count = scanner.nextInt();

        Book book = new Book(bookName, price, count);
        boolean isShelfFull = true;

        for (int i = 0; i < bookShelf.length; i++) {
            if (bookShelf[i] == null) {
                isShelfFull = false;
                bookShelf[i] = book;
                break;
            }
        }

        if (isShelfFull) {
            Book[] newBookShelf = new Book[bookShelf.length * 2];
            for (int i = 0; i < bookShelf.length; i++) {
                newBookShelf[i] = bookShelf[i];
            }
            bookShelf = newBookShelf;
            bookShelf[bookShelf.length / 2] = book;
        }

        System.out.println("Yeni kitab elave etmek istiyirsiniz? Yes or No: ");
        scanner.nextLine(); // Consume newline character
        String answer = scanner.nextLine();
        if (answer.equalsIgnoreCase("yes")) {
            addBook();
        } else {
            showMenu();
        }
    }

    public static void findBook() {
        System.out.println("Kitab adini qeyd edin: ");
        Scanner scanner = new Scanner(System.in);
        String searchedBook = scanner.nextLine();
        boolean found = false;
        for (Book book : bookShelf) {
            if (book != null && book.name.equalsIgnoreCase(searchedBook)) {
                System.out.println("Qiymet: " + book.price + " Sayi: " + book.count);
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println("Kitab tapilmadi.");
        }
    }
}

class Book {
    public String name;
    public int price;
    public int count;

    public Book(String name, int price, int count) {
        this.name = name;
        this.price = price;
        this.count = count;
    }
}
