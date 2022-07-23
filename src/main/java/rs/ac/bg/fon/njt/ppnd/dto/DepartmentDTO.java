package rs.ac.bg.fon.njt.ppnd.dto;

public class DepartmentDTO {

	private Long id;
	private String name;
	private int numberOfMembers;
	
	
	public DepartmentDTO() {
		super();
	}
	public DepartmentDTO(Long id, String name, int numberOfMembers) {
		super();
		this.id = id;
		this.name = name;
		this.numberOfMembers = numberOfMembers;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getNumberOfMembers() {
		return numberOfMembers;
	}
	public void setNumberOfMembers(int numberOfMembers) {
		this.numberOfMembers = numberOfMembers;
	}
	
	
}
