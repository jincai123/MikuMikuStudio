/*
 * Created on 4 ao�t 2004
 */
package jmetest.sound;

import java.net.URL;

import jmetest.effects.RenParticleEditor;

import com.jme.app.SimpleGame;
import com.jme.bounding.BoundingBox;
import com.jme.effects.ParticleManager;
import com.jme.image.Texture;
import com.jme.input.KeyBindingManager;
import com.jme.input.KeyInput;
import com.jme.input.action.AbstractInputAction;
import com.jme.intersection.Intersection;
import com.jme.math.Vector3f;
import com.jme.renderer.ColorRGBA;
import com.jme.scene.Controller;
import com.jme.scene.Node;
import com.jme.scene.shape.Box;
import com.jme.scene.shape.Sphere;
import com.jme.scene.state.AlphaState;
import com.jme.scene.state.TextureState;
import com.jme.sound.SoundAPIController;
import com.jme.sound.SoundPool;
import com.jme.sound.scene.ProgrammableSound;
import com.jme.sound.scene.SoundNode;
import com.jme.ui.UIText;
import com.jme.util.TextureManager;

/**
 * @author Arman OZCELIK
 *  
 */
public class PongRevisited extends SimpleGame {

    private Box player;

    private Box computer;

    private Sphere ball;

    private Box lowerWall;

    private Box upperWall;

    private Node particleNode;

    private ParticleManager manager, bmanager;

    private SoundNode snode;

    private ProgrammableSound ballSound;

    private static final int BOUNCE_EVENT = 1;

    private static final int WALL_BOUNCE_EVENT = 2;

    private static final int MISS_EVENT = 3;

    private float ballXSpeed = -5f;

    private float ballYSpeed = 0.0f;

    private int difficulty = 10;

    private UIText playerScoreText, computerScoreText;

    private int computerScore, playerScore;

    private Node uiNode;
    
    

    protected void simpleInitGame() {
        SoundAPIController.getSoundSystem(properties.getRenderer());
        SoundAPIController.getRenderer().setCamera(cam);

        snode = new SoundNode();
        uiNode = new Node("UINODE");
        playerScoreText = new UIText("UINODE", "jmetest/data/font/conc_font.png", 600,
                0, 1.0f, 50.0f, 5.0f);
        computerScoreText = new UIText("UINODE", "jmetest/data/font/conc_font.png",
                100, 0, 1.0f, 50.0f, 5.0f);
        playerScoreText.setText("Player : 0");
        computerScoreText.setText("Computer : 0");
        uiNode.attachChild(playerScoreText);
        uiNode.attachChild(computerScoreText);

        display.getRenderer().setBackgroundColor(new ColorRGBA(0, 0, 0, 1));

        cam.setFrustum(1f, 5000F, -0.55f, 0.55f, 0.4125f, -0.4125f);

        Vector3f loc = new Vector3f(0, 0, -850);

        Vector3f left = new Vector3f(1, 0, 0);
        Vector3f up = new Vector3f(0, 1, 0f);
        Vector3f dir = new Vector3f(0, 0, 1);
        cam.setFrame(loc, left, up, dir);

        display.getRenderer().setCamera(cam);

        player = new Box("Player", new Vector3f(0, 0, 0), 5f, 50f, 5f);
        player.getLocalTranslation().x = -400;
        player.setModelBound(new BoundingBox());
        player.updateModelBound();

        computer = new Box("Computer", new Vector3f(0, 0, 0), 5f, 50f, 5f);
        computer.getLocalTranslation().x = 400;
        computer.setModelBound(new BoundingBox());
        computer.updateModelBound();

        ball = new Sphere("Ball", 15, 15, 5f);
        ball.setModelBound(new BoundingBox());
        ball.getLocalTranslation().z = -00f;
        ball.updateModelBound();

        ballSound = new ProgrammableSound();
        /*URL laserURL = PongRevisited.class.getClassLoader().getResource(
                "data/sound/ESPARK.wav");
                */
        URL explodeURL = PongRevisited.class.getClassLoader().getResource(
                "jmetest/data/sound/explosion.wav");
        URL wallURL = PongRevisited.class.getClassLoader().getResource(
                "jmetest/data/sound/turn.wav");
        //ballSound.bindEvent(BOUNCE_EVENT, SoundPool
          //      .compile(new URL[] { laserURL }));
        ballSound.bindEvent(MISS_EVENT, SoundPool
                .compile(new URL[] { explodeURL }));
        ballSound.bindEvent(WALL_BOUNCE_EVENT, SoundPool
                .compile(new URL[] { wallURL }));
        ballSound.setMaxDistance(5000);
        snode.attachChild(ballSound);

        lowerWall = new Box("Left Wall", new Vector3f(0, -300, 0), 450f, 5f, 5f);
        lowerWall.setModelBound(new BoundingBox());
        lowerWall.updateModelBound();

        upperWall = new Box("Right Wall", new Vector3f(0, 300, 0), 450f, 5f, 5f);
        upperWall.setModelBound(new BoundingBox());
        upperWall.updateModelBound();
        
        
        manager = new ParticleManager(300, display.getRenderer().getCamera());
        manager.setGravityForce(new Vector3f(0.0f, 0.0f, 0.0f));
        manager.setEmissionDirection(new Vector3f(0.0f, 1.0f, 0.0f));
        manager.setEmissionMaximumAngle(3.1415927f);
        manager.setSpeed(1.4f);
        manager.setParticlesMinimumLifeTime(1000.0f);
        manager.setStartSize(5.0f);
        manager.setEndSize(5.0f);
        manager.setStartColor(new ColorRGBA(1.0f, 0.312f, 0.121f, 1.0f));
        manager.setEndColor(new ColorRGBA(1.0f, 0.24313726f, 0.03137255f, 0.0f));
        manager.setRandomMod(0.0f);
        manager.setControlFlow(false);
        manager.setReleaseRate(300);
        manager.setReleaseVariance(0.0f);
        manager.setInitialVelocity(1.0f);
        manager.setParticleSpinSpeed(0.0f);

        manager.warmUp(1000);
        manager.getParticles().addController(manager);
        
        
        
        bmanager = new ParticleManager(100, display.getRenderer().getCamera());
        bmanager.setGravityForce(new Vector3f(0.0f, 0.0f, 0.0f));
        bmanager.setEmissionDirection(new Vector3f(-1.0f, 0.0f, 0.0f));
        bmanager.setEmissionMaximumAngle(0.1f);
        bmanager.setSpeed(0.4f);
        bmanager.setParticlesMinimumLifeTime(100.0f);
        bmanager.setStartSize(5.0f);
        bmanager.setEndSize(5.0f);
        bmanager.setStartColor(new ColorRGBA(1.0f, 0.312f, 0.121f, 1.0f));
        bmanager.setEndColor(new ColorRGBA(1.0f, 0.24313726f, 0.03137255f, 0.0f));
        bmanager.setRandomMod(0.0f);
        bmanager.setControlFlow(false);
        bmanager.setReleaseRate(300);
        bmanager.setReleaseVariance(0.0f);
        bmanager.setInitialVelocity(0.3f);
        bmanager.setParticleSpinSpeed(-0.5f);

        bmanager.warmUp(1000);
        bmanager.getParticles().addController(bmanager);

       
        
        
        
        AlphaState as1 = display.getRenderer().createAlphaState();
        as1.setBlendEnabled(true);
        as1.setSrcFunction(AlphaState.SB_SRC_ALPHA);
        as1.setDstFunction(AlphaState.DB_ONE);
        as1.setTestEnabled(true);
        as1.setTestFunction(AlphaState.TF_GREATER);
        as1.setEnabled(true);

        TextureState ts = display.getRenderer().createTextureState();
        ts.setTexture(
            TextureManager.loadTexture(
            RenParticleEditor.class.getClassLoader().getResource(
            "jmetest/data/texture/flaresmall.jpg"),
            Texture.MM_LINEAR_LINEAR,
            Texture.FM_LINEAR,
            true));
        ts.setEnabled(true);
        manager.setRepeatType(Controller.RT_CLAMP);
        Node myNode = new Node("Particle Nodes");
        myNode.setRenderState(as1);
        myNode.setRenderState(ts);
        Node mybNode = new Node("Particle Nodes");
        mybNode.setRenderState(as1);
        mybNode.setRenderState(ts);
        
        mybNode.attachChild(bmanager.getParticles());
        myNode.attachChild(manager.getParticles());
        
        rootNode.attachChild(myNode);
        rootNode.attachChild(mybNode);
        
        rootNode.attachChild(player);
        lightState.setEnabled(!lightState.isEnabled());
        rootNode.attachChild(computer);
        rootNode.attachChild(lowerWall);
        rootNode.attachChild(upperWall);
        rootNode.attachChild(ball);
        rootNode.attachChild(uiNode);

        input.setMouseSpeed(0);
        input.setKeySpeed(40);

        input.addKeyboardAction("moveUp", KeyInput.KEY_UP, new MoveUpAction());
        input.addKeyboardAction("moveDown", KeyInput.KEY_DOWN,
                new MoveDownAction());
        //KeyBindingManager.getKeyBindingManager().remove("forward");
        //KeyBindingManager.getKeyBindingManager().remove("backward");
        KeyBindingManager.getKeyBindingManager().remove("lookUp");
        KeyBindingManager.getKeyBindingManager().remove("lookDown");

    }

    public void simpleUpdate() {
        manager.setRepeatType(Controller.RT_CLAMP);
        if (checkPlayer()) {
            ballSound.setPosition(cam.getLocation().x - 5, cam.getLocation().y,
                    cam.getLocation().z);
            snode.onEvent(WALL_BOUNCE_EVENT);
        }
        if (checkComputer()) {
            ballSound.setPosition(cam.getLocation().x + 5, cam.getLocation().y,
                    cam.getLocation().z);
            snode.onEvent(WALL_BOUNCE_EVENT);
        }

        if (checkWalls()) {
            ballSound.setPosition(cam.getLocation().x + 5, cam.getLocation().y,
                    cam.getLocation().z);
            snode.onEvent(WALL_BOUNCE_EVENT);
        }
        moveBall();
        moveComputer();

        if (ball.getLocalTranslation().x < player.getWorldTranslation().x) {

            ballSound.setPosition(cam.getLocation().x - 5, cam.getLocation().y,
                    cam.getLocation().z);
            ballSound.fireEvent(MISS_EVENT);
            computerScoreText.setText("Computer : " + (++computerScore));
            manager.setRepeatType(Controller.RT_WRAP);
            manager.forceRespawn();
            manager.getParticles().setLocalTranslation(new Vector3f(ball.getLocalTranslation().x, ball.getLocalTranslation().y, ball.getLocalTranslation().z));
            reset();
            
            
        }
        if (ball.getLocalTranslation().x > computer.getWorldTranslation().x) {

            ballSound.setPosition(cam.getLocation().x - 5, cam.getLocation().y,
                    cam.getLocation().z);
            ballSound.fireEvent(MISS_EVENT);
            playerScoreText.setText("Player : " + (++playerScore));
            manager.setRepeatType(Controller.RT_WRAP);
            manager.forceRespawn();
            manager.getParticles().setLocalTranslation(new Vector3f(ball.getLocalTranslation().x, ball.getLocalTranslation().y, ball.getLocalTranslation().z));
            if(difficulty>2) difficulty--;
            reset();
            
        }
        fps.print("");
        snode.updateGeometricState(tpf, true);

        super.simpleUpdate();

    }

    /**
     *  
     */
    private void moveBall() {
        ball.getLocalTranslation().x += ballXSpeed;
        ball.getLocalTranslation().y += ballYSpeed;
        bmanager.getParticles().getLocalTranslation().x=ball.getLocalTranslation().x;
        bmanager.getParticles().getLocalTranslation().y=ball.getLocalTranslation().y;
        if(ballXSpeed < 0){
            bmanager.setEmissionDirection(new Vector3f(1,ballYSpeed, 0));
        }else{
            bmanager.setEmissionDirection(new Vector3f(-1,-ballYSpeed, 0));
        }
    }

    private void moveComputer() {
        float dist = Math.abs(ball.getLocalTranslation().y
                - computer.getLocalTranslation().y);
        if (ballXSpeed > 0) {
            if (computer.getLocalTranslation().y < ball.getLocalTranslation().y) {
                computer.getLocalTranslation().y += Math
                        .rint(dist / difficulty);
            } else {
                computer.getLocalTranslation().y -= Math
                        .rint(dist / difficulty);
            }
        } else {
            if (computer.getLocalTranslation().y < 0)
                computer.getLocalTranslation().y += 2;
            else if (computer.getLocalTranslation().y > 0)
                computer.getLocalTranslation().y -= 2;
        }

    }

    private boolean checkPlayer() {
        if (Intersection.intersection(ball.getWorldBound(), player
                .getWorldBound())) {

            ballXSpeed = 0 - ballXSpeed;

            float racketHit = (ball.getLocalTranslation().y - (player
                    .getLocalTranslation().y));

            ballYSpeed += (racketHit / 4);
            return true;
        }
        return false;
    }

    public boolean checkComputer() {
        if (Intersection.intersection(ball.getWorldBound(), computer
                .getWorldBound())) {
            ballXSpeed = 0 - ballXSpeed;
            ballSound.setPosition(cam.getLocation().x - 5, cam.getLocation().y,
                    cam.getLocation().z);
            float racketHit = (ball.getLocalTranslation().y - (computer
                    .getLocalTranslation().y));
            
            ballYSpeed += (racketHit / 4);
            return true;

        }
        return false;
    }

    public boolean checkWalls() {
        if (Intersection.intersection(ball.getWorldBound(), lowerWall
                .getWorldBound())) {
            ballYSpeed = 0 - ballYSpeed;
            return true;
        }
        if (Intersection.intersection(ball.getWorldBound(), upperWall
                .getWorldBound())) {
            ballYSpeed = 0 - ballYSpeed;
            return true;
        }
        return false;
    }

    public void simpleRender() {

        SoundAPIController.getRenderer().draw(snode);
        display.getRenderer().draw(particleNode);

        super.simpleRender();
    }

    public static void main(String[] args) {
        PongRevisited app = new PongRevisited();
        app.setDialogBehaviour(ALWAYS_SHOW_PROPS_DIALOG);
        app.start();
    }

    private void reset() {
        player.getLocalTranslation().x = -400;
        player.getLocalTranslation().y = 0;
        player.getLocalTranslation().z = 0;

        computer.getLocalTranslation().x = 400;
        computer.getLocalTranslation().y = 0;
        computer.getLocalTranslation().z = 0;

        ball.getLocalTranslation().x = 0;
        ball.getLocalTranslation().y = 0;
        ball.getLocalTranslation().z = 0;

        ballXSpeed = 5f;
        ballYSpeed = 0;
    }

    class MoveUpAction extends AbstractInputAction {
        int numBullets;

        MoveUpAction() {
            setAllowsRepeats(true);
        }

        public void performAction(float time) {
            player.getLocalTranslation().y += 5;

        }
    }

    class MoveDownAction extends AbstractInputAction {
        int numBullets;

        MoveDownAction() {
            setAllowsRepeats(true);
        }

        public void performAction(float time) {
            player.getLocalTranslation().y -= 5;

        }
    }

}