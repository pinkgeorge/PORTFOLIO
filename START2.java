package meMe;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.EventQueue;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class START2 extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					START2 frame = new START2();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	public START2() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 765, 501);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setLocationRelativeTo(null);

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		//IMAGES
		ImageIcon hoMe = new ImageIcon("E:\\Eclipse codes\\Portfolio\\Images\\BUTTONHOME.png");
		ImageIcon homePressed = new ImageIcon("E:\\Eclipse codes\\Portfolio\\Images\\BUTTONHOME_PRESSED.png");
		ImageIcon arrowLeft = new ImageIcon("E:\\Eclipse codes\\Portfolio\\Images\\BUTTONLEFT.png");
        ImageIcon arrowleftPressed = new ImageIcon("E:\\Eclipse codes\\Portfolio\\Images\\BUTTONLEFT_PRESSED.png");
	     
		JLabel HOME = new JLabel("");
		HOME.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				playSound("E:\\Eclipse codes\\Portfolio\\Effects\\Home.wav");
				AAFirst abt = new AAFirst();
				abt.setVisible(true);
				dispose();
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				HOME.setIcon(homePressed);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				HOME.setIcon(hoMe);
			}
		});
		HOME.setBounds(224, 410, 33, 31);
		contentPane.add(HOME);
		        
		JLabel START1 = new JLabel("");
		START1.setBackground(Color.BLACK);
		START1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				playSound("E:\\Eclipse codes\\Portfolio\\Effects\\Arrows.wav");
				START1 abt = new START1();
				abt.setVisible(true);
				dispose();
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				START1.setIcon(arrowleftPressed);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				START1.setIcon(arrowLeft);
			}
		});
		START1.setBounds(138, 410, 31, 33);
		contentPane.add(START1);
		
		JLabel BG = new JLabel("");
		BG.setIcon(new ImageIcon("E:\\Eclipse codes\\Portfolio\\Images\\C2_OC.png"));
		BG.setBounds(0, 0, 751, 465);
		contentPane.add(BG);
		
		//FOR SOUND EFFECTS
	}
    public static void playSound(String soundFilePath) {
        try {
            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File(soundFilePath).getAbsoluteFile());
            Clip clip = AudioSystem.getClip();
            clip.open(audioInputStream);
            clip.start();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
