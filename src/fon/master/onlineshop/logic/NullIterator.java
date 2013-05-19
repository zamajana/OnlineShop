package fon.master.onlineshop.logic;

import java.util.Iterator;

import fon.master.onlineshop.domain.ProductComponent;

public class NullIterator implements Iterator<ProductComponent>{

	public boolean hasNext() {
		return false;
	}

	public ProductComponent next() {
		return null;
	}

	public void remove() {
		throw new UnsupportedOperationException();
	}

}
