package tugaspbo;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    static ArrayList<Restaurant> restaurants = new ArrayList<>();
    public Main() {
    }

    public static void main(String[] args) {
        int check = 2;
        Scanner scanner = new Scanner(System.in);
        Login user1 = new Login();

        do {
            System.out.println("Ayo Login !");
            System.out.println("++++++LOGIN++++++");
            System.out.print("input username : ");
            String user = scanner.nextLine();
            System.out.print("input password : ");
            String password = scanner.nextLine();
            System.out.println("++++++++++++++++++++");
            if ((!user.equals(user1.getUsername_user()) || !password.equals(user1.getPassword_user())) && (!user.equals(user1.getUsername_admin()) || !password.equals(user1.getPassword_admin()))) {
                System.out.println("Username atau Password salah");
            } else {
                check = 0;
                if (user.equals(user1.getUsername_user())) {
                    System.out.println("Sambutan hangat untuk Anda! " + user);
                    int customerChoice = 0;
                    do {
                        System.out.println("+++++++MENU CUSTOMER+++++++");
                        System.out.println("1. Jelajahi Tempat Makan");
                        System.out.println("2. Pilihlah Tempat Makan");
                        System.out.println("3. Meninggalkan Menu");
                        System.out.println("++++++++++++++++++++");
                        System.out.print("Pemilihan opsi : ");
                        customerChoice = scanner.nextInt();
                        scanner.nextLine();

                        switch (customerChoice) {
                            case 1:
                                Restaurant.showRestaurants(restaurants);
                                break;
                            case 2:
                                // Menampilkan daftar Tempat Makan yang tersedia
                                Restaurant.showRestaurants(restaurants);

                                // Memilih restoran
                                System.out.print("Pilih Tempat Makan yang anda inginkan :");
                                String selectedRestaurant = scanner.nextLine();

                                // Mencari Tempat Makan yang dipilih di dalam list restaurants
                                Restaurant chosenRestaurant = null;
                                for (Restaurant restaurant : restaurants) {
                                    if (restaurant.getName().equalsIgnoreCase(selectedRestaurant)) {
                                        chosenRestaurant = restaurant;
                                        break;
                                    }
                                }

                                // Jika Tempat Makan ditemukan, tampilkan menu dan pilihan untuk memesan
                                if (chosenRestaurant != null) {
                                    ArrayList<String> menus = chosenRestaurant.getMenus();
                                    ArrayList<Double> prices = chosenRestaurant.getPrice();

                                    System.out.println("Menu " + chosenRestaurant.getName() + ":");
                                    for (int i = 0; i < menus.size(); i++) {
                                        System.out.println((i+1) + ". " + menus.get(i) + " - Rp " + prices.get(i));
                                    }

                                    // Memilih menu dan menambahkannya ke keranjang belanja
                                    ArrayList<String> cartMenus = new ArrayList<>();
                                    ArrayList<Double> cartPrices = new ArrayList<>();
                                    boolean continueOrdering = true;
                                    while (continueOrdering) {
                                        System.out.print("Silahkan pilih nomor menu: ");
                                        int menuNumber = scanner.nextInt();
                                        scanner.nextLine();
                                        cartMenus.add(menus.get(menuNumber-1));
                                        cartPrices.add(prices.get(menuNumber-1));

                                        System.out.print("Ingin menambah pesanan ? (y/n): ");
                                        String answer = scanner.nextLine();
                                        continueOrdering = answer.equalsIgnoreCase("y");
                                    }

                                    // Menampilkan daftar pesanan dan total harga
                                    System.out.println("Pesanan yang Anda pilih :");
                                    double totalPrice = 0;
                                    for (int i = 0; i < cartMenus.size(); i++) {
                                        System.out.println("- " + cartMenus.get(i) + " - Rp " + cartPrices.get(i));
                                        totalPrice += cartPrices.get(i);
                                    }
                                    System.out.println("Total harga: Rp " + totalPrice);
                                } else {
                                    System.out.println("Tempat Makan tidak ditemukan.");
                                }
                                break;
                            case 3:
                                System.out.println("Keluar dari menu customer.");
                                break;
                            default:
                                System.out.println("Pilihan tidak valid.");
                        }
                    } while (customerChoice != 3);
                } else if (user.equals(user1.getUsername_admin())) {
                    System.out.println("Sambutan hangat untuk admin! " + user);
                    int choice = 0;
                    do {
                        System.out.println("+++++++MENU+++++++");
                        System.out.println("1. Daftarkan Tempat Makan baru");
                        System.out.println("2. Hapus Tempat Makan dari daftar");
                        System.out.println("3. Lihat daftar Tempat Makan");
                        System.out.println("4. Keluar");
                        System.out.println("===================");
                        System.out.print("Pemilihan opsi : ");
                        choice = scanner.nextInt();
                        scanner.nextLine();

                        switch (choice) {
                            case 1:
                                Restaurant.addRestaurant(restaurants);
                                break;
                            case 2:
                                Restaurant.deleteRestaurant(restaurants);
                                break;
                            case 3:
                                Restaurant.showRestaurants(restaurants);
                                break;
                            case 4:
                                System.out.println("Keluar dari menu admin.");
                                check = 2;
                                break;
                            default:
                                System.out.println("Pilihan tidak valid.");
                        }
                    } while (choice != 4);
                }
            }
        } while(check > 1);

    }
}
