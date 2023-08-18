class MenuItem(val name: String, val price: Int)

class OrderMenu {
    //Daftar menu
    private val menuItems = listOf(
        MenuItem("Ayam Bakar", 50000),
        MenuItem("Ayam Goreng", 40000),
        MenuItem("Ayam Geprek", 40000),
        MenuItem("Kulit Ayam Crispy", 15000),
        MenuItem("Sate Usus Ayam", 5000)
    )

    //Menampilkan daftar menu
    fun displayMenu() {
        println("List Menu Makanan:")
        for ((index, item) in menuItems.withIndex()) {
            println("${index + 1}. ${item.name} = Rp. ${item.price}")
        }
    }

    //Memesan menu berdasarkan nomor menu
    fun takeOrder(): MenuItem {
        print("Pilih Menu Makanan: ")
        val menuNumber = readlnOrNull()?.toIntOrNull() ?: 0
        val selectedMenuItem = menuItems.getOrNull(menuNumber - 1)
        return selectedMenuItem ?: menuItems[0]
    }

    //Menampilkan menu yang telah dipesan
    fun displaySelectedMenu(selectedMenuItem: MenuItem) {
        val menuNumber = menuItems.indexOf(selectedMenuItem) + 1
        println("\nKamu memilih menu $menuNumber")
        println("Nama Menu: ${selectedMenuItem.name}")
        println("Harga: Rp. ${selectedMenuItem.price}")
    }

    //Melakukan pembayaran dan pengecekan jumlahnya
    fun takePayment(item: MenuItem): Boolean {
        var payment: Int
        do {
            print("Masukan Pembayaran: ")
            payment = readlnOrNull()?.toIntOrNull() ?: 0

            if (payment < item.price) {
                println("Maaf, pembayaran anda tidak mencukupi. Silahkan lakukan pembayaran kembali.")
            }
        } while (payment < item.price)

        return true
    }

    //Menampilkan metode pengiriman makanan
    fun displayDeliveryMethod() {
        println("Pilih Metode Pengiriman Makanan: ")
        println("1. Take away")
        println("2. Delivery")
    }

    //Melakukan proses pengiriman hingga pesanan selesai
    fun processDelivery() {
        when (readlnOrNull()?.toIntOrNull() ?: 0) {
            1 -> {
                print("Makananmu sedang dimasak")
                Thread.sleep(1000)
                for (i in 1..5) {
                    print(". ")
                    Thread.sleep(1000)
                }

                print("\nMakananmu sudah siap! Silakan ambil di resto ya!")
                Thread.sleep(1000)
                for (i in 1..5) {
                    print(". ")
                    Thread.sleep(1000)
                }

                print("\nPesananmu selesai!")
                for (i in 1..3) {
                    print(". ")
                    Thread.sleep(1000)
                }
            }

            2 -> {
                print("Makananmu sedang dimasak")
                Thread.sleep(1000)
                for (i in 1..5) {
                    print(". ")
                    Thread.sleep(1000)
                }

                print("\nMakananmu sudah siap! Driver segera menuju ke tempatmu!")
                Thread.sleep(1000)
                for (i in 1..5) {
                    print(". ")
                    Thread.sleep(1000)
                }

                print("\nDriver sampai! Pesananmu selesai!")
                for (i in 1..3) {
                    print(". ")
                    Thread.sleep(1000)
                }
            }

            else -> {
                println("Tidak ada Metode Pengiriman yang dipilih! Tekan 1 untuk Takeaway atau 2 untuk Delivery")
                processDelivery()
            }
        }
    }
}

fun main() {
    val orderMenu = OrderMenu()
    orderMenu.displayMenu()

    val selectedMenuItem = orderMenu.takeOrder()
    orderMenu.displaySelectedMenu(selectedMenuItem)

    if (orderMenu.takePayment(selectedMenuItem)) {
        println("\nTerima kasih, Anda berhasil memesan makanan.")
    } else {
        println("Maaf, pembayaran Anda gagal.")
        return
    }

    orderMenu.displayDeliveryMethod()
    orderMenu.processDelivery()
}