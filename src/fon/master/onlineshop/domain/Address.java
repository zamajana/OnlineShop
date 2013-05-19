package fon.master.onlineshop.domain;

import java.io.Serializable;

public class Address extends BaseEntity implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int id;
	private String street;
	private String number;
	private Place place;
	
	public Address() {
		super();
	}

	public Address(int id, String street, String number, Place place) {
		super();
		this.id = id;
		this.street = street;
		this.number = number;
		this.place = place;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public Place getPlace() {
		return place;
	}

	public void setPlace(Place place) {
		this.place = place;
	}
	
	@Override
	public String toString() {
		return "Address: "+this.street+", "+this.number+", "+this.place.toString();
	}
	
//	@Override
//	public int hashCode() {
//		final int prime = 31;
//		int result = super.hashCode();
//		result = prime * result + ((street == null) ? 0 : street.hashCode());
//		result = prime * result + ((number == null) ? 0 : number.hashCode());
//		result = prime * result + ((place == null) ? 0 : place.hashCode());
//		return result;
//	}
//
//	@Override
//	public boolean equals(Object obj) {
//		if (this == obj)
//			return true;
//		if (!super.equals(obj))
//			return false;
//		if (getClass() != obj.getClass())
//			return false;
//		Address other = (Address) obj;
//		if (street == null) {
//			if (other.street != null)
//				return false;
//		} else if (!street.equals(other.street))
//			return false;
//		if (number == null) {
//			if (other.number != null)
//				return false;
//		} else if (!number.equals(other.number))
//			return false;
//		if (place == null) {
//			if (other.place != null)
//				return false;
//		} else if (!place.equals(other.place))
//			return false;
//		return true;
//	}
}
