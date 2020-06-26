package model.entities;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import model.exceptions.DomainException;

public class Reservations {
	
	private Date checkIn, checkOut;
	private int roomNumber;
	
	private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	
	public Reservations(Date checkIn, Date checkOut, int roomNumber) throws DomainException {
		Date date = new Date();
		if (checkIn.after(checkOut))
			throw new DomainException("The check-out date must be after check-in date.");
		if (!date.before(checkIn) || !date.before(checkOut))
			throw new DomainException("You must make reservation for future dates.");
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

	public void updateDates(Date checkIn, Date checkOut) throws DomainException {
		Date date = new Date();
		if (checkIn.after(checkOut))
			throw new DomainException("The check-out date must be after check-in date.");
		if (!date.before(checkIn) || !date.before(checkOut))
			throw new DomainException("You must make reservation for future dates.");

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
