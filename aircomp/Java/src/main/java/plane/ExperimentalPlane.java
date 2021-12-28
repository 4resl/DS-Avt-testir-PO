package plane;

import model.ClassificationLevel;
import model.ExperimentalType;

import java.util.Objects;

public class ExperimentalPlane extends AbstractPlane {

    private ExperimentalType type;
    private ClassificationLevel classificationLevel;

    public ExperimentalPlane(String model, int maxSpeed, int maxFlightDistance, int maxLoadCapacity, ExperimentalType type, ClassificationLevel classificationLevel) {
        super(model, maxSpeed, maxFlightDistance, maxLoadCapacity);
        this.type = type;
        this.classificationLevel = classificationLevel;
    }

    public ClassificationLevel getClassificationLevel(){
        return classificationLevel;
    }

    public void setClassificationLevel(ClassificationLevel classificationLevel){
        this.classificationLevel = classificationLevel;
    }

    public ExperimentalType getType() {
        return type;
    }

    public void setType(ExperimentalType type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return super.toString().replace("}",
                ", type=" + type
                        + ", classificationLevel=" + classificationLevel +
                        '}');
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ExperimentalPlane)) return false;
        if (!super.equals(o)) return false;
        ExperimentalPlane plane = (ExperimentalPlane) o;
        return type == plane.type
                && classificationLevel == plane.classificationLevel;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), type, classificationLevel);
    }
}
