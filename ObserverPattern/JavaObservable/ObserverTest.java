import java.util.Observable;
import java.util.Observer;


public class ObserverTest {
	public static void main(String[] args) {
		WeatherData weatherData = new WeatherData();

		TemperatureDisplay d1 = new TemperatureDisplay(weatherData);
		TemperatureDisplay d2 = new TemperatureDisplay(weatherData);

		weatherData.setTemperature(100);
	}
}

interface DisplayElement {
	public void display();
}

class WeatherData extends Observable {
	private float temperature;

	public WeatherData() { }

	public void setTemperature(float temp) {
		this.temperature = temp;
		setChanged();		// This has to be called to set a flag so obervers can be notified.
		notifyObservers();	// Flag back to false.
	}

	public float getTemperature() {
		return temperature;
	}
}

class TemperatureDisplay implements Observer, DisplayElement {
	private float temperature;
	private Observable observable;

	public TemperatureDisplay(Observable observable) {
		this.observable = observable;
		observable.addObserver(this);
	}

	// Active "pull" update, not the passive update in previous customized observer pattern.
	public void update(Observable observable, Object arg) {
		if (observable instanceof WeatherData) {
			WeatherData weatherData = (WeatherData)observable;
			temperature = weatherData.getTemperature();
		}
		display();
	}

	public void display() {
		System.out.println("Temperature is " + temperature);
	}
}