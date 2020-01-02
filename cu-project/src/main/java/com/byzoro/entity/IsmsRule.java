package com.byzoro.entity;

import java.io.Serializable;

/**
 * isms_rule
 * @author 
 */
public class IsmsRule implements Serializable {
    /**
     * 自增 主健
     */
    private Long id;

    /**
     * 与策略表中的ID关联
     */
    private Long commandid;

    /**
     * 规则代码，见10.7
     */
    private Boolean subtype;

    /**
     * 规则为IP时为起始值，其它类型为规则内容
     */
    private String valueStart;

    /**
     * 仅在IP规则有效，标识结束IP
     */
    private String valueEnd;

    /**
     * 0正文标题及正文本身，1 附件文件题目，2 附件正文 多个之间使用半角逗号隔开
     */
    private String keywordRange;

    private static final long serialVersionUID = 1L;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getCommandid() {
        return commandid;
    }

    public void setCommandid(Long commandid) {
        this.commandid = commandid;
    }

    public Boolean getSubtype() {
        return subtype;
    }

    public void setSubtype(Boolean subtype) {
        this.subtype = subtype;
    }

    public String getValueStart() {
        return valueStart;
    }

    public void setValueStart(String valueStart) {
        this.valueStart = valueStart;
    }

    public String getValueEnd() {
        return valueEnd;
    }

    public void setValueEnd(String valueEnd) {
        this.valueEnd = valueEnd;
    }

    public String getKeywordRange() {
        return keywordRange;
    }

    public void setKeywordRange(String keywordRange) {
        this.keywordRange = keywordRange;
    }

    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        IsmsRule other = (IsmsRule) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getCommandid() == null ? other.getCommandid() == null : this.getCommandid().equals(other.getCommandid()))
            && (this.getSubtype() == null ? other.getSubtype() == null : this.getSubtype().equals(other.getSubtype()))
            && (this.getValueStart() == null ? other.getValueStart() == null : this.getValueStart().equals(other.getValueStart()))
            && (this.getValueEnd() == null ? other.getValueEnd() == null : this.getValueEnd().equals(other.getValueEnd()))
            && (this.getKeywordRange() == null ? other.getKeywordRange() == null : this.getKeywordRange().equals(other.getKeywordRange()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getCommandid() == null) ? 0 : getCommandid().hashCode());
        result = prime * result + ((getSubtype() == null) ? 0 : getSubtype().hashCode());
        result = prime * result + ((getValueStart() == null) ? 0 : getValueStart().hashCode());
        result = prime * result + ((getValueEnd() == null) ? 0 : getValueEnd().hashCode());
        result = prime * result + ((getKeywordRange() == null) ? 0 : getKeywordRange().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", commandid=").append(commandid);
        sb.append(", subtype=").append(subtype);
        sb.append(", valueStart=").append(valueStart);
        sb.append(", valueEnd=").append(valueEnd);
        sb.append(", keywordRange=").append(keywordRange);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}