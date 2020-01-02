package com.byzoro.entity;

import java.util.Date;
import java.util.List;

public class SYSResource {
    private Integer resourceId;

    private String resourceName;

    private String resourceHref;

    private String resourceImage;

    private String resourceType;

    private String resourceDesc;

    private String resourceRemark;

    private String isActive;

    private Integer sortIndex;

    private Integer parentId;

    private String isLeaf;

    private Date createTime;

    private String tempOne;
    
    private List<SYSResource> childList;
    
    private SYSResource parent;


    public String getResourceName() {
        return resourceName;
    }

    public void setResourceName(String resourceName) {
        this.resourceName = resourceName == null ? null : resourceName.trim();
    }

    public String getResourceHref() {
        return resourceHref;
    }

    public void setResourceHref(String resourceHref) {
        this.resourceHref = resourceHref == null ? null : resourceHref.trim();
    }

    public String getResourceImage() {
        return resourceImage;
    }

    public void setResourceImage(String resourceImage) {
        this.resourceImage = resourceImage == null ? null : resourceImage.trim();
    }

    public String getResourceType() {
        return resourceType;
    }

    public void setResourceType(String resourceType) {
        this.resourceType = resourceType == null ? null : resourceType.trim();
    }

    public String getResourceDesc() {
        return resourceDesc;
    }

    public void setResourceDesc(String resourceDesc) {
        this.resourceDesc = resourceDesc == null ? null : resourceDesc.trim();
    }

    public String getResourceRemark() {
        return resourceRemark;
    }

    public void setResourceRemark(String resourceRemark) {
        this.resourceRemark = resourceRemark == null ? null : resourceRemark.trim();
    }

    public String getIsActive() {
        return isActive;
    }

    public void setIsActive(String isActive) {
        this.isActive = isActive == null ? null : isActive.trim();
    }

    public Integer getSortIndex() {
        return sortIndex;
    }

    public void setSortIndex(Integer sortIndex) {
        this.sortIndex = sortIndex;
    }

    public Integer getParentId() {
        return parentId;
    }

    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }

    public String getIsLeaf() {
        return isLeaf;
    }

    public void setIsLeaf(String isLeaf) {
        this.isLeaf = isLeaf == null ? null : isLeaf.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getTempOne() {
        return tempOne;
    }

    public void setTempOne(String tempOne) {
        this.tempOne = tempOne == null ? null : tempOne.trim();
    }

	public Integer getResourceId() {
		return resourceId;
	}

	public void setResourceId(Integer resourceId) {
		this.resourceId = resourceId;
	}

	public List<SYSResource> getChildList() {
		return childList;
	}

	public void setChildList(List<SYSResource> childList) {
		this.childList = childList;
	}

	public SYSResource getParent() {
		return parent;
	}

	public void setParent(SYSResource parent) {
		this.parent = parent;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((childList == null) ? 0 : childList.hashCode());
		result = prime * result + ((createTime == null) ? 0 : createTime.hashCode());
		result = prime * result + ((isActive == null) ? 0 : isActive.hashCode());
		result = prime * result + ((isLeaf == null) ? 0 : isLeaf.hashCode());
		result = prime * result + ((parent == null) ? 0 : parent.hashCode());
		result = prime * result + ((parentId == null) ? 0 : parentId.hashCode());
		result = prime * result + ((resourceDesc == null) ? 0 : resourceDesc.hashCode());
		result = prime * result + ((resourceHref == null) ? 0 : resourceHref.hashCode());
		result = prime * result + ((resourceId == null) ? 0 : resourceId.hashCode());
		result = prime * result + ((resourceImage == null) ? 0 : resourceImage.hashCode());
		result = prime * result + ((resourceName == null) ? 0 : resourceName.hashCode());
		result = prime * result + ((resourceRemark == null) ? 0 : resourceRemark.hashCode());
		result = prime * result + ((resourceType == null) ? 0 : resourceType.hashCode());
		result = prime * result + ((sortIndex == null) ? 0 : sortIndex.hashCode());
		result = prime * result + ((tempOne == null) ? 0 : tempOne.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
            return true;
        }
		if (obj == null) {
            return false;
        }
		if (getClass() != obj.getClass()) {
            return false;
        }
		SYSResource other = (SYSResource) obj;
		if (childList == null) {
			if (other.childList != null) {
                return false;
            }
		} else if (!childList.equals(other.childList)) {
            return false;
        }
		if (createTime == null) {
			if (other.createTime != null) {
                return false;
            }
		} else if (!createTime.equals(other.createTime)) {
            return false;
        }
		if (isActive == null) {
			if (other.isActive != null) {
                return false;
            }
		} else if (!isActive.equals(other.isActive)) {
            return false;
        }
		if (isLeaf == null) {
			if (other.isLeaf != null) {
                return false;
            }
		} else if (!isLeaf.equals(other.isLeaf)) {
            return false;
        }
		if (parent == null) {
			if (other.parent != null) {
                return false;
            }
		} else if (!parent.equals(other.parent)) {
            return false;
        }
		if (parentId == null) {
			if (other.parentId != null) {
                return false;
            }
		} else if (!parentId.equals(other.parentId)) {
            return false;
        }
		if (resourceDesc == null) {
			if (other.resourceDesc != null) {
                return false;
            }
		} else if (!resourceDesc.equals(other.resourceDesc)) {
            return false;
        }
		if (resourceHref == null) {
			if (other.resourceHref != null) {
                return false;
            }
		} else if (!resourceHref.equals(other.resourceHref)) {
            return false;
        }
		if (resourceId == null) {
			if (other.resourceId != null) {
                return false;
            }
		} else if (!resourceId.equals(other.resourceId)) {
            return false;
        }
		if (resourceImage == null) {
			if (other.resourceImage != null) {
                return false;
            }
		} else if (!resourceImage.equals(other.resourceImage)) {
            return false;
        }
		if (resourceName == null) {
			if (other.resourceName != null) {
                return false;
            }
		} else if (!resourceName.equals(other.resourceName)) {
            return false;
        }
		if (resourceRemark == null) {
			if (other.resourceRemark != null) {
                return false;
            }
		} else if (!resourceRemark.equals(other.resourceRemark)) {
            return false;
        }
		if (resourceType == null) {
			if (other.resourceType != null) {
                return false;
            }
		} else if (!resourceType.equals(other.resourceType)) {
            return false;
        }
		if (sortIndex == null) {
			if (other.sortIndex != null) {
                return false;
            }
		} else if (!sortIndex.equals(other.sortIndex)) {
            return false;
        }
		if (tempOne == null) {
			if (other.tempOne != null) {
                return false;
            }
		} else if (!tempOne.equals(other.tempOne)) {
            return false;
        }
		return true;
	}
	
	
}