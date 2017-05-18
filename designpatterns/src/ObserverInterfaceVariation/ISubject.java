package ObserverInterfaceVariation;

import java.util.List;

/**
 * @author Erik Verduin
 */
interface ISubject {

    void attach(IObserver iObserver);

    void detach(IObserver iObserver);

    void notifyObservers();
}
