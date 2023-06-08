package meMe;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.ImageIcon;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;

public class Gallery1 extends JFrame {

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
	public Gallery1() {
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
		HOME.setBounds(645, 387, 34, 33);
		contentPane.add(HOME);

		JLabel Gallery2 = new JLabel("");
		Gallery2.setBackground(Color.BLACK);
		Gallery2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				playSound("E:\\Eclipse codes\\Portfolio\\Effects\\Arrows.wav");
				Gallery2 abt = new Gallery2();
				abt.setVisible(true);
				dispose();
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				Gallery2.setIcon(arrowrightPressed);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				Gallery2.setIcon(arrowRight);
			}
		});
		Gallery2.setBounds(602, 389, 32, 30);
		contentPane.add(Gallery2);
	
		JLabel BG = new JLabel("");
		BG.setIcon(new ImageIcon("E:\\Eclipse codes\\Portfolio\\Images\\B1_GALLERY.png"));
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
