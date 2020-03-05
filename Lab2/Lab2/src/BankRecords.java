import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class BankRecords {
	
	//Array of BankRecords objects
	static BankRecords robjs[] = new BankRecords[600];
	//ArrayList to hold spreadsheet data (rows/columns)
	static ArrayList<List<String>> array = new ArrayList<>();
	
	//Instance fields for all data [types]
	private String id;
	private int age;
	private String sex;
	private String region;
	private double income;
	private String married;
	private int children;
	private String car;
	private String save_act;
	private String current_act;
	private String mortgage;
	private String pep;
	
	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(String id) {
		this.id = id;
	}
	/**
	 * @return the age
	 */
	public int getAge() {
		return age;
	}
	/**
	 * @param age the age to set
	 */
	public void setAge(int age) {
		this.age = age;
	}
	/**
	 * @return the sex
	 */
	public String getSex() {
		return sex;
	}
	/**
	 * @param sex the sex to set
	 */
	public void setSex(String sex) {
		this.sex = sex;
	}
	/**
	 * @return the region
	 */
	public String getRegion() {
		return region;
	}
	/**
	 * @param region the region to set
	 */
	public void setRegion(String region) {
		this.region = region;
	}
	/**
	 * @return the income
	 */
	public double getIncome() {
		return income;
	}
	/**
	 * @param income the income to set
	 */
	public void setIncome(double income) {
		this.income = income;
	}
	/**
	 * @return the married
	 */
	public String getMarried() {
		return married;
	}
	/**
	 * @param married the married to set
	 */
	public void setMarried(String married) {
		this.married = married;
	}
	/**
	 * @return the children
	 */
	public int getChildren() {
		return children;
	}
	/**
	 * @param children the children to set
	 */
	public void setChildren(int children) {
		this.children = children;
	}
	/**
	 * @return the car
	 */
	public String getCar() {
		return car;
	}
	/**
	 * @param car the car to set
	 */
	public void setCar(String car) {
		this.car = car;
	}
	/**
	 * @return the save_act
	 */
	public String getSave_act() {
		return save_act;
	}
	/**
	 * @param save_act the save_act to set
	 */
	public void setSave_act(String save_act) {
		this.save_act = save_act;
	}
	/**
	 * @return the current_act
	 */
	public String getCurrent_act() {
		return current_act;
	}
	/**
	 * @param current_act the current_act to set
	 */
	public void setCurrent_act(String current_act) {
		this.current_act = current_act;
	}
	/**
	 * @return the mortgage
	 */
	public String getMortgage() {
		return mortgage;
	}
	/**
	 * @param mortgage the mortgage to set
	 */
	public void setMortgage(String mortgage) {
		this.mortgage = mortgage;
	}
	/**
	 * @return the pep
	 */
	public String getPep() {
		return pep;
	}
	/**
	 * @param pep the pep to set
	 */
	public void setPep(String pep) {
		this.pep = pep;
	}
	
	//Code to read file data and parse records
	public void readData() {
		
		BufferedReader br = null;
		
		//Initialize reader object, set file path to root of project
		try {
			br = new BufferedReader(new FileReader (new File("bank-Detail.csv")));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		String line;
		
		//Read each csv record
		try {
			while ((line = br.readLine()) != null) {
				//Parse each record in csv file by a comma (,)
				//List stored in the arraylist -> Arrays
				array.add(Arrays.asList(line.split(",")));
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//Call function for processing record data
		processData();
	}
	
	//Code to process data into array using setters
	public void processData( ) {
		
		//Create index for array while iterating through list
		int idx = 0;
		
		//FOR loop used to cycle through list of values
		//Will PASS data into record objects' setters
		for (List<String> rowData:array) {
			//Initialize array of objects
			robjs[idx] = new BankRecords();
			
			//Call setters below and populate them, item-by-item
			robjs[idx].setId(rowData.get(0));							//Get column 1
			robjs[idx].setAge(Integer.parseInt(rowData.get(1)));		//Get column 2
			robjs[idx].setSex(rowData.get(2));							//Get column 3
			robjs[idx].setRegion(rowData.get(3));						//Get column 4
			robjs[idx].setIncome(Double.parseDouble(rowData.get(4)));	//Get column 5
			robjs[idx].setMarried(rowData.get(5));						//Get column 6
			robjs[idx].setChildren(Integer.parseInt(rowData.get(6)));	//Get column 7
			robjs[idx].setCar(rowData.get(7));							//Get column 8
			robjs[idx].setSave_act(rowData.get(8));						//Get column 9
			robjs[idx].setCurrent_act(rowData.get(9));					//Get column 10
			robjs[idx].setMortgage(rowData.get(10));					//Get column 11
			robjs[idx].setPep(rowData.get(11));							//Get column 12
			
			idx++;
		}
		
		//Call function to print objects held in memory
		printData();
	}
	
	//Code to print data to console
	public void printData() {
		
		System.out.println("ID\t\tAGE\t\tSEX\t\tREGION\t\tINCOME\t\tMORTGAGE");
		
		//FOR loop to output first 25 records
		for (int odx = 0; odx < 25; odx++) {
			//Appropriate formatting to ensure fields align
			System.out.printf("%-10s\t", robjs[odx].getId());
			System.out.printf("%-10s\t", robjs[odx].getAge());
			System.out.printf("%-10s\t", robjs[odx].getSex());
			System.out.printf("%-10s\t", robjs[odx].getRegion());
			System.out.printf("$%.2f\t", robjs[odx].getIncome());
			System.out.printf("%-10s\t", robjs[odx].getMortgage());
			//System.out.printf("%-10s\t", robjs[odx].getChildren());
			//System.out.printf("%-10s\t", robjs[odx].getCar());
			//System.out.printf("%-10s\t", robjs[odx].getSave_act());
			//System.out.printf("%-10s\t", robjs[odx].getCurrent_act());
			//System.out.printf("%-10s\t", robjs[odx].getPep());
			System.out.println();
		}
		
	}
}