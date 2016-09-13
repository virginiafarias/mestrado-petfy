package cap7.petfy;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ListAdapter;
import android.widget.ListView;

import java.util.List;

import adapter.AdapterListViewAnimal;
import controller.AnimalController;
import model.Animal;

public class AnimalListagemActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animal_listagem);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        AnimalController animalController = new AnimalController(getBaseContext());
        AdapterListViewAnimal adapterAnimal = new AdapterListViewAnimal(this, animalController.getAll());
        ListView listViewAnimal = (ListView) findViewById(R.id.list_animal);
        listViewAnimal.setAdapter(adapterAnimal);
    }

}
