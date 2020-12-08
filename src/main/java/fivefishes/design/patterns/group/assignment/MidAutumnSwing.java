package fivefishes.design.patterns.group.assignment;

import fivefishes.design.patterns.group.assignment.components.ButtonPanel;
import fivefishes.design.patterns.group.assignment.components.DesignPatternControlPanel;
import fivefishes.design.patterns.group.assignment.components.TableLabel;
import fivefishes.design.patterns.group.assignment.components.abstractFactory.*;
import fivefishes.design.patterns.group.assignment.components.strategy.StrategyControlPanel;
import fivefishes.design.patterns.group.assignment.components.strategy.LanternLabel;
import fivefishes.design.patterns.group.assignment.components.decorator.*;
import fivefishes.design.patterns.group.assignment.components.memento.MementoControlPanel;
import fivefishes.design.patterns.group.assignment.components.observer.*;
import fivefishes.design.patterns.group.assignment.controllers.abstractFactory.AbstractFactoryController;
import fivefishes.design.patterns.group.assignment.controllers.strategy.LightBehaviourController;
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
    private int imageWidth;
    private int imageStartXaxis;
    private int imageStartYaxis;

    //Abstract Factory
    private TableLabel tableLabel = new TableLabel();
    private MooncakeDescriptionPanel mooncakeDescriptionPanel = new MooncakeDescriptionPanel();
    private MooncakeLabel mooncakeLabel = new MooncakeLabel(mooncakeDescriptionPanel);
    private AbstractFactoryController abstractFactoryController = new AbstractFactoryController(mooncakeDescriptionPanel, mooncakeLabel);

    // Decorator
    House house = new House();
    JLayeredPane houseLayeredPanel = new JLayeredPane();
    JLabel houseLabel = house.getImages().get(0);
    HouseController houseController = new HouseController(houseLayeredPanel, house, this);
    HouseImagePanel houseImagePanel = new HouseImagePanel();

    // Memento
    private JLabel changErLabel = new JLabel();
    private MementoController mementoController = new MementoController(changErLabel);

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

    // Strategy
    private LanternLabel lanternLabel = new LanternLabel();
    private LightBehaviourController lightBehaviourController = new LightBehaviourController(lanternLabel);

    private DesignPatternControlPanel abstractFactoryControlPanel = new AbstractFactoryControlPanel("Abstract Factory", abstractFactoryController);
    private DesignPatternControlPanel decoratorControlPanel = new DecoratorControlPanel("Decorator", houseController);
    private DesignPatternControlPanel mementoControlPanel = new MementoControlPanel("Memento", "Only 5 history max at a time", mementoController);
    private DesignPatternControlPanel observerControlPanel = new ObserverControlPanel("Observer", observerController, timerLabel);
    private DesignPatternControlPanel strategyControlPanel = new StrategyControlPanel("Strategy", lightBehaviourController);

    private Dimension buttonPanelDimension = new Dimension((int) screenSize.getWidth(), buttonPanelHeight);
    private List<DesignPatternControlPanel> designPatternControlPanels = new ArrayList<DesignPatternControlPanel>() {{
        add(abstractFactoryControlPanel);
        add(decoratorControlPanel);
        add(mementoControlPanel);
        add(observerControlPanel);
        add(strategyControlPanel);
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
        int tableXaxis = imageStartXaxis + imageWidth - 725;
        int tableYaxis = imageHeight - 205;
        int mooncakeXaxis = tableXaxis + 15;
        int mooncakeYaxis = tableYaxis - 30;
        tableLabel.setBounds(tableXaxis, tableYaxis, 260, 178);
        mooncakeLabel.setBounds(mooncakeXaxis, mooncakeYaxis, 207, 53);
        backgroundImageLabel.add(mooncakeDescriptionPanel);
        backgroundImageLabel.add(mooncakeLabel);
        backgroundImageLabel.add(tableLabel);
        mooncakeDescriptionPanel.setBounds(tableXaxis - 20, 20, 380, 300);
        mooncakeDescriptionPanel.setLayout(new BoxLayout(mooncakeDescriptionPanel, BoxLayout.Y_AXIS));
        mooncakeDescriptionPanel.setVisible(false);

        // Strategy
        int laternXaxis = imageStartXaxis + 300;
        int laternYaxis = imageStartYaxis + 150;
        lanternLabel.setBounds(laternXaxis, laternYaxis, 200, 200);
        backgroundImageLabel.add(lanternLabel);

        // Decorator
        houseLabel.setBounds(0, 0, 300, 300);
        houseLayeredPanel.add(houseLabel, JLayeredPane.DEFAULT_LAYER);
//        houseLayeredPanel.setBounds(0, 0, imageWidth, imageHeight);
        int houseYaxis = imageHeight - 315;
        houseLayeredPanel.setBounds(200, houseYaxis, 300, 300);
        backgroundImageLabel.add(houseLayeredPanel, JLayeredPane.PALETTE_LAYER);

        // Memento
        int changErImageXaxis = imageStartXaxis + imageWidth - 350;
        int changErImageYaxis = 0;
        changErLabel.setBounds(changErImageXaxis, changErImageYaxis, 300, 300);
        backgroundImageLabel.add(changErLabel);

        // Observer
        new Thread(timerWorker).start();
        executorService.scheduleAtFixedRate(subjectWorker, 1, 1, TimeUnit.MINUTES);
        int rabbitXaxis = imageStartXaxis + imageWidth - 325;
        int rabbitYaxis = imageHeight - 180;
        dancingRabbitLabel.setBounds(rabbitXaxis, rabbitYaxis, 500, 178);
        singingRabbitLabel.setBounds(rabbitXaxis - 100, rabbitYaxis, 500, 178);
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

        imageWidth = backgroundResizedImage.getWidth(null);
        imageStartXaxis = (int) (screenSize.getWidth() - backgroundResizedImage.getWidth(null)) / 2;
        imageStartYaxis = 10;
    }
}//class
