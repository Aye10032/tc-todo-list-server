package com.aye10032.tctodolist.tctodolistserver.dao;

import com.aye10032.tctodolist.tctodolistserver.pojo.Group;
import com.aye10032.tctodolist.tctodolistserver.pojo.GroupExample;
import com.aye10032.tctodolist.tctodolistserver.pojo.GroupExample.Criteria;
import com.aye10032.tctodolist.tctodolistserver.pojo.GroupExample.Criterion;
import org.apache.ibatis.jdbc.SQL;

import java.util.List;
import java.util.Map;

public class GroupSqlProvider {
    public String countByExample(GroupExample example) {
        SQL sql = new SQL();
        sql.SELECT("count(*)").FROM("todo_group");
        applyWhere(sql, example, false);
        return sql.toString();
    }

    public String deleteByExample(GroupExample example) {
        SQL sql = new SQL();
        sql.DELETE_FROM("todo_group");
        applyWhere(sql, example, false);
        return sql.toString();
    }

    public String insertSelective(Group record) {
        SQL sql = new SQL();
        sql.INSERT_INTO("todo_group");
        
        if (record.getOwner() != null) {
            sql.VALUES("owner", "#{owner,jdbcType=INTEGER}");
        }
        
        if (record.getName() != null) {
            sql.VALUES("name", "#{name,jdbcType=VARCHAR}");
        }
        
        if (record.getInformation() != null) {
            sql.VALUES("information", "#{information,jdbcType=VARCHAR}");
        }
        
        if (record.getAdmins() != null) {
            sql.VALUES("admins", "#{admins,jdbcType=VARCHAR,typeHandler=com.aye10032.tctodolist.tctodolistserver.handler.ListToVarcharTypeHandler}");
        }
        
        return sql.toString();
    }

    public String selectByExample(GroupExample example) {
        SQL sql = new SQL();
        if (example != null && example.isDistinct()) {
            sql.SELECT_DISTINCT("id");
        } else {
            sql.SELECT("id");
        }
        sql.SELECT("owner");
        sql.SELECT("name");
        sql.SELECT("information");
        sql.SELECT("admins");
        sql.FROM("todo_group");
        applyWhere(sql, example, false);
        
        if (example != null && example.getOrderByClause() != null) {
            sql.ORDER_BY(example.getOrderByClause());
        }
        
        return sql.toString();
    }

    public String updateByExampleSelective(Map<String, Object> parameter) {
        Group record = (Group) parameter.get("record");
        GroupExample example = (GroupExample) parameter.get("example");
        
        SQL sql = new SQL();
        sql.UPDATE("todo_group");
        
        if (record.getId() != null) {
            sql.SET("id = #{record.id,jdbcType=INTEGER}");
        }
        
        if (record.getOwner() != null) {
            sql.SET("owner = #{record.owner,jdbcType=INTEGER}");
        }
        
        if (record.getName() != null) {
            sql.SET("name = #{record.name,jdbcType=VARCHAR}");
        }
        
        if (record.getInformation() != null) {
            sql.SET("information = #{record.information,jdbcType=VARCHAR}");
        }
        
        if (record.getAdmins() != null) {
            sql.SET("admins = #{record.admins,jdbcType=VARCHAR,typeHandler=com.aye10032.tctodolist.tctodolistserver.handler.ListToVarcharTypeHandler}");
        }
        
        applyWhere(sql, example, true);
        return sql.toString();
    }

    public String updateByExample(Map<String, Object> parameter) {
        SQL sql = new SQL();
        sql.UPDATE("todo_group");
        
        sql.SET("id = #{record.id,jdbcType=INTEGER}");
        sql.SET("owner = #{record.owner,jdbcType=INTEGER}");
        sql.SET("name = #{record.name,jdbcType=VARCHAR}");
        sql.SET("information = #{record.information,jdbcType=VARCHAR}");
        sql.SET("admins = #{record.admins,jdbcType=VARCHAR,typeHandler=com.aye10032.tctodolist.tctodolistserver.handler.ListToVarcharTypeHandler}");
        
        GroupExample example = (GroupExample) parameter.get("example");
        applyWhere(sql, example, true);
        return sql.toString();
    }

    public String updateByPrimaryKeySelective(Group record) {
        SQL sql = new SQL();
        sql.UPDATE("todo_group");
        
        if (record.getOwner() != null) {
            sql.SET("owner = #{owner,jdbcType=INTEGER}");
        }
        
        if (record.getName() != null) {
            sql.SET("name = #{name,jdbcType=VARCHAR}");
        }
        
        if (record.getInformation() != null) {
            sql.SET("information = #{information,jdbcType=VARCHAR}");
        }
        
        if (record.getAdmins() != null) {
            sql.SET("admins = #{admins,jdbcType=VARCHAR,typeHandler=com.aye10032.tctodolist.tctodolistserver.handler.ListToVarcharTypeHandler}");
        }
        
        sql.WHERE("id = #{id,jdbcType=INTEGER}");
        
        return sql.toString();
    }

    protected void applyWhere(SQL sql, GroupExample example, boolean includeExamplePhrase) {
        if (example == null) {
            return;
        }
        
        String parmPhrase1;
        String parmPhrase1_th;
        String parmPhrase2;
        String parmPhrase2_th;
        String parmPhrase3;
        String parmPhrase3_th;
        if (includeExamplePhrase) {
            parmPhrase1 = "%s #{example.oredCriteria[%d].allCriteria[%d].value}";
            parmPhrase1_th = "%s #{example.oredCriteria[%d].allCriteria[%d].value,typeHandler=%s}";
            parmPhrase2 = "%s #{example.oredCriteria[%d].allCriteria[%d].value} and #{example.oredCriteria[%d].criteria[%d].secondValue}";
            parmPhrase2_th = "%s #{example.oredCriteria[%d].allCriteria[%d].value,typeHandler=%s} and #{example.oredCriteria[%d].criteria[%d].secondValue,typeHandler=%s}";
            parmPhrase3 = "#{example.oredCriteria[%d].allCriteria[%d].value[%d]}";
            parmPhrase3_th = "#{example.oredCriteria[%d].allCriteria[%d].value[%d],typeHandler=%s}";
        } else {
            parmPhrase1 = "%s #{oredCriteria[%d].allCriteria[%d].value}";
            parmPhrase1_th = "%s #{oredCriteria[%d].allCriteria[%d].value,typeHandler=%s}";
            parmPhrase2 = "%s #{oredCriteria[%d].allCriteria[%d].value} and #{oredCriteria[%d].criteria[%d].secondValue}";
            parmPhrase2_th = "%s #{oredCriteria[%d].allCriteria[%d].value,typeHandler=%s} and #{oredCriteria[%d].criteria[%d].secondValue,typeHandler=%s}";
            parmPhrase3 = "#{oredCriteria[%d].allCriteria[%d].value[%d]}";
            parmPhrase3_th = "#{oredCriteria[%d].allCriteria[%d].value[%d],typeHandler=%s}";
        }
        
        StringBuilder sb = new StringBuilder();
        List<Criteria> oredCriteria = example.getOredCriteria();
        boolean firstCriteria = true;
        for (int i = 0; i < oredCriteria.size(); i++) {
            Criteria criteria = oredCriteria.get(i);
            if (criteria.isValid()) {
                if (firstCriteria) {
                    firstCriteria = false;
                } else {
                    sb.append(" or ");
                }
                
                sb.append('(');
                List<Criterion> criterions = criteria.getAllCriteria();
                boolean firstCriterion = true;
                for (int j = 0; j < criterions.size(); j++) {
                    Criterion criterion = criterions.get(j);
                    if (firstCriterion) {
                        firstCriterion = false;
                    } else {
                        sb.append(" and ");
                    }
                    
                    if (criterion.isNoValue()) {
                        sb.append(criterion.getCondition());
                    } else if (criterion.isSingleValue()) {
                        if (criterion.getTypeHandler() == null) {
                            sb.append(String.format(parmPhrase1, criterion.getCondition(), i, j));
                        } else {
                            sb.append(String.format(parmPhrase1_th, criterion.getCondition(), i, j,criterion.getTypeHandler()));
                        }
                    } else if (criterion.isBetweenValue()) {
                        if (criterion.getTypeHandler() == null) {
                            sb.append(String.format(parmPhrase2, criterion.getCondition(), i, j, i, j));
                        } else {
                            sb.append(String.format(parmPhrase2_th, criterion.getCondition(), i, j, criterion.getTypeHandler(), i, j, criterion.getTypeHandler()));
                        }
                    } else if (criterion.isListValue()) {
                        sb.append(criterion.getCondition());
                        sb.append(" (");
                        List<?> listItems = (List<?>) criterion.getValue();
                        boolean comma = false;
                        for (int k = 0; k < listItems.size(); k++) {
                            if (comma) {
                                sb.append(", ");
                            } else {
                                comma = true;
                            }
                            if (criterion.getTypeHandler() == null) {
                                sb.append(String.format(parmPhrase3, i, j, k));
                            } else {
                                sb.append(String.format(parmPhrase3_th, i, j, k, criterion.getTypeHandler()));
                            }
                        }
                        sb.append(')');
                    }
                }
                sb.append(')');
            }
        }
        
        if (sb.length() > 0) {
            sql.WHERE(sb.toString());
        }
    }
}