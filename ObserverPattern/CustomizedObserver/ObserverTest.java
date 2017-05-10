import java.util.ArrayList;

public class ObserverTest {
	public static void main(String[] args) {
		WeatherData weatherData = new WeatherData();

		TemperatureDisplay d1 = new TemperatureDisplay(weatherData);
		TemperatureDisplay d2 = new TemperatureDisplay(weatherData);

		d1.display();
		d2.display();

		weatherData.setTemperature(100);

		d1.display();
		d2.display();
	}
}

interface Subject {
	public void registerObserver(Observer o);
	public void removeObserver(Observer o);
	public void notifyObservers();
}

interface Observer {
	public void update(float temp);
}

interface DisplayElement {
	public void display();
}

class WeatherData implements Subject {
	private ArrayList<Observer> observers;
	private float temperature;

	public WeatherData() {
		observers = new ArrayList<Observer>();
	}

	public void registerObserver(Observer o) {
		observers.add(o);
	}

	public void removeObserver(Observer o) {
		int i = observers.indexOf(o);
		if (i >= 0) {
			observers.remove(i);
		}
	}

	public void notifyObservers() {
		for (int i = 0; i < observers.size(); i++) {
			Observer o = observers.get(i);
			o.update(temperature);
		}
	}

	public void setTemperature(float temp) {
		this.temperature = temp;
		notifyObservers();
	}
}

class TemperatureDisplay implements Observer, DisplayElement {
	private float temperature;

	public TemperatureDisplay(Subject weatherData) {
		weatherData.registerObserver(this);
	}

	public void update(float temp) {
		temperature = temp;
	}

	public void display() {
		System.out.println("Temperature is " + temperature);
	}
}