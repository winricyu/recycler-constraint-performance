package fun.dooit.performance;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import java.util.ArrayList;
import java.util.List;

public class ScrollingActivity extends AppCompatActivity {

    private RecyclerView mRecyclerView;
    private RecyclerView.LayoutManager layoutManager;
    private TicketAdapter mTicketAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scrolling);
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
        mRecyclerView = findViewById(R.id.recyclerView);
        layoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        List<Integer> data = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            data.add(i + 1);
        }
        mTicketAdapter = new TicketAdapter(data);
        mRecyclerView.setLayoutManager(layoutManager);
        mRecyclerView.setAdapter(mTicketAdapter);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_scrolling, menu);
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

    private class TicketAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

        private List<Integer> mList;


        public TicketAdapter(List<Integer> mList) {
            this.mList = mList;
        }

        @Override
        public int getItemViewType(int position) {
            return position;
        }

        @NonNull
        @Override
        public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            TicketVH ticketVH = null;
            LinearLayout linearLayout;
            View view;
            int type = viewType % 3;
//            switch (type) {
//                case 0:

            linearLayout = new LinearLayout(ScrollingActivity.this);
            linearLayout.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT,LinearLayout.LayoutParams.WRAP_CONTENT));
            linearLayout.setOrientation(LinearLayout.VERTICAL);
            view = LayoutInflater.from(ScrollingActivity.this).inflate(R.layout.item_search_flight_destination, parent, false);
            linearLayout.addView(view);
            view = LayoutInflater.from(ScrollingActivity.this).inflate(R.layout.item_search_flight_destination, parent, false);
            linearLayout.addView(view);
            view = LayoutInflater.from(ScrollingActivity.this).inflate(R.layout.item_search_flight_price, parent, false);
            linearLayout.addView(view);
            ticketVH = new TicketVH(linearLayout);
//            break;
//                case 1:
//                    ticketVH = new TicketVH(LayoutInflater.from(ScrollingActivity.this).inflate(R.layout.item_search_flight_destination, parent, false));
//                    break;
//                case 2:
//                    ticketVH = new TicketVH(LayoutInflater.from(ScrollingActivity.this).inflate(R.layout.item_search_flight_destination, parent, false));
//                    break;
//            }

            return ticketVH;
        }

        @Override
        public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {

        }

        @Override
        public int getItemCount() {
            return mList.size();
        }

        class TicketVH extends RecyclerView.ViewHolder {

            public TicketVH(View itemView) {
                super(itemView);
            }
        }
    }
}
