package com.example.android.tourguideapp;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private int[] icImageId = {
            R.drawable.map,
            R.drawable.camera,
            R.drawable.coffee,
            R.drawable.balloon,
            R.drawable.bed};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        //Dummy Data
        if (!City.isInitialized()) {

            Place placeToSee1 = new Place(getString(R.string.place_to_see_1_name), getString(R.string.city_description), 1, 42.870631, -8.527591, R.drawable.ciudad_cultura, R.drawable.ciudad_cultura_full);
            Place placeToSee2 = new Place(getString(R.string.place_to_see_2_name), getString(R.string.city_description), 1, 42.880637, -8.544537, R.drawable.catedral, R.drawable.catedral_full);
            Place placeToSee3 = new Place(getString(R.string.place_to_see_3_name), getString(R.string.city_description), 1, 42.876896, -8.536468, R.drawable.pinario, R.drawable.pinario_full);
            Place placeToSee5 = new Place(getString(R.string.place_to_see_4_name), getString(R.string.city_description), 1, 42.871914, -8.537217, R.drawable.colegiata_sar, R.drawable.colegiata_sar_full);
            Place placeToSee4 = new Place(getString(R.string.place_to_see_5_name), getString(R.string.city_description), 1, 42.878811, -8.542218, R.drawable.facultad_historia, R.drawable.facultad_historia_full);

            Place placeToEat1 = new Place(getString(R.string.place_to_eat_1_name), getString(R.string.city_description), 2, 42.881805, -8.546817, R.drawable.marcelo, R.drawable.marcelo_full);
            Place placeToEat2 = new Place(getString(R.string.place_to_eat_2_name), getString(R.string.city_description), 2, 42.881022, -8.540229, R.drawable.tafona, R.drawable.tafona_full);
            Place placeToEat4 = new Place(getString(R.string.place_to_eat_3_name), getString(R.string.city_description), 2, 42.882673, -8.535542, R.drawable.maceta, R.drawable.maceta_full);
            Place placeToEat5 = new Place(getString(R.string.place_to_eat_4_name), getString(R.string.city_description), 2, 42.883581, -8.539484, R.drawable.markesa, R.drawable.markesa_full);
            Place placeToEat3 = new Place(getString(R.string.place_to_eat_5_name), getString(R.string.city_description), 2, 42.882177, -8.541470, R.drawable.curro_parra, R.drawable.curro_da_parra_full);

            Place placeToDo1 = new Place(getString(R.string.place_to_do_1_name), getString(R.string.city_description), 3, 42.883117, -8.539665, R.drawable.cgac, R.drawable.cgac_full);
            Place placeToDo2 = new Place(getString(R.string.place_to_do_2_name), getString(R.string.city_description), 3, 42.877681, -8.544904, R.drawable.eugenio_granell, R.drawable.eugenio_granell_full);
            Place placeToDo3 = new Place(getString(R.string.place_to_do_3_name), getString(R.string.city_description), 3, 42.881438, -8.543306, R.drawable.pobo_galego, R.drawable.pobo_galego_full);
            Place placeToDo5 = new Place(getString(R.string.place_to_do_4_name), getString(R.string.city_description), 3, 42.882188, -8.539069, R.drawable.zona_c, R.drawable.zona_c_full);
            Place placeToDo4 = new Place(getString(R.string.place_to_do_5_name), getString(R.string.city_description), 3, 42.880053, -8.542221, R.drawable.riquela, R.drawable.riquela_full);

            Place placeToSleep1 = new Place(getString(R.string.place_to_sleep_1_name), getString(R.string.city_description), 4, 42.883141, -8.543356, R.drawable.costavella, R.drawable.costavella_full);
            Place placeToSleep2 = new Place(getString(R.string.place_to_sleep_2_name), getString(R.string.city_description), 4, 42.876187, -8.548923, R.drawable.herradura, R.drawable.herradura_full);
            Place placeToSleep3 = new Place(getString(R.string.place_to_sleep_3_name), getString(R.string.city_description), 4, 42.883655, -8.542866, R.drawable.moure, R.drawable.moure_full);
            Place placeToSleep4 = new Place(getString(R.string.place_to_sleep_4_name), getString(R.string.city_description), 4, 42.879498, -8.544314, R.drawable.rua_vilar, R.drawable.rua_vilar_full);
            Place placeToSleep5 = new Place(getString(R.string.place_to_sleep_5_name), getString(R.string.city_description), 4, 42.881485, -8.545869, R.drawable.reis_catolicos, R.drawable.reis_catolicos_full);


            City.setInitialized(true);
        }

        ViewPager cityCategoriesPager = findViewById(R.id.city_categories_pager);

        CategoryAdapter categoryAdapter = new CategoryAdapter(getSupportFragmentManager());

        cityCategoriesPager.setAdapter(categoryAdapter);

        // Give the TabLayout the ViewPager
        TabLayout tabLayout = findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(cityCategoriesPager);


        for (int i = 0; i < icImageId.length; i++) {
            tabLayout.getTabAt(i).setIcon(icImageId[i]);
        }
    }
}
