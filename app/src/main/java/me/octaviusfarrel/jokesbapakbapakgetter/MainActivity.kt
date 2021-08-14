package me.octaviusfarrel.jokesbapakbapakgetter

import android.content.Intent
import android.graphics.Bitmap
import android.os.AsyncTask
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.telecom.Call
import android.widget.Button
import android.widget.ImageView
import android.widget.Toast
import com.squareup.picasso.MemoryPolicy
import com.squareup.picasso.Picasso
import com.squareup.picasso.RequestCreator
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import java.util.concurrent.Callable

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportActionBar?.title = "Jokes Bapak Bapak Getter"
        getJokes()
        val button:Button = findViewById(R.id.get_jokes)
        button.setOnClickListener {
            Toast.makeText(this, "Fetching jokes...", Toast.LENGTH_SHORT).show()
            getJokes()
            Toast.makeText(this, "Jokes Successfully fetched", Toast.LENGTH_SHORT).show()
        }
    }

    private fun getJokes() {
        val display:ImageView = findViewById(R.id.display_jokes)
        Picasso
            .get()
            .load("https://jokesbapak2.herokuapp.com/v1")
            .memoryPolicy(MemoryPolicy.NO_CACHE)
            .memoryPolicy(MemoryPolicy.NO_STORE)
            .resize(250, 250)
            .centerCrop()
            .into(display)
    }
}
