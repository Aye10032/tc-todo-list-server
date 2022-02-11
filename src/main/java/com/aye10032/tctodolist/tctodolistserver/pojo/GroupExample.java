package com.aye10032.tctodolist.tctodolistserver.pojo;

import java.util.ArrayList;
import java.util.List;

public class GroupExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public GroupExample() {
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
        protected List<Criterion> adminsCriteria;

        protected List<Criterion> allCriteria;

        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<>();
            adminsCriteria = new ArrayList<>();
        }

        public List<Criterion> getAdminsCriteria() {
            return adminsCriteria;
        }

        protected void addAdminsCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            adminsCriteria.add(new Criterion(condition, value, "com.aye10032.tctodolist.tctodolistserver.handler.ListToVarcharTypeHandler"));
            allCriteria = null;
        }

        protected void addAdminsCriterion(String condition, List value1, List value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            adminsCriteria.add(new Criterion(condition, value1, value2, "com.aye10032.tctodolist.tctodolistserver.handler.ListToVarcharTypeHandler"));
            allCriteria = null;
        }

        public boolean isValid() {
            return criteria.size() > 0
                || adminsCriteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            if (allCriteria == null) {
                allCriteria = new ArrayList<>();
                allCriteria.addAll(criteria);
                allCriteria.addAll(adminsCriteria);
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

        public Criteria andOwnerIsNull() {
            addCriterion("owner is null");
            return (Criteria) this;
        }

        public Criteria andOwnerIsNotNull() {
            addCriterion("owner is not null");
            return (Criteria) this;
        }

        public Criteria andOwnerEqualTo(Integer value) {
            addCriterion("owner =", value, "owner");
            return (Criteria) this;
        }

        public Criteria andOwnerNotEqualTo(Integer value) {
            addCriterion("owner <>", value, "owner");
            return (Criteria) this;
        }

        public Criteria andOwnerGreaterThan(Integer value) {
            addCriterion("owner >", value, "owner");
            return (Criteria) this;
        }

        public Criteria andOwnerGreaterThanOrEqualTo(Integer value) {
            addCriterion("owner >=", value, "owner");
            return (Criteria) this;
        }

        public Criteria andOwnerLessThan(Integer value) {
            addCriterion("owner <", value, "owner");
            return (Criteria) this;
        }

        public Criteria andOwnerLessThanOrEqualTo(Integer value) {
            addCriterion("owner <=", value, "owner");
            return (Criteria) this;
        }

        public Criteria andOwnerIn(List<Integer> values) {
            addCriterion("owner in", values, "owner");
            return (Criteria) this;
        }

        public Criteria andOwnerNotIn(List<Integer> values) {
            addCriterion("owner not in", values, "owner");
            return (Criteria) this;
        }

        public Criteria andOwnerBetween(Integer value1, Integer value2) {
            addCriterion("owner between", value1, value2, "owner");
            return (Criteria) this;
        }

        public Criteria andOwnerNotBetween(Integer value1, Integer value2) {
            addCriterion("owner not between", value1, value2, "owner");
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

        public Criteria andInformationIsNull() {
            addCriterion("information is null");
            return (Criteria) this;
        }

        public Criteria andInformationIsNotNull() {
            addCriterion("information is not null");
            return (Criteria) this;
        }

        public Criteria andInformationEqualTo(String value) {
            addCriterion("information =", value, "information");
            return (Criteria) this;
        }

        public Criteria andInformationNotEqualTo(String value) {
            addCriterion("information <>", value, "information");
            return (Criteria) this;
        }

        public Criteria andInformationGreaterThan(String value) {
            addCriterion("information >", value, "information");
            return (Criteria) this;
        }

        public Criteria andInformationGreaterThanOrEqualTo(String value) {
            addCriterion("information >=", value, "information");
            return (Criteria) this;
        }

        public Criteria andInformationLessThan(String value) {
            addCriterion("information <", value, "information");
            return (Criteria) this;
        }

        public Criteria andInformationLessThanOrEqualTo(String value) {
            addCriterion("information <=", value, "information");
            return (Criteria) this;
        }

        public Criteria andInformationLike(String value) {
            addCriterion("information like", value, "information");
            return (Criteria) this;
        }

        public Criteria andInformationNotLike(String value) {
            addCriterion("information not like", value, "information");
            return (Criteria) this;
        }

        public Criteria andInformationIn(List<String> values) {
            addCriterion("information in", values, "information");
            return (Criteria) this;
        }

        public Criteria andInformationNotIn(List<String> values) {
            addCriterion("information not in", values, "information");
            return (Criteria) this;
        }

        public Criteria andInformationBetween(String value1, String value2) {
            addCriterion("information between", value1, value2, "information");
            return (Criteria) this;
        }

        public Criteria andInformationNotBetween(String value1, String value2) {
            addCriterion("information not between", value1, value2, "information");
            return (Criteria) this;
        }

        public Criteria andAdminsIsNull() {
            addCriterion("admins is null");
            return (Criteria) this;
        }

        public Criteria andAdminsIsNotNull() {
            addCriterion("admins is not null");
            return (Criteria) this;
        }

        public Criteria andAdminsEqualTo(List value) {
            addAdminsCriterion("admins =", value, "admins");
            return (Criteria) this;
        }

        public Criteria andAdminsNotEqualTo(List value) {
            addAdminsCriterion("admins <>", value, "admins");
            return (Criteria) this;
        }

        public Criteria andAdminsGreaterThan(List value) {
            addAdminsCriterion("admins >", value, "admins");
            return (Criteria) this;
        }

        public Criteria andAdminsGreaterThanOrEqualTo(List value) {
            addAdminsCriterion("admins >=", value, "admins");
            return (Criteria) this;
        }

        public Criteria andAdminsLessThan(List value) {
            addAdminsCriterion("admins <", value, "admins");
            return (Criteria) this;
        }

        public Criteria andAdminsLessThanOrEqualTo(List value) {
            addAdminsCriterion("admins <=", value, "admins");
            return (Criteria) this;
        }

        public Criteria andAdminsLike(List value) {
            addAdminsCriterion("admins like", value, "admins");
            return (Criteria) this;
        }

        public Criteria andAdminsNotLike(List value) {
            addAdminsCriterion("admins not like", value, "admins");
            return (Criteria) this;
        }

        public Criteria andAdminsIn(List<List> values) {
            addAdminsCriterion("admins in", values, "admins");
            return (Criteria) this;
        }

        public Criteria andAdminsNotIn(List<List> values) {
            addAdminsCriterion("admins not in", values, "admins");
            return (Criteria) this;
        }

        public Criteria andAdminsBetween(List value1, List value2) {
            addAdminsCriterion("admins between", value1, value2, "admins");
            return (Criteria) this;
        }

        public Criteria andAdminsNotBetween(List value1, List value2) {
            addAdminsCriterion("admins not between", value1, value2, "admins");
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