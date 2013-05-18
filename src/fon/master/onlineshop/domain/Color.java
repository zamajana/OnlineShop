package fon.master.onlineshop.domain;

public class Color extends ColorSize{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public Color() {
		super();
	}

	public Color(int id, String name) {
		super(id, name);
	}
	
	@Override
	public String toString() {
		return "Color:" + super.toString();
	}
}
