package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.InputMismatchException;
import java.util.Scanner;

import model.entities.Reservations;
import model.exceptions.DomainException;

public class Program {

	public static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		try{
			System.out.print("Room number: ");
			int roomNumber = sc.nextInt();
			System.out.print("Check-in date (dd/MM/yyyy): ");
			String chkIn = sc.next();
			Date checkIn = sdf.parse(chkIn);
			System.out.print("Check-out date(dd/MM/yyyy): ");
			String chkOut = sc.next();
			Date checkOut = sdf.parse(chkOut);

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

			System.out.println("Error in reservation: Check-out date must be after check-in date");
		} catch (ParseException e){
			System.out.println("Invalid date format.");
		} catch (DomainException e) {
			System.out.println("Error in reservation: " + e.getMessage());
		} catch (InputMismatchException e){
			System.out.println("Entrada inválida: " + e.getMessage());
		}

		sc.close();
		System.exit(0);

	}

}
