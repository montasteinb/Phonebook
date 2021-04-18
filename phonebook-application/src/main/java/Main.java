import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    Phonebook phonebook = new Phonebook();
    Scanner scanner = new Scanner(System.in);
    User user;

    public static void main(String[] args) {
        Main main = new Main();
        main.showMenu();
    }
    void showMenu() {
        String userInput = "";
        do {
            System.out.println("Welcome to the Phonebook "
                    + "\n1. Add User \t\t 4. View all contacts"
                    + "\n2. Remove User \t\t 5. Update contact"
                    + "\n3. Search Contact \t\t"
                    + "\n Enter Quit to end program"
            );

            System.out.print("Please choose one of the options: ");
            userInput = scanner.nextLine();

            switch (userInput) {
                case "quit":
                    System.out.println("Exiting application...");
                    break;
                case "1":
                    addUser();
                    break;
                case "2":
                    deleteUser();
                    break;
                case "3":
                    searchUser();
                    break;
                case "4":
                    viewAllUsers();
                    break;
                case "5":
                    updateUser();
                    break;
                default:
                    break;


            }
            this.showMenu();
        }
        while (!userInput.equalsIgnoreCase("Quit"));

    }

    void addUser(){
        System.out.println("\n Add user");

        System.out.print("Enter Name: ");
        String name = scanner.nextLine();

        System.out.print("Enter Phone Number: ");
        int phoneNumber = Integer.parseInt(scanner.nextLine());

        System.out.print("Enter Email: ");
        String email = scanner.nextLine();

        User user = new User(name, phoneNumber, email);
        System.out.println(phonebook.addUser(user));

    }

    void deleteUser(){
        System.out.println("Delete User\n");
        System.out.println("Enter User Name: ");

        String userName = scanner.nextLine();
        String message = phonebook.removeUser(userName);
        System.out.println(message);
    }

    void searchUser() {
        System.out.println("Search User\n");
        System.out.println("Please enter what you're searching for: ");
        String userName = scanner.nextLine();

        if(userName.contains(userName)){
            System.out.println("Found user " + userName);
        }else {
            System.out.println(userName + " not found");
        }

    }

    void viewAllUsers(){
        ArrayList<User> allUsers = phonebook.getAllUsers();

        System.out.println("\nAll available users\n");
        System.out.println("User Name\t Phone Number\t Email\t");

        for (User user: allUsers){
            System.out.println(user.name + " \t" + user.phoneNumber + " \t" + user.email);
        }
    }

    void updateUser(){
        this.viewAllUsers();

        System.out.println("Update User");

        System.out.println("Enter User name: ");
        user.name = scanner.nextLine();

        System.out.println("Enter new name for user: ");
        user.name = scanner.nextLine();

        System.out.println("Enter new phone number: ");
        user.phoneNumber = scanner.nextInt();

        String response = phonebook.updateUser(user.phoneNumber, user);
        System.out.println(response);

    }
}
