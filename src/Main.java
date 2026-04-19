public class Main {
    public static void main(String[] args) {

        NavigatorImp navigator = new NavigatorImp();

        MyArrayList<String> lp1 = new MyArrayList<>();
        lp1.add("Москва");
        lp1.add("Новосибирск");
        lp1.add("Барнаул");
        Route r1 = new Route(4000, 77, true, lp1);

        MyArrayList<String> lp1s = new MyArrayList<>();
        lp1s.add("Москва");
        lp1s.add("Питер");
        lp1s.add("Барнаул");
        Route r1second = new Route(4000, 5, false, lp1s);

        MyArrayList<String> lp2 = new MyArrayList<>();
        lp2.add("Москва");
        lp2.add("Екатеринбург");
        lp2.add("Барнаул");
        Route r2 = new Route(4444, 77, false, lp2);

        MyArrayList<String> lp3 = new MyArrayList<>();
        lp3.add("Москва");
        lp3.add("Зудилово");
        lp3.add("Барнаул");
        Route r3 = new Route(60, 77, false, lp3);

        MyArrayList<String> lp4 = new MyArrayList<>();
        lp4.add("Москва");
        lp4.add("New York");
        lp4.add("Нижний Новгород");
        lp4.add("Екатеринбург");
        lp4.add("Волгоград");
        lp4.add("Барнаул");
        Route r4 = new Route(52, 52, true, lp4);

        MyArrayList<String> lp5 = new MyArrayList<>();
        lp5.add("Москва");
        lp5.add("Омск");
        lp5.add("Барнаул");
        Route r5 = new Route(600, 2, true, lp5);

        MyArrayList<String> lp6 = new MyArrayList<>();
        lp6.add("Москва");
        lp6.add("Красноярск");
        lp6.add("Краснодар");
        lp6.add("Барнаул");
        Route r6 = new Route(77777, 6, false, lp6);

        MyArrayList<String> lp7 = new MyArrayList<>();
        lp7.add("Липецк");
        lp7.add("Екатеринбург");
        lp7.add("Новосибирск");
        lp7.add("Смоленск");
        Route r7 = new Route(11111, 3, true, lp7);

        MyArrayList<String> lp8 = new MyArrayList<>();
        lp8.add("Уфа");
        lp8.add("Екатеринбург");
        lp8.add("Барнаул");
        Route r8 = new Route(11111, 9, true, lp8);

        MyArrayList<String> lp9 = new MyArrayList<>();
        lp9.add("Рязань");
        lp9.add("Екатеринбург");
        lp9.add("Красноярск");
        lp9.add("Белгород");
        Route r9 = new Route(4444, 77, true, lp9);

        MyArrayList<String> lp10 = new MyArrayList<>();
        lp10.add("Москва");
        lp10.add("Зудилово");
        lp10.add("Барнаул");
        Route r10 = new Route(62, 77, false, lp10);


        navigator.addRoute(r1);
        navigator.addRoute(r2);
        navigator.addRoute(r3);
        navigator.addRoute(r4);
        navigator.addRoute(r5);
        navigator.addRoute(r6);
        navigator.addRoute(r1second);
        navigator.addRoute(r7);
        navigator.addRoute(r8);
        navigator.addRoute(r9);
        navigator.addRoute(r10);

        System.out.println(navigator);

        System.out.println("contains r6? " + navigator.contains(r6));
        System.out.println("contains r1second? " + navigator.contains(r1second));

        System.out.println("size navigator: " + navigator.size());

//        System.out.println(navigator.getRoute(r3.getId()));
        navigator.chooseRoute(r3.getId());
//        System.out.println(navigator.getRoute(r3.getId()));

//        System.out.println(navigator.searchRoutes("Москва", "Барнаул"));
//        System.out.println(navigator.searchRoutes("jkbjf", " mvdjn"));
//        System.out.println(navigator.getFavoriteRoutes("Екатеринбург"));
//        System.out.println(navigator.getFavoriteRoutes("bgksjbgk"));
        System.out.println(navigator.getTop5Routes());

//        System.out.println(navigator);




//        TreeSet<Integer> trees = new TreeSet<>();
//        trees.add(4);
//        trees.add(2);
//        trees.add(6);
//        trees.add(1);
//        trees.add(3);
//        trees.add(5);
//        trees.add(7);
//
//        trees.remove(4);
//        System.out.println(trees.contains(3));
//        System.out.println(trees.isEmpty());
//        System.out.println(trees.first() + " " + trees.last());
//        System.out.println(trees);
//        trees.clear();
//        System.out.println(trees + "!");


//
//        System.out.println(trees.get(4));
//
//        System.out.println(trees);

//        ArrayList<String> points1 = new ArrayList<>();
//        points1.add("Иваново");
//        points1.add("Питер");
//        points1.add("Краснодар");
//        Route r1 = new Route("neirnslknoj398h87g", 50, 1, false, points1);
//        ArrayList<String> points2 = new ArrayList<>();
//        points2.add("Иваново");
//        points2.add("Питер");
//        points2.add("Красноярск");
//        Route r2 = new Route("iudbiuvbbisbu", 50, 0, true, points1);
//        System.out.println(r1.equals(r2));
////        System.out.println(r1.hashCode());
//        System.out.println(r2.hashCode());
//        System.out.println(r1.hashCode());


//        Tree<Integer> bst = new Tree<>();
//        bst.insert(4);
//        bst.insert(2);
//        bst.insert(6);
//        bst.insert(1);
//        bst.insert(3);
//        bst.insert(5);
//        bst.insert(7);
//        bst.insert(8);
//        bst.insert(9);
////
////        System.out.println(bst.inOrder());
//        bst.printTree();
////
//        bst.delete(6);
//        bst.delete(9);
////
//////        System.out.println(bst.inOrder());
//        bst.printTree();
    }
}
