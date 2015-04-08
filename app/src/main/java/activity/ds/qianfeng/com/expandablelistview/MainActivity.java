package activity.ds.qianfeng.com.expandablelistview;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ExpandableListView;

import com.lidroid.xutils.DbUtils;
import com.lidroid.xutils.ViewUtils;
import com.lidroid.xutils.exception.DbException;
import com.lidroid.xutils.view.annotation.ContentView;
import com.lidroid.xutils.view.annotation.ViewInject;

import java.util.ArrayList;
import java.util.List;

/**
 * 可扩展的listview
 */
@ContentView(R.layout.activity_main)
public class MainActivity extends ActionBarActivity {
    @ViewInject(R.id.listview)
    private ExpandableListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ViewUtils.inject(this);
        List<Bean> beans=new ArrayList<>();

        for (int i=0;i<10;i++){
            Bean bean=new Bean();
            bean.setName("Bean"+i);
            bean.setChildren(new ArrayList<ChildBean>());
            for(int j=0;j<=i;j++){
                ChildBean child=new ChildBean();
                child.setName("Bean"+i+"Child"+j);
                child.setBean(bean);
                bean.getChildren().add(child);
            }
            beans.add(bean);
        }
        DbUtils utils=DbUtils.create(this);
        try {
            utils.saveAll(beans);
        } catch (DbException e) {
            e.printStackTrace();
        }
        //读取数据
//        try {
//            beans=utils.findAll(Bean.class);
//        } catch (DbException e) {
//            e.printStackTrace();
//        }
        //设置适配器
        listView.setAdapter(new MyAdapter(this,beans));
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
}
