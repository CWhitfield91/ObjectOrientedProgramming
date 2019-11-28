/**
 * class that inherits from GamePiece abstract class
 */
public class FootSoldier extends GamePiece {

    /**
     * constructor that initializes attackBehavior to AttackWithPhaser
     * initializes defendBehavior to DefendWithShield
     * initializes moveBehavior to SoldierMove
     */
    public FootSoldier() {
        attackBehavior = new AttackWithPhaser();
        defendBehavior = new DefendWithShield();
        moveBehavior = new SoldierMove();
    }


}
