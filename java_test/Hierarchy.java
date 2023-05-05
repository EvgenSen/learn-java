import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        System.out.println("Hierarchy test started");

        User user1 = new User("Ivan");
        System.out.println(user1.toString());

        Developer dev1 = new Developer("Boris", "Java");
        System.out.println(dev1.toString());

        Developer dev2 = new Developer();
        // System.out.println(dev2.toString());
        dev2.name = "Egor";
        dev2.lang = "C++";
        System.out.println(dev2.toString());

        Manager manager1 = new Manager("Petr", "Head");
        System.out.println(manager1.toString());
    }
}

class Global {
    static final String DEF_NAME = "NoName";
    static final String DEF_LANG = "NoLang";
    static final String DEF_POST = "NoPost";

    static int ID = 0;

    static int getNextID() {
        return ++ID;
    }
}

class User {
    protected Integer id;
    String name;

    public User() {
        this.name = Global.DEF_NAME;
        this.id = Global.getNextID();
    }

    public User(String name) {
        this.name = name;
        this.id = Global.getNextID();
    }

    public Integer getID() {
        return this.id;
    }

    public String toString() {
        return "Class=User     " +
                ", id=" + id +
                ", name='" + name + '\'' +
                '.' ;
    }
}

class Developer extends User {
    String lang;

    public Developer() {
        super();
        this.lang = Global.DEF_LANG;
    }

    public Developer(String name, String lang) {
        super(name);
        this.lang = lang;
    }

    @Override
    public String toString() {
        return "Class=Developer" +
                ", id=" + id +
                ", name='" + name + '\'' +
                ", lang=" + lang +
                '.' ;
    }
}

class Manager extends User {
    String post;

    public Manager() {
        super();
        this.post = Global.DEF_POST;
    }

    public Manager(String name, String post) {
        super(name);
        this.post = post;
    }

    @Override
    public String toString() {
        return "Class=Manager  " +
                ", id=" + id +
                ", name='" + name + '\'' +
                ", post=" + post +
                '.' ;
    }
}
