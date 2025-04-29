com.example.menugenerator;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

public class DatabaseAccess {
    private DatabaseHelper openHelper;
    private SQLiteDatabase db;
    private static DatabaseAccess instance;
    private Cursor c = null;

    private DatabaseAccess(Context context) {
        this.openHelper = new DatabaseHelper(context);
    }

    public static DatabaseAccess getInstance(Context context) {
        if (instance == null) {
            instance = new DatabaseAccess(context);
        }
        return instance;
    }

    public void open() {
        this.db = openHelper.getReadableDatabase();
    }

    public void close() {
        if (db != null) {
            this.db.close();
        }
    }
    public SQLiteDatabase getDb() {
        return db;
    }
    public String getNombreDeParticipants(String utilisateur) {
        String result = null;
        Cursor c = db.rawQuery("SELECT NombreDeParticipants FROM Utilisateur WHERE Nom=?", new String[]{utilisateur});
        if (c != null) {
            if (c.moveToFirst()) {
                result = c.getString(0);
            }
            c.close(); // ✅ toujours fermer le curseur, même si vide
        }
        return result;
    }
}
