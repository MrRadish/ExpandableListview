package activity.ds.qianfeng.com.expandablelistview;

import com.lidroid.xutils.db.annotation.Column;
import com.lidroid.xutils.db.annotation.Finder;
import com.lidroid.xutils.db.annotation.Id;
import com.lidroid.xutils.db.annotation.Table;

import java.util.List;

/**
 * Created by Administrator on 2015/3/11.
 */
@Table(name="bean")
public class Bean {
    @Id(column = "id")
    private int id;
    @Column(column = "name")
    private String name;
    @Finder(valueColumn = "id",targetColumn = "beanId")
    List<ChildBean> children;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<ChildBean> getChildren() {
        return children;
    }

    public void setChildren(List<ChildBean> children) {
        this.children = children;
    }
}
