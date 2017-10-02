package com.example.daggerretrofitokhttpgsonrxjavarxandroid.ui.foodz;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.example.daggerretrofitokhttpgsonrxjavarxandroid.R;
import com.example.daggerretrofitokhttpgsonrxjavarxandroid.app.DeezFoodzApplication;
import com.example.daggerretrofitokhttpgsonrxjavarxandroid.app.StringUtils;
import com.example.daggerretrofitokhttpgsonrxjavarxandroid.model.FoodzItem;
import com.example.daggerretrofitokhttpgsonrxjavarxandroid.ui.food.FoodActivity;

import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

public class FoodzActivity extends AppCompatActivity implements FoodzView {

    //FoodzPresenter presenter;

    @Inject
    FoodzPresenter presenter;


    @BindView(R.id.activity_foodz_recyclerView)
    RecyclerView foodzRecyclerView;


    @BindView(R.id.activity_foodz_progressBar)
    ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_foodz);

        ((DeezFoodzApplication) getApplication()).getAppComponent().inject(this);

        ButterKnife.bind(this);

        foodzRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        // presenter = new FoodzPresenterImpl();
        presenter.setView(this);
        presenter.getFoodz();

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

       /*
        * FoodzView
        */

    @Override
    public void showLoading() {
        progressBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideLoading() {

        progressBar.setVisibility(View.GONE);

    }

    @Override
    public void showFoodz(List<FoodzItem> foodzItemList) {

        foodzRecyclerView.setAdapter(new FoodzAdapter(foodzItemList));
        foodzRecyclerView.getAdapter().notifyDataSetChanged();
    }

    @Override
    public void showErrorMessage() {

        Toast.makeText(this, R.string.FoodzListError, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void launchFoodDetail(FoodzItem foodzItem) {

        FoodActivity.launch(this, foodzItem);
    }


    /*
   * Inner Classes
   */

    class FoodzAdapter extends RecyclerView.Adapter<FoodzViewHolder> {

        private List<FoodzItem> foodzItemList;

        FoodzAdapter(List<FoodzItem> foodzItemList) {
            this.foodzItemList = foodzItemList;
        }

        @Override
        public FoodzViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            LayoutInflater inflater = LayoutInflater.from(FoodzActivity.this);
            return new FoodzViewHolder(inflater.inflate(R.layout.list_item_food, parent, false));
        }

        @Override
        public void onBindViewHolder(FoodzViewHolder holder, int position) {
            FoodzItem foodzItem = foodzItemList.get(position);
            holder.getFoodName().setText(StringUtils.stripPrefix(foodzItem.getName()));
            holder.getContainer().setOnClickListener(v -> launchFoodDetail(foodzItem));
        }

        @Override
        public int getItemCount() {
            return foodzItemList.size();
        }
    }
}
