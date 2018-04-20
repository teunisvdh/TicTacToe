package com.example.teunis.tictactoe;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {
    Game game;

    // used the quick fix instead of onSaveInstanceState in the end. Only works with rotation

    // create new game
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        game = new Game();
    }

    // sets text of the tiles
    public void tileClicked(View view) {
        Button button = (Button) view;

        // used contentDescription for position instead
        int id = button.getId();

        // ContentDescription 0-8 for tiles 1-9
        CharSequence whatButton = button.getContentDescription();
        int thisButton = Integer.parseInt(whatButton.toString());

        // determine position of tile
        int[] rowList = {0,0,0,1,1,1,2,2,2};
        int[] columnList = {0,1,2,0,1,2,0,1,2};
        int row = rowList[thisButton];
        int column = columnList[thisButton];

        // use draw function on tile
        Tile tile = game.draw(row, column);

        // change text (X or O)
        switch(tile) {
            case CROSS:
                button.setText("X");
                break;
            case CIRCLE:
                button.setText("O");
                break;
            case INVALID:
                break;
        }

        // check winOrLose, if true: buttontext becomes "win"
        if (game.winOrLose()) {
            button.setText("win");
        }
    }

    // resets game when "new game" is clicked
    public void resetClicked(View view) {

        // create new game
        game = new Game();

        // reset UI to blank tiles
        Button one = findViewById(R.id.button1);
        one.setText("");
        Button two = findViewById(R.id.button2);
        two.setText("");
        Button three = findViewById(R.id.button3);
        three.setText("");
        Button four = findViewById(R.id.button4);
        four.setText("");
        Button five = findViewById(R.id.button5);
        five.setText("");
        Button six = findViewById(R.id.button6);
        six.setText("");
        Button seven = findViewById(R.id.button7);
        seven.setText("");
        Button eight = findViewById(R.id.button8);
        eight.setText("");
        Button nine = findViewById(R.id.button9);
        nine.setText("");
    }
}
