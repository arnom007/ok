package model.entities;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Reservations {
	
	private Date checkIn, checkOut;
	private int roomNumber;
	
	private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	
	public Reservations(Date checkIn, Date checkOut, int roomNumber) {
		this.checkIn = checkIn;
		this.checkOut = checkOut;
		this.roomNumber = roomNumber;
	}

	public Date getCheckIn() {
		return checkIn;
	}

	public Date getCheckOut() {
		return checkOut;
	}
	
	public long duration() {
		long diff = checkOut.getTime() - checkIn.getTime();
		return TimeUnit.DAYS.convert(diff, TimeUnit.DAYS.MILLISECONDS);
	}

	public void updateDates(Date checkIn, Date checkOut) {
			this.checkIn = checkIn;
			this.checkOut = checkOut;
	}

	public int getRoomNumber() {
		return roomNumber;
	}

	public void setRoomNumber(int roomNumber) {
		this.roomNumber = roomNumber;
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("Room: ");
		sb.append(roomNumber + ", ");
		sb.append("check-in: ");
		sb.append(sdf.format(checkIn) + ", ");
		sb.append("check-out: ");
		sb.append(sdf.format(checkOut) + ", ");
		sb.append(duration() + " nights");
		return sb.toString();
		
	}
	
}
