package com.example.horlistview;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.lang.ref.WeakReference;
import java.util.List;
public class MoviesAdapter extends RecyclerView.Adapter<MoviesAdapter.MyViewHolder> {
    private List<MovieModel> moviesList;
    private final ClickListener clickListener;

    public MoviesAdapter(List<MovieModel> moviesList,ClickListener clickListener) {
        this.moviesList = moviesList;
        this.clickListener = clickListener;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.movies_list, parent, false);
        return new MyViewHolder(itemView,clickListener);
    }
    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        MovieModel movie = moviesList.get(position);
        holder.title.setText(movie.getTitle());
        holder.genre.setText(movie.getGenre());
        holder.year.setText(movie.getYear());
    }
    @Override
    public int getItemCount() {
        return moviesList.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        TextView title, year, genre;
        Button button;
        private WeakReference<ClickListener> listenerRef;

        MyViewHolder(View view,ClickListener clickListener) {
            super(view);
            listenerRef = new WeakReference<>(clickListener);
            title = view.findViewById(R.id.title);
            genre = view.findViewById(R.id.genre);
            year = view.findViewById(R.id.year);
            button = view.findViewById(R.id.button);
            button.setOnClickListener(this);
        }
        @Override
        public void onClick(View v) {
            if(v.getId() == button.getId()){
                Toast.makeText(v.getContext(), "heyyyyyyy", Toast.LENGTH_SHORT).show();
            }
            listenerRef.get().onPositionClicked(getAdapterPosition());
        }
    }
}