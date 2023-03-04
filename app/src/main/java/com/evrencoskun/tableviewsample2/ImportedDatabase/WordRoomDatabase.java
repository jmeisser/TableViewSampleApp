package com.evrencoskun.tableviewsample2.ImportedDatabase;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Database(entities = {Word.class}, version = 1, exportSchema = false)
public abstract class WordRoomDatabase extends RoomDatabase {

    public abstract WordDao wordDao();

    private static volatile WordRoomDatabase INSTANCE;
    private static final int NUMBER_OF_THREADS = 4;
    static final ExecutorService databaseWriteExecutor =
            Executors.newFixedThreadPool(NUMBER_OF_THREADS);

    public static WordRoomDatabase getDatabase(final Context context) {
        if (INSTANCE == null) {
            synchronized (WordRoomDatabase.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                                    WordRoomDatabase.class, "word_database")
                            .addCallback(sRoomDatabaseCallback)
                            .build();
                }
            }
        }
        return INSTANCE;
    }
    private static Callback sRoomDatabaseCallback = new Callback() {
        @Override
        public void onCreate(@NonNull SupportSQLiteDatabase db) {
            super.onCreate(db);

            // If you want to keep data through app restarts,
            // comment out the following block
            databaseWriteExecutor.execute(() -> {
                // Populate the database in the background.
                // If you want to start with more words, just add them.
                WordDao dao = INSTANCE.wordDao();
                dao.deleteAll();

                Word word = new Word("Hello");
                dao.insert(word);
                word = new Word("World");
                dao.insert(word);
                word = new Word("Aello");
                dao.insert(word);
                word = new Word("Bello");
                dao.insert(word);
                word = new Word("Cello");
                dao.insert(word);
                word = new Word("Dello");
                dao.insert(word);
                word = new Word("Eello");
                dao.insert(word);
                word = new Word("Fello");
                dao.insert(word);
                word = new Word("Gello");
                dao.insert(word);
                word = new Word("Iello");
                dao.insert(word);
                word = new Word("Jello");
                dao.insert(word);
                word = new Word("Kello");
                dao.insert(word);
                word = new Word("Lello");
                dao.insert(word);
                word = new Word("Mello");
                dao.insert(word);
                word = new Word("Nello");
                dao.insert(word);
                word = new Word("Oello");
                dao.insert(word);
                word = new Word("Pello");
                dao.insert(word);
                word = new Word("Qorld");
                dao.insert(word);
                word = new Word("Rello");
                dao.insert(word);
                word = new Word("Sello");
                dao.insert(word);
                word = new Word("Tello");
                dao.insert(word);
                word = new Word("Uello");
                dao.insert(word);
                word = new Word("Vello");
                dao.insert(word);
                word = new Word("Wello");
                dao.insert(word);
                word = new Word("Xello");
                dao.insert(word);
                word = new Word("Yello");
                dao.insert(word);
                word = new Word("Zello");
                dao.insert(word);
                word = new Word("1ello");
                dao.insert(word);
                word = new Word("2ello");
                dao.insert(word);
                word = new Word("3ello");
                dao.insert(word);
                word = new Word("4ello");
                dao.insert(word);
                word = new Word("5ello");
                dao.insert(word);
                word = new Word("6ello");
                dao.insert(word);
                word = new Word("7ello");
                dao.insert(word);
                word = new Word("8ello");
                dao.insert(word);
                word = new Word("9ello");
                dao.insert(word);
                word = new Word("Aorld");
                dao.insert(word);
                word = new Word("Borld");
                dao.insert(word);
                word = new Word("Corld");
                dao.insert(word);
                word = new Word("Dorld");
                dao.insert(word);
                word = new Word("Eorld");
                dao.insert(word);
                word = new Word("Forld");
                dao.insert(word);
                word = new Word("Gorld");
                dao.insert(word);
                word = new Word("Horld");
                dao.insert(word);
                word = new Word("Iorld");
                dao.insert(word);
                word = new Word("Jorld");
                dao.insert(word);
                word = new Word("Korld");
                dao.insert(word);
                word = new Word("Lorld");
                dao.insert(word);


            });
        }
    };
}