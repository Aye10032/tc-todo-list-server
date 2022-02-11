package com.aye10032.tctodolist.tctodolistserver.pojo;

import java.util.ArrayList;
import java.util.List;

public class PlayerExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public PlayerExample() {
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
     * @author dazo66
     * @date 2022-02-11
     */
    protected abstract static class GeneratedCriteria {
        protected List<Criterion> groupsCriteria;

        protected List<Criterion> allCriteria;

        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<>();
            groupsCriteria = new ArrayList<>();
        }

        public List<Criterion> getGroupsCriteria() {
            return groupsCriteria;
        }

        protected void addGroupsCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            groupsCriteria.add(new Criterion(condition, value, "com.aye10032.tctodolist.tctodolistserver.handler.ListToVarcharTypeHandler"));
            allCriteria = null;
        }

        protected void addGroupsCriterion(String condition, List value1, List value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            groupsCriteria.add(new Criterion(condition, value1, value2, "com.aye10032.tctodolist.tctodolistserver.handler.ListToVarcharTypeHandler"));
            allCriteria = null;
        }

        public boolean isValid() {
            return criteria.size() > 0
                || groupsCriteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            if (allCriteria == null) {
                allCriteria = new ArrayList<>();
                allCriteria.addAll(criteria);
                allCriteria.addAll(groupsCriteria);
            }
            return allCriteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
            allCriteria = null;
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
            allCriteria = null;
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
            allCriteria = null;
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

        public Criteria andNameIsNull() {
            addCriterion("name is null");
            return (Criteria) this;
        }

        public Criteria andNameIsNotNull() {
            addCriterion("name is not null");
            return (Criteria) this;
        }

        public Criteria andNameEqualTo(String value) {
            addCriterion("name =", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotEqualTo(String value) {
            addCriterion("name <>", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameGreaterThan(String value) {
            addCriterion("name >", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameGreaterThanOrEqualTo(String value) {
            addCriterion("name >=", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLessThan(String value) {
            addCriterion("name <", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLessThanOrEqualTo(String value) {
            addCriterion("name <=", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLike(String value) {
            addCriterion("name like", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotLike(String value) {
            addCriterion("name not like", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameIn(List<String> values) {
            addCriterion("name in", values, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotIn(List<String> values) {
            addCriterion("name not in", values, "name");
            return (Criteria) this;
        }

        public Criteria andNameBetween(String value1, String value2) {
            addCriterion("name between", value1, value2, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotBetween(String value1, String value2) {
            addCriterion("name not between", value1, value2, "name");
            return (Criteria) this;
        }

        public Criteria andUuidIsNull() {
            addCriterion("uuid is null");
            return (Criteria) this;
        }

        public Criteria andUuidIsNotNull() {
            addCriterion("uuid is not null");
            return (Criteria) this;
        }

        public Criteria andUuidEqualTo(String value) {
            addCriterion("uuid =", value, "uuid");
            return (Criteria) this;
        }

        public Criteria andUuidNotEqualTo(String value) {
            addCriterion("uuid <>", value, "uuid");
            return (Criteria) this;
        }

        public Criteria andUuidGreaterThan(String value) {
            addCriterion("uuid >", value, "uuid");
            return (Criteria) this;
        }

        public Criteria andUuidGreaterThanOrEqualTo(String value) {
            addCriterion("uuid >=", value, "uuid");
            return (Criteria) this;
        }

        public Criteria andUuidLessThan(String value) {
            addCriterion("uuid <", value, "uuid");
            return (Criteria) this;
        }

        public Criteria andUuidLessThanOrEqualTo(String value) {
            addCriterion("uuid <=", value, "uuid");
            return (Criteria) this;
        }

        public Criteria andUuidLike(String value) {
            addCriterion("uuid like", value, "uuid");
            return (Criteria) this;
        }

        public Criteria andUuidNotLike(String value) {
            addCriterion("uuid not like", value, "uuid");
            return (Criteria) this;
        }

        public Criteria andUuidIn(List<String> values) {
            addCriterion("uuid in", values, "uuid");
            return (Criteria) this;
        }

        public Criteria andUuidNotIn(List<String> values) {
            addCriterion("uuid not in", values, "uuid");
            return (Criteria) this;
        }

        public Criteria andUuidBetween(String value1, String value2) {
            addCriterion("uuid between", value1, value2, "uuid");
            return (Criteria) this;
        }

        public Criteria andUuidNotBetween(String value1, String value2) {
            addCriterion("uuid not between", value1, value2, "uuid");
            return (Criteria) this;
        }

        public Criteria andAdminIsNull() {
            addCriterion("admin is null");
            return (Criteria) this;
        }

        public Criteria andAdminIsNotNull() {
            addCriterion("admin is not null");
            return (Criteria) this;
        }

        public Criteria andAdminEqualTo(Integer value) {
            addCriterion("admin =", value, "admin");
            return (Criteria) this;
        }

        public Criteria andAdminNotEqualTo(Integer value) {
            addCriterion("admin <>", value, "admin");
            return (Criteria) this;
        }

        public Criteria andAdminGreaterThan(Integer value) {
            addCriterion("admin >", value, "admin");
            return (Criteria) this;
        }

        public Criteria andAdminGreaterThanOrEqualTo(Integer value) {
            addCriterion("admin >=", value, "admin");
            return (Criteria) this;
        }

        public Criteria andAdminLessThan(Integer value) {
            addCriterion("admin <", value, "admin");
            return (Criteria) this;
        }

        public Criteria andAdminLessThanOrEqualTo(Integer value) {
            addCriterion("admin <=", value, "admin");
            return (Criteria) this;
        }

        public Criteria andAdminIn(List<Integer> values) {
            addCriterion("admin in", values, "admin");
            return (Criteria) this;
        }

        public Criteria andAdminNotIn(List<Integer> values) {
            addCriterion("admin not in", values, "admin");
            return (Criteria) this;
        }

        public Criteria andAdminBetween(Integer value1, Integer value2) {
            addCriterion("admin between", value1, value2, "admin");
            return (Criteria) this;
        }

        public Criteria andAdminNotBetween(Integer value1, Integer value2) {
            addCriterion("admin not between", value1, value2, "admin");
            return (Criteria) this;
        }

        public Criteria andGroupsIsNull() {
            addCriterion("groups is null");
            return (Criteria) this;
        }

        public Criteria andGroupsIsNotNull() {
            addCriterion("groups is not null");
            return (Criteria) this;
        }

        public Criteria andGroupsEqualTo(List value) {
            addGroupsCriterion("groups =", value, "groups");
            return (Criteria) this;
        }

        public Criteria andGroupsNotEqualTo(List value) {
            addGroupsCriterion("groups <>", value, "groups");
            return (Criteria) this;
        }

        public Criteria andGroupsGreaterThan(List value) {
            addGroupsCriterion("groups >", value, "groups");
            return (Criteria) this;
        }

        public Criteria andGroupsGreaterThanOrEqualTo(List value) {
            addGroupsCriterion("groups >=", value, "groups");
            return (Criteria) this;
        }

        public Criteria andGroupsLessThan(List value) {
            addGroupsCriterion("groups <", value, "groups");
            return (Criteria) this;
        }

        public Criteria andGroupsLessThanOrEqualTo(List value) {
            addGroupsCriterion("groups <=", value, "groups");
            return (Criteria) this;
        }

        public Criteria andGroupsLike(List value) {
            addGroupsCriterion("groups like", value, "groups");
            return (Criteria) this;
        }

        public Criteria andGroupsNotLike(List value) {
            addGroupsCriterion("groups not like", value, "groups");
            return (Criteria) this;
        }

        public Criteria andGroupsIn(List<List> values) {
            addGroupsCriterion("groups in", values, "groups");
            return (Criteria) this;
        }

        public Criteria andGroupsNotIn(List<List> values) {
            addGroupsCriterion("groups not in", values, "groups");
            return (Criteria) this;
        }

        public Criteria andGroupsBetween(List value1, List value2) {
            addGroupsCriterion("groups between", value1, value2, "groups");
            return (Criteria) this;
        }

        public Criteria andGroupsNotBetween(List value1, List value2) {
            addGroupsCriterion("groups not between", value1, value2, "groups");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {
        protected Criteria() {
            super();
        }
    }

    /**
     * @author dazo66
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