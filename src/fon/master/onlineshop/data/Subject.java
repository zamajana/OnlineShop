package fon.master.onlineshop.data;

import fon.master.onlineshop.gui.cart.view.Observer;

public interface Subject {

	public void registerObserver(Observer observer);
	
	public void removeObserver(Observer observer);
	
	public void notifyObservers();
}
