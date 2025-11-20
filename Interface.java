import java.util.Scanner;

public class Interface {
    private Country myCountry;
    private Scanner scanner;

    public Interface() {
        scanner = new Scanner(System.in);
        // ساخت یک کشور پیش‌فرض
        myCountry = new Country("Spain"); 
    }

    public void start() {
        boolean running = true;
        while (running) {
            printMenu();
            int choice = scanner.nextInt();
            scanner.nextLine(); // رفع باگ خط جدید در اسکنر

            switch (choice) {
                case 1:
                    System.out.println("Data initialized.");
                    break;
                case 2:
                    addProvince();
                    break;
                case 3:
                    addMunicipality();
                    break;
                case 4:
                    addCity();
                    break;
                case 5:
                    System.out.println(myCountry.toString());
                    break;
                case 6:
                    System.out.println("Total Population: " + myCountry.calculateTotalPopulation());
                    break;
                case 0:
                    running = false;
                    System.out.println("Goodbye!");
                    break;
                default:
                    System.out.println("Invalid option.");
            }
        }
    }

    private void printMenu() {
        System.out.println("\n--- Census System Menu ---");
        System.out.println("1. Initialize Data");
        System.out.println("2. Add Province");
        System.out.println("3. Add Municipality to a Province");
        System.out.println("4. Add City to a Municipality");
        System.out.println("5. Show Country Summary");
        System.out.println("6. Show Total Population");
        System.out.println("0. Exit");
        System.out.print("Choose an option: ");
    }

    private void addProvince() {
        System.out.print("Enter Province Name: ");
        String name = scanner.nextLine();
        myCountry.addProvince(new Province(name));
        System.out.println("Province added!");
    }

    private void addMunicipality() {
        System.out.print("Enter name of the Province to add to: ");
        String pName = scanner.nextLine();
        
        Province foundProvince = null;
        for (Province p : myCountry.getProvinces()) {
            if (p.getName().equalsIgnoreCase(pName)) {
                foundProvince = p;
                break;
            }
        }

        if (foundProvince != null) {
            System.out.print("Enter new Municipality Name: ");
            String mName = scanner.nextLine();
            foundProvince.addMunicipality(new Municipality(mName));
            System.out.println("Municipality added!");
        } else {
            System.out.println("Province not found!");
        }
    }

    private void addCity() {
        System.out.print("Enter Province Name: ");
        String pName = scanner.nextLine();
        Province foundProvince = null;
        for (Province p : myCountry.getProvinces()) {
            if (p.getName().equalsIgnoreCase(pName)) {
                foundProvince = p;
                break;
            }
        }

        if (foundProvince == null) {
            System.out.println("Province not found.");
            return;
        }

        System.out.print("Enter Municipality Name: ");
        String mName = scanner.nextLine();
        Municipality foundMunicipality = null;
        for (Municipality m : foundProvince.getMunicipalities()) {
            if (m.getName().equalsIgnoreCase(mName)) {
                foundMunicipality = m;
                break;
            }
        }

        if (foundMunicipality != null) {
            System.out.print("Enter City Name: ");
            String cName = scanner.nextLine();
            System.out.print("Enter Population: ");
            int pop = scanner.nextInt();
            scanner.nextLine(); 

            foundMunicipality.addCity(new City(cName, pop));
            System.out.println("City added successfully!");
        } else {
            System.out.println("Municipality not found.");
        }
    }
}
