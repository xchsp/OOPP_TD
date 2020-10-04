package model.game.enemy.concreteenemies;

import model.game.enemy.AbstractEnemy;
import model.game.enemy.BaseDamager;
import model.game.enemy.EnemyVisitor;
import model.game.enemy.PathIterator;

import static application.PropertyValues.EnemyStats.*;

/**
 * @author Oskar, Sebastian, Behroz, Samuel, Erik
 * A class for all enemies which only differ in health and speed.
 */
public abstract class BasicEnemy extends AbstractEnemy {
    public static final int BASE_HEALTH = 20;
    public static final double BASE_SPEED = 0.01;

    private BasicEnemy(BaseDamager baseDamager, PathIterator pathIterator, double healthMultiplier, double speedMultiplier) {
        super(baseDamager, pathIterator, (int) (BASE_HEALTH * healthMultiplier), BASE_SPEED * speedMultiplier);
    }

    public static class Fishstick extends BasicEnemy {

        public Fishstick(BaseDamager baseDamager, PathIterator pathIterator) {
            super(baseDamager, pathIterator, FISHSTICK_HEALTH, FISHSTICK_SPEED);
        }

        @Override
        public void accept(EnemyVisitor visitor) {
            visitor.visit(this);
        }
    }

    public static class Swordfish extends BasicEnemy {

        public Swordfish(BaseDamager baseDamager, PathIterator pathIterator) {
            super(baseDamager, pathIterator, SWORDFISH_HEALTH, SWORDFISH_SPEED);
        }

        @Override
        public void accept(EnemyVisitor visitor) {
            visitor.visit(this);
        }
    }

    public static class FishAndChips extends BasicEnemy {

        public FishAndChips(BaseDamager baseDamager, PathIterator pathIterator) {
            super(baseDamager, pathIterator, FISH_AND_CHIPS_HEALTH, FISH_AND_CHIPS_SPEED);
        }

        @Override
        public void accept(EnemyVisitor visitor) {
            visitor.visit(this);
        }
    }

    public static class FishInABoat extends BasicEnemy {

        public FishInABoat(BaseDamager baseDamager, PathIterator pathIterator) {
            super(baseDamager, pathIterator, FISH_IN_A_BOAT_HEALTH, FISH_IN_A_BOAT_SPEED);
        }

        @Override
        public void accept(EnemyVisitor visitor) {
            visitor.visit(this);
        }
    }

    public static class Sailfish extends BasicEnemy {

        public Sailfish(BaseDamager baseDamager, PathIterator pathIterator) {
            super(baseDamager, pathIterator, SAILFISH_HEALTH, SAILFISH_SPEED);
        }

        @Override
        public void accept(EnemyVisitor visitor) {
            visitor.visit(this);
        }
    }

    public static class Shark extends BasicEnemy {

        public Shark(BaseDamager baseDamager, PathIterator pathIterator) {
            super(baseDamager, pathIterator, SHARK_HEALTH, SHARK_SPEED);
        }

        @Override
        public void accept(EnemyVisitor visitor) {
            visitor.visit(this);
        }
    }

    public static class FishInAFishTank extends BasicEnemy {

        public FishInAFishTank(BaseDamager baseDamager, PathIterator pathIterator) {
            super(baseDamager, pathIterator, FISH_IN_A_FISH_TANK_HEALTH, FISH_IN_A_FISH_TANK_SPEED);
        }

        @Override
        public void accept(EnemyVisitor visitor) {
            visitor.visit(this);
        }
    }
}
