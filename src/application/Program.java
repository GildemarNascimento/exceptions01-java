package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import model.entities.Reservation;
import model.excepitions.DomainException;
public class Program {

	public static void main(String[] Args) {
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		
		try {
			System.out.println("Room number: ");
			int roomNumber = sc.nextInt();
			System.out.println("Check-in date (dd/mm/yyyy): ");
			Date checkIn = sdf.parse(sc.next());
			System.out.println("Check-out date (dd/mm/yyyy): ");
			Date checkOut = sdf.parse(sc.next());
			
			
		
			Reservation reservation = new Reservation(roomNumber, checkIn, checkOut);
			System.out.println("Reservetion " + reservation);
			
			System.out.println();
			System.out.println("Enter data to update the reservetion");
			System.out.println("Check-in date (dd/mm/yyyy): ");
			checkIn = sdf.parse(sc.next());
			System.out.println("Check-out date (dd/mm/yyyy): ");
			checkOut = sdf.parse(sc.next());
			
			reservation.updateDates(checkIn, checkOut);
			
			System.out.println("Reservetion " + reservation);
		
		} catch (ParseException e) {
			System.out.println("Invalid date format");
				
		} catch(DomainException e){
			System.out.println("Error in  reservatio: " + e.getMessage());
		} catch(RuntimeException e){
			System.out.println("Unexpected Error" + e.getMessage());
		}
				
		sc.close();
		
	}

}
