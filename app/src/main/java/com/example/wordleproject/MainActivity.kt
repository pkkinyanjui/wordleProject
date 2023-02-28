package com.example.wordleproject

import androidx.appcompat.app.AppCompatActivity
import android.widget.Button
import android.widget.Toast
import android.widget.TextView
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.EditText
import androidx.core.view.isVisible
import com.example.wordleproject.FourLetterWordList.getRandomFourLetterWord
import org.w3c.dom.Text


class MainActivity : AppCompatActivity() {
    val wordToGuess = getRandomFourLetterWord()

    var counter = 0
    private fun checkGuess(guess: String) : String {
        var result = ""
        for (i in 0..3) {
            if (guess[i] == wordToGuess[i]) {
                result += "O"
            }
            else if (guess[i] in wordToGuess) {
                result += "+"
            }
            else {
                result += "X"
            }
        }
        return result
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val button = findViewById<Button>(R.id.submitWord)
        Log.i("THE WORD IS", wordToGuess)

            button.setOnClickListener() {

                if(counter == 0) {
                    var input = findViewById<EditText>(R.id.editText)
                    var wordGuessed = input.text
                    var output = findViewById<TextView>(R.id.guessReturn1)

                    output.text = wordGuessed
                    output.visibility = View.VISIBLE

                    var hint = checkGuess(wordGuessed.toString().uppercase())
                    var hintText = findViewById<TextView>(R.id.guessHint1)
                    hintText.text = hint
                    hintText.visibility = View.VISIBLE

                }


                else if(counter == 1) {
                    var input = findViewById<EditText>(R.id.editText)
                    var wordGuessed = input.text
                    var output = findViewById<TextView>(R.id.guessReturn2)
                    var text = findViewById<TextView>(R.id.guess1)
                    var text2 = findViewById<TextView>(R.id.check1)
                    output.text = wordGuessed
                    output.visibility = View.VISIBLE
                    text.visibility = View.VISIBLE
                    text2.visibility = View.VISIBLE

                    var hint = checkGuess(wordGuessed.toString().uppercase())
                    var hintText = findViewById<TextView>(R.id.guessHint2)
                    hintText.text = hint
                    hintText.visibility = View.VISIBLE

                    if(wordGuessed.toString() == wordToGuess){

                        Toast.makeText(it.context, "YOU WIN!", Toast.LENGTH_SHORT).show()
                        counter = 5;
                    }

                }


                else if(counter == 2) {
                    var input = findViewById<EditText>(R.id.editText)
                    var wordGuessed = input.text
                    var output = findViewById<TextView>(R.id.guessReturn3)
                    var text = findViewById<TextView>(R.id.guess2)
                    var text2 = findViewById<TextView>(R.id.check2)
                    output.text = wordGuessed
                    output.visibility = View.VISIBLE
                    text.visibility = View.VISIBLE
                    text2.visibility = View.VISIBLE


                    var hint = checkGuess(wordGuessed.toString().uppercase())
                    var hintText = findViewById<TextView>(R.id.guessHint3)
                    hintText.text = hint
                    hintText.visibility = View.VISIBLE

                    if(wordGuessed.toString() == wordToGuess){

                        Toast.makeText(it.context, "YOU WIN!", Toast.LENGTH_SHORT).show()
                        counter = 5;
                    }



                }

                if(counter == 3){
                    Toast.makeText(it.context, "Guesses Exceeded!", Toast.LENGTH_SHORT).show()
                    var finalView = findViewById<TextView>(R.id.Final)
                    finalView.text = wordToGuess.toString()

                }
                counter+=1;
                }

            // end of button
            }


    }
