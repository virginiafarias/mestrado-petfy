package cap7.petfy;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import controller.VacinaController;
import model.Vacina;

public class AddVacinaActivity extends AppCompatActivity {

    private EditText nome;
    private EditText data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_vacina);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        nome = (EditText) findViewById(R.id.edit_vacina_nome);
        data = (EditText) findViewById(R.id.edit_vacina_data);

    }

    public void onSalvar(View view) {
        VacinaController vacinaController = new VacinaController(getBaseContext());
        Vacina vacina = new Vacina();
        vacina.setNome(nome.getText().toString());
        vacina.setData(data.getText().toString());

        Bundle bundle = getIntent().getExtras();
        bundle.putInt("aba", 1);
        boolean resultado = vacinaController.cadastrar(vacina, bundle.getInt("animal_id"));
        Toast toast = Toast.makeText(getApplicationContext(), String.valueOf(resultado), Toast.LENGTH_SHORT);
        toast.show();
        Intent intent = new Intent(view.getContext(), AnimalDetalheActivity.class);
        intent.putExtras(bundle);
        startActivity(intent);


    }

}
