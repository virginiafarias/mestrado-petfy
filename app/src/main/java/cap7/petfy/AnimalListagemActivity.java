package cap7.petfy;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.List;

import adapter.AdapterListViewAnimal;
import controller.AnimalController;
import dao.CriaBanco;
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

        // Pega o animal selecionado a mostra os detalhes
        listViewAnimal.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Animal animal = (Animal) parent.getItemAtPosition(position);
                Intent intent = new Intent(view.getContext(), AnimalDetalheActivity.class);
                Bundle bundle = new Bundle();
                bundle.putInt("animal_id", animal.getId());
                intent.putExtras(bundle);
                startActivity(intent);
            }
        });
    }

    public void addAnimal(View view) {
        Intent intent = new Intent(view.getContext(), AnimalCadastroActivity.class);
        startActivity(intent);
    }

}
