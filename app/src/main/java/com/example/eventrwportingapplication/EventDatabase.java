package com.example.eventrwportingapplication;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import com.example.eventrwportingapplication.Core.Event;
import com.example.eventrwportingapplication.Core.User;
import com.example.eventrwportingapplication.Enums.EventType;
import com.example.eventrwportingapplication.Enums.Region;
import com.example.eventrwportingapplication.Enums.RiskLevel;

import java.io.ByteArrayOutputStream;
import java.util.ArrayList;
import java.util.List;

public class EventDatabase extends SQLiteOpenHelper {
    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "EventDB";

    //user table
    private static final String TABLE_USER_NAME = "users";
    private static final String USER_COLUMN_ID = "username";
    private static final String USER_COLUMN_Password = "password";
    private static final String[] TABLE_USER_COLUMNS = {USER_COLUMN_ID, USER_COLUMN_Password};

    //event table
    private static final String TABLE_EVENTS_NAME = "events";
    private static final String EVENT_COLUMN_ID = "id";
    private static final String EVENT_COLUMN_EVENT_TYPE = "eventType";
    private static final String EVENT_COLUMN_IMAGE = "image1";
    private static final String EVENT_COLUMN_DESCRIPTION = "description";
    private static final String EVENT_COLUMN_LOCATION = "location";
    private static final String EVENT_COLUMN_REGION = "region";
    private static final String EVENT_COLUMN_RISK_LEVEL = "riskLevel";
    private static final String EVENT_COLUMN_USERID = "user_id";
    private SQLiteDatabase db = null;

    private static final String[] TABLE_EVENT_COLUMNS = {EVENT_COLUMN_ID, EVENT_COLUMN_EVENT_TYPE,
            EVENT_COLUMN_IMAGE, EVENT_COLUMN_DESCRIPTION, EVENT_COLUMN_LOCATION, EVENT_COLUMN_REGION,
            EVENT_COLUMN_RISK_LEVEL, EVENT_COLUMN_USERID};


    public EventDatabase(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);

    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        try {
            // SQL statement to create user table
            String CREATE_USER_TABLE = "create table if not exists " + TABLE_USER_NAME + " ( "
                    + USER_COLUMN_ID + " TEXT PRIMARY KEY, "
                    + USER_COLUMN_Password + " TEXT)";
            sqLiteDatabase.execSQL(CREATE_USER_TABLE);

            // SQL statement to create event table
            String CREATE_ITEM_TABLE = "create table if not exists " + TABLE_EVENTS_NAME + " ( "
                    + EVENT_COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                    + EVENT_COLUMN_EVENT_TYPE + " TEXT, "
                    + EVENT_COLUMN_IMAGE + " BLOB, "
                    + EVENT_COLUMN_DESCRIPTION + " TEXT, "
                    + EVENT_COLUMN_LOCATION + " TEXT, "
                    + EVENT_COLUMN_REGION + " TEXT, "
                    + EVENT_COLUMN_RISK_LEVEL + " TEXT, "
                    + EVENT_COLUMN_USERID + " TEXT)";
            sqLiteDatabase.execSQL(CREATE_ITEM_TABLE);

        } catch (Throwable t) {
            t.printStackTrace();
        }

    }
    /*
    If we uploaded a new version or added a new field to the table,
     in onUpgrade we define a query that adjusts what we changed in the new version
      so as not to lose the user data
     */

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int oldVersion, int newVersion) {
        try {
            // drop event table if already exists
            //db.execSQL("DROP TABLE IF EXISTS users");
            //db.execSQL("DROP TABLE IF EXISTS events");
        } catch (Throwable t) {
            t.printStackTrace();
        }
        //onCreate(sqLiteDatabase);
    }

    public void createEvent(User user, Event event) {

        try {
            // make values to be inserted
            ContentValues values = new ContentValues();
            values.put(EVENT_COLUMN_EVENT_TYPE, event.getEventType().toString());
            values.put(EVENT_COLUMN_DESCRIPTION, event.getDescription());
            values.put(EVENT_COLUMN_LOCATION, event.getLocation());
            values.put(EVENT_COLUMN_REGION, event.getRegion().toString());
            values.put(EVENT_COLUMN_RISK_LEVEL, event.getRiskLevel().toString());
            values.put(EVENT_COLUMN_USERID, user.getUsername());

            //images
            Bitmap image1 = event.getImg();
            if (image1 != null) {
                byte[] data = getBitmapAsByteArray(image1);
                if (data.length > 0) {
                    values.put(EVENT_COLUMN_IMAGE, data);
                }
            }
            // insert event
            db.insert(TABLE_EVENTS_NAME, null, values);
        } catch (Throwable t) {
            t.printStackTrace();
        }
    }

    //?????????
    private byte[] getBitmapAsByteArray(Bitmap bitmap) {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.PNG, 0, outputStream);
        return outputStream.toByteArray();
    }
    //????????

    //?????
    public void createUser(User user) {
        try {
            // make values to be inserted
            ContentValues values = new ContentValues();
            values.put(USER_COLUMN_ID, user.getUsername());
            values.put(USER_COLUMN_Password, user.getPassword());

            // insert folder
            db.insert(TABLE_USER_NAME, null, values);
        } catch (Throwable t) {
            t.printStackTrace();
        }
    }

    public int updateEvent(Event event) {
        int cnt = 0;
        try {

            // make values to be inserted
            ContentValues values = new ContentValues();
            values.put(EVENT_COLUMN_EVENT_TYPE, event.getEventType().toString());
            values.put(EVENT_COLUMN_DESCRIPTION, event.getDescription());
            values.put(EVENT_COLUMN_LOCATION, event.getLocation());
            values.put(EVENT_COLUMN_REGION, event.getRegion().toString());
            values.put(EVENT_COLUMN_RISK_LEVEL, event.getRiskLevel().toString());


            //images
            Bitmap image1 = event.getImg();
            if (image1 != null) {
                byte[] data = getBitmapAsByteArray(image1);
                if (data != null && data.length > 0) {
                    values.put(EVENT_COLUMN_IMAGE, data);
                }
            } else {
                values.putNull(EVENT_COLUMN_IMAGE);
            }
/*
צריךך לשאול על EVENT_COLUMN_ID???!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
 */
            // update
            String parameters[] = new String[]{String.valueOf(event.getId())};
            cnt = db.update(TABLE_EVENTS_NAME,
                    values,
                    EVENT_COLUMN_ID + " = ?",
                    parameters
            );
        } catch (Throwable t) {
            t.printStackTrace();
        }
        return cnt;
    }

    public void deleteEvent(Event event) {

        try {
// ?????????????????????????????!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!איך יכול לדעת את EVENT_COLUMN_ID כי זה מספר רץ

            // delete event
            db.delete(TABLE_EVENTS_NAME, EVENT_COLUMN_ID + " = ?",
                    new String[]{String.valueOf(event.getId())});
        } catch (Throwable t) {
            t.printStackTrace();
        }
    }
    public List<Event> getAllEvents() {
        List<Event> result = new ArrayList<>();
        Cursor cursor = null;
        try {
            cursor = db.query(TABLE_EVENTS_NAME,
                    TABLE_EVENT_COLUMNS,
                    null, null,
                    null, null, null);

            cursor.moveToFirst();
            while (!cursor.isAfterLast()) {
                Event event = cursorToEvent(cursor);
                result.add(event);
                cursor.moveToNext();
            }
        } catch (Throwable t) {
            t.printStackTrace();
        } finally {
            // make sure to close the cursor
            if (cursor != null) {
                cursor.close();
            }
        }
        return result;
    }

    private Event cursorToEvent(Cursor cursor) {
        Event result = new Event();
        try {

            result.setId(cursor.getInt(0));
            result.setEventType(EventType.valueOf(cursor.getString(1)));

            //images
            byte[] img1Byte = cursor.getBlob(2);
            if (img1Byte != null && img1Byte.length > 0) {
                Bitmap image1 = BitmapFactory.decodeByteArray(img1Byte, 0, img1Byte.length);
                if (image1 != null) {
                    result.setImg(image1);
                }
            }

            result.setDescription(cursor.getString(3));
            result.setLocation(cursor.getString(4));
            result.setRegion(Region.valueOf(cursor.getString(5)));
            result.setRiskLevel(RiskLevel.valueOf(cursor.getString(6)));
            result.setUserID(cursor.getString(7));

        } catch (Throwable t) {
            t.printStackTrace();
        }
        return result;
    }

//    public List<User> getAllUser() {}
//    public User cursorToUser() {}

    /**
     * שאליתה שנותנת את כל האירועים עבור משתמש ספציפי
     *
     * @param user
     * @return ArrayList contains all the events for user
     */
    public List<Event> getAllEventsOfUser(User user) {
        List<Event> result = new ArrayList<>();
        Cursor cursor = null;
        try {
            String userId = user.getUsername();
            cursor = db.query(TABLE_EVENTS_NAME, TABLE_EVENT_COLUMNS, EVENT_COLUMN_USERID + " = ?",
                    new String[]{String.valueOf(userId)}, null, null,
                    null, null);

            if (cursor != null && cursor.getCount() > 0) {
                cursor.moveToFirst();
                while (!cursor.isAfterLast()) {
                    Event event = cursorToEvent(cursor);
                    result.add(event);
                    cursor.moveToNext();
                }
            }
        } catch (Throwable t) {
            t.printStackTrace();
        } finally {
            if (cursor != null) {
                // make sure to close the cursor
                cursor.close();
            }
        }
        return result;
    }

// we want to add a field of Approved in Users --------------------------------------------------

    public List<Event> getAllEventsThatUserApproved(User user){
        List<Event> result = new ArrayList<>();
        Cursor cursor = null;
        try {
            String userId = user.getUsername();
            cursor = db.query(TABLE_EVENTS_NAME, TABLE_EVENT_COLUMNS, EVENT_COLUMN_USERID + " = ?",
                    new String[]{String.valueOf(userId)}, null, null,
                    null, null);

            if (cursor != null && cursor.getCount() > 0) {
                cursor.moveToFirst();
                while (!cursor.isAfterLast()) {
                    Event event = cursorToEvent(cursor);
                    result.add(event);
                    cursor.moveToNext();
                }
            }
        } catch (Throwable t) {
            t.printStackTrace();
        } finally {
            if (cursor != null) {
                // make sure to close the cursor
                cursor.close();
            }
        }
        return result;
    }




/////////////////////////////////////////////////////////////////////////////////////////////////////
    public void open() {
        try {
            db = getWritableDatabase();
        } catch (Throwable t) {
            t.printStackTrace();
        }
    }

    public void close() {
        try {
            db.close();
        } catch (Throwable t) {
            t.printStackTrace();
        }
    }


}
