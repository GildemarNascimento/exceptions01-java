package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import model.entities.Reservation;
public class Program {
	public static void main(String[] Args) throws ParseException {
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		System.out.println("Room number: ");
		int roomNumber = sc.nextInt();
		System.out.println("Check-in date (dd/mm/yyyy): ");
		Date checkIn = sdf.parse(sc.next());
		System.out.println("Check-out date (dd/mm/yyyy): ");
		Date checkOut = sdf.parse(sc.next());
		
		if (!checkOut.after(checkIn)) {
			System.out.println("Erro in reservetion: Check-out date must be after  check-in date");
		}else {
			Reservation reservation = new Reservation(roomNumber, checkIn, checkOut);
			System.out.println("Reservetion " + reservation);
			
			System.out.println();
			System.out.println("Enter data to update the reservetion");
			System.out.println("Check-in date (dd/mm/yyyy): ");
			checkIn = sdf.parse(sc.next());
			System.out.println("Check-out date (dd/mm/yyyy): ");
			checkOut = sdf.parse(sc.next());
			
			String error = reservation.updateDates(checkIn, checkOut);
			
			if (error != null) {
				System.out.println("Error in reservetion: " + error);
			} else {
				System.out.println("Reservetion " + reservation);
			}
			
			
		}
		
		sc.close();
		
		
	}

}
