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

            Place placeToSee1 = new Place("Cidade Da Cultura", "Short Description", 1, 42.870631, -8.527591, R.drawable.ciudad_cultura);
            Place placeToSee2 = new Place("Catedral", "Short Description", 1, 42.880637, -8.544537, R.drawable.catedral);
            Place placeToSee3 = new Place("San Martín Pinario", "Short Description", 1, 42.876896, -8.536468, R.drawable.pinario);
            Place placeToSee5 = new Place("Colegiata de Sar", "Short Description", 1, 42.871914, -8.537217, R.drawable.colegiata_sar);
            Place placeToSee4 = new Place("Facultade de Xeografía e Historia", "Short Description", 1, 42.878811, -8.542218, R.drawable.facultad_historia);

            Place placeToEat1 = new Place("Casa Marcelo", "Short Description", 2, 42.881805, -8.546817, R.drawable.marcelo);
            Place placeToEat2 = new Place("La Tafona", "Short Description", 2, 42.881022, -8.540229, R.drawable.tafona);
            Place placeToEat4 = new Place("A Maceta", "Short Description", 2, 42.882673, -8.535542, R.drawable.maceta);
            Place placeToEat5 = new Place("Izakaya Markesa", "Short Description", 2, 42.883581, -8.539484, R.drawable.markesa);
            Place placeToEat3 = new Place("O Curro Da Parra", "Short Description", 2, 42.882177, -8.541470, R.drawable.curro_parra);

            Place placeToDo1 = new Place("CGAC ", "Short Description", 3, 42.883117, -8.539665, R.drawable.cgac);
            Place placeToDo2 = new Place("Fundación Eugenio Granell ", "Short Description", 3, 42.877681, -8.544904, R.drawable.eugenio_granell);
            Place placeToDo3 = new Place("Museo do Pobo Galego", "Short Description", 3, 42.881438, -8.543306, R.drawable.pobo_galego);
            Place placeToDo5 = new Place("Zona C ", "Short Description", 3, 42.882188, -8.539069, R.drawable.zona_c);
            Place placeToDo4 = new Place("Sala Riquela", "Short Description", 3, 42.880053, -8.542221, R.drawable.riquela);

            /*Place placeToSleep1 = new Place("Hotel Costavella",4,42.883141, -8.543356);
            Place placeToSleep2 = new Place("Hotel Herradura",4,42.876187, -8.548923);
            Place placeToSleep3 = new Place("Hotel Moure",4,42.883655, -8.542866);
            Place placeToSleep4 = new Place("Hotel Rua Vilar",4,42.879498, -8.544314);
            Place placeToSleep5= new Place("Hostal de los Reyes Católicos",4,42.881485, -8.545869);*/


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
