/**
 * interface for Subject objects
 */
public interface Subject {

    /**
     * registerObserver method used by subject objects
     * @param o variable that holds observer objects to be registered
     */
    void registerObserver(Observer o);

    /**
     * removeObserver method used by subject objects
     * @param o observer to be removed from the array list
     */
    void removeObserver(Observer o);

    /**
     * notifyObservers method used by subject objects
     * @param u boolean value that observers react to
     */
    void notifyObservers(boolean u);
}
