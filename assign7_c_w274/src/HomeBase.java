import java.util.ArrayList;

/**
 * class for HomeBase, implements the subject interface
 */
public class HomeBase implements Subject {

    private ArrayList observers = new ArrayList();
    private boolean underAttack;

    /**
     * registers(adds) all observers to the observers array list
     * @param o the observing object that is to be added to the array list
     */
    public void registerObserver(Observer o) {
        observers.add(o);
    }

    /**
     * removes observers from the array list
     * @param o the observing object that is to be removed from the array list
     */
    public void removeObserver(Observer o) {
        int i = observers.indexOf(o);
        if (i >= 0) {
            observers.remove(i);
        }
    }

    /**
     * notifies all observer objects of a status change to either attack or defend
     * depending on the change
     * @param underAttack boolean that determines if observers are to attack or defend
     */
    public void notifyObservers(boolean underAttack) {
        if (underAttack == true) {
            for (int i = 0; i < observers.size(); i++) {
                Observer observer = (Observer) observers.get(i);
                observer.defend();
            }
        } else {
            for (int i = 0; i < observers.size(); i++) {
                Observer observer = (Observer) observers.get(i);
                observer.attack();
            }
        }
    }

    /**
     * setter for the underAttack variable. Calls the notifyObservers method immediately
     * after variable is set
     * @param underAttack underAttack variable is set to this parameter
     */
    public void setUnderAttack(boolean underAttack) {
        this.underAttack = underAttack;
        notifyObservers(this.underAttack);
    }
}