/*
package nz.co.aetheric.syphilis.wodcards;

import javax.microedition.lcdui.Alert;
import javax.microedition.lcdui.Command;
import javax.microedition.lcdui.CommandListener;
import javax.microedition.lcdui.Display;
import javax.microedition.lcdui.Displayable;
import javax.microedition.lcdui.Form;
import javax.microedition.lcdui.Gauge;
import javax.microedition.lcdui.Item;
import javax.microedition.lcdui.ItemStateListener;
import javax.microedition.lcdui.StringItem;
import javax.microedition.midlet.MIDlet;

public class CardFace extends MIDlet
    implements CommandListener, ItemStateListener {
  private boolean midletPaused = false;
  private CardShuffle deck;
  private Form drawForm;
  private Form optiForm;
  private StringItem resultText;
  private StringItem optionText1;
  private StringItem optionText2;
  private Gauge poolGauge;
  private Gauge xagainGauge;
  private Gauge cycleGauge;
  private Gauge roteGauge;
  private Command drawCommand;
  private Command exitCommand;
  private Command backCommand;
  private Command optiCommand;

  private void initialize() {
    this.deck = new CardShuffle();

    this.drawCommand = new Command("Draw", 4, 0);
    this.optiCommand = new Command("Options", 2, 0);
    this.exitCommand = new Command("Exit", 7, 0);
    this.backCommand = new Command("Back", 2, 0);

    this.poolGauge = new Gauge("Draw Pool", true, 20, 5);

    this.optionText1 = new StringItem("Options: ", "p5(10)x1n", 0);
    this.resultText = new StringItem("Result ", "", 0);
    this.drawForm = new Form("CardDeck", new Item[] {
        this.poolGauge,
        this.optionText1,
        this.resultText
    });

    this.drawForm.addCommand(this.optiCommand);
    this.drawForm.addCommand(this.drawCommand);
    this.drawForm.setCommandListener(this);
    this.drawForm.setItemStateListener(this);

    this.optionText2 = new StringItem("Options: ", "p5(10)x1n", 0);
    this.xagainGauge = new Gauge("X-again", true, 2, 2);
    this.cycleGauge = new Gauge("Cycles", true, 2, 1);
    this.roteGauge = new Gauge("Rote action", true, 1, 0);
    this.optiForm = new Form("Options", new Item[] {
        this.optionText2,
        this.xagainGauge,
        this.cycleGauge,
        this.roteGauge
    });

    this.optiForm.addCommand(this.backCommand);
    this.optiForm.addCommand(this.exitCommand);
    this.optiForm.setCommandListener(this);
    this.optiForm.setItemStateListener(this);
  }

  public void startMIDlet() {
    switchDisplayable(null, this.drawForm);
  }

  public void resumeMIDlet() {
    switchDisplayable(null, this.drawForm);
  }

  public void switchDisplayable(Alert alert, Displayable nextDisplayable) {
    Display display = getDisplay();
    if(alert == null)
      display.setCurrent(nextDisplayable);
    else
      display.setCurrent(alert, nextDisplayable);
  }

  public void commandAction(Command command, Displayable displayable) {
    if(displayable == this.drawForm) {
      if(command == this.optiCommand)
        getDisplay().setCurrent(this.optiForm);
      else if(command == this.drawCommand)
        this.resultText.setText(this.deck.draw() + "\n" + this.deck.getSerial());
    } else if(displayable == this.optiForm)
      if(command == this.exitCommand)
        exitMIDlet();
      else if(command == this.backCommand)
        getDisplay().setCurrent(this.drawForm);
  }

  public void itemStateChanged(Item item) {
    if(item == this.poolGauge) {
      this.deck.setPool(this.poolGauge.getValue());
    } else if(item == this.xagainGauge) {
      switch(this.xagainGauge.getValue()) {
        case 0:
          this.deck.setAgain(8);
          break;
        case 1:
          this.deck.setAgain(9);
          break;
        case 2:
          this.deck.setAgain(10);
      }
    } else if(item == this.roteGauge) {
      switch(this.roteGauge.getValue()) {
        case 0:
          this.deck.setRote(false);
          break;
        case 1:
          this.deck.setRote(true);
      }
    } else if(item == this.cycleGauge) {
      switch(this.cycleGauge.getValue()) {
        case 0:
          this.deck.setCycles(0);
          break;
        case 1:
          this.deck.setCycles(1);
          break;
        case 2:
          this.deck.setCycles(2);
      }
    }
    String text = "p" + this.deck.getPool() + "(" + this.deck.getAgain() + ")" + "x" + this.deck.getCycles()
        + (this.deck.getRote() ? "r" : "n");

    this.optionText1.setText(text);
    this.optionText2.setText(text);
    this.resultText.setText("");

    this.deck.shuffle();
  }

  public Display getDisplay() {
    return Display.getDisplay(this);
  }

  public void pauseApp() {
    this.midletPaused = true;
  }

  public void destroyApp(boolean unconditional) {
  }

  public void exitMIDlet() {
    switchDisplayable(null, null);
    destroyApp(true);
    notifyDestroyed();
  }

  public void startApp() {
    if(this.midletPaused) {
      resumeMIDlet();
    } else {
      initialize();
      startMIDlet();
    }
    this.midletPaused = false;
  }
}
*/
