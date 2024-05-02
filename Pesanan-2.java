package tugaspbo;

import java.util.ArrayList;

public class Pesanan {
    private Restaurant restaurant;
    private ArrayList<Menu> menuPesanan = new ArrayList<>();
    private int totalHarga;

    public Pesanan(Restaurant restaurant) {
        this.restaurant = restaurant;
    }

    public Restaurant getRestaurant() {
        return restaurant;
    }

    public ArrayList<Menu> getMenuPesanan() {
        return menuPesanan;
    }

    public void setMenuPesanan(ArrayList<Menu> menuPesanan) {
        this.menuPesanan = menuPesanan;
        int total = 0;
        for (Menu menu : menuPesanan) {
            total += menu.getPrice();
        }
        totalHarga = total;
    }

    public int getTotalHarga() {
        return totalHarga;
    }

}
