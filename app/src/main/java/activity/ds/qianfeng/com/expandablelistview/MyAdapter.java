package activity.ds.qianfeng.com.expandablelistview;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.BaseExpandableListAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Administrator on 2015/3/11.
 */
public class MyAdapter extends BaseExpandableListAdapter {

    private Context context;
    private List<Bean> beans;
    public MyAdapter(Context context,List<Bean> beans){
        this.beans=beans;
        this.context=context;
    }


    /**
     * 得到组的个数
     * @return
     */
    @Override
    public int getGroupCount() {
        return beans.size();
    }

    /**
     * 组里子view的个数
     * @param groupPosition
     * @return
     */
    @Override
    public int getChildrenCount(int groupPosition) {
        return beans.get(groupPosition).getChildren().size();
    }

    @Override
    public Object getGroup(int groupPosition) {
        return beans.get(groupPosition);
    }

    @Override
    public Object getChild(int groupPosition, int childPosition) {
        return beans.get(groupPosition).getChildren().get(childPosition);
    }

    @Override
    public long getGroupId(int groupPosition) {
        return groupPosition;
    }

    @Override
    public long getChildId(int groupPosition, int childPosition) {
        return groupPosition;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }

    @Override
    public View getGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {
        if(convertView==null){
            convertView= LayoutInflater.from(context).inflate(R.layout.group,parent,false);
            convertView.setTag(convertView.findViewById(R.id.txt_group));
        }
        TextView view1= (TextView) convertView.getTag();

        if(isExpanded){
            view1.setTextColor(Color.RED);
        }else{
            view1.setTextColor(Color.BLUE);
        }
        //设置显示内容
        view1.setText(beans.get(groupPosition).getName());
        return convertView;
    }

    @Override
    public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {

        if(convertView==null){
            convertView=LayoutInflater.from(context).inflate(R.layout.item,parent,false);
            convertView.setTag(convertView.findViewById(R.id.txt_item));
        }
        TextView view1= (TextView) convertView.getTag();

        if(isLastChild){
            view1.setTextColor(Color.RED);
        }else{
            view1.setTextColor(Color.BLUE);
        }
        //设置显示内容
        view1.setText(beans.get(groupPosition).getChildren().get(childPosition).getName());
        return convertView;

    }

    @Override
    public boolean isChildSelectable(int i, int i2) {
        return false;
    }
}
