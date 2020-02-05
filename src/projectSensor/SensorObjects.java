package projectSensor;

public class SensorObjects {

	//private String date;
	//private String time;
	private String temp;
	private String humidity;
	private String co2level;
	private String moisture;
	private int waterlevel;
	private int motorstatus;
	private int ventilationswitch;
	private int itap;
	private int gasswitch;
	private int ventswitch;
	private int humidityswitch;
	
	public SensorObjects(String temp, String humidity, String co2level, String moisture,
			int waterlevel, int motorstatus, int ventilationswitch, int itap, int gasswitch, int ventswitch,
			int humidityswitch) {
		super();
//		this.date = date;
//		this.time = time;
		this.temp = temp;
		this.humidity = humidity;
		this.co2level = co2level;
		this.moisture = moisture;
		this.waterlevel = waterlevel;
		this.motorstatus = motorstatus;
		this.ventilationswitch = ventilationswitch;
		this.itap = itap;
		this.gasswitch = gasswitch;
		this.ventswitch = ventswitch;
		this.humidityswitch = humidityswitch;
	}

//	public String getDate() {
//		return date;
//	}
//
//	public void setDate(String date) {
//		this.date = date;
//	}

//	public String getTime() {
//		return time;
//	}
//
//	public void setTime(String time) {
//		this.time = time;
//	}

	public String getTemp() {
		return temp;
	}

	public void setTemp(String temp) {
		this.temp = temp;
	}

	public String getHumidity() {
		return humidity;
	}

	public void setHumidity(String humidity) {
		this.humidity = humidity;
	}

	public String getCo2level() {
		return co2level;
	}

	public void setCo2level(String co2level) {
		this.co2level = co2level;
	}

	public String getMoisture() {
		return moisture;
	}

	public void setMoisture(String moisture) {
		this.moisture = moisture;
	}

	public int getWaterlevel() {
		return waterlevel;
	}

	public void setWaterlevel(int waterlevel) {
		this.waterlevel = waterlevel;
	}

	public int getMotorstatus() {
		return motorstatus;
	}

	public void setMotorstatus(int motorstatus) {
		this.motorstatus = motorstatus;
	}

	public int getVentilationswitch() {
		return ventilationswitch;
	}

	public void setVentilationswitch(int ventilationswitch) {
		this.ventilationswitch = ventilationswitch;
	}

	public int getItap() {
		return itap;
	}

	public void setItap(int itap) {
		this.itap = itap;
	}

	public int getGasswitch() {
		return gasswitch;
	}

	public void setGasswitch(int gasswitch) {
		this.gasswitch = gasswitch;
	}

	public int getVentswitch() {
		return ventswitch;
	}

	public void setVentswitch(int ventswitch) {
		this.ventswitch = ventswitch;
	}

	public int getHumidityswitch() {
		return humidityswitch;
	}

	public void setHumidityswitch(int humidityswitch) {
		this.humidityswitch = humidityswitch;
	}

}
