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

public class START1 extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					START1 frame = new START1();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public START1() {
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
		ImageIcon arrowRight = new ImageIcon("E:\\Eclipse codes\\Portfolio\\Images\\BUTTONRIGHT.png");
        ImageIcon arrowrightPressed = new ImageIcon("E:\\Eclipse codes\\Portfolio\\Images\\BUTTONRIGHT_PRESSED.png");
  
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
		
		JLabel START2 = new JLabel("");
		START2.setBackground(Color.BLACK);
		START2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				playSound("E:\\Eclipse codes\\Portfolio\\Effects\\Arrows.wav");
				START2 abt = new START2();
				abt.setVisible(true);
				dispose();
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				START2.setIcon(arrowrightPressed);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				START2.setIcon(arrowRight);

			}
		});
		START2.setBounds(181, 410, 31, 33);
		contentPane.add(START2);
		
		JLabel BG = new JLabel("");
		BG.setIcon(new ImageIcon("E:\\Eclipse codes\\Portfolio\\Images\\C1_OC.png"));
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
