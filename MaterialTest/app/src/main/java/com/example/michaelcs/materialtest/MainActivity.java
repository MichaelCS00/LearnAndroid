package com.example.michaelcs.materialtest;

import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.nio.file.DirectoryIteratorException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;


public class MainActivity extends AppCompatActivity {
    private Book[] books = {
            new Book("CONGRATSGRADUATES", R.drawable.congratsgraduates),
            new Book("DIFICULTY", R.drawable.dificulty),
            new Book("JAPANESECOOKING", R.drawable.japanesecooking),
            new Book("NEWSCIENCE", R.drawable.newscience),
            new Book("SCIENCFICTION", R.drawable.sciencfiction),
            new Book("TEALMODERN", R.drawable.tealmodern),
            new Book("THE", R.drawable.the),
            new Book("VALEN", R.drawable.valen),
            new Book("WEARELOVELY", R.drawable.wearelovely)
    };
    private Book[] fruits = {
            new Book("Apple", R.drawable.apple),
            new Book("Banana", R.drawable.banana),
            new Book("Orange", R.drawable.orange),
            new Book("Watermelon", R.drawable.watermelon),
            new Book("Pear", R.drawable.pear),
            new Book("Grape", R.drawable.grape),
            new Book("Pineapple", R.drawable.pineapple),
            new Book("Strawberry", R.drawable.strawberry),
            new Book("Cherry", R.drawable.cherry),
            new Book("Mango", R.drawable.mango)};

    private DrawerLayout mDrawerLayout;

    private List<Book> bookList = new ArrayList<>();

    private BookAdapter adapter;

    private SwipeRefreshLayout swipeRefresh;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);

        //将自定义toolbar设定为Actionbar
        setSupportActionBar(toolbar);
        mDrawerLayout = findViewById(R.id.drawer_layout);
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
            actionBar.setHomeAsUpIndicator(R.drawable.menu_off);
        }
        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setCheckedItem(R.id.nav_call);
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                mDrawerLayout.closeDrawers();
                return true;
            }
        });

        //给FloatActionButton绑定事件“显示Snackbar”
        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Snackbar.make(v, "Data deleted", Snackbar.LENGTH_SHORT)
                        .setAction("Undo", new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                Toast.makeText(MainActivity.this, "Data restored",
                                        Toast.LENGTH_SHORT).show();
                            }
                        }).show();
            }
        });

        //初始化Books数据
        initBooks();

        //给布局RecycleView设定布局管理器和Adapter
        RecyclerView recyclerView = findViewById(R.id.recycler_view);
        GridLayoutManager layoutManager = new GridLayoutManager(this, 2);
        recyclerView.setLayoutManager(layoutManager);
        adapter = new BookAdapter(bookList);
        recyclerView.setAdapter(adapter);

        //下拉刷新
        swipeRefresh = findViewById(R.id.swipe_refresh);
        swipeRefresh.setColorSchemeResources(R.color.colorAccent);
        swipeRefresh.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                refreshBooks();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.toobar, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                mDrawerLayout.openDrawer(GravityCompat.START);
                break;
            case R.id.backup:
                Toast.makeText(this, "You clicked Backup", Toast.LENGTH_SHORT).show();
                break;
            case R.id.delete:
                Toast.makeText(this, "You clicked Delete", Toast.LENGTH_SHORT).show();
                break;
            case R.id.settings:
                Toast.makeText(this, "You clicked Settings", Toast.LENGTH_SHORT).show();
                break;
            default:
                break;
        }
        return true;
    }

    //初始化books数据,随机生成50个数的数组，对应ID生成随机图片
    private void initBooks() {
        bookList.clear();
        for (int i = 0; i < 50; i++) {
            Random random = new Random();
            int index = random.nextInt(books.length);
            bookList.add(books[index]);
        }
    }

    //定义下拉刷新操作
    private void refreshBooks(){
        new Thread(new Runnable() {
            @Override
            public void run() {
                try{
                    Thread.sleep(1000);
                }catch (InterruptedException e){
                    e.printStackTrace();
                }
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        initBooks();
                        adapter.notifyDataSetChanged();
                        swipeRefresh.setRefreshing(false);
                    }
                });
            }
        }).start();
    }

}
