package model.game;

import model.game.enemy.Enemy;
import model.game.projectile.Projectile;
import org.junit.jupiter.api.Test;
import utils.Vector;

import static model.game.Mock.createMockEnemy;
import static model.game.Mock.createStationaryProjectile;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * @author Oskar, Erik
 */
class CollisionDetectorTest {

    @Test
    void canCheckEnemyProjectileCollision() {
        Enemy e = createMockEnemy(new Vector(1, 1));
        Projectile p = createStationaryProjectile(new Vector(1, 1));
        assertTrue(CollisionDetector.isEnemyAndProjectileColliding(e, p));

        e = createMockEnemy(new Vector(1, 1));
        p = createStationaryProjectile(new Vector(10, 1));
        assertFalse(CollisionDetector.isEnemyAndProjectileColliding(e, p));
    }
}