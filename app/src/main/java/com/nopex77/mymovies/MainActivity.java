package com.nopex77.mymovies;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private RecyclerView rvFilm;
    private ArrayList<Film_class> list = new ArrayList<>();
    private String title = "Mode List";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setActionBarTitle(title);

        rvFilm = findViewById(R.id.rv_film);
        rvFilm.setHasFixedSize(true);

        list.addAll(FilmData_class.getListData());
        showRecyclerList();
    }

    private void showRecyclerList() {
        rvFilm.setLayoutManager(new LinearLayoutManager(this));
        ListFilmAdapter_class listFilmAdapter_class = new ListFilmAdapter_class(list);
        rvFilm.setAdapter(listFilmAdapter_class);
        listFilmAdapter_class.setOnItemClickCallback(new ListFilmAdapter_class.OnItemClickCallback() {
            @Override
            public void onItemClicked(Film_class data) {
                showSelectedHero(data);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        setMode(item.getItemId());
        return super.onOptionsItemSelected(item);
    }

    public void setMode(int selectedMode) {
        switch (selectedMode) {
            case R.id.action_list:
                title = "Mode List";
                showRecyclerList();
                break;

            case R.id.action_grid:
                title = "Mode Grid";
                showRecyclerGrid();
                break;

            case R.id.action_cardview:
                title = "Mode CardView";
                showRecyclerCardView();
                break;
        }
        setActionBarTitle(title);
    }

    private void showRecyclerGrid() {
        rvFilm.setLayoutManager(new GridLayoutManager(this, 2));
        GridFilmAdapter_class gridFilmAdapter = new GridFilmAdapter_class(list);
        rvFilm.setAdapter(gridFilmAdapter);
        gridFilmAdapter.setOnItemClickCallback(new GridFilmAdapter_class.OnItemClickCallback() {
            @Override
            public void onItemClicked(Film_class data) {
                showSelectedHero(data);
            }
        });

    }

    private void showRecyclerCardView(){
        rvFilm.setLayoutManager(new LinearLayoutManager(this));
        CardviewFilmAdapter_class cardViewHeroAdapter = new CardviewFilmAdapter_class(list);
        rvFilm.setAdapter(cardViewHeroAdapter);
    }

    private void setActionBarTitle(String title) {
        if (getSupportActionBar() != null) {
            getSupportActionBar().setTitle(title);
        }
    }

    private void showSelectedHero(Film_class film) {
        Toast.makeText(this, "Kamu memilih " + film.getNama(), Toast.LENGTH_SHORT).show();
    }
}