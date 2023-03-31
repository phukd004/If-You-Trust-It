//6313213 Chokchai Bisgood
//6313128 Natthawut Saexu
//6313136 Phuwadol Khamdad
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import javax.swing.text.*;
import javax.sound.sampled.*; 
import java.util.*;
 
public class MultipleDay{
    public static String Player_Name;
    public static int frameWidth,frameHeight,Volume;
    public static MyImageIcon forestBG,stairBG,dialogframe,cpf,choiceframe,axolotl,bobcry;
    public static MyImageIcon lemur,slothi,dingo,kakapo,blackbear,hedgehog,wendigo,mingame2scene,space,officeBG,girl ;
    public static MyImageIcon bob,minigame1BG,hallway_horror,ghost,hallwarp,lightbuilding;
    public static MyImageIcon parkingBG,forestDay2BG,shoeBG,blood1BG,blood2BG,forestDay2_2BG,taro,building,hallway,computer,EndBG; 
    public static SoundEffect bts,theme,type,phonecall,phonehangup,footstep,kidcry,loudnoise,noise;
    public static SoundEffect monstersound,runningfootstep,coffee,weirdsound,JSsound;
    public static ArrayList<SoundEffect> AllSound;
    public static Day1 Day_1;
    public static Day2 Day_2;
    public static Day3 Day_3;
    public MultipleDay(int W,int H,String N,int V)//constructor for M in game create new Day_1 Day_2 Day_3
    {
    frameWidth = W;frameHeight = H;Player_Name = N;Volume = V;
    AddImages();   // add and resize image
    AddSoundEffect(); // add all sound effect that is used in the game
    Day_1 = new Day1();
    Day_2 = new Day2();
    Day_3 = new Day3();
    }; 
    public void AddImages()// add and resize image that is used in this class
    {
        officeBG = new MyImageIcon("img/BG/b_officeBG.png").resize(frameWidth,frameHeight-293-47);
        forestBG = new MyImageIcon("img/BG/b_forestBG.png").resize(frameWidth,frameHeight-293-47);
        stairBG = new MyImageIcon("img/BG/b_stairBG.png").resize(frameWidth,frameHeight-293-47);
        dialogframe = new MyImageIcon("img/FRAME/textbox.png").resize(frameWidth,293);
        cpf = new MyImageIcon("img/FRAME/textbox.png").resize(400,200);
        choiceframe = new MyImageIcon("img/BG/officeBG.jpg").resize(400,66);    
        axolotl = new MyImageIcon("img/MINIGAME2/axolotl.png").resize(200,200);
        lemur = new MyImageIcon("img/MINIGAME2/lemur.png").resize(200,200);
        slothi  =  new MyImageIcon("img/MINIGAME2/sloth.png").resize(200,200);
        dingo     =  new MyImageIcon("img/MINIGAME2/dingo.png").resize(200,200);
        kakapo          =  new MyImageIcon("img/MINIGAME2/kakapo.png").resize(200,200);
        blackbear   =  new MyImageIcon("img/MINIGAME2/blackbear.png").resize(200,200);
        hedgehog    =  new MyImageIcon("img/MINIGAME2/hedgehog.png").resize(200,200);
        wendigo    =  new MyImageIcon("img/MINIGAME2/wendigo.png").resize(200,200);
        mingame2scene = new MyImageIcon("img/MINIGAME2/animalLabel.jpg").resize(400,400);
        space = new MyImageIcon("img/MINIGAME2/space.png").resize(400,400);
        girl = new MyImageIcon("img/character/b_girl.png").resize(400,400);
        ghost = new MyImageIcon("img/character/b_ghost.png").resize(400,400);
        bobcry = new MyImageIcon("img/character/b_bobcry.png").resize(400,400);
        bob = new MyImageIcon("img/character/b_bob.png").resize(400,400);
        taro = new MyImageIcon("img/character/b_taro.png").resize(400,400);
        minigame1BG = new MyImageIcon("img/MINIGAME1/RadioBG.png").resize(400,200);
        ////////////////////////////////////// DAY2 BG
        parkingBG = new MyImageIcon("img/BG/Day2/b_parkingBG.png").resize(frameWidth,frameHeight-293-47);
        forestDay2BG = new MyImageIcon("img/BG/Day2/b_forestDay2BG.png").resize(frameWidth,frameHeight-293-47);
        shoeBG = new MyImageIcon("img/BG/Day2/b_shoeBG.png").resize(frameWidth,frameHeight-293-47);
        blood1BG = new MyImageIcon("img/BG/Day2/b_bloodBG.jpg").resize(frameWidth,frameHeight-293-47);
        blood2BG = new MyImageIcon("img/BG/Day2/b_blood2BG.jpg").resize(frameWidth,frameHeight-293-47);
        forestDay2_2BG = new MyImageIcon("img/BG/Day2/b_forestDay2_2BG.png").resize(frameWidth,frameHeight-293-47); 
        ////////////////////////////////////////////////// DAY 3 BG
        building = new MyImageIcon("img/BG/Day3/b_day3building.png").resize(frameWidth,frameHeight-293-47);    
        hallway = new MyImageIcon("img/BG/Day3/b_day3hallway.jpg").resize(frameWidth,frameHeight-293-47); 
        computer = new MyImageIcon("img/BG/Day3/b_day3comp.png").resize(frameWidth,frameHeight-293-47);
        hallway_horror = new MyImageIcon("img/BG/Day3/b_day3hallwayhorror.png").resize(frameWidth,frameHeight-293-47);
        hallwarp = new MyImageIcon("img/BG/Day3/b_day3hallwarp.png").resize(frameWidth,frameHeight-293-47);
        lightbuilding = new MyImageIcon("img/BG/Day3/light_day3building.jpg").resize(frameWidth,frameHeight-293-47);
        ////////////////////////////////// ENDSCENE
        EndBG = new MyImageIcon("img/BG/b_officeBG.png").resize(frameWidth,frameHeight);
        
    }
    public void AddSoundEffect(){ // add all soundeffect used in this game and add to arraylist and setvolume according to menu input
        bts   = new SoundEffect("sound/BTclick.wav");
	theme = new SoundEffect("sound/Themesong1.wav");
        type   = new SoundEffect("sound/Keytypesound.wav");
        phonecall = new SoundEffect("sound/DAY1/phonecall.wav");
        phonehangup = new SoundEffect("sound/DAY1/phonehangup.wav");
        footstep = new SoundEffect("sound/DAY1/footstep.wav");
        kidcry = new SoundEffect("sound/DAY1/kidcry.wav");
        loudnoise = new SoundEffect("sound/DAY1/loudnoise.wav");  
        monstersound = new SoundEffect("sound/Monster_sound.wav");
        runningfootstep = new SoundEffect("sound/DAY2/running_footstep.wav");
        coffee = new SoundEffect("sound/DAY3/coffee.wav");
        weirdsound = new SoundEffect("sound/DAY3/weirdsound.wav");
        JSsound = new SoundEffect("sound/DAY3/JSsound.wav");
        noise = new SoundEffect("sound/DAY3/noise.wav");
        AllSound = new ArrayList<SoundEffect>();
        AllSound.add(bts);
        AllSound.add(theme);
        AllSound.add(type);
        AllSound.add(phonecall);
        AllSound.add(phonehangup);
        AllSound.add(footstep);
        AllSound.add(kidcry);
        AllSound.add(loudnoise);
        AllSound.add(monstersound);
        AllSound.add(runningfootstep);
        AllSound.add(coffee);
        AllSound.add(weirdsound);
        AllSound.add(JSsound);
        AllSound.add(noise);
        for(MultipleDay.SoundEffect a : AllSound){
           a.fc.setValue(Volume);
        }
    }
            static class Day1 extends JPanel{ 
            public JPanel           cpane1;
            private JLabel          sloth,drawpane,dialogpane,scenepane,choicepane,choice1,choice2,choice3,checkLabel,RLabel;
            private JLabel          game2Label,character;
            public JTextPane        dialogarea;
            public JTextPane        choice1text,choice2text,choice3text;
            public int choicecount = 1,countdialog=1,selected=1;
            public int scenecount = 1;
            public boolean status_die = false,miniwin = false,select=false,minigame2select=false;
            private String      []     minigameitem = {"Iris had her hair tied","Bob wear a necklace","Bob is 11 year's old"
                                                        ,"Iris wear glasses   ","Iris wears sweater  ","Bob is chubby     "};
            private String      []     animalitem = {"Axolotl","Lemur","Dingo","Wendigo","Hedgehog","Blackbear","Kakapo","Sloth"};
            public Day1() //all 3 days are the same except minigame in Day1 contains minigame1 and Day3 minigame2
            {
            setLayout(null);
            setBounds(0,0,frameWidth,frameHeight);
            theme.playLoop();//****************
            //==============================  choice
            choicepane = new JLabel(cpf);
            choicepane.setFocusable(false);
            choicepane.setLocation(0,191);
            choicepane.setSize(400,200);
            choice1text = new JTextPane();
            choice2text = new JTextPane();
            choice3text = new JTextPane();
            choicepane.setLayout(new BoxLayout(choicepane,BoxLayout.Y_AXIS));
            //   this multiple choices is where the player interact with JLabel to answer the question
            choice1 = new JLabel(choiceframe);
            choice1.setFocusable(false);
            choice1.setSize(400,66);
            choice1text.setBounds(0,0,400,66);
            choice1text.setEditable(false);choice1text.setFocusable(false);
            choice1text.setForeground(new Color(239,178,97));choice1text.setBackground(Color.BLACK);      
            choice1text.setBorder(BorderFactory.createMatteBorder(1,1,1,1,Color.gray));
            choice1text.setFont( new Font("SanSerif", Font.BOLD | Font.ITALIC, 30) );
            choice1.add(choice1text);
            choice1text.addMouseListener( new MouseAdapter(){        
            public void mouseClicked( MouseEvent e ){
                          switch(choicecount){
                   case 1:{}break;
                   case 2:{choicepane.setVisible(false);scenecount++;choicecount++;countdialog++;dialogarea.setText("You hide and the thing that made the noise doesn't notices you");footstep.stop();}break;
                   
               }
            }
	});
            //============================== 
            choice2 = new JLabel(choiceframe);
            choice2.setFocusable(false);
            choice2.setSize(400,66);
            choice2text.setBounds(0,0,400,66);
            choice2text.setEditable(false);choice2text.setFocusable(false);
            choice2text.setFont( new Font("SanSerif", Font.BOLD | Font.ITALIC, 30) );
            choice2text.setForeground(new Color(239,178,97));choice2text.setBackground(Color.BLACK);
            choice2text.setBorder(BorderFactory.createMatteBorder(1,1,1,1,Color.gray));         
            choice2.add(choice2text);
            choice2text.addMouseListener( new MouseAdapter(){        
            public void mouseClicked( MouseEvent e ){
                   switch(choicecount){
                    case 1:{}break;
                    case 2:{dialogarea.setText("You run and suddenly the monster chase after you " + Player_Name + " The monster swipe you with it's claw. You died horribly....");youdie();}break;
                    
               }
            }
	});
            //============================== 
            choice3 = new JLabel(choiceframe);
            choice3.setFocusable(false);
            choice3.setSize(400,66);
            choice3text.setBounds(0,0,400,66);
            choice3text.setEditable(false);choice3text.setFocusable(false);
            choice3text.setFont( new Font("SanSerif", Font.BOLD | Font.ITALIC, 30) );
            choice3text.setForeground(new Color(239,178,97));choice3text.setBackground(Color.BLACK);
            choice3text.setBorder(BorderFactory.createMatteBorder(1,1,1,1,Color.gray));
            choice3.add(choice3text);
            choice3text.addMouseListener( new MouseAdapter(){        
            public void mouseClicked( MouseEvent e ){
               switch(choicecount){
                   case 1:{}break;
                   case 2:{dialogarea.setText("You choose to stay still the monster found you " + Player_Name + " The monster bite off your head. You died horribly....");youdie();}break;
               }                          
            }
	});
            //============================== end of multiple choice
            choicepane.add(choice1);
            choicepane.add(choice2);
            choicepane.add(choice3);
            //============================== 
            character = new JLabel(girl);
            character.setBounds(800,0,400,400);
            scenepane = new JLabel(officeBG);
            dialogpane = new JLabel(dialogframe);
            dialogarea = new JTextPane();
            dialogarea.setBounds(51,32,1266,228);
            dialogarea.setFocusable(false);dialogarea.setEditable(false);
            dialogarea.setFont( new Font("SanSerif", Font.BOLD | Font.ITALIC, 40) );
            dialogarea.setForeground(new Color(239,178,97));
            dialogarea.setBackground(Color.BLACK);
            dialogarea.setText("We received a report of a missing children in this area,A boy and his sister went missing while their family were hiking on the mountain,The parents called us immediately.");
            dialogarea.addMouseListener( new MouseAdapter(){        
            public void mouseClicked( MouseEvent e ) // play the scene according to case
            {
                   switch(scenecount){
                       case 1:{scene1();}break;
                       case 2:{scene2();}break;
                       case 3:{scene3();}break;
                   }
               }                          
            });
            minigame1(); // Minigame 1
            checkLabel.setVisible(false);
            scenepane.add(character);
            character.setVisible(false);
            scenepane.setBounds(0,0,frameWidth,400);
            dialogpane.setBounds(0,400,frameWidth,293);
            scenepane.add(choicepane);
            dialogpane.add(dialogarea);
            choicepane.setVisible(false);
            add(scenepane);
            add(dialogpane);
            validate();
            setVisible(true);
            }
            public void choicescene1()//this method set the text that is in the choice
            {
            choicepane.setVisible(true);
            choice1text.setText("Choice 1 : HIDE");
            choice2text.setText("Choice 2 : RUN");
            choice3text.setText("Choice 3 : STAY STILL");
            }
            //============================== 
             public void youdie() // this method is being called when you failed to answer the right question
            {
                UIManager.put("OptionPane.messageFont", new Font("SanSerif", Font.BOLD | Font.ITALIC, 20));
                if(choicecount==1){
                JOptionPane.showMessageDialog(new JFrame(), "Your only job was to find those children but you still failed? START OVER AGAIN", "YOU'VE FAILED",
                JOptionPane.INFORMATION_MESSAGE );
                }
                else{
                JOptionPane.showMessageDialog(new JFrame(), "You've tried your best but YOU DIE! START OVER AGAIN", "YOU DIED",
                JOptionPane.INFORMATION_MESSAGE );    
                }
                for(SoundEffect a: AllSound){
                a.stop();
                }
                  Component c = this.getTopLevelAncestor();
                if (c instanceof Window)
                {         
                    theme.stop();
                    Window w = (Window) c;
                    w.dispose();
                }
                new Game(frameWidth,frameHeight,Volume,Player_Name);                    
            }
            //============================== 
            public void scene1() // these method are method that changed texted and being called upon when user clicked the dialogarea(black area)
            {
                if(countdialog==1)
                {
                    bts.playOnce();
                    dialogarea.setText("*phone calling*");
                    phonecall.playLoop();
                }
                if(countdialog==2){
                    bts.playOnce();
                    phonecall.stop();
                    dialogarea.setText(Player_Name + " : Hello , this is search and rescue department of this national park My name is \""+ Player_Name +"\" Are there anything we can help?");
                }
                if(countdialog==3){
                    bts.playOnce();
                    dialogarea.setText("Parents : Our children went missing while they were picking berry on the track We lose sight of them about a minute and suddenly they went missing.");
                }
                if(countdialog==4){
                    bts.playOnce();
                    dialogarea.setText(Player_Name + " : Ok calm down maa'm Could you tell me what's your children looks like? ");
                }
                if(countdialog==5){
                    bts.playOnce();
                    dialogarea.setText("Parents : The boy named \"Bob\" and girl named \"Iris\". Bob is chubby boy with necklace,he will turn 11 this month and Iris wears round glasses with her hair tied");
                }
                if(countdialog==6){
                    checkLabel.setVisible(true);
                    countdialog--;
                    bts.playOnce();
                    dialogarea.setText("I've finish writing down the description of the kids maybe I got something wrong ?....(Choose wrong description of the two kids)");
                }
                if(countdialog==7){
                    bts.playOnce();
                    dialogarea.setText("Parents : Please help find our children!");
                }
                if(countdialog==8){
                    bts.playOnce();
                    dialogarea.setText(Player_Name +" : We'll do what we can sir ma'am so don't worry");
                }
                if(countdialog==9){
                    bts.playOnce();
                    dialogarea.setText("*phone hang up*");
                    phonehangup.playOnce();               
                    scenecount++;
                }
                countdialog++;
            }
            public void scene2(){
               if(countdialog==10)
                {
                    bts.playOnce();
                    scenepane.setIcon(forestBG);
                    dialogarea.setText("After that family hanged up me and other rescue officer went searching in the area that the family report their children missing after a while looking I'm really glad that we found the little sister first then I asked her what is going on.");
                    phonehangup.stop();
                }
                if(countdialog==11)
                {
                    character.setVisible(true);
                    bts.playOnce();
                    dialogarea.setText(Player_Name +" : Hello little girl are you hurt ?");
                }
                if(countdialog==12)
                {
                    bts.playOnce();
                    dialogarea.setText("Iris : only a scratch not that bad");
                }
                if(countdialog==13)
                {
                    bts.playOnce();
                    dialogarea.setText(Player_Name +" : Alright! Let me help treat your wound, So where is your brother ?");
                }
                if(countdialog==14)
                {
                    bts.playOnce();
                    dialogarea.setText("Iris : He went with \"...\"");
                }
                if(countdialog==15)
                {
                    bts.playOnce();
                    dialogarea.setText(Player_Name +" : !? \"confused\"");
                }
                if(countdialog==16)
                {
                    bts.playOnce();
                    dialogarea.setText("Iris : He gave us a berry and tell us that we stay quite he want to play with my brother for a while");
                }
                if(countdialog==17)
                {
                    bts.playOnce();
                    dialogarea.setText(Player_Name +" : And........ last time you saw that man what was he doing with your brother");
                }
                if(countdialog==18)
                {
                    bts.playOnce();
                    dialogarea.setText("Iris : My brother was riding on his neck he's very tall and his face looks weird.");
                }
                if(countdialog==19)
                {
                    bts.playOnce();
                    dialogarea.setText(Player_Name +" : Ok, You go back to your family with that officer over there he'll take you to your family at the centre.");
                }
                if(countdialog==20)
                {
                    bts.playOnce();
                    dialogarea.setText("Iris : What about my brother ?");
                }
                if(countdialog==21)
                {
                    bts.playOnce();
                    dialogarea.setText(Player_Name +" : Your brother will join you soon.");
                }
                if(countdialog==22)
                {
                    character.setVisible(false);
                    bts.playOnce();
                    dialogarea.setText("After my friend took the girl.");
                }
                if(countdialog==23)
                {
                    bts.playOnce();
                    dialogarea.setText(Player_Name +" : What was that child talking about ?\".....\" What was his intension with her brother this is getting confused, then I speak to my self I don't have much time to be concerned with this matter I should keep on finding this boy.");
                }
                if(countdialog==24)
                {
                    bts.playOnce();
                    footstep.playLoop();
                    dialogarea.setText("*foot steps!*");
                    choicescene1();
                    countdialog--;
                }
                countdialog++;
            }
            public void scene3(){
                if(countdialog==25)
                {
                    bts.playOnce();
                    footstep.stop();
                    dialogarea.setText("After considering what the girl said I think that this might a case of kidnapping and that's odd, For what I've known so far there doesn't exist any record of human inhabitance in this area ");
                    
                }
                if(countdialog==26)
                {
                    bts.playOnce();
                    scenepane.setIcon(stairBG);
                    dialogarea.setText(Player_Name +" : What on earth is this, A Stair in the middle of a goddamn forest you got to be kidding me It looks weird like someone cut it off from a home and place it here.");
                }
                if(countdialog==27)
                {
                    bts.playOnce();
                    kidcry.playLoop();
                    dialogarea.setText("While you were checking out this weird staircase, Suddenly you hear a boy crying not far away you and another rescue officer go out and search for a while and found a boy crying at the cliff not far away from there.");
                }
                if(countdialog==28)
                {
                    character.setIcon(bobcry);
                    character.setVisible(true);
                    bts.playOnce();
                    dialogarea.setText(Player_Name + " : Are you hurt?");
                }
                if(countdialog==29)
                {   
                    bts.playOnce();
                    dialogarea.setText("Bob : No Sir! *sob*");
                }
                if(countdialog==30)
                {
                    character.setIcon(bob);
                    bts.playOnce();
                    kidcry.stop();
                    dialogarea.setText(Player_Name +" : And where's the man playing with you?");
                }
                if(countdialog==31)
                {
                    bts.playOnce();
                    dialogarea.setText("Bob : He just went off, He drop me off from his shoulder and left me here.");
                }
                if(countdialog==32)
                {
                    bts.playOnce();
                    dialogarea.setText(Player_Name +" : Ok now we found everyone let's get back your family is waiting.");
                }
                if(countdialog==33)
                {
                    character.setVisible(false);
                    bts.playOnce();
                    dialogarea.setText(Player_Name +" : What is wrong with this place a monster thats seems to be friendly and it seems to know that there are humans out here and that weird staircase too after I got back to the headquarter I should find  a report about these incidents.");
                }
                if(countdialog==34)
                {
                    bts.playOnce();
                    loudnoise.playLoop();
                    dialogarea.setText("*Loud Noise* !?!");
                }
                if(countdialog==35)
                {
                    bts.playOnce();
                    loudnoise.stop();
                    dialogarea.setText("After we got the boy to his family I went to report what I encountered and search for an earlier report of SAR then I found a lot of weird cases but nothing related to what I see today.");
                }
                if(countdialog==36)
                {
                    bts.playOnce();
                    dialogarea.setText("END OF DAY 1......");
                }
                if(countdialog==37)
                {
                    setVisible(false);
                    Day_2.setVisible(true);
                }
                countdialog++;
            }
            public void scene4(){
               scenepane.setIcon(officeBG);
               dialogarea.setText("SCENE 5");
               scenecount++;
            }
            public void minigame1() // method to create minigame1
            {
                    checkLabel = new JLabel();
                    RLabel = new JLabel(minigame1BG);
                    RLabel.setLayout(new BoxLayout(RLabel,BoxLayout.Y_AXIS));
                    RLabel.setBounds(0,0,400,200);
                    ButtonGroup G1 = new ButtonGroup();
                    JRadioButton radiogame[] = new JRadioButton[8];
                    JButton Submit = new JButton("ENTER");
                    Submit.setBounds(300,250,100,50);
                    checkLabel.add(RLabel);

                    for (int i=0;i<6;i++) 
                    {
                        radiogame[i] = new JRadioButton( minigameitem[i].toString() );
                        radiogame[i].setFont( new Font("SanSerif", Font.BOLD | Font.ITALIC, 20) );
                        radiogame[i].setFocusable(false);
                        G1.add( radiogame[i] );
                        RLabel.add(radiogame[i]);
                        radiogame[i].addItemListener( new ItemListener() 
                        {
                            
                            public void itemStateChanged( ItemEvent e )
                            {
                                JRadioButton temp = (JRadioButton)e.getItem();
                                if(temp.getText().trim().equals(minigameitem[2]))
                                {
                                    miniwin = true;
                                    select = true;
                                    
                                }
                                else{                                
                                    select = true;
                                    miniwin = false;}
                            }   
                        });
                    }
                    checkLabel.add(Submit);
                    checkLabel.setBounds(500,50,400,300);
                    scenepane.add(checkLabel);
                    Submit.addActionListener(new ActionListener(){
                    @Override    
                    public void actionPerformed(ActionEvent e)
                    {
                        if(miniwin == false&&select==true){youdie();}
                        if(miniwin == true&&select==true)
                        {                        
                         bts.playOnce();
                        phonecall.stop();
                        dialogarea.setText("Ah yes he wasn't 11 he was 10 !");
                        checkLabel.setVisible(false);
                        countdialog++;
                        choicecount++;
                        }
                        getTopLevelAncestor().requestFocusInWindow();
                    }      
                    });
            }

            }
            
          static class Day2 extends JPanel
          {
            private JLabel          sloth,drawpane,dialogpane,scenepane,choicepane,choice1,choice2,choice3,checkLabel,RLabel;
            private JLabel          game2Label,character;
            public JTextPane        dialogarea;
            public JTextPane        choice1text,choice2text,choice3text;
            public int choicecount = 1,countdialog=1,selected=1;
            public int scenecount = 1;
            public boolean status_die = false,miniwin = false,select=false;
            public Day2() 
            {
            Day_2 = this;
            Day_2.setLayout(null);
            Day_2.setBounds(0,0,frameWidth,frameHeight);
            //==============================  choice
            choicepane = new JLabel(cpf);
            choicepane.setFocusable(false);
            choicepane.setLocation(0,191);
            choicepane.setSize(400,200);
            choice1text = new JTextPane();
            choice2text = new JTextPane();
            choice3text = new JTextPane();
            choicepane.setLayout(new BoxLayout(choicepane,BoxLayout.Y_AXIS));
            //============================== 
            choice1 = new JLabel(choiceframe);
            choice1.setFocusable(false);
            choice1.setSize(400,66);
            choice1text.setBounds(0,0,400,66);
            choice1text.setEditable(false);choice1text.setFocusable(false);
            choice1text.setForeground(new Color(239,178,97));choice1text.setBackground(Color.BLACK);      
            choice1text.setBorder(BorderFactory.createMatteBorder(1,1,1,1,Color.gray));
            choice1text.setFont( new Font("SanSerif", Font.BOLD | Font.ITALIC, 25) );
            choice1.add(choice1text);
            choice1text.addMouseListener( new MouseAdapter(){        
            public void mouseClicked( MouseEvent e ){
               switch(choicecount){
                   case 1:{choicepane.setVisible(false);scenecount++;choicecount++;countdialog++;dialogarea.setText("You found something!");}break;
                   case 2:{         }break;
                   case 3:{         }break;
               }
            }
            });
            //============================== 
            choice2 = new JLabel(choiceframe);
            choice2.setFocusable(false);
            choice2.setSize(400,66);
            choice2text.setBounds(0,0,400,66);
            choice2text.setEditable(false);choice2text.setFocusable(false);
            choice2text.setFont( new Font("SanSerif", Font.BOLD | Font.ITALIC, 25) );
            choice2text.setForeground(new Color(239,178,97));choice2text.setBackground(Color.BLACK);
            choice2text.setBorder(BorderFactory.createMatteBorder(1,1,1,1,Color.gray));         
            choice2.add(choice2text);
            choice2text.addMouseListener( new MouseAdapter(){        
            public void mouseClicked( MouseEvent e ){
               switch(choicecount){
                    case 1:{dialogarea.setText("AS YOU RUN THE MONSTER NOTICE YOU AND KILL YOU, YOU DIED HORRIBLY");youdie();}break;
                    case 2:{         }break;
                    case 3:{         }break;
               }
            }
            });
            //============================== 
            choice3 = new JLabel(choiceframe);
            choice3.setFocusable(false);
            choice3.setSize(400,66);
            choice3text.setBounds(0,0,400,66);
            choice3text.setEditable(false);choice3text.setFocusable(false);
            choice3text.setFont( new Font("SanSerif", Font.BOLD | Font.ITALIC, 25) );
            choice3text.setForeground(new Color(239,178,97));choice3text.setBackground(Color.BLACK);
            choice3text.setBorder(BorderFactory.createMatteBorder(1,1,1,1,Color.gray));
            choice3.add(choice3text);
            choice3text.addMouseListener( new MouseAdapter(){        
            public void mouseClicked( MouseEvent e ){
               switch(choicecount){
                   case 1:{dialogarea.setText("AS YOU RUN FASTER THAN BEFORE THE MONSTER RUN AFTER YOU AND KILL YOU, YOU DIED HORRIBLY");youdie(); }break;
                   case 2:{         }break;
                   case 3:{         }break;
               }                          
            }
	});
            //============================== 
            choicepane.add(choice1);
            choicepane.add(choice2);
            choicepane.add(choice3);
            //============================== 
            character = new JLabel(taro);
            character.setBounds(800,0,400,400);
            scenepane = new JLabel(officeBG);
            dialogpane = new JLabel(dialogframe);
            dialogarea = new JTextPane();
            dialogarea.setBounds(51,32,1266,228);
            dialogarea.setFocusable(false);dialogarea.setEditable(false);
            dialogarea.setFont( new Font("SanSerif", Font.BOLD | Font.ITALIC, 40) );
            dialogarea.setForeground(new Color(239,178,97));
            dialogarea.setBackground(Color.BLACK);
            dialogarea.setText("I got a chance to ask my fellow officer in the park about these weird incidents, But they seem like they don't want to talk about any of that thing out there might be because of our superior don't want these non sense story to spread out.");
            dialogarea.addMouseListener( new MouseAdapter(){        
            public void mouseClicked( MouseEvent e ){
                   switch(scenecount){
                       case 1:{scene1();               }break;
                       case 2:{scene2();               }break;
                       case 3:{scene3();               }break;
                       case 4:{scene4();               }break;
                       case 5:{scene5();               }break;
                       case 6:{scene6();               }break;
                       case 7:{scene7();               }break;
                   }
               }                          
            });
            //============================== 
            scenepane.add(character);
            character.setVisible(false);
            scenepane.setBounds(0,0,frameWidth,400);
            dialogpane.setBounds(0,400,frameWidth,293);
            scenepane.add(choicepane);
            dialogpane.add(dialogarea);
            choicepane.setVisible(false);
            Day_2.add(scenepane);
            Day_2.add(dialogpane);
            Day_2.setVisible(false);
            Day_2.validate();
            }
            //============================== 
            public void youdie()
            {
                UIManager.put("OptionPane.messageFont", new Font("SanSerif", Font.BOLD | Font.ITALIC, 20));
                JOptionPane.showMessageDialog(new JFrame(), "All hope are lost START OVER AGAIN !", "YOU DIED !!!!",
                JOptionPane.INFORMATION_MESSAGE );
                for(SoundEffect a: AllSound){
                a.stop();
            }
                Component c = this.getTopLevelAncestor();
                if (c instanceof Window) 
                {         
                    theme.stop();
                    Window w = (Window) c;
                    w.dispose();
                }
                new Game(frameWidth,frameHeight,Volume,Player_Name);
            }
            public void choicescene1(){
            choicepane.setVisible(true);
            choice1text.setText("Choice 1 : check what's in the bush");
            choice2text.setText("Choice 2 : RUN");
            choice3text.setText("Choice 3 : RUN FASTER THAN CHOICE 2");
            }
            public void scene1()
            {
                if(countdialog==1)
                {
                    bts.playOnce();
                    dialogarea.setText("but one of my colleague trusts me \"Taro\" he also stumbled upon these odds case too.");
                }
                if(countdialog==2)
                {
                    bts.playOnce();
                    phonecall.playLoop();
                    dialogarea.setText("*phone ringing*");
                }
                if(countdialog==3)
                {
                    bts.playOnce();
                    phonecall.stop();
                    dialogarea.setText("Child's mother : Help please ! My children went missing while I was walking with them at the lake, Suddenly there was a weird sound at my back and then my children disappeared");
                }
                if(countdialog==4)
                {
                    bts.playOnce();
                    dialogarea.setText(Player_Name + " : Ok Ma'am we'll go right there and find your children please stay calm.");
                }
                if(countdialog==5)
                {
                    bts.playOnce();
                    runningfootstep.playLoop();
                    dialogarea.setText("*running footstep*");
                    scenecount++;
                }
                countdialog++;
            }
            public void scene2()
            {
               if(countdialog==6)
                {
                    runningfootstep.stop();
                    bts.playOnce();
                    scenepane.setIcon(parkingBG);
                    dialogarea.setText("When we arrived at the scene the mother was waiting with a police officer, Me and other officer guess that the children might be around here, So we went out searching.");
                    scenecount++;
                }
               countdialog++;
            }
            public void scene3()
            {
                if(countdialog==7)
                {
                    scenepane.setIcon(forestDay2BG);
                    bts.playOnce();
                    dialogarea.setText(Player_Name + " : What are these wood hiding from us......");
                }
                if(countdialog==8)
                {
                    bts.playOnce();
                    dialogarea.setText(Player_Name + " : And the thing that abduct the child is it the same one as yesterday?");
                    scenecount++;
                }
                countdialog++;
            }
            public void scene4()
            {
                if(countdialog==9)
                {
                    bts.playOnce();
                    scenepane.setIcon(blood2BG);
                    dialogarea.setText("The search area keep expanding larger and larger and keep us further away from the main road, And we stumble upon a stain of blood.");
                }
                if(countdialog==10)
                {
                    bts.playOnce();
                    dialogarea.setText(Player_Name +" : What is this blood ????????????");
                }
                if(countdialog==11)
                {
                    bts.playOnce();
                    footstep.playLoop();
                    dialogarea.setText("*Sound of bush waving*");
                }
                if(countdialog==12)
                {
                    footstep.stop();
                    bts.playOnce();
                    dialogarea.setText(Player_Name + ": Who's there ?");
                }
                if(countdialog==13)
                {
                    choicescene1();
                    bts.playOnce();
                    dialogarea.setText("Out of curious I try  to check something that is in the bush..................................");
                    countdialog--;
                }
                countdialog++;
            }
            public void scene5()
            {
                if(countdialog==14)
                {
                    bts.playOnce();
                    scenepane.setIcon(shoeBG);
                    dialogarea.setText(Player_Name + " : A shoe ? this might belongs to the child we are finding.");
                }
                if(countdialog==15)
                {
                    bts.playOnce();
                    dialogarea.setText("Taro(radio) : "+Player_Name+" , I found something here come check it out right now!!!!");
                }
                if(countdialog==16)
                {
                    bts.playOnce();
                    dialogarea.setText(Player_Name + " : I'm on my way !");
                    scenecount++;
                }
                countdialog++;
            }
            public void scene6()
            {
                if(countdialog==17)
                {
                    bts.playOnce();
                    scenepane.setIcon(blood1BG);
                    dialogarea.setText("When I arrived I found a trail of blood, that lead to somewhere in the park.");
                }
                if(countdialog==18)
                {
                    bts.playOnce();
                    dialogarea.setText(Player_Name + " : Quickly let's follow this trail the child might still be alive.");
                }
                if(countdialog==19)
                {
                    bts.playOnce();
                    character.setVisible(true);
                    dialogarea.setText("Taro : Becareful something might be around here!!!!");
                }
                if(countdialog==20)
                {
                    bts.playOnce();
                    character.setVisible(false);
                    dialogarea.setText("After a while following the trail we found a tattered shirt, and the trail blood suddenly stop");
                }
                if(countdialog==21)
                {
                    bts.playOnce();
                    dialogarea.setText(Player_Name +" : Hmm...? This place isn't that far from the stairs");
                }
                if(countdialog==22)
                {
                    bts.playOnce();
                    monstersound.playLoop();
                    dialogarea.setText("*Weird Noise*");
                }
                if(countdialog==23)
                {
                    bts.playOnce();
                    monstersound.stop();
                    dialogarea.setText(Player_Name + " : That sound maybe it's around here.");
                    scenecount++;
                }
                countdialog++;
            }
            public void scene7()
            {
                if(countdialog==24)
                {
                    bts.playOnce();
                    scenepane.setIcon(forestDay2_2BG);
                    dialogarea.setText("After a while searching there, The rest of our corp come to our area to plan further, But now it's too dark to keep on finding so we're heading back to information center with disappointment .");
                }
                if(countdialog==25)
                {
                    bts.playOnce();
                    dialogarea.setText(Player_Name + " : This is too weird how can a child disappear without any trace like this ?");
                }
                if(countdialog==26)
                {
                    bts.playOnce();
                    character.setVisible(true);
                    dialogarea.setText("Taro : This might be another case of a missing person that will be lost forever");
                }
                if(countdialog==27)
                {
                    bts.playOnce();
                    dialogarea.setText(Player_Name + " : What..........?");
                }
                if(countdialog==28)
                {
                    bts.playOnce();
                    dialogarea.setText("Taro : In the computer at our base I've heard that there are a database of animal in this area. It might contains some information about the thing we find. ");
                }
                if(countdialog==29)
                {
                    bts.playOnce();  
                    dialogarea.setText("After some small talk with Taro, Our superior come to check out the situation and warns us that no one try to find out what that thing is...");
                }
                if(countdialog==30)
                {
                    bts.playOnce();
                    character.setVisible(false);
                    dialogarea.setText("END OF DAY 2......");
                }
                if(countdialog==31)
                {
                    setVisible(false);
                    Day_3.setVisible(true);
                }
                countdialog++;
            }
            
            
          }
           static class Day3 extends JPanel
           {
            private JLabel          sloth,drawpane,dialogpane,scenepane,choicepane,choice1,choice2,choice3,checkLabel,RLabel;
            private JLabel          game2Label,character,ghostJS,endscene;
            public JTextPane        dialogarea;
            public JTextPane        choice1text,choice2text,choice3text;
            public int choicecount = 1,countdialog=1,selected=1;
            public int scenecount = 1;
            public boolean status_die = false,miniwin = false,select=false,minigame2select=false;
            private String      []     animalitem = {"Axolotl","Lemur","Dingo","Wendigo","Hedgehog","Blackbear","Kakapo","Sloth"};
           public Day3()
            {
            Day_3 = this;
            Day_3.setLayout(null);
            Day_3.setBounds(0,0,frameWidth,frameHeight);
            //==============================  choice
            choicepane = new JLabel(cpf);
            choicepane.setFocusable(false);
            choicepane.setLocation(0,191);
            choicepane.setSize(400,200);
            choice1text = new JTextPane();
            choice2text = new JTextPane();
            choice3text = new JTextPane();
            choicepane.setLayout(new BoxLayout(choicepane,BoxLayout.Y_AXIS));
            //============================== 
            choice1 = new JLabel(choiceframe);
            choice1.setFocusable(false);
            choice1.setSize(400,66);
            choice1text.setBounds(0,0,400,66);
            choice1text.setEditable(false);choice1text.setFocusable(false);
            choice1text.setForeground(new Color(239,178,97));choice1text.setBackground(Color.BLACK);      
            choice1text.setBorder(BorderFactory.createMatteBorder(1,1,1,1,Color.gray));
            choice1text.setFont( new Font("SanSerif", Font.BOLD | Font.ITALIC, 30) );
            choice1.add(choice1text);
            choice1text.addMouseListener( new MouseAdapter(){        
            public void mouseClicked( MouseEvent e ){
               switch(choicecount){
                   case 1:{         }break;
                   case 2:{         }break;
                   case 3:{         }break;
               }
            }
            });
            //============================== 
            choice2 = new JLabel(choiceframe);
            choice2.setFocusable(false);
            choice2.setSize(400,66);
            choice2text.setBounds(0,0,400,66);
            choice2text.setEditable(false);choice2text.setFocusable(false);
            choice2text.setFont( new Font("SanSerif", Font.BOLD | Font.ITALIC, 30) );
            choice2text.setForeground(new Color(239,178,97));choice2text.setBackground(Color.BLACK);
            choice2text.setBorder(BorderFactory.createMatteBorder(1,1,1,1,Color.gray));         
            choice2.add(choice2text);
            choice2text.addMouseListener( new MouseAdapter(){        
            public void mouseClicked( MouseEvent e ){
               switch(choicecount){
                    case 1:{         }break;
                    case 2:{         }break;
                    case 3:{         }break;
               }
            }
            });
            //============================== 
            choice3 = new JLabel(choiceframe);
            choice3.setFocusable(false);
            choice3.setSize(400,66);
            choice3text.setBounds(0,0,400,66);
            choice3text.setEditable(false);choice3text.setFocusable(false);
            choice3text.setFont( new Font("SanSerif", Font.BOLD | Font.ITALIC, 30) );
            choice3text.setForeground(new Color(239,178,97));choice3text.setBackground(Color.BLACK);
            choice3text.setBorder(BorderFactory.createMatteBorder(1,1,1,1,Color.gray));
            choice3.add(choice3text);
            choice3text.addMouseListener( new MouseAdapter(){        
            public void mouseClicked( MouseEvent e ){
               switch(choicecount){
                   case 1:{         }break;
                   case 2:{         }break;
                   case 3:{         }break;
               }                          
            }
	});
            //============================== 
            choicepane.add(choice1);
            choicepane.add(choice2);
            choicepane.add(choice3);
            //============================== 
            character = new JLabel(taro);
            character.setBounds(800,0,400,400);
            ghostJS = new JLabel(ghost);
            ghostJS.setBounds(frameWidth/2,0,400,400);
            scenepane = new JLabel(building);
            scenepane.setFocusable(false);
            minigame2();
            dialogpane = new JLabel(dialogframe);
            dialogarea = new JTextPane();
            dialogarea.setBounds(51,32,1266,228);
            dialogarea.setFocusable(false);dialogarea.setEditable(false);
            dialogarea.setFont( new Font("SanSerif", Font.BOLD | Font.ITALIC, 40) );
            dialogarea.setForeground(new Color(239,178,97));
            dialogarea.setBackground(Color.BLACK);
            dialogarea.setText("This night is the first night that I work late here at the office, Usually there are about 2-3 officers work this time to standby if there are any urgent accident happens, But as I've know there aren't any happens before  ");
            dialogarea.addMouseListener( new MouseAdapter(){        
            public void mouseClicked( MouseEvent e ){
                   switch(scenecount){
                       case 1:{scene1();}break;
                       case 2:{scene2();}break;
                       case 3:{scene3();}break;
                       case 4:{scene4();}break;
                       case 5:{scene5();}break;
                       case 6:{scene6();}break;
                       case 7:{         }break;
                   }
               }                          
            });
            //============================== 
            scenepane.add(character);
            scenepane.add(ghostJS);
            ghostJS.setVisible(false);
            character.setVisible(false);
            scenepane.setBounds(0,0,frameWidth,400);
            dialogpane.setBounds(0,400,frameWidth,293);
            scenepane.add(choicepane);
            dialogpane.add(dialogarea);
            choicepane.setVisible(false);
            ENDGAME();
            Day_3.add(scenepane);
            Day_3.add(dialogpane);
            Day_3.setVisible(false);
            Day_3.validate();
            }
           //============================== 
           public void scene1(){
            if(countdialog==1){
                    bts.playOnce();
                    dialogarea.setText("But tonight I'm the only one here, Other officers aren't free today they have to attend ther own \"Business\" hey but what can I say I'm a newbie here.");
                }
                if(countdialog==2){
                    bts.playOnce();
                    dialogarea.setText(Player_Name + " : Hopes that nothing weird happens tonight ! (Mumbling) (Lift up a cup to drink)");
                    coffee.playOnce();
                }
                if(countdialog==3){
                    bts.playOnce();
                    dialogarea.setText("My Job tonight is to patrol around here and stand by if there are any call.");
                    scenecount++;
                }
                countdialog++;
           }
           public void scene2(){
           if(countdialog==4){
           bts.playOnce();
           scenepane.setIcon(hallway);
           dialogarea.setText("*While patroling in the hallway*");
           }
           if(countdialog==5){          
           bts.playOnce();
           dialogarea.setText(Player_Name +" : Hmm....? Chief room's isn't locked ?");
           }
           if(countdialog==6){
           bts.playOnce();
           dialogarea.setText(Player_Name + " : Maybe I should check out that computer that Taro told me about maybe it contains some information about the \"Thing\"  that maybe out there.");         
           scenecount++;
           }
           countdialog++;
           }
           public void scene3(){
               if(countdialog==7){
                bts.playOnce();
                scenepane.setIcon(computer);
                dialogarea.setText("After checking around for a while, I found one file in the chief's computer that magically doesn't require any password to unlock.");
               }
               if(countdialog==8){
               bts.playOnce();
               dialogarea.setText(Player_Name+" : So this file contains a list of animal that lives in this park hmmm what should I look for ? Maybe some weird animal name ?");
               game2Label.setVisible(true);
               countdialog--;
               }
               if(countdialog==9){
               bts.playOnce();
               dialogarea.setText(Player_Name+" : What the......? So staircase is where this thing comes from ?");
               }
               if(countdialog==10){
               bts.playOnce();
               dialogarea.setText("*weird noise outside of the window*");
               monstersound.playLoop();
               }
               if(countdialog==11){
               bts.playOnce();
               monstersound.stop();
               dialogarea.setText("I look at the window but couldn't find the source of that sound.");
               }
               if(countdialog==12){
               bts.playOnce();
               dialogarea.setText("*sound from hallway*");
               weirdsound.playLoop();
               scenecount++;
               }
               countdialog++;
           }
           public void scene4(){
           if(countdialog==13){
            bts.playOnce();
            weirdsound.stop();
            game2Label.setVisible(false);
            scenepane.setIcon(hallway_horror);
            dialogarea.setText("After I turned back there is a shadowy figure staring at me.");           
           }
           if(countdialog==14){
            bts.playOnce();
            dialogarea.setText(Player_Name +" : Hey, Who's there ?");          
           }
           if(countdialog==15){
           bts.playOnce();
           ghostJS.setVisible(true);
           JSsound.playOnce();
           dialogarea.setText("^&%$^&%$^&#$*&#^%*&^(%^&(^&*#*&%^#$*&^");
           }
           if(countdialog==16){
           bts.playOnce();
           ghostJS.setVisible(false);
           scenepane.setIcon(hallway);
           dialogarea.setText("You passed out...........");
           scenecount++;
           }
           countdialog++;
           }
           public void scene5(){
           if(countdialog==17){
           bts.playOnce();
           dialogarea.setText(Player_Name+" : Argh my head.");
           }
           if(countdialog==18){
           bts.playOnce();
           phonecall.playLoop();
           dialogarea.setText("*phone ringing*");
           }
           if(countdialog==19){
           bts.playOnce();
           phonecall.stop();
           dialogarea.setText("I picked up the phone");
           }
           if(countdialog==20){
           bts.playOnce();
           noise.playOnce();
           dialogarea.setText("*noises*");
           }
           if(countdialog==21){
           bts.playOnce();
           scenepane.setIcon(hallwarp);
           dialogarea.setText(Player_Name+" : Ah not again !");
           }
           if(countdialog==22){
           bts.playOnce();
           dialogarea.setText("You started to faint");
           scenecount++;
           }
           countdialog++;
           }
           public void scene6(){
           if(countdialog==23){
           bts.playOnce();
           character.setVisible(true);
           game2Label.setVisible(true);
           scenepane.setIcon(computer);
           dialogarea.setText("You got up and Taro is shaking you...");
           }
           if(countdialog==24){
           bts.playOnce();
           dialogarea.setText("Taro: Hey are you okay ?");
           }
           if(countdialog==25){
           bts.playOnce();
           dialogarea.setText(Player_Name+" : Y.....Yes");
           }
           if(countdialog==26){
           bts.playOnce();
           dialogarea.setText("Taro : What are you doing ?");
           }
           if(countdialog==27){
           bts.playOnce();
           dialogarea.setText(Player_Name +" : Checking out the file on this computer.");
           }
           if(countdialog==28){
           bts.playOnce();
           dialogarea.setText("Taro : The file that is on the screen right now ?");
           }
           if(countdialog==29){
           bts.playOnce();
           dialogarea.setText(Player_Name + " : Right... !?");
           }
           if(countdialog==30){
           bts.playOnce();
           dialogarea.setText("Taro : Let's go out side it is morning already ! ");
           }
           if(countdialog==31){
           bts.playOnce();
           game2Label.setVisible(false);
           character.setVisible(false);
           scenepane.setIcon(lightbuilding);
           dialogarea.setText("After that Taro stayed with me until my head feels better and nothing weird ever happens again forever after and "+ Player_Name +" stay out of harm way and live until the ripe old age of 90 ...........");
           }
           if(countdialog==32){
           bts.playOnce();
           scenepane.setVisible(false);
           dialogpane.setVisible(false);
           endscene.setVisible(true);
           Component c = this.getTopLevelAncestor();
           Window w = (Window) c;
           w.requestFocusInWindow();
           }
           countdialog++;
           }
           public void ENDGAME()  // endgame label contains credits name of creator and listener to start from menu
           {
       
               endscene = new JLabel(EndBG);
               endscene.setSize(frameWidth,frameHeight);
               endscene.setLayout(null);
               JLabel ghostt = new JLabel(ghost);
               ghostt.setBounds(0,0,342,frameHeight);
               JLabel tarot = new JLabel(taro);
               tarot.setBounds(1024,0,342,frameHeight);
               JTextPane IDS = new JTextPane();
               IDS.setBackground(Color.BLACK);
               IDS.setEditable(false);
               IDS.setForeground(Color.WHITE);
               IDS.setFont( new Font("SanSerif", Font.BOLD | Font.ITALIC, 40) );
               IDS.setText("\n\n\nThank you for playing\n Hope you enjoy this game :D\n\n\n"
                       + "6313128 Natthawut Saexu\n6313136 Phuwadol Khamdad\n" 
                       + "6313213 Chokchai Bisgood");
               StyledDocument doc = IDS.getStyledDocument();
               SimpleAttributeSet center = new SimpleAttributeSet();
               StyleConstants.setAlignment(center, StyleConstants.ALIGN_CENTER);
               doc.setParagraphAttributes(0, doc.getLength(), center, false);               
               IDS.setBounds(342,0,682,frameHeight);
               endscene.add(ghostt);
               endscene.add(IDS);
               endscene.add(tarot);
               Day_3.add(endscene);
               IDS.setFocusable(false);
               tarot.setFocusable(false);
               ghostt.setFocusable(false);
               endscene.setFocusable(false);
               endscene.setVisible(false);
               endscene.addMouseListener(new MouseAdapter()
               {
                   public void mouseClicked( MouseEvent e )
                   {
                        for(SoundEffect a: AllSound){a.stop();}
                        Component c = Day_3.getTopLevelAncestor();
                        if (c instanceof Window) 
                        {         
                            theme.stop();
                            Window w = (Window) c;
                            w.dispose();
                        }
                    new MainApplication();
                    }
               });
               IDS.addMouseListener(new MouseAdapter()
               {
                   public void mouseClicked( MouseEvent e )
                   {
                        for(SoundEffect a: AllSound){a.stop();}
                        Component c = Day_3.getTopLevelAncestor();
                        if (c instanceof Window) 
                        {         
                            theme.stop();
                            Window w = (Window) c;
                            w.dispose();
                        }
                    new MainApplication();
                    }
               });
       
           }
           //============================== 
                        public void youdie()
            {
                UIManager.put("OptionPane.messageFont", new Font("SanSerif", Font.BOLD | Font.ITALIC, 20));
                JOptionPane.showMessageDialog(new JFrame(), "All hope are lost START OVER FROM MENU", "YOU DIED !!!!",
                JOptionPane.INFORMATION_MESSAGE );
                for(SoundEffect a: AllSound){a.stop();}
                Component c = this.getTopLevelAncestor();
                if (c instanceof Window) 
                {         
                    theme.stop();
                    Window w = (Window) c;
                    w.dispose();
                }
                new Game(frameWidth,frameHeight,Volume,Player_Name);
            }
            public void minigame2() //this method create game2Label which inside contains combobox
            {
                game2Label = new JLabel(mingame2scene);
                game2Label.setFocusable(false);
                JLabel animalLabel = new JLabel(space);
                game2Label.setLayout(new BorderLayout());
                animalLabel.setSize(400,200);
                JButton Enter = new JButton("Enter");
                Enter.setFocusable(false);
                JComboBox combo = new JComboBox(animalitem);
                combo.setFocusable(false);
                combo.setSelectedItem(null);
                game2Label.setBounds(500,0,400,390);
                game2Label.add(combo,BorderLayout.PAGE_START);
                game2Label.add(animalLabel,BorderLayout.CENTER);
                game2Label.add(Enter,BorderLayout.SOUTH);
                scenepane.add(game2Label);
                game2Label.setVisible(true);
                combo.addItemListener( new ItemListener() 
                {
                    public void itemStateChanged( ItemEvent e )
                    {
                        minigame2select = true;
                        int index = combo.getSelectedIndex();
                        switch (index)
                        {
                            case 0:{selected=0;}break;
                            case 1:{selected=1;}break;
                            case 2:{selected=2;}break;
                            case 3:{selected=3;}break;
                            case 4:{selected=4;}break;
                            case 5:{selected=5;}break;
                            case 6:{selected=6;}break;
                            case 7:{selected=7;}break;
                        }
                    }
                });
                Enter.addActionListener(new ActionListener(){
                @Override    
                    public void actionPerformed(ActionEvent e)
                    {
                        if(minigame2select == true)
                        {
                            switch (selected)
                            {
                                case 0:{animalLabel.setIcon(axolotl);}break;
                                case 1:{animalLabel.setIcon(lemur);}break;
                                case 2:{animalLabel.setIcon(dingo);}break;
                                case 3:{
                                        animalLabel.setIcon(wendigo);
                                        bts.playOnce();
                                        dialogarea.setText(Player_Name + " : Ah...... Yes it must be this one!!");
                                        countdialog++;
                                        Enter.setVisible(false);
                                        combo.setVisible(false);}break;
                                case 4:{animalLabel.setIcon(hedgehog);}break;
                                case 5:{animalLabel.setIcon(blackbear);}break;
                                case 6:{animalLabel.setIcon(kakapo);}break;
                                case 7:{animalLabel.setIcon(slothi);}break;
                            }
                        }
                    }      
                });
            game2Label.setVisible(false);
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
         
} 

