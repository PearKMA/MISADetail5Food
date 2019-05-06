package vn.com.misa.detail5food;

import android.databinding.DataBindingUtil;
import android.graphics.drawable.ColorDrawable;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import vn.com.misa.detail5food.databases.SQLiteDataController;
import vn.com.misa.detail5food.databinding.ActivityMainBinding;
import vn.com.misa.detail5food.model.InfomationStore;

public class MainActivity extends AppCompatActivity {
    private Toolbar toolbar;
    private ArrayList<InfomationStore> mList;
    private SQLiteDataController mDatabase;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        addControl();
        setToolBar();
        addSQL();
        addEvent();
    }

    private void addEvent() {

    }

    private void addSQL() {
        mList.add(new InfomationStore(1,"HÀNG RONG 1",3.5f,1,"Đồ uống","Sắp mở cửa","06:30 SA - 10:00 CH",
                "96 Chợ Nhỏ, Đường Bé, Hà Nội","69Km"));
        mList.add(new InfomationStore(2,"HÀNG RONG 2",2.5f,1,"Đồ ăn","Đã mở cửa","08:30 SA - 08:00 CH",
                "69 Chợ Lớn, Đường To, Hà Nội","96Km"));
        mList.add(new InfomationStore(3,"HÀNG RONG 3",5.0f,1,"Đồ chơi","Đóng cửa","07:30 SA - 06:00 CH",
                "969 Chợ Cái, Đường Phèn, Hà Nội","696Km"));

        for (InfomationStore info: mList){
            mDatabase.addInfomationStore(info);
        }
    }

    /**
     * findviewbyid các view
     */
    private void addControl() {
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        mList = new ArrayList<>();
        mDatabase=new SQLiteDataController(this);
    }

    /**
     * thiết lập toolbar hiện menu chia sẻ, báo cáo sai thông tin nhà hàng, trở lại màn hình trước đó
     * bắt sự kiện ẩn/hiện tên nhà hàng trên toolbar khi người dùng cuộn trang
     */
    private void setToolBar() {
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_back);

        final CollapsingToolbarLayout collapsingToolbar =
                (CollapsingToolbarLayout) findViewById(R.id.collapsingToolbar);
        AppBarLayout appBarLayout = (AppBarLayout) findViewById(R.id.appBarLayout);
        appBarLayout.addOnOffsetChangedListener(new AppBarLayout.OnOffsetChangedListener() {
            boolean isShow = false;
            int scrollRange = -1;

            @Override
            public void onOffsetChanged(AppBarLayout appBarLayout, int verticalOffset) {
                if (scrollRange == -1) {
                    scrollRange = appBarLayout.getTotalScrollRange();
                }
                if (scrollRange + verticalOffset == 0) {
                    collapsingToolbar.setTitle("HÀNG RONG");
                    isShow = true;
                } else if (isShow) {
                    collapsingToolbar.setTitle("");
                    isShow = false;
                }
            }
        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_toolbar, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
//        ActivityMainBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
//
//        InfomationStore infomationStore = new InfomationStore();


        switch (item.getItemId()) {
            case R.id.mnuShare:
                mDatabase.getInfomationStoreById(1);
                Toast.makeText(getApplicationContext(), "Shared", Toast.LENGTH_LONG).show();
                return true;
            case R.id.mnuReport:
                mDatabase.getInfomationStoreById(2);
                Toast.makeText(getApplicationContext(), "Reported", Toast.LENGTH_LONG).show();
                return true;
            case android.R.id.home:
                mDatabase.getInfomationStoreById(3);
//                finish();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }

    }

    @Override
    public boolean onNavigateUp() {
        finish();
        return true;
    }
}
