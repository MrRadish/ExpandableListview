package activity.ds.qianfeng.com.expandablelistview;

import com.lidroid.xutils.db.annotation.Column;
import com.lidroid.xutils.db.annotation.Foreign;
import com.lidroid.xutils.db.annotation.Id;
import com.lidroid.xutils.db.annotation.Table;

/**
 * Created by Administrator on 2015/3/11.
 */
@Table(name="child")
public class ChildBean {
    @Id(column = "id")
    private int id;
    @Column(column = "name")
    private String name;
    @Foreign(column="beanId",foreign = "id")//取bean类的id作为beanid的值
    private Bean bean;


    public Bean getBean() {
        return bean;
    }

    public void setBean(Bean bean) {
        this.bean = bean;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

}
