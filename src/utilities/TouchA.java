/**
 * Created By Vaishali
 * Use this class to scroll the screen.
 * Example TouchA.swipe(startx, starty, startx, endy, 1000);
 * 
 */

package utilities;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;

import basicConfig.LaunchApp;



public class TouchA {
	
	/**
	 * Method to swipe the screen horizontally and vertically
	 * @param startx
	 * @param starty
	 * @param endx
	 * @param endy
	 * @param duration
	 */
	public static void swipe(int startx, int starty, int endx, int endy, int duration) {
		try {
			Process pr = execute("adb shell input touchscreen swipe "+startx+" "+starty+" "+endx+" "+endy+" "+duration);
		} catch (IOException | InterruptedException e) {
			throw new RuntimeException("Execution error while executing command" + "adb shell input touchscreen swipe", e);

		}
    }  
    
	/**
	 * Method to tap on screen
	 * @param x
	 * @param y
	 */
    public static void tap(int x, int y){
    	try {
			Process pr = execute("adb shell input tap "+x+ " "+ y);
		} catch (IOException | InterruptedException e) {
			
			throw new RuntimeException("Execution error while executing command" + "adb shell input tap x y", e);
		}
    }
    
    
    
    
    /**
     * Method to execute any adb command. Pass the adb command as string into this method
     * @param command
     * @return
     * @throws IOException
     * @throws InterruptedException
     */
    private static Process execute(String command) throws IOException, InterruptedException {
        List<String> commandP = new ArrayList();
        String[] com = command.split(" ");
        for (int i = 0; i < com.length; i++) {
            commandP.add(com[i]);
        }
        ProcessBuilder prb = new ProcessBuilder(commandP);
        Process pr = prb.start();
        pr.waitFor(10, TimeUnit.SECONDS);
        return pr;
    }
    
    private static int getAbsoluteValueOfX(int x){
    	WebDriver driver = (WebDriver)LaunchApp.getDriver();
    	Dimension size = driver.manage().window().getSize();
    	int startx = (int)(size.width * 0.19);
    	return startx;
    }
    
    private static int getAbsoluteValueOfY(int y){
    	WebDriver driver = (WebDriver)LaunchApp.getDriver();
    	Dimension size = driver.manage().window().getSize();
       	int starty = (int) (size.height * 0.8);
       	return starty;
    }
    
    
}
