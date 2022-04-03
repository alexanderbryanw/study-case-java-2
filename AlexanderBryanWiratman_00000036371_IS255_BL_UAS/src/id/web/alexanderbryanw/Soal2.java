package id.web.alexanderbryanw;

import java.util.Scanner;

public class Soal2 {
	static Barang headBarang;

	static class Barang {
		String nama;
		int jumlah;
		int harga;
		Barang nextBarang;

		public Barang(String nama, int jumlah, int harga) {
			this.nama = nama;
			this.jumlah = jumlah;
			this.harga = harga;
		}
	}

	public int searchBarang(Barang headBarang, String key) {
		Barang current = headBarang;
		while (current != null) {
			if (current.nama.equalsIgnoreCase(key)) {
				return 1;
			}
			current = current.nextBarang;
		}
		return -1;
	}

	public void insertBarang(String nama, int jumlah, int harga) {
		Barang newBarang = new Barang(nama, jumlah, harga);

		if (headBarang == null) {
			headBarang = newBarang;
		} else {
			Barang temp = headBarang;
			while (temp.nextBarang != null) {
				temp = temp.nextBarang;
			}
			temp.nextBarang = newBarang;
		}
	}

	public int nambahBarang(Barang headBarang, String namaInput, int jumInput) {
		Barang current = headBarang;
		while (current != null) {
			if (current.nama.equalsIgnoreCase(namaInput)) {
				current.jumlah = current.jumlah + jumInput;
				return 1;
			}
			current = current.nextBarang;
		}
		return -1;
	}

	void deleteBarang(String Key) {
		Barang temp = headBarang, prev = null;
		String stringBarang = String.valueOf(temp.nama);
		String stringKey = String.valueOf(Key);
		if (temp != null && stringBarang.equalsIgnoreCase(stringKey)) {
			headBarang = temp.nextBarang;
			return;
		}
		while (temp != null && stringBarang != stringKey) {
			prev = temp;
			temp = temp.nextBarang;
			if (temp != null && stringBarang.equalsIgnoreCase(stringKey)) {
				headBarang = temp.nextBarang;
				return;
			}
			if (temp == null)
				return;
			prev.nextBarang = temp.nextBarang;
		}
	}

	static void printList() {
		Barang barang = headBarang;
		if (barang != null) {
			System.out.println("NAMA_BARANG    QTY    HARGA_BARANG    SUB_TOTAL");
			while (barang != null) {
				int subtotal = barang.jumlah * barang.harga;
				System.out.printf("%-30s%-12d%-28d%-20d\n", barang.nama, barang.jumlah, barang.harga, subtotal);
				barang = barang.nextBarang;
			}
		} else
			System.out.println("No item in Cart");
	}

	public static void main(String[] args) {
		Soal2 llist = new Soal2();
		System.out.println("========Shopping Program by Alexander B.==========");
		boolean ulang;
		while (ulang = true) {
			System.out.println("1. View List Shopping Cart");
			System.out.println("2. Insert to Shopping Cart");
			System.out.println("3. Delete from Shopping Cart");
			System.out.println("4. Exit");
			System.out.print("Choice : ");
			Scanner scan = new Scanner(System.in);
			int choice = scan.nextInt();
			if (choice == 1) {
				printList();
			} else if (choice == 2) {
				System.out.print("Masukkan nama barang : ");
				String namaInput = scan.next();
				System.out.print("Masukkan jumlah barang: ");
				int jumInput = scan.nextInt();
				if (namaInput != null && jumInput >= 0) {
					int cekBarangSama = llist.nambahBarang(headBarang, namaInput, jumInput);
					if (cekBarangSama > 0) {
						System.out.printf("Jumlah %s berhasil ditambahkan\n", namaInput);
					} else {
						System.out.print("Masukkan harga barang: ");
						int hargaInput = scan.nextInt();
						llist.insertBarang(namaInput, jumInput, hargaInput);
					}
					System.out.println("Insert Success!");
				} else
					System.out.println("Insert Failed!");
			} else if (choice == 3) {
				printList();
				System.out.print("Masukkan nama barang yang ingin dihapus : ");
				String keyDelete = scan.next();
				int cekBarang = llist.searchBarang(headBarang, keyDelete);
				if (keyDelete == null) {
					System.out.println("Delete Failed!");
				}
				if (cekBarang > 0) {
					llist.deleteBarang(keyDelete);
					System.out.println("Delete Success!");
				} else
					System.out.println("Item not Found");
			} else if (choice == 4) {
				ulang = false;
				break;
			}
			System.out.println();
		}
		System.out.println("Thankyou for using Shopping Program by Alexander B.");
	}
}
