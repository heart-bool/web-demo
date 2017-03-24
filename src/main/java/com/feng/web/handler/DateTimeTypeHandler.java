/**
 * Created by Administrator on 2017/3/24.
 */

package com.feng.web.handler;

import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;
import org.joda.time.DateTime;

import java.sql.*;

/***
 * @Description:
 *
 * @ClassName: DateTimeTypeHandler
 * @Author: FENG WANG
 * @Email: <email>18908069164@163.com</email>
 * @Date 2017/3/24 9:17
 */
public class DateTimeTypeHandler extends BaseTypeHandler<DateTime> {
    public DateTimeTypeHandler() {
    }

    public void setNonNullParameter(PreparedStatement ps, int i, DateTime parameter, JdbcType jdbcType) throws SQLException {
        ps.setTimestamp(i, new Timestamp(parameter.getMillis()));
    }

    public DateTime getNullableResult(ResultSet rs, String columnName) throws SQLException {
        Timestamp sqlTimestamp = rs.getTimestamp(columnName);
        return sqlTimestamp == null ? null : new DateTime(sqlTimestamp);
    }

    public DateTime getNullableResult(ResultSet rs, int columnIndex) throws SQLException {
        Timestamp sqlTimestamp = rs.getTimestamp(columnIndex);
        return sqlTimestamp == null ? null : new DateTime(sqlTimestamp);
    }

    public DateTime getNullableResult(CallableStatement cs, int columnIndex) throws SQLException {
        Timestamp sqlTimestamp = cs.getTimestamp(columnIndex);
        return sqlTimestamp == null ? null : new DateTime(sqlTimestamp);
    }
}
