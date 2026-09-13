package springxml;

import org.springframework.context.support.ClassPathXmlApplicationContext;

class XmlLifecycleBean {

    public XmlLifecycleBean() {
        System.out.println("Bean created.");
    }

    public void init() {
        System.out.println("Bean initialized.");
    }

    public void execute() {
        System.out.println("Bean is being used.");
    }

    public void destroy() {
        System.out.println("Bean destroyed.");
    }
}

public class XmlScopeLifecycleDemo {

    public static void main(String[] args) {

        ClassPathXmlApplicationContext context =
                new ClassPathXmlApplicationContext("scope-lifecycle-config.xml");

        System.out.println("----- SINGLETON -----");

        XmlLifecycleBean bean1 =
                context.getBean("singletonBean", XmlLifecycleBean.class);

        XmlLifecycleBean bean2 =
                context.getBean("singletonBean", XmlLifecycleBean.class);

        System.out.println("Same object: " + (bean1 == bean2));

        bean1.execute();

        System.out.println("\n----- PROTOTYPE -----");

        XmlLifecycleBean prototype1 =
                context.getBean("prototypeBean", XmlLifecycleBean.class);

        XmlLifecycleBean prototype2 =
                context.getBean("prototypeBean", XmlLifecycleBean.class);

        System.out.println("Same object: " + (prototype1 == prototype2));

        context.close();
    }
}