package ObserverInterfaceVariation;

/**
 * @author Erik Verduin
 */
public class ObserverDigitalI implements IObserver {
    SubjectTimerI subject;

    public ObserverDigitalI(SubjectTimerI subject) {
        this.subject = subject;
        subject.attach(this);
    }

    public ObserverDigitalI() {
        subject.detach(this);
    }

    @Override
    public void update(ISubject theChangedISubject) {
        if (theChangedISubject == subject) {
            draw();
        }
    }

    private void draw() {
        // Override draw
        System.out.println(subject.getTime() + " : Time from Digital");
    }


}
