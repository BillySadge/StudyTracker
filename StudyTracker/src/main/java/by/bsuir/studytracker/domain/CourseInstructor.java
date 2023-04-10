package by.bsuir.studytracker.domain;

public class CourseInstructor {

    private int courseId;
    private int instructorId;

    public CourseInstructor(int courseId, int instructorId) {
        this.courseId = courseId;
        this.instructorId = instructorId;
    }

    public int getCourseId() {
        return courseId;
    }

    public void setCourseId(int courseId) {
        this.courseId = courseId;
    }

    public int getInstructorId() {
        return instructorId;
    }

    public void setInstructorId(int instructorId) {
        this.instructorId = instructorId;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CourseInstructor that = (CourseInstructor) o;

        if (courseId != that.courseId) return false;
        return instructorId == that.instructorId;
    }

    @Override
    public int hashCode() {
        int result = courseId;
        result = 31 * result + instructorId;
        return result;
    }

    @Override
    public String toString() {
        return "CourseInstructor{" +
                "courseId=" + courseId +
                ", instructorId=" + instructorId +
                '}';
    }
}
