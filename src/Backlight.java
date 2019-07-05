import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class Backlight extends PrintWriter{
	public Backlight() throws FileNotFoundException{
		super("/tmp/backlight/value");
	}

	public Backlight(File file) throws FileNotFoundException {
		super(file);
	}
	void setBacklight(int x) {
		Thread t = new Thread() {
			public void run() {
				println(x);
				flush();
			}
		};
		t.start();
	}
}
