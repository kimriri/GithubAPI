package com.programmers.githubapiRepository.data;

import android.database.Cursor;
import android.os.CancellationSignal;
import androidx.room.CoroutinesRoom;
import androidx.room.EntityDeletionOrUpdateAdapter;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import java.lang.Class;
import java.lang.Exception;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Callable;
import kotlin.Unit;
import kotlin.coroutines.Continuation;

@SuppressWarnings({"unchecked", "deprecation"})
public final class LocalUsersDataDAO_Impl implements LocalUsersDataDAO {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<UsersData> __insertionAdapterOfUsersData;

  private final EntityDeletionOrUpdateAdapter<UsersData> __updateAdapterOfUsersData;

  public LocalUsersDataDAO_Impl(RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfUsersData = new EntityInsertionAdapter<UsersData>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR REPLACE INTO `LOCALUSERSDATE` (`id`,`search`,`login`,`avatar_url`,`favorite`) VALUES (nullif(?, 0),?,?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, UsersData value) {
        stmt.bindLong(1, value.getId());
        if (value.getSearch() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getSearch());
        }
        if (value.getLogin() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getLogin());
        }
        if (value.getAvatar_url() == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindString(4, value.getAvatar_url());
        }
        final int _tmp = value.getFavorite() ? 1 : 0;
        stmt.bindLong(5, _tmp);
      }
    };
    this.__updateAdapterOfUsersData = new EntityDeletionOrUpdateAdapter<UsersData>(__db) {
      @Override
      public String createQuery() {
        return "UPDATE OR ABORT `LOCALUSERSDATE` SET `id` = ?,`search` = ?,`login` = ?,`avatar_url` = ?,`favorite` = ? WHERE `id` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, UsersData value) {
        stmt.bindLong(1, value.getId());
        if (value.getSearch() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getSearch());
        }
        if (value.getLogin() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getLogin());
        }
        if (value.getAvatar_url() == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindString(4, value.getAvatar_url());
        }
        final int _tmp = value.getFavorite() ? 1 : 0;
        stmt.bindLong(5, _tmp);
        stmt.bindLong(6, value.getId());
      }
    };
  }

  @Override
  public Object insert(final UsersData user, final Continuation<? super Unit> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __insertionAdapterOfUsersData.insert(user);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, $completion);
  }

  @Override
  public Object updateUser(final UsersData user, final Continuation<? super Unit> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __updateAdapterOfUsersData.handle(user);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, $completion);
  }

  @Override
  public Object getAllUsers(final Continuation<? super List<UsersData>> $completion) {
    final String _sql = "SELECT * FROM LOCALUSERSDATE";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    final CancellationSignal _cancellationSignal = DBUtil.createCancellationSignal();
    return CoroutinesRoom.execute(__db, false, _cancellationSignal, new Callable<List<UsersData>>() {
      @Override
      public List<UsersData> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfSearch = CursorUtil.getColumnIndexOrThrow(_cursor, "search");
          final int _cursorIndexOfLogin = CursorUtil.getColumnIndexOrThrow(_cursor, "login");
          final int _cursorIndexOfAvatarUrl = CursorUtil.getColumnIndexOrThrow(_cursor, "avatar_url");
          final int _cursorIndexOfFavorite = CursorUtil.getColumnIndexOrThrow(_cursor, "favorite");
          final List<UsersData> _result = new ArrayList<UsersData>(_cursor.getCount());
          while(_cursor.moveToNext()) {
            final UsersData _item;
            final int _tmpId;
            _tmpId = _cursor.getInt(_cursorIndexOfId);
            final String _tmpSearch;
            if (_cursor.isNull(_cursorIndexOfSearch)) {
              _tmpSearch = null;
            } else {
              _tmpSearch = _cursor.getString(_cursorIndexOfSearch);
            }
            final String _tmpLogin;
            if (_cursor.isNull(_cursorIndexOfLogin)) {
              _tmpLogin = null;
            } else {
              _tmpLogin = _cursor.getString(_cursorIndexOfLogin);
            }
            final String _tmpAvatar_url;
            if (_cursor.isNull(_cursorIndexOfAvatarUrl)) {
              _tmpAvatar_url = null;
            } else {
              _tmpAvatar_url = _cursor.getString(_cursorIndexOfAvatarUrl);
            }
            final boolean _tmpFavorite;
            final int _tmp;
            _tmp = _cursor.getInt(_cursorIndexOfFavorite);
            _tmpFavorite = _tmp != 0;
            _item = new UsersData(_tmpId,_tmpSearch,_tmpLogin,_tmpAvatar_url,_tmpFavorite);
            _result.add(_item);
          }
          return _result;
        } finally {
          _cursor.close();
          _statement.release();
        }
      }
    }, $completion);
  }

  @Override
  public Object getUser(final String search,
      final Continuation<? super List<UsersData>> $completion) {
    final String _sql = "SELECT * FROM LOCALUSERSDATE WHERE search = ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (search == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, search);
    }
    final CancellationSignal _cancellationSignal = DBUtil.createCancellationSignal();
    return CoroutinesRoom.execute(__db, false, _cancellationSignal, new Callable<List<UsersData>>() {
      @Override
      public List<UsersData> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfSearch = CursorUtil.getColumnIndexOrThrow(_cursor, "search");
          final int _cursorIndexOfLogin = CursorUtil.getColumnIndexOrThrow(_cursor, "login");
          final int _cursorIndexOfAvatarUrl = CursorUtil.getColumnIndexOrThrow(_cursor, "avatar_url");
          final int _cursorIndexOfFavorite = CursorUtil.getColumnIndexOrThrow(_cursor, "favorite");
          final List<UsersData> _result = new ArrayList<UsersData>(_cursor.getCount());
          while(_cursor.moveToNext()) {
            final UsersData _item;
            final int _tmpId;
            _tmpId = _cursor.getInt(_cursorIndexOfId);
            final String _tmpSearch;
            if (_cursor.isNull(_cursorIndexOfSearch)) {
              _tmpSearch = null;
            } else {
              _tmpSearch = _cursor.getString(_cursorIndexOfSearch);
            }
            final String _tmpLogin;
            if (_cursor.isNull(_cursorIndexOfLogin)) {
              _tmpLogin = null;
            } else {
              _tmpLogin = _cursor.getString(_cursorIndexOfLogin);
            }
            final String _tmpAvatar_url;
            if (_cursor.isNull(_cursorIndexOfAvatarUrl)) {
              _tmpAvatar_url = null;
            } else {
              _tmpAvatar_url = _cursor.getString(_cursorIndexOfAvatarUrl);
            }
            final boolean _tmpFavorite;
            final int _tmp;
            _tmp = _cursor.getInt(_cursorIndexOfFavorite);
            _tmpFavorite = _tmp != 0;
            _item = new UsersData(_tmpId,_tmpSearch,_tmpLogin,_tmpAvatar_url,_tmpFavorite);
            _result.add(_item);
          }
          return _result;
        } finally {
          _cursor.close();
          _statement.release();
        }
      }
    }, $completion);
  }

  @Override
  public Object getUserId(final String login,
      final Continuation<? super List<UsersData>> $completion) {
    final String _sql = "SELECT * FROM LOCALUSERSDATE WHERE login = ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (login == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, login);
    }
    final CancellationSignal _cancellationSignal = DBUtil.createCancellationSignal();
    return CoroutinesRoom.execute(__db, false, _cancellationSignal, new Callable<List<UsersData>>() {
      @Override
      public List<UsersData> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfSearch = CursorUtil.getColumnIndexOrThrow(_cursor, "search");
          final int _cursorIndexOfLogin = CursorUtil.getColumnIndexOrThrow(_cursor, "login");
          final int _cursorIndexOfAvatarUrl = CursorUtil.getColumnIndexOrThrow(_cursor, "avatar_url");
          final int _cursorIndexOfFavorite = CursorUtil.getColumnIndexOrThrow(_cursor, "favorite");
          final List<UsersData> _result = new ArrayList<UsersData>(_cursor.getCount());
          while(_cursor.moveToNext()) {
            final UsersData _item;
            final int _tmpId;
            _tmpId = _cursor.getInt(_cursorIndexOfId);
            final String _tmpSearch;
            if (_cursor.isNull(_cursorIndexOfSearch)) {
              _tmpSearch = null;
            } else {
              _tmpSearch = _cursor.getString(_cursorIndexOfSearch);
            }
            final String _tmpLogin;
            if (_cursor.isNull(_cursorIndexOfLogin)) {
              _tmpLogin = null;
            } else {
              _tmpLogin = _cursor.getString(_cursorIndexOfLogin);
            }
            final String _tmpAvatar_url;
            if (_cursor.isNull(_cursorIndexOfAvatarUrl)) {
              _tmpAvatar_url = null;
            } else {
              _tmpAvatar_url = _cursor.getString(_cursorIndexOfAvatarUrl);
            }
            final boolean _tmpFavorite;
            final int _tmp;
            _tmp = _cursor.getInt(_cursorIndexOfFavorite);
            _tmpFavorite = _tmp != 0;
            _item = new UsersData(_tmpId,_tmpSearch,_tmpLogin,_tmpAvatar_url,_tmpFavorite);
            _result.add(_item);
          }
          return _result;
        } finally {
          _cursor.close();
          _statement.release();
        }
      }
    }, $completion);
  }

  public static List<Class<?>> getRequiredConverters() {
    return Collections.emptyList();
  }
}
