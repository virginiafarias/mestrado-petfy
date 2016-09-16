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
import controller.VermifugacaoController;
import model.Vacina;
import model.Vermifugacao;

public class AddVermifugacaoActivity extends AppCompatActivity {

    private EditText nome;
    private EditText data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_vermifugacao);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        nome = (EditText) findViewById(R.id.edit_verm_nome);
        data = (EditText) findViewById(R.id.edit_verm_data);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    public void onSalvar(View view) {
        VermifugacaoController vermController = new VermifugacaoController(getBaseContext());
        Vermifugacao vermifugacao = new Vermifugacao();
        vermifugacao.setNome(nome.getText().toString());
        vermifugacao.setData(data.getText().toString());

        Bundle bundle = getIntent().getExtras();
        bundle.putInt("aba", 3);
        boolean resultado = vermController.cadastrar(vermifugacao, bundle.getInt("animal_id"));
        Intent intent = new Intent(view.getContext(), AnimalDetalheActivity.class);
        intent.putExtras(bundle);
        startActivity(intent);

    }

}
