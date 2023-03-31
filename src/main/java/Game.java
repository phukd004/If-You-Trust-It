//6313213 Chokchai Bisgood
//6313128 Natthawut Saexu
//6313136 Phuwadol Khamdad
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import javax.sound.sampled.*; 
import java.util.*;
public class Game extends JFrame{
     private Game            Game;
     private JPanel          gamepane,STab;
     private JLabel          STabLabel;
     private JPanel          contentpane;
     private JButton         SettingBT;
     private int             frameWidth,frameHeight,Volume,x,y;
     private String          Player_Name;
     private Dimension       dimension;
     private MyImageIcon     setpane1,seticon;
     private SettingPanel    Setting;
     private MultipleDay          M;
     private boolean         OptionOpen = false;
     public Game(int W,int H,int V,String N){
         Game = this;
         Game.Player_Name = N;Game.Volume = V;Game.frameWidth = W;Game.frameHeight = H;
         AddImages();                                    // add all image that is used in this class
         Game.setSize(new Dimension(frameWidth,frameHeight));
         Game.setTitle("GAME");
         Game.setScreenAlign();                          // set this frame to align at the middle of user's monitor
         Game.setResizable(false);
         contentpane = (JPanel)Game.getContentPane();
         contentpane.setLayout(new BorderLayout());
         STab = new JPanel(new BorderLayout());
         STab.setPreferredSize(new Dimension(frameWidth,47));
         STabLabel = new JLabel(setpane1);
         SetSettingBT();                                 // set up setting button
         STabLabel.add(SettingBT);
         STab.add(STabLabel);
         Setting = new SettingPanel(frameWidth,frameHeight,Volume);
         gamepane = new JPanel(null);        
         createaddDay(frameWidth,frameHeight);           // this method create new object M(JPanel) and add to gamepane
         SetEscListener();                               // set escape button listener to be add to this JFrame
         contentpane.add(STab,BorderLayout.PAGE_START);
         contentpane.add(gamepane,BorderLayout.CENTER);
         contentpane.add(Setting,BorderLayout.LINE_END);
         Game.setVisible(true);
         setDefaultCloseOperation( WindowConstants.EXIT_ON_CLOSE );
     }
     public void AddImages() //method to add imageicon
     {
       setpane1 = new MyImageIcon("img/FRAME/setpane3.png").resize(frameWidth,47);
       seticon  = new MyImageIcon("img/BT/set_icon.png").resize(47,47);
     }
     public void createaddDay(int W,int H) // this method create new object M(JPanel) and add to gamepane
     {
         M  = new MultipleDay(W,H,Player_Name,Volume);
         gamepane.add(M.Day_1);
         gamepane.add(M.Day_2);
         gamepane.add(M.Day_3);
     }
     public void setScreenAlign() // set this frame to align at the middle of user's monitor
     {
        Game.dimension = Toolkit.getDefaultToolkit().getScreenSize();
        Game.x = (int) ((dimension.getWidth() - this.getWidth()) / 2);
        Game.y = (int) ((dimension.getHeight() - this.getHeight()) / 2);
        Game.setLocation(x,y);
     }
     public void SetEscListener() // add keylistener to this JFrame (Game) to wait for ESC key when user pressed
     {
     Game.addKeyListener(new KeyListener(){
            public void keyTyped(KeyEvent e){}
            @Override
            public void keyPressed(KeyEvent e){               
                if(OptionOpen==false){
                    if (e.getKeyCode() == KeyEvent.VK_ESCAPE ){
                        M.bts.playOnce();
                        Setting.setVisible(true);
                        gamepane.setVisible(false);
                        Game.requestFocusInWindow();
                        OptionOpen = true;
                    }
                }
                else{
                    if (e.getKeyCode() == KeyEvent.VK_ESCAPE ){
                        M.bts.playOnce();
                        Setting.setVisible(false);
                        gamepane.setVisible(true);  
                        Game.requestFocusInWindow();
                        OptionOpen = false;
                    }
                }  
            }
            public void keyReleased(KeyEvent e){}
        });
     }
     public void SetSettingBT() // add Setting button (JButton)Listener to this button
     {
            Game.SettingBT = new JButton();
            Game.SettingBT.setIcon(seticon);
            Game.SettingBT.setSize(47,47);
            Game.SettingBT.setLocation(10,0);
            Game.SettingBT.setFocusable(false);
            Game.SettingBT.addMouseListener( new MouseAdapter(){        
            public void mouseClicked( MouseEvent e ){
                if(Game.OptionOpen==false){
                M.bts.playOnce();
                gamepane.setVisible(false);
                Setting.setVisible(true);
                Game.requestFocusInWindow();
                Game.OptionOpen = true;
                }
                else{
                M.bts.playOnce();
                gamepane.setVisible(true);
                Setting.setVisible(false);
                Game.requestFocusInWindow();
                Game.OptionOpen = false;
                }
            }
	});
    }    
    class SettingPanel extends JPanel
    {
    int frameWidth,frameHeight;
    private JPanel bpane1,bpane2;
    private JLabel drawpane;
    private JButton QuitBT;
    private JSlider VolumeSlide;
    private MyImageIcon SettingBG,QuitBTI;
    public SettingPanel(int x,int y,int V)
    {
    frameWidth = x;frameHeight = y;
    setPreferredSize(new Dimension(frameWidth,frameHeight-47));
    setLayout(new BorderLayout());
    setOpaque(false);
    AddImages();
    drawpane = new JLabel(SettingBG);
    drawpane.setLayout(new BoxLayout(drawpane,BoxLayout.Y_AXIS));
    drawpane.setPreferredSize(new Dimension(frameWidth,frameHeight-47));
    VolumeSlide = new JSlider(-40,6);
    VolumeSlide.setValue(V);
    VolumeSlide.setFont( new Font("SanSerif", Font.BOLD | Font.ITALIC, 20));
    VolumeSlide.setPreferredSize(new Dimension(800,50));
    VolumeSlide.setMinorTickSpacing(1);
    VolumeSlide.setPaintTicks(true);
    VolumeSlide.setPaintLabels(true);
    VolumeSlide.addChangeListener(new ChangeListener(){ //add change listener to volumeslide to change sound according to user input
            @Override
            public void stateChanged(ChangeEvent event)
            {
                M.Volume = VolumeSlide.getValue();
                for(MultipleDay.SoundEffect a : M.AllSound)
                {   if(M.Volume==-40)
                    {
                        M.Volume = -80;
                    }
                    a.fc.setValue(M.Volume);
                }
                getTopLevelAncestor().requestFocusInWindow();
            }        
        });
    QuitBT = new JButton();
    QuitBT.setIcon(QuitBTI);
    QuitBT.setPreferredSize(new Dimension(250,100));
    QuitBT.addActionListener(new ActionListener(){
        @Override
        public void actionPerformed(ActionEvent e){
                M.bts.playOnce();              
                System.exit(0);
        }
        });
    JPanel VSpane = new JPanel(new FlowLayout(FlowLayout.CENTER));     
    VSpane.setOpaque(false);
    VSpane.add(VolumeSlide);
    JPanel Qpane = new JPanel(new FlowLayout(FlowLayout.RIGHT)); Qpane.setOpaque(false);
    Qpane.add(QuitBT);
    bpane1 = new JPanel(); bpane1.setPreferredSize(new Dimension(frameWidth,100)); bpane1.setOpaque(false);
    bpane2 = new JPanel(); bpane2.setPreferredSize(new Dimension(frameWidth,50));  bpane2.setOpaque(false);
    drawpane.add(bpane1);
    drawpane.add(VSpane);
    drawpane.add(bpane2);
    drawpane.add(Qpane);
    add(drawpane,BorderLayout.PAGE_START);
    setVisible(false);
}
     public void AddImages() // this method add all imageicon that is used in this class
     {
       SettingBG = new MyImageIcon("img/BG/optionBG.jpg").resize(frameWidth,frameHeight-47);
       QuitBTI = new MyImageIcon("img/BT/quit_button.png").resize(250,100);
     }
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
}
