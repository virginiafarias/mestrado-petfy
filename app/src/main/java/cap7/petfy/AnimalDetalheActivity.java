package cap7.petfy;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

import adapter.ViewPagerAdapter;
import fragments.DetalhesFragment;
import fragments.MedicacaoFragment;
import fragments.VacinaFragment;
import fragments.VermifugacaoFragment;

public class AnimalDetalheActivity extends AppCompatActivity {

    private TabLayout tabLayout;
    private ViewPager viewPager;
    private ViewPagerAdapter viewPagerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animal_detalhe);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        tabLayout = (TabLayout) findViewById(R.id.tabLayout);
        viewPager = (ViewPager) findViewById(R.id.viewPager);
        viewPagerAdapter = new ViewPagerAdapter(getSupportFragmentManager());
        viewPagerAdapter.addFragments(new DetalhesFragment(), "Detalhes");
        viewPagerAdapter.addFragments(new VacinaFragment() , "Vacinação");
        viewPagerAdapter.addFragments(new MedicacaoFragment(), "Medicação");
        viewPagerAdapter.addFragments(new VermifugacaoFragment(), "Vermifugação");

        viewPager.setAdapter(viewPagerAdapter);
        tabLayout.setupWithViewPager(viewPager);


        Bundle bundle = getIntent().getExtras();
        int id = bundle.getInt("animal_id");


        TextView txt = (TextView) findViewById(R.id.textView2);
        txt.setText(String.valueOf(id));


    }

}
