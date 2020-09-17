package model.game.tower.concretetowers;

import model.game.enemy.Enemy;
import model.game.tower.AimingTower;
import model.game.tower.Tower;
import model.game.tower.TowerService;
import model.game.tower.TowerVisitor;
import utils.Vector;

import java.util.List;
import java.util.Random;

public class GrizzlyBear implements Tower {

    private final static int MAXCHARGE = 88;
    private final AimingTower baseTower;
    private final float range;
    private int charge;

    public GrizzlyBear(AimingTower baseTower) {
        this.baseTower = baseTower;
        this.range = 5;
        this.charge = 87;
    }

    @Override
    public TowerService getTowerService() {
        return baseTower.getTowerService();
    }

    @Override
    public Vector getPos() {
        return baseTower.getPos();
    }

    @Override
    public void update() {
        charge++;
        baseTower.update();
        if (charge >= MAXCHARGE) {
            Enemy currentEnemy = getEnemyToBeAttacked();
            if (currentEnemy != null) {
                attackEnemy(currentEnemy);
                charge = 0;
            } else {
                charge--;
            }
        }
    }

    @Override
    public float getRange() {
        return range;
    }

    @Override
    public List<? extends Enemy> getEnemiesInRange(float range) {
        return baseTower.getEnemiesInRange(range);
    }

    private Enemy getEnemyToBeAttacked() {
        List<? extends Enemy> enemiesInRange = getEnemiesInRange(range);
        if (!enemiesInRange.isEmpty()) {
            Random rand = new Random();
            int currentIndex = rand.nextInt(enemiesInRange.size());
            return enemiesInRange.get(currentIndex);
        }
        return null;
    }

    private void attackEnemy(Enemy currentEnemy) {
        baseTower.changeAngle(currentEnemy.getPos());
        getTowerService().addProjectile(getTowerService().getProjectileFactory().createRock(getPos().asVectorF(), baseTower.getAngle().setMagnitude(0.3f), 1));
//        currentEnemy.damage(1);
    }

    @Override
    public void accept(TowerVisitor visitor) {
        visitor.visit(this);
    }


}