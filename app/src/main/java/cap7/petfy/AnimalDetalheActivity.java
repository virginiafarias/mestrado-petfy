package cap7.petfy;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
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

        Bundle bundle = getIntent().getExtras();

        tabLayout = (TabLayout) findViewById(R.id.tabLayout);
        viewPager = (ViewPager) findViewById(R.id.viewPager);
        viewPagerAdapter = new ViewPagerAdapter(getSupportFragmentManager());
        Fragment detalhes = new DetalhesFragment();
        detalhes.setArguments(bundle);
        Fragment vacinacao = new VacinaFragment();
        vacinacao.setArguments(bundle);
        Fragment medicacao = new MedicacaoFragment();
        medicacao.setArguments(bundle);
        Fragment vermifugacao = new VermifugacaoFragment();
        vermifugacao.setArguments(bundle);
        viewPagerAdapter.addFragments(detalhes, "Detalhes");
        viewPagerAdapter.addFragments(vacinacao, "Vacinação");
        viewPagerAdapter.addFragments(medicacao, "Medicação");
        viewPagerAdapter.addFragments(vermifugacao, "Vermifugação");

        viewPager.setAdapter(viewPagerAdapter);
        viewPager.setCurrentItem(bundle.getInt("aba"));
        tabLayout.setupWithViewPager(viewPager);

    }

}
