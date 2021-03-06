package view.particles;

import config.Config;
import utils.Vector;
import view.particles.distribution.LinearDoubleDistribution;
import view.particles.distribution.LinearIntegerDistribution;
import view.particles.distribution.LinearVectorDistribution;

/**
 * @author Oskar, Samuel, Erik
 * Factory for creating particle emitters
 * Is used by particleHandler
 */
public final class EmitterFactory {

    private EmitterFactory() {
    }

    static Emitter createRockEmitter(Vector position, double angle) {
        return new Emitter.Builder()
                .setEmitterPosition(position)
                .setImagePath(Config.ImagePath.ROCK)
                .setLifetimeDistribution(LinearIntegerDistribution.fromRange(10, 20))
                .setStartPosition(LinearVectorDistribution.withAnyAngle(() -> 0.1))
                .setStartVelocity(LinearVectorDistribution.withAnyAngle(LinearDoubleDistribution.fromRange(0.001, 0.02)))
                .setEmitterLifetime(10)
                .setNewParticlesPerUpdate(LinearIntegerDistribution.fromRange(0, 3))
                .build();
    }

    static Emitter createBombardaEmitter(Vector position, double angle) {
        return new Emitter.Builder()
                .setEmitterPosition(position)
                .setImagePath(Config.ImagePath.BOMBARDA_CHARM)
                .setLifetimeDistribution(LinearIntegerDistribution.fromRange(10, 20))
                .setStartPosition(LinearVectorDistribution.withAnyAngle(() -> 0.3))
                .setStartVelocity(LinearVectorDistribution.withAnyAngle(LinearDoubleDistribution.fromRange(0.08, 0.1)))
                .setEmitterLifetime(3)
                .setNewParticlesPerUpdate(LinearIntegerDistribution.fromRange(10, 20))
                .setTileSize(LinearDoubleDistribution.fromRange(0.1, 0.2))
                .build();
    }

    static Emitter createSniperSmokeEmitter(Vector position, double angle) {
        return new Emitter.Builder()
                // Slightly offsets emitter position to make the smoke come from the gun instead of the center
                .setEmitterPosition(position.plus(Vector.fromPolar(angle, 0.5)))
                .setImagePath(Config.ImagePath.SMOKE)
                .setLifetimeDistribution(LinearIntegerDistribution.fromRange(20, 30))
                .setStartPosition(LinearVectorDistribution.withAnyAngle(() -> 0.1))
                .setStartVelocity(LinearVectorDistribution.fromAngleAndMagnitude(
                        LinearDoubleDistribution.fromMidPoint(angle, Math.PI / 10),
                        LinearDoubleDistribution.fromRange(0.01, 0.05))
                )
                .setEmitterLifetime(1)
                .setNewParticlesPerUpdate(LinearIntegerDistribution.fromRange(20, 30))
                .setTileSize(LinearDoubleDistribution.fromRange(0.07, 0.14))
                .build();
    }

    static Emitter createBulletEmitter(Vector position, double angle) {
        return new Emitter.Builder()
                .setEmitterPosition(position)
                .setImagePath(Config.ImagePath.BULLET)
                .setLifetimeDistribution(LinearIntegerDistribution.fromRange(15, 15))
                .setStartPosition(LinearVectorDistribution.withAnyAngle(() -> 0.3))
                .setStartVelocity(LinearVectorDistribution.withAnyAngle(LinearDoubleDistribution.fromRange(0.001, 0.01)))
                .setEmitterLifetime(1)
                .setNewParticlesPerUpdate(LinearIntegerDistribution.fromRange(1, 1))
                .setTileSize(LinearDoubleDistribution.fromRange(0.05, 0.05))
                .build();
    }

    static Emitter createSwingEmitter(Vector position, double angle) {
        return new Emitter.Builder()
                .setEmitterPosition(position)
                .setImagePath(Config.ImagePath.AXE)
                .setLifetimeDistribution(LinearIntegerDistribution.fromRange(20, 20))
                .setStartPosition(LinearVectorDistribution.withAnyAngle(() -> 0.5))
                .setStartVelocity(LinearVectorDistribution.withAnyAngle(LinearDoubleDistribution.fromRange(0.001, 0.01)))
                .setStartAngle(LinearDoubleDistribution.fromRange(0, Math.PI * 2))
                .setAngleVelocity(LinearDoubleDistribution.fromRange(0, Math.PI * 0.01))
                .setEmitterLifetime(1)
                .setNewParticlesPerUpdate(LinearIntegerDistribution.fromRange(1, 1))
                .setTileSize(LinearDoubleDistribution.fromRange(0.3, 0.3))
                .build();
    }

    static Emitter createCompassEmitter(Vector position, double angle) {
        return new Emitter.Builder()
                .setEmitterPosition(position)
                .setImagePath(Config.ImagePath.COMPASS)
                .setLifetimeDistribution(LinearIntegerDistribution.fromRange(30, 30))
                .setStartPosition(LinearVectorDistribution.withAnyAngle(() -> 0.0))
                .setStartVelocity(LinearVectorDistribution.withAnyAngle(LinearDoubleDistribution.fromRange(0.0, 0.0)))
                .setAngleVelocity(LinearDoubleDistribution.fromRange(0, 0))
                .setEmitterLifetime(1)
                .setNewParticlesPerUpdate(LinearIntegerDistribution.fromRange(1, 1))
                .setTileSize(LinearDoubleDistribution.fromRange(0.5, 0.5))
                .build();
    }

    static Emitter createBeerEmitter(Vector position, double angle) {
        return new Emitter.Builder()
                .setEmitterPosition(position)
                .setImagePath(Config.ImagePath.BEER)
                .setLifetimeDistribution(LinearIntegerDistribution.fromRange(30, 30))
                .setStartPosition(LinearVectorDistribution.withAnyAngle(() -> 0.0))
                .setStartVelocity(LinearVectorDistribution.withAnyAngle(LinearDoubleDistribution.fromRange(0.0, 0.0)))
                .setAngleVelocity(LinearDoubleDistribution.fromRange(0, 0))
                .setEmitterLifetime(1)
                .setNewParticlesPerUpdate(LinearIntegerDistribution.fromRange(1, 1))
                .setTileSize(LinearDoubleDistribution.fromRange(0.5, 0.5))
                .build();
    }

    static Emitter createRubixCubeEmitter(Vector position, double angle) {
        return new Emitter.Builder()
                .setEmitterPosition(position)
                .setImagePath(Config.ImagePath.RUBIX_CUBE)
                .setLifetimeDistribution(LinearIntegerDistribution.fromRange(30, 30))
                .setStartPosition(LinearVectorDistribution.withAnyAngle(() -> 0.0))
                .setStartVelocity(LinearVectorDistribution.withAnyAngle(LinearDoubleDistribution.fromRange(0.0, 0.0)))
                .setAngleVelocity(LinearDoubleDistribution.fromRange(0, 0))
                .setEmitterLifetime(1)
                .setNewParticlesPerUpdate(LinearIntegerDistribution.fromRange(1, 1))
                .setTileSize(LinearDoubleDistribution.fromRange(0.5, 0.5))
                .build();
    }

    public static Emitter createExplosionEmitter(Vector position, double angle) {
        return new Emitter.Builder()
                .setEmitterPosition(position)
                .setImagePath(Config.ImagePath.EXPLOSION)
                .setLifetimeDistribution(LinearIntegerDistribution.fromRange(10, 20))
                .setStartPosition(LinearVectorDistribution.withAnyAngle(() -> 0.01))
                .setStartVelocity(LinearVectorDistribution.withAnyAngle(LinearDoubleDistribution.fromRange(0.05, 0.1)))
                .setEmitterLifetime(5)
                .setNewParticlesPerUpdate(LinearIntegerDistribution.fromRange(5, 10))
                .setTileSize(LinearDoubleDistribution.fromRange(0.5, 0.5))
                .build();
    }

    public static Emitter createMoneyEmitter(Vector position, double angle) {
        return new Emitter.Builder()
                .setEmitterPosition(position)
                .setImagePath(Config.ImagePath.MONEY)
                .setLifetimeDistribution(LinearIntegerDistribution.fromRange(15, 15))
                .setStartPosition(LinearVectorDistribution.withAnyAngle(() -> 0.0))
                .setStartVelocity(LinearVectorDistribution.withAnyAngle(LinearDoubleDistribution.fromRange(0.01, 0.05)))
                .setAngleVelocity(LinearDoubleDistribution.fromRange(0, 0))
                .setEmitterLifetime(5)
                .setNewParticlesPerUpdate(LinearIntegerDistribution.fromRange(5, 5))
                .setTileSize(LinearDoubleDistribution.fromRange(0.2, 0.2))
                .build();
    }

    public static Emitter createBeeEmitter(Vector position, double angle) {
        return new Emitter.Builder()
                .setEmitterPosition(position)
                .setImagePath(Config.ImagePath.BEE)
                .setLifetimeDistribution(LinearIntegerDistribution.fromRange(15, 15))
                .setStartPosition(LinearVectorDistribution.withAnyAngle(() -> 0.0))
                .setStartVelocity(LinearVectorDistribution.withAnyAngle(LinearDoubleDistribution.fromRange(0.01, 0.1)))
                .setAngleVelocity(LinearDoubleDistribution.fromRange(0, 0))
                .setEmitterLifetime(2)
                .setNewParticlesPerUpdate(LinearIntegerDistribution.fromRange(3, 3))
                .setTileSize(LinearDoubleDistribution.fromRange(0.1, 0.1))
                .build();
    }
}
