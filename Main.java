package tugas2;

import java.util.ArrayList;
import java.util.List;

/**
 * Mewakili Taksi dengan nama pengemudi, model mobil, dan status ketersediaan.
 */
class Taxi {
    private String driverName;
    private String carModel;
    private boolean isAvailable;

    /**
     * Membuat Taksi dengan nama pengemudi dan model mobil yang ditentukan.
     *
     * @param driverName nama pengemudinya
     * @param carModel   model mobilnya
     */
    public Taxi(String driverName, String carModel) {
        this.driverName = driverName;
        this.carModel = carModel;
        this.isAvailable = true;
    }

    /**
     * Memeriksa apakah taksi tersedia.
     *
     * @return benar jika taksi tersedia, salah jika sebaliknya
     */
    public boolean isAvailable() {
        return isAvailable;
    }

    /**
     * Pesan taksi, tandai sebagai tidak tersedia.
     */
    public void book() {
        isAvailable = false;
    }

    /**
     * Menyelesaikan perjalanan, menandai taksi tersedia.
     */
    public void completeRide() {
        isAvailable = true;
    }

    /**
     * Mengembalikan representasi string taksi.
     *
     * @return string yang berisi nama pengemudi dan model mobil
     */
    @Override
    public String toString() {
        return driverName + " - " + carModel;
    }
}

/**
 * Mengelola koleksi Taksi dan menangani permintaan dan perjalanan taksi.
 */
class TaxiService {
    private List<Taxi> taxis;

    /**
     * Membangun TaxiService dan menginisialisasinya dengan daftar taksi.
     */
    public TaxiService() {
        taxis = new ArrayList<>();
        taxis.add(new Taxi("John", "Toyota"));
        taxis.add(new Taxi("Doe", "Honda"));
    }

    /**
     * Menemukan taksi yang tersedia.
     *
     * @return Taksi yang tersedia, atau batal jika tidak ada taksi yang tersedia
     */
    public Taxi findAvailableTaxi() {
        for (Taxi taxi : taxis) {
            if (taxi.isAvailable()) {
                return taxi;
            }
        }
        return null;
    }

    /**
     * Meminta taksi dan memesannya jika tersedia.
     */
    public void requestTaxi() {
        Taxi taxi = findAvailableTaxi();
        if (taxi != null) {
            System.out.println("Taxi booked: " + taxi);
            taxi.book();
        } else {
            System.out.println("No taxis available.");
        }
    }

    /**
     * Menyelesaikan perjalanan untuk taksi yang dipesan pertama kali ditemukan.
     */
    public void completeRide() {
        for (Taxi taxi : taxis) {
            if (!taxi.isAvailable()) {
                System.out.println("Ride completed: " + taxi);
                taxi.completeRide();
                return;
            }
        }
        System.out.println("No rides to complete.");
    }
}

/**
 * Kelas utama untuk menjalankan aplikasi TaxiService.
 */
public class Main {
    /**
     * Titik masuk aplikasi.
     *
     * @param args cargumen baris perintah (tidak digunakan)
     */
    public static void main(String[] args) {
        TaxiService taxiService = new TaxiService();
        taxiService.requestTaxi();
        taxiService.completeRide();
    }
}
