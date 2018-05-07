package app.qlExpress.operater;

import com.ql.util.express.Operator;

import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("unchecked")
public class JointOperator extends Operator {

    @Override
    public Object executeInner(Object[] objects) throws Exception {
        Object object1 = objects[0];
        Object object2 = objects[1];
        if (object1 instanceof List){
            ((List) object1).add(object2);
            return object1;
        }else{
            List list = new ArrayList();
            list.add(object1);
            list.add(object2);
            return list;
        }
    }
}
