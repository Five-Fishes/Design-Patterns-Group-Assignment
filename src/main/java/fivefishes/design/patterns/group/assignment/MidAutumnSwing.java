package fivefishes.design.patterns.group.assignment;

import fivefishes.design.patterns.group.assignment.components.TableLabel;
import fivefishes.design.patterns.group.assignment.components.abstractFactory.*;
import fivefishes.design.patterns.group.assignment.components.behaviour.LanternLabel;
import fivefishes.design.patterns.group.assignment.components.behaviour.LanternLightComboBox;
import fivefishes.design.patterns.group.assignment.components.decorator.*;
import fivefishes.design.patterns.group.assignment.components.memento.ChangErFashionComboBox;
import fivefishes.design.patterns.group.assignment.components.memento.RedoButton;
import fivefishes.design.patterns.group.assignment.components.memento.UndoButton;
import fivefishes.design.patterns.group.assignment.controllers.abstractFactory.AbstractFactoryController;
import fivefishes.design.patterns.group.assignment.controllers.behaviour.LightBehaviourController;
import fivefishes.design.patterns.group.assignment.controllers.decorator.HouseController;
import fivefishes.design.patterns.group.assignment.controllers.memento.MementoController;
import fivefishes.design.patterns.group.assignment.entities.decorator.House;

import fivefishes.design.patterns.group.assignment.components.observer.ObserverCheckBox;
import fivefishes.design.patterns.group.assignment.components.observer.RabbitGifLabel;
import fivefishes.design.patterns.group.assignment.components.observer.TimerLabel;
import fivefishes.design.patterns.group.assignment.entities.observer.*;
import fivefishes.design.patterns.group.assignment.enumerations.observer.RabbitImage;
import fivefishes.design.patterns.group.assignment.interfaces.observer.Observer;
import fivefishes.design.patterns.group.assignment.workers.observer.SubjectWorker;
import fivefishes.design.patterns.group.assignment.workers.observer.TimerWorker;

import fivefishes.design.patterns.group.assignment.entities.behaviour.Bright;
import fivefishes.design.patterns.group.assignment.entities.behaviour.Dim;
import fivefishes.design.patterns.group.assignment.entities.behaviour.Lantern;
import fivefishes.design.patterns.group.assignment.entities.behaviour.NoLight;
import fivefishes.design.patterns.group.assignment.entities.behaviour.Normal;

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

public class MidAutumnSwing extends JFrame {

    // General
    private JPanel backgroundImagePanel = new JPanel();
    private JPanel buttonPanel = new JPanel();
    private JPanel infoPanel = new JPanel();
    private JLabel backgroundImageLabel;

    private final Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    private final int buttonPanelHeight = 150;

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
    private AddMooncakeButton addMooncakeButton = new AddMooncakeButton(abstractFactoryController);
    private MooncakeStyleComboBox mooncakeStyleComboBox = new MooncakeStyleComboBox(abstractFactoryController);
    private MooncakeFlavorComboBox mooncakeFlavorComboBox = new MooncakeFlavorComboBox(abstractFactoryController);

    // Behaviour
    private LanternLabel lanternLabel = new LanternLabel();
    private LightBehaviourController lightBehaviourController = new LightBehaviourController(lanternLabel);
    private LanternLightComboBox lanternLightComboBox = new LanternLightComboBox(lightBehaviourController);

    // Decorator
    House house = new House();
    JLayeredPane houseLayeredPanel = new JLayeredPane();
    JLabel houseLabel = house.getImages().get(0);
    HouseController houseController = new HouseController(houseLayeredPanel, house, this);
    DecoratorComboBox decoratorComboBox = new DecoratorComboBox(houseController);
    ApplyDecorationButton applyDecorationButton = new ApplyDecorationButton(houseController);
    ClearDecorationButton clearDecorationButton = new ClearDecorationButton(houseController);
    HouseImagePanel houseImagePanel = new HouseImagePanel();

    // Memento
    private JLabel changErLabel = new JLabel();
    private MementoController mementoController = new MementoController(changErLabel);
    private UndoButton undoButton = new UndoButton(mementoController);
    private RedoButton redoButton = new RedoButton(mementoController);
    private ChangErFashionComboBox changErFashionComboBox = new ChangErFashionComboBox(mementoController);
    private int changErImageXaxis;
    private int changErImageYaxis;

    // Observer
    private RabbitGifLabel dancingRabbitLabel = new RabbitGifLabel(RabbitImage.Dancing);
    private RabbitGifLabel singingRabbitLabel = new RabbitGifLabel(RabbitImage.Singing);
    private Observer audioPlayerObserver = new AudioPlayerObserver();
    private RabbitObserver rabbitObserver = new RabbitObserver(dancingRabbitLabel, singingRabbitLabel);
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
        backgroundImageLabel.setLayout(null);
        backgroundImagePanel.add(backgroundImageLabel);
        backgroundImagePanel.setBackground(Color.white);

        // infoPanel
        infoPanel.add(new JLabel("Only 5 ChangEr will be saved in history"));
        infoPanel.setBackground(Color.white);

        // buttonPanel
        buttonPanel.add(infoPanel);
        buttonPanel.setAlignmentX(Component.LEFT_ALIGNMENT);
        buttonPanel.setBackground(Color.white);
        buttonPanel.setPreferredSize(new Dimension((int) screenSize.getWidth(), buttonPanelHeight));

        //Abstract Factory
        tableLabel.setBounds(1120, 600, 260, 178);
        mooncakeLabel.setBounds(1155, 570, 207, 53);
        backgroundImageLabel.add(mooncakeDescriptionPanel);
        backgroundImageLabel.add(mooncakeLabel);
        backgroundImageLabel.add(tableLabel);
        mooncakeDescriptionPanel.setBounds(800, 300, 400, 300);
        mooncakeDescriptionPanel.setLayout(new BoxLayout(mooncakeDescriptionPanel, BoxLayout.Y_AXIS));
        mooncakeDescriptionPanel.setVisible(false);
        buttonPanel.add(mooncakeStyleComboBox);
        buttonPanel.add(mooncakeFlavorComboBox);
        buttonPanel.add(addMooncakeButton);

        // Behaviour
        lanternLabel.setBounds(400, 200, 200, 200);
        backgroundImageLabel.add(lanternLabel);
        buttonPanel.add(lanternLightComboBox);

        // Decorator
        houseLabel.setBounds(0, 0, 300, 300);
        houseLayeredPanel.add(houseLabel, JLayeredPane.DEFAULT_LAYER);
        int imageHeight = (int) (screenSize.getHeight() - buttonPanelHeight - 20);
        int imageWidth = (int) screenSize.getWidth();
        houseLayeredPanel.setBounds(0, 0, imageWidth, imageHeight);
        backgroundImagePanel.add(houseImagePanel, JLayeredPane.DEFAULT_LAYER);
        houseLayeredPanel.setBounds(200, 250, 300, 300);
        backgroundImageLabel.add(houseLayeredPanel, JLayeredPane.PALETTE_LAYER);
        buttonPanel.add(decoratorComboBox);
        buttonPanel.add(applyDecorationButton);
        buttonPanel.add(clearDecorationButton);

        // Memento
        changErImageXaxis = (int) screenSize.getWidth() - 350;
        changErImageYaxis = 100;
        changErLabel.setBounds(changErImageXaxis, changErImageYaxis, 300, 300);
        backgroundImageLabel.add(changErLabel);
        buttonPanel.add(undoButton);
        buttonPanel.add(changErFashionComboBox);
        buttonPanel.add(redoButton);

        // Observer
        new Thread(timerWorker).start();
        executorService.scheduleAtFixedRate(subjectWorker, 0, 1, TimeUnit.MINUTES);
        dancingRabbitLabel.setBounds(800, 500, 500, 178);
        singingRabbitLabel.setBounds(1100, 500, 500, 178);
        backgroundImageLabel.add(dancingRabbitLabel);
        backgroundImageLabel.add(singingRabbitLabel);
        buttonPanel.add(timerLabel);
        buttonPanel.add(rabbitObserverCheckBox);
        buttonPanel.add(audioPlayerObserverCheckBox);
        
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
