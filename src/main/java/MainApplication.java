//6313213 Chokchai Bisgood
//6313128 Natthawut Saexu
//6313136 Phuwadol Khamdad
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import javax.sound.sampled.*;
import java.util.*;
public class MainApplication extends JFrame{
    private MainApplication     Main;
    private Menu        MenuPanel;
    private StartOption StartOption;
    private Option      OptionPanel;
    private Tutorial    TutorialPanel;
    private JPanel      contentpane;
    private int         frameWidth = 1366, frameHeight = 768,x,y,Volume=-17;
    private String      Player_Name;
    private Dimension   dimension;  
    private SoundEffect BTSound,Theme1,type;
    private ArrayList<SoundEffect> AllSound = new ArrayList<SoundEffect>();
public MainApplication(){       
        Main = this;
        Main.setTitle("ifyoutrustit_Game");
        Main.setSize(frameWidth,frameHeight);
        Main.setFrameAlign();  // set this frame to align at the middle of user's monitor
        Main.AddSoundEffect(); // call upon method to add sound effect to an arraylist
        Main.setResizable(false);
	Main.setDefaultCloseOperation( WindowConstants.EXIT_ON_CLOSE );
        MenuPanel   = new Menu(frameWidth,frameHeight);
        Main.setMenuButton();  //set up button in menupanel e.g. start,option,quit
        OptionPanel = new Option(frameWidth,frameHeight);
        TutorialPanel = new Tutorial(frameWidth,frameHeight);
        Main.setTutorialButton(); //set up button in menupanel ? to display a tutorial panel
        Main.setOptionButton();   // set up jslider and back button in option panel
        StartOption = new StartOption(frameWidth,frameHeight);
        Main.setStartOption();   // set up start button and naming character when pressed start
        contentpane = (JPanel)Main.getContentPane();
        contentpane.setLayout(null);
        contentpane.add(TutorialPanel);
        contentpane.add(MenuPanel);
        contentpane.add(OptionPanel);
        contentpane.add(StartOption);
        Main.setVisible(true);
        Theme1.playLoop();
        Main.validate();
}
public void setStartOption() // this method  add actionlistener to Back button in Start Panel 
                             //and focus listener to JTextpane Nameselect in StartOption panel that extends JPanel
{
      StartOption.BackBT.addActionListener( new ActionListener(){
            @Override
            public void actionPerformed( ActionEvent e ){
                BTSound.playOnce();
                StartOption.setVisible(false);
                OptionPanel.setVisible(false);
                MenuPanel.setVisible(true);
            }
	});
      StartOption.NameSelect.addFocusListener(new FocusListener() 
        {
            public void focusGained(FocusEvent e) 
            {
                  if(StartOption.NameSelect.getText().trim().equals("Enter Your Name"))
                  {
                  StartOption.NameSelect.setText("");
                  }
             
            }
            public void focusLost(FocusEvent e) 
            {
                if(StartOption.NameSelect.getText().trim().equals(""))
                {
                    StartOption.NameSelect.setText("Enter Your Name");
                }
          
            }
        });
        StartOption.NameSelect.addCaretListener( new CaretListener() 
        {
            public void caretUpdate( CaretEvent e )
            {
		Player_Name = StartOption.NameSelect.getText();
                type.playOnce();
            }
	});
        StartOption.StartBT.addActionListener(new ActionListener(){
        @Override
        public void actionPerformed(ActionEvent e){
        BTSound.playOnce();
         if(Player_Name==null||Player_Name.trim().equals("Enter Your Name")){
                    UIManager.put("OptionPane.messageFont", new Font("SanSerif", Font.BOLD | Font.ITALIC, 20));
                    JOptionPane.showMessageDialog(new JFrame(), "Please enter your name before start the game", "Name Please",
                    JOptionPane.INFORMATION_MESSAGE );          
                }
        else{
        Theme1.stop();
        new Game(frameWidth,frameHeight,Volume,Player_Name);
        dispose();
        }
        }
        });
}
public void setMenuButton()//this method add listener to start,option,quit button in MenuPanel
{
        MenuPanel.StartBT.addActionListener(new ActionListener(){
        @Override    
        public void actionPerformed(ActionEvent e){
             BTSound.playOnce();
             MenuPanel.setVisible(false);
             StartOption.setVisible(true);
             OptionPanel.setVisible(false); 
        }      
        });
        MenuPanel.OptionBT.addActionListener(new ActionListener(){
        @Override
        public void actionPerformed(ActionEvent e){
           BTSound.playOnce();
           MenuPanel.setVisible(false);
           StartOption.setVisible(false);
           OptionPanel.setVisible(true);
        }
        });
        MenuPanel.QuitBT.addActionListener(new ActionListener(){
        @Override
        public void actionPerformed(ActionEvent e){
                BTSound.playOnce();
                Theme1.stop();
                System.exit(0);
        }
        });
        MenuPanel.TutorialBT.addActionListener(new ActionListener(){
        @Override
        public void actionPerformed(ActionEvent e){
                BTSound.playOnce();
                MenuPanel.setVisible(false);
                StartOption.setVisible(false);
                TutorialPanel.setVisible(true);
        }
        });
}
public void setOptionButton()//this method add listener to JSlider VolumeSlide in OptionPanel
                             //and Back button listener
{
      OptionPanel.VolumeSlide.addChangeListener(new ChangeListener(){
            @Override
            public void stateChanged(ChangeEvent event) 
            {
                Volume = OptionPanel.VolumeSlide.getValue();
                for(SoundEffect a : AllSound)
                {
                    if(Volume==-40)
                    {
                        Volume = -80;
                    }
                    a.fc.setValue(Volume);
                }
            }
        });
      OptionPanel.BackBT.addActionListener( new ActionListener(){
            @Override
            public void actionPerformed( ActionEvent e )
            {
                BTSound.playOnce();
                OptionPanel.setVisible(false);
                MenuPanel.setVisible(true);
            }
	});
}
public void setTutorialButton() //this method add listener for Back button in Tutorial Panel
{
            TutorialPanel.BackBT.addActionListener( new ActionListener(){
            @Override
            public void actionPerformed( ActionEvent e )
            {
                BTSound.playOnce();
                TutorialPanel.setVisible(false);
                MenuPanel.setVisible(true);
            }
	});
}
public void setFrameAlign() // this method set window when open to align in the middle of user's monitor
{
        Main.dimension = Toolkit.getDefaultToolkit().getScreenSize();
        Main.x = (int) ((dimension.getWidth() - this.getWidth()) / 2);
        Main.y = (int) ((dimension.getHeight() - this.getHeight()) / 2);
        Main.setLocation(x,y);
}
 public void AddSoundEffect()// this method add all sound used in this menu to an arraylist
 {
     BTSound    =  new SoundEffect("sound/BTclick.wav");
     Theme1     =  new SoundEffect("sound/Themesong1.wav");
     type  =  new SoundEffect("sound/Keytypesound.wav");  
     AllSound.add(BTSound);
     AllSound.add(Theme1);
     AllSound.add(type);
    }
class Menu extends JPanel
{
    int frameWidth,frameHeight;
    private JLabel drawpane,Logo;
    private JButton StartBT,QuitBT,OptionBT,TutorialBT;
    private MyImageIcon mainBG,startBTI,quitBTI,optionBTI,LogoBTI,tutorial; 
    public Menu(int x,int y){     
    frameWidth = x;frameHeight = y;
    setBounds(0,-10,frameWidth,frameHeight);
    AddImages();
    drawpane = new JLabel();
    drawpane.setIcon(mainBG);
    drawpane.setBounds(0,0,frameWidth,frameHeight);
    drawpane.setLayout(null);
    //==========================
    Logo = new JLabel();
    Logo.setIcon(LogoBTI);
    Logo.setBounds(frameWidth/2-350,0,700,350);
    //======================
    StartBT = new JButton();
    StartBT.setIcon(startBTI);
    StartBT.setBounds((int)(frameWidth/2)-88,300,175,75);
    //======================
    OptionBT = new JButton();
    OptionBT.setIcon(optionBTI);
    OptionBT.setBounds((int)(frameWidth/2)-88,450,175,75);
    //======================
    QuitBT = new JButton();
    QuitBT.setIcon(quitBTI);
    QuitBT.setBounds((int)(frameWidth/2)-88,600,175,75);
    //================================
    TutorialBT = new JButton(tutorial);
    TutorialBT.setBounds(1300,0,50,50);
    //================================
    drawpane.add(Logo);
    drawpane.add(TutorialBT);
    drawpane.add(StartBT);
    drawpane.add(OptionBT);
    drawpane.add(QuitBT);
    add(drawpane);
    }
    public void AddImages()// this method add all imageicon that is used in this class
    {
      mainBG = new MyImageIcon("img/BG/mainmenuBG.jpg").resize(frameWidth,frameHeight);
      startBTI = new MyImageIcon("img/BT/start_button.png").resize(175,75);
      quitBTI = new MyImageIcon("img/BT/quit_button.png").resize(175,75);
      optionBTI = new MyImageIcon("img/BT/setting_button.png").resize(175,75);
      LogoBTI = new MyImageIcon("img/Logo.png").resize(700,350);
      tutorial = new MyImageIcon("img/BT/tutorial.png").resize(50,50);
    }
}
class Option extends JPanel{
    int frameWidth,frameHeight;
    private JLabel drawpane;
    private JButton BackBT;
    private JSlider VolumeSlide;
    private MyImageIcon X,BackBTI;
    public Option(int x,int y){
    frameWidth = x;frameHeight = y;
    setBounds(0,-10,frameWidth,frameHeight);
    setBackground(Color.blue);
    AddImages();
    drawpane = new JLabel();
    drawpane.setBounds(0,0,frameWidth,frameHeight);
    drawpane.setIcon(X);
    drawpane.setLayout(null);
    //=====================
    VolumeSlide = new JSlider(-40,6);
    VolumeSlide.setFont( new Font("SanSerif", Font.BOLD | Font.ITALIC, 20) );
    VolumeSlide.setBounds(283,350,800,100);
    VolumeSlide.setMinorTickSpacing(1);
    VolumeSlide.setPaintTicks(true);
    VolumeSlide.setPaintLabels(true);
    //======================
    BackBT = new JButton();
    BackBT.setIcon(BackBTI);
    BackBT.setFont( new Font("SanSerif", Font.BOLD | Font.ITALIC, 40) );
    BackBT.setBounds(50,600,250,100);
    //======================
    drawpane.add(VolumeSlide);
    drawpane.add(BackBT);
    setVisible(false);
    add(drawpane);
}
    public void AddImages()// this method add all imageicon that is used in this class
    {
       X = new MyImageIcon("img/BG/mainmenuBG.jpg").resize(frameWidth,frameHeight);
       BackBTI = new MyImageIcon("img/BT/back_button.png").resize(250,100);
    }
}
class StartOption extends JPanel{
    int frameWidth,frameHeight;
    private JLabel drawpane;
    private JButton BackBT,StartBT;
    private JTextField NameSelect;
    private MyImageIcon X,Y,StartBTI,BackBTI;
    public StartOption(int x,int y){   
    frameWidth = x;frameHeight = y;
    setBounds(0,-10,frameWidth,frameHeight);
    setBackground(Color.blue);
    AddImages();
    drawpane = new JLabel();
    drawpane.setBounds(0,0,frameWidth,frameHeight);
    drawpane.setIcon(X);
    drawpane.setLayout(null);
    //=====================
    BackBT = new JButton();
    BackBT.setIcon(BackBTI);
    BackBT.setFont( new Font("SanSerif", Font.BOLD | Font.ITALIC, 40) );
    BackBT.setBounds(50,600,250,100);
    //======================
    NameSelect = new JTextField("Enter Your Name");
    NameSelect.setFont( new Font("SanSerif", Font.BOLD | Font.ITALIC, 40) );
    NameSelect.setHorizontalAlignment(JTextField.CENTER);
    NameSelect.setBounds(483,640,400,80);
    //======================
    StartBT = new JButton();
    StartBT.setIcon(StartBTI);
    StartBT.setBounds(1066,600,250,100);
    StartBT.setFont( new Font("SanSerif", Font.BOLD | Font.ITALIC, 40) );
    //======================
    drawpane.add(BackBT);
    drawpane.add(NameSelect);
    drawpane.add(StartBT);
    setVisible(false);
    add(drawpane);    
    }
    public void AddImages()// this method add all imageicon that is used in this class
    {
       X = new MyImageIcon("img/BG/mainmenuBG.jpg").resize(frameWidth,frameHeight);
       BackBTI = new MyImageIcon("img/BT/back_button.png").resize(250,100);
       StartBTI = new MyImageIcon("img/BT/start_button.png").resize(250,100);
    }
}
class Tutorial extends JPanel{
    int frameWidth,frameHeight;
    private JLabel drawpane;
    private JButton BackBT;
    private JSlider VolumeSlide;
    private MyImageIcon X,BackBTI;
    public Tutorial(int x,int y){
    frameWidth = x;frameHeight = y;
    setBounds(0,-10,frameWidth,frameHeight);
    AddImages();
    drawpane = new JLabel();
    drawpane.setBounds(0,0,frameWidth,frameHeight);
    drawpane.setIcon(X);
    drawpane.setLayout(null);
    //=====================
    BackBT = new JButton();
    BackBT.setIcon(BackBTI);
    BackBT.setFont( new Font("SanSerif", Font.BOLD | Font.ITALIC, 40) );
    BackBT.setBounds(50,600,250,100);
    //======================
    drawpane.add(BackBT);
    setVisible(false);
    add(drawpane);
}
    public void AddImages()// this method add all imageicon that is used in this class
    {
       BackBTI = new MyImageIcon("img/BT/back_button.png").resize(250,100);
       X = new MyImageIcon("img/Tutorial.png");
    }
}
class SoundEffect{
        private Clip clip;
        float previousVolume = 0;
        float currentVolume = -17;
        FloatControl fc;
        public SoundEffect(String filename)
        {
            try
            {
                java.io.File file = new java.io.File(filename);
                AudioInputStream audioStream = AudioSystem.getAudioInputStream(file);
                clip = AudioSystem.getClip();
                clip.open(audioStream);
                fc = (FloatControl)clip.getControl(FloatControl.Type.MASTER_GAIN); //control sound level
                fc.setValue(currentVolume);
            }
            catch (Exception e) { e.printStackTrace(); }
        }
        public void playOnce()   { clip.setMicrosecondPosition(0); clip.start(); }
        public void playLoop()   { clip.loop(Clip.LOOP_CONTINUOUSLY); }
        public void stop()       { clip.stop(); }
    }
class MyImageIcon extends ImageIcon{
    public MyImageIcon(String fname)  { super(fname); }
    public MyImageIcon(Image image)   { super(image); }
    public MyImageIcon resize(int width, int height){
	Image oldimg = this.getImage();
	Image newimg = oldimg.getScaledInstance(width, height, java.awt.Image.SCALE_SMOOTH);
        return new MyImageIcon(newimg);
    }
    };   
    public static void main(String[] args) {
        new MainApplication();      
    }
    
}
