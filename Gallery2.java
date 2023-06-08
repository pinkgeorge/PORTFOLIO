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

public class Gallery2 extends JFrame {

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
	public Gallery2() {
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
		
		JLabel Gallery1 = new JLabel("");
		Gallery1.setBackground(Color.BLACK);
		Gallery1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				playSound("E:\\Eclipse codes\\Portfolio\\Effects\\Arrows.wav");
				Gallery1 abt = new Gallery1();
				abt.setVisible(true);
				dispose();
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				Gallery1.setIcon(arrowleftPressed);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				Gallery1.setIcon(arrowLeft);
			}
		});
		Gallery1.setBounds(560, 390, 29, 27);
		contentPane.add(Gallery1);
		
		JLabel Gallery3 = new JLabel("");
		Gallery3.setBackground(Color.BLACK);
		Gallery3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				playSound("E:\\Eclipse codes\\Portfolio\\Effects\\Arrows.wav");
				Gallery3 abt = new Gallery3();
				abt.setVisible(true);
				dispose();
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				Gallery3.setIcon(arrowrightPressed);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				Gallery3.setIcon(arrowRight);
			}
		});
		Gallery3.setBounds(602, 388, 32, 32);
		contentPane.add(Gallery3);
		
		JLabel BG = new JLabel("");
		BG.setIcon(new ImageIcon("E:\\Eclipse codes\\Portfolio\\Images\\B2_GALLERY.png"));
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
