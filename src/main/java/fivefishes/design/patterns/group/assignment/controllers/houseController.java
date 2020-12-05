package fivefishes.design.patterns.group.assignment.controllers;

import java.awt.*;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.JLabel;
import static javax.swing.JOptionPane.showMessageDialog;

import fivefishes.design.patterns.group.assignment.MidAutumnSwing;
import fivefishes.design.patterns.group.assignment.entities.fireworkDecorator;
import fivefishes.design.patterns.group.assignment.entities.flagsDecorator;
import fivefishes.design.patterns.group.assignment.entities.house;
import fivefishes.design.patterns.group.assignment.entities.houseBase;
import fivefishes.design.patterns.group.assignment.entities.lanternDecorator;
import fivefishes.design.patterns.group.assignment.entities.candlesDecorator;
import fivefishes.design.patterns.group.assignment.interfaces.IDecoratable;

public class houseController {
  public static int order = 201;
  public IDecoratable house;
  private MidAutumnSwing frame;
  private Rectangle areaToRepaint;
  private houseBase layered_house;

  public houseController(MidAutumnSwing frame, Rectangle areaToRepaint, houseBase layered_house){
    this.frame = frame;
    this.areaToRepaint = areaToRepaint;
    this.layered_house = layered_house;
  }

  public void onDecorationSelected(String decoratorName){
    /**
     * create new decorator instance and wrap house within
     * example:
     *   house = new lanternDecorator(house);
     */
    switch (decoratorName.toLowerCase()) {
      case "lanterndecorator":
        
        house = new lanternDecorator(house);
        break;
      case "fireworkdecorator":
      
        house = new fireworkDecorator(house);
        break;
      case "candlesdecorator":

        house = new candlesDecorator(house);
        break;
      case "flagsdecorator":

        house = new flagsDecorator(house);
        break;
      default:
        break;
    }
  }

  public void onApplyDecoratorClicked(){
    if (house.getImages().size() == 1) {
      showMessageDialog(frame, "No decoration selected");
    } else {
      applyDecorations();   
    }  
  }

  public void onClearDecorationsClicked() {
    if (house.getImages().size() == 1) {
      showMessageDialog(frame, "No decoration to clear!");
    } else {
      layered_house.removeAll();
      this.house = new house();
      applyDecorations();  
    }
    
  }

  private void applyDecorations(){
    layered_house.removeAll();
    /* Do layers composing */ 
    ArrayList<JLabel> labels = house.getImages();
    for (int i = labels.size(); i > 0; i--) {
      JLabel templbl = labels.get(i-1);
      Random r = new Random();

      int x_position = i == labels.size() ? 0 : r.nextInt(60) - 30;
      
      templbl.setBounds(x_position, 0, 300, 300);
      layered_house.setLayer(templbl, order+=1);
      layered_house.add(templbl);
    }

    /* Repaint the specified region */
    frame.repaint(areaToRepaint.x, areaToRepaint.y, areaToRepaint.width, areaToRepaint.height);
  }
}
