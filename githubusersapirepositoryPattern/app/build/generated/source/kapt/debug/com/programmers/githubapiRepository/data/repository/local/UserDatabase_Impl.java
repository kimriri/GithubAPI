package com.programmers.githubapiRepository.data.repository.local;

import androidx.annotation.NonNull;
import androidx.room.DatabaseConfiguration;
import androidx.room.InvalidationTracker;
import androidx.room.RoomOpenHelper;
import androidx.room.RoomOpenHelper.Delegate;
import androidx.room.RoomOpenHelper.ValidationResult;
import androidx.room.migration.AutoMigrationSpec;
import androidx.room.migration.Migration;
import androidx.room.util.DBUtil;
import androidx.room.util.TableInfo;
import androidx.room.util.TableInfo.Column;
import androidx.room.util.TableInfo.ForeignKey;
import androidx.room.util.TableInfo.Index;
import androidx.sqlite.db.SupportSQLiteDatabase;
import androidx.sqlite.db.SupportSQLiteOpenHelper;
import androidx.sqlite.db.SupportSQLiteOpenHelper.Callback;
import androidx.sqlite.db.SupportSQLiteOpenHelper.Configuration;
import com.programmers.githubapiRepository.data.LocalUsersDataDAO;
import com.programmers.githubapiRepository.data.LocalUsersDataDAO_Impl;
import java.lang.Class;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

@SuppressWarnings({"unchecked", "deprecation"})
public final class UserDatabase_Impl extends UserDatabase {
  private volatile LocalUsersDataDAO _localUsersDataDAO;

  @Override
  protected SupportSQLiteOpenHelper createOpenHelper(DatabaseConfiguration configuration) {
    final SupportSQLiteOpenHelper.Callback _openCallback = new RoomOpenHelper(configuration, new RoomOpenHelper.Delegate(1) {
      @Override
      public void createAllTables(SupportSQLiteDatabase _db) {
        _db.execSQL("CREATE TABLE IF NOT EXISTS `LOCALUSERSDATE` (`id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `search` TEXT NOT NULL, `login` TEXT NOT NULL, `avatar_url` TEXT NOT NULL, `favorite` INTEGER NOT NULL)");
        _db.execSQL("CREATE TABLE IF NOT EXISTS room_master_table (id INTEGER PRIMARY KEY,identity_hash TEXT)");
        _db.execSQL("INSERT OR REPLACE INTO room_master_table (id,identity_hash) VALUES(42, '9e49c3223d8add52a9b4fdba8c475400')");
      }

      @Override
      public void dropAllTables(SupportSQLiteDatabase _db) {
        _db.execSQL("DROP TABLE IF EXISTS `LOCALUSERSDATE`");
        if (mCallbacks != null) {
          for (int _i = 0, _size = mCallbacks.size(); _i < _size; _i++) {
            mCallbacks.get(_i).onDestructiveMigration(_db);
          }
        }
      }

      @Override
      public void onCreate(SupportSQLiteDatabase _db) {
        if (mCallbacks != null) {
          for (int _i = 0, _size = mCallbacks.size(); _i < _size; _i++) {
            mCallbacks.get(_i).onCreate(_db);
          }
        }
      }

      @Override
      public void onOpen(SupportSQLiteDatabase _db) {
        mDatabase = _db;
        internalInitInvalidationTracker(_db);
        if (mCallbacks != null) {
          for (int _i = 0, _size = mCallbacks.size(); _i < _size; _i++) {
            mCallbacks.get(_i).onOpen(_db);
          }
        }
      }

      @Override
      public void onPreMigrate(SupportSQLiteDatabase _db) {
        DBUtil.dropFtsSyncTriggers(_db);
      }

      @Override
      public void onPostMigrate(SupportSQLiteDatabase _db) {
      }

      @Override
      public RoomOpenHelper.ValidationResult onValidateSchema(SupportSQLiteDatabase _db) {
        final HashMap<String, TableInfo.Column> _columnsLOCALUSERSDATE = new HashMap<String, TableInfo.Column>(5);
        _columnsLOCALUSERSDATE.put("id", new TableInfo.Column("id", "INTEGER", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsLOCALUSERSDATE.put("search", new TableInfo.Column("search", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsLOCALUSERSDATE.put("login", new TableInfo.Column("login", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsLOCALUSERSDATE.put("avatar_url", new TableInfo.Column("avatar_url", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsLOCALUSERSDATE.put("favorite", new TableInfo.Column("favorite", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysLOCALUSERSDATE = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesLOCALUSERSDATE = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoLOCALUSERSDATE = new TableInfo("LOCALUSERSDATE", _columnsLOCALUSERSDATE, _foreignKeysLOCALUSERSDATE, _indicesLOCALUSERSDATE);
        final TableInfo _existingLOCALUSERSDATE = TableInfo.read(_db, "LOCALUSERSDATE");
        if (! _infoLOCALUSERSDATE.equals(_existingLOCALUSERSDATE)) {
          return new RoomOpenHelper.ValidationResult(false, "LOCALUSERSDATE(com.programmers.githubapiRepository.data.UsersData).\n"
                  + " Expected:\n" + _infoLOCALUSERSDATE + "\n"
                  + " Found:\n" + _existingLOCALUSERSDATE);
        }
        return new RoomOpenHelper.ValidationResult(true, null);
      }
    }, "9e49c3223d8add52a9b4fdba8c475400", "0d677e2fece4d9efd434a20e7d32d1e8");
    final SupportSQLiteOpenHelper.Configuration _sqliteConfig = SupportSQLiteOpenHelper.Configuration.builder(configuration.context)
        .name(configuration.name)
        .callback(_openCallback)
        .build();
    final SupportSQLiteOpenHelper _helper = configuration.sqliteOpenHelperFactory.create(_sqliteConfig);
    return _helper;
  }

  @Override
  protected InvalidationTracker createInvalidationTracker() {
    final HashMap<String, String> _shadowTablesMap = new HashMap<String, String>(0);
    HashMap<String, Set<String>> _viewTables = new HashMap<String, Set<String>>(0);
    return new InvalidationTracker(this, _shadowTablesMap, _viewTables, "LOCALUSERSDATE");
  }

  @Override
  public void clearAllTables() {
    super.assertNotMainThread();
    final SupportSQLiteDatabase _db = super.getOpenHelper().getWritableDatabase();
    try {
      super.beginTransaction();
      _db.execSQL("DELETE FROM `LOCALUSERSDATE`");
      super.setTransactionSuccessful();
    } finally {
      super.endTransaction();
      _db.query("PRAGMA wal_checkpoint(FULL)").close();
      if (!_db.inTransaction()) {
        _db.execSQL("VACUUM");
      }
    }
  }

  @Override
  protected Map<Class<?>, List<Class<?>>> getRequiredTypeConverters() {
    final HashMap<Class<?>, List<Class<?>>> _typeConvertersMap = new HashMap<Class<?>, List<Class<?>>>();
    _typeConvertersMap.put(LocalUsersDataDAO.class, LocalUsersDataDAO_Impl.getRequiredConverters());
    return _typeConvertersMap;
  }

  @Override
  public Set<Class<? extends AutoMigrationSpec>> getRequiredAutoMigrationSpecs() {
    final HashSet<Class<? extends AutoMigrationSpec>> _autoMigrationSpecsSet = new HashSet<Class<? extends AutoMigrationSpec>>();
    return _autoMigrationSpecsSet;
  }

  @Override
  public List<Migration> getAutoMigrations(
      @NonNull Map<Class<? extends AutoMigrationSpec>, AutoMigrationSpec> autoMigrationSpecsMap) {
    return Arrays.asList();
  }

  @Override
  public LocalUsersDataDAO localUsersDataDao() {
    if (_localUsersDataDAO != null) {
      return _localUsersDataDAO;
    } else {
      synchronized(this) {
        if(_localUsersDataDAO == null) {
          _localUsersDataDAO = new LocalUsersDataDAO_Impl(this);
        }
        return _localUsersDataDAO;
      }
    }
  }
}
