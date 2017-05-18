package Observer;

/**
 * @author Erik Verduin
 */
public class ObserverDigital extends AbstractObserver {
    SubjectTimer subject;

    public ObserverDigital(SubjectTimer subject) {
        this.subject = subject;
        subject.getOberservers().add(this);
    }

    public ObserverDigital() {
        subject.getOberservers().remove(this);
    }

    @Override
    protected void update(AbstractSubject theChangedAbstractSubject) {
        if (theChangedAbstractSubject == subject) {
            draw();
        }
    }

    public void draw() {
        // Override draw
        System.out.println("Drawing");
    }


}
