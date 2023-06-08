package meMe;


import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.ImageIcon;

public class About extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AAFirst frame = new AAFirst();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	public About() {
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
		HOME.setBounds(224, 409, 33, 33);
		contentPane.add(HOME);
		
		JLabel Interests = new JLabel("");
		Interests.setBackground(Color.BLACK);
		Interests.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				playSound("E:\\Eclipse codes\\Portfolio\\Effects\\Arrows.wav");
				Interests abt = new Interests();
				abt.setVisible(true);
				dispose();
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				Interests.setIcon(arrowrightPressed);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				Interests.setIcon(arrowRight);

			}
		});
		Interests.setBounds(181, 410, 31, 33);
		contentPane.add(Interests);
		
		JLabel BG = new JLabel("");
		BG.setIcon(new ImageIcon("C:\\Users\\Jairus\\Pictures\\PORTFOLIO_FINAL\\A1_ABOUT.png"));
		BG.setBounds(0, 0, 751, 465);
		contentPane.add(BG);
	}
	
	//FOR SOUND EFFECTS
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