package daten;
import java.security.acl.LastOwnerException;
import java.util.Date;

public class Student extends Person implements Comparable<Student> {

	public Student(String firstName, String lastName) {
		this(firstName, lastName, false);
	}

	public Student(String firstName, String lastName, boolean selfEntitled) {
		super(firstName, lastName);
		setSelfEntitled(selfEntitled);
	}

	private boolean selfEntitled;
	private Date birthDate; // TODO add getter,setter,Constructors
	
	//checked
	public Student(String firstName, String lastName, boolean selfEntitled, Date birthDate) {
		super(firstName, lastName);
		this.selfEntitled = selfEntitled;
		this.birthDate = birthDate;
	}

	public Date getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(Date birthDate) {
		if (birthDate == null) {
			throw new IllegalArgumentException("birthDate must not be null!");
		}
		this.birthDate = birthDate;
	}

	public boolean getSelfEntitled() {
		return selfEntitled;
	}

	public void setSelfEntitled(boolean selfEntitled) {
		this.selfEntitled = selfEntitled;
	}

	@Override
	public int compareTo(Student o) {
		int result = 0;

		// TODO implement meaningful unit tests
		if ((result = getLastName().compareTo(o.getLastName())) == 0) {
			if ((result = getFirstName().compareTo(o.getFirstName())) == 0) {
				result = getBirthDate().compareTo(o.getBirthDate()); // TODO change to
															// getter after
															// implementation
			}
		}
		return result;
	}
	

	@Override
	public String toString() {
		// TODO missing implementation
		return "Name d. Studenten: " + getLastName() + " " + getFirstName() + "\n" + "SelfEntitled: " + getSelfEntitled()
				+"\n" + "GebDat: " + getBirthDate();
		//return super.toString();
	}
}
