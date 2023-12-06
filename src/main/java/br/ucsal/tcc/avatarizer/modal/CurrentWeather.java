package br.ucsal.tcc.avatarizer.modal;

public class CurrentWeather {
    private String time;
    private int interval;
    private double temperature_2m;
    private int is_day;
    private double rain;
    
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public int getInterval() {
		return interval;
	}
	public void setInterval(int interval) {
		this.interval = interval;
	}
	public double getTemperature_2m() {
		return temperature_2m;
	}
	public void setTemperature_2m(double temperature_2m) {
		this.temperature_2m = temperature_2m;
	}
	public int getIs_day() {
		return is_day;
	}
	public void setIs_day(int is_day) {
		this.is_day = is_day;
	}
	public double getRain() {
		return rain;
	}
	public void setRain(double rain) {
		this.rain = rain;
	}
    
}