package hangman;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Frame;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.logging.Logger;

/**
 *
 * @author Yash Nainsukha
 */
public class HangmanCanvas extends Frame {

    /* Constants for the simple version of the picture (in pixels) */
    private static final int SCAFFOLD_HEIGHT = 360;
    private static final int BEAM_LENGTH = 144;
    private static final int ROPE_LENGTH = 18;
    private static final int HEAD_RADIUS = 36;
    private static final int BODY_LENGTH = 144;
    private static final int ARM_OFFSET_FROM_HEAD = 28;
    private static final int UPPER_ARM_LENGTH = 72;
    private static final int LOWER_ARM_LENGTH = 44;
    private static final int HIP_WIDTH = 36;
    private static final int LEG_LENGTH = 108;
    private static final int FOOT_LENGTH = 28;
    static int task = 0;
    static boolean guess = true;
    Logger Log = Logger.getLogger(HangmanCanvas.class.getName());

    public HangmanCanvas() {
        super("Hangman");
        prepareGUI();
    }

    private void prepareGUI() {
        setSize(500, 700);
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent windowEvent) {
                System.exit(0);
            }
        });
    }

    /**
     * Draw scaffold, rope, man and words
     */
    @Override
    public void paint(Graphics g) {
        g.drawLine(100, 150, 100, SCAFFOLD_HEIGHT + 150);
        g.drawLine(100, 150, 100 + BEAM_LENGTH, 150);
        g.drawLine(100 + BEAM_LENGTH, 150, 100 + BEAM_LENGTH, 150 + ROPE_LENGTH);
        if (task == 1) {
            g.setColor(Color.MAGENTA);
            Font font = new Font("Serif", Font.PLAIN, 18);
            g.setFont(font);
            g.drawString(HangmanPlay.guessWord.toString(), 150, 550);
            g.setColor(Color.red);
            g.drawString(HangmanPlay.wrongChars, 50, 600);
            switch (HangmanPlay.tries) {
                case 0:
                    //right foot
                    g.setColor(Color.DARK_GRAY);
                    g.drawLine(100 + BEAM_LENGTH + HIP_WIDTH, 150 + ROPE_LENGTH + HEAD_RADIUS * 2 + BODY_LENGTH + LEG_LENGTH, 100 + BEAM_LENGTH + HIP_WIDTH + FOOT_LENGTH, 150 + ROPE_LENGTH + HEAD_RADIUS * 2 + BODY_LENGTH + LEG_LENGTH);
                case 1:
                    //left foot
                    g.setColor(Color.DARK_GRAY);
                    g.drawLine(100 + BEAM_LENGTH - HIP_WIDTH, 150 + ROPE_LENGTH + HEAD_RADIUS * 2 + BODY_LENGTH + LEG_LENGTH, 100 + BEAM_LENGTH - HIP_WIDTH - FOOT_LENGTH, 150 + ROPE_LENGTH + HEAD_RADIUS * 2 + BODY_LENGTH + LEG_LENGTH);
                case 2:
                    //right leg
                    g.setColor(Color.DARK_GRAY);
                    g.drawLine(100 + BEAM_LENGTH, 150 + ROPE_LENGTH + HEAD_RADIUS * 2 + BODY_LENGTH, 100 + BEAM_LENGTH + HIP_WIDTH, 150 + ROPE_LENGTH + HEAD_RADIUS * 2 + BODY_LENGTH);
                    g.drawLine(100 + BEAM_LENGTH + HIP_WIDTH, 150 + ROPE_LENGTH + HEAD_RADIUS * 2 + BODY_LENGTH, 100 + BEAM_LENGTH + HIP_WIDTH, 150 + ROPE_LENGTH + HEAD_RADIUS * 2 + BODY_LENGTH + LEG_LENGTH);
                case 3:
                    //left leg
                    g.setColor(Color.DARK_GRAY);
                    g.drawLine(100 + BEAM_LENGTH, 150 + ROPE_LENGTH + HEAD_RADIUS * 2 + BODY_LENGTH, 100 + BEAM_LENGTH - HIP_WIDTH, 150 + ROPE_LENGTH + HEAD_RADIUS * 2 + BODY_LENGTH);
                    g.drawLine(100 + BEAM_LENGTH - HIP_WIDTH, 150 + ROPE_LENGTH + HEAD_RADIUS * 2 + BODY_LENGTH, 100 + BEAM_LENGTH - HIP_WIDTH, 150 + ROPE_LENGTH + HEAD_RADIUS * 2 + BODY_LENGTH + LEG_LENGTH);
                case 4:
                    //right arm
                    g.setColor(Color.DARK_GRAY);
                    g.drawLine(100 + BEAM_LENGTH, 150 + ROPE_LENGTH + HEAD_RADIUS * 2 + ARM_OFFSET_FROM_HEAD, 100 + BEAM_LENGTH + UPPER_ARM_LENGTH, 150 + ROPE_LENGTH + HEAD_RADIUS * 2 + ARM_OFFSET_FROM_HEAD);
                    g.drawLine(100 + BEAM_LENGTH + UPPER_ARM_LENGTH, 150 + ROPE_LENGTH + HEAD_RADIUS * 2 + ARM_OFFSET_FROM_HEAD, 100 + BEAM_LENGTH + UPPER_ARM_LENGTH, 150 + ROPE_LENGTH + HEAD_RADIUS * 2 + ARM_OFFSET_FROM_HEAD + LOWER_ARM_LENGTH);
                case 5:
                    //left arm
                    g.setColor(Color.DARK_GRAY);
                    g.drawLine(100 + BEAM_LENGTH, 150 + ROPE_LENGTH + HEAD_RADIUS * 2 + ARM_OFFSET_FROM_HEAD, 100 + BEAM_LENGTH - UPPER_ARM_LENGTH, 150 + ROPE_LENGTH + HEAD_RADIUS * 2 + ARM_OFFSET_FROM_HEAD);
                    g.drawLine(100 + BEAM_LENGTH - UPPER_ARM_LENGTH, 150 + ROPE_LENGTH + HEAD_RADIUS * 2 + ARM_OFFSET_FROM_HEAD, 100 + BEAM_LENGTH - UPPER_ARM_LENGTH, 150 + ROPE_LENGTH + HEAD_RADIUS * 2 + ARM_OFFSET_FROM_HEAD + LOWER_ARM_LENGTH);
                case 6:
                    //body
                    g.setColor(Color.DARK_GRAY);
                    g.drawLine(100 + BEAM_LENGTH, 150 + ROPE_LENGTH + HEAD_RADIUS * 2, 100 + BEAM_LENGTH, 150 + ROPE_LENGTH + HEAD_RADIUS * 2 + BODY_LENGTH);
                case 7:
                    //head
                    g.setColor(Color.DARK_GRAY);
                    g.drawOval(100 + BEAM_LENGTH - HEAD_RADIUS, 150 + ROPE_LENGTH, HEAD_RADIUS * 2, HEAD_RADIUS * 2);
            };
        }
    }
}
