package ObserverInterfaceVariation;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Erik Verduin
 */
public class SubjectTimerI implements ISubject {

    private int time = 0; //Extra stuff for testing
    private List<IObserver> iObservers;

    public SubjectTimerI() {
        iObservers = new ArrayList<>();
    }

    @Override
    public void attach(IObserver iObserver) {
        iObservers.add(iObserver);
    }

    @Override
    public void detach(IObserver iObserver) {
        iObservers.remove(iObserver);
    }

    @Override
    public void notifyObservers() {
        for(IObserver iObserver : iObservers) {
            iObserver.update(this);
        }
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }

    public void tick() {
        // Update internal time-keeping state
        time++;
        notifyObservers();
    }

}
