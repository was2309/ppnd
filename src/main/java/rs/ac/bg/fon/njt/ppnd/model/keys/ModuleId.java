package rs.ac.bg.fon.njt.ppnd.model.keys;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class ModuleId implements Serializable {

    @Column(name = "study_program_id")
    private Long studyProgramId;

    @Column(name = "module_id")
    private Long moduleId;

    public ModuleId() {
    }

    public ModuleId(Long studyProgramId, Long moduleId) {
        this.studyProgramId = studyProgramId;
        this.moduleId = moduleId;
    }

    public Long getStudyProgramId() {
        return studyProgramId;
    }

    public void setStudyProgramId(Long studyProgramId) {
        this.studyProgramId = studyProgramId;
    }

    public Long getModuleId() {
        return moduleId;
    }

    public void setModuleId(Long moduleId) {
        this.moduleId = moduleId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ModuleId moduleId1 = (ModuleId) o;
        return Objects.equals(studyProgramId, moduleId1.studyProgramId) && Objects.equals(moduleId, moduleId1.moduleId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(studyProgramId, moduleId);
    }
}
