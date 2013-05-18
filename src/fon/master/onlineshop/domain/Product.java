package fon.master.onlineshop.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


public class Product extends ProductComponent implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
//	private int id;
//	private String name;
//	private double price;
//	private String description;
	private List<Size> sizes = new ArrayList<Size>();
	private List<Dimension> dimensions = new ArrayList<Dimension>();
	private List<Color> colors = new ArrayList<Color>();
	private double discount;
	private String image;
	private double rating;
	private Category category;
	
	public Product() {
		
	}

	@Deprecated
	public Product(int id, String name, double price, String description,
			List<Size> sizes, List<Dimension> dimensions, List<Color> colors,
			double discount, String image, double rating, Category category) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
		this.description = description;
		this.sizes = sizes;
		this.dimensions = dimensions;
		this.colors = colors;
		this.discount = discount;
		this.image = image;
		this.rating = rating;
		this.category = category;
	}
	
	public Product(int id, String name, double price, String description, 
			Category category) {
		super();
		setId(id);
		setName(name);
		setPrice(price);
		setDescription(description);
		setCategory(category);
	}
	
	@Override
	public ProductComponent change(String name, double price, String description,
			Category category) {
		this.name = name;
		this.price = price;
		this.description = description;
		this.category = category;
		return this;
	}
	
	@Override
	public void print() {
		System.out.println("  ---- "+getName()+", price:"+getPrice() +" ----");
		System.out.println("       ------" +getDescription());
	}

	public List<Size> getSizes() {
		return sizes;
	}

	public void setSizes(List<Size> sizes) {
		this.sizes = sizes;
	}

	public List<Dimension> getDimensions() {
		return dimensions;
	}

	public void setDimensions(List<Dimension> dimensions) {
		this.dimensions = dimensions;
	}

	public List<Color> getColors() {
		return colors;
	}

	public void setColors(List<Color> colors) {
		this.colors = colors;
	}

	public double getDiscount() {
		return discount;
	}

	public void setDiscount(double discount) {
		this.discount = discount;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public double getRating() {
		return rating;
	}

	public void setRating(double rating) {
		this.rating = rating;
	}
	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((description == null) ? 0 : description.hashCode());
		result = prime * result + ((category == null) ? 0 : category.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Product other = (Product) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		if (category == null) {
			if (other.category != null)
				return false;
		} else if (!category.equals(other.category))
			return false;
		return true;
	}
	
	@Override
	public String toString() {
		return this.name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public ProductComponent getParent() {
		return parent;
	}

	public void setParent(ProductComponent productComponent){
		this.parent = productComponent;
	}


}
