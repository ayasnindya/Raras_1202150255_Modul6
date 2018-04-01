package id.ac.telkomuniversity.student.ayasnindya.raras_1202150255_modul6;

import android.app.Fragment;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.nfc.Tag;
import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TabLayout;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;

import com.google.firebase.auth.FirebaseAuth;

import java.util.ArrayList;
import java.util.List;

public class Home extends AppCompatActivity {
    FloatingActionButton fab;
    ViewPager viewPager;
    TabLayout tabLayout;
    FirebaseAuth auth;
    AppBarLayout abl;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        viewPager = (ViewPager) findViewById(R.id.viewPager);
        tabLayout = (TabLayout) findViewById(R.id.tabs);
        fab = (FloatingActionButton) findViewById(R.id.fab);
        abl = (AppBarLayout) findViewById(R.id.appbar);
        auth = FirebaseAuth.getInstance();

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Intent dari PopotoanHome ke PostFOto
                Intent intent = new Intent(Home.this, PostFoto.class);
                startActivity(intent);
            }
        });

        //SetupPager ViewPager
        setupPager(viewPager);

        //setupWithViewPager si ViewPager pada tab
        tabLayout.setupWithViewPager(viewPager);
        //set tulisan pada tab
        tabLayout.getTabAt(0).setText("TERBARU");
        tabLayout.getTabAt(1).setText("POTO SAYA");
        tabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                //getPosition()==0 untuk tab terbaru lalu set warna background
                if (tab.getPosition() == 0) {
                    abl.setBackgroundColor(getResources().getColor(R.color.colorPrimary));
                } else {
                    abl.setBackgroundColor(getResources().getColor(R.color.colorPrimaryDark));
                }
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_main, menu);
        return true;
    }

    //Method ketika menu logout dipilih
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        //getItemId() dari item dengan action_settings pada Menu
        if (item.getItemId() == R.id.action_settings) {
            //FirebaseAuth.getInstance() untuk signOut()
            auth.signOut();
            //Intent dari Home ke Login
            startActivity(new Intent(Home.this, MainActivity.class));
            //finish
            finish();
        }
        //mengembalikan nilai boolean true
        return true;
    }

    //Menetapkan adapter untuk viewpager
    public void setupPager(ViewPager v) {
        VPAdapter adapter = new VPAdapter(getSupportFragmentManager());
        //menambah fragment pada adapter
        adapter.addFragment(new Terbaru(), "TERBARU");
        adapter.addFragment(new FotoSaya(), "SAYA");

        //setAdapter ViewPager pada adapter
        v.setAdapter(adapter);
    }

    //Subclass sebagai adapter untuk Viewpager dengan fragmentnya
    class VPAdapter extends FragmentPagerAdapter {
        //deklarasi nama variable ArrayList<> baru dengan fragment
        private final List<android.support.v4.app.Fragment> listfragment = new ArrayList<>();
        //deklarasi nama variable ArrayList<> baru dengan String
        private final List<String> listfragmenttitle = new ArrayList<>();

        public VPAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public android.support.v4.app.Fragment getItem(int position) {
            //mengembalikan get(position) pada listfragment
            return listfragment.get(position);
        }

        public void addFragment(android.support.v4.app.Fragment f, String title) {
            //Menambahkan fragment dan title
            listfragment.add(f);
            listfragmenttitle.add(title);
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return null;
        }

        @Override
        public int getCount() {
            //mengembalikan ukuran listfragment
            return listfragment.size();
        }
    }
}