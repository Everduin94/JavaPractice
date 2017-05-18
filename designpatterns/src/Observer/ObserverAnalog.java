package Observer;

/**
 * @author Erik Verduin
 */
public class ObserverAnalog extends AbstractObserver {
    SubjectTimer subject;

    public ObserverAnalog(SubjectTimer subject) {
        this.subject = subject;
        subject.getOberservers().add(this);
    }

    public ObserverAnalog() { // Pretty sure this is a deconstructor for C / C++
        subject.getOberservers().remove(this);
    }

    @Override
    protected void update(AbstractSubject theChangedAbstractSubject) {
        if (theChangedAbstractSubject == subject) {
            draw();
        }
    }

    public void draw() {
        //Override draw
        System.out.println("Drawing from analog");
    }
}
