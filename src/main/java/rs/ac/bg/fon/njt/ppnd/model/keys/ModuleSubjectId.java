package rs.ac.bg.fon.njt.ppnd.model.keys;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Embedded;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class ModuleSubjectId implements Serializable {

    @Embedded
    private ModuleId moduleId;

    @Column(name = "subject_id")
    private Long subjectId;

    public ModuleSubjectId() {
    }

    public ModuleSubjectId(ModuleId moduleId, Long subjectId) {
        this.moduleId = moduleId;
        this.subjectId = subjectId;
    }

    public ModuleId getModuleId() {
        return moduleId;
    }

    public void setModuleId(ModuleId moduleId) {
        this.moduleId = moduleId;
    }

    public Long getSubjectId() {
        return subjectId;
    }

    public void setSubjectId(Long subjectId) {
        this.subjectId = subjectId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ModuleSubjectId that = (ModuleSubjectId) o;
        return Objects.equals(moduleId, that.moduleId) && Objects.equals(subjectId, that.subjectId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(moduleId, subjectId);
    }
}
