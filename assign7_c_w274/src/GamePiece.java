/**
 * abstract parent class for FootSoldier and ArmoredTank
 * implements the Observer interface
 */
public abstract class GamePiece implements Observer {
    AttackBehavior attackBehavior;
    DefendBehavior defendBehavior;
    MoveBehavior moveBehavior;

    /**
     * default constructor
     */
    public GamePiece() {

    }

    /**
     * setter for attackBehavior
     * @param ab attackBehavior is set to the variable ab
     */
    public void setAttackBehavior(AttackBehavior ab) {
        attackBehavior = ab;
    }

    /**
     * setter for defendBehavior
     * @param db defendBehavior is set to variable db
     */
    public void setDefendBehavior(DefendBehavior db) {
        defendBehavior = db;
    }

    /**
     * setter for moveBehavior
     * @param mb moveBehavior is set to the variable mb
     */
    public void setMoveBehavior(MoveBehavior mb) {
        moveBehavior = mb;
    }

    /**
     * attack needed for Observer interface
     * performs the attack that is set by the setAttackBehavior method
     */
    public void attack() {
        attackBehavior.attack();
    }

    /**
     * defend method needed for Observer interface
     * performs the defend behavior that is set by the setDefendBehavior method
     */
    public void defend() {
        defendBehavior.defend();
    }

    /**
     * move method
     * performs the move behavior that is set by the setMoveBehavior method
     */
    public void move() {
        moveBehavior.move();
    }
}
