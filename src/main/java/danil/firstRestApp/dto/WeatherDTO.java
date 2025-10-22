package danil.firstRestApp.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class WeatherDTO {

	private Double latitude;
	private Double longitude;
	private String timezone;
	private int elevation;
	
	@JsonProperty("current_weather")
	private CurrentWeatherDTO currentWeather;
	
	public Double getLatitude() {
		return latitude;
	}
	public void setLatitude(Double latitude) {
		this.latitude = latitude;
	}
	public Double getLongitude() {
		return longitude;
	}
	public void setLongitude(Double longitude) {
		this.longitude = longitude;
	}
	public String getTimezone() {
		return timezone;
	}
	public void setTimezone(String timezone) {
		this.timezone = timezone;
	}
	public int getElevation() {
		return elevation;
	}
	public void setElevation(int elevation) {
		this.elevation = elevation;
	}
	public CurrentWeatherDTO getCurrentWeather() {
		return currentWeather;
	}
	public void setCurrentWeather(CurrentWeatherDTO currentWeather) {
		this.currentWeather = currentWeather;
	}
	
}
