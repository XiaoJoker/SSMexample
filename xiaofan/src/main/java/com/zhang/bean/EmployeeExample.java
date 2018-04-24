package com.zhang.bean;

import java.util.ArrayList;
import java.util.List;

public class EmployeeExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public EmployeeExample() {
        oredCriteria = new ArrayList<Criteria>();
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

    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
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

        public Criteria andWorkerIdIsNull() {
            addCriterion("worker_id is null");
            return (Criteria) this;
        }

        public Criteria andWorkerIdIsNotNull() {
            addCriterion("worker_id is not null");
            return (Criteria) this;
        }

        public Criteria andWorkerIdEqualTo(Integer value) {
            addCriterion("worker_id =", value, "workerId");
            return (Criteria) this;
        }

        public Criteria andWorkerIdNotEqualTo(Integer value) {
            addCriterion("worker_id <>", value, "workerId");
            return (Criteria) this;
        }

        public Criteria andWorkerIdGreaterThan(Integer value) {
            addCriterion("worker_id >", value, "workerId");
            return (Criteria) this;
        }

        public Criteria andWorkerIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("worker_id >=", value, "workerId");
            return (Criteria) this;
        }

        public Criteria andWorkerIdLessThan(Integer value) {
            addCriterion("worker_id <", value, "workerId");
            return (Criteria) this;
        }

        public Criteria andWorkerIdLessThanOrEqualTo(Integer value) {
            addCriterion("worker_id <=", value, "workerId");
            return (Criteria) this;
        }

        public Criteria andWorkerIdIn(List<Integer> values) {
            addCriterion("worker_id in", values, "workerId");
            return (Criteria) this;
        }

        public Criteria andWorkerIdNotIn(List<Integer> values) {
            addCriterion("worker_id not in", values, "workerId");
            return (Criteria) this;
        }

        public Criteria andWorkerIdBetween(Integer value1, Integer value2) {
            addCriterion("worker_id between", value1, value2, "workerId");
            return (Criteria) this;
        }

        public Criteria andWorkerIdNotBetween(Integer value1, Integer value2) {
            addCriterion("worker_id not between", value1, value2, "workerId");
            return (Criteria) this;
        }

        public Criteria andWorkerNameIsNull() {
            addCriterion("worker_name is null");
            return (Criteria) this;
        }

        public Criteria andWorkerNameIsNotNull() {
            addCriterion("worker_name is not null");
            return (Criteria) this;
        }

        public Criteria andWorkerNameEqualTo(String value) {
            addCriterion("worker_name =", value, "workerName");
            return (Criteria) this;
        }

        public Criteria andWorkerNameNotEqualTo(String value) {
            addCriterion("worker_name <>", value, "workerName");
            return (Criteria) this;
        }

        public Criteria andWorkerNameGreaterThan(String value) {
            addCriterion("worker_name >", value, "workerName");
            return (Criteria) this;
        }

        public Criteria andWorkerNameGreaterThanOrEqualTo(String value) {
            addCriterion("worker_name >=", value, "workerName");
            return (Criteria) this;
        }

        public Criteria andWorkerNameLessThan(String value) {
            addCriterion("worker_name <", value, "workerName");
            return (Criteria) this;
        }

        public Criteria andWorkerNameLessThanOrEqualTo(String value) {
            addCriterion("worker_name <=", value, "workerName");
            return (Criteria) this;
        }

        public Criteria andWorkerNameLike(String value) {
            addCriterion("worker_name like", value, "workerName");
            return (Criteria) this;
        }

        public Criteria andWorkerNameNotLike(String value) {
            addCriterion("worker_name not like", value, "workerName");
            return (Criteria) this;
        }

        public Criteria andWorkerNameIn(List<String> values) {
            addCriterion("worker_name in", values, "workerName");
            return (Criteria) this;
        }

        public Criteria andWorkerNameNotIn(List<String> values) {
            addCriterion("worker_name not in", values, "workerName");
            return (Criteria) this;
        }

        public Criteria andWorkerNameBetween(String value1, String value2) {
            addCriterion("worker_name between", value1, value2, "workerName");
            return (Criteria) this;
        }

        public Criteria andWorkerNameNotBetween(String value1, String value2) {
            addCriterion("worker_name not between", value1, value2, "workerName");
            return (Criteria) this;
        }

        public Criteria andWorkerGenderIsNull() {
            addCriterion("worker_gender is null");
            return (Criteria) this;
        }

        public Criteria andWorkerGenderIsNotNull() {
            addCriterion("worker_gender is not null");
            return (Criteria) this;
        }

        public Criteria andWorkerGenderEqualTo(String value) {
            addCriterion("worker_gender =", value, "workerGender");
            return (Criteria) this;
        }

        public Criteria andWorkerGenderNotEqualTo(String value) {
            addCriterion("worker_gender <>", value, "workerGender");
            return (Criteria) this;
        }

        public Criteria andWorkerGenderGreaterThan(String value) {
            addCriterion("worker_gender >", value, "workerGender");
            return (Criteria) this;
        }

        public Criteria andWorkerGenderGreaterThanOrEqualTo(String value) {
            addCriterion("worker_gender >=", value, "workerGender");
            return (Criteria) this;
        }

        public Criteria andWorkerGenderLessThan(String value) {
            addCriterion("worker_gender <", value, "workerGender");
            return (Criteria) this;
        }

        public Criteria andWorkerGenderLessThanOrEqualTo(String value) {
            addCriterion("worker_gender <=", value, "workerGender");
            return (Criteria) this;
        }

        public Criteria andWorkerGenderLike(String value) {
            addCriterion("worker_gender like", value, "workerGender");
            return (Criteria) this;
        }

        public Criteria andWorkerGenderNotLike(String value) {
            addCriterion("worker_gender not like", value, "workerGender");
            return (Criteria) this;
        }

        public Criteria andWorkerGenderIn(List<String> values) {
            addCriterion("worker_gender in", values, "workerGender");
            return (Criteria) this;
        }

        public Criteria andWorkerGenderNotIn(List<String> values) {
            addCriterion("worker_gender not in", values, "workerGender");
            return (Criteria) this;
        }

        public Criteria andWorkerGenderBetween(String value1, String value2) {
            addCriterion("worker_gender between", value1, value2, "workerGender");
            return (Criteria) this;
        }

        public Criteria andWorkerGenderNotBetween(String value1, String value2) {
            addCriterion("worker_gender not between", value1, value2, "workerGender");
            return (Criteria) this;
        }

        public Criteria andWorkerEmailIsNull() {
            addCriterion("worker_email is null");
            return (Criteria) this;
        }

        public Criteria andWorkerEmailIsNotNull() {
            addCriterion("worker_email is not null");
            return (Criteria) this;
        }

        public Criteria andWorkerEmailEqualTo(String value) {
            addCriterion("worker_email =", value, "workerEmail");
            return (Criteria) this;
        }

        public Criteria andWorkerEmailNotEqualTo(String value) {
            addCriterion("worker_email <>", value, "workerEmail");
            return (Criteria) this;
        }

        public Criteria andWorkerEmailGreaterThan(String value) {
            addCriterion("worker_email >", value, "workerEmail");
            return (Criteria) this;
        }

        public Criteria andWorkerEmailGreaterThanOrEqualTo(String value) {
            addCriterion("worker_email >=", value, "workerEmail");
            return (Criteria) this;
        }

        public Criteria andWorkerEmailLessThan(String value) {
            addCriterion("worker_email <", value, "workerEmail");
            return (Criteria) this;
        }

        public Criteria andWorkerEmailLessThanOrEqualTo(String value) {
            addCriterion("worker_email <=", value, "workerEmail");
            return (Criteria) this;
        }

        public Criteria andWorkerEmailLike(String value) {
            addCriterion("worker_email like", value, "workerEmail");
            return (Criteria) this;
        }

        public Criteria andWorkerEmailNotLike(String value) {
            addCriterion("worker_email not like", value, "workerEmail");
            return (Criteria) this;
        }

        public Criteria andWorkerEmailIn(List<String> values) {
            addCriterion("worker_email in", values, "workerEmail");
            return (Criteria) this;
        }

        public Criteria andWorkerEmailNotIn(List<String> values) {
            addCriterion("worker_email not in", values, "workerEmail");
            return (Criteria) this;
        }

        public Criteria andWorkerEmailBetween(String value1, String value2) {
            addCriterion("worker_email between", value1, value2, "workerEmail");
            return (Criteria) this;
        }

        public Criteria andWorkerEmailNotBetween(String value1, String value2) {
            addCriterion("worker_email not between", value1, value2, "workerEmail");
            return (Criteria) this;
        }

        public Criteria andDIdIsNull() {
            addCriterion("d_id is null");
            return (Criteria) this;
        }

        public Criteria andDIdIsNotNull() {
            addCriterion("d_id is not null");
            return (Criteria) this;
        }

        public Criteria andDIdEqualTo(Integer value) {
            addCriterion("d_id =", value, "dId");
            return (Criteria) this;
        }

        public Criteria andDIdNotEqualTo(Integer value) {
            addCriterion("d_id <>", value, "dId");
            return (Criteria) this;
        }

        public Criteria andDIdGreaterThan(Integer value) {
            addCriterion("d_id >", value, "dId");
            return (Criteria) this;
        }

        public Criteria andDIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("d_id >=", value, "dId");
            return (Criteria) this;
        }

        public Criteria andDIdLessThan(Integer value) {
            addCriterion("d_id <", value, "dId");
            return (Criteria) this;
        }

        public Criteria andDIdLessThanOrEqualTo(Integer value) {
            addCriterion("d_id <=", value, "dId");
            return (Criteria) this;
        }

        public Criteria andDIdIn(List<Integer> values) {
            addCriterion("d_id in", values, "dId");
            return (Criteria) this;
        }

        public Criteria andDIdNotIn(List<Integer> values) {
            addCriterion("d_id not in", values, "dId");
            return (Criteria) this;
        }

        public Criteria andDIdBetween(Integer value1, Integer value2) {
            addCriterion("d_id between", value1, value2, "dId");
            return (Criteria) this;
        }

        public Criteria andDIdNotBetween(Integer value1, Integer value2) {
            addCriterion("d_id not between", value1, value2, "dId");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

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