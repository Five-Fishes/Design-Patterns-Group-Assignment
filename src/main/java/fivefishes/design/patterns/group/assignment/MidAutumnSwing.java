package fivefishes.design.patterns.group.assignment;

import fivefishes.design.patterns.group.assignment.components.observer.ObserverCheckBox;
import fivefishes.design.patterns.group.assignment.components.observer.RabbitGifLabel;
import fivefishes.design.patterns.group.assignment.components.observer.TimerLabel;
import fivefishes.design.patterns.group.assignment.entities.observer.*;
import fivefishes.design.patterns.group.assignment.enums.observer.RabbitImage;
import fivefishes.design.patterns.group.assignment.interfaces.observer.Observer;
import fivefishes.design.patterns.group.assignment.worker.observer.SubjectWorker;
import fivefishes.design.patterns.group.assignment.worker.observer.TimerWorker;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.HashSet;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class MidAutumnSwing extends JFrame implements ActionListener {

    private RabbitGifLabel dancingRabbitLabel= new RabbitGifLabel(RabbitImage.Dancing);
    private RabbitGifLabel singingRabbitLabel= new RabbitGifLabel(RabbitImage.Singing);
    private Observer audioPlayerObserver = new AudioPlayerObserver();
    private RabbitObserver rabbitObserver = new RabbitObserver(dancingRabbitLabel,singingRabbitLabel);
    private ClockSubject clockSubject = new ClockSubject(
            new HashSet<Observer>() {{
                add(audioPlayerObserver);
                add(rabbitObserver);
            }}
    );
    private JLabel timerLabel = new TimerLabel();
    private ObserverCheckBox rabbitObserverCheckBox = new ObserverCheckBox(clockSubject, rabbitObserver);
    private ObserverCheckBox audioPlayerObserverCheckBox = new ObserverCheckBox(clockSubject, audioPlayerObserver);
    SubjectWorker subjectWorker = new SubjectWorker(clockSubject);
    TimerWorker timerWorker = new TimerWorker(timerLabel);
    ScheduledExecutorService executorService = Executors.newScheduledThreadPool(1);


    //Buttons
    private JButton lightButton;
    private JButton exitButton;

    //Panels
    private JPanel titlePanel, backgroundImagePanel, buttonPanel;

    //Labels
    private JLabel title, backgroundImageLabel;

    //Image
    private BufferedImage image;


    private boolean lights = false;

    private int imageHeight;
    private Image resizedImage;

    private final int buttonPanelHeight = 150;
    private int imageStartXaxis;
    private int imageStartYaxis;
    private final Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();


    public MidAutumnSwing() {
        //Set title
        setTitle("Decorate the Christmas tree!");

        setLayout(new BorderLayout());

        //Setting the title of the JLabel
        title = new JLabel("Creative Designed By 30000007333 From <a href=\"https://lovepik.com/image-400492940/mid-autumn-festival-background.html\">LovePik.com</a>");

        //Setting the font
        title.setFont(new Font("CENTURY GOTHIC", Font.ITALIC, 15));

        //Setting the text colour to red and positioning it to the centre
        title.setForeground(Color.red);
        title.setHorizontalAlignment(SwingConstants.CENTER);

        //Creating a new JPanel and adding the title label to it
        titlePanel = new JPanel();
        titlePanel.add(title);

        //Setting colour of title panel
        titlePanel.setBackground(Color.white);

        //Creating a new JPanel for the image to go
        backgroundImagePanel = new JPanel();

        //Retrieving image from the file
        try {
            image = ImageIO.read(new File("src/main/java/fivefishes/design/patterns/group/assignment/resources/background.jpg"));
        } catch (IOException ex) {
            ex.printStackTrace();
        }

        backgroundImageConfiguration();
        //Adding the image to a label
        backgroundImageLabel = new JLabel(new ImageIcon(resizedImage));

        backgroundImagePanel.add(backgroundImageLabel);
        backgroundImagePanel.setBackground(Color.white);

        //Creating a new JPanel for the buttons to go
        buttonPanel = new JPanel();

        //Setting colour of button panel
        buttonPanel.setBackground(Color.white);

        new Thread(timerWorker).start();
        executorService.scheduleAtFixedRate(subjectWorker, 0, 1, TimeUnit.MINUTES);

        //Naming buttons
        lightButton = new JButton("Lights");
        exitButton = new JButton("Exit");

        //Setting colour of buttons
        lightButton.setBackground(Color.red);
        exitButton.setBackground(Color.red);

        //Setting font on buttons
        lightButton.setFont(new Font("CENTURY GOTHIC", Font.ITALIC, 16));
        exitButton.setFont(new Font("CENTURY GOTHIC", Font.ITALIC, 16));

        //Setting font colour on buttons
        lightButton.setForeground(Color.white);
        exitButton.setForeground(Color.white);

        //Add the buttons to the buttonPanel
        buttonPanel.add(lightButton);
        buttonPanel.add(exitButton);
        buttonPanel.add(timerLabel);
        buttonPanel.add(rabbitObserverCheckBox);
        buttonPanel.add(audioPlayerObserverCheckBox);

        //Enable buttons to listen for a mouse-click
        lightButton.addActionListener(this);
        exitButton.addActionListener(this);

        //Positioning Panels
        add(titlePanel, BorderLayout.NORTH);
        add(backgroundImagePanel, BorderLayout.CENTER);
        add(buttonPanel, BorderLayout.SOUTH);

        // set buttonPanel width and height
        buttonPanel.setPreferredSize(new Dimension((int) screenSize.getWidth(), buttonPanelHeight));

        dancingRabbitLabel.setBounds(800, 500, 500, 178);
        singingRabbitLabel.setBounds(1100, 500, 500, 178);
        backgroundImageLabel.add(dancingRabbitLabel);
        backgroundImageLabel.add(singingRabbitLabel);

        //Configure the frame
//        getContentPane().setBackground(Color.white);
//        getContentPane().add(panelContainer);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(screenSize);
        setLocation(0, 0);
        setVisible(true);

    }//Constructor

    public void paint(Graphics g) {
        //Call the paint method of the superclass
        super.paint(g);

        // Perform drawing here using g.drawImage()

    } //paint

    //Coding the event-handling routine
    public void actionPerformed(ActionEvent event) {

        if (event.getSource() == lightButton) {

        }//if light

        else {
            System.exit(0);

        }//else exit

    } //actionPerformed

    private void backgroundImageConfiguration() {
        imageHeight = (int) (screenSize.getHeight() - buttonPanelHeight - 20);
        resizedImage = image.getScaledInstance(-1, imageHeight, Image.SCALE_SMOOTH);

        imageStartXaxis = (int) (screenSize.getWidth() - resizedImage.getWidth(null)) / 2;
        imageStartYaxis = 10;
    }

}//class
