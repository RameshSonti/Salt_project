package csv.dal.beans;

public class StudentVO {

	private int studentId;// unique id for all student
	private String firstName;
	private String lastName;
	private String address;
	private String zipCode;
	private String primaryPhoneNumber;

	public StudentVO(int studentId, String firstName, String lastName, String address, String zipCode,
			String primaryPhoneNumber) {
		super();
		this.studentId = studentId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.address = address;
		this.zipCode = zipCode;
		this.primaryPhoneNumber = primaryPhoneNumber;
	}

	public int getStudentId() {
		return studentId;
	}

	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getZipCode() {
		return zipCode;
	}

	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}

	public String getPrimaryPhoneNumber() {
		return primaryPhoneNumber;
	}

	public void setPrimaryPhoneNumber(String primaryPhoneNumber) {
		this.primaryPhoneNumber = primaryPhoneNumber;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + studentId;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		StudentVO other = (StudentVO) obj;
		if (studentId != other.studentId)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "StudentInfo [studentId=" + studentId + ", firstName=" + firstName + ", lastName=" + lastName
				+ ", address=" + address + ", zipCode=" + zipCode + ", primaryPhoneNumber=" + primaryPhoneNumber + "]";
	}

}
