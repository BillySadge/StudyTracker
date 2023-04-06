package by.bsuir.studytracker.domain;

import java.time.Instant;
import java.util.Objects;

public class Program {
    private int programId;
    private String programName;
    private String programType;
    private int departmentId;
    private String programCoordinator;
    private String description;
    private String degreeRequirements;
    private String admissionRequirements;
    private Instant programLength;
    private String programWebsite;

    public Program(int programId, String programName, String programType, int departmentId, String programCoordinator,
                   String description, String degreeRequirements, String admissionRequirements, Instant programLength, String programWebsite) {
        this.programId = programId;
        this.programName = programName;
        this.programType = programType;
        this.departmentId = departmentId;
        this.programCoordinator = programCoordinator;
        this.description = description;
        this.degreeRequirements = degreeRequirements;
        this.admissionRequirements = admissionRequirements;
        this.programLength = programLength;
        this.programWebsite = programWebsite;
    }

    public int getProgramId() {
        return programId;
    }

    public void setProgramId(int programId) {
        this.programId = programId;
    }

    public String getProgramName() {
        return programName;
    }

    public void setProgramName(String programName) {
        this.programName = programName;
    }

    public String getProgramType() {
        return programType;
    }

    public void setProgramType(String programType) {
        this.programType = programType;
    }

    public int getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(int departmentId) {
        this.departmentId = departmentId;
    }

    public String getProgramCoordinator() {
        return programCoordinator;
    }

    public void setProgramCoordinator(String programCoordinator) {
        this.programCoordinator = programCoordinator;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDegreeRequirements() {
        return degreeRequirements;
    }

    public void setDegreeRequirements(String degreeRequirements) {
        this.degreeRequirements = degreeRequirements;
    }

    public String getAdmissionRequirements() {
        return admissionRequirements;
    }

    public void setAdmissionRequirements(String admissionRequirements) {
        this.admissionRequirements = admissionRequirements;
    }

    public Instant getProgramLength() {
        return programLength;
    }

    public void setProgramLength(Instant programLength) {
        this.programLength = programLength;
    }

    public String getProgramWebsite() {
        return programWebsite;
    }

    public void setProgramWebsite(String programWebsite) {
        this.programWebsite = programWebsite;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Program program = (Program) o;
        return programId == program.programId && departmentId == program.departmentId && Objects.equals(programName, program.programName) && Objects.equals(programType, program.programType) && Objects.equals(programCoordinator, program.programCoordinator) && Objects.equals(description, program.description) && Objects.equals(degreeRequirements, program.degreeRequirements) && Objects.equals(admissionRequirements, program.admissionRequirements) && Objects.equals(programLength, program.programLength) && Objects.equals(programWebsite, program.programWebsite);
    }

    @Override
    public int hashCode() {
        return Objects.hash(programId, programName, programType, departmentId, programCoordinator, description, degreeRequirements, admissionRequirements, programLength, programWebsite);
    }

    @Override
    public String toString() {
        return "Program{" +
                "programId=" + programId +
                ", programName='" + programName + '\'' +
                ", programType='" + programType + '\'' +
                ", departmentId=" + departmentId +
                ", programCoordinator='" + programCoordinator + '\'' +
                ", description='" + description + '\'' +
                ", degreeRequirements='" + degreeRequirements + '\'' +
                ", admissionRequirements='" + admissionRequirements + '\'' +
                ", programLength=" + programLength +
                ", programWebsite='" + programWebsite + '\'' +
                '}';
    }
}
