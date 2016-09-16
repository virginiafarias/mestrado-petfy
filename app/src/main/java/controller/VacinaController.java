package controller;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

import dao.CriaBanco;
import model.Animal;
import model.Vacina;
import util.AnimalConstants;
import util.VacinaConstants;

/**
 * Created by Virginia Farias on 15/09/2016.
 */
public class VacinaController {

    private SQLiteDatabase db;
    private CriaBanco banco;

    public VacinaController(Context context) {
        banco = new CriaBanco(context);
    }

    public boolean cadastrar(Vacina vacina, int idAnimal) {
        db = banco.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(VacinaConstants.VACINA_NOME, vacina.getNome());
        values.put(VacinaConstants.VACINA_DATA, vacina.getData());
        values.put(VacinaConstants.VACINA_VACINADO, 0);
        values.put(VacinaConstants.VACINA_ANIMAL_ID, idAnimal);

        long resultado = db.insert(VacinaConstants.VACINA_TABELA, null, values);
        db.close();

        return resultado != -1;

    }

    public List<Vacina> getByAnimalId(int id) {
        db = banco.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM " + VacinaConstants.VACINA_TABELA + " WHERE "
                + VacinaConstants.VACINA_ANIMAL_ID + " = " + id, null);

        List<Vacina> vacinas = new ArrayList<Vacina>();
        if(cursor.moveToFirst()) {
            do {
                Vacina vacina = new Vacina();
                vacina.setId(cursor.getInt(cursor.getColumnIndex(VacinaConstants.VACINA_ID)));
                vacina.setNome(cursor.getString(cursor.getColumnIndex(VacinaConstants.VACINA_NOME)));
                vacina.setData(cursor.getString(cursor.getColumnIndex(VacinaConstants.VACINA_DATA)));
                int vacinado = cursor.getInt(cursor.getColumnIndex(VacinaConstants.VACINA_VACINADO));
                vacina.setVacinado(vacinado == 0 ? false : true);
                vacinas.add(vacina);

            } while (cursor.moveToNext());
        }

        if(cursor != null && !cursor.isClosed()) {
            cursor.close();
        }

        return vacinas;
    }
}
