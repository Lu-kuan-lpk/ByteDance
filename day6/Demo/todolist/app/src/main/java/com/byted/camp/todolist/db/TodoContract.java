package com.byted.camp.todolist.db;

import android.provider.BaseColumns;

import com.byted.camp.todolist.beans.Note;
import com.byted.camp.todolist.beans.Priority;
import com.byted.camp.todolist.beans.State;

import java.util.Date;

public final class TodoContract {
    Note note;
    // TODO 1. 定义创建数据库以及升级的操作
//    public static final String SQL_CREATE_ENTRIES = "CREATE TABLE" +
//            todoentry.TABLE_NAME+"("
//            +todoentry._ID+" INTEGER PRIMARY KEY,"
//            +todoentry.COLUMN_CONTENT+" TEXT,"
//            +todoentry.COLUMN_DATE+" INTEGER,"
//            +todoentry.COLUMN_STATE+" INTEGER,"
//            +todoentry.COLUMN_PRIORITY+" INTEGER"+
//            ")";

    public static final String SQL_CREATE_ENTRIES =
            "CREATE TABLE " + todoentry.TABLE_NAME
                    + "(" + todoentry._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
            + todoentry.COLUMN_DATE + " INTEGER, "
            + todoentry.COLUMN_STATE + " INTEGER, "
            + todoentry.COLUMN_CONTENT + " TEXT, "
            + todoentry.COLUMN_PRIORITY + " INTEGER)";

    public static final String SQL_DELETE_ENTRIES =
            "DROP TABLE IF EXSITS"+ todoentry.TABLE_NAME;

    public static final String SQL_ADD_RECORDS =
            "ALTER TABLE " + todoentry.TABLE_NAME
                    + " ADD " + todoentry.COLUMN_PRIORITY + " INTEGER";

    private TodoContract() {}

    public static class todoentry implements BaseColumns{
        // TODO 2.此处定义表名以及列明
        public static final String TABLE_NAME = "note";

        public static final String COLUMN_DATE = "date";
        public static final String COLUMN_STATE = "state";
        public static final String COLUMN_CONTENT = "content";
        public static final String COLUMN_PRIORITY = "priority";
    }

}
