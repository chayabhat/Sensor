package projectSensor;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.ArrayList;

public class MainClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		try {
			Class.forName("org.sqlite.JDBC");
			System.out.println("Load driver success");

			Connection connection = DriverManager.getConnection("jdbc:sqlite:D:/project/sample.sqlite");
			System.out.println("connect driver success");
			// Query insert to table product with 4 value
			String query = "INSERT INTO PRODUCT"
					+ "(Temp, Humidity, "
					+ "CO2Level, Moisture, WaterLevel, MotorStatus, "
					+ "VentilationSwitch, ITap, GasSwitch, VentSwitch, HumiditySwitch, Date,Time)"
					+ "VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
			System.out.println("database found");

			// CREATE Prepare statement
			PreparedStatement preparedStatement = connection.prepareStatement(query);
			//System.out.println("preparestatement"+preparedStatement);

			// Get list of products from filetext
			ArrayList<SensorObjects> listObjects = getListProductFromTextFile("sensorData.txt");

			// insert list to db
			for (int i = 0; i < listObjects.size(); i++) {
			
				//java.sql.Date time = getCurrentDate();
				preparedStatement.setString(1, listObjects.get(i).getTemp());
				preparedStatement.setString(2, listObjects.get(i).getHumidity());
				preparedStatement.setString(3, listObjects.get(i).getCo2level());
				preparedStatement.setString(4, listObjects.get(i).getMoisture());
				preparedStatement.setInt(5, listObjects.get(i).getWaterlevel());
				preparedStatement.setInt(6, listObjects.get(i).getMotorstatus());
				preparedStatement.setInt(7, listObjects.get(i).getVentilationswitch());
				preparedStatement.setInt(8, listObjects.get(i).getItap());
				preparedStatement.setInt(9, listObjects.get(i).getGasswitch());
				preparedStatement.setInt(10, listObjects.get(i).getVentswitch());
				preparedStatement.setInt(11, listObjects.get(i).getHumidityswitch());
				preparedStatement.setDate(12, (Date) getCurrentDate());
				preparedStatement.setDate(13, (Date) getCurrentDate());
				
				preparedStatement.executeUpdate();

			}

			System.out.println("executed sussecfully");
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	private static Date getCurrentDate() {
		// TODO Auto-generated method stub
		// java.sql.Date today = new java.sql.Date();
		java.util.Date utilDate = new java.util.Date();
		java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
		System.out.println(utilDate);
		// return new java.sql.Date(today);
		return (Date) sqlDate;

	}

	public static ArrayList<SensorObjects> getListProductFromTextFile(String filePath) {
		FileInputStream fis = null;
		InputStreamReader isr = null;
		BufferedReader bReader = null;
		ArrayList<SensorObjects> listResult = new ArrayList<SensorObjects>();

		try {
			fis = new FileInputStream(filePath);
			isr = new InputStreamReader(fis);
			bReader = new BufferedReader(isr);

			// String save line get from text file
			String line = null;

			// Array save product
			String[] strObject = null;

			// loop and get all data in text file
			while (true) {
				// Get 1 line
				line = bReader.readLine();
				// Check line get empty , exit loop
				if (line == null) {
					break;
				} else {
					strObject = line.split(",");

					listResult.add(new SensorObjects(strObject[0], strObject[1],
							strObject[2], strObject[3], Integer.parseInt(strObject[4]), 
							Integer.parseInt(strObject[5]),
							Integer.parseInt(strObject[6]), Integer.parseInt(strObject[7]),
							Integer.parseInt(strObject[8]), Integer.parseInt(strObject[9]),
							Integer.parseInt(strObject[10])));
				}

			}

		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Read file error");
			e.printStackTrace();

		} finally {
			try {
				bReader.close();
				isr.close();
				fis.close();
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		}
		return listResult;

	}

}
