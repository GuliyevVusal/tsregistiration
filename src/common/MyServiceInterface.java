package common;

public interface MyServiceInterface {


//    public void showMenu() {
//        System.out.println("Welcome Teacher & Student Registiration: ");
//        System.out.println("Enter operation:  0/1/2/3/4/5");
//        System.out.println(" 0. First time create :");
//        System.out.println(" 1. Add new : ");
//        System.out.println(" 2. Upadate : ");
//        System.out.println(" 3. Delete : ");
//        System.out.println(" 4. Search : ");
//        System.out.println(" 5. GetAll : ");
//
//
//        int actionTeacher = new Scanner(System.in).nextInt();
//
//
//        if (actionTeacher == 0) {
//            initialize();
//        } else if (actionTeacher == 1) {
//            initializeNew();
//        } else if (actionTeacher == 2) {
//            update();
//        } else if (actionTeacher == 3) {
//            delete();
//        } else if (actionTeacher == 4) {
//            find();
//        } else if (actionTeacher == 5) {
//            getAll();
//        }
//
//    }

    void initialize();

    void initializeNew();


    void update();

    void delete();


    void find();


    void getAll();

}


