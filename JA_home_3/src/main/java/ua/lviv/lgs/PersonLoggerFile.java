package ua.lviv.lgs;

import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;

public class PersonLoggerFile {
	private static Logger Log = Logger.getLogger(PersonLoggerFile.class);
	public static void main(String[] args) {
		
		logWithDomConfigurator();

		Person[] person = new Person[4];

		person[0] = new Person(0, "Vitaly Sniv", 178, 80);
		person[1] = new Person(1, "Peter Smit", 182, 92.3);
		person[2] = new Person(2, "Olga Guk", 0, 85.8);
		person[3] = new Person(3, "Nataly Ivanova", 172, 100.2);

		for (int i = 0; i < 5; i++) {
			try {
				double indexWeight = 10000 * person[i].getWeight() / (person[i].getGrowth() * person[i].getGrowth());
				//System.out.println(indexWeight);
				if (person[i].getGrowth() == 0) {
					throw new WrongDenominatorException("Denominator zero");
				}
			} catch (ArrayIndexOutOfBoundsException e) {
				Log.error("ERROR ArrayIndexOutOfBoundsException");
			} catch (WrongDenominatorException e) {
				Log.warn("WARN WrongDenominatorException");				
			}
		}

	}
	
public static void logWithDomConfigurator() {
		
		DOMConfigurator.configure("LoggerConfig.xml");
		Log.trace("TRACE message of project"); 
		Log.debug("DEBUG message of project");
		Log.info("INFO message of project");
		Log.warn("WARN message of project");
		Log.error("ERROR message of project");
		Log.fatal("FATAL message of project");
	}
}

class Person {
	private int id;
	private String name;
	private double growth;
	private double weight;

	public Person(int id, String name, double growth, double weight) {
		super();
		this.id = id;
		this.name = name;
		this.growth = growth;
		this.weight = weight;
	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public double getGrowth() {
		return growth;
	}

	public double getWeight() {
		return weight;
	}

	@Override
	public String toString() {
		return "Person [id=" + id + ", name=" + name + ", growth=" + growth + ", weight=" + weight + "]";
	}

}

class WrongDenominatorException extends Exception {

	private static final long serialVersionUID = 1L;
	private String parametr;

	public WrongDenominatorException(String parametr) {
		super(parametr);
		this.parametr = parametr;
	}

	public String getParametr() {
		return parametr;
	}
}