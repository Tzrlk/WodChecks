package nz.co.aetheric.syphilis.wodcards;

import android.app.Activity;
import android.database.ContentObserver;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;
import net.technologichron.manacalc.NumberPicker;

public class WodCardsActivity extends Activity {
  private static final String PARAM_DECK_CYCLES = "deck.cycles";
  private static final String PARAM_DECK_POOL = "deck.pool";
  private static final String PARAM_DECK_AGAIN = "deck.again";
  private static final String PARAM_DECK_ROTE = "deck.rote";

  private CardDeck deck;
  private CheckBox roteCheckView;
  private NumberPicker cyclesPickerView;
  private NumberPicker againPickerView;
  private NumberPicker poolPickerView;
  private TextView drawTitleView;
  private TextView drawResultView;

  @Override protected void onCreate(Bundle state) {
    super.onCreate(state);
    this.deck = ( state == null
        ? new CardDeck(1, 5, 10, false)
        : new CardDeck(
            state.getInt(PARAM_DECK_CYCLES, 1),
            state.getInt(PARAM_DECK_POOL, 5),
            state.getInt(PARAM_DECK_AGAIN, 10),
            state.getBoolean(PARAM_DECK_ROTE, false)
        )
    );
    super.setContentView(R.layout.main);
    this.roteCheckView = (CheckBox) super.findViewById(R.id.roteCheck);
    this.cyclesPickerView = (NumberPicker) super.findViewById(R.id.cyclesPicker);
    this.againPickerView = (NumberPicker) super.findViewById(R.id.againPicker);
    this.poolPickerView = (NumberPicker) super.findViewById(R.id.poolPicker);
    this.drawTitleView = (TextView) super.findViewById(R.id.drawTitle);
    this.drawResultView = (TextView) super.findViewById(R.id.drawResult);

    this.roteCheckView.setOnClickListener(new View.OnClickListener() {
      @Override public void onClick(View view) {
        deck.setRote(roteCheckView.isChecked());
        updateDrawTitle(null);
      }
    });

    this.cyclesPickerView.registerObserver(new ContentObserver(this.cyclesPickerView.getHandler()) {
      @Override public void onChange(boolean selfChange) {
        super.onChange(selfChange);
        deck.setCycles(cyclesPickerView.getValue());
        updateDrawTitle(null);
      }
    });

    this.againPickerView.registerObserver(new ContentObserver(this.againPickerView.getHandler()) {
      @Override
      public void onChange(boolean selfChange) {
        super.onChange(selfChange);
        deck.setAgain(againPickerView.getValue());
        updateDrawTitle(null);
      }
    });

    this.poolPickerView.registerObserver(new ContentObserver(this.poolPickerView.getHandler()) {
      @Override public void onChange(boolean selfChange) {
        super.onChange(selfChange);
        deck.setPool(poolPickerView.getValue());
        updateDrawTitle(null);
      }
    });

    this.drawResultView.setOnClickListener(new View.OnClickListener() {
      @Override public void onClick(View view) {
        updateDrawTitle(deck.draw());
        drawResultView.setText(deck.getSerial());
      }
    });
  }

  @Override protected void onSaveInstanceState(Bundle state) {
    super.onSaveInstanceState(state);
    if(deck != null && state != null) {
      state.putInt(PARAM_DECK_CYCLES, deck.getCycles());
      state.putInt(PARAM_DECK_POOL, deck.getPool());
      state.putInt(PARAM_DECK_AGAIN, deck.getAgain());
      state.putBoolean(PARAM_DECK_ROTE, deck.getRote());
    }
  }

  @Override protected void onStop() {
    super.onStop();
    deck = null;
  }

  private void updateDrawTitle(Integer draw) {
    String titleText = String.format("Draw[p%d(%d)x%d%s]: %s. Tap below to redraw.",
        this.deck.getPool(),
        this.deck.getAgain(),
        this.deck.getCycles(),
        this.deck.getRote() ? "r" : "n",
        draw == null ? '-' : String.valueOf(draw)
    );
    drawTitleView.setText(titleText);
  }
}
