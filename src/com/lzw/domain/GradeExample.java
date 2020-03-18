package com.lzw.domain;

import java.util.ArrayList;
import java.util.List;

public class GradeExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public GradeExample() {
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

        public Criteria andSmallquestionidIsNull() {
            addCriterion("smallQuestionId is null");
            return (Criteria) this;
        }

        public Criteria andSmallquestionidIsNotNull() {
            addCriterion("smallQuestionId is not null");
            return (Criteria) this;
        }

        public Criteria andSmallquestionidEqualTo(Integer value) {
            addCriterion("smallQuestionId =", value, "smallquestionid");
            return (Criteria) this;
        }

        public Criteria andSmallquestionidNotEqualTo(Integer value) {
            addCriterion("smallQuestionId <>", value, "smallquestionid");
            return (Criteria) this;
        }

        public Criteria andSmallquestionidGreaterThan(Integer value) {
            addCriterion("smallQuestionId >", value, "smallquestionid");
            return (Criteria) this;
        }

        public Criteria andSmallquestionidGreaterThanOrEqualTo(Integer value) {
            addCriterion("smallQuestionId >=", value, "smallquestionid");
            return (Criteria) this;
        }

        public Criteria andSmallquestionidLessThan(Integer value) {
            addCriterion("smallQuestionId <", value, "smallquestionid");
            return (Criteria) this;
        }

        public Criteria andSmallquestionidLessThanOrEqualTo(Integer value) {
            addCriterion("smallQuestionId <=", value, "smallquestionid");
            return (Criteria) this;
        }

        public Criteria andSmallquestionidIn(List<Integer> values) {
            addCriterion("smallQuestionId in", values, "smallquestionid");
            return (Criteria) this;
        }

        public Criteria andSmallquestionidNotIn(List<Integer> values) {
            addCriterion("smallQuestionId not in", values, "smallquestionid");
            return (Criteria) this;
        }

        public Criteria andSmallquestionidBetween(Integer value1, Integer value2) {
            addCriterion("smallQuestionId between", value1, value2, "smallquestionid");
            return (Criteria) this;
        }

        public Criteria andSmallquestionidNotBetween(Integer value1, Integer value2) {
            addCriterion("smallQuestionId not between", value1, value2, "smallquestionid");
            return (Criteria) this;
        }

        public Criteria andExamidIsNull() {
            addCriterion("examId is null");
            return (Criteria) this;
        }

        public Criteria andExamidIsNotNull() {
            addCriterion("examId is not null");
            return (Criteria) this;
        }

        public Criteria andExamidEqualTo(Integer value) {
            addCriterion("examId =", value, "examid");
            return (Criteria) this;
        }

        public Criteria andExamidNotEqualTo(Integer value) {
            addCriterion("examId <>", value, "examid");
            return (Criteria) this;
        }

        public Criteria andExamidGreaterThan(Integer value) {
            addCriterion("examId >", value, "examid");
            return (Criteria) this;
        }

        public Criteria andExamidGreaterThanOrEqualTo(Integer value) {
            addCriterion("examId >=", value, "examid");
            return (Criteria) this;
        }

        public Criteria andExamidLessThan(Integer value) {
            addCriterion("examId <", value, "examid");
            return (Criteria) this;
        }

        public Criteria andExamidLessThanOrEqualTo(Integer value) {
            addCriterion("examId <=", value, "examid");
            return (Criteria) this;
        }

        public Criteria andExamidIn(List<Integer> values) {
            addCriterion("examId in", values, "examid");
            return (Criteria) this;
        }

        public Criteria andExamidNotIn(List<Integer> values) {
            addCriterion("examId not in", values, "examid");
            return (Criteria) this;
        }

        public Criteria andExamidBetween(Integer value1, Integer value2) {
            addCriterion("examId between", value1, value2, "examid");
            return (Criteria) this;
        }

        public Criteria andExamidNotBetween(Integer value1, Integer value2) {
            addCriterion("examId not between", value1, value2, "examid");
            return (Criteria) this;
        }

        public Criteria andStudentidIsNull() {
            addCriterion("studentId is null");
            return (Criteria) this;
        }

        public Criteria andStudentidIsNotNull() {
            addCriterion("studentId is not null");
            return (Criteria) this;
        }

        public Criteria andStudentidEqualTo(String value) {
            addCriterion("studentId =", value, "studentid");
            return (Criteria) this;
        }

        public Criteria andStudentidNotEqualTo(String value) {
            addCriterion("studentId <>", value, "studentid");
            return (Criteria) this;
        }

        public Criteria andStudentidGreaterThan(String value) {
            addCriterion("studentId >", value, "studentid");
            return (Criteria) this;
        }

        public Criteria andStudentidGreaterThanOrEqualTo(String value) {
            addCriterion("studentId >=", value, "studentid");
            return (Criteria) this;
        }

        public Criteria andStudentidLessThan(String value) {
            addCriterion("studentId <", value, "studentid");
            return (Criteria) this;
        }

        public Criteria andStudentidLessThanOrEqualTo(String value) {
            addCriterion("studentId <=", value, "studentid");
            return (Criteria) this;
        }

        public Criteria andStudentidLike(String value) {
            addCriterion("studentId like", value, "studentid");
            return (Criteria) this;
        }

        public Criteria andStudentidNotLike(String value) {
            addCriterion("studentId not like", value, "studentid");
            return (Criteria) this;
        }

        public Criteria andStudentidIn(List<String> values) {
            addCriterion("studentId in", values, "studentid");
            return (Criteria) this;
        }

        public Criteria andStudentidNotIn(List<String> values) {
            addCriterion("studentId not in", values, "studentid");
            return (Criteria) this;
        }

        public Criteria andStudentidBetween(String value1, String value2) {
            addCriterion("studentId between", value1, value2, "studentid");
            return (Criteria) this;
        }

        public Criteria andStudentidNotBetween(String value1, String value2) {
            addCriterion("studentId not between", value1, value2, "studentid");
            return (Criteria) this;
        }

        public Criteria andTotalpointIsNull() {
            addCriterion("totalPoint is null");
            return (Criteria) this;
        }

        public Criteria andTotalpointIsNotNull() {
            addCriterion("totalPoint is not null");
            return (Criteria) this;
        }

        public Criteria andTotalpointEqualTo(Double value) {
            addCriterion("totalPoint =", value, "totalpoint");
            return (Criteria) this;
        }

        public Criteria andTotalpointNotEqualTo(Double value) {
            addCriterion("totalPoint <>", value, "totalpoint");
            return (Criteria) this;
        }

        public Criteria andTotalpointGreaterThan(Double value) {
            addCriterion("totalPoint >", value, "totalpoint");
            return (Criteria) this;
        }

        public Criteria andTotalpointGreaterThanOrEqualTo(Double value) {
            addCriterion("totalPoint >=", value, "totalpoint");
            return (Criteria) this;
        }

        public Criteria andTotalpointLessThan(Double value) {
            addCriterion("totalPoint <", value, "totalpoint");
            return (Criteria) this;
        }

        public Criteria andTotalpointLessThanOrEqualTo(Double value) {
            addCriterion("totalPoint <=", value, "totalpoint");
            return (Criteria) this;
        }

        public Criteria andTotalpointIn(List<Double> values) {
            addCriterion("totalPoint in", values, "totalpoint");
            return (Criteria) this;
        }

        public Criteria andTotalpointNotIn(List<Double> values) {
            addCriterion("totalPoint not in", values, "totalpoint");
            return (Criteria) this;
        }

        public Criteria andTotalpointBetween(Double value1, Double value2) {
            addCriterion("totalPoint between", value1, value2, "totalpoint");
            return (Criteria) this;
        }

        public Criteria andTotalpointNotBetween(Double value1, Double value2) {
            addCriterion("totalPoint not between", value1, value2, "totalpoint");
            return (Criteria) this;
        }

        public Criteria andScorepoint1IsNull() {
            addCriterion("scorePoint1 is null");
            return (Criteria) this;
        }

        public Criteria andScorepoint1IsNotNull() {
            addCriterion("scorePoint1 is not null");
            return (Criteria) this;
        }

        public Criteria andScorepoint1EqualTo(Double value) {
            addCriterion("scorePoint1 =", value, "scorepoint1");
            return (Criteria) this;
        }

        public Criteria andScorepoint1NotEqualTo(Double value) {
            addCriterion("scorePoint1 <>", value, "scorepoint1");
            return (Criteria) this;
        }

        public Criteria andScorepoint1GreaterThan(Double value) {
            addCriterion("scorePoint1 >", value, "scorepoint1");
            return (Criteria) this;
        }

        public Criteria andScorepoint1GreaterThanOrEqualTo(Double value) {
            addCriterion("scorePoint1 >=", value, "scorepoint1");
            return (Criteria) this;
        }

        public Criteria andScorepoint1LessThan(Double value) {
            addCriterion("scorePoint1 <", value, "scorepoint1");
            return (Criteria) this;
        }

        public Criteria andScorepoint1LessThanOrEqualTo(Double value) {
            addCriterion("scorePoint1 <=", value, "scorepoint1");
            return (Criteria) this;
        }

        public Criteria andScorepoint1In(List<Double> values) {
            addCriterion("scorePoint1 in", values, "scorepoint1");
            return (Criteria) this;
        }

        public Criteria andScorepoint1NotIn(List<Double> values) {
            addCriterion("scorePoint1 not in", values, "scorepoint1");
            return (Criteria) this;
        }

        public Criteria andScorepoint1Between(Double value1, Double value2) {
            addCriterion("scorePoint1 between", value1, value2, "scorepoint1");
            return (Criteria) this;
        }

        public Criteria andScorepoint1NotBetween(Double value1, Double value2) {
            addCriterion("scorePoint1 not between", value1, value2, "scorepoint1");
            return (Criteria) this;
        }

        public Criteria andScorepoint2IsNull() {
            addCriterion("scorePoint2 is null");
            return (Criteria) this;
        }

        public Criteria andScorepoint2IsNotNull() {
            addCriterion("scorePoint2 is not null");
            return (Criteria) this;
        }

        public Criteria andScorepoint2EqualTo(Double value) {
            addCriterion("scorePoint2 =", value, "scorepoint2");
            return (Criteria) this;
        }

        public Criteria andScorepoint2NotEqualTo(Double value) {
            addCriterion("scorePoint2 <>", value, "scorepoint2");
            return (Criteria) this;
        }

        public Criteria andScorepoint2GreaterThan(Double value) {
            addCriterion("scorePoint2 >", value, "scorepoint2");
            return (Criteria) this;
        }

        public Criteria andScorepoint2GreaterThanOrEqualTo(Double value) {
            addCriterion("scorePoint2 >=", value, "scorepoint2");
            return (Criteria) this;
        }

        public Criteria andScorepoint2LessThan(Double value) {
            addCriterion("scorePoint2 <", value, "scorepoint2");
            return (Criteria) this;
        }

        public Criteria andScorepoint2LessThanOrEqualTo(Double value) {
            addCriterion("scorePoint2 <=", value, "scorepoint2");
            return (Criteria) this;
        }

        public Criteria andScorepoint2In(List<Double> values) {
            addCriterion("scorePoint2 in", values, "scorepoint2");
            return (Criteria) this;
        }

        public Criteria andScorepoint2NotIn(List<Double> values) {
            addCriterion("scorePoint2 not in", values, "scorepoint2");
            return (Criteria) this;
        }

        public Criteria andScorepoint2Between(Double value1, Double value2) {
            addCriterion("scorePoint2 between", value1, value2, "scorepoint2");
            return (Criteria) this;
        }

        public Criteria andScorepoint2NotBetween(Double value1, Double value2) {
            addCriterion("scorePoint2 not between", value1, value2, "scorepoint2");
            return (Criteria) this;
        }

        public Criteria andScorepoint3IsNull() {
            addCriterion("scorePoint3 is null");
            return (Criteria) this;
        }

        public Criteria andScorepoint3IsNotNull() {
            addCriterion("scorePoint3 is not null");
            return (Criteria) this;
        }

        public Criteria andScorepoint3EqualTo(Double value) {
            addCriterion("scorePoint3 =", value, "scorepoint3");
            return (Criteria) this;
        }

        public Criteria andScorepoint3NotEqualTo(Double value) {
            addCriterion("scorePoint3 <>", value, "scorepoint3");
            return (Criteria) this;
        }

        public Criteria andScorepoint3GreaterThan(Double value) {
            addCriterion("scorePoint3 >", value, "scorepoint3");
            return (Criteria) this;
        }

        public Criteria andScorepoint3GreaterThanOrEqualTo(Double value) {
            addCriterion("scorePoint3 >=", value, "scorepoint3");
            return (Criteria) this;
        }

        public Criteria andScorepoint3LessThan(Double value) {
            addCriterion("scorePoint3 <", value, "scorepoint3");
            return (Criteria) this;
        }

        public Criteria andScorepoint3LessThanOrEqualTo(Double value) {
            addCriterion("scorePoint3 <=", value, "scorepoint3");
            return (Criteria) this;
        }

        public Criteria andScorepoint3In(List<Double> values) {
            addCriterion("scorePoint3 in", values, "scorepoint3");
            return (Criteria) this;
        }

        public Criteria andScorepoint3NotIn(List<Double> values) {
            addCriterion("scorePoint3 not in", values, "scorepoint3");
            return (Criteria) this;
        }

        public Criteria andScorepoint3Between(Double value1, Double value2) {
            addCriterion("scorePoint3 between", value1, value2, "scorepoint3");
            return (Criteria) this;
        }

        public Criteria andScorepoint3NotBetween(Double value1, Double value2) {
            addCriterion("scorePoint3 not between", value1, value2, "scorepoint3");
            return (Criteria) this;
        }

        public Criteria andScorepoint4IsNull() {
            addCriterion("scorePoint4 is null");
            return (Criteria) this;
        }

        public Criteria andScorepoint4IsNotNull() {
            addCriterion("scorePoint4 is not null");
            return (Criteria) this;
        }

        public Criteria andScorepoint4EqualTo(Double value) {
            addCriterion("scorePoint4 =", value, "scorepoint4");
            return (Criteria) this;
        }

        public Criteria andScorepoint4NotEqualTo(Double value) {
            addCriterion("scorePoint4 <>", value, "scorepoint4");
            return (Criteria) this;
        }

        public Criteria andScorepoint4GreaterThan(Double value) {
            addCriterion("scorePoint4 >", value, "scorepoint4");
            return (Criteria) this;
        }

        public Criteria andScorepoint4GreaterThanOrEqualTo(Double value) {
            addCriterion("scorePoint4 >=", value, "scorepoint4");
            return (Criteria) this;
        }

        public Criteria andScorepoint4LessThan(Double value) {
            addCriterion("scorePoint4 <", value, "scorepoint4");
            return (Criteria) this;
        }

        public Criteria andScorepoint4LessThanOrEqualTo(Double value) {
            addCriterion("scorePoint4 <=", value, "scorepoint4");
            return (Criteria) this;
        }

        public Criteria andScorepoint4In(List<Double> values) {
            addCriterion("scorePoint4 in", values, "scorepoint4");
            return (Criteria) this;
        }

        public Criteria andScorepoint4NotIn(List<Double> values) {
            addCriterion("scorePoint4 not in", values, "scorepoint4");
            return (Criteria) this;
        }

        public Criteria andScorepoint4Between(Double value1, Double value2) {
            addCriterion("scorePoint4 between", value1, value2, "scorepoint4");
            return (Criteria) this;
        }

        public Criteria andScorepoint4NotBetween(Double value1, Double value2) {
            addCriterion("scorePoint4 not between", value1, value2, "scorepoint4");
            return (Criteria) this;
        }

        public Criteria andScorepoint5IsNull() {
            addCriterion("scorePoint5 is null");
            return (Criteria) this;
        }

        public Criteria andScorepoint5IsNotNull() {
            addCriterion("scorePoint5 is not null");
            return (Criteria) this;
        }

        public Criteria andScorepoint5EqualTo(Double value) {
            addCriterion("scorePoint5 =", value, "scorepoint5");
            return (Criteria) this;
        }

        public Criteria andScorepoint5NotEqualTo(Double value) {
            addCriterion("scorePoint5 <>", value, "scorepoint5");
            return (Criteria) this;
        }

        public Criteria andScorepoint5GreaterThan(Double value) {
            addCriterion("scorePoint5 >", value, "scorepoint5");
            return (Criteria) this;
        }

        public Criteria andScorepoint5GreaterThanOrEqualTo(Double value) {
            addCriterion("scorePoint5 >=", value, "scorepoint5");
            return (Criteria) this;
        }

        public Criteria andScorepoint5LessThan(Double value) {
            addCriterion("scorePoint5 <", value, "scorepoint5");
            return (Criteria) this;
        }

        public Criteria andScorepoint5LessThanOrEqualTo(Double value) {
            addCriterion("scorePoint5 <=", value, "scorepoint5");
            return (Criteria) this;
        }

        public Criteria andScorepoint5In(List<Double> values) {
            addCriterion("scorePoint5 in", values, "scorepoint5");
            return (Criteria) this;
        }

        public Criteria andScorepoint5NotIn(List<Double> values) {
            addCriterion("scorePoint5 not in", values, "scorepoint5");
            return (Criteria) this;
        }

        public Criteria andScorepoint5Between(Double value1, Double value2) {
            addCriterion("scorePoint5 between", value1, value2, "scorepoint5");
            return (Criteria) this;
        }

        public Criteria andScorepoint5NotBetween(Double value1, Double value2) {
            addCriterion("scorePoint5 not between", value1, value2, "scorepoint5");
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