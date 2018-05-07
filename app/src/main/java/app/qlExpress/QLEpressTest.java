package app.qlExpress;

import app.qlExpress.operater.JointOperator;
import com.ql.util.express.DefaultContext;
import com.ql.util.express.ExpressRunner;

public class QLEpressTest {

    public static void main(String[] args) {
        ExpressRunner expressRunner = new ExpressRunner();
        DefaultContext<String,Object> context = new DefaultContext<>();
        try {
            expressRunner.addOperator("join",new JointOperator());
            Object execute = expressRunner.execute("1 join 2 join 3", context, null, false, false);
            System.out.println(execute);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
