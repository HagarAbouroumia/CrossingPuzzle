package game6.Model;

import java.util.ArrayList;

public class Caretaker {

    int count = 0;
    private ArrayList<MementoClass> mementos = new ArrayList<>();
    int size;

    public int getSize() {
        return mementos.size() - 1;
    }

    public void addMemento(MementoClass m) {
        //count++;
        mementos.add(m);
//
//        if (count == 5) {
//            System.out.println(mementos.get(0).getiCrossers());
//            System.out.println(mementos.get(1).getiCrossers());
//            System.out.println(mementos.get(2).getiCrossers());
//            System.out.println(mementos.get(3).getiCrossers());
//            System.out.println(mementos.get(4).getiCrossers());
//        }

    }

    public MementoClass get(int i) {

        return mementos.get(i);
    }

    public void clear() {
        mementos.clear();
    }

}
