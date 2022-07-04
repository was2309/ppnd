package rs.ac.bg.fon.njt.ppnd.model.keys;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Embedded;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class LecturingId implements Serializable {

    @Embedded
    private TeachingCoveragePlanId teachingCoveragePlanId;

    @Column(name = "lecturing_id")
    private Long lecturingId;

    public LecturingId() {
    }

    public LecturingId(TeachingCoveragePlanId teachingCoveragePlanId, Long lecturingId) {
        this.teachingCoveragePlanId = teachingCoveragePlanId;
        this.lecturingId = lecturingId;
    }

    public void setTeachingCoveragePlanId(TeachingCoveragePlanId teachingCoveragePlanId) {
        this.teachingCoveragePlanId = teachingCoveragePlanId;
    }

    public Long getLecturingId() {
        return lecturingId;
    }

    public void setLecturingId(Long lecturingId) {
        this.lecturingId = lecturingId;
    }

    public TeachingCoveragePlanId getTeachingCoveragePlanId() {
        return teachingCoveragePlanId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LecturingId that = (LecturingId) o;
        return Objects.equals(teachingCoveragePlanId, that.teachingCoveragePlanId) && Objects.equals(lecturingId, that.lecturingId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(teachingCoveragePlanId, lecturingId);
    }
}
