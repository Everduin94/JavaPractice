package ObserverInterfaceVariation;

/**
 * @author Erik Verduin
 */
public class ObserverAnalogI implements IObserver {
    SubjectTimerI subject;

    public ObserverAnalogI(SubjectTimerI subject) {
        this.subject = subject;
        subject.attach(this);
    }

    public ObserverAnalogI() { // Pretty sure this is a deconstructor for C / C++
        subject.detach(this);
    }

    @Override
    public void update(ISubject theChangedISubject) {
        if (theChangedISubject == subject) {
            draw();
        }
    }

    public void manuallyAdjustTime(int time) {
        subject.setTime(time);
    }

    private void draw() {
        //Override draw
        System.out.println(subject.getTime() + " : Time from Analog");

    }
}
