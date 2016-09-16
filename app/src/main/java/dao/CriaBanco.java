package dao;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import util.AnimalConstants;
import util.VacinaConstants;

/**
 * Created by Virginia Farias on 12/09/2016.
 */
public class CriaBanco extends SQLiteOpenHelper {

    public static final String NOME_BANCO = "petfy.db";
    public static final int VERSAO = 1;

    public CriaBanco(Context context) {
        super(context, NOME_BANCO, null, VERSAO);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(AnimalConstants.ANIMAL_TABLE_CREATE);
        db.execSQL(VacinaConstants.VACINA_TABLE_CREATE);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
