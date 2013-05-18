package fon.master.onlineshop.gui;

import com.vaadin.ui.Window;
import com.vaadin.ui.Window.Notification;


public class OnlineShopNotification extends Notification{

	/**
	 * 
	 */
	private static final long serialVersionUID = -1953913141793542378L;
	
	private Window window;
	
	public OnlineShopNotification(String caption, String message, int type, Window window) {
		super(message);
		setCaption(caption);
		setDescription("<br/>"+message);
//		setDelayMsec(2000);
		this.window = window;
//		setIcon(icon);
	}
	
	public static void showNotification(String message, Window window){
		OnlineShopNotification notification = new OnlineShopNotification("Notification", message, OnlineShopNotification.TYPE_HUMANIZED_MESSAGE, window);
		notification.setStyleName("humanizedNotification");
		window.showNotification(notification);
	}
	
	public static void showTrayNotification(String message, Window window){
		OnlineShopNotification notification = new OnlineShopNotification("Notification", message, OnlineShopNotification.TYPE_TRAY_NOTIFICATION, window);
		notification.setStyleName("trayNotification");
		window.showNotification(notification);
	}

	public static void showWarning(String message, Window window){
		OnlineShopNotification notification = new OnlineShopNotification("Warning", message, OnlineShopNotification.TYPE_WARNING_MESSAGE, window);
		notification.setStyleName("wariningNotification");
		window.showNotification(notification);
	}
	
	public static void showError(String message,  Window window){
		OnlineShopNotification notification = new OnlineShopNotification("Error", message, OnlineShopNotification.TYPE_ERROR_MESSAGE, window);
		notification.setStyleName("errorNotification");
		window.showNotification(notification);
	}
	
	
	
}
