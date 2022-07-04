package rs.ac.bg.fon.njt.ppnd.model.keys;


import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Embedded;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class TeachingCoveragePlanId implements Serializable {

    @Embedded
    private ModuleSubjectId moduleSubjectId;

    @Column(name = "year_id")
    private Long yearId;


    public TeachingCoveragePlanId() {
    }

    public TeachingCoveragePlanId(ModuleSubjectId moduleSubjectId, Long yearId) {
        this.moduleSubjectId = moduleSubjectId;
        this.yearId = yearId;
    }

    public void setModuleSubjectId(ModuleSubjectId moduleSubjectId) {
        this.moduleSubjectId = moduleSubjectId;
    }

    public Long getYearId() {
        return yearId;
    }

    public void setYearId(Long yearId) {
        this.yearId = yearId;
    }

    public ModuleSubjectId getModuleSubjectId() {
        return moduleSubjectId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TeachingCoveragePlanId that = (TeachingCoveragePlanId) o;
        return Objects.equals(moduleSubjectId, that.moduleSubjectId) && Objects.equals(yearId, that.yearId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(moduleSubjectId, yearId);
    }
}
