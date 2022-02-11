package com.aye10032.tctodolist.tctodolistserver.dao;

import com.aye10032.tctodolist.tctodolistserver.pojo.Message;
import com.aye10032.tctodolist.tctodolistserver.pojo.MessageExample;
import com.aye10032.tctodolist.tctodolistserver.pojo.MessageExample.Criteria;
import com.aye10032.tctodolist.tctodolistserver.pojo.MessageExample.Criterion;
import org.apache.ibatis.jdbc.SQL;

import java.util.List;
import java.util.Map;

public class MessageSqlProvider {
    public String countByExample(MessageExample example) {
        SQL sql = new SQL();
        sql.SELECT("count(*)").FROM("todo_message");
        applyWhere(sql, example, false);
        return sql.toString();
    }

    public String deleteByExample(MessageExample example) {
        SQL sql = new SQL();
        sql.DELETE_FROM("todo_message");
        applyWhere(sql, example, false);
        return sql.toString();
    }

    public String insertSelective(Message record) {
        SQL sql = new SQL();
        sql.INSERT_INTO("todo_message");

        if (record.getFromPlayer() != null) {
            sql.VALUES("from_player", "#{fromPlayer,jdbcType=INTEGER}");
        }

        if (record.getTargetPlayer() != null) {
            sql.VALUES("target_player", "#{targetPlayer,jdbcType=INTEGER}");
        }

        if (record.getSendTime() != null) {
            sql.VALUES("send_time", "#{sendTime,jdbcType=NUMERIC}");
        }

        if (record.getLastUpdateTime() != null) {
            sql.VALUES("last_update_time", "#{lastUpdateTime,jdbcType=NUMERIC}");
        }

        if (record.getMsg() != null) {
            sql.VALUES("msg", "#{msg,jdbcType=VARCHAR}");
        }

        if (record.getHasRead() != null) {
            sql.VALUES("has_read", "#{hasRead,jdbcType=BOOLEAN}");
        }

        if (record.getFromTodo() != null) {
            sql.VALUES("from_todo", "#{fromTodo,jdbcType=INTEGER}");
        }

        return sql.toString();
    }

    public String selectByExample(MessageExample example) {
        SQL sql = new SQL();
        if (example != null && example.isDistinct()) {
            sql.SELECT_DISTINCT("id");
        } else {
            sql.SELECT("id");
        }
        sql.SELECT("from_player");
        sql.SELECT("target_player");
        sql.SELECT("send_time");
        sql.SELECT("last_update_time");
        sql.SELECT("msg");
        sql.SELECT("has_read");
        sql.SELECT("from_todo");
        sql.FROM("todo_message");
        applyWhere(sql, example, false);

        if (example != null && example.getOrderByClause() != null) {
            sql.ORDER_BY(example.getOrderByClause());
        }

        return sql.toString();
    }

    public String updateByExampleSelective(Map<String, Object> parameter) {
        Message record = (Message) parameter.get("record");
        MessageExample example = (MessageExample) parameter.get("example");

        SQL sql = new SQL();
        sql.UPDATE("todo_message");

        if (record.getId() != null) {
            sql.SET("id = #{record.id,jdbcType=INTEGER}");
        }

        if (record.getFromPlayer() != null) {
            sql.SET("from_player = #{record.fromPlayer,jdbcType=INTEGER}");
        }

        if (record.getTargetPlayer() != null) {
            sql.SET("target_player = #{record.targetPlayer,jdbcType=INTEGER}");
        }

        if (record.getSendTime() != null) {
            sql.SET("send_time = #{record.sendTime,jdbcType=NUMERIC}");
        }

        if (record.getLastUpdateTime() != null) {
            sql.SET("last_update_time = #{record.lastUpdateTime,jdbcType=NUMERIC}");
        }

        if (record.getMsg() != null) {
            sql.SET("msg = #{record.msg,jdbcType=VARCHAR}");
        }

        if (record.getHasRead() != null) {
            sql.SET("has_read = #{record.hasRead,jdbcType=BOOLEAN}");
        }

        if (record.getFromTodo() != null) {
            sql.SET("from_todo = #{record.fromTodo,jdbcType=INTEGER}");
        }

        applyWhere(sql, example, true);
        return sql.toString();
    }

    public String updateByExample(Map<String, Object> parameter) {
        SQL sql = new SQL();
        sql.UPDATE("todo_message");

        sql.SET("id = #{record.id,jdbcType=INTEGER}");
        sql.SET("from_player = #{record.fromPlayer,jdbcType=INTEGER}");
        sql.SET("target_player = #{record.targetPlayer,jdbcType=INTEGER}");
        sql.SET("send_time = #{record.sendTime,jdbcType=NUMERIC}");
        sql.SET("last_update_time = #{record.lastUpdateTime,jdbcType=NUMERIC}");
        sql.SET("msg = #{record.msg,jdbcType=VARCHAR}");
        sql.SET("has_read = #{record.hasRead,jdbcType=BOOLEAN}");
        sql.SET("from_todo = #{record.fromTodo,jdbcType=INTEGER}");

        MessageExample example = (MessageExample) parameter.get("example");
        applyWhere(sql, example, true);
        return sql.toString();
    }

    public String updateByPrimaryKeySelective(Message record) {
        SQL sql = new SQL();
        sql.UPDATE("todo_message");

        if (record.getFromPlayer() != null) {
            sql.SET("from_player = #{fromPlayer,jdbcType=INTEGER}");
        }

        if (record.getTargetPlayer() != null) {
            sql.SET("target_player = #{targetPlayer,jdbcType=INTEGER}");
        }

        if (record.getSendTime() != null) {
            sql.SET("send_time = #{sendTime,jdbcType=NUMERIC}");
        }

        if (record.getLastUpdateTime() != null) {
            sql.SET("last_update_time = #{lastUpdateTime,jdbcType=NUMERIC}");
        }

        if (record.getMsg() != null) {
            sql.SET("msg = #{msg,jdbcType=VARCHAR}");
        }

        if (record.getHasRead() != null) {
            sql.SET("has_read = #{hasRead,jdbcType=BOOLEAN}");
        }

        if (record.getFromTodo() != null) {
            sql.SET("from_todo = #{fromTodo,jdbcType=INTEGER}");
        }

        sql.WHERE("id = #{id,jdbcType=INTEGER}");

        return sql.toString();
    }

    protected void applyWhere(SQL sql, MessageExample example, boolean includeExamplePhrase) {
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
                            sb.append(String.format(parmPhrase1_th, criterion.getCondition(), i, j, criterion.getTypeHandler()));
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