package hridoy.aiz.fragmentswithrecyclerview;

import android.app.Application;

import java.util.ArrayList;

public class ApplicationClass extends Application {

    public ArrayList<Person> personArrayList;

    @Override
    public void onCreate() {
        super.onCreate();

        personArrayList = new ArrayList<Person>();

        personArrayList.add(new Person("Yean Botham", "4332164123132"));
        personArrayList.add(new Person("Mark Ruffalo", "4651321"));
        personArrayList.add(new Person("Hanse Kronje", "791313265465"));
    }
}

