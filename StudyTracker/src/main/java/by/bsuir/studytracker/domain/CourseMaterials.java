package by.bsuir.studytracker.domain;

import java.time.Instant;
import java.util.Objects;

public class CourseMaterials {
    private int materialId;
    private int courseId;
    private String materialName;
    private String materialType;
    private String description;
    private String url;
    private Instant dateAdded;
    private String filePath;


    public int getMaterialId() {
        return materialId;
    }

    public void setMaterialId(int materialId) {
        this.materialId = materialId;
    }

    public int getCourseId() {
        return courseId;
    }

    public void setCourseId(int courseId) {
        this.courseId = courseId;
    }

    public String getMaterialName() {
        return materialName;
    }

    public void setMaterialName(String materialName) {
        this.materialName = materialName;
    }

    public String getMaterialType() {
        return materialType;
    }

    public void setMaterialType(String materialType) {
        this.materialType = materialType;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Instant getDateAdded() {
        return dateAdded;
    }

    public void setDateAdded(Instant dateAdded) {
        this.dateAdded = dateAdded;
    }

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    public CourseMaterials(int materialId, int courseId, String materialName, String materialType, String description,
                           String url, Instant dateAdded, String filePath) {
        this.materialId = materialId;
        this.courseId = courseId;
        this.materialName = materialName;
        this.materialType = materialType;
        this.description = description;
        this.url = url;
        this.dateAdded = dateAdded;
        this.filePath = filePath;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CourseMaterials that)) return false;
        return materialId == that.materialId && courseId == that.courseId && Objects.equals(materialName, that.materialName) && Objects.equals(materialType, that.materialType) && Objects.equals(description, that.description) && Objects.equals(url, that.url) && Objects.equals(dateAdded, that.dateAdded) && Objects.equals(filePath, that.filePath);
    }

    @Override
    public int hashCode() {
        return Objects.hash(materialId, courseId, materialName, materialType, description, url, dateAdded, filePath);
    }

    @Override
    public String toString() {
        return "CourseMaterials{" +
                "materialId=" + materialId +
                ", courseId=" + courseId +
                ", materialName='" + materialName + '\'' +
                ", materialType='" + materialType + '\'' +
                ", description='" + description + '\'' +
                ", url='" + url + '\'' +
                ", dateAdded=" + dateAdded +
                ", filePath='" + filePath + '\'' +
                '}';
    }
}
