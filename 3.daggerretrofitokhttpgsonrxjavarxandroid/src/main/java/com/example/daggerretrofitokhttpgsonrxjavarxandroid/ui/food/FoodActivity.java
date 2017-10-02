package com.example.daggerretrofitokhttpgsonrxjavarxandroid.ui.food;

import android.content.Context;
import android.content.Intent;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.example.daggerretrofitokhttpgsonrxjavarxandroid.R;
import com.example.daggerretrofitokhttpgsonrxjavarxandroid.app.DeezFoodzApplication;
import com.example.daggerretrofitokhttpgsonrxjavarxandroid.app.StringUtils;
import com.example.daggerretrofitokhttpgsonrxjavarxandroid.model.Food;
import com.example.daggerretrofitokhttpgsonrxjavarxandroid.model.FoodzItem;
import com.example.daggerretrofitokhttpgsonrxjavarxandroid.ui.foodz.FoodzPresenter;
import com.example.daggerretrofitokhttpgsonrxjavarxandroid.ui.foodz.FoodzView;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

public class FoodActivity extends AppCompatActivity implements FoodView {

    public static final String EXTRA_FOOD_ID = "EXTRA_FOOD_ID";
    @Inject
    FoodPresenter presenter;
    @BindView(R.id.activity_food_name)
    TextView foodName;
    @BindView(R.id.activity_food_measure)
    TextView foodMeasure;
    @BindView(R.id.activity_food_nutrient)
    TextView foodNutrient;
    @BindView(R.id.activity_food_imageView)
    ImageView imageView;
    @BindView(R.id.activity_food_progressBar)
    ProgressBar progressBar;

    public static void launch(Context context, FoodzItem foodzItem) {
        Intent intent = new Intent(context, FoodActivity.class);
        intent.putExtra(EXTRA_FOOD_ID, foodzItem.getId());
        context.startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food);

        ((DeezFoodzApplication) getApplication()).getAppComponent().inject(this);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        ButterKnife.bind(this);

        String foodId = getIntent().getStringExtra(EXTRA_FOOD_ID);

        //presenter = new FoodPresenterImpl();
        presenter.setView(this);
        presenter.getFood(foodId);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

  /*
   * FoodView
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
    public void showFood(Food food) {

        String foodNameString = StringUtils.stripPrefix(food.getName());
        setTitle(foodNameString);
        foodName.setText(foodNameString);
        foodMeasure.setText(String.format(getString(R.string.FoodItemMeasure), food.getMeasure()));
        foodNutrient.setText(food.getNutrients().get(0).toString());
        foodNutrient.setTextColor(ContextCompat.getColor(this, presenter.getFoodColor(food)));
        imageView.setImageDrawable(ContextCompat.getDrawable(this, presenter.getFoodImage(food)));

    }

    @Override
    public void showErrorMessage() {

        Toast.makeText(this, R.string.FoodItemError, Toast.LENGTH_SHORT).show();

    }
}
