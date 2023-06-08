package meMe;

import java.awt.EventQueue;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

public class AAFirst extends JFrame {

	private JPanel contentPane;
    private Clip clip;
  //  AAFirst frame = new AAFirst();
    int num;


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
	public AAFirst() {
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
		
		ImageIcon forGallery = new ImageIcon("E:\\Eclipse codes\\Portfolio\\Images\\AA1_BUTTON GALLERY_PRESSED .png");
		ImageIcon forGallery2 = new ImageIcon("E:\\Eclipse codes\\Portfolio\\Images\\AA1_BUTTON GALLERY  .png");
		ImageIcon normalIcon = new ImageIcon("E:\\Eclipse codes\\Portfolio\\Images\\AA1_BUTTON ABOUT.png");
        ImageIcon hoverIcon = new ImageIcon("E:\\Eclipse codes\\Portfolio\\Images\\AA1_BUTTON ABOUT_PRESSED.png");
		ImageIcon startOne = new ImageIcon("E:\\Eclipse codes\\Portfolio\\Images\\AAA1_START.png");
        ImageIcon startTwo = new ImageIcon("E:\\Eclipse codes\\Portfolio\\Images\\AAA1_START_PRESSED.png");
		ImageIcon Play = new ImageIcon("E:\\Eclipse codes\\Portfolio\\Images\\PLAYBUTTON.png");
        ImageIcon playPressed = new ImageIcon("E:\\Eclipse codes\\Portfolio\\Images\\PLAYBUTTON_PRESSED.png");
        
		
		JLabel GALLERY = new JLabel("");
		GALLERY.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				playSound("E:\\Eclipse codes\\Portfolio\\Effects\\about gallery.wav");
				Gallery1 abt = new Gallery1();
				abt.setVisible(true);
				dispose();
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				GALLERY.setIcon(forGallery);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				GALLERY.setIcon(forGallery2);
			}
		});
		GALLERY.setBounds(283, 377, 190, 53);
		contentPane.add(GALLERY);

		JLabel ABOUT = new JLabel("");
		ABOUT.setIcon(new ImageIcon("C:\\Users\\Jairus\\Pictures\\PORTFOLIO_FINAL\\AA1_BUTTON ABOUT.png"));
		ABOUT.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                // Change the icon when the mouse enters the label
                ABOUT.setIcon(hoverIcon);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                // Reset the icon when the mouse exits the label
                ABOUT.setIcon(normalIcon);
            }
			@Override
			public void mouseClicked(MouseEvent e) {
				playSound("E:\\Eclipse codes\\Portfolio\\Effects\\about gallery.wav");
				About abt = new About();
				abt.setVisible(true);
				dispose();
			}
			
			
        });
		            ABOUT.setVisible(true);
	        // Add the label to the frame
	        getContentPane().add(ABOUT);
	    
		ABOUT.setBounds(284, 316, 189, 50);
		contentPane.add(ABOUT);
        
		JLabel START = new JLabel("");
		START.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				playSound("E:\\Eclipse codes\\Portfolio\\Effects\\mixkit-game-click-1114.wav");
				START1 abt = new START1();
				abt.setVisible(true);
				dispose();
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				START.setIcon(startTwo);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				START.setIcon(startOne);
			}
		});
		START.setBounds(487, 62, 243, 118);
		contentPane.add(START);

		JLabel PLAYBUTTON = new JLabel("");
		PLAYBUTTON.setBounds(40, 205, 34, 30);
		contentPane.add(PLAYBUTTON);
		
		 num = 1;
		
		PLAYBUTTON.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
            	num++;
            	if (num%2==0) {
            		
            	playSound("E:\\\\Eclipse codes\\\\Portfolio\\\\Effects\\\\mixkit-game-click-1114.wav");
            	playSound("E:\\Eclipse codes\\Portfolio\\Effects\\Cipher2.wav");
            	} else {
            		stopSound();
                	playSound("E:\\\\Eclipse codes\\\\Portfolio\\\\Effects\\\\mixkit-game-click-1114.wav");

            	}
               
                // Add your desired functionality here
            }
			@Override
			public void mouseEntered(MouseEvent e) {
				PLAYBUTTON.setIcon(playPressed);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				PLAYBUTTON.setIcon(Play);
			
			}
        });

		JLabel BG = new JLabel(new ImageIcon("E:\\Eclipse codes\\Portfolio\\Images\\FINAAAL.gif"));
		BG.setBounds(0, 0, 751, 465);
		contentPane.add(BG);
		getContentPane().add(BG);
	}
	
	//FOR SOUND EFFECTS	
	   public void playSound(String soundFilePath) {
	        try {
	            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File(soundFilePath).getAbsoluteFile());
	            clip = AudioSystem.getClip();
	            clip.open(audioInputStream);
	            clip.start();
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	    }


	    public void stopSound() {
	        if (clip != null && clip.isRunning()) {
	            clip.stop();
	            clip.close();
	        }
	    }
	}
