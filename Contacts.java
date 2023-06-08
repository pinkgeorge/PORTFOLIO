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

public class Contacts extends JFrame {

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
	public Contacts() {
		setResizable(false);
		setTitle("Zujomenji Zone Zero");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 765, 501);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setLocationRelativeTo(null);

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		//IMAGES
		ImageIcon arrowLeft = new ImageIcon("E:\\Eclipse codes\\Portfolio\\Images\\BUTTONLEFT.png");
        ImageIcon arrowleftPressed = new ImageIcon("E:\\Eclipse codes\\Portfolio\\Images\\BUTTONLEFT_PRESSED.png");
		ImageIcon hoMe = new ImageIcon("E:\\Eclipse codes\\Portfolio\\Images\\BUTTONHOME.png");
        ImageIcon homePressed = new ImageIcon("E:\\Eclipse codes\\Portfolio\\Images\\BUTTONHOME_PRESSED.png");
        
		JLabel Skill = new JLabel("");
		Skill.setBackground(Color.BLACK);
		Skill.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				playSound("E:\\Eclipse codes\\Portfolio\\Effects\\Arrows.wav");
				Skill abt = new Skill();
				abt.setVisible(true);
				dispose();
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				Skill.setIcon(arrowleftPressed);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				Skill.setIcon(arrowLeft);
			}
		});
		Skill.setBounds(138, 410, 31, 33);
		contentPane.add(Skill);
		
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
		
		JLabel BG = new JLabel("");
		BG.setBounds(0, 0, 751, 465);
		contentPane.add(BG);
		BG.setIcon(new ImageIcon("C:\\Users\\Jairus\\Pictures\\PORTFOLIO_FINAL\\A4_CONTACTS.png"));
		
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

