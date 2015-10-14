package br.com;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ListView;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends Activity {
    
    ListView listView;
    List<RowItem> rowItems;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        rowItems = new ArrayList<RowItem>();
        rowItems.add(new RowItem("AAAAA","BBBBBB"));
        rowItems.add(new RowItem("AAAAA","BBBBBB"));
        rowItems.add(new RowItem("AAAAA","BBBBBB"));
        rowItems.add(new RowItem("AAAAA","BBBBBB"));
        
        
        listView = (ListView) findViewById(R.id.list);
        CustomListViewAdapter adapter = new CustomListViewAdapter(this, R.layout.list_item, rowItems);
        listView.setAdapter(adapter);
    }
}
