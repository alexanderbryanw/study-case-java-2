package id.web.alexanderbryanw;

import java.util.Scanner;

public class Soal1 {
	public static void doInsertionSortAscNo(Data[] data) {
		int putaran, index, tempNo, tempJmlMotor;
		String tempNama, tempMotor;
		int panjangArr = data.length;
		for (putaran = 1; putaran < panjangArr; putaran++) {
			tempNo = data[putaran].no;
			tempNama = data[putaran].nama;
			tempMotor = data[putaran].motor;
			tempJmlMotor = data[putaran].jmlMotor;
			index = putaran - 1;
			while (index >= 0 && tempNo < data[index].no) {
				data[index + 1].no = data[index].no;
				data[index + 1].nama = data[index].nama;
				data[index + 1].motor = data[index].motor;
				data[index + 1].jmlMotor = data[index].jmlMotor;
				index = index - 1;
			}
			data[index + 1].no = tempNo;
			data[index + 1].nama = tempNama;
			data[index + 1].motor = tempMotor;
			data[index + 1].jmlMotor = tempJmlMotor;
		}
		tampilkanArray(data);
	}
	
	public static void doInsertionSortDescNo(Data[] data) {
		int putaran, index, tempNo, tempJmlMotor;
		String tempNama, tempMotor;
		int panjangArr = data.length;
		for (putaran = 1; putaran < panjangArr; putaran++) {
			tempNo = data[putaran].no;
			tempNama = data[putaran].nama;
			tempMotor = data[putaran].motor;
			tempJmlMotor = data[putaran].jmlMotor;
			index = putaran - 1;
			while (index >= 0 && tempNo > data[index].no) {
				data[index + 1].no = data[index].no;
				data[index + 1].nama = data[index].nama;
				data[index + 1].motor = data[index].motor;
				data[index + 1].jmlMotor = data[index].jmlMotor;
				index = index - 1;
			}
			data[index + 1].no = tempNo;
			data[index + 1].nama = tempNama;
			data[index + 1].motor = tempMotor;
			data[index + 1].jmlMotor = tempJmlMotor;
		}
		tampilkanArray(data);
	}


	public static void tampilkanArray(Data[] data) {
		System.out.println("======================================================");
		System.out.println("No		Nama		Motor		Jumlah");
		System.out.println("======================================================");
		for (int index = 0; index < data.length; index++) {
			System.out.printf("%-15d\t%-15s\t%-15s\t%-15d\n", data[index].no, data[index].nama, data[index].motor, data[index].jmlMotor);
		}
		System.out.println("======================================================");
	}

	public static int cariSequential(Data[] data, int keyDicari) {
		for (int i = 0; i < data.length; i++) {
			if (data[i].no == keyDicari) {
				return i;
			}
		}
		return -1;
	}

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("DATA PELANGGAN PT YAMAAP MOTOR");
		System.out.print("Jumlah data pembeli yang diinput : ");
		int length = scan.nextInt();
		Data[] data = new Data[length];
		for (int i = 0; i < data.length; i++) {
			data[i] = new Data();
		}
		System.out.println();
		for (int i = 0; i < data.length; i++) {
			System.out.printf("==========Input data ke-%d==========\n", i + 1);
			System.out.print("No. Pelanggan	: ");
			data[i].no = scan.nextInt();
			System.out.print("Nama		: ");
			data[i].nama = scan.next();
			System.out.print("Tipe Motor	: ");
			scan.nextLine();
			data[i].motor = scan.nextLine();
			System.out.print("Jumlah		: ");
			data[i].jmlMotor = scan.nextInt();
			System.out.println();
		}
		boolean ulang;
		while (ulang = true) {
			System.out.println("======================================================");
			System.out.println("Pilihan : ");
			System.out.println("1. Urutkan No. Pelanggan (A-Z)");
			System.out.println("2. Urutkan No. Pelanggan (Z-A)");
			System.out.println("3. Cari No. Pelanggan");
			System.out.println("4. Keluar");
			System.out.println();
			System.out.print("Pilihan : ");
			int pilihan = scan.nextInt();
			System.out.println("------------------------------------------------------");
			if (pilihan == 1) {
				doInsertionSortAscNo(data);
			} else if (pilihan == 2) {
				doInsertionSortDescNo(data);
			} else if (pilihan == 3) {
				System.out.println("No. pelanggan yang ingin dicari :");
				int noDicari = scan.nextInt();
				int indexNoDicari = cariSequential(data, noDicari);
				if (indexNoDicari >= 0) {
					System.out.println();
					System.out.printf("Ditemukan Pelanggan bernama %s dengan pembelian %d unit %s.\n", data[indexNoDicari].nama,
							data[indexNoDicari].jmlMotor, data[indexNoDicari].motor);
				} else
					System.out.println("Data tidak ditemukan");
			} else if (pilihan == 4) {
				ulang = false;
				break;
			}
			System.out.println("------------------------------------------------------");
		}
		System.out.println("Selamat melanjutkan pekerjaan anda!");
	}

}
