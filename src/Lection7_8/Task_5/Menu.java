package Lection7_8.Task_5;


import java.io.File;
import java.io.IOException;
import java.nio.channels.Pipe;
import java.util.Locale;
import java.util.Scanner;

public class Menu {

    private Database<Long, Human> database;
    private String databaseName;
    private Scanner scanner = new Scanner(System.in);

    public Menu(Database<Long, Human> base) {
        this.database = base;
        databaseName = "dateBase.txt";
    }

    public Menu(String databaseName) {
        try {
            this.databaseName = databaseName;
            File dataFile = new File(databaseName);

            database = (Database<Long, Human>)Serialization.deserialize(dataFile);
        } catch (IOException | ClassNotFoundException ex) {
            System.out.println("Database is absent!");
            database = new Database();
        }
    }

    public void show() {
        int menuValue;
        while (true) {
            System.out.println("-------------------");
            System.out.println("      Menu");
            System.out.println("1. Add information about a person.");
            System.out.println("2. Delete data about a person by phone number.");
            System.out.println("3. Search data about a person by phone number.");
            System.out.println("4. Show database.");
            System.out.println("5. Exit.");
            System.out.println("-------------------");

            try{
                String value = scanner.next();
                menuValue = Integer.parseInt(value);
            } catch (Exception ex) {
                menuValue = -1;
            }

            option(menuValue);
        }
    }

    private void option(int index) {
        switch (index) {
            case 1:
                add();
                break;
            case 2:
                delete();
                break;
            case 3:
                find();
                break;
            case 4:
                System.out.println("database");
                break;
            case 5:
                saveAndExit();
                break;
            default:
                System.out.println("Incorrect data input!");
                break;
        }
    }

    private void add() {
        Human human = Human.create(scanner);
        database.add(human.getPhone(), human);
    }

    private void delete() {
        long phone = inPhoneNumber();
        if(phone == -1) {
            System.out.println("Incorrect data input!");
            return;
        }

        database.delete(phone);
    }

    private void find() {
        long phone = inPhoneNumber();
        if(phone == -1) {
            System.out.println("Incorrect data input!");
            return;
        }

        Human human = database.get(phone);
        System.out.println(human);
    }

    private void saveAndExit() {
        try{
            Serialization.serialize(database,databaseName);
        } catch (IOException ex) {
            ex.printStackTrace();
        } finally {
            System.exit(0);
        }
    }

    private long inPhoneNumber() {
        try {
            System.out.println("Enter phone: ");
            String value = scanner.next();
            long phone = Long.parseLong(value);
            return phone;
        } catch (Exception ex) {
            return -1;
        }
    }

    public String getDatabaseName() {
        return databaseName;
    }

    public void setDatabaseName(String databaseName) {
        this.databaseName = databaseName;
    }

    public Database<Long, Human> getDatabase() {
        return database;
    }

    public void setDatabase(Database<Long, Human> database) {
        this.database = database;
    }
}
