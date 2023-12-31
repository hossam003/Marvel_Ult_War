package GUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import engine.Game;
import engine.Player;
import exceptions.AbilityUseException;
import exceptions.ChampionDisarmedException;
import exceptions.InvalidTargetException;
import exceptions.LeaderAbilityAlreadyUsedException;
import exceptions.LeaderNotCurrentException;
import exceptions.NotEnoughResourcesException;
import exceptions.UnallowedMovementException;
import model.abilities.AreaOfEffect;
import model.abilities.CrowdControlAbility;
import model.abilities.DamagingAbility;
import model.abilities.HealingAbility;
import model.effects.Disarm;
import model.world.AntiHero;
import model.world.Champion;
import model.world.Cover;
import model.world.Direction;
import model.world.Hero;
import model.world.Villain;

public class Main implements ActionListener, MouseListener, KeyListener{

	static Game game;
	
	JFrame frame;
	JFrame frame2;
	JFrame frame3;
	
	ImageIcon marvel = new ImageIcon("Start.jpg");
	ImageIcon Cap = new ImageIcon("Captain America.png");
	ImageIcon Thor = new ImageIcon("Thor.png");
	ImageIcon Loki = new ImageIcon("Loki.png");
	ImageIcon Ironman = new ImageIcon("Ironman.png");
	ImageIcon Hulk = new ImageIcon("Hulk.png");
	ImageIcon Hela = new ImageIcon("Hela.png");
	ImageIcon Venom = new ImageIcon("Venom.png");
	ImageIcon Deadpool = new ImageIcon("Deadpool.png");
	ImageIcon Strange = new ImageIcon("Dr Strange.png");
	ImageIcon Spiderman = new ImageIcon("Spiderman.png");
	ImageIcon Quicksilver = new ImageIcon("Quicksilver.png");
	ImageIcon Electro = new ImageIcon("Electro.png");
	ImageIcon Iceman = new ImageIcon("Iceman.png");
	ImageIcon Yellow = new ImageIcon("Yellow Jacket.png");
	ImageIcon Ghost = new ImageIcon("Ghost Rider.png");
	ImageIcon Ability = new ImageIcon("Ability.png");
	ImageIcon Directions = new ImageIcon("Direction.png");
	ImageIcon Point = new ImageIcon("Point.png");
	
	JButton Start;
	JButton howtoplay;
	
	JButton c1;
	JButton c2;
	JButton c3;
	JButton c4;
	JButton c5;
	JButton c6;
	JButton c7;
	JButton c8;
	JButton c9;
	JButton c10;
	JButton c11;
	JButton c12;
	JButton c13;
	JButton c14;
	JButton c15;
	
	JButton champ11;
	JButton champ12;
	JButton champ13;
	JButton champ21;
	JButton champ22;
	JButton champ23;
	
	JButton b00 = new JButton();
	JButton b01 = new JButton();
	JButton b02 = new JButton();
	JButton b03 = new JButton();
	JButton b04 = new JButton();
	JButton b10 = new JButton();
	JButton b11 = new JButton();
	JButton b12 = new JButton();
	JButton b13 = new JButton();
	JButton b14 = new JButton();
	JButton b20 = new JButton();
	JButton b21 = new JButton();
	JButton b22 = new JButton();
	JButton b23 = new JButton();
	JButton b24 = new JButton();
	JButton b30 = new JButton();
	JButton b31 = new JButton();
	JButton b32 = new JButton();
	JButton b33 = new JButton();
	JButton b34 = new JButton();
	JButton b40 = new JButton();
	JButton b41 = new JButton();
	JButton b42 = new JButton();
	JButton b43 = new JButton();
	JButton b44 = new JButton();

	JButton endturn;
	
	JButton done;
	
	JPanel panel1;
	JPanel panel2;
	JPanel panel3;
	JPanel panel4;
	JPanel panel5;
	
	JPanel team1;
	JPanel team2;
	
	JPanel champsbuttons;
	
	JPanel abilitiespanel;
	
	JPanel panelf2;
	
	JLabel l;
	
	JLabel queue;
	
	JLabel label;
	
	JLabel chooseleaders;
	
	JLabel l1;
	JLabel l2;
	JLabel l3;
	JLabel l4;
	JLabel l5;
	JLabel l6;
	JLabel l7;
	JLabel l8;
	JLabel l9;
	
	JPanel jp = new JPanel();
	JPanel subframe;
	
	ArrayList<Integer> keys = new ArrayList<Integer>();
	
	ArrayList<JButton> covers = new ArrayList<JButton>();
	
	int pointx;
	int pointy;
	int ability;
	
	Clip clip;
	
	public Main() throws UnsupportedAudioFileException, IOException, LineUnavailableException
	{
//		File file = new File("Sound.wav");
//		AudioInputStream audioStream = AudioSystem.getAudioInputStream(file);
//		clip = AudioSystem.getClip();
//		clip.open(audioStream);
//		clip.start();
		
		Image newimg = Directions.getImage().getScaledInstance(40, 40, java.awt.Image.SCALE_SMOOTH);
		Directions = new ImageIcon(newimg);
		
		newimg = Point.getImage().getScaledInstance(40, 40, java.awt.Image.SCALE_SMOOTH);
		Point = new ImageIcon(newimg);
		
		newimg = Ability.getImage().getScaledInstance(60, 50, java.awt.Image.SCALE_SMOOTH);
		Ability = new ImageIcon(newimg);
		
		newimg = marvel.getImage().getScaledInstance(1917, 1005, java.awt.Image.SCALE_SMOOTH);
		marvel = new ImageIcon(newimg);
		
		// JFrame = a GUI window to add components to
		frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("Marvel: Ultimate War");
		frame.setIconImage(marvel.getImage());

		// JLabel = a GUI display area for a string of text, an image, or both
		
		l = new JLabel();
		l.setIcon(marvel);
		l.setBounds(-2, 0, 1925, 1008);
		l.setHorizontalAlignment((int) JFrame.CENTER_ALIGNMENT);
		
		Start = new JButton();
		Start.addActionListener(this);
		Start.setFocusable(false);
		Start.setText("Start");
		Start.setFont(new Font("Arial", Font.BOLD, 30));
		Start.setBorder(null);
		Start.setBorderPainted(false);
		Start.setContentAreaFilled(false);
		Start.setOpaque(false);
		Start.setForeground(new Color(0x335988));
		Start.setPreferredSize(new Dimension(50, 30));

		howtoplay = new JButton();
		howtoplay.addActionListener(this);
		howtoplay.setFocusable(false);
		howtoplay.setText("How to play");
		howtoplay.setFont(new Font("Arial", Font.BOLD, 30));
		howtoplay.setBorder(null);
		howtoplay.setBorderPainted(false);
		howtoplay.setContentAreaFilled(false);
		howtoplay.setOpaque(false);
		howtoplay.setForeground(new Color(0x335988));
		howtoplay.setPreferredSize(new Dimension(80, 30));
		
		l.add(Start);
		l.add(howtoplay);
		Start.setBounds(625, 550, 610, 30);
		howtoplay.setBounds(567, 600, 730, 30);
		
		subframe = new JPanel();
		subframe.add(l);
		subframe.setLayout(null);
		
//		frame.setSize(new Dimension(800,1200));
		frame.add(subframe);
		frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
//		frame.setResizable(false);
		frame.setVisible(true);
	}

	public void chooseleaders()
	{
		subframe.setLayout(new BorderLayout());
		
		chooseleaders = new JLabel("Please choose your Leaders");
		chooseleaders.setForeground(Color.white);
		chooseleaders.setFont(new Font("Arial", Font.BOLD, 40));
		chooseleaders.setHorizontalAlignment((int) JFrame.CENTER_ALIGNMENT);
		
		JLabel player1 = new JLabel(game.getFirstPlayer().getName());
		JLabel player2 = new JLabel(game.getSecondPlayer().getName());
		
		champ11 = new JButton(game.getFirstPlayer().getTeam().get(0).getName());
		champ12 = new JButton(game.getFirstPlayer().getTeam().get(1).getName());
		champ13 = new JButton(game.getFirstPlayer().getTeam().get(2).getName());
		champ21 = new JButton(game.getSecondPlayer().getTeam().get(0).getName());
		champ22 = new JButton(game.getSecondPlayer().getTeam().get(1).getName());
		champ23 = new JButton(game.getSecondPlayer().getTeam().get(2).getName());
		champ11.addActionListener(this);
		champ12.addActionListener(this);
		champ13.addActionListener(this);
		champ21.addActionListener(this);
		champ22.addActionListener(this);
		champ23.addActionListener(this);
		champ11.setFocusable(false);
		champ12.setFocusable(false);
		champ13.setFocusable(false);
		champ21.setFocusable(false);
		champ22.setFocusable(false);
		champ23.setFocusable(false);
		
		Image newimg = Cap.getImage().getScaledInstance(80, 80, java.awt.Image.SCALE_SMOOTH);
		Cap = new ImageIcon(newimg);
		newimg = Deadpool.getImage().getScaledInstance(80, 80, java.awt.Image.SCALE_SMOOTH);
		Deadpool = new ImageIcon(newimg);
		newimg = Strange.getImage().getScaledInstance(80, 80, java.awt.Image.SCALE_SMOOTH);
		Strange = new ImageIcon(newimg);
		newimg = Quicksilver.getImage().getScaledInstance(80, 80, java.awt.Image.SCALE_SMOOTH);
		Quicksilver = new ImageIcon(newimg);
		newimg = Electro.getImage().getScaledInstance(80, 80, java.awt.Image.SCALE_SMOOTH);
		Electro = new ImageIcon(newimg);
		newimg = Ghost.getImage().getScaledInstance(80, 80, java.awt.Image.SCALE_SMOOTH);
		Ghost = new ImageIcon(newimg);
		newimg = Ironman.getImage().getScaledInstance(80, 80, java.awt.Image.SCALE_SMOOTH);
		Ironman = new ImageIcon(newimg);
		newimg = Hulk.getImage().getScaledInstance(80, 80, java.awt.Image.SCALE_SMOOTH);
		Hulk = new ImageIcon(newimg);
		newimg = Hela.getImage().getScaledInstance(80, 80, java.awt.Image.SCALE_SMOOTH);
		Hela = new ImageIcon(newimg);
		newimg = Loki.getImage().getScaledInstance(80, 80, java.awt.Image.SCALE_SMOOTH);
		Loki = new ImageIcon(newimg);
		newimg = Thor.getImage().getScaledInstance(80, 80, java.awt.Image.SCALE_SMOOTH);
		Thor = new ImageIcon(newimg);
		newimg = Yellow.getImage().getScaledInstance(80, 80, java.awt.Image.SCALE_SMOOTH);
		Yellow = new ImageIcon(newimg);
		newimg = Venom.getImage().getScaledInstance(80, 80, java.awt.Image.SCALE_SMOOTH);
		Venom = new ImageIcon(newimg);
		newimg = Spiderman.getImage().getScaledInstance(80, 80, java.awt.Image.SCALE_SMOOTH);
		Spiderman = new ImageIcon(newimg);
		newimg = Iceman.getImage().getScaledInstance(80, 80, java.awt.Image.SCALE_SMOOTH);
		Iceman = new ImageIcon(newimg);
		
		champimage(champ11.getText(), champ11);
		champimage(champ12.getText(), champ12);
		champimage(champ13.getText(), champ13);
		champimage(champ21.getText(), champ21);
		champimage(champ22.getText(), champ22);
		champimage(champ23.getText(), champ23);
		
		champ11.setHorizontalTextPosition(JButton.LEFT);
		champ12.setHorizontalTextPosition(JButton.LEFT);
		champ13.setHorizontalTextPosition(JButton.LEFT);
		champ21.setHorizontalTextPosition(JButton.LEFT);
		champ22.setHorizontalTextPosition(JButton.LEFT);
		champ23.setHorizontalTextPosition(JButton.LEFT);
		
		team1 = new JPanel();
		team2 = new JPanel();
		
		team1.setLayout(new GridLayout(4,1));
		team2.setLayout(new GridLayout(4, 1));
		
		team1.add(player1);
		team1.add(champ11);
		team1.add(champ12);
		team1.add(champ13);

		team2.add(player2);
		team2.add(champ21);
		team2.add(champ22);
		team2.add(champ23);
		
		team1.setPreferredSize(new Dimension(500,200));
		team2.setPreferredSize(new Dimension(500,200));
		team1.setBackground(new Color(0x335988));
		team2.setBackground(new Color(0x335988));
				
		player1.setFont(new Font("Arial", Font.BOLD, 30));
		player2.setFont(new Font("Arial", Font.BOLD, 30));
		player1.setHorizontalAlignment((int) JPanel.CENTER_ALIGNMENT);
		player2.setHorizontalAlignment((int) JPanel.CENTER_ALIGNMENT);
		player1.setForeground(Color.white);
		player2.setForeground(Color.white);
		
		champ11.setFont(new Font("Arial", Font.BOLD, 30));
		champ12.setFont(new Font("Arial", Font.BOLD, 30));
		champ13.setFont(new Font("Arial", Font.BOLD, 30));
		champ21.setFont(new Font("Arial", Font.BOLD, 30));
		champ22.setFont(new Font("Arial", Font.BOLD, 30));
		champ23.setFont(new Font("Arial", Font.BOLD, 30));
		
		champ11.setBackground(Color.white);
		champ12.setBackground(Color.white);
		champ13.setBackground(Color.white);
		champ21.setBackground(Color.white);
		champ22.setBackground(Color.white);
		champ23.setBackground(Color.white);
		
		champ11.setHorizontalAlignment((int) JPanel.CENTER_ALIGNMENT);
		champ12.setHorizontalAlignment((int) JPanel.CENTER_ALIGNMENT);
		champ13.setHorizontalAlignment((int) JPanel.CENTER_ALIGNMENT);
		champ11.setFocusable(false);
		champ12.setFocusable(false);
		champ13.setFocusable(false);
		
		champ21.setHorizontalAlignment((int) JPanel.CENTER_ALIGNMENT);
		champ22.setHorizontalAlignment((int) JPanel.CENTER_ALIGNMENT);
		champ23.setHorizontalAlignment((int) JPanel.CENTER_ALIGNMENT);
		champ21.setFocusable(false);
		champ22.setFocusable(false);
		champ23.setFocusable(false);
		

		subframe.add(chooseleaders, BorderLayout.PAGE_START);
		subframe.add(team1, BorderLayout.LINE_START);
		subframe.add(team2, BorderLayout.LINE_END);
		
		frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
		frame.setVisible(true);
	}
	
	public void Play()
	{
		subframe.setVisible(false);
		// JFrame = a GUI window to add components to
		frame.setLayout(new BorderLayout());

		
		// JPanel = a GUI component that functions as a container to hold other components
		panel1 = new JPanel();
		panel2 = new JPanel();
		panel3 = new JPanel();
		panel4 = new JPanel();
		panel5 = new JPanel();
		
		panel1.setBackground(Color.white);
		panel2.setBackground(Color.white);
		panel3.setBackground(Color.black);
		panel4.setBackground(Color.white);
		panel5.setBackground(Color.white);
				
		panel1.setPreferredSize(new Dimension(250,200));
		panel2.setPreferredSize(new Dimension(250,200));
		panel3.setPreferredSize(new Dimension(50,50));
		panel4.setPreferredSize(new Dimension(0,140));
		panel5.setPreferredSize(new Dimension(25,25));
		
		panel1.setLayout(null);
		panel2.setLayout(null);
		panel3.setLayout(new GridLayout(5,5));
		panel4.setLayout(null);
		panel5.setLayout(null);
		
		for(int i = 0; i < game.getFirstPlayer().getTeam().size() ;i++)
			game.getTurnOrder().insert(game.getFirstPlayer().getTeam().get(i));
		for(int i = 0; i < game.getSecondPlayer().getTeam().size() ;i++)
			game.getTurnOrder().insert(game.getSecondPlayer().getTeam().get(i));
		
		game.placeChampions();

		b00.addActionListener(this);
		b01.addActionListener(this);
		b02.addActionListener(this);
		b03.addActionListener(this);
		b04.addActionListener(this);
		b10.addActionListener(this);
		b11.addActionListener(this);
		b12.addActionListener(this);
		b13.addActionListener(this);
		b14.addActionListener(this);
		b20.addActionListener(this);
		b21.addActionListener(this);
		b22.addActionListener(this);
		b23.addActionListener(this);
		b24.addActionListener(this);
		b30.addActionListener(this);
		b31.addActionListener(this);
		b32.addActionListener(this);
		b33.addActionListener(this);
		b34.addActionListener(this);
		b40.addActionListener(this);
		b41.addActionListener(this);
		b42.addActionListener(this);
		b43.addActionListener(this);
		b44.addActionListener(this);
		
		panel3.add(b40);
		panel3.add(b41);
		panel3.add(b42);
		panel3.add(b43);
		panel3.add(b44);
		panel3.add(b30);
		panel3.add(b31);
		panel3.add(b32);
		panel3.add(b33);
		panel3.add(b34);
		panel3.add(b20);
		panel3.add(b21);
		panel3.add(b22);
		panel3.add(b23);
		panel3.add(b24);
		panel3.add(b10);
		panel3.add(b11);
		panel3.add(b12);
		panel3.add(b13);
		panel3.add(b14);
		panel3.add(b00);
		panel3.add(b01);
		panel3.add(b02);
		panel3.add(b03);
		panel3.add(b04);
		
		b00.setBackground(Color.white);
		b01.setBackground(Color.white);
		b02.setBackground(Color.white);
		b03.setBackground(Color.white);
		b04.setBackground(Color.white);
		b10.setBackground(Color.white);
		b11.setBackground(Color.white);
		b12.setBackground(Color.white);
		b13.setBackground(Color.white);
		b14.setBackground(Color.white);
		b20.setBackground(Color.white);
		b21.setBackground(Color.white);
		b22.setBackground(Color.white);
		b23.setBackground(Color.white);
		b24.setBackground(Color.white);
		b30.setBackground(Color.white);
		b31.setBackground(Color.white);
		b32.setBackground(Color.white);
		b33.setBackground(Color.white);
		b34.setBackground(Color.white);
		b40.setBackground(Color.white);
		b41.setBackground(Color.white);
		b42.setBackground(Color.white);
		b43.setBackground(Color.white);
		b44.setBackground(Color.white);
		
		b00.setFocusable(false);
		b01.setFocusable(false);
		b02.setFocusable(false);
		b03.setFocusable(false);
		b04.setFocusable(false);
		b10.setFocusable(false);
		b11.setFocusable(false);
		b12.setFocusable(false);
		b13.setFocusable(false);
		b14.setFocusable(false);
		b20.setFocusable(false);
		b21.setFocusable(false);
		b22.setFocusable(false);
		b23.setFocusable(false);
		b24.setFocusable(false);
		b30.setFocusable(false);
		b31.setFocusable(false);
		b32.setFocusable(false);
		b33.setFocusable(false);
		b34.setFocusable(false);
		b40.setFocusable(false);
		b41.setFocusable(false);
		b42.setFocusable(false);
		b43.setFocusable(false);
		b44.setFocusable(false);
		
		Image newimg = Cap.getImage().getScaledInstance(100, 100, java.awt.Image.SCALE_SMOOTH);
		Cap = new ImageIcon(newimg);
		newimg = Deadpool.getImage().getScaledInstance(100, 100, java.awt.Image.SCALE_SMOOTH);
		Deadpool = new ImageIcon(newimg);
		newimg = Strange.getImage().getScaledInstance(100, 100, java.awt.Image.SCALE_SMOOTH);
		Strange = new ImageIcon(newimg);
		newimg = Quicksilver.getImage().getScaledInstance(100, 100, java.awt.Image.SCALE_SMOOTH);
		Quicksilver = new ImageIcon(newimg);
		newimg = Electro.getImage().getScaledInstance(100, 100, java.awt.Image.SCALE_SMOOTH);
		Electro = new ImageIcon(newimg);
		newimg = Ghost.getImage().getScaledInstance(100, 100, java.awt.Image.SCALE_SMOOTH);
		Ghost = new ImageIcon(newimg);
		newimg = Ironman.getImage().getScaledInstance(100, 100, java.awt.Image.SCALE_SMOOTH);
		Ironman = new ImageIcon(newimg);
		newimg = Hulk.getImage().getScaledInstance(100, 100, java.awt.Image.SCALE_SMOOTH);
		Hulk = new ImageIcon(newimg);
		newimg = Hela.getImage().getScaledInstance(100, 100, java.awt.Image.SCALE_SMOOTH);
		Hela = new ImageIcon(newimg);
		newimg = Loki.getImage().getScaledInstance(100, 100, java.awt.Image.SCALE_SMOOTH);
		Loki = new ImageIcon(newimg);
		newimg = Thor.getImage().getScaledInstance(100, 100, java.awt.Image.SCALE_SMOOTH);
		Thor = new ImageIcon(newimg);
		newimg = Yellow.getImage().getScaledInstance(100, 100, java.awt.Image.SCALE_SMOOTH);
		Yellow = new ImageIcon(newimg);
		newimg = Venom.getImage().getScaledInstance(100, 100, java.awt.Image.SCALE_SMOOTH);
		Venom = new ImageIcon(newimg);
		newimg = Spiderman.getImage().getScaledInstance(100, 100, java.awt.Image.SCALE_SMOOTH);
		Spiderman = new ImageIcon(newimg);
		newimg = Iceman.getImage().getScaledInstance(100, 100, java.awt.Image.SCALE_SMOOTH);
		Iceman = new ImageIcon(newimg);
		
		queue = new JLabel();
		updateboard();
		showCurrentChamp();
		viewPQ();
		queue.setBounds(250, 0, 700, 25);
		queue.setFont(new Font("Arial", Font.ITALIC, 13));
		
		endturn = new JButton("End turn");
		panel5.add(endturn).setBounds(1016, 0, 100, 20);
		endturn.setBackground(Color.DARK_GRAY);
		endturn.setForeground(Color.white);
		endturn.setFocusable(false);
		endturn.addActionListener(this);
		
		printChamps(game.getFirstPlayer(),  panel1);
		printChamps(game.getSecondPlayer(),  panel2);
		
		frame.add(panel1,BorderLayout.WEST);
		frame.add(panel2,BorderLayout.EAST);
		frame.add(panel3,BorderLayout.CENTER);
		frame.add(panel4, BorderLayout.PAGE_END);
		frame.add(panel5, BorderLayout.PAGE_START);
		
		frame.addKeyListener(this);
		frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
		frame.setVisible(true);
	}
	
	
	public void controls() {
		frame3 = new JFrame();
		JPanel sub = new JPanel();
		frame3.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame3.setTitle("How to play");
		frame3.setIconImage(marvel.getImage());
		frame3.setSize(new Dimension(850,400));
		frame3.setResizable(false);
		sub.setBackground(Color.black);
		frame3.add(sub);
		
		JLabel body = new JLabel();
		
		body.setText("<html>" + "Controls: " + "<br>" + "<br>" + "<br>"
					+ "- 'Up', 'Down', 'Left', 'Right' arrows are used to move the champion." + "<br>" + "<br>"
					+ "- To attack, press 'a' then choose the direction for the attack using 'Up', 'Down', 'Left', 'Right' arrows." + "<br>" + "<br>"
					+ "- To cast an ability press 'c'." + "<br>" + "<br>"
					+ "- To use your leader ability you must be playing with the leader you chose at the beggining then press 'L'." + "<br>" + "<br>"
					+ "- After you are done with your turn, click on 'End turn' button or press 'e' to move on to the next champion's turn." + "</html>");
		
		body.setFont(new Font("Arial", Font.BOLD, 15));
		
		body.setForeground(Color.white);
		
		sub.add(body);
		frame3.setVisible(true);
	}
	
	public void singletarget() {
		frame2 = new JFrame();
		frame2.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		frame2.setTitle("Cast ability");
		frame2.setIconImage(Point.getImage());
		frame2.setResizable(false);
		frame2.setSize(300,150);
		
		panelf2 = new JPanel();
		panelf2.setPreferredSize(new Dimension(300,150));
		panelf2.setLayout(new GridLayout(2,1));
		
		done = new JButton("Done");
		done.addActionListener(this);
		done.setBackground(Color.white);
		done.setForeground(Color.black);
		done.setFocusable(false);
		done.setFont(new Font("Arial", Font.BOLD, 13));
		done.setBounds((int) JPanel.CENTER_ALIGNMENT, (int) JPanel.CENTER_ALIGNMENT, 90, 15);
		
		JPanel a = new JPanel();
		a.setLayout(new FlowLayout());
		a.add(done);
		
		JLabel chooselocation = new JLabel("Click on a target on the board.");
		chooselocation.setFont(new Font("Arial", Font.BOLD, 14));
		chooselocation.setHorizontalAlignment((int) JPanel.CENTER_ALIGNMENT);
		
		frame2.add(panelf2);
		panelf2.add(chooselocation);
		panelf2.add(a);
		frame2.setLocationRelativeTo(null); // you make the window appear at the center of the screen
		frame2.setVisible(true);
	}
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == howtoplay)
			controls();
		
		else if(e.getSource() == Start)
		{
			l.setVisible(false);
			subframe.setLayout(new BorderLayout());
			subframe.setBackground(new Color(0x335988));
			
			ImageIcon icon = new ImageIcon("Avatar.png");
			String Player1 = (String) JOptionPane.showInputDialog(null, "Please enter your name.", "Player One", JOptionPane.INFORMATION_MESSAGE, icon, null, null);
			while(Player1 == null)
			{
				JOptionPane.showMessageDialog(null, "Player name cannot be empty.", null, JOptionPane.WARNING_MESSAGE);
				Player1 = (String) JOptionPane.showInputDialog(null, "Please enter your name.", "Player One", JOptionPane.INFORMATION_MESSAGE, icon, null, null);
			}
			Player first = new Player(Player1);
			String Player2 = (String) JOptionPane.showInputDialog(null, "Please enter your name.", "Player Two", JOptionPane.INFORMATION_MESSAGE, icon, null, null);
			while(Player2 == null)
			{
				JOptionPane.showMessageDialog(null, "Player name cannot be empty.", null, JOptionPane.WARNING_MESSAGE);
				Player2 = (String) JOptionPane.showInputDialog(null, "Please enter your name.", "Player Two", JOptionPane.INFORMATION_MESSAGE, icon, null, null);
			}
			Player second = new Player(Player2);
			game = new Game(first, second);
			
			try {
				Game.loadAbilities("Abilities.csv");
				Game.loadChampions("Champions.csv");
			} catch (IOException e1) {
				e1.printStackTrace();
			}
								
			label = new JLabel("Please choose your Champions.");
			label.setForeground(Color.white);
			label.setPreferredSize(new Dimension(1000,75));
			JPanel jpanel = new JPanel();
			jpanel.add(label);
			jpanel.setBackground(new Color(0x335988));
			subframe.add(label, BorderLayout.PAGE_START);
			label.setHorizontalAlignment((int) JFrame.CENTER_ALIGNMENT);
			label.setVerticalAlignment((int) JFrame.CENTER_ALIGNMENT);
			label.setFont(new Font("Arial", Font.BOLD, 20));
			
			champsbuttons = new JPanel();
			champsbuttons.setLayout(new GridLayout(3,5));
			champsbuttons.setBackground(Color.white);
			
			c1 = new JButton(Game.getAvailableChampions().get(0).getName());
			load(Game.getAvailableChampions().get(0), c1);
			
			c2 = new JButton(Game.getAvailableChampions().get(1).getName());
			load(Game.getAvailableChampions().get(1), c2);
			
			c3 = new JButton(Game.getAvailableChampions().get(2).getName());
			load(Game.getAvailableChampions().get(2), c3);
			
			c4 = new JButton(Game.getAvailableChampions().get(3).getName());
			load(Game.getAvailableChampions().get(3), c4);
			
			c5 = new JButton(Game.getAvailableChampions().get(4).getName());
			load(Game.getAvailableChampions().get(4), c5);
			
			c6 = new JButton(Game.getAvailableChampions().get(5).getName());
			load(Game.getAvailableChampions().get(5), c6);
			
			c7 = new JButton(Game.getAvailableChampions().get(6).getName());
			load(Game.getAvailableChampions().get(6), c7);
			
			c8 = new JButton(Game.getAvailableChampions().get(7).getName());
			load(Game.getAvailableChampions().get(7), c8);
			
			c9 = new JButton(Game.getAvailableChampions().get(8).getName());
			load(Game.getAvailableChampions().get(8), c9);
			
			c10 = new JButton(Game.getAvailableChampions().get(9).getName());
			load(Game.getAvailableChampions().get(9), c10);
			
			c11 = new JButton(Game.getAvailableChampions().get(10).getName());
			load(Game.getAvailableChampions().get(10), c11);
			
			c12 = new JButton(Game.getAvailableChampions().get(11).getName());
			load(Game.getAvailableChampions().get(11), c12);
			
			c13 = new JButton(Game.getAvailableChampions().get(12).getName());
			load(Game.getAvailableChampions().get(12), c13);
			
			c14 = new JButton(Game.getAvailableChampions().get(13).getName());
			load(Game.getAvailableChampions().get(13), c14);
			
			c15 = new JButton(Game.getAvailableChampions().get(14).getName());
			load(Game.getAvailableChampions().get(14), c15);
			
			Image newimg = Cap.getImage().getScaledInstance(80, 80, java.awt.Image.SCALE_SMOOTH);
			Cap = new ImageIcon(newimg);
			newimg = Deadpool.getImage().getScaledInstance(80, 80, java.awt.Image.SCALE_SMOOTH);
			Deadpool = new ImageIcon(newimg);
			newimg = Strange.getImage().getScaledInstance(80, 80, java.awt.Image.SCALE_SMOOTH);
			Strange = new ImageIcon(newimg);
			newimg = Quicksilver.getImage().getScaledInstance(80, 80, java.awt.Image.SCALE_SMOOTH);
			Quicksilver = new ImageIcon(newimg);
			newimg = Electro.getImage().getScaledInstance(80, 80, java.awt.Image.SCALE_SMOOTH);
			Electro = new ImageIcon(newimg);
			newimg = Ghost.getImage().getScaledInstance(80, 80, java.awt.Image.SCALE_SMOOTH);
			Ghost = new ImageIcon(newimg);
			newimg = Ironman.getImage().getScaledInstance(80, 80, java.awt.Image.SCALE_SMOOTH);
			Ironman = new ImageIcon(newimg);
			newimg = Hulk.getImage().getScaledInstance(80, 80, java.awt.Image.SCALE_SMOOTH);
			Hulk = new ImageIcon(newimg);
			newimg = Hela.getImage().getScaledInstance(80, 80, java.awt.Image.SCALE_SMOOTH);
			Hela = new ImageIcon(newimg);
			newimg = Loki.getImage().getScaledInstance(80, 80, java.awt.Image.SCALE_SMOOTH);
			Loki = new ImageIcon(newimg);
			newimg = Thor.getImage().getScaledInstance(80, 80, java.awt.Image.SCALE_SMOOTH);
			Thor = new ImageIcon(newimg);
			newimg = Yellow.getImage().getScaledInstance(80, 80, java.awt.Image.SCALE_SMOOTH);
			Yellow = new ImageIcon(newimg);
			newimg = Venom.getImage().getScaledInstance(80, 80, java.awt.Image.SCALE_SMOOTH);
			Venom = new ImageIcon(newimg);
			newimg = Spiderman.getImage().getScaledInstance(80, 80, java.awt.Image.SCALE_SMOOTH);
			Spiderman = new ImageIcon(newimg);
			newimg = Iceman.getImage().getScaledInstance(80, 80, java.awt.Image.SCALE_SMOOTH);
			Iceman = new ImageIcon(newimg);
			
			c1.setIcon(Cap);
			c1.setHorizontalTextPosition(JButton.LEFT);
			
			c2.setIcon(Deadpool);
			c2.setHorizontalTextPosition(JButton.LEFT);
			
			c3.setIcon(Strange);
			c3.setHorizontalTextPosition(JButton.LEFT);
			
			c4.setIcon(Electro);
			c4.setHorizontalTextPosition(JButton.LEFT);
			
			c5.setIcon(Ghost);
			c5.setHorizontalTextPosition(JButton.LEFT);
			
			c6.setIcon(Hela);
			c6.setHorizontalTextPosition(JButton.LEFT);
			
			c7.setIcon(Hulk);
			c7.setHorizontalTextPosition(JButton.LEFT);
			
			c8.setIcon(Iceman);
			c8.setHorizontalTextPosition(JButton.LEFT);
			
			c9.setIcon(Ironman);
			c9.setHorizontalTextPosition(JButton.LEFT);
			
			c10.setIcon(Loki);
			c10.setHorizontalTextPosition(JButton.LEFT);
			
			c11.setIcon(Quicksilver);
			c11.setHorizontalTextPosition(JButton.LEFT);
			
			c12.setIcon(Spiderman);
			c12.setHorizontalTextPosition(JButton.LEFT);
			
			c13.setIcon(Thor);
			c13.setHorizontalTextPosition(JButton.LEFT);
			
			c14.setIcon(Venom);
			c14.setHorizontalTextPosition(JButton.LEFT);
			
			c15.setIcon(Yellow);
			c15.setHorizontalTextPosition(JButton.LEFT);
			
			champsbuttons.add(c1);
			champsbuttons.add(c2);
			champsbuttons.add(c3);
			champsbuttons.add(c4);
			champsbuttons.add(c5);
			champsbuttons.add(c6);
			champsbuttons.add(c7);
			champsbuttons.add(c8);
			champsbuttons.add(c9);
			champsbuttons.add(c10);
			champsbuttons.add(c11);
			champsbuttons.add(c12);
			champsbuttons.add(c13);
			champsbuttons.add(c14);
			champsbuttons.add(c15);
			
			c1.addMouseListener(this);
			c2.addMouseListener(this);
			c3.addMouseListener(this);
			c4.addMouseListener(this);
			c5.addMouseListener(this);
			c6.addMouseListener(this);
			c7.addMouseListener(this);
			c8.addMouseListener(this);
			c9.addMouseListener(this);
			c10.addMouseListener(this);
			c11.addMouseListener(this);
			c12.addMouseListener(this);
			c13.addMouseListener(this);
			c14.addMouseListener(this);
			c15.addMouseListener(this);
			
			subframe.add(champsbuttons, BorderLayout.CENTER);
			champsbuttons.setVisible(true);
			frame.setVisible(true);
		}
		else if(e.getSource() == c1)
			chooseChamp(c1, "Captain America");
	
		else if(e.getSource() == c2)
			chooseChamp(c2,"Deadpool");
		
		else if(e.getSource() == c3)
			chooseChamp(c3, "Dr Strange");
		
		else if(e.getSource() == c4)
			chooseChamp(c4, "Electro");
		
		else if(e.getSource() == c5)
			chooseChamp(c5, "Ghost Rider");
		
		else if(e.getSource() == c6)
			chooseChamp(c6, "Hela");
		
		else if(e.getSource() == c7)
			chooseChamp(c7, "Hulk");
		
		else if(e.getSource() == c8)
			chooseChamp(c8, "Iceman");
		
		else if(e.getSource() == c9)
			chooseChamp(c9, "Ironman");
		
		else if(e.getSource() == c10)
			chooseChamp(c10, "Loki");
		
		else if(e.getSource() == c11)
			chooseChamp(c11, "Quicksilver");
		
		else if(e.getSource() == c12)
			chooseChamp(c12, "Spiderman");
		
		else if(e.getSource() == c13)
			chooseChamp(c13, "Thor");
		
		else if(e.getSource() == c14)
			chooseChamp(c14, "Venom");
		
		else if(e.getSource() == c15)
			chooseChamp(c15, "Yellow Jacket");
		
		else if(e.getSource() == champ11)
		{
			game.getFirstPlayer().setLeader(game.getFirstPlayer().getTeam().get(0));
			champ11.setEnabled(false);
			champ12.setVisible(false);
			champ13.setVisible(false);
			if(game.getFirstPlayer().getLeader() != null && game.getSecondPlayer().getLeader() != null)
			{	
				chooseleaders.setVisible(false);
				team1.setVisible(false);
				team2.setVisible(false);
				this.Play();
			}
		}
		
		else if(e.getSource() == champ12)
		{
			game.getFirstPlayer().setLeader(game.getFirstPlayer().getTeam().get(1));
			champ12.setEnabled(false);
			champ11.setVisible(false);
			champ13.setVisible(false);
			if(game.getFirstPlayer().getLeader() != null && game.getSecondPlayer().getLeader() != null)
			{	
				chooseleaders.setVisible(false);
				team1.setVisible(false);
				team2.setVisible(false);
				this.Play();
			}
		}
		
		else if(e.getSource() == champ13)
		{
			game.getFirstPlayer().setLeader(game.getFirstPlayer().getTeam().get(2));
			champ13.setEnabled(false);
			champ11.setVisible(false);
			champ12.setVisible(false);
			if(game.getFirstPlayer().getLeader() != null && game.getSecondPlayer().getLeader() != null)
			{	
				chooseleaders.setVisible(false);
				team1.setVisible(false);
				team2.setVisible(false);
				this.Play();
			}
		}
		
		else if(e.getSource() == champ21)
		{
			game.getSecondPlayer().setLeader(game.getSecondPlayer().getTeam().get(0));
			champ21.setEnabled(false);
			champ22.setVisible(false);
			champ23.setVisible(false);
			if(game.getFirstPlayer().getLeader() != null && game.getSecondPlayer().getLeader() != null)
			{	
				chooseleaders.setVisible(false);
				team1.setVisible(false);
				team2.setVisible(false);
				this.Play();
			}
		}
		
		else if(e.getSource() == champ22)
		{
			game.getSecondPlayer().setLeader(game.getSecondPlayer().getTeam().get(1));
			champ22.setEnabled(false);
			champ21.setVisible(false);
			champ23.setVisible(false);
			if(game.getFirstPlayer().getLeader() != null && game.getSecondPlayer().getLeader() != null)
			{	
				chooseleaders.setVisible(false);
				team1.setVisible(false);
				team2.setVisible(false);
				this.Play();
			}
		}
		
		else if(e.getSource() == champ23)
		{
			game.getSecondPlayer().setLeader(game.getSecondPlayer().getTeam().get(2));
			champ23.setEnabled(false);
			champ21.setVisible(false);
			champ22.setVisible(false);
			if(game.getFirstPlayer().getLeader() != null && game.getSecondPlayer().getLeader() != null)
			{	
				chooseleaders.setVisible(false);
				team1.setVisible(false);
				team2.setVisible(false);
				this.Play();
			}
		}
		
		else if(e.getSource() == endturn)
		{
			game.endTurn();
			showCurrentChamp();
			viewPQ();
			printChamps(game.getFirstPlayer(), panel1);
			printChamps(game.getSecondPlayer(), panel2);
			updateboard();
		}
		
		else if(e.getSource() == b00)
		{
			pointx = 0;
			pointy = 0;
			
			frame2.toFront();
		}
		else if(e.getSource() == b01)
		{
			pointx = 0;
			pointy = 1;
			
			frame2.toFront();
		}
		else if(e.getSource() == b02)
		{
			pointx = 0;
			pointy = 2;
			
			frame2.toFront();
		}
		else if(e.getSource() == b03)
		{
			pointx = 0;
			pointy = 3;
			
			frame2.toFront();
		}
		else if(e.getSource() == b04)
		{
			pointx = 0;
			pointy = 4;
			
			frame2.toFront();
		}
		else if(e.getSource() == b10)
		{
			pointx = 1;
			pointy = 0;
			
			frame2.toFront();
		}
		else if(e.getSource() == b11)
		{
			pointx = 1;
			pointy = 1;
			
			frame2.toFront();
		}
		else if(e.getSource() == b12)
		{
			pointx = 1;
			pointy = 2;
			
			frame2.toFront();
		}
		else if(e.getSource() == b13)
		{
			pointx = 1;
			pointy = 3;
			
			frame2.toFront();
		}
		else if(e.getSource() == b14)
		{
			pointx = 1;
			pointy = 4;
			
			frame2.toFront();
		}
		else if(e.getSource() == b20)
		{
			pointx = 2;
			pointy = 0;
			
			frame2.toFront();
		}
		else if(e.getSource() == b21)
		{
			pointx = 2;
			pointy = 1;
			
			frame2.toFront();
		}
		else if(e.getSource() == b22)
		{
			pointx = 2;
			pointy = 2;
			
			frame2.toFront();
		}
		else if(e.getSource() == b23)
		{
			pointx = 2;
			pointy = 3;
			
			frame2.toFront();
		}
		else if(e.getSource() == b24)
		{
			pointx = 2;
			pointy = 4;
			
			frame2.toFront();
		}
		else if(e.getSource() == b30)
		{
			pointx = 3;
			pointy = 0;
			
			frame2.toFront();
		}
		else if(e.getSource() == b31)
		{
			pointx = 3;
			pointy = 1;
			
			frame2.toFront();
		}
		else if(e.getSource() == b32)
		{
			pointx = 3;
			pointy = 2;
			
			frame2.toFront();
		}
		else if(e.getSource() == b33)
		{
			pointx = 3;
			pointy = 3;
			
			frame2.toFront();
		}
		else if(e.getSource() == b34)
		{
			pointx = 3;
			pointy = 4;
			
			frame2.toFront();
		}
		else if(e.getSource() == b40)
		{
			pointx = 4;
			pointy = 0;
			
			frame2.toFront();
		}
		else if(e.getSource() == b41)
		{
			pointx = 4;
			pointy = 1;
			
			frame2.toFront();
		}
		else if(e.getSource() == b42)
		{
			pointx = 4;
			pointy = 2;
			
			frame2.toFront();
		}
		else if(e.getSource() == b43)
		{
			pointx = 4;
			pointy = 3;
			
			frame2.toFront();
		}
		else if(e.getSource() == b44)
		{
			pointx = 4;
			pointy = 4;
			
			frame2.toFront();
		}
		
		else if(e.getSource() == done)
		{
			frame2.dispose();
			
			try {
				game.castAbility(game.getCurrentChampion().getAbilities().get(ability), pointx, pointy);
			} catch (NotEnoughResourcesException e1) {
				JOptionPane.showMessageDialog(null, "You don't have enough resources.", null, JOptionPane.WARNING_MESSAGE);
			} catch (AbilityUseException e1) {
				JOptionPane.showMessageDialog(null, "Cannot use ability.", null, JOptionPane.WARNING_MESSAGE);
			} catch (InvalidTargetException e1) {
				JOptionPane.showMessageDialog(null, "Invalid target.", null, JOptionPane.WARNING_MESSAGE);
			} catch (CloneNotSupportedException e1) {
				e1.printStackTrace();
			}
			
			printChamps(game.getFirstPlayer(), panel1);
			printChamps(game.getSecondPlayer(), panel2);
			showCurrentChamp();
			updateboard();
			viewPQ();
			checkgameover();
		}
	}
	

	public void showCurrentChamp()
	{
		panel4.removeAll();
		Champion c = game.getCurrentChampion();
		
		String type;
		if(c instanceof Hero)
			type = "Hero";
		else if(c instanceof AntiHero)
			type = "AntiHero";
		else
			type = "Villain";
		
		JLabel effects = new JLabel("Applied effects: ");
		for(int j = 0; j<c.getAppliedEffects().size() ;j++)
			effects.setText(effects.getText() + "   " + Integer.toString(j+1) + "- " + c.getAppliedEffects().get(j).getName() + " for " + c.getAppliedEffects().get(j).getDuration() + " Rounds.");		
		
		JPanel p = new JPanel();
		p.setBounds(0, 0, 800, 20);
		p.setBackground(Color.white);
		p.setLayout(new GridLayout(1, 8));
		
		JLabel j1 = new JLabel(c.getName());
		JLabel j2 = new JLabel(type);
		JLabel j3 = new JLabel("CurrentHP:  " + c.getCurrentHP());
		JLabel j4 = new JLabel("Mana:  " + c.getMana());
		JLabel j5 = new JLabel(c.getCurrentActionPoints() + " Points available");
		JLabel j6 = new JLabel("Damage:  " + c.getAttackDamage());
		JLabel j7 = new JLabel("Range:  " + c.getAttackRange());
		JLabel j8 = new JLabel("Speed:  " + c.getSpeed());

		switch(c.getName())
		{
			case "Captain America": j1.setForeground(new Color(0x00008B)) ;break;
			case "Deadpool": j1.setForeground(Color.red) ;break;
			case "Dr Strange": j1.setForeground(new Color(0xfab538)) ;break;
			case "Electro": j1.setForeground(new Color(0x1f6a96)) ;break;
			case "Ghost Rider": j1.setForeground(new Color(0xFD6E05)) ;break;
			case "Hela": j1.setForeground(new Color(0x013220)) ;break;
			case "Hulk": j1.setForeground(new Color(0x70964b)) ;break;
			case "Iceman": j1.setForeground(new Color(0x00CEF1)) ;break;
			case "Ironman": j1.setForeground(new Color(0xaa0505)) ;break;
			case "Loki": j1.setForeground(new Color(0x0b450a)) ;break;
			case "Quicksilver": j1.setForeground(Color.gray) ;break;
			case "Spiderman": j1.setForeground(Color.red) ;break;
			case "Thor": j1.setForeground(new Color(0x697F79)) ;break;
			case "Venom": j1.setForeground(Color.BLACK) ;break;
			case "Yellow Jacket": j1.setForeground(Color.orange) ;break;
		}
		
		j1.setFont(new Font("Arial", Font.BOLD, 13));
		j1.setHorizontalAlignment((int) JPanel.CENTER_ALIGNMENT);
		j2.setHorizontalAlignment((int) JPanel.CENTER_ALIGNMENT);
		j3.setHorizontalAlignment((int) JPanel.CENTER_ALIGNMENT);
		j4.setHorizontalAlignment((int) JPanel.CENTER_ALIGNMENT);
		j5.setHorizontalAlignment((int) JPanel.CENTER_ALIGNMENT);
		j6.setHorizontalAlignment((int) JPanel.CENTER_ALIGNMENT);
		j7.setHorizontalAlignment((int) JPanel.CENTER_ALIGNMENT);
		j8.setHorizontalAlignment((int) JPanel.CENTER_ALIGNMENT);
		
		p.add(j1);
		p.add(j2);
		p.add(j3); 
		p.add(j4);
		p.add(j5);
		p.add(j6);
		p.add(j7);
		p.add(j8);
		
		
		panel4.add(p);
		panel4.add(effects);
		panel4.add(new JLabel("Abilities: ")).setBounds(0, 40, 1000, 20);
		
		effects.setBounds(0, 20, 2000, 20);
		
		int size = game.getCurrentChampion().getAbilities().size();
		
		abilitiespanel = new JPanel();		
		abilitiespanel.setBounds(0, 60, 1350, 80);
		abilitiespanel.setBackground(Color.white);
		abilitiespanel.setLayout(new GridLayout(size,9));
		
		panel4.add(abilitiespanel);
		
		for(int j = 0; j<c.getAbilities().size() ;j++)
		{
			String abilitytype;
			String special;
			if(c.getAbilities().get(j) instanceof HealingAbility)
			{
				abilitytype = "Healing Ability";
				special = Integer.toString(((HealingAbility) c.getAbilities().get(j)).getHealAmount()) + " Heal amount";
			}
			else if(c.getAbilities().get(j) instanceof DamagingAbility)
			{
				abilitytype = "Damaging Ability";
				special = Integer.toString(((DamagingAbility) c.getAbilities().get(j)).getDamageAmount()) + " Damage amount";
			}
			else
			{
				abilitytype = "Crowd Control Ability";
				special = ((CrowdControlAbility) c.getAbilities().get(j)).getEffect().getName() + " Effect";
			}
			
			l1 = new JLabel(Integer.toString(j+1) + "-  " + c.getAbilities().get(j).getName() + ":");
			l2 = new JLabel(abilitytype);
			l3 = new JLabel("Cast area: " + c.getAbilities().get(j).getCastArea());
			l4 = new JLabel("Cast range: " + c.getAbilities().get(j).getCastRange());
			l5 = new JLabel("Mana: " + c.getAbilities().get(j).getManaCost());
			l6 = new JLabel("Required action points: " + c.getAbilities().get(j).getRequiredActionPoints());
			l7  =new JLabel("Current cooldown: " + c.getAbilities().get(j).getCurrentCooldown());
			l8 = new JLabel("Base cooldown: " + c.getAbilities().get(j).getBaseCooldown());
			l9 = new JLabel(special);
			
			l2.setHorizontalAlignment((int) JPanel.CENTER_ALIGNMENT);
			l3.setHorizontalAlignment((int) JPanel.CENTER_ALIGNMENT);
			l4.setHorizontalAlignment((int) JPanel.CENTER_ALIGNMENT);
			l5.setHorizontalAlignment((int) JPanel.CENTER_ALIGNMENT);
			l6.setHorizontalAlignment((int) JPanel.CENTER_ALIGNMENT);
			l7.setHorizontalAlignment((int) JPanel.CENTER_ALIGNMENT);
			l8.setHorizontalAlignment((int) JPanel.CENTER_ALIGNMENT);
			l9.setHorizontalAlignment((int) JPanel.CENTER_ALIGNMENT);
			
			abilitiespanel.add(l1);
			abilitiespanel.add(l2); 
			abilitiespanel.add(l3);
			abilitiespanel.add(l4);
			abilitiespanel.add(l5);
			abilitiespanel.add(l6);
			abilitiespanel.add(l7);
			abilitiespanel.add(l8);
			abilitiespanel.add(l9);
			
		}
	}
	
	
	public void viewPQ()
	{
		boolean first = true;
		queue.setText("");
		ArrayList<Champion> ac = new ArrayList<Champion>();
		int size = game.getTurnOrder().size();
		for(int i = 0; i<size ;i++)
		{
			Champion c = (Champion) game.getTurnOrder().remove();
			if(!first)
				queue.setText(c.getName() + " <- " + queue.getText());
			else
			{
				queue.setText(c.getName());
				first = false;
			}
			ac.add(c);
		}
		while(!ac.isEmpty())
			game.getTurnOrder().insert(ac.remove(0));
		panel5.add(queue);
	}
	
	
	public void viewdetails(Champion c) 
	{
		jp.removeAll();
		jp.setLayout(new GridLayout(2,5));
		
		JLabel j1 = new JLabel("MaxHP: " + Integer.toString(c.getMaxHP()));
		JLabel j2 = new JLabel("Mana: " + Integer.toString(c.getMana()));
		JLabel j3 = new JLabel("Action points per turn: " + Integer.toString(c.getCurrentActionPoints()));
		JLabel j4 = new JLabel("Attack Damage: " + Integer.toString(c.getAttackDamage()));
		JLabel j5 = new JLabel("Attack Range: " + Integer.toString(c.getAttackRange()));
		JLabel j6 = new JLabel("Speed: " + Integer.toString(c.getSpeed()));
		JLabel j7 = new JLabel("Abilities: ");
		
		j1.setHorizontalAlignment((int) JFrame.CENTER_ALIGNMENT);
		j2.setHorizontalAlignment((int) JFrame.CENTER_ALIGNMENT);
		j3.setHorizontalAlignment((int) JFrame.CENTER_ALIGNMENT);
		j4.setHorizontalAlignment((int) JFrame.CENTER_ALIGNMENT);
		j5.setHorizontalAlignment((int) JFrame.CENTER_ALIGNMENT);
		j6.setHorizontalAlignment((int) JFrame.CENTER_ALIGNMENT);
		j7.setHorizontalAlignment((int) JFrame.CENTER_ALIGNMENT);

		jp.add(j1);
		jp.add(j2);
		jp.add(j3);
		jp.add(j4);
		jp.add(j5);
		jp.add(j6);
		jp.add(j7);
		
		j1.setForeground(Color.white);
		j2.setForeground(Color.white);
		j3.setForeground(Color.white);
		j4.setForeground(Color.white);
		j5.setForeground(Color.white);
		j6.setForeground(Color.white);
		j7.setForeground(Color.white);
		
		for(int j = 0; j<c.getAbilities().size() ;j++)
		{
			JLabel j8 = new JLabel(Integer.toString(j+1) + "- " + c.getAbilities().get(j).getName() + ". " );
			jp.add(j8);
			j8.setHorizontalAlignment((int) JFrame.CENTER_ALIGNMENT);
			j8.setForeground(Color.white);
		}

		jp.setBackground(new Color(0x335988));
		jp.setPreferredSize(new Dimension(0,200));
		frame.add(jp, BorderLayout.PAGE_END);
		frame.setVisible(true);
	}
	
	
	public void load(Champion c, JButton Name)
	{
		Name.setFont(new Font("Comic Sans",Font.BOLD + Font.ITALIC,15));		
		Name.setContentAreaFilled(false);
		Name.setOpaque(false);
		Name.setForeground(Color.black);
		Name.setText(c.getName());
		Name.addActionListener(this);
		Name.setFocusable(false);
		
		if(c instanceof Hero)
			Name.setForeground(new Color(0x008b00));
		else if(c instanceof Villain)
			Name.setForeground(new Color(0x8b0000));
	}
		
	
	public void chooseChamp(JButton button, String cName){
		if(game.getFirstPlayer().getTeam().size()<3)
		{
			find(game.getFirstPlayer(), cName);
			button.setEnabled(false);
		}
		else if(game.getSecondPlayer().getTeam().size()<3)
		{
			find(game.getSecondPlayer(), cName);
			button.setEnabled(false);
			if(game.getSecondPlayer().getTeam().size() == 3)
			{
				jp.setVisible(false);
				label.setVisible(false);
				champsbuttons.setVisible(false);
				this.chooseleaders();
				return;
			}
		}
	}
		
	
	public void find(Player p, String name)
	{
		for(int i = 0; i<Game.getAvailableChampions().size() ;i++)
			if(Game.getAvailableChampions().get(i).getName().equals(name))
				p.getTeam().add(Game.getAvailableChampions().get(i));
	}
		
	
	public void printChamps(Player player,JPanel panel)
	{
		panel.removeAll();
		
		JLabel playername = new JLabel (player.getName());
		panel.add(playername);
		playername.setFont(new Font("Arial", Font.BOLD, 20));
		playername.setBounds(0, 0, 250, 25);
		playername.setHorizontalAlignment((int) JPanel.CENTER_ALIGNMENT);
		playername.setForeground(Color.white);
		
		if(playername.getText().equals(game.getFirstPlayer().getName()))
			panel.setBackground(new Color(0x335988));
		else
			panel.setBackground(new Color(0x8B0000));
		
		String isleaderabilityused = "";
		boolean f = false;
		if(player == game.getFirstPlayer())
		{
			if(game.isFirstLeaderAbilityUsed())
			{
				isleaderabilityused = "Leader ability used";
				f = true;
			}
			else
			{
				isleaderabilityused = "Leader ability available";
				f = false;
			}
		}
		else if(player == game.getSecondPlayer())
		{
			if(game.isSecondLeaderAbilityUsed())
			{
				isleaderabilityused = "Leader ability used";
				f = true;
			}
			else
			{
				isleaderabilityused = "Leader ability available";
				f = false;
			}
		}
		
		JLabel leaderability = new JLabel(isleaderabilityused);
		
		panel.add(leaderability);
		
		if(f)
			leaderability.setForeground(Color.red);
		else
			leaderability.setForeground(Color.green);
		leaderability.setBounds(0, 25, 250, 25);
		
		for(int i = 0; i<player.getTeam().size() ;i++)
		{
			Champion c = player.getTeam().get(i);
			JLabel champs = new JLabel(c.getName());
			panel.add(champs);
			champs.setFont(new Font("Arial", Font.BOLD, 15));
			champs.setHorizontalAlignment((int) JPanel.CENTER_ALIGNMENT);
			champs.setBounds(0, 50+180*i, 250, 20);
			champs.setForeground(Color.white);
			
			String type;
			if(c instanceof Hero)
				type = "Hero";
			else if(c instanceof AntiHero)
				type = "AntiHero";
			else
				type = "Villain";
			
			String isleader;
			if(player.getLeader() == c)
				isleader = "Leader";
			else
				isleader = "";
			
			JLabel effects = new JLabel("<html>" + "Applied effects: " + "<br>");
			for(int j = 0; j<c.getAppliedEffects().size() ;j++)
				effects.setText(effects.getText() + c.getAppliedEffects().get(j).getName() + " for " + c.getAppliedEffects().get(j).getDuration() + " Rounds." + "<br>");		
			effects.setText(effects.getText() + "</html>");
			
			JLabel playerdetails = new JLabel("<html>" + c.getCurrentHP() + " HP" + "<br>" 
					+ c.getMana() + " Mana" + "<br>" 
					+ c.getSpeed() + " Speed" + "<br>"
					+ c.getMaxActionPointsPerTurn() + " Points per turn" + "<br>"
					+ c.getAttackDamage() + " Damage" + "<br>"
					+ c.getAttackRange() + " Range" + "<br>"
					+ type + "<br>"
					+ isleader + "<br>"
					+ "</html>");
			
			playerdetails.setForeground(Color.white);
			effects.setForeground(Color.white);
			panel.add(playerdetails);
			panel.add(effects);
			playerdetails.setBounds(0, 50 + 180*i, 124, 200);
			effects.setBounds(125, 50 + 180*i, 125, 200);
			frame.repaint();
		}
	}
	
	
	
	public void updateboard() {
		
		b00.setIcon(null);
		b01.setIcon(null);
		b02.setIcon(null);
		b03.setIcon(null);
		b04.setIcon(null);
		b10.setIcon(null);
		b11.setIcon(null);
		b12.setIcon(null);
		b13.setIcon(null);
		b14.setIcon(null);
		b20.setIcon(null);
		b21.setIcon(null);
		b22.setIcon(null);
		b23.setIcon(null);
		b24.setIcon(null);
		b30.setIcon(null);
		b31.setIcon(null);
		b32.setIcon(null);
		b33.setIcon(null);
		b34.setIcon(null);
		b40.setIcon(null);
		b41.setIcon(null);
		b42.setIcon(null);
		b43.setIcon(null);
		b44.setIcon(null);
		
		b00.setBackground(Color.white);
		b01.setBackground(Color.white);
		b02.setBackground(Color.white);
		b03.setBackground(Color.white);
		b04.setBackground(Color.white);
		b10.setBackground(Color.white);
		b11.setBackground(Color.white);
		b12.setBackground(Color.white);
		b13.setBackground(Color.white);
		b14.setBackground(Color.white);
		b20.setBackground(Color.white);
		b21.setBackground(Color.white);
		b22.setBackground(Color.white);
		b23.setBackground(Color.white);
		b24.setBackground(Color.white);
		b30.setBackground(Color.white);
		b31.setBackground(Color.white);
		b32.setBackground(Color.white);
		b33.setBackground(Color.white);
		b34.setBackground(Color.white);
		b40.setBackground(Color.white);
		b41.setBackground(Color.white);
		b42.setBackground(Color.white);
		b43.setBackground(Color.white);
		b44.setBackground(Color.white);
		
		b00.setText(null);
		b01.setText(null);
		b02.setText(null);
		b03.setText(null);
		b04.setText(null);
		b10.setText(null);
		b11.setText(null);
		b12.setText(null);
		b13.setText(null);
		b14.setText(null);
		b20.setText(null);
		b21.setText(null);
		b22.setText(null);
		b23.setText(null);
		b24.setText(null);
		b30.setText(null);
		b31.setText(null);
		b32.setText(null);
		b33.setText(null);
		b34.setText(null);
		b40.setText(null);
		b41.setText(null);
		b42.setText(null);
		b43.setText(null);
		b44.setText(null);
		
		for(int i = 0; i<game.getFirstPlayer().getTeam().size() ;i++)
		{
			String c = game.getFirstPlayer().getTeam().get(i).getName();
			int x = game.getFirstPlayer().getTeam().get(i).getLocation().x;
			int y = game.getFirstPlayer().getTeam().get(i).getLocation().y;
			
			championlocation(c, x, y);
		}
		
		for(int i = 0; i<game.getSecondPlayer().getTeam().size() ;i++)
		{
			String c = game.getSecondPlayer().getTeam().get(i).getName();
			int x = game.getSecondPlayer().getTeam().get(i).getLocation().x;
			int y = game.getSecondPlayer().getTeam().get(i).getLocation().y;
			
			championlocation(c, x, y);
		}
		
		for(int x = 0; x<5 ;x++)
			for(int y = 0; y<5 ;y++)
				checkcover(x, y);
		
		for(int i = 0; i<covers.size() ;i++)
			if(covers.get(i).getText() == null)
			{
				covers.get(i).setBackground(Color.white);
				covers.remove(i);
			}
	}
	
	
	public void checkcover(int x, int y) {
		if(game.getBoard()[x][y] instanceof Cover)
		{
			if(x == 0 && y == 0)
			{
				b00.setBackground(Color.black);
				b00.setText(Integer.toString(((Cover) game.getBoard()[x][y]).getCurrentHP()));
				b00.setForeground(Color.white);
				
				covers.add(b00);
			}
			
			else if(x == 0 && y == 1)
			{
				b01.setBackground(Color.black);
				b01.setText(Integer.toString(((Cover) game.getBoard()[x][y]).getCurrentHP()));
				b01.setForeground(Color.white);
				
				covers.add(b01);
			}
			
			else if(x == 0 && y == 2)
			{
				b02.setBackground(Color.black);
				b02.setText(Integer.toString(((Cover) game.getBoard()[x][y]).getCurrentHP()));
				b02.setForeground(Color.white);
				
				covers.add(b02);
			}
			
			else if(x == 0 && y == 3)
			{
				b03.setBackground(Color.black);
				b03.setText(Integer.toString(((Cover) game.getBoard()[x][y]).getCurrentHP()));
				b03.setForeground(Color.white);
				
				covers.add(b03);
			}
			
			else if(x == 0 && y == 4)
			{
				b04.setBackground(Color.black);
				b04.setText(Integer.toString(((Cover) game.getBoard()[x][y]).getCurrentHP()));
				b04.setForeground(Color.white);
				
				covers.add(b04);
			}
			
			else if(x == 1 && y == 0)
			{
				b10.setBackground(Color.black);
				b10.setText(Integer.toString(((Cover) game.getBoard()[x][y]).getCurrentHP()));
				b10.setForeground(Color.white);
				
				covers.add(b10);
			}
			
			else if(x == 1 && y == 1)
			{
				b11.setBackground(Color.black);
				b11.setText(Integer.toString(((Cover) game.getBoard()[x][y]).getCurrentHP()));
				b11.setForeground(Color.white);
				
				covers.add(b11);
			}
			
			else if(x == 1 && y == 2)
			{
				b12.setBackground(Color.black);
				b12.setText(Integer.toString(((Cover) game.getBoard()[x][y]).getCurrentHP()));
				b12.setForeground(Color.white);
				
				covers.add(b12);
			}
			
			else if(x == 1 && y == 3)
			{
				b13.setBackground(Color.black);
				b13.setText(Integer.toString(((Cover) game.getBoard()[x][y]).getCurrentHP()));
				b13.setForeground(Color.white);
				
				covers.add(b13);
			}
			
			else if(x == 1 && y == 4)
			{
				b14.setBackground(Color.black);
				b14.setText(Integer.toString(((Cover) game.getBoard()[x][y]).getCurrentHP()));
				b14.setForeground(Color.white);
				
				covers.add(b14);
			}
			
			else if(x == 2 && y == 0)
			{
				b20.setBackground(Color.black);
				b20.setText(Integer.toString(((Cover) game.getBoard()[x][y]).getCurrentHP()));
				b20.setForeground(Color.white);
				
				covers.add(b20);
			}
			
			else if(x == 2 && y == 1)
			{
				b21.setBackground(Color.black);
				b21.setText(Integer.toString(((Cover) game.getBoard()[x][y]).getCurrentHP()));
				b21.setForeground(Color.white);
				
				covers.add(b21);
			}
			
			else if(x == 2 && y == 2)
			{
				b22.setBackground(Color.black);
				b22.setText(Integer.toString(((Cover) game.getBoard()[x][y]).getCurrentHP()));
				b22.setForeground(Color.white);
				
				covers.add(b22);
			}
			
			else if(x == 2 && y == 3)
			{
				b23.setBackground(Color.black);
				b23.setText(Integer.toString(((Cover) game.getBoard()[x][y]).getCurrentHP()));
				b23.setForeground(Color.white);
				
				covers.add(b23);
			}
			
			else if(x == 2 && y == 4)
			{
				b24.setBackground(Color.black);
				b24.setText(Integer.toString(((Cover) game.getBoard()[x][y]).getCurrentHP()));
				b24.setForeground(Color.white);
				
				covers.add(b24);
			}
			
			else if(x == 3 && y == 0)
			{
				b30.setBackground(Color.black);
				b30.setText(Integer.toString(((Cover) game.getBoard()[x][y]).getCurrentHP()));
				b30.setForeground(Color.white);
				
				covers.add(b30);
			}
			
			else if(x == 3 && y == 1)
			{
				b31.setBackground(Color.black);
				b31.setText(Integer.toString(((Cover) game.getBoard()[x][y]).getCurrentHP()));
				b31.setForeground(Color.white);
				
				covers.add(b31);
			}
			
			else if(x == 3 && y == 2)
			{
				b32.setBackground(Color.black);
				b32.setText(Integer.toString(((Cover) game.getBoard()[x][y]).getCurrentHP()));
				b32.setForeground(Color.white);
				
				covers.add(b32);
			}
			
			else if(x == 3 && y == 3)
			{
				b33.setBackground(Color.black);
				b33.setText(Integer.toString(((Cover) game.getBoard()[x][y]).getCurrentHP()));
				b33.setForeground(Color.white);
				
				covers.add(b33);
			}
			
			else if(x == 3 && y == 4)
			{
				b34.setBackground(Color.black);
				b34.setText(Integer.toString(((Cover) game.getBoard()[x][y]).getCurrentHP()));
				b34.setForeground(Color.white);
				
				covers.add(b34);
			}
			
			else if(x == 4 && y == 0)
			{
				b40.setBackground(Color.black);
				b40.setText(Integer.toString(((Cover) game.getBoard()[x][y]).getCurrentHP()));
				b40.setForeground(Color.white);
				
				covers.add(b40);
			}
			
			else if(x == 4 && y == 1)
			{
				b41.setBackground(Color.black);
				b41.setText(Integer.toString(((Cover) game.getBoard()[x][y]).getCurrentHP()));
				b41.setForeground(Color.white);
				
				covers.add(b41);
			}
			
			else if(x == 4 && y == 2)
			{
				b42.setBackground(Color.black);
				b42.setText(Integer.toString(((Cover) game.getBoard()[x][y]).getCurrentHP()));
				b42.setForeground(Color.white);
				
				covers.add(b42);
			}
			
			else if(x == 4 && y == 3)
			{
				b43.setBackground(Color.black);
				b43.setText(Integer.toString(((Cover) game.getBoard()[x][y]).getCurrentHP()));
				b43.setForeground(Color.white);
				
				covers.add(b43);
			}
			
			else if(x == 4 && y == 4)
			{
				b44.setBackground(Color.black);
				b44.setText(Integer.toString(((Cover) game.getBoard()[x][y]).getCurrentHP()));
				b44.setForeground(Color.white);
				
				covers.add(b44);
			}
		}
	}
	
	
	public void championlocation(String c, int x, int y) {
		
		if(x == 0 && y == 0)
		{
			champimage(c, b00);
			for(int i = 0; i<game.getFirstPlayer().getTeam().size() ;i++)
				if(game.getFirstPlayer().getTeam().get(i).getName().equals(c))
					b00.setBackground(new Color(0x335988));
			for(int i = 0; i<game.getSecondPlayer().getTeam().size() ;i++)
				if(game.getSecondPlayer().getTeam().get(i).getName().equals(c))
					b00.setBackground(new Color(0x8B0000));
		}
		
		else if(x == 0 && y == 1)
		{
			champimage(c, b01);
			for(int i = 0; i<game.getFirstPlayer().getTeam().size() ;i++)
				if(game.getFirstPlayer().getTeam().get(i).getName().equals(c))
					b01.setBackground(new Color(0x335988));
			for(int i = 0; i<game.getSecondPlayer().getTeam().size() ;i++)
				if(game.getSecondPlayer().getTeam().get(i).getName().equals(c))
					b01.setBackground(new Color(0x8B0000));
		}
		
		else if(x == 0 && y == 2)
		{
			champimage(c, b02);
			for(int i = 0; i<game.getFirstPlayer().getTeam().size() ;i++)
				if(game.getFirstPlayer().getTeam().get(i).getName().equals(c))
					b02.setBackground(new Color(0x335988));
			for(int i = 0; i<game.getSecondPlayer().getTeam().size() ;i++)
				if(game.getSecondPlayer().getTeam().get(i).getName().equals(c))
					b02.setBackground(new Color(0x8B0000));
		}
		
		else if(x == 0 && y == 3)
		{
			champimage(c, b03);
			for(int i = 0; i<game.getFirstPlayer().getTeam().size() ;i++)
				if(game.getFirstPlayer().getTeam().get(i).getName().equals(c))
					b03.setBackground(new Color(0x335988));
			for(int i = 0; i<game.getSecondPlayer().getTeam().size() ;i++)
				if(game.getSecondPlayer().getTeam().get(i).getName().equals(c))
					b03.setBackground(new Color(0x8B0000));
		}
		
		else if(x == 0 && y == 4)
		{
			champimage(c, b04);
			for(int i = 0; i<game.getFirstPlayer().getTeam().size() ;i++)
				if(game.getFirstPlayer().getTeam().get(i).getName().equals(c))
					b04.setBackground(new Color(0x335988));
			for(int i = 0; i<game.getSecondPlayer().getTeam().size() ;i++)
				if(game.getSecondPlayer().getTeam().get(i).getName().equals(c))
					b04.setBackground(new Color(0x8B0000));
		}
		
		else if(x == 1 && y == 0)
		{
			champimage(c, b10);
			for(int i = 0; i<game.getFirstPlayer().getTeam().size() ;i++)
				if(game.getFirstPlayer().getTeam().get(i).getName().equals(c))
					b10.setBackground(new Color(0x335988));
			for(int i = 0; i<game.getSecondPlayer().getTeam().size() ;i++)
				if(game.getSecondPlayer().getTeam().get(i).getName().equals(c))
					b10.setBackground(new Color(0x8B0000));
		}
		
		else if(x == 1 && y == 1)
		{
			champimage(c, b11);
			for(int i = 0; i<game.getFirstPlayer().getTeam().size() ;i++)
				if(game.getFirstPlayer().getTeam().get(i).getName().equals(c))
					b11.setBackground(new Color(0x335988));
			for(int i = 0; i<game.getSecondPlayer().getTeam().size() ;i++)
				if(game.getSecondPlayer().getTeam().get(i).getName().equals(c))
					b11.setBackground(new Color(0x8B0000));
		}
		
		else if(x == 1 && y == 2)
		{
			champimage(c, b12);
			for(int i = 0; i<game.getFirstPlayer().getTeam().size() ;i++)
				if(game.getFirstPlayer().getTeam().get(i).getName().equals(c))
					b12.setBackground(new Color(0x335988));
			for(int i = 0; i<game.getSecondPlayer().getTeam().size() ;i++)
				if(game.getSecondPlayer().getTeam().get(i).getName().equals(c))
					b12.setBackground(new Color(0x8B0000));
		}
		
		else if(x == 1 && y == 3)
		{
			champimage(c, b13);
			for(int i = 0; i<game.getFirstPlayer().getTeam().size() ;i++)
				if(game.getFirstPlayer().getTeam().get(i).getName().equals(c))
					b13.setBackground(new Color(0x335988));
			for(int i = 0; i<game.getSecondPlayer().getTeam().size() ;i++)
				if(game.getSecondPlayer().getTeam().get(i).getName().equals(c))
					b13.setBackground(new Color(0x8B0000));
		}
		
		else if(x == 1 && y == 4)
		{
			champimage(c, b14);
			for(int i = 0; i<game.getFirstPlayer().getTeam().size() ;i++)
				if(game.getFirstPlayer().getTeam().get(i).getName().equals(c))
					b14.setBackground(new Color(0x335988));
			for(int i = 0; i<game.getSecondPlayer().getTeam().size() ;i++)
				if(game.getSecondPlayer().getTeam().get(i).getName().equals(c))
					b14.setBackground(new Color(0x8B0000));
		}
		
		else if(x == 2 && y == 0)
		{
			champimage(c, b20);
			for(int i = 0; i<game.getFirstPlayer().getTeam().size() ;i++)
				if(game.getFirstPlayer().getTeam().get(i).getName().equals(c))
					b20.setBackground(new Color(0x335988));
			for(int i = 0; i<game.getSecondPlayer().getTeam().size() ;i++)
				if(game.getSecondPlayer().getTeam().get(i).getName().equals(c))
					b20.setBackground(new Color(0x8B0000));
		}
		
		else if(x == 2 && y == 1)
		{
			champimage(c, b21);
			for(int i = 0; i<game.getFirstPlayer().getTeam().size() ;i++)
				if(game.getFirstPlayer().getTeam().get(i).getName().equals(c))
					b21.setBackground(new Color(0x335988));
			for(int i = 0; i<game.getSecondPlayer().getTeam().size() ;i++)
				if(game.getSecondPlayer().getTeam().get(i).getName().equals(c))
					b21.setBackground(new Color(0x8B0000));
		}
		
		else if(x == 2 && y == 2)
		{
			champimage(c, b22);
			for(int i = 0; i<game.getFirstPlayer().getTeam().size() ;i++)
				if(game.getFirstPlayer().getTeam().get(i).getName().equals(c))
					b22.setBackground(new Color(0x335988));
			for(int i = 0; i<game.getSecondPlayer().getTeam().size() ;i++)
				if(game.getSecondPlayer().getTeam().get(i).getName().equals(c))
					b22.setBackground(new Color(0x8B0000));
		}
		
		else if(x == 2 && y == 3)
		{
			champimage(c, b23);
			for(int i = 0; i<game.getFirstPlayer().getTeam().size() ;i++)
				if(game.getFirstPlayer().getTeam().get(i).getName().equals(c))
					b23.setBackground(new Color(0x335988));
			for(int i = 0; i<game.getSecondPlayer().getTeam().size() ;i++)
				if(game.getSecondPlayer().getTeam().get(i).getName().equals(c))
					b23.setBackground(new Color(0x8B0000));
		}
		
		else if(x == 2 && y == 4)
		{
			champimage(c, b24);
			for(int i = 0; i<game.getFirstPlayer().getTeam().size() ;i++)
				if(game.getFirstPlayer().getTeam().get(i).getName().equals(c))
					b24.setBackground(new Color(0x335988));
			for(int i = 0; i<game.getSecondPlayer().getTeam().size() ;i++)
				if(game.getSecondPlayer().getTeam().get(i).getName().equals(c))
					b24.setBackground(new Color(0x8B0000));
		}
		
		else if(x == 3 && y == 0)
		{
			champimage(c, b30);
			for(int i = 0; i<game.getFirstPlayer().getTeam().size() ;i++)
				if(game.getFirstPlayer().getTeam().get(i).getName().equals(c))
					b30.setBackground(new Color(0x335988));
			for(int i = 0; i<game.getSecondPlayer().getTeam().size() ;i++)
				if(game.getSecondPlayer().getTeam().get(i).getName().equals(c))
					b30.setBackground(new Color(0x8B0000));
		}
		
		else if(x == 3 && y == 1)
		{
			champimage(c, b31);
			for(int i = 0; i<game.getFirstPlayer().getTeam().size() ;i++)
				if(game.getFirstPlayer().getTeam().get(i).getName().equals(c))
					b31.setBackground(new Color(0x335988));
			for(int i = 0; i<game.getSecondPlayer().getTeam().size() ;i++)
				if(game.getSecondPlayer().getTeam().get(i).getName().equals(c))
					b31.setBackground(new Color(0x8B0000));
		}
		
		else if(x == 3 && y == 2)
		{
			champimage(c, b32);
			for(int i = 0; i<game.getFirstPlayer().getTeam().size() ;i++)
				if(game.getFirstPlayer().getTeam().get(i).getName().equals(c))
					b32.setBackground(new Color(0x335988));
			for(int i = 0; i<game.getSecondPlayer().getTeam().size() ;i++)
				if(game.getSecondPlayer().getTeam().get(i).getName().equals(c))
					b32.setBackground(new Color(0x8B0000));
		}
		
		else if(x == 3 && y == 3)
		{
			champimage(c, b33);
			for(int i = 0; i<game.getFirstPlayer().getTeam().size() ;i++)
				if(game.getFirstPlayer().getTeam().get(i).getName().equals(c))
					b33.setBackground(new Color(0x335988));
			for(int i = 0; i<game.getSecondPlayer().getTeam().size() ;i++)
				if(game.getSecondPlayer().getTeam().get(i).getName().equals(c))
					b33.setBackground(new Color(0x8B0000));
		}
		
		else if(x == 3 && y == 4)
		{
			champimage(c, b34);
			for(int i = 0; i<game.getFirstPlayer().getTeam().size() ;i++)
				if(game.getFirstPlayer().getTeam().get(i).getName().equals(c))
					b34.setBackground(new Color(0x335988));
			for(int i = 0; i<game.getSecondPlayer().getTeam().size() ;i++)
				if(game.getSecondPlayer().getTeam().get(i).getName().equals(c))
					b34.setBackground(new Color(0x8B0000));
		}
		
		else if(x == 4 && y == 0)
		{
			champimage(c, b40);
			for(int i = 0; i<game.getFirstPlayer().getTeam().size() ;i++)
				if(game.getFirstPlayer().getTeam().get(i).getName().equals(c))
					b40.setBackground(new Color(0x335988));
			for(int i = 0; i<game.getSecondPlayer().getTeam().size() ;i++)
				if(game.getSecondPlayer().getTeam().get(i).getName().equals(c))
					b40.setBackground(new Color(0x8B0000));
		}
		
		else if(x == 4 && y == 1)
		{
			champimage(c, b41);
			for(int i = 0; i<game.getFirstPlayer().getTeam().size() ;i++)
				if(game.getFirstPlayer().getTeam().get(i).getName().equals(c))
					b41.setBackground(new Color(0x335988));
			for(int i = 0; i<game.getSecondPlayer().getTeam().size() ;i++)
				if(game.getSecondPlayer().getTeam().get(i).getName().equals(c))
					b41.setBackground(new Color(0x8B0000));
		}
		
		else if(x == 4 && y == 2)
		{
			champimage(c, b42);
			for(int i = 0; i<game.getFirstPlayer().getTeam().size() ;i++)
				if(game.getFirstPlayer().getTeam().get(i).getName().equals(c))
					b42.setBackground(new Color(0x335988));
			for(int i = 0; i<game.getSecondPlayer().getTeam().size() ;i++)
				if(game.getSecondPlayer().getTeam().get(i).getName().equals(c))
					b42.setBackground(new Color(0x8B0000));
		}
		
		else if(x == 4 && y == 3)
		{
			champimage(c, b43);
			for(int i = 0; i<game.getFirstPlayer().getTeam().size() ;i++)
				if(game.getFirstPlayer().getTeam().get(i).getName().equals(c))
					b43.setBackground(new Color(0x335988));
			for(int i = 0; i<game.getSecondPlayer().getTeam().size() ;i++)
				if(game.getSecondPlayer().getTeam().get(i).getName().equals(c))
					b43.setBackground(new Color(0x8B0000));
		}
		
		else if(x == 4 && y == 4)
		{
			champimage(c, b44);
			for(int i = 0; i<game.getFirstPlayer().getTeam().size() ;i++)
				if(game.getFirstPlayer().getTeam().get(i).getName().equals(c))
					b44.setBackground(new Color(0x335988));
			for(int i = 0; i<game.getSecondPlayer().getTeam().size() ;i++)
				if(game.getSecondPlayer().getTeam().get(i).getName().equals(c))
					b44.setBackground(new Color(0x8B0000));
		}
	}
	
	
	public void champimage(String c, JButton b)
	{
		if(c.equals("Captain America"))
			b.setIcon(Cap);
		
		else if(c.equals("Thor"))
			b.setIcon(Thor);
		
		else if(c.equals("Loki"))
			b.setIcon(Loki);
		
		else if(c.equals("Hela"))
			b.setIcon(Hela);
		
		else if(c.equals("Hulk"))
			b.setIcon(Hulk);
		
		else if(c.equals("Ironman"))
			b.setIcon(Ironman);
		
		else if(c.equals("Yellow Jacket"))
			b.setIcon(Yellow);
		
		else if(c.equals("Spiderman"))
			b.setIcon(Spiderman);
		
		else if(c.equals("Venom"))
			b.setIcon(Venom);
		
		else if(c.equals("Quicksilver"))
			b.setIcon(Quicksilver);
		
		else if(c.equals("Ghost Rider"))
			b.setIcon(Ghost);
		
		else if(c.equals("Iceman"))
			b.setIcon(Iceman);
		
		else if(c.equals("Deadpool"))
			b.setIcon(Deadpool);
		
		else if(c.equals("Dr Strange"))
			b.setIcon(Strange);
		
		else if(c.equals("Electro"))
			b.setIcon(Electro);
	}
	
	
	
	
	@Override
	public void mouseClicked(MouseEvent e) {
		
	}
	
	
	@Override
	public void mousePressed(MouseEvent e) {
		
	}
	
	
	@Override
	public void mouseReleased(MouseEvent e) {
		
	}
	
	
	@Override
	public void mouseEntered(MouseEvent e) {
		if(e.getSource() == c1)
			viewdetails(Game.getAvailableChampions().get(0));
		
		else if(e.getSource() == c2)
			viewdetails(Game.getAvailableChampions().get(1));
		
		else if(e.getSource() == c3)
			viewdetails(Game.getAvailableChampions().get(2));
		
		else if(e.getSource() == c4)
			viewdetails(Game.getAvailableChampions().get(3));
		
		else if(e.getSource() == c5)
			viewdetails(Game.getAvailableChampions().get(4));
		
		else if(e.getSource() == c6)
			viewdetails(Game.getAvailableChampions().get(5));
		
		else if(e.getSource() == c7)
			viewdetails(Game.getAvailableChampions().get(6));
		
		else if(e.getSource() == c8)
			viewdetails(Game.getAvailableChampions().get(7));
		
		else if(e.getSource() == c9)
			viewdetails(Game.getAvailableChampions().get(8));
		
		else if(e.getSource() == c10)
			viewdetails(Game.getAvailableChampions().get(9));
		
		else if(e.getSource() == c11)
			viewdetails(Game.getAvailableChampions().get(10));
		
		else if(e.getSource() == c12)
			viewdetails(Game.getAvailableChampions().get(11));
		
		else if(e.getSource() == c13)
			viewdetails(Game.getAvailableChampions().get(12));
		
		else if(e.getSource() == c14)
			viewdetails(Game.getAvailableChampions().get(13));
		
		else if(e.getSource() == c15)
			viewdetails(Game.getAvailableChampions().get(14));
	}
	
	
	@Override
	public void mouseExited(MouseEvent e) {
		
	}
	
	
	
	
	@Override
	public void keyTyped(KeyEvent e) {
		
	}

	
	@Override
	public void keyPressed(KeyEvent e) {
		if(e.getKeyCode() == 38)
		{
			if(keys.size() == 0)
			{
				try {
					game.move(Direction.UP);
				} catch (NotEnoughResourcesException e1) {
					JOptionPane.showMessageDialog(null, "You need at least one action point to move", null, JOptionPane.WARNING_MESSAGE);
				} catch (UnallowedMovementException e1) {
					JOptionPane.showMessageDialog(null, "You can't move to this cell.", null, JOptionPane.WARNING_MESSAGE);
				}
	
				showCurrentChamp();
				viewPQ();
				updateboard();
			}
			else
			{
				keys.add(38);
				multikeys(keys);
			}
		}
		else if(e.getKeyCode() == 40)
		{
			if(keys.size() == 0)
			{
				try {
					game.move(Direction.DOWN);
				} catch (NotEnoughResourcesException e1) {
					JOptionPane.showMessageDialog(null, "You need at least one action point to move", null, JOptionPane.WARNING_MESSAGE);
				} catch (UnallowedMovementException e1) {
					JOptionPane.showMessageDialog(null, "You can't move to this cell.", null, JOptionPane.WARNING_MESSAGE);
				}
	
				showCurrentChamp();
				viewPQ();
				updateboard();
			}
			else
			{
				keys.add(40);
				multikeys(keys);
			}
		}
		else if(e.getKeyCode() == 39)
		{
			if(keys.size() == 0)
			{
				try {
					game.move(Direction.RIGHT);
				} catch (NotEnoughResourcesException e1) {
					JOptionPane.showMessageDialog(null, "You need at least one action point to move", null, JOptionPane.WARNING_MESSAGE);
				} catch (UnallowedMovementException e1) {
					JOptionPane.showMessageDialog(null, "You can't move to this cell.", null, JOptionPane.WARNING_MESSAGE);
				}
	
				showCurrentChamp();
				viewPQ();
				updateboard();
			}
			else
			{
				keys.add(39);
				multikeys(keys);
			}
		}
		else if(e.getKeyCode() == 37)
		{
			if(keys.size() == 0)
			{
				try {
					game.move(Direction.LEFT);
				} catch (NotEnoughResourcesException e1) {
					JOptionPane.showMessageDialog(null, "You need at least one action point to move", null, JOptionPane.WARNING_MESSAGE);
				} catch (UnallowedMovementException e1) {
					JOptionPane.showMessageDialog(null, "You can't move to this cell.", null, JOptionPane.WARNING_MESSAGE);
				}
	
				showCurrentChamp();
				viewPQ();
				updateboard();
			}
			else
			{
				keys.add(37);
				multikeys(keys);
			}
		}
		
		else if(e.getKeyCode() == 69) //endturn
		{
			game.endTurn();
			showCurrentChamp();
			viewPQ();
			printChamps(game.getFirstPlayer(), panel1);
			printChamps(game.getSecondPlayer(), panel2);
			updateboard();
		}
		
		else if(e.getKeyCode() == 76) //useleaderability
		{
			try {
				game.useLeaderAbility();
			} catch (LeaderNotCurrentException e1) {
				JOptionPane.showMessageDialog(null, "The current champion is not a leader", null, JOptionPane.WARNING_MESSAGE);
			} catch (LeaderAbilityAlreadyUsedException e1) {
				JOptionPane.showMessageDialog(null, "This leader already used his ability", null, JOptionPane.WARNING_MESSAGE);
			}
			
			printChamps(game.getFirstPlayer(), panel1);
			printChamps(game.getSecondPlayer(), panel2);
			showCurrentChamp();
			updateboard();
			viewPQ();
			checkgameover();
		}
		
		else if(e.getKeyCode() == 65) //attack
			keys.add(65);
		

		else if(e.getKeyCode() == 67) //castability
		{
			boolean disarmed = false;
			for(int i = 0; i<game.getCurrentChampion().getAppliedEffects().size() ;i++)
				if(game.getCurrentChampion().getAppliedEffects().get(i) instanceof Disarm)
					disarmed = true;
			if(!disarmed)
			{
				String[] number = {game.getCurrentChampion().getAbilities().get(0).getName(), game.getCurrentChampion().getAbilities().get(1).getName(), game.getCurrentChampion().getAbilities().get(2).getName()};
				ability = JOptionPane.showOptionDialog(null, "Choose an ability.", "Directional ability", JOptionPane.DEFAULT_OPTION, 0, Ability, number, null);
				
				cast(ability);
			}
			else
			{
				String[] number = {game.getCurrentChampion().getAbilities().get(0).getName(), game.getCurrentChampion().getAbilities().get(1).getName(), game.getCurrentChampion().getAbilities().get(2).getName(), game.getCurrentChampion().getAbilities().get(3).getName()};
				ability = JOptionPane.showOptionDialog(null, "Choose an ability.", "Directional ability", JOptionPane.DEFAULT_OPTION, 0, Ability, number, null);
				
				cast(ability);
			}
			
			printChamps(game.getFirstPlayer(), panel1);
			printChamps(game.getSecondPlayer(), panel2);
			showCurrentChamp();
			updateboard();
			viewPQ();
			checkgameover();
		}
	}
		
	
	@Override
	public void keyReleased(KeyEvent e) {
		
	}
	
	
	public void multikeys(ArrayList<Integer> keys) {
		if(keys.get(keys.size() - 2) == 65)
		{
			if(keys.get(keys.size() - 1) == 38)
			{
				try {
					game.attack(Direction.UP);
				} catch (NotEnoughResourcesException e) {
					JOptionPane.showMessageDialog(null, "You need at least two action point to perform a normal attack.", null, JOptionPane.WARNING_MESSAGE);
				} catch (ChampionDisarmedException e) {
					JOptionPane.showMessageDialog(null, "Can not attack while being disarmed.", null, JOptionPane.WARNING_MESSAGE);
				} catch (InvalidTargetException e) {
					JOptionPane.showMessageDialog(null, "Invalid target.", null, JOptionPane.WARNING_MESSAGE);
				}
			}
		
			else if(keys.get(keys.size() - 1) == 40)
			{
				try {
					game.attack(Direction.DOWN);
				} catch (NotEnoughResourcesException e) {
					JOptionPane.showMessageDialog(null, "You need at least two action point to perform a normal attack.", null, JOptionPane.WARNING_MESSAGE);
				} catch (ChampionDisarmedException e) {
					JOptionPane.showMessageDialog(null, "Can not attack while being disarmed.", null, JOptionPane.WARNING_MESSAGE);
				} catch (InvalidTargetException e) {
					JOptionPane.showMessageDialog(null, "Invalid target.", null, JOptionPane.WARNING_MESSAGE);
				}
			}
			
			else if(keys.get(keys.size() - 1) == 39)
			{
				try {
					game.attack(Direction.RIGHT);
				} catch (NotEnoughResourcesException e) {
					JOptionPane.showMessageDialog(null, "You need at least two action point to perform a normal attack.", null, JOptionPane.WARNING_MESSAGE);
				} catch (ChampionDisarmedException e) {
					JOptionPane.showMessageDialog(null, "Can not attack while being disarmed.", null, JOptionPane.WARNING_MESSAGE);
				} catch (InvalidTargetException e) {
					JOptionPane.showMessageDialog(null, "Invalid target.", null, JOptionPane.WARNING_MESSAGE);
				}
			}
		
			else if(keys.get(keys.size() - 1) == 37)
			{
				try {
					game.attack(Direction.LEFT);
				} catch (NotEnoughResourcesException e) {
					JOptionPane.showMessageDialog(null, "You need at least two action point to perform a normal attack.", null, JOptionPane.WARNING_MESSAGE);
				} catch (ChampionDisarmedException e) {
					JOptionPane.showMessageDialog(null, "Can not attack while being disarmed.", null, JOptionPane.WARNING_MESSAGE);
				} catch (InvalidTargetException e) {
					JOptionPane.showMessageDialog(null, "Invalid target.", null, JOptionPane.WARNING_MESSAGE);
				}
			}
			
			printChamps(game.getFirstPlayer(), panel1);
			printChamps(game.getSecondPlayer(), panel2);
			showCurrentChamp();
			updateboard();
			viewPQ();
			checkgameover();
			keys.removeAll(keys);
		}
	}

	
	public void cast(int ability) {
		if(game.getCurrentChampion().getAbilities().get(ability).getCastArea() == AreaOfEffect.DIRECTIONAL)
		{
			String[] directions = {"UP", "DOWN", "LEFT", "RIGHT"};
			int out = JOptionPane.showOptionDialog(null, "Choose a direction.", "Cast ability", JOptionPane.DEFAULT_OPTION, 0, Directions, directions, null);
			
			if(out == 0)
			{
				try {
					game.castAbility(game.getCurrentChampion().getAbilities().get(ability), Direction.UP);
				} catch (NotEnoughResourcesException e1) {
					JOptionPane.showMessageDialog(null, "You don't have enough resources.", null, JOptionPane.WARNING_MESSAGE);
				} catch (AbilityUseException e1) {
					JOptionPane.showMessageDialog(null, "Cannot use ability.", null, JOptionPane.WARNING_MESSAGE);
				} catch (CloneNotSupportedException e1) {
					e1.printStackTrace();
				}
			}
			else if(out == 1)
			{
				try {
					game.castAbility(game.getCurrentChampion().getAbilities().get(ability), Direction.DOWN);
				} catch (NotEnoughResourcesException e1) {
					JOptionPane.showMessageDialog(null, "You don't have enough resources.", null, JOptionPane.WARNING_MESSAGE);
				} catch (AbilityUseException e1) {
					JOptionPane.showMessageDialog(null, "Cannot use ability.", null, JOptionPane.WARNING_MESSAGE);
				} catch (CloneNotSupportedException e1) {
					e1.printStackTrace();
				}						
			}
			else if(out == 2)
			{
				try {
					game.castAbility(game.getCurrentChampion().getAbilities().get(ability), Direction.LEFT);
				} catch (NotEnoughResourcesException e1) {
					JOptionPane.showMessageDialog(null, "You don't have enough resources.", null, JOptionPane.WARNING_MESSAGE);
				} catch (AbilityUseException e1) {
					JOptionPane.showMessageDialog(null, "Cannot use ability.", null, JOptionPane.WARNING_MESSAGE);
				} catch (CloneNotSupportedException e1) {
					e1.printStackTrace();
				}
			}
			else if(out == 3)
			{
				try {
					game.castAbility(game.getCurrentChampion().getAbilities().get(ability), Direction.RIGHT);
				} catch (NotEnoughResourcesException e1) {
					JOptionPane.showMessageDialog(null, "You don't have enough resources.", null, JOptionPane.WARNING_MESSAGE);
				} catch (AbilityUseException e1) {
					JOptionPane.showMessageDialog(null, "Cannot use ability.", null, JOptionPane.WARNING_MESSAGE);
				} catch (CloneNotSupportedException e1) {
					e1.printStackTrace();
				}
			}
		}
		
		else if(game.getCurrentChampion().getAbilities().get(ability).getCastArea() == AreaOfEffect.SINGLETARGET)
			singletarget();
		
		else
		{
			try {
				game.castAbility(game.getCurrentChampion().getAbilities().get(ability));
			} catch (NotEnoughResourcesException e1) {
				JOptionPane.showMessageDialog(null, "You don't have enough resources.", null, JOptionPane.WARNING_MESSAGE);
			} catch (AbilityUseException e1) {
				JOptionPane.showMessageDialog(null, "Cannot use ability.", null, JOptionPane.WARNING_MESSAGE);
			} catch (CloneNotSupportedException e1) {
				e1.printStackTrace();
			}	
		}
	}

	
	public void checkgameover() {
		if(game.checkGameOver() == null)
			return;
		else
		{
			ImageIcon end = new ImageIcon("end.png");
			Player p = game.checkGameOver();
			JOptionPane.showMessageDialog(null, null, p.getName() + " wins.", JOptionPane.INFORMATION_MESSAGE, end);
			frame.dispose();
			clip.close();
		}
	}
	
	
	
	
	public static void main(String[]args) throws UnsupportedAudioFileException, IOException, LineUnavailableException{
		new Main();
	}


	
	
	

}
