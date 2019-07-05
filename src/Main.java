import java.awt.FontFormatException;
import java.io.IOException;

public class Main {
	public static Backlight backlight;
	public static void main(String[] args) throws FontFormatException, IOException {
		// TODO Auto-generated method stub
		backlight = new Backlight();
		System.out.println("Hello World!");
		GUI mainGUI = new GUI();
		System.out.println("Working Directory = " +
	              System.getProperty("user.dir"));
		mainGUI.setTrip(0);
		Thread main = new Thread() { //Demo thread
			public void run() {
				int i=1;
				while(true) {
					mainGUI.updateTime();
					mainGUI.setTrip(mainGUI.getTrip()+1);
					mainGUI.setBatteryIcon(i);
					i++;
					if(i==5) {
						i=1;
					}
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		};
		main.start();
	}

}
