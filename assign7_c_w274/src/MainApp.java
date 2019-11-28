/**
 * @author Cameron Whitfield
 * main driver class for assignment 7
 */
public class MainApp {

    public static void main(String[] args) {

        HomeBase homeBase = new HomeBase();

        FootSoldier chip = new FootSoldier();
        FootSoldier ted = new FootSoldier();
        ArmoredTank tankAlpha = new ArmoredTank();

        homeBase.registerObserver(tankAlpha);
        homeBase.registerObserver(ted);
        homeBase.registerObserver(chip);

        System.out.println("");
        homeBase.setUnderAttack(true);

        ted.setAttackBehavior(new AttackWithPlasmaRifle());

        System.out.println("");
        chip.move();
        tankAlpha.move();

        System.out.println("");
        homeBase.setUnderAttack(false);

        System.out.println("");
        homeBase.setUnderAttack(true);
    }
}
