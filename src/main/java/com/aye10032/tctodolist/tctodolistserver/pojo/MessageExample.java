package com.aye10032.tctodolist.tctodolistserver.pojo;

import java.util.ArrayList;
import java.util.List;

public class MessageExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public MessageExample() {
        oredCriteria = new ArrayList<>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    /**
     * @author Aye10032
     * @date 2022-02-11
     */
    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andIdIsNull() {
            addCriterion("id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Integer value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Integer value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Integer value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Integer value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Integer value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Integer> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Integer> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Integer value1, Integer value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Integer value1, Integer value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andFromPlayerIsNull() {
            addCriterion("from_player is null");
            return (Criteria) this;
        }

        public Criteria andFromPlayerIsNotNull() {
            addCriterion("from_player is not null");
            return (Criteria) this;
        }

        public Criteria andFromPlayerEqualTo(Integer value) {
            addCriterion("from_player =", value, "fromPlayer");
            return (Criteria) this;
        }

        public Criteria andFromPlayerNotEqualTo(Integer value) {
            addCriterion("from_player <>", value, "fromPlayer");
            return (Criteria) this;
        }

        public Criteria andFromPlayerGreaterThan(Integer value) {
            addCriterion("from_player >", value, "fromPlayer");
            return (Criteria) this;
        }

        public Criteria andFromPlayerGreaterThanOrEqualTo(Integer value) {
            addCriterion("from_player >=", value, "fromPlayer");
            return (Criteria) this;
        }

        public Criteria andFromPlayerLessThan(Integer value) {
            addCriterion("from_player <", value, "fromPlayer");
            return (Criteria) this;
        }

        public Criteria andFromPlayerLessThanOrEqualTo(Integer value) {
            addCriterion("from_player <=", value, "fromPlayer");
            return (Criteria) this;
        }

        public Criteria andFromPlayerIn(List<Integer> values) {
            addCriterion("from_player in", values, "fromPlayer");
            return (Criteria) this;
        }

        public Criteria andFromPlayerNotIn(List<Integer> values) {
            addCriterion("from_player not in", values, "fromPlayer");
            return (Criteria) this;
        }

        public Criteria andFromPlayerBetween(Integer value1, Integer value2) {
            addCriterion("from_player between", value1, value2, "fromPlayer");
            return (Criteria) this;
        }

        public Criteria andFromPlayerNotBetween(Integer value1, Integer value2) {
            addCriterion("from_player not between", value1, value2, "fromPlayer");
            return (Criteria) this;
        }

        public Criteria andTargetPlayerIsNull() {
            addCriterion("target_player is null");
            return (Criteria) this;
        }

        public Criteria andTargetPlayerIsNotNull() {
            addCriterion("target_player is not null");
            return (Criteria) this;
        }

        public Criteria andTargetPlayerEqualTo(Integer value) {
            addCriterion("target_player =", value, "targetPlayer");
            return (Criteria) this;
        }

        public Criteria andTargetPlayerNotEqualTo(Integer value) {
            addCriterion("target_player <>", value, "targetPlayer");
            return (Criteria) this;
        }

        public Criteria andTargetPlayerGreaterThan(Integer value) {
            addCriterion("target_player >", value, "targetPlayer");
            return (Criteria) this;
        }

        public Criteria andTargetPlayerGreaterThanOrEqualTo(Integer value) {
            addCriterion("target_player >=", value, "targetPlayer");
            return (Criteria) this;
        }

        public Criteria andTargetPlayerLessThan(Integer value) {
            addCriterion("target_player <", value, "targetPlayer");
            return (Criteria) this;
        }

        public Criteria andTargetPlayerLessThanOrEqualTo(Integer value) {
            addCriterion("target_player <=", value, "targetPlayer");
            return (Criteria) this;
        }

        public Criteria andTargetPlayerIn(List<Integer> values) {
            addCriterion("target_player in", values, "targetPlayer");
            return (Criteria) this;
        }

        public Criteria andTargetPlayerNotIn(List<Integer> values) {
            addCriterion("target_player not in", values, "targetPlayer");
            return (Criteria) this;
        }

        public Criteria andTargetPlayerBetween(Integer value1, Integer value2) {
            addCriterion("target_player between", value1, value2, "targetPlayer");
            return (Criteria) this;
        }

        public Criteria andTargetPlayerNotBetween(Integer value1, Integer value2) {
            addCriterion("target_player not between", value1, value2, "targetPlayer");
            return (Criteria) this;
        }

        public Criteria andSendTimeIsNull() {
            addCriterion("send_time is null");
            return (Criteria) this;
        }

        public Criteria andSendTimeIsNotNull() {
            addCriterion("send_time is not null");
            return (Criteria) this;
        }

        public Criteria andSendTimeEqualTo(Long value) {
            addCriterion("send_time =", value, "sendTime");
            return (Criteria) this;
        }

        public Criteria andSendTimeNotEqualTo(Long value) {
            addCriterion("send_time <>", value, "sendTime");
            return (Criteria) this;
        }

        public Criteria andSendTimeGreaterThan(Long value) {
            addCriterion("send_time >", value, "sendTime");
            return (Criteria) this;
        }

        public Criteria andSendTimeGreaterThanOrEqualTo(Long value) {
            addCriterion("send_time >=", value, "sendTime");
            return (Criteria) this;
        }

        public Criteria andSendTimeLessThan(Long value) {
            addCriterion("send_time <", value, "sendTime");
            return (Criteria) this;
        }

        public Criteria andSendTimeLessThanOrEqualTo(Long value) {
            addCriterion("send_time <=", value, "sendTime");
            return (Criteria) this;
        }

        public Criteria andSendTimeIn(List<Long> values) {
            addCriterion("send_time in", values, "sendTime");
            return (Criteria) this;
        }

        public Criteria andSendTimeNotIn(List<Long> values) {
            addCriterion("send_time not in", values, "sendTime");
            return (Criteria) this;
        }

        public Criteria andSendTimeBetween(Long value1, Long value2) {
            addCriterion("send_time between", value1, value2, "sendTime");
            return (Criteria) this;
        }

        public Criteria andSendTimeNotBetween(Long value1, Long value2) {
            addCriterion("send_time not between", value1, value2, "sendTime");
            return (Criteria) this;
        }

        public Criteria andLastUpdateTimeIsNull() {
            addCriterion("last_update_time is null");
            return (Criteria) this;
        }

        public Criteria andLastUpdateTimeIsNotNull() {
            addCriterion("last_update_time is not null");
            return (Criteria) this;
        }

        public Criteria andLastUpdateTimeEqualTo(Long value) {
            addCriterion("last_update_time =", value, "lastUpdateTime");
            return (Criteria) this;
        }

        public Criteria andLastUpdateTimeNotEqualTo(Long value) {
            addCriterion("last_update_time <>", value, "lastUpdateTime");
            return (Criteria) this;
        }

        public Criteria andLastUpdateTimeGreaterThan(Long value) {
            addCriterion("last_update_time >", value, "lastUpdateTime");
            return (Criteria) this;
        }

        public Criteria andLastUpdateTimeGreaterThanOrEqualTo(Long value) {
            addCriterion("last_update_time >=", value, "lastUpdateTime");
            return (Criteria) this;
        }

        public Criteria andLastUpdateTimeLessThan(Long value) {
            addCriterion("last_update_time <", value, "lastUpdateTime");
            return (Criteria) this;
        }

        public Criteria andLastUpdateTimeLessThanOrEqualTo(Long value) {
            addCriterion("last_update_time <=", value, "lastUpdateTime");
            return (Criteria) this;
        }

        public Criteria andLastUpdateTimeIn(List<Long> values) {
            addCriterion("last_update_time in", values, "lastUpdateTime");
            return (Criteria) this;
        }

        public Criteria andLastUpdateTimeNotIn(List<Long> values) {
            addCriterion("last_update_time not in", values, "lastUpdateTime");
            return (Criteria) this;
        }

        public Criteria andLastUpdateTimeBetween(Long value1, Long value2) {
            addCriterion("last_update_time between", value1, value2, "lastUpdateTime");
            return (Criteria) this;
        }

        public Criteria andLastUpdateTimeNotBetween(Long value1, Long value2) {
            addCriterion("last_update_time not between", value1, value2, "lastUpdateTime");
            return (Criteria) this;
        }

        public Criteria andMsgIsNull() {
            addCriterion("msg is null");
            return (Criteria) this;
        }

        public Criteria andMsgIsNotNull() {
            addCriterion("msg is not null");
            return (Criteria) this;
        }

        public Criteria andMsgEqualTo(String value) {
            addCriterion("msg =", value, "msg");
            return (Criteria) this;
        }

        public Criteria andMsgNotEqualTo(String value) {
            addCriterion("msg <>", value, "msg");
            return (Criteria) this;
        }

        public Criteria andMsgGreaterThan(String value) {
            addCriterion("msg >", value, "msg");
            return (Criteria) this;
        }

        public Criteria andMsgGreaterThanOrEqualTo(String value) {
            addCriterion("msg >=", value, "msg");
            return (Criteria) this;
        }

        public Criteria andMsgLessThan(String value) {
            addCriterion("msg <", value, "msg");
            return (Criteria) this;
        }

        public Criteria andMsgLessThanOrEqualTo(String value) {
            addCriterion("msg <=", value, "msg");
            return (Criteria) this;
        }

        public Criteria andMsgLike(String value) {
            addCriterion("msg like", value, "msg");
            return (Criteria) this;
        }

        public Criteria andMsgNotLike(String value) {
            addCriterion("msg not like", value, "msg");
            return (Criteria) this;
        }

        public Criteria andMsgIn(List<String> values) {
            addCriterion("msg in", values, "msg");
            return (Criteria) this;
        }

        public Criteria andMsgNotIn(List<String> values) {
            addCriterion("msg not in", values, "msg");
            return (Criteria) this;
        }

        public Criteria andMsgBetween(String value1, String value2) {
            addCriterion("msg between", value1, value2, "msg");
            return (Criteria) this;
        }

        public Criteria andMsgNotBetween(String value1, String value2) {
            addCriterion("msg not between", value1, value2, "msg");
            return (Criteria) this;
        }

        public Criteria andHasReadIsNull() {
            addCriterion("has_read is null");
            return (Criteria) this;
        }

        public Criteria andHasReadIsNotNull() {
            addCriterion("has_read is not null");
            return (Criteria) this;
        }

        public Criteria andHasReadEqualTo(Integer value) {
            addCriterion("has_read =", value, "hasRead");
            return (Criteria) this;
        }

        public Criteria andHasReadNotEqualTo(Integer value) {
            addCriterion("has_read <>", value, "hasRead");
            return (Criteria) this;
        }

        public Criteria andHasReadGreaterThan(Integer value) {
            addCriterion("has_read >", value, "hasRead");
            return (Criteria) this;
        }

        public Criteria andHasReadGreaterThanOrEqualTo(Integer value) {
            addCriterion("has_read >=", value, "hasRead");
            return (Criteria) this;
        }

        public Criteria andHasReadLessThan(Integer value) {
            addCriterion("has_read <", value, "hasRead");
            return (Criteria) this;
        }

        public Criteria andHasReadLessThanOrEqualTo(Integer value) {
            addCriterion("has_read <=", value, "hasRead");
            return (Criteria) this;
        }

        public Criteria andHasReadIn(List<Integer> values) {
            addCriterion("has_read in", values, "hasRead");
            return (Criteria) this;
        }

        public Criteria andHasReadNotIn(List<Integer> values) {
            addCriterion("has_read not in", values, "hasRead");
            return (Criteria) this;
        }

        public Criteria andHasReadBetween(Integer value1, Integer value2) {
            addCriterion("has_read between", value1, value2, "hasRead");
            return (Criteria) this;
        }

        public Criteria andHasReadNotBetween(Integer value1, Integer value2) {
            addCriterion("has_read not between", value1, value2, "hasRead");
            return (Criteria) this;
        }

        public Criteria andFromTodoIsNull() {
            addCriterion("from_todo is null");
            return (Criteria) this;
        }

        public Criteria andFromTodoIsNotNull() {
            addCriterion("from_todo is not null");
            return (Criteria) this;
        }

        public Criteria andFromTodoEqualTo(Integer value) {
            addCriterion("from_todo =", value, "fromTodo");
            return (Criteria) this;
        }

        public Criteria andFromTodoNotEqualTo(Integer value) {
            addCriterion("from_todo <>", value, "fromTodo");
            return (Criteria) this;
        }

        public Criteria andFromTodoGreaterThan(Integer value) {
            addCriterion("from_todo >", value, "fromTodo");
            return (Criteria) this;
        }

        public Criteria andFromTodoGreaterThanOrEqualTo(Integer value) {
            addCriterion("from_todo >=", value, "fromTodo");
            return (Criteria) this;
        }

        public Criteria andFromTodoLessThan(Integer value) {
            addCriterion("from_todo <", value, "fromTodo");
            return (Criteria) this;
        }

        public Criteria andFromTodoLessThanOrEqualTo(Integer value) {
            addCriterion("from_todo <=", value, "fromTodo");
            return (Criteria) this;
        }

        public Criteria andFromTodoIn(List<Integer> values) {
            addCriterion("from_todo in", values, "fromTodo");
            return (Criteria) this;
        }

        public Criteria andFromTodoNotIn(List<Integer> values) {
            addCriterion("from_todo not in", values, "fromTodo");
            return (Criteria) this;
        }

        public Criteria andFromTodoBetween(Integer value1, Integer value2) {
            addCriterion("from_todo between", value1, value2, "fromTodo");
            return (Criteria) this;
        }

        public Criteria andFromTodoNotBetween(Integer value1, Integer value2) {
            addCriterion("from_todo not between", value1, value2, "fromTodo");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {
        protected Criteria() {
            super();
        }
    }

    /**
     * @author Aye10032
     * @date 2022-02-11
     */
    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}