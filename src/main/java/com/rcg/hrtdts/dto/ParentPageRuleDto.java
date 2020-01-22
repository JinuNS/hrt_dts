package com.rcg.hrtdts.dto;

import java.util.List;

public class ParentPageRuleDto {

	private Long pageId;

	private String key;

	private Long level;

	private String path;

	private String icon;

	private String label;

	private Boolean menu;
	
	private List<ChildPageRoleDto>childs;

	public Long getPageId() {
		return pageId;
	}

	public void setPageId(Long pageId) {
		this.pageId = pageId;
	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public Long getLevel() {
		return level;
	}

	public void setLevel(Long level) {
		this.level = level;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public String getIcon() {
		return icon;
	}

	public void setIcon(String icon) {
		this.icon = icon;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public Boolean getMenu() {
		return menu;
	}

	public void setMenu(Boolean menu) {
		this.menu = menu;
	}

	public List<ChildPageRoleDto> getChilds() {
		return childs;
	}

	public void setChilds(List<ChildPageRoleDto> childs) {
		this.childs = childs;
	}
	
	
	

}
