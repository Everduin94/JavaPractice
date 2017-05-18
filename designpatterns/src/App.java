import Observer.ObserverAnalog;
import Observer.SubjectTimer;
import Observer.ObserverDigital;
import ObserverInterfaceVariation.ObserverAnalogI;
import ObserverInterfaceVariation.ObserverDigitalI;
import ObserverInterfaceVariation.SubjectTimerI;
import Strategy.Composition;
import Strategy.concreteImpl.SimpleCompositor;
import Strategy.concreteImpl.TeXCompositor;

/**
 * @author Erik Verduin
 */
public class App {
    public static void main(String[] args) {
        strategyExample();
    }

    private static void strategyExample() {
        Composition quick = new Composition(new SimpleCompositor());
        quick.repair();
        Composition slick = new Composition(new TeXCompositor());
        slick.repair();
    }


    private static void observerExample() {
        SubjectTimer timer = new SubjectTimer();
        ObserverAnalog observerAnalog = new ObserverAnalog(timer);
        ObserverDigital observerDigital = new ObserverDigital(timer);

        timer.tick();
        timer.tick();
    }

    private static void interfaceObserverExample() {
        SubjectTimerI subjectTimerI = new SubjectTimerI();
        ObserverAnalogI observerAnalogI = new ObserverAnalogI(subjectTimerI);
        ObserverDigitalI observerDigitalI = new ObserverDigitalI(subjectTimerI);

        subjectTimerI.tick();

        observerAnalogI.manuallyAdjustTime(14);

        subjectTimerI.tick();
    }
}
