import java.awt.Color;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.Date;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JSlider;
import javax.swing.SwingConstants;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class GUI {
	JLabel batteryLabel = new JLabel("100%");
	JLabel time = new JLabel((new Date()).toString());
	ImageIcon batteryIcon ;
	JLabel trip = new JLabel();
	JButton reset = new JButton();
	JLabel batteryTemp= new JLabel();
	ImageIcon batteryTempIcon;
	JLabel motorTemp= new JLabel();
	ImageIcon motorTempIcon;
	JLabel kmph = new JLabel();
	JButton lowSpeed = new JButton("Low Speed");
	JButton highSpeed = new JButton("High Speed");
	JButton sportMode = new JButton("Sport Mode");
	JButton reverseMode = new JButton("Reverse Mode");
	JButton parkingMode = new JButton("Parking Mode");
	public void setMode(int value) {
		/* ------------------*
		 * 0 <- Low Speed    *
		 * 1 <- High Speed   *
		 * 2 <- Sport Mode   *
		 * 3 <- Reverse Mode *
		 * 4 <- Parking Mode *
		 *-------------------*/
		switch(value) {
			case 0:
				lowSpeed.setBackground(Color.GREEN);
				highSpeed.setBackground(Color.GRAY);
				sportMode.setBackground(Color.GRAY);
				reverseMode.setBackground(Color.GRAY);
				parkingMode.setBackground(Color.GRAY);
				break;
			case 1:
				lowSpeed.setBackground(Color.GRAY);
				highSpeed.setBackground(Color.GREEN);
				sportMode.setBackground(Color.GRAY);
				reverseMode.setBackground(Color.GRAY);
				parkingMode.setBackground(Color.GRAY);
				break;
			case 2:
				lowSpeed.setBackground(Color.GRAY);
				highSpeed.setBackground(Color.GRAY);
				sportMode.setBackground(Color.GREEN);
				reverseMode.setBackground(Color.GRAY);
				parkingMode.setBackground(Color.GRAY);
				break;
			case 3:
				lowSpeed.setBackground(Color.GRAY);
				highSpeed.setBackground(Color.GRAY);
				sportMode.setBackground(Color.GRAY);
				reverseMode.setBackground(Color.GREEN);
				parkingMode.setBackground(Color.GRAY);
				break;
			case 4:
				lowSpeed.setBackground(Color.GRAY);
				highSpeed.setBackground(Color.GRAY);
				sportMode.setBackground(Color.GRAY);
				reverseMode.setBackground(Color.GRAY);
				parkingMode.setBackground(Color.GREEN);
				break;
		}
	}
	public void updateTime() {
		time.setText((new Date()).toString());
	}
	public void setBatteryIcon(int level) {
		/* --------------*
         * Total 4 Bars  *
		 * 1 <- 1 Bar    *
		 * 2 <- 2 Bar    *
		 * 3 <- 3 Bar    *
		 * 4 <- 4 Bar    *
		 *---------------*/
		switch(level) {
			case 1:
				batteryIcon=new ImageIcon("batt1.png");
				batteryLabel.setIcon(batteryIcon);
				batteryLabel.setText("25%");
				break;
			case 2:
				batteryIcon=new ImageIcon("batt2.png");
				batteryLabel.setIcon(batteryIcon);
				batteryLabel.setText("50%");
				break;
			case 3:
				batteryIcon=new ImageIcon("batt3.png");
				batteryLabel.setIcon(batteryIcon);
				batteryLabel.setText("75%");
				break;
			case 4:
				batteryIcon=new ImageIcon("batt4.png");
				batteryLabel.setIcon(batteryIcon);
				batteryLabel.setText("100%");
				break;
		}
	}
	public void setBatteryTempColor(Color color) {
		if(color==Color.RED) {
			batteryTempIcon=new ImageIcon("battery_red.png");
			batteryTemp.setIcon(batteryTempIcon);
		}
		else if(color==Color.YELLOW) {
			batteryTempIcon=new ImageIcon("battery_yellow.png");
			batteryTemp.setIcon(batteryTempIcon);
		} 
		else if(color==Color.GREEN) {
			batteryTempIcon=new ImageIcon("battery_GREEN.png");
			batteryTemp.setIcon(batteryTempIcon);
		} 
	}
	public void setMotorTempColor(Color color) {
		if(color==Color.RED) {
			motorTempIcon=new ImageIcon("motor_red.png");
			motorTemp.setIcon(motorTempIcon);
		}
		else if(color==Color.YELLOW) {
			motorTempIcon=new ImageIcon("motor_yellow.png");
			motorTemp.setIcon(motorTempIcon);
		} 
		else if(color==Color.GREEN) {
			motorTempIcon=new ImageIcon("motor_GREEN.png");
			motorTemp.setIcon(motorTempIcon);
		} 
	}
	public void setTrip(long val) {
		trip.setText("TRIP(KM) : " + Long.toString(val));
	}
	public long getTrip() {
		String text=trip.getText();
		text=text.substring(text.indexOf(":")+2);
		return Long.parseLong(text);
	}
	public void setkmph(long value) {
		kmph.setText(Long.toString(value));
	}
	@SuppressWarnings("unused")
	public GUI() throws FontFormatException, IOException{
		//Creation of main frame or window
		JFrame mainFrame = new JFrame();
		//Set properties of window
		mainFrame.getContentPane().setBackground(Color.WHITE);      // To set background to white for entire window
		mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);   // To exit on closing
		mainFrame.setExtendedState(JFrame.MAXIMIZED_BOTH);          // For fullscreen
		mainFrame.setUndecorated(true);                             // Disable title bar
		mainFrame.setVisible(true);                                 // Enable window visibility
		mainFrame.setLayout(null);                                  // Absolute layout
		
		//Add Battery Level Icon and percentage
		setBatteryIcon(2);                //Default 2 bars
		mainFrame.add(batteryLabel);
		time.setFont(new Font(time.getFont().getName(),Font.PLAIN,20));
		
		//Add time
		mainFrame.add(time);
		trip.setFont(new Font(time.getFont().getName(),Font.PLAIN,20));
		
		//Add trip
		mainFrame.add(trip);
		
		//Add reset button
		reset.setText("Reset");
		mainFrame.add(reset);
		
		//Add temperature indicators and labels
		JLabel temperatureLabel = new JLabel("TEMPERATURE");
		temperatureLabel.setFont(new Font(time.getFont().getName(),Font.PLAIN,20));
		mainFrame.add(temperatureLabel);
		mainFrame.add(batteryTemp);
		setBatteryTempColor(Color.RED);   //Default RED
		mainFrame.add(motorTemp);
		setMotorTempColor(Color.RED);     //Default RED
		
		//Add kilometer per hour
		kmph.setHorizontalAlignment(SwingConstants.RIGHT);
		setkmph(150);
		kmph.setFont(new Font(time.getFont().getName(),Font.PLAIN,100));
		mainFrame.add(kmph);
		JLabel kmphLabel=new JLabel("Km/h");
		mainFrame.add(kmphLabel);
		kmphLabel.setFont(new Font(time.getFont().getName(),Font.PLAIN,20));
		
		//Add mode label and mode buttons **TO BE MADE PANEL**
		JLabel modeLabel = new JLabel("MODE");
		mainFrame.add(modeLabel);
		modeLabel.setFont(new Font(time.getFont().getName(),Font.PLAIN,20));
		mainFrame.add(lowSpeed);
		mainFrame.add(highSpeed);
		mainFrame.add(sportMode);
		mainFrame.add(reverseMode);
		mainFrame.add(parkingMode);
		setMode(1);                       //Default HighSpeed Mode
		
		//Backlight Slider
		JSlider backlight = new JSlider();
		backlight.setOrientation(JSlider.HORIZONTAL);
		backlight.setMaximum(1024);
		backlight.setMinimum(100);
		backlight.setSnapToTicks(true);
		backlight.setBackground(Color.white);
		backlight.setValue(1024);
		mainFrame.add(backlight);
		
		//Get screen width and height		
		GraphicsDevice gd = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice();
		int width = gd.getDisplayMode().getWidth();
		int height = gd.getDisplayMode().getHeight();
		
		/* GUI Layout
		 * Do not touch unless its really needed
		 * Absolute values 
		 * Some are screen dependent.
		 */
		
		
		batteryLabel.setBounds(width-175,0,180,50);  //Battery with Battery icon [R,O,Y,G]
		time.setBounds(10,10,400,40);                //Time
		trip.setBounds(10,60,300,40);                //Trip
		reset.setBounds(10,100,100,40);              //Reset
		temperatureLabel.setBounds(width-160,30,200,100);  //Label TEMPERATURE
		batteryTemp.setBounds(width-100,100,40,40);         //Battery temperature icon [R, Y, G]
		motorTemp.setBounds(width-50,100,40,40);           //Motor temperature icon [R, Y, G]
		kmph.setBounds(width/2-200,60,300,130);       //KMPH main speedometer
		kmphLabel.setBounds(width/2+100,120,60,50);     //Km/hr label in the speedometer
		modeLabel.setBounds(10,170,100,40);          //MODE label
		lowSpeed.setBounds(10,220,width-20,40);      //Low speed mode set button
		highSpeed.setBounds(10,260,width-20,40);     //High speed mode set button
		sportMode.setBounds(10,300,width-20,40);     //Sport mode set button
		reverseMode.setBounds(10,340,width-20,40);   //Reverse mode set button
		parkingMode.setBounds(10,380,width-20,40);   //Parking mode set button
		backlight.setBounds(width-310,height-50,300,40);
		
		//System.out.println(mainFrame.getBounds());
		
		/* Button Handlers
		 * It will be a mess around here
		 */
		reset.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				setTrip(0);                           // Do reset the trip
			}
		});
		lowSpeed.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				setMode(0);
			}
		});
		highSpeed.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				setMode(1);
			}
		});
		sportMode.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				setMode(2);
			}
		});
		reverseMode.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				setMode(3);
			}
		});
		parkingMode.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				setMode(4);
			}
		});
		
		// Backlight handler
		backlight.addChangeListener(new ChangeListener() {
			@Override
			public void stateChanged(ChangeEvent e) {
				if(backlight.getMousePosition()!=null) {
					float pos=(float) backlight.getMousePosition().getX();
					pos/=300;
					int temp=(int) (pos*(1024-100))+100;
					backlight.setValue(temp);
				}
				Main.backlight.setBacklight(backlight.getValue());
			}
		});
	}
}
