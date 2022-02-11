package com.aye10032.tctodolist.tctodolistserver.dao;

import com.aye10032.tctodolist.tctodolistserver.pojo.Task;
import com.aye10032.tctodolist.tctodolistserver.pojo.TaskExample;
import com.aye10032.tctodolist.tctodolistserver.pojo.TaskExample.Criteria;
import com.aye10032.tctodolist.tctodolistserver.pojo.TaskExample.Criterion;
import org.apache.ibatis.jdbc.SQL;

import java.util.List;
import java.util.Map;

public class TaskSqlProvider {
    public String countByExample(TaskExample example) {
        SQL sql = new SQL();
        sql.SELECT("count(*)").FROM("todo_task");
        applyWhere(sql, example, false);
        return sql.toString();
    }

    public String deleteByExample(TaskExample example) {
        SQL sql = new SQL();
        sql.DELETE_FROM("todo_task");
        applyWhere(sql, example, false);
        return sql.toString();
    }

    public String insertSelective(Task record) {
        SQL sql = new SQL();
        sql.INSERT_INTO("todo_task");
        
        if (record.getName() != null) {
            sql.VALUES("name", "#{name,jdbcType=VARCHAR}");
        }
        
        if (record.getPos() != null) {
            sql.VALUES("pos", "#{pos,jdbcType=VARCHAR}");
        }
        
        if (record.getOwner() != null) {
            sql.VALUES("owner", "#{owner,jdbcType=INTEGER}");
        }
        
        if (record.getTime() != null) {
            sql.VALUES("time", "#{time,jdbcType=NUMERIC}");
        }
        
        if (record.getLastUpdateTime() != null) {
            sql.VALUES("last_update_time", "#{lastUpdateTime,jdbcType=NUMERIC}");
        }
        
        if (record.getGroup() != null) {
            sql.VALUES("group", "#{group,jdbcType=INTEGER}");
        }
        
        if (record.getStatus() != null) {
            sql.VALUES("status", "#{status,jdbcType=INTEGER}");
        }
        
        if (record.getUndertakerList() != null) {
            sql.VALUES("undertaker_list", "#{undertakerList,jdbcType=VARCHAR}");
        }
        
        return sql.toString();
    }

    public String selectByExample(TaskExample example) {
        SQL sql = new SQL();
        if (example != null && example.isDistinct()) {
            sql.SELECT_DISTINCT("id");
        } else {
            sql.SELECT("id");
        }
        sql.SELECT("name");
        sql.SELECT("pos");
        sql.SELECT("owner");
        sql.SELECT("time");
        sql.SELECT("last_update_time");
        sql.SELECT("group");
        sql.SELECT("status");
        sql.SELECT("undertaker_list");
        sql.FROM("todo_task");
        applyWhere(sql, example, false);
        
        if (example != null && example.getOrderByClause() != null) {
            sql.ORDER_BY(example.getOrderByClause());
        }
        
        return sql.toString();
    }

    public String updateByExampleSelective(Map<String, Object> parameter) {
        Task record = (Task) parameter.get("record");
        TaskExample example = (TaskExample) parameter.get("example");
        
        SQL sql = new SQL();
        sql.UPDATE("todo_task");
        
        if (record.getId() != null) {
            sql.SET("id = #{record.id,jdbcType=INTEGER}");
        }
        
        if (record.getName() != null) {
            sql.SET("name = #{record.name,jdbcType=VARCHAR}");
        }
        
        if (record.getPos() != null) {
            sql.SET("pos = #{record.pos,jdbcType=VARCHAR}");
        }
        
        if (record.getOwner() != null) {
            sql.SET("owner = #{record.owner,jdbcType=INTEGER}");
        }
        
        if (record.getTime() != null) {
            sql.SET("time = #{record.time,jdbcType=NUMERIC}");
        }
        
        if (record.getLastUpdateTime() != null) {
            sql.SET("last_update_time = #{record.lastUpdateTime,jdbcType=NUMERIC}");
        }
        
        if (record.getGroup() != null) {
            sql.SET("group = #{record.group,jdbcType=INTEGER}");
        }
        
        if (record.getStatus() != null) {
            sql.SET("status = #{record.status,jdbcType=INTEGER}");
        }
        
        if (record.getUndertakerList() != null) {
            sql.SET("undertaker_list = #{record.undertakerList,jdbcType=VARCHAR}");
        }
        
        applyWhere(sql, example, true);
        return sql.toString();
    }

    public String updateByExample(Map<String, Object> parameter) {
        SQL sql = new SQL();
        sql.UPDATE("todo_task");
        
        sql.SET("id = #{record.id,jdbcType=INTEGER}");
        sql.SET("name = #{record.name,jdbcType=VARCHAR}");
        sql.SET("pos = #{record.pos,jdbcType=VARCHAR}");
        sql.SET("owner = #{record.owner,jdbcType=INTEGER}");
        sql.SET("time = #{record.time,jdbcType=NUMERIC}");
        sql.SET("last_update_time = #{record.lastUpdateTime,jdbcType=NUMERIC}");
        sql.SET("group = #{record.group,jdbcType=INTEGER}");
        sql.SET("status = #{record.status,jdbcType=INTEGER}");
        sql.SET("undertaker_list = #{record.undertakerList,jdbcType=VARCHAR}");
        
        TaskExample example = (TaskExample) parameter.get("example");
        applyWhere(sql, example, true);
        return sql.toString();
    }

    public String updateByPrimaryKeySelective(Task record) {
        SQL sql = new SQL();
        sql.UPDATE("todo_task");
        
        if (record.getName() != null) {
            sql.SET("name = #{name,jdbcType=VARCHAR}");
        }
        
        if (record.getPos() != null) {
            sql.SET("pos = #{pos,jdbcType=VARCHAR}");
        }
        
        if (record.getOwner() != null) {
            sql.SET("owner = #{owner,jdbcType=INTEGER}");
        }
        
        if (record.getTime() != null) {
            sql.SET("time = #{time,jdbcType=NUMERIC}");
        }
        
        if (record.getLastUpdateTime() != null) {
            sql.SET("last_update_time = #{lastUpdateTime,jdbcType=NUMERIC}");
        }
        
        if (record.getGroup() != null) {
            sql.SET("group = #{group,jdbcType=INTEGER}");
        }
        
        if (record.getStatus() != null) {
            sql.SET("status = #{status,jdbcType=INTEGER}");
        }
        
        if (record.getUndertakerList() != null) {
            sql.SET("undertaker_list = #{undertakerList,jdbcType=VARCHAR}");
        }
        
        sql.WHERE("id = #{id,jdbcType=INTEGER}");
        
        return sql.toString();
    }

    protected void applyWhere(SQL sql, TaskExample example, boolean includeExamplePhrase) {
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