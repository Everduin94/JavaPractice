package Observer;

/**
 * @author Erik Verduin
 */
public class SubjectTimer extends AbstractSubject {

    private int time = 0; //Extra stuff for testing

    public SubjectTimer() {

    }

    int getTime() {
        return time;
    }

    int getHour() {
        return 3;
    }

    int getMinute() {
        return 2;
    }

    int getSecond() {
        return 1;
    }

    public void tick() {
        // Update internal time-keeping state
        time++;
        notifyObservers();
    }

}
