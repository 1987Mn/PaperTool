package com.lzw.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class PaperExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public PaperExample() {
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

        public Criteria andTitleIsNull() {
            addCriterion("title is null");
            return (Criteria) this;
        }

        public Criteria andTitleIsNotNull() {
            addCriterion("title is not null");
            return (Criteria) this;
        }

        public Criteria andTitleEqualTo(String value) {
            addCriterion("title =", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleNotEqualTo(String value) {
            addCriterion("title <>", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleGreaterThan(String value) {
            addCriterion("title >", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleGreaterThanOrEqualTo(String value) {
            addCriterion("title >=", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleLessThan(String value) {
            addCriterion("title <", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleLessThanOrEqualTo(String value) {
            addCriterion("title <=", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleLike(String value) {
            addCriterion("title like", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleNotLike(String value) {
            addCriterion("title not like", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleIn(List<String> values) {
            addCriterion("title in", values, "title");
            return (Criteria) this;
        }

        public Criteria andTitleNotIn(List<String> values) {
            addCriterion("title not in", values, "title");
            return (Criteria) this;
        }

        public Criteria andTitleBetween(String value1, String value2) {
            addCriterion("title between", value1, value2, "title");
            return (Criteria) this;
        }

        public Criteria andTitleNotBetween(String value1, String value2) {
            addCriterion("title not between", value1, value2, "title");
            return (Criteria) this;
        }

        public Criteria andCourseIsNull() {
            addCriterion("course is null");
            return (Criteria) this;
        }

        public Criteria andCourseIsNotNull() {
            addCriterion("course is not null");
            return (Criteria) this;
        }

        public Criteria andCourseEqualTo(String value) {
            addCriterion("course =", value, "course");
            return (Criteria) this;
        }

        public Criteria andCourseNotEqualTo(String value) {
            addCriterion("course <>", value, "course");
            return (Criteria) this;
        }

        public Criteria andCourseGreaterThan(String value) {
            addCriterion("course >", value, "course");
            return (Criteria) this;
        }

        public Criteria andCourseGreaterThanOrEqualTo(String value) {
            addCriterion("course >=", value, "course");
            return (Criteria) this;
        }

        public Criteria andCourseLessThan(String value) {
            addCriterion("course <", value, "course");
            return (Criteria) this;
        }

        public Criteria andCourseLessThanOrEqualTo(String value) {
            addCriterion("course <=", value, "course");
            return (Criteria) this;
        }

        public Criteria andCourseLike(String value) {
            addCriterion("course like", value, "course");
            return (Criteria) this;
        }

        public Criteria andCourseNotLike(String value) {
            addCriterion("course not like", value, "course");
            return (Criteria) this;
        }

        public Criteria andCourseIn(List<String> values) {
            addCriterion("course in", values, "course");
            return (Criteria) this;
        }

        public Criteria andCourseNotIn(List<String> values) {
            addCriterion("course not in", values, "course");
            return (Criteria) this;
        }

        public Criteria andCourseBetween(String value1, String value2) {
            addCriterion("course between", value1, value2, "course");
            return (Criteria) this;
        }

        public Criteria andCourseNotBetween(String value1, String value2) {
            addCriterion("course not between", value1, value2, "course");
            return (Criteria) this;
        }

        public Criteria andCoursenumIsNull() {
            addCriterion("courseNum is null");
            return (Criteria) this;
        }

        public Criteria andCoursenumIsNotNull() {
            addCriterion("courseNum is not null");
            return (Criteria) this;
        }

        public Criteria andCoursenumEqualTo(String value) {
            addCriterion("courseNum =", value, "coursenum");
            return (Criteria) this;
        }

        public Criteria andCoursenumNotEqualTo(String value) {
            addCriterion("courseNum <>", value, "coursenum");
            return (Criteria) this;
        }

        public Criteria andCoursenumGreaterThan(String value) {
            addCriterion("courseNum >", value, "coursenum");
            return (Criteria) this;
        }

        public Criteria andCoursenumGreaterThanOrEqualTo(String value) {
            addCriterion("courseNum >=", value, "coursenum");
            return (Criteria) this;
        }

        public Criteria andCoursenumLessThan(String value) {
            addCriterion("courseNum <", value, "coursenum");
            return (Criteria) this;
        }

        public Criteria andCoursenumLessThanOrEqualTo(String value) {
            addCriterion("courseNum <=", value, "coursenum");
            return (Criteria) this;
        }

        public Criteria andCoursenumLike(String value) {
            addCriterion("courseNum like", value, "coursenum");
            return (Criteria) this;
        }

        public Criteria andCoursenumNotLike(String value) {
            addCriterion("courseNum not like", value, "coursenum");
            return (Criteria) this;
        }

        public Criteria andCoursenumIn(List<String> values) {
            addCriterion("courseNum in", values, "coursenum");
            return (Criteria) this;
        }

        public Criteria andCoursenumNotIn(List<String> values) {
            addCriterion("courseNum not in", values, "coursenum");
            return (Criteria) this;
        }

        public Criteria andCoursenumBetween(String value1, String value2) {
            addCriterion("courseNum between", value1, value2, "coursenum");
            return (Criteria) this;
        }

        public Criteria andCoursenumNotBetween(String value1, String value2) {
            addCriterion("courseNum not between", value1, value2, "coursenum");
            return (Criteria) this;
        }

        public Criteria andCollegeIsNull() {
            addCriterion("college is null");
            return (Criteria) this;
        }

        public Criteria andCollegeIsNotNull() {
            addCriterion("college is not null");
            return (Criteria) this;
        }

        public Criteria andCollegeEqualTo(String value) {
            addCriterion("college =", value, "college");
            return (Criteria) this;
        }

        public Criteria andCollegeNotEqualTo(String value) {
            addCriterion("college <>", value, "college");
            return (Criteria) this;
        }

        public Criteria andCollegeGreaterThan(String value) {
            addCriterion("college >", value, "college");
            return (Criteria) this;
        }

        public Criteria andCollegeGreaterThanOrEqualTo(String value) {
            addCriterion("college >=", value, "college");
            return (Criteria) this;
        }

        public Criteria andCollegeLessThan(String value) {
            addCriterion("college <", value, "college");
            return (Criteria) this;
        }

        public Criteria andCollegeLessThanOrEqualTo(String value) {
            addCriterion("college <=", value, "college");
            return (Criteria) this;
        }

        public Criteria andCollegeLike(String value) {
            addCriterion("college like", value, "college");
            return (Criteria) this;
        }

        public Criteria andCollegeNotLike(String value) {
            addCriterion("college not like", value, "college");
            return (Criteria) this;
        }

        public Criteria andCollegeIn(List<String> values) {
            addCriterion("college in", values, "college");
            return (Criteria) this;
        }

        public Criteria andCollegeNotIn(List<String> values) {
            addCriterion("college not in", values, "college");
            return (Criteria) this;
        }

        public Criteria andCollegeBetween(String value1, String value2) {
            addCriterion("college between", value1, value2, "college");
            return (Criteria) this;
        }

        public Criteria andCollegeNotBetween(String value1, String value2) {
            addCriterion("college not between", value1, value2, "college");
            return (Criteria) this;
        }

        public Criteria andTeacherIsNull() {
            addCriterion("teacher is null");
            return (Criteria) this;
        }

        public Criteria andTeacherIsNotNull() {
            addCriterion("teacher is not null");
            return (Criteria) this;
        }

        public Criteria andTeacherEqualTo(String value) {
            addCriterion("teacher =", value, "teacher");
            return (Criteria) this;
        }

        public Criteria andTeacherNotEqualTo(String value) {
            addCriterion("teacher <>", value, "teacher");
            return (Criteria) this;
        }

        public Criteria andTeacherGreaterThan(String value) {
            addCriterion("teacher >", value, "teacher");
            return (Criteria) this;
        }

        public Criteria andTeacherGreaterThanOrEqualTo(String value) {
            addCriterion("teacher >=", value, "teacher");
            return (Criteria) this;
        }

        public Criteria andTeacherLessThan(String value) {
            addCriterion("teacher <", value, "teacher");
            return (Criteria) this;
        }

        public Criteria andTeacherLessThanOrEqualTo(String value) {
            addCriterion("teacher <=", value, "teacher");
            return (Criteria) this;
        }

        public Criteria andTeacherLike(String value) {
            addCriterion("teacher like", value, "teacher");
            return (Criteria) this;
        }

        public Criteria andTeacherNotLike(String value) {
            addCriterion("teacher not like", value, "teacher");
            return (Criteria) this;
        }

        public Criteria andTeacherIn(List<String> values) {
            addCriterion("teacher in", values, "teacher");
            return (Criteria) this;
        }

        public Criteria andTeacherNotIn(List<String> values) {
            addCriterion("teacher not in", values, "teacher");
            return (Criteria) this;
        }

        public Criteria andTeacherBetween(String value1, String value2) {
            addCriterion("teacher between", value1, value2, "teacher");
            return (Criteria) this;
        }

        public Criteria andTeacherNotBetween(String value1, String value2) {
            addCriterion("teacher not between", value1, value2, "teacher");
            return (Criteria) this;
        }

        public Criteria andClassamajorIsNull() {
            addCriterion("classAMajor is null");
            return (Criteria) this;
        }

        public Criteria andClassamajorIsNotNull() {
            addCriterion("classAMajor is not null");
            return (Criteria) this;
        }

        public Criteria andClassamajorEqualTo(String value) {
            addCriterion("classAMajor =", value, "classamajor");
            return (Criteria) this;
        }

        public Criteria andClassamajorNotEqualTo(String value) {
            addCriterion("classAMajor <>", value, "classamajor");
            return (Criteria) this;
        }

        public Criteria andClassamajorGreaterThan(String value) {
            addCriterion("classAMajor >", value, "classamajor");
            return (Criteria) this;
        }

        public Criteria andClassamajorGreaterThanOrEqualTo(String value) {
            addCriterion("classAMajor >=", value, "classamajor");
            return (Criteria) this;
        }

        public Criteria andClassamajorLessThan(String value) {
            addCriterion("classAMajor <", value, "classamajor");
            return (Criteria) this;
        }

        public Criteria andClassamajorLessThanOrEqualTo(String value) {
            addCriterion("classAMajor <=", value, "classamajor");
            return (Criteria) this;
        }

        public Criteria andClassamajorLike(String value) {
            addCriterion("classAMajor like", value, "classamajor");
            return (Criteria) this;
        }

        public Criteria andClassamajorNotLike(String value) {
            addCriterion("classAMajor not like", value, "classamajor");
            return (Criteria) this;
        }

        public Criteria andClassamajorIn(List<String> values) {
            addCriterion("classAMajor in", values, "classamajor");
            return (Criteria) this;
        }

        public Criteria andClassamajorNotIn(List<String> values) {
            addCriterion("classAMajor not in", values, "classamajor");
            return (Criteria) this;
        }

        public Criteria andClassamajorBetween(String value1, String value2) {
            addCriterion("classAMajor between", value1, value2, "classamajor");
            return (Criteria) this;
        }

        public Criteria andClassamajorNotBetween(String value1, String value2) {
            addCriterion("classAMajor not between", value1, value2, "classamajor");
            return (Criteria) this;
        }

        public Criteria andTestnumIsNull() {
            addCriterion("testNum is null");
            return (Criteria) this;
        }

        public Criteria andTestnumIsNotNull() {
            addCriterion("testNum is not null");
            return (Criteria) this;
        }

        public Criteria andTestnumEqualTo(String value) {
            addCriterion("testNum =", value, "testnum");
            return (Criteria) this;
        }

        public Criteria andTestnumNotEqualTo(String value) {
            addCriterion("testNum <>", value, "testnum");
            return (Criteria) this;
        }

        public Criteria andTestnumGreaterThan(String value) {
            addCriterion("testNum >", value, "testnum");
            return (Criteria) this;
        }

        public Criteria andTestnumGreaterThanOrEqualTo(String value) {
            addCriterion("testNum >=", value, "testnum");
            return (Criteria) this;
        }

        public Criteria andTestnumLessThan(String value) {
            addCriterion("testNum <", value, "testnum");
            return (Criteria) this;
        }

        public Criteria andTestnumLessThanOrEqualTo(String value) {
            addCriterion("testNum <=", value, "testnum");
            return (Criteria) this;
        }

        public Criteria andTestnumLike(String value) {
            addCriterion("testNum like", value, "testnum");
            return (Criteria) this;
        }

        public Criteria andTestnumNotLike(String value) {
            addCriterion("testNum not like", value, "testnum");
            return (Criteria) this;
        }

        public Criteria andTestnumIn(List<String> values) {
            addCriterion("testNum in", values, "testnum");
            return (Criteria) this;
        }

        public Criteria andTestnumNotIn(List<String> values) {
            addCriterion("testNum not in", values, "testnum");
            return (Criteria) this;
        }

        public Criteria andTestnumBetween(String value1, String value2) {
            addCriterion("testNum between", value1, value2, "testnum");
            return (Criteria) this;
        }

        public Criteria andTestnumNotBetween(String value1, String value2) {
            addCriterion("testNum not between", value1, value2, "testnum");
            return (Criteria) this;
        }

        public Criteria andTesttimeIsNull() {
            addCriterion("testTime is null");
            return (Criteria) this;
        }

        public Criteria andTesttimeIsNotNull() {
            addCriterion("testTime is not null");
            return (Criteria) this;
        }

        public Criteria andTesttimeEqualTo(Date value) {
            addCriterion("testTime =", value, "testtime");
            return (Criteria) this;
        }

        public Criteria andTesttimeNotEqualTo(Date value) {
            addCriterion("testTime <>", value, "testtime");
            return (Criteria) this;
        }

        public Criteria andTesttimeGreaterThan(Date value) {
            addCriterion("testTime >", value, "testtime");
            return (Criteria) this;
        }

        public Criteria andTesttimeGreaterThanOrEqualTo(Date value) {
            addCriterion("testTime >=", value, "testtime");
            return (Criteria) this;
        }

        public Criteria andTesttimeLessThan(Date value) {
            addCriterion("testTime <", value, "testtime");
            return (Criteria) this;
        }

        public Criteria andTesttimeLessThanOrEqualTo(Date value) {
            addCriterion("testTime <=", value, "testtime");
            return (Criteria) this;
        }

        public Criteria andTesttimeIn(List<Date> values) {
            addCriterion("testTime in", values, "testtime");
            return (Criteria) this;
        }

        public Criteria andTesttimeNotIn(List<Date> values) {
            addCriterion("testTime not in", values, "testtime");
            return (Criteria) this;
        }

        public Criteria andTesttimeBetween(Date value1, Date value2) {
            addCriterion("testTime between", value1, value2, "testtime");
            return (Criteria) this;
        }

        public Criteria andTesttimeNotBetween(Date value1, Date value2) {
            addCriterion("testTime not between", value1, value2, "testtime");
            return (Criteria) this;
        }

        public Criteria andTestwayIsNull() {
            addCriterion("testWay is null");
            return (Criteria) this;
        }

        public Criteria andTestwayIsNotNull() {
            addCriterion("testWay is not null");
            return (Criteria) this;
        }

        public Criteria andTestwayEqualTo(String value) {
            addCriterion("testWay =", value, "testway");
            return (Criteria) this;
        }

        public Criteria andTestwayNotEqualTo(String value) {
            addCriterion("testWay <>", value, "testway");
            return (Criteria) this;
        }

        public Criteria andTestwayGreaterThan(String value) {
            addCriterion("testWay >", value, "testway");
            return (Criteria) this;
        }

        public Criteria andTestwayGreaterThanOrEqualTo(String value) {
            addCriterion("testWay >=", value, "testway");
            return (Criteria) this;
        }

        public Criteria andTestwayLessThan(String value) {
            addCriterion("testWay <", value, "testway");
            return (Criteria) this;
        }

        public Criteria andTestwayLessThanOrEqualTo(String value) {
            addCriterion("testWay <=", value, "testway");
            return (Criteria) this;
        }

        public Criteria andTestwayLike(String value) {
            addCriterion("testWay like", value, "testway");
            return (Criteria) this;
        }

        public Criteria andTestwayNotLike(String value) {
            addCriterion("testWay not like", value, "testway");
            return (Criteria) this;
        }

        public Criteria andTestwayIn(List<String> values) {
            addCriterion("testWay in", values, "testway");
            return (Criteria) this;
        }

        public Criteria andTestwayNotIn(List<String> values) {
            addCriterion("testWay not in", values, "testway");
            return (Criteria) this;
        }

        public Criteria andTestwayBetween(String value1, String value2) {
            addCriterion("testWay between", value1, value2, "testway");
            return (Criteria) this;
        }

        public Criteria andTestwayNotBetween(String value1, String value2) {
            addCriterion("testWay not between", value1, value2, "testway");
            return (Criteria) this;
        }

        public Criteria andQuestionnumIsNull() {
            addCriterion("questionNum is null");
            return (Criteria) this;
        }

        public Criteria andQuestionnumIsNotNull() {
            addCriterion("questionNum is not null");
            return (Criteria) this;
        }

        public Criteria andQuestionnumEqualTo(Integer value) {
            addCriterion("questionNum =", value, "questionnum");
            return (Criteria) this;
        }

        public Criteria andQuestionnumNotEqualTo(Integer value) {
            addCriterion("questionNum <>", value, "questionnum");
            return (Criteria) this;
        }

        public Criteria andQuestionnumGreaterThan(Integer value) {
            addCriterion("questionNum >", value, "questionnum");
            return (Criteria) this;
        }

        public Criteria andQuestionnumGreaterThanOrEqualTo(Integer value) {
            addCriterion("questionNum >=", value, "questionnum");
            return (Criteria) this;
        }

        public Criteria andQuestionnumLessThan(Integer value) {
            addCriterion("questionNum <", value, "questionnum");
            return (Criteria) this;
        }

        public Criteria andQuestionnumLessThanOrEqualTo(Integer value) {
            addCriterion("questionNum <=", value, "questionnum");
            return (Criteria) this;
        }

        public Criteria andQuestionnumIn(List<Integer> values) {
            addCriterion("questionNum in", values, "questionnum");
            return (Criteria) this;
        }

        public Criteria andQuestionnumNotIn(List<Integer> values) {
            addCriterion("questionNum not in", values, "questionnum");
            return (Criteria) this;
        }

        public Criteria andQuestionnumBetween(Integer value1, Integer value2) {
            addCriterion("questionNum between", value1, value2, "questionnum");
            return (Criteria) this;
        }

        public Criteria andQuestionnumNotBetween(Integer value1, Integer value2) {
            addCriterion("questionNum not between", value1, value2, "questionnum");
            return (Criteria) this;
        }

        public Criteria andSmallquestionnumIsNull() {
            addCriterion("smallQuestionNum is null");
            return (Criteria) this;
        }

        public Criteria andSmallquestionnumIsNotNull() {
            addCriterion("smallQuestionNum is not null");
            return (Criteria) this;
        }

        public Criteria andSmallquestionnumEqualTo(Integer value) {
            addCriterion("smallQuestionNum =", value, "smallquestionnum");
            return (Criteria) this;
        }

        public Criteria andSmallquestionnumNotEqualTo(Integer value) {
            addCriterion("smallQuestionNum <>", value, "smallquestionnum");
            return (Criteria) this;
        }

        public Criteria andSmallquestionnumGreaterThan(Integer value) {
            addCriterion("smallQuestionNum >", value, "smallquestionnum");
            return (Criteria) this;
        }

        public Criteria andSmallquestionnumGreaterThanOrEqualTo(Integer value) {
            addCriterion("smallQuestionNum >=", value, "smallquestionnum");
            return (Criteria) this;
        }

        public Criteria andSmallquestionnumLessThan(Integer value) {
            addCriterion("smallQuestionNum <", value, "smallquestionnum");
            return (Criteria) this;
        }

        public Criteria andSmallquestionnumLessThanOrEqualTo(Integer value) {
            addCriterion("smallQuestionNum <=", value, "smallquestionnum");
            return (Criteria) this;
        }

        public Criteria andSmallquestionnumIn(List<Integer> values) {
            addCriterion("smallQuestionNum in", values, "smallquestionnum");
            return (Criteria) this;
        }

        public Criteria andSmallquestionnumNotIn(List<Integer> values) {
            addCriterion("smallQuestionNum not in", values, "smallquestionnum");
            return (Criteria) this;
        }

        public Criteria andSmallquestionnumBetween(Integer value1, Integer value2) {
            addCriterion("smallQuestionNum between", value1, value2, "smallquestionnum");
            return (Criteria) this;
        }

        public Criteria andSmallquestionnumNotBetween(Integer value1, Integer value2) {
            addCriterion("smallQuestionNum not between", value1, value2, "smallquestionnum");
            return (Criteria) this;
        }

        public Criteria andTotalpointsIsNull() {
            addCriterion("totalPoints is null");
            return (Criteria) this;
        }

        public Criteria andTotalpointsIsNotNull() {
            addCriterion("totalPoints is not null");
            return (Criteria) this;
        }

        public Criteria andTotalpointsEqualTo(Double value) {
            addCriterion("totalPoints =", value, "totalpoints");
            return (Criteria) this;
        }

        public Criteria andTotalpointsNotEqualTo(Double value) {
            addCriterion("totalPoints <>", value, "totalpoints");
            return (Criteria) this;
        }

        public Criteria andTotalpointsGreaterThan(Double value) {
            addCriterion("totalPoints >", value, "totalpoints");
            return (Criteria) this;
        }

        public Criteria andTotalpointsGreaterThanOrEqualTo(Double value) {
            addCriterion("totalPoints >=", value, "totalpoints");
            return (Criteria) this;
        }

        public Criteria andTotalpointsLessThan(Double value) {
            addCriterion("totalPoints <", value, "totalpoints");
            return (Criteria) this;
        }

        public Criteria andTotalpointsLessThanOrEqualTo(Double value) {
            addCriterion("totalPoints <=", value, "totalpoints");
            return (Criteria) this;
        }

        public Criteria andTotalpointsIn(List<Double> values) {
            addCriterion("totalPoints in", values, "totalpoints");
            return (Criteria) this;
        }

        public Criteria andTotalpointsNotIn(List<Double> values) {
            addCriterion("totalPoints not in", values, "totalpoints");
            return (Criteria) this;
        }

        public Criteria andTotalpointsBetween(Double value1, Double value2) {
            addCriterion("totalPoints between", value1, value2, "totalpoints");
            return (Criteria) this;
        }

        public Criteria andTotalpointsNotBetween(Double value1, Double value2) {
            addCriterion("totalPoints not between", value1, value2, "totalpoints");
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