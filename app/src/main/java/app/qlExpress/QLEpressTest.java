package app.qlExpress;

import app.qlExpress.operater.JointOperator;
import com.ql.util.express.DefaultContext;
import com.ql.util.express.ExpressRunner;

public class QLEpressTest {

    public static void main(String[] args) {
        ExpressRunner runner = new ExpressRunner();
        DefaultContext<String,Object> context = new DefaultContext<>();
        try {
            //绑定java类
            runner.addFunctionOfClassMethod("绝对值",Math.class.getName(),"abs",new String[]{"double"},null);
            Object execute1 = runner.execute("绝对值(-2.3)", context, null, false, false);
            System.out.println(execute1);
            //绑定对象
            runner.addFunctionOfServiceMethod("打印",System.out,"println",new String[]{"String"},null);
            Object execute2 = runner.execute("打印(\"士大夫\")", context, null, false, false);
            //绑定operator
            runner.addOperator("join",new JointOperator());
            Object execute = runner.execute("1 join 2 join 3", context, null, false, false);
            System.out.println(execute);
            //macro宏定义
            runner.addMacro("平均成绩","(数学+语文+英语)/3.0");
            runner.addMacro("是否合格","平均成绩>90");
            context.put("语文",92);
            context.put("数学",88);
            context.put("英语",89);
            Object average = runner.execute("平均成绩", context, null, false, false);
            Object grage = runner.execute("是否合格", context, null, false, false);
            System.out.println(average);
            System.out.println(grage);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
