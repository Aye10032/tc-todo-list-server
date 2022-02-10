package com.aye10032.tctodolist.tctodolistserver.handler;

import org.apache.commons.lang3.StringUtils;
import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.MappedJdbcTypes;
import org.apache.ibatis.type.MappedTypes;
import org.apache.ibatis.type.TypeHandler;
import org.mybatis.generator.internal.types.JavaTypeResolverDefaultImpl;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @program: tc-todo-list-server
 * @className: ListToVarcharTypeHandler
 * @Description: List类型转换
 * @version: v1.0
 * @author: Aye10032
 * @date: 2022/2/10 下午 2:04
 */
@MappedJdbcTypes(JdbcType.VARCHAR)
@MappedTypes(List.class)
public class ListToVarcharTypeHandler implements TypeHandler<List<Integer>> {

    @Override
    public void setParameter(PreparedStatement ps, int i, List<Integer> parameter, JdbcType jdbcType) throws SQLException {
        StringBuffer sb = new StringBuffer();
        if (!parameter.isEmpty()) {
            for (Integer integer : parameter) {
                sb.append(integer).append(",");
            }
            String substring = sb.substring(0, sb.length() - 1);
            ps.setString(i, substring);
        } else {
            ps.setString(i, "");
        }
    }

    @Override
    public List<Integer> getResult(ResultSet rs, String columnName) throws SQLException {
        String resultString = rs.getString(columnName);
        if (StringUtils.isNotEmpty(resultString)) {
            return StringsToInts(resultString);
        }
        return null;
    }

    @Override
    public List<Integer> getResult(ResultSet rs, int columnIndex) throws SQLException {
        String resultString = rs.getString(columnIndex);
        if (StringUtils.isNotEmpty(resultString)) {
            return StringsToInts(resultString);
        }
        return null;
    }

    @Override
    public List<Integer> getResult(CallableStatement cs, int columnIndex) throws SQLException {
        String resultString = cs.getString(columnIndex);
        if (StringUtils.isNotEmpty(resultString)) {
            return StringsToInts(resultString);
        }
        return null;
    }

    private List<Integer> StringsToInts(String strings) {
        List<Integer> result = new ArrayList<>();
        for (String string : strings.split(",")) {
            result.add(Integer.parseInt(string));
        }
        return result;
    }

}
