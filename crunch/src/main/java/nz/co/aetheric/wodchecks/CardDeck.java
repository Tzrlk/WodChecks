package nz.co.aetheric.wodchecks;

import java.util.Date;
import java.util.Random;

public class CardDeck {
    private byte[] deck;
    private int wins;
    private int redraws;
    private int again;
    private int pool;
    private int cycles;
    private boolean rote;
    private String serial;

    public CardDeck() {
        this(1, 5, 10, false);
    }

    public CardDeck(int cycles, int pool, int again, boolean rote) {
        this.deck = new byte[40];
        for (byte suit = 0; suit < 4; suit++)
            for (byte card = 1; card <= 10; card++)
                this.deck[(suit * 10 + card - 1)] = card;
        this.wins = this.redraws = 0;
        this.cycles = cycles;
        this.pool = pool;
        this.again = again;
        this.rote = rote;
    }

    // public functions

    public int draw() {
        this.serial = "";
        if (this.pool < 1)
            return drawChance();
        this.wins = this.redraws = 0;
        for (int cycle = 0; cycle < this.cycles; cycle++) {
            shuffle();
            for (int i = 0; i < this.pool; i++)
                drawResult(this.deck[i], true);
            this.serial += " ";
        }
        shuffle();
        if (this.cycles < 1)
            this.redraws += this.pool;
        int i = 0;
        while (this.redraws-- > 0)
            drawResult(this.deck[(i++)], false);
        return this.wins;
    }

    public void shuffle() {
        for (int i = 40; i > 0; i--)
            swap(i - 1, randInt(i));
    }

    public byte drawChance() {
        int draw = randInt(10) + 1;
        this.serial = (draw + "");
        switch (draw) {
            case 1:
                return -1;
            case 10:
                return 1;
            default:
                return 0;
        }
    }

    // private functions

    private void swap(int a, int b) {
        byte temp = this.deck[a];
        this.deck[a] = this.deck[b];
        this.deck[b] = temp;
    }

    private void drawResult(int draw, boolean cycle) {
        this.serial += (draw == 10 ? 0 : draw);
        if (draw > 7) {
            this.wins += 1;
            if (draw >= this.again)
                this.redraws += 1;
        } else if ((cycle) && (this.rote)) {
            this.redraws += 1;
        }
    }

    private byte randInt(int max) {
        return (byte) new Random(new Date().getTime()).nextInt(max);
    }

    // getters

    public int getAgain() {
        return this.again;
    }

    public int getPool() {
        return this.pool;
    }

    public boolean getRote() {
        return this.rote;
    }

    public int getCycles() {
        return this.cycles;
    }

    public String getSerial() {
        return this.serial;
    }

    // setters

    public void setAll(int cycles, int pool, int again, boolean rote) {
        this.setCycles(cycles);
        this.setPool(pool);
        this.setAgain(again);
        this.setRote(rote);
    }

    public void setAgain(int value) {
        if ((7 < value) && (value < 11))
            this.again = value;
    }

    public void setPool(int value) {
        if (value < 41)
            this.pool = value;
    }

    public void setRote(boolean value) {
        this.rote = value;
    }

    public void setCycles(int value) {
        this.cycles = value;
    }
}