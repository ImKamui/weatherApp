package danil.firstRestApp.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CurrentWeatherDTO {

	private Double temperature;
	private Double windspeed;
	private Double winddirection;
	
	@JsonProperty("weatherCode")
	private int weatherCode;
	
	@JsonProperty("id_day")
	private int isDay;
	
	private String time;
	
	public Double getTemperature() {
		return temperature;
	}
	public void setTemperature(Double temperature) {
		this.temperature = temperature;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public int getWeatherCode() {
		return weatherCode;
	}
	public void setWeatherCode(int weatherCode) {
		this.weatherCode = weatherCode;
	}
	public Double getWindspeed() {
		return windspeed;
	}
	public void setWindspeed(Double windspeed) {
		this.windspeed = windspeed;
	}
	public Double getWinddirection() {
		return winddirection;
	}
	public void setWinddirection(Double winddirection) {
		this.winddirection = winddirection;
	}
	public int getIsDay() {
		return isDay;
	}
	public void setIsDay(int isDay) {
		this.isDay = isDay;
	}
	
}
