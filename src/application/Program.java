package application;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import model.entities.Reservations;

public class Program {

	public static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

	public static void main(String[] args) throws Exception {

		Scanner sc = new Scanner(System.in);

		System.out.print("Room number: ");
		int roomNumber = sc.nextInt();
		System.out.print("Check-in date (dd/MM/yyyy): ");
		String chkIn = sc.next();
		Date checkIn = sdf.parse(chkIn);
		System.out.print("Check-out date(dd/MM/yyyy): ");
		String chkOut = sc.next();
		Date checkOut = sdf.parse(chkOut);

		if (checkOut.after(checkIn)) {
			Reservations reservation = new Reservations(checkIn, checkOut, roomNumber);
			System.out.println("Reservation: " + reservation);

			System.out.println("\n" + "Enter the data to update the reservation:");
			System.out.print("Check-in date (dd/MM/yyyy): ");
			chkIn = sc.next();
			checkIn = sdf.parse(chkIn);
			System.out.print("Check-out date(dd/MM/yyyy): ");
			chkOut = sc.next();
			checkOut = sdf.parse(chkOut);
			reservation.updateDates(checkIn, checkOut);
		} else {
			System.out.println("Error in reservation: Check-out date must be after check-in date");
		}

		sc.close();
		System.exit(0);

	}

}
