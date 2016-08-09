package resource.and.property;

import init.destroy.method.ConfigBean;

import org.springframework.core.io.ClassPathResource;

public class SpringClassPathResource {

    private static int num = 0;

    public static void main(String[] args) {

        testClassPathResource();
    }

    public static void testClassPathResource() {
        ClassPathResource cpr1 = new ClassPathResource("home/rain/a");
        println(cpr1);
        ClassPathResource cpr2 = new ClassPathResource("/home/rain/a");
        println(cpr2);

        ClassPathResource cpr3 = new ClassPathResource("home/rain/a", SpringClassPathResource.class);
        println(cpr3);
        ClassPathResource cpr4 = new ClassPathResource("/home/rain/a", SpringClassPathResource.class);
        println(cpr4);

        ClassPathResource cpr5 = new ClassPathResource("", SpringClassPathResource.class);
        println(cpr5);
        ClassPathResource cpr6 = new ClassPathResource("/", SpringClassPathResource.class);
        println(cpr6);

        ClassPathResource cpr7 = new ClassPathResource("app.properties", SpringClassPathResource.class);
        println(cpr7);

        ClassPathResource cpr8 = new ClassPathResource("app.properties", ConfigBean.class.getClassLoader());
        println(cpr8);
        ClassPathResource cpr9 = new ClassPathResource("app.properties", SpringClassPathResource.class.getClassLoader());
        println(cpr9);

        ClassPathResource cpr10 = new ClassPathResource("", SpringClassPathResource.class.getClassLoader());
        println(cpr10);
        ClassPathResource cpr11 = new ClassPathResource("/", SpringClassPathResource.class.getClassLoader());
        println(cpr11);

        ClassPathResource cpr12 = new ClassPathResource("overview.html", SpringClassPathResource.class.getClassLoader());
        println(cpr12);
    }

    private static void println(ClassPathResource r) {
        System.out.println("--------------------------------------------");
        System.out.println(++num);
        System.out.println("Description: " + r.getDescription());
        System.out.println("Filename: " + r.getFilename());
        System.out.println("Path: " + r.getPath());
        System.out.println("Exists: " + r.exists());
        System.out.println("--------------------------------------------");
        System.out.println();
    }
}
