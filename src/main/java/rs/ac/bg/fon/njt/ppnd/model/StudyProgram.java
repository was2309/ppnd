package rs.ac.bg.fon.njt.ppnd.model;


import lombok.*;


import javax.persistence.*;


@Entity
@Table(name = "study_program")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class StudyProgram {


    @Id
    @GeneratedValue
    @Column(name = "study_program_id")
    private Long id;

    @Column(name = "study_program_name")
    private String name;

	public StudyProgram(Long id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

	public StudyProgram() {
		super();
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


    
    
}
