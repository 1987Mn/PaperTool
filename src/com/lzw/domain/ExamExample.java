package com.lzw.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ExamExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ExamExample() {
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

        public Criteria andPaperidIsNull() {
            addCriterion("paperId is null");
            return (Criteria) this;
        }

        public Criteria andPaperidIsNotNull() {
            addCriterion("paperId is not null");
            return (Criteria) this;
        }

        public Criteria andPaperidEqualTo(Integer value) {
            addCriterion("paperId =", value, "paperid");
            return (Criteria) this;
        }

        public Criteria andPaperidNotEqualTo(Integer value) {
            addCriterion("paperId <>", value, "paperid");
            return (Criteria) this;
        }

        public Criteria andPaperidGreaterThan(Integer value) {
            addCriterion("paperId >", value, "paperid");
            return (Criteria) this;
        }

        public Criteria andPaperidGreaterThanOrEqualTo(Integer value) {
            addCriterion("paperId >=", value, "paperid");
            return (Criteria) this;
        }

        public Criteria andPaperidLessThan(Integer value) {
            addCriterion("paperId <", value, "paperid");
            return (Criteria) this;
        }

        public Criteria andPaperidLessThanOrEqualTo(Integer value) {
            addCriterion("paperId <=", value, "paperid");
            return (Criteria) this;
        }

        public Criteria andPaperidIn(List<Integer> values) {
            addCriterion("paperId in", values, "paperid");
            return (Criteria) this;
        }

        public Criteria andPaperidNotIn(List<Integer> values) {
            addCriterion("paperId not in", values, "paperid");
            return (Criteria) this;
        }

        public Criteria andPaperidBetween(Integer value1, Integer value2) {
            addCriterion("paperId between", value1, value2, "paperid");
            return (Criteria) this;
        }

        public Criteria andPaperidNotBetween(Integer value1, Integer value2) {
            addCriterion("paperId not between", value1, value2, "paperid");
            return (Criteria) this;
        }

        public Criteria andClbumidIsNull() {
            addCriterion("clbumId is null");
            return (Criteria) this;
        }

        public Criteria andClbumidIsNotNull() {
            addCriterion("clbumId is not null");
            return (Criteria) this;
        }

        public Criteria andClbumidEqualTo(Integer value) {
            addCriterion("clbumId =", value, "clbumid");
            return (Criteria) this;
        }

        public Criteria andClbumidNotEqualTo(Integer value) {
            addCriterion("clbumId <>", value, "clbumid");
            return (Criteria) this;
        }

        public Criteria andClbumidGreaterThan(Integer value) {
            addCriterion("clbumId >", value, "clbumid");
            return (Criteria) this;
        }

        public Criteria andClbumidGreaterThanOrEqualTo(Integer value) {
            addCriterion("clbumId >=", value, "clbumid");
            return (Criteria) this;
        }

        public Criteria andClbumidLessThan(Integer value) {
            addCriterion("clbumId <", value, "clbumid");
            return (Criteria) this;
        }

        public Criteria andClbumidLessThanOrEqualTo(Integer value) {
            addCriterion("clbumId <=", value, "clbumid");
            return (Criteria) this;
        }

        public Criteria andClbumidIn(List<Integer> values) {
            addCriterion("clbumId in", values, "clbumid");
            return (Criteria) this;
        }

        public Criteria andClbumidNotIn(List<Integer> values) {
            addCriterion("clbumId not in", values, "clbumid");
            return (Criteria) this;
        }

        public Criteria andClbumidBetween(Integer value1, Integer value2) {
            addCriterion("clbumId between", value1, value2, "clbumid");
            return (Criteria) this;
        }

        public Criteria andClbumidNotBetween(Integer value1, Integer value2) {
            addCriterion("clbumId not between", value1, value2, "clbumid");
            return (Criteria) this;
        }

        public Criteria andTestdateIsNull() {
            addCriterion("testDate is null");
            return (Criteria) this;
        }

        public Criteria andTestdateIsNotNull() {
            addCriterion("testDate is not null");
            return (Criteria) this;
        }

        public Criteria andTestdateEqualTo(Date value) {
            addCriterion("testDate =", value, "testdate");
            return (Criteria) this;
        }

        public Criteria andTestdateNotEqualTo(Date value) {
            addCriterion("testDate <>", value, "testdate");
            return (Criteria) this;
        }

        public Criteria andTestdateGreaterThan(Date value) {
            addCriterion("testDate >", value, "testdate");
            return (Criteria) this;
        }

        public Criteria andTestdateGreaterThanOrEqualTo(Date value) {
            addCriterion("testDate >=", value, "testdate");
            return (Criteria) this;
        }

        public Criteria andTestdateLessThan(Date value) {
            addCriterion("testDate <", value, "testdate");
            return (Criteria) this;
        }

        public Criteria andTestdateLessThanOrEqualTo(Date value) {
            addCriterion("testDate <=", value, "testdate");
            return (Criteria) this;
        }

        public Criteria andTestdateIn(List<Date> values) {
            addCriterion("testDate in", values, "testdate");
            return (Criteria) this;
        }

        public Criteria andTestdateNotIn(List<Date> values) {
            addCriterion("testDate not in", values, "testdate");
            return (Criteria) this;
        }

        public Criteria andTestdateBetween(Date value1, Date value2) {
            addCriterion("testDate between", value1, value2, "testdate");
            return (Criteria) this;
        }

        public Criteria andTestdateNotBetween(Date value1, Date value2) {
            addCriterion("testDate not between", value1, value2, "testdate");
            return (Criteria) this;
        }

        public Criteria andClbumroomIsNull() {
            addCriterion("clbumRoom is null");
            return (Criteria) this;
        }

        public Criteria andClbumroomIsNotNull() {
            addCriterion("clbumRoom is not null");
            return (Criteria) this;
        }

        public Criteria andClbumroomEqualTo(String value) {
            addCriterion("clbumRoom =", value, "clbumroom");
            return (Criteria) this;
        }

        public Criteria andClbumroomNotEqualTo(String value) {
            addCriterion("clbumRoom <>", value, "clbumroom");
            return (Criteria) this;
        }

        public Criteria andClbumroomGreaterThan(String value) {
            addCriterion("clbumRoom >", value, "clbumroom");
            return (Criteria) this;
        }

        public Criteria andClbumroomGreaterThanOrEqualTo(String value) {
            addCriterion("clbumRoom >=", value, "clbumroom");
            return (Criteria) this;
        }

        public Criteria andClbumroomLessThan(String value) {
            addCriterion("clbumRoom <", value, "clbumroom");
            return (Criteria) this;
        }

        public Criteria andClbumroomLessThanOrEqualTo(String value) {
            addCriterion("clbumRoom <=", value, "clbumroom");
            return (Criteria) this;
        }

        public Criteria andClbumroomLike(String value) {
            addCriterion("clbumRoom like", value, "clbumroom");
            return (Criteria) this;
        }

        public Criteria andClbumroomNotLike(String value) {
            addCriterion("clbumRoom not like", value, "clbumroom");
            return (Criteria) this;
        }

        public Criteria andClbumroomIn(List<String> values) {
            addCriterion("clbumRoom in", values, "clbumroom");
            return (Criteria) this;
        }

        public Criteria andClbumroomNotIn(List<String> values) {
            addCriterion("clbumRoom not in", values, "clbumroom");
            return (Criteria) this;
        }

        public Criteria andClbumroomBetween(String value1, String value2) {
            addCriterion("clbumRoom between", value1, value2, "clbumroom");
            return (Criteria) this;
        }

        public Criteria andClbumroomNotBetween(String value1, String value2) {
            addCriterion("clbumRoom not between", value1, value2, "clbumroom");
            return (Criteria) this;
        }

        public Criteria andPeoplenumIsNull() {
            addCriterion("peopleNum is null");
            return (Criteria) this;
        }

        public Criteria andPeoplenumIsNotNull() {
            addCriterion("peopleNum is not null");
            return (Criteria) this;
        }

        public Criteria andPeoplenumEqualTo(Integer value) {
            addCriterion("peopleNum =", value, "peoplenum");
            return (Criteria) this;
        }

        public Criteria andPeoplenumNotEqualTo(Integer value) {
            addCriterion("peopleNum <>", value, "peoplenum");
            return (Criteria) this;
        }

        public Criteria andPeoplenumGreaterThan(Integer value) {
            addCriterion("peopleNum >", value, "peoplenum");
            return (Criteria) this;
        }

        public Criteria andPeoplenumGreaterThanOrEqualTo(Integer value) {
            addCriterion("peopleNum >=", value, "peoplenum");
            return (Criteria) this;
        }

        public Criteria andPeoplenumLessThan(Integer value) {
            addCriterion("peopleNum <", value, "peoplenum");
            return (Criteria) this;
        }

        public Criteria andPeoplenumLessThanOrEqualTo(Integer value) {
            addCriterion("peopleNum <=", value, "peoplenum");
            return (Criteria) this;
        }

        public Criteria andPeoplenumIn(List<Integer> values) {
            addCriterion("peopleNum in", values, "peoplenum");
            return (Criteria) this;
        }

        public Criteria andPeoplenumNotIn(List<Integer> values) {
            addCriterion("peopleNum not in", values, "peoplenum");
            return (Criteria) this;
        }

        public Criteria andPeoplenumBetween(Integer value1, Integer value2) {
            addCriterion("peopleNum between", value1, value2, "peoplenum");
            return (Criteria) this;
        }

        public Criteria andPeoplenumNotBetween(Integer value1, Integer value2) {
            addCriterion("peopleNum not between", value1, value2, "peoplenum");
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