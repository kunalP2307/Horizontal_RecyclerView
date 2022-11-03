package com.example.horlistview;

import static android.content.ContentValues.TAG;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;
public class MainActivity extends AppCompatActivity {

    private List<MovieModel> movieList = new ArrayList<>();
    private MoviesAdapter mAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        mAdapter = new MoviesAdapter(movieList, new ClickListener() {
            @Override
            public void onPositionClicked(int position) {
                Toast.makeText(MainActivity.this, "jsgfjdgs", Toast.LENGTH_SHORT).show();
                Log.d(TAG, "onPositionClicked: "+position);
            }
        });
        LinearLayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        mLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(mAdapter);
        prepareMovieData();
    }
    private void prepareMovieData() {
        MovieModel movie = new MovieModel("Mad Max: Fury Road", "Action & Adventure", "2015");
        movieList.add(movie);
        movie = new MovieModel("Inside Out", "Animation, Kids & Family", "2015");
        movieList.add(movie);
        movie = new MovieModel("Star Wars: Episode VII - The Force Awakens", "Action", "2015");
        movieList.add(movie);
        movie = new MovieModel("Shaun the Sheep", "Animation", "2015");
        movieList.add(movie);
        movie = new MovieModel("The Martian", "Science Fiction & Fantasy", "2015");
        movieList.add(movie);
        movie = new MovieModel("Mission: Impossible Rogue Nation", "Action", "2015");
        movieList.add(movie);
        movie = new MovieModel("Up", "Animation", "2009");
        movieList.add(movie);
        movie = new MovieModel("Star Trek", "Science Fiction", "2009");
        movieList.add(movie);
        movie = new MovieModel("The LEGO MovieModel", "Animation", "2014");
        movieList.add(movie);
        movie = new MovieModel("Iron Man", "Action & Adventure", "2008");
        movieList.add(movie);
        movie = new MovieModel("Aliens", "Science Fiction", "1986");
        movieList.add(movie);
        movie = new MovieModel("Chicken Run", "Animation", "2000");
        movieList.add(movie);
        movie = new MovieModel("Back to the Future", "Science Fiction", "1985");
        movieList.add(movie);
        movie = new MovieModel("Raiders of the Lost Ark", "Action & Adventure", "1981");
        movieList.add(movie);
        movie = new MovieModel("Goldfinger", "Action & Adventure", "1965");
        movieList.add(movie);
        movie = new MovieModel("Guardians of the Galaxy", "Science Fiction & Fantasy", "2014");
        movieList.add(movie);
        mAdapter.notifyDataSetChanged();
    }
}
