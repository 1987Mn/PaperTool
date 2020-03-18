package com.lzw.domain;

import java.util.ArrayList;
import java.util.List;

public class SmallquestionExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public SmallquestionExample() {
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

        public Criteria andQuestionidIsNull() {
            addCriterion("questionId is null");
            return (Criteria) this;
        }

        public Criteria andQuestionidIsNotNull() {
            addCriterion("questionId is not null");
            return (Criteria) this;
        }

        public Criteria andQuestionidEqualTo(Integer value) {
            addCriterion("questionId =", value, "questionid");
            return (Criteria) this;
        }

        public Criteria andQuestionidNotEqualTo(Integer value) {
            addCriterion("questionId <>", value, "questionid");
            return (Criteria) this;
        }

        public Criteria andQuestionidGreaterThan(Integer value) {
            addCriterion("questionId >", value, "questionid");
            return (Criteria) this;
        }

        public Criteria andQuestionidGreaterThanOrEqualTo(Integer value) {
            addCriterion("questionId >=", value, "questionid");
            return (Criteria) this;
        }

        public Criteria andQuestionidLessThan(Integer value) {
            addCriterion("questionId <", value, "questionid");
            return (Criteria) this;
        }

        public Criteria andQuestionidLessThanOrEqualTo(Integer value) {
            addCriterion("questionId <=", value, "questionid");
            return (Criteria) this;
        }

        public Criteria andQuestionidIn(List<Integer> values) {
            addCriterion("questionId in", values, "questionid");
            return (Criteria) this;
        }

        public Criteria andQuestionidNotIn(List<Integer> values) {
            addCriterion("questionId not in", values, "questionid");
            return (Criteria) this;
        }

        public Criteria andQuestionidBetween(Integer value1, Integer value2) {
            addCriterion("questionId between", value1, value2, "questionid");
            return (Criteria) this;
        }

        public Criteria andQuestionidNotBetween(Integer value1, Integer value2) {
            addCriterion("questionId not between", value1, value2, "questionid");
            return (Criteria) this;
        }

        public Criteria andContentIsNull() {
            addCriterion("content is null");
            return (Criteria) this;
        }

        public Criteria andContentIsNotNull() {
            addCriterion("content is not null");
            return (Criteria) this;
        }

        public Criteria andContentEqualTo(String value) {
            addCriterion("content =", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentNotEqualTo(String value) {
            addCriterion("content <>", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentGreaterThan(String value) {
            addCriterion("content >", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentGreaterThanOrEqualTo(String value) {
            addCriterion("content >=", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentLessThan(String value) {
            addCriterion("content <", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentLessThanOrEqualTo(String value) {
            addCriterion("content <=", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentLike(String value) {
            addCriterion("content like", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentNotLike(String value) {
            addCriterion("content not like", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentIn(List<String> values) {
            addCriterion("content in", values, "content");
            return (Criteria) this;
        }

        public Criteria andContentNotIn(List<String> values) {
            addCriterion("content not in", values, "content");
            return (Criteria) this;
        }

        public Criteria andContentBetween(String value1, String value2) {
            addCriterion("content between", value1, value2, "content");
            return (Criteria) this;
        }

        public Criteria andContentNotBetween(String value1, String value2) {
            addCriterion("content not between", value1, value2, "content");
            return (Criteria) this;
        }

        public Criteria andScoreIsNull() {
            addCriterion("score is null");
            return (Criteria) this;
        }

        public Criteria andScoreIsNotNull() {
            addCriterion("score is not null");
            return (Criteria) this;
        }

        public Criteria andScoreEqualTo(Double value) {
            addCriterion("score =", value, "score");
            return (Criteria) this;
        }

        public Criteria andScoreNotEqualTo(Double value) {
            addCriterion("score <>", value, "score");
            return (Criteria) this;
        }

        public Criteria andScoreGreaterThan(Double value) {
            addCriterion("score >", value, "score");
            return (Criteria) this;
        }

        public Criteria andScoreGreaterThanOrEqualTo(Double value) {
            addCriterion("score >=", value, "score");
            return (Criteria) this;
        }

        public Criteria andScoreLessThan(Double value) {
            addCriterion("score <", value, "score");
            return (Criteria) this;
        }

        public Criteria andScoreLessThanOrEqualTo(Double value) {
            addCriterion("score <=", value, "score");
            return (Criteria) this;
        }

        public Criteria andScoreIn(List<Double> values) {
            addCriterion("score in", values, "score");
            return (Criteria) this;
        }

        public Criteria andScoreNotIn(List<Double> values) {
            addCriterion("score not in", values, "score");
            return (Criteria) this;
        }

        public Criteria andScoreBetween(Double value1, Double value2) {
            addCriterion("score between", value1, value2, "score");
            return (Criteria) this;
        }

        public Criteria andScoreNotBetween(Double value1, Double value2) {
            addCriterion("score not between", value1, value2, "score");
            return (Criteria) this;
        }

        public Criteria andScorepointnumIsNull() {
            addCriterion("scorePointNum is null");
            return (Criteria) this;
        }

        public Criteria andScorepointnumIsNotNull() {
            addCriterion("scorePointNum is not null");
            return (Criteria) this;
        }

        public Criteria andScorepointnumEqualTo(Integer value) {
            addCriterion("scorePointNum =", value, "scorepointnum");
            return (Criteria) this;
        }

        public Criteria andScorepointnumNotEqualTo(Integer value) {
            addCriterion("scorePointNum <>", value, "scorepointnum");
            return (Criteria) this;
        }

        public Criteria andScorepointnumGreaterThan(Integer value) {
            addCriterion("scorePointNum >", value, "scorepointnum");
            return (Criteria) this;
        }

        public Criteria andScorepointnumGreaterThanOrEqualTo(Integer value) {
            addCriterion("scorePointNum >=", value, "scorepointnum");
            return (Criteria) this;
        }

        public Criteria andScorepointnumLessThan(Integer value) {
            addCriterion("scorePointNum <", value, "scorepointnum");
            return (Criteria) this;
        }

        public Criteria andScorepointnumLessThanOrEqualTo(Integer value) {
            addCriterion("scorePointNum <=", value, "scorepointnum");
            return (Criteria) this;
        }

        public Criteria andScorepointnumIn(List<Integer> values) {
            addCriterion("scorePointNum in", values, "scorepointnum");
            return (Criteria) this;
        }

        public Criteria andScorepointnumNotIn(List<Integer> values) {
            addCriterion("scorePointNum not in", values, "scorepointnum");
            return (Criteria) this;
        }

        public Criteria andScorepointnumBetween(Integer value1, Integer value2) {
            addCriterion("scorePointNum between", value1, value2, "scorepointnum");
            return (Criteria) this;
        }

        public Criteria andScorepointnumNotBetween(Integer value1, Integer value2) {
            addCriterion("scorePointNum not between", value1, value2, "scorepointnum");
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