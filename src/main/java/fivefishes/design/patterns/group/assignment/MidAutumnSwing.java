package fivefishes.design.patterns.group.assignment;

import fivefishes.design.patterns.group.assignment.components.ButtonPanel;
import fivefishes.design.patterns.group.assignment.components.DesignPatternControlPanel;
import fivefishes.design.patterns.group.assignment.components.TableLabel;
import fivefishes.design.patterns.group.assignment.components.abstractFactory.*;
import fivefishes.design.patterns.group.assignment.components.behaviour.BehaviourControlPanel;
import fivefishes.design.patterns.group.assignment.components.behaviour.LanternLabel;
import fivefishes.design.patterns.group.assignment.components.decorator.*;
import fivefishes.design.patterns.group.assignment.components.memento.MementoControlPanel;
import fivefishes.design.patterns.group.assignment.components.observer.*;
import fivefishes.design.patterns.group.assignment.controllers.abstractFactory.AbstractFactoryController;
import fivefishes.design.patterns.group.assignment.controllers.behaviour.LightBehaviourController;
import fivefishes.design.patterns.group.assignment.controllers.decorator.HouseController;
import fivefishes.design.patterns.group.assignment.controllers.memento.MementoController;
import fivefishes.design.patterns.group.assignment.controllers.observer.ObserverController;
import fivefishes.design.patterns.group.assignment.entities.decorator.House;

import fivefishes.design.patterns.group.assignment.entities.observer.*;
import fivefishes.design.patterns.group.assignment.enumerations.observer.RabbitImage;
import fivefishes.design.patterns.group.assignment.interfaces.observer.Observer;
import fivefishes.design.patterns.group.assignment.workers.observer.SubjectWorker;
import fivefishes.design.patterns.group.assignment.workers.observer.TimerWorker;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class MidAutumnSwing extends JFrame {

    // General
    private final Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    private final int buttonPanelHeight = 150;
    private JPanel backgroundImagePanel = new JPanel();
    private JLabel backgroundImageLabel;

    // Background
    private Image backgroundResizedImage;
    private int imageHeight;
    private int imageStartXaxis;
    private int imageStartYaxis;

    //Abstract Factory
    private TableLabel tableLabel = new TableLabel();
    private MooncakeDescriptionPanel mooncakeDescriptionPanel = new MooncakeDescriptionPanel();
    private MooncakeLabel mooncakeLabel = new MooncakeLabel(mooncakeDescriptionPanel);
    private AbstractFactoryController abstractFactoryController = new AbstractFactoryController(mooncakeDescriptionPanel, mooncakeLabel);

    // Behaviour
    private LanternLabel lanternLabel = new LanternLabel();
    private LightBehaviourController lightBehaviourController = new LightBehaviourController(lanternLabel);

    // Decorator
    House house = new House();
    JLayeredPane houseLayeredPanel = new JLayeredPane();
    JLabel houseLabel = house.getImages().get(0);
    HouseController houseController = new HouseController(houseLayeredPanel, house, this);
    HouseImagePanel houseImagePanel = new HouseImagePanel();

    // Memento
    private JLabel changErLabel = new JLabel();
    private MementoController mementoController = new MementoController(changErLabel);
    private int changErImageXaxis;
    private int changErImageYaxis;

    // Observer
    private TimerLabel timerLabel = new TimerLabel();
    private RabbitGifLabel dancingRabbitLabel = new RabbitGifLabel(RabbitImage.Dancing);
    private RabbitGifLabel singingRabbitLabel = new RabbitGifLabel(RabbitImage.Singing);
    private AudioPlayerObserver audioPlayerObserver = new AudioPlayerObserver();
    private RabbitObserver rabbitObserver = new RabbitObserver(dancingRabbitLabel, singingRabbitLabel);
    private ClockSubject clockSubject = new ClockSubject(
            new HashSet<Observer>() {{
                add(audioPlayerObserver);
                add(rabbitObserver);
            }}
    );
    private ObserverController observerController = new ObserverController(clockSubject, audioPlayerObserver, rabbitObserver);
    SubjectWorker subjectWorker = new SubjectWorker(clockSubject);
    TimerWorker timerWorker = new TimerWorker(timerLabel);
    ScheduledExecutorService executorService = Executors.newScheduledThreadPool(1);

    private DesignPatternControlPanel abstractFactoryControlPanel = new AbstractFactoryControlPanel("Abstract Factory", abstractFactoryController);
    private DesignPatternControlPanel behaviourControlPanel = new BehaviourControlPanel("Behaviour", lightBehaviourController);
    private DesignPatternControlPanel decoratorControlPanel = new DecoratorControlPanel("Decorator", houseController);
    private DesignPatternControlPanel mementoControlPanel = new MementoControlPanel("Memento", "Only 5 ChangEr will be saved in history", mementoController);
    private DesignPatternControlPanel observerControlPanel = new ObserverControlPanel("Observer", observerController, timerLabel);

    private Dimension buttonPanelDimension = new Dimension((int) screenSize.getWidth(), buttonPanelHeight);
    private List<DesignPatternControlPanel> designPatternControlPanels = new ArrayList<DesignPatternControlPanel>() {{
        add(abstractFactoryControlPanel);
        add(behaviourControlPanel);
        add(decoratorControlPanel);
        add(mementoControlPanel);
        add(observerControlPanel);
    }};
    private ButtonPanel buttonPanel = new ButtonPanel(designPatternControlPanels, buttonPanelDimension);

    public MidAutumnSwing() {

        // General
        this.setTitle("MidAutumn Festival");
        this.setLayout(new BorderLayout());
        this.add(backgroundImagePanel, BorderLayout.CENTER);
        this.add(buttonPanel, BorderLayout.SOUTH);
        this.getContentPane().setBackground(Color.white);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(screenSize);
        this.setLocation(0, 0);
        this.setVisible(true);

        // Background
        backgroundImageConfiguration();
        backgroundImageLabel = new JLabel(new ImageIcon(backgroundResizedImage));
        backgroundImagePanel.setBackground(Color.white);
        backgroundImagePanel.add(backgroundImageLabel);

        //Abstract Factory
        tableLabel.setBounds(1120, 600, 260, 178);
        mooncakeLabel.setBounds(1155, 570, 207, 53);
        backgroundImageLabel.add(mooncakeDescriptionPanel);
        backgroundImageLabel.add(mooncakeLabel);
        backgroundImageLabel.add(tableLabel);
        mooncakeDescriptionPanel.setBounds(800, 300, 400, 300);
        mooncakeDescriptionPanel.setLayout(new BoxLayout(mooncakeDescriptionPanel, BoxLayout.Y_AXIS));
        mooncakeDescriptionPanel.setVisible(false);

        // Behaviour
        lanternLabel.setBounds(400, 200, 200, 200);
        backgroundImageLabel.add(lanternLabel);

        // Decorator
        houseLabel.setBounds(0, 0, 300, 300);
        houseLayeredPanel.add(houseLabel, JLayeredPane.DEFAULT_LAYER);
        int imageHeight = (int) (screenSize.getHeight() - buttonPanelHeight - 20);
        int imageWidth = (int) screenSize.getWidth();
        houseLayeredPanel.setBounds(0, 0, imageWidth, imageHeight);
        houseLayeredPanel.setBounds(200, 250, 300, 300);
        backgroundImageLabel.add(houseLayeredPanel, JLayeredPane.PALETTE_LAYER);

        // Memento
        changErImageXaxis = (int) screenSize.getWidth() - 350;
        changErImageYaxis = 100;
        changErLabel.setBounds(changErImageXaxis, changErImageYaxis, 300, 300);
        backgroundImageLabel.add(changErLabel);

        // Observer
        new Thread(timerWorker).start();
        executorService.scheduleAtFixedRate(subjectWorker, 0, 1, TimeUnit.MINUTES);
        dancingRabbitLabel.setBounds(800, 500, 500, 178);
        singingRabbitLabel.setBounds(1100, 500, 500, 178);
        backgroundImageLabel.add(dancingRabbitLabel);
        backgroundImageLabel.add(singingRabbitLabel);
        
    }//Constructor


    private void backgroundImageConfiguration() {
        BufferedImage image = null;
        try {
            image = ImageIO.read(new File("src/main/java/fivefishes/design/patterns/group/assignment/resources/background.jpg"));
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        imageHeight = (int) (screenSize.getHeight() - buttonPanelHeight - 20);
        backgroundResizedImage = image.getScaledInstance(-1, imageHeight, Image.SCALE_SMOOTH);

        imageStartXaxis = (int) (screenSize.getWidth() - backgroundResizedImage.getWidth(null)) / 2;
        imageStartYaxis = 10;
    }
}//class
