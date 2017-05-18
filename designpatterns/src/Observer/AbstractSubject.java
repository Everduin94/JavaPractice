package Observer;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Erik Verduin
 */
abstract class AbstractSubject {

    private List<AbstractObserver> abstractObservers;

    public AbstractSubject() {
        abstractObservers = new ArrayList<>();
    }

    void attach(AbstractObserver abstractObserver) {
        abstractObservers.add(abstractObserver);
    }

    void detach(AbstractObserver abstractObserver) {
        abstractObservers.remove(abstractObserver);
    }

    List<AbstractObserver> getOberservers() {
        return abstractObservers;
    }

    void notifyObservers() {
        for(AbstractObserver abstractObserver : abstractObservers) {
            abstractObserver.update(this);
        }
    }
}
