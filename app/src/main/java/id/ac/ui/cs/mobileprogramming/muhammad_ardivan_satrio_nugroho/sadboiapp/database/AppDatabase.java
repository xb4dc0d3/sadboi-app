package id.ac.ui.cs.mobileprogramming.muhammad_ardivan_satrio_nugroho.sadboiapp.database;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import id.ac.ui.cs.mobileprogramming.muhammad_ardivan_satrio_nugroho.sadboiapp.dao.StoryPostDao;
import id.ac.ui.cs.mobileprogramming.muhammad_ardivan_satrio_nugroho.sadboiapp.model.StoryPost;

@Database(entities = {StoryPost.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {

    //TODO: Add more entities

    // StoryPostDao Abstract Class
    public abstract StoryPostDao storyPostDao();

    private static volatile AppDatabase INSTANCE;

    public static AppDatabase getDatabase(final Context context) {
        if (INSTANCE == null) {
            synchronized (AppDatabase.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                            AppDatabase.class, "sadboi_app_database")
                            .build();
                }
            }
        }
        return INSTANCE;
    }
}
