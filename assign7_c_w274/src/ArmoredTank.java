/**
 * class that inherits from abstract class GamePiece. Initializes all behaviors
 * associated with the ArmoredTank
 */
public class ArmoredTank extends GamePiece {

    /**
     * constructor for Armored Tank. Sets attackBehavior to AttackWithCannon
     * sets defendBehavior to DefendWithForceField
     * sets moveBehavior to TankMove
     */
    public ArmoredTank() {
        attackBehavior = new AttackWithCannon();
        defendBehavior = new DefendWithForceField();
        moveBehavior = new TankMove();
    }


}
