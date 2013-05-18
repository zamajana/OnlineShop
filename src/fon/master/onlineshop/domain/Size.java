package fon.master.onlineshop.domain;

public class Size extends ColorSize{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public Size() {
		super();
	}
	
	public Size(int id, String name) {
		super(id, name);
	}

	@Override
	public String toString() {
		return "Size: " +super.toString();
	}
	
	
}
