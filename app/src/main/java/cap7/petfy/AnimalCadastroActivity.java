package cap7.petfy;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import java.util.List;

import controller.AnimalController;
import model.Animal;

public class AnimalCadastroActivity extends AppCompatActivity {

    private EditText nome;
    private EditText nascimento;
    private RadioGroup sexo;
    private RadioGroup especie;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animal_cadastro);

        nome = (EditText) findViewById(R.id.edit_animal_nome);
        nascimento = (EditText) findViewById(R.id.edit_animal_nasc);
        sexo = (RadioGroup) findViewById(R.id.rd_animal_sexo);
        especie = (RadioGroup) findViewById(R.id.rd_animal_especie);

        Button btnSalvar = (Button) findViewById(R.id.btn_animal_salvar);

    }

    public void onSalvar(View view) {
        AnimalController animalController = new AnimalController(getBaseContext());
        int sexoSelectedId = sexo.getCheckedRadioButtonId();
        int especieSelectedId = especie.getCheckedRadioButtonId();
        Button sexoButton = (Button) findViewById(sexoSelectedId);
        Button especieButton = (Button) findViewById(especieSelectedId);

        Animal animal = new Animal();
        animal.setNome(nome.getText().toString());
        animal.setNascimento(nascimento.getText().toString());
        animal.setSexo(sexoButton.getText().toString());
        animal.setEspecie(especieButton.getText().toString());

        boolean resultado = animalController.cadastrar(animal);

        List<Animal> animais = animalController.getAll();

        String msg = resultado ? "Animal cadastrado com sucesso" : "Erro ao cadastrar animal";

        Toast toast = Toast.makeText(getApplicationContext(), msg, Toast.LENGTH_SHORT);
        toast.show();
    }

}
