package tugaspbo;

import java.util.ArrayList;
import java.util.Scanner;

public class Restaurant {
    private String name;
    private ArrayList<String> menus;
    private ArrayList<Double> price;
    private static Scanner scanner = new Scanner(System.in);

    public Restaurant() {
        this.name = name;
        this.menus = menus;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<String> getMenus() {
        return menus;
    }

    public void setMenus(ArrayList<String> menus) {
        this.menus = menus;
    }

    public ArrayList<Double> getPrice() {
        return price;
    }

    public void setPrice(ArrayList<Double> price) {
        this.price = price;
    }
//fungsi dari admin
    public static void addRestaurant(ArrayList<Restaurant> restaurants) {
        System.out.print("Masukkan nama Tempat Makan : ");
        String name = scanner.nextLine();

        Restaurant newRestaurant = new Restaurant();
        newRestaurant.setName(name);

        ArrayList<String> menus = new ArrayList<>();
        ArrayList<Double> prices = new ArrayList<>();

        boolean continueAddingMenu = true;
        while (continueAddingMenu) {
            System.out.print("Masukkan menu : ");
            String menu = scanner.nextLine();
            menus.add(menu);

            System.out.print("Harga : ");
            Double price = scanner.nextDouble();
            prices.add(price);

            scanner.nextLine();

            System.out.print("Tambah menu baru? (y/n): ");
            String answer = scanner.nextLine();
            continueAddingMenu = answer.equalsIgnoreCase("y");
        }

        newRestaurant.setMenus(menus);
        newRestaurant.setPrice(prices);

        restaurants.add(newRestaurant);
        System.out.println("Berhasil menambah Tempat Makan.");
    }

    public static void deleteRestaurant(ArrayList<Restaurant> restaurants) {
        System.out.print("Masukkan nama Tempat Makan yang ingin dihapus : ");
        String nameToDelete = scanner.nextLine();

        for (int i = 0; i < restaurants.size(); i++) {
            Restaurant restaurant = restaurants.get(i);
            if (restaurant.getName().equalsIgnoreCase(nameToDelete)) {
                restaurants.remove(i);
                System.out.println("Tempat Makan berhasil dihapus.");
                return;
            }
        }

        System.out.println("Tempat Makan tidak ditemukan.");
    }

    public static void showRestaurants(ArrayList<Restaurant> restaurants) {
        System.out.println("Daftar Tempat Makan :");

        for (Restaurant restaurant : restaurants) {
            System.out.println("- " + restaurant.getName());
        }
    }
    //fungsi customer
    public void showMenu() {
        System.out.println("Daftar menu di " + this.getName() + ":");

        for (int i = 0; i < menus.size(); i++) {
            System.out.println("- " + menus.get(i) + " : Rp " + price.get(i));
        }
    }
    public double calculateTotal(ArrayList<String> selectedMenus) {
        double total = 0;

        for (String selectedMenu : selectedMenus) {
            int index = menus.indexOf(selectedMenu);
            if (index != -1) {
                total += price.get(index);
            }
        }

        return total;
    }
    public boolean hasMenu(String menuName) {
        return menus.contains(menuName);
    }

}

