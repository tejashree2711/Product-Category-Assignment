package com.nimap_assignment.prod_cat.dto;


import com.nimap_assignment.prod_cat.model.Category;
import lombok.Data;

@Data
public class CategoryDto {
    private Integer cid;
    private String cname;
    private String cdescription;

    public CategoryDto() {
    }

    public CategoryDto(Integer cid, String cname, String cdescription) {
        this.cid = cid;
        this.cname = cname;
        this.cdescription = cdescription;
    }

    public Integer getCid() {
        return cid;
    }

    public void setCid(Integer cid) {
        this.cid = cid;
    }

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }

    public String getCdescription() {
        return cdescription;
    }

    public void setCdescription(String cdescription) {
        this.cdescription = cdescription;
    }

    public static CategoryDto fromCategory(Category category) {
        if (category == null) {
            return null;
        }
        return new CategoryDto(category.getCid(), category.getCname(), category.getCdescription());
    }
}
