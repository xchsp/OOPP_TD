package view.gameView.layers;

import config.Config;
import model.game.tower.Tower;
import model.game.tower.TowerVisitor;
import model.game.tower.concretetowers.*;
import utils.Vector;
import view.WindowState;
import view.texture.ImageHandler;

import java.awt.*;
import java.awt.image.BufferedImage;

/**
 * @author Oskar, Sebastian, Samuel, Erik
 * Display towers.
 * Is used by swingView.
 */

public class TowerDrawer implements TowerVisitor {

    private final Graphics graphics;
    private final WindowState windowState;

    public TowerDrawer(Graphics g, WindowState windowState) {
        graphics = g;
        this.windowState = windowState;
    }

    @Override
    public void visit(GrizzlyBear tower) {
        drawTower(tower.getPos(), tower.getAngle(), Config.ImagePath.GRIZZLY_BEAR);
    }

    @Override
    public void visit(BearryPotter tower) {
        drawTower(tower.getPos(), tower.getAngle(), Config.ImagePath.BEARRY_POTTER);
    }

    @Override
    public void visit(SniperBear tower) {
        drawTower(tower.getPos(), tower.getAngle(), Config.ImagePath.SNIPER_BEAR);
    }

    @Override
    public void visit(SovietBear tower) {
        drawTower(tower.getPos(), tower.getAngle(), Config.ImagePath.SOVIET_BEAR);
    }

    @Override
    public void visit(Barbearian tower) {
        drawTower(tower.getPos(), tower.getAngle(), Config.ImagePath.BARBEARIAN);
    }

    @Override
    public void visit(BearGrylls tower) {
        drawTower(tower.getPos(), Config.ImagePath.BEAR_GRYLLS);
    }

    @Override
    public void visit(Beer tower) {
        drawTower(tower.getPos(), Config.ImagePath.BEER_BEAR);
    }

    @Override
    public void visit(RubixCubeBear tower) {
        drawTower(tower.getPos(), Config.ImagePath.RUBIX_CUBE_BEAR);
    }

    @Override
    public void visit(BazookaBear tower) {
        drawTower(tower.getPos(), tower.getAngle(), Config.ImagePath.BAZOOKA_BEAR);
    }

    @Override
    public void visit(Bearon tower) {
        drawTower(tower.getPos(), Config.ImagePath.BEARON);
    }

    @Override
    public void visit(JustinBeeBear tower) {
        drawTower(tower.getPos(), tower.getAngle(), Config.ImagePath.JUSTINBEEBEAR);
    }


    private void drawTower(Vector pos, String path) {
        Vector defaultVector = new Vector(0, 1);
        drawTower(pos, defaultVector.getAngle(), path);
    }

    private void drawTower(Vector notRotatedPos, double angle, String path) {

        final double sin = Math.abs(Math.sin(angle));
        final double cos = Math.abs(Math.cos(angle));

        Vector pos = getRealPos(notRotatedPos);
        double width = windowState.getTileSize() * cos + windowState.getTileSize() * sin;
        int offset = (int) ((width - windowState.getTileSize()) / 2);
        BufferedImage image = ImageHandler.getImage(path, angle);

        graphics.drawImage(image, pos.getIntX() - offset, pos.getIntY() - offset, (int) width, (int) width, null);
    }

    private Vector getRealPos(Vector pos) {
        int x = (int) (windowState.getTileSize() * pos.x + windowState.getTileMapOffset().x);
        int y = (int) (windowState.getTileSize() * pos.y + windowState.getTileMapOffset().y);
        return new Vector(x, y);
    }

}
