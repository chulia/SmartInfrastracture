package com.june.domain.model;

import java.util.Date;

public class OdaaSequence {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column odaa_sequence.biz_key
     *
     * @mbg.generated Thu Nov 09 22:08:17 CST 2023
     */
    private String bizKey;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column odaa_sequence.max_id
     *
     * @mbg.generated Thu Nov 09 22:08:17 CST 2023
     */
    private Long maxId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column odaa_sequence.step
     *
     * @mbg.generated Thu Nov 09 22:08:17 CST 2023
     */
    private Integer step;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column odaa_sequence.description
     *
     * @mbg.generated Thu Nov 09 22:08:17 CST 2023
     */
    private String description;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column odaa_sequence.update_time
     *
     * @mbg.generated Thu Nov 09 22:08:17 CST 2023
     */
    private Date updateTime;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column odaa_sequence.biz_key
     *
     * @return the value of odaa_sequence.biz_key
     *
     * @mbg.generated Thu Nov 09 22:08:17 CST 2023
     */
    public String getBizKey() {
        return bizKey;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column odaa_sequence.biz_key
     *
     * @param bizKey the value for odaa_sequence.biz_key
     *
     * @mbg.generated Thu Nov 09 22:08:17 CST 2023
     */
    public void setBizKey(String bizKey) {
        this.bizKey = bizKey;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column odaa_sequence.max_id
     *
     * @return the value of odaa_sequence.max_id
     *
     * @mbg.generated Thu Nov 09 22:08:17 CST 2023
     */
    public Long getMaxId() {
        return maxId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column odaa_sequence.max_id
     *
     * @param maxId the value for odaa_sequence.max_id
     *
     * @mbg.generated Thu Nov 09 22:08:17 CST 2023
     */
    public void setMaxId(Long maxId) {
        this.maxId = maxId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column odaa_sequence.step
     *
     * @return the value of odaa_sequence.step
     *
     * @mbg.generated Thu Nov 09 22:08:17 CST 2023
     */
    public Integer getStep() {
        return step;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column odaa_sequence.step
     *
     * @param step the value for odaa_sequence.step
     *
     * @mbg.generated Thu Nov 09 22:08:17 CST 2023
     */
    public void setStep(Integer step) {
        this.step = step;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column odaa_sequence.description
     *
     * @return the value of odaa_sequence.description
     *
     * @mbg.generated Thu Nov 09 22:08:17 CST 2023
     */
    public String getDescription() {
        return description;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column odaa_sequence.description
     *
     * @param description the value for odaa_sequence.description
     *
     * @mbg.generated Thu Nov 09 22:08:17 CST 2023
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column odaa_sequence.update_time
     *
     * @return the value of odaa_sequence.update_time
     *
     * @mbg.generated Thu Nov 09 22:08:17 CST 2023
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column odaa_sequence.update_time
     *
     * @param updateTime the value for odaa_sequence.update_time
     *
     * @mbg.generated Thu Nov 09 22:08:17 CST 2023
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}